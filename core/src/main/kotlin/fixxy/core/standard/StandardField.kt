package fixxy.core.standard

import fixxy.core.Field
import fixxy.core.FieldDefinition
import fixxy.core.FixFieldValue
import fixxy.core.IsGroup
import fixxy.core.MessagePart

@Suppress("DataClassPrivateConstructor")
data class StandardField private constructor(
    private val definition: FieldDefinition,
    override val fixFieldValue: FixFieldValue,
    override val parts: Set<MessagePart>
) : Field {
    override fun definition(): FieldDefinition = definition
    override fun isGroup(): IsGroup = parts.isNotEmpty()

  companion object {

    @JvmStatic
    fun simpleField(definition: FieldDefinition, fixFieldValue: FixFieldValue): Field =
      StandardField(definition, fixFieldValue, setOf())

    @JvmStatic
    fun groupCountField(definition: FieldDefinition, fixFieldValue: FixFieldValue, parts: Set<MessagePart>): Field =
      StandardField(definition, fixFieldValue, parts)

    @JvmStatic
    fun groupCountField(
      definition: FieldDefinition,
      fixFieldValue: FixFieldValue,
      vararg parts: MessagePart
    ): Field =
      StandardField(definition, fixFieldValue, parts.toSet())
  }
}