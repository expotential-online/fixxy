package fixxy.quickfix

import fixxy.core.EnumerableFieldValue
import fixxy.core.TagNumber
import fixxy.quickfix.QuickFixEnumeratedFieldValueHelper.enumeratedFieldValuesForFieldName
import fixxy.quickfix.QuickFixEnumeratedFieldValueHelper.inScope
import fixxy.quickfix.QuickFixEnumeratedFieldValueHelperJavaTest.ScopingTester
import fixxy.quickfix.QuickFixEnumeratedFieldValueHelperKotlinTest.Companion.KotlinSuiteName
import fixxy.quickfix.QuickFixVersion.Fix40
import fixxy.quickfix.QuickFixVersion.Fix41
import fixxy.quickfix.QuickFixVersion.Fix42
import fixxy.quickfix.QuickFixVersion.Fix43
import fixxy.quickfix.QuickFixVersion.Fix44
import fixxy.quickfix.QuickFixVersion.Fix50
import fixxy.quickfix.QuickFixVersion.Fix50sp1
import fixxy.quickfix.QuickFixVersion.Fix50sp2
import fixxy.quickfix.Tests.Java
import fixxy.quickfix.Tests.Kotlin
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.platform.commons.logging.LoggerFactory.getLogger
import quickfix.DataDictionary
import quickfix.DefaultDataDictionaryProvider
import kotlin.reflect.KProperty0
import kotlin.reflect.full.staticProperties

@DisplayName(KotlinSuiteName)
internal class QuickFixEnumeratedFieldValueHelperKotlinTest {

  private val logger = getLogger(javaClass)

  @Test
  @DisplayName("[ FIX 4.0 ] $AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix")
  fun testAllQuickFixFieldsWithEnumeratedFieldValues_Fix_4_0() {
    testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(Fix40)
  }

  @Test
  @DisplayName("[ FIX 4.1 ] $AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix")
  fun testAllQuickFixFieldsWithEnumeratedFieldValues_Fix_4_1() {
    testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(Fix41)
  }

  @Test
  @DisplayName("[ FIX 4.2 ] $AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix")
  fun testAllQuickFixFieldsWithEnumeratedFieldValues_Fix_4_2() {
    testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(Fix42)
  }

  @Test
  @DisplayName("[ FIX 4.3 ] $AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix")
  fun testAllQuickFixFieldsWithEnumeratedFieldValues_Fix_4_3() {
    testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(Fix43)
  }

  @Test
  @DisplayName("[ FIX 4.4 ] $AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix")
  fun testAllQuickFixFieldsWithEnumeratedFieldValues_Fix_4_4() {
    testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(Fix44)
  }

  @Test
  @DisplayName("[ FIX 5.0 ] $AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix")
  fun testAllQuickFixFieldsWithEnumeratedFieldValues_Fix_5_0() {
    testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(Fix50)
  }

  @Test
  @DisplayName("[ FIX 5.0 sp1 ] $AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix")
  fun testAllQuickFixFieldsWithEnumeratedFieldValues_Fix_5_0_sp_1() {
    testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(Fix50sp1)
  }

  @Test
  @DisplayName("[ FIX 5.0 sp2 ] $AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix")
  fun testAllQuickFixFieldsWithEnumeratedFieldValues_Fix_5_0_sp_2() {
    testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(Fix50sp2)
  }

  @Test
  @DisplayName(InScopePropertyTestName)
  fun testInScopeProperty() {
    assertFalse(inScope(scopingTesterProperty("nonConstant")))
    assertFalse(inScope(scopingTesterProperty("nonPublic")))
    assertFalse(inScope(scopingTesterProperty("serialVersionUID")))
    assertFalse(inScope(scopingTesterProperty("FIELD")))
    assertTrue(inScope(scopingTesterProperty("candidate")))
  }

  private fun testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(quickFixVersion: QuickFixVersion) {
    val dictionary = dictionaryForVersion(quickFixVersion)
    val fieldsWithEnumeratedFieldValues = fieldsWithEnumeratedFieldValues(dictionary)
    val summaries = fieldsWithEnumeratedFieldValues.map { testQuickFixFieldWithEnumeratedValues(it) }
    logger.info { "Found [${summaries.count()}] FIX fields with enumerated values. Details follow..." }
    summaries.forEach { logger.info { it } }
  }

  private fun dictionaryForVersion(quickFixVersion: QuickFixVersion): DataDictionary =
    DefaultDataDictionaryProvider().getApplicationDataDictionary(quickFixVersion.applVerID())

  private fun fieldsWithEnumeratedFieldValues(dictionary: DataDictionary): List<Field> =
    dictionary.orderedFields
      .filter { dictionary.hasFieldValue(it) }
      .map { Field(it, dictionary.getFieldName(it)) }
      .toList()

  private fun testQuickFixFieldWithEnumeratedValues(field: Field): String {
    val values = enumeratedFieldValuesForFieldName(field.name)
    return summary(field, values)
  }

  private fun summary(field: Field, enumerableFieldValues: Set<EnumerableFieldValue>): String {
    val longestFixFieldValue = enumerableFieldValues.maxOfOrNull { it.fixFieldValue().length } ?: 1
    val summary = StringBuilder(
      "FIX field [${field.tagNumber}] with name [${field.name}] has enumerated values:\n\n"
    )
    enumerableFieldValues.forEach {
      val paddedFixFieldValue = it.fixFieldValue().padEnd(longestFixFieldValue, ' ')
      summary.append(" - $paddedFixFieldValue | ${it.description()}\n")
    }
    return summary.toString()
  }

  private fun scopingTesterProperty(propertyName: String): KProperty0<*> =
    ScopingTester::class.staticProperties.first { it.name == propertyName }

  private data class Field(val tagNumber: TagNumber, val name: String)

  companion object {
    private const val SuiteName = "The QuickFix enumerated field value helper"
    const val KotlinSuiteName = "$Kotlin $SuiteName"
    const val JavaSuiteName = "$Java $SuiteName"

    const val AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix =
      "correctly processes All QuickFix fields with enumerated values for this FIX version"
    const val InScopePropertyTestName =
      "correctly determines whether a class property is a candidate for an enumerated field value"
  }
}