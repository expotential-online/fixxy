package fixxy.quickfix

import com.google.common.base.CaseFormat.UPPER_CAMEL
import com.google.common.base.CaseFormat.UPPER_UNDERSCORE
import fixxy.core.EnumerableFieldValue
import fixxy.core.standard.StandardEnumerableFieldValue.Companion.simpleEnumerableFieldValue
import quickfix.field.MsgType
import kotlin.reflect.KClass
import kotlin.reflect.KProperty0
import kotlin.reflect.KVisibility.PUBLIC
import kotlin.reflect.full.staticProperties

object QuickFixEnumeratedFieldValueHelper {

  private val ignoredClassFieldNames = setOf("serialVersionUID", "FIELD")
  private val quickFixFieldsPackageName = MsgType::class.java.packageName

  @JvmStatic
  fun enumeratedFieldValuesForFieldName(fieldName: String): Set<EnumerableFieldValue> {
    val quickFixFieldClass = quickFixFieldClassForFieldName(fieldName)
    val quickFixFieldClassConstants = quickFixFieldClassConstants(quickFixFieldClass)
    return quickFixFieldClassConstants.map { simpleEnumerableFieldValue(format(it.name), it.get().toString()) }
      .toSet()
  }

  private fun quickFixFieldClassForFieldName(fieldName: String): KClass<*> =
    Class.forName("${quickFixFieldsPackageName}.${fieldName}").kotlin

  private fun quickFixFieldClassConstants(fieldClass: KClass<*>) =
    fieldClass.staticProperties.filter { inScope(it) }

  private fun inScope(property: KProperty0<*>): Boolean =
    property.isFinal && isPublic(property) && shouldNotBeIgnored(property)

  private fun isPublic(property: KProperty0<*>): Boolean =
    property.visibility == PUBLIC

  private fun shouldNotBeIgnored(property: KProperty0<*>): Boolean =
    !ignoredClassFieldNames.contains(property.name)

  private fun format(quickFixFieldClassConstantName: String): String =
    UPPER_UNDERSCORE.to(UPPER_CAMEL, quickFixFieldClassConstantName)
}