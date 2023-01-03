package fixxy.core.standard

import fixxy.core.Field
import fixxy.core.Message

@Suppress("DataClassPrivateConstructor")
data class StandardMessage private constructor(override val fields: Set<Field>) : Message {

    companion object {

        @JvmStatic
        fun simpleMessage(fields: Set<Field>): Message = StandardMessage(fields)

        @JvmStatic
        fun simpleMessage(vararg fields: Field): Message = StandardMessage(fields.toSet())
    }
}
