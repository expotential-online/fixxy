package fixxy.core.standard

import fixxy.core.Field
import fixxy.core.Message
import fixxy.core.TagNumber
import fixxy.core.standard.StandardMessagePart.Companion.simpleMessagePart

@Suppress("DataClassPrivateConstructor")
data class StandardMessage private constructor(private val fields: Set<Field>) : Message {

  private val delegate = simpleMessagePart(fields)
  override fun fields(): Set<Field> = delegate.fields()
  override fun fieldOrNullForTagNumber(tagNumber: TagNumber): Field? = delegate.fieldOrNullForTagNumber(tagNumber)
  override fun fieldOrThrowForTagNumber(tagNumber: TagNumber): Field = delegate.fieldOrThrowForTagNumber(tagNumber)

  companion object {

    @JvmStatic
    fun simpleMessage(fields: Set<Field>): Message = StandardMessage(fields)

    @JvmStatic
    fun simpleMessage(vararg fields: Field): Message = StandardMessage(fields.toSet())
  }
}
