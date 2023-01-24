package fixxy.core.standard

import fixxy.core.Field
import fixxy.core.MessagePart
import fixxy.core.TagNumber
import fixxy.core.exceptions.FieldNotIncludedException

@Suppress("DataClassPrivateConstructor")
data class StandardMessagePart private constructor(private val fields: Set<Field>) : MessagePart {

  private val fieldsByTagNumber = fields.associateBy { it.fieldDefinition().tagNumber() }

  override fun fields(): Set<Field> = fields

  override fun fieldOrNullForTagNumber(tagNumber: TagNumber): Field? = fieldsByTagNumber[tagNumber]

  override fun fieldOrThrowForTagNumber(tagNumber: TagNumber): Field =
    fieldsByTagNumber.getOrElse(tagNumber) { throw FieldNotIncludedException(tagNumber) }

  companion object {

    @JvmStatic
    fun simpleMessagePart(fields: Set<Field>): MessagePart = StandardMessagePart(fields)

    @JvmStatic
    fun simpleMessagePart(vararg fields: Field): MessagePart = StandardMessagePart(fields.toSet())
  }
}