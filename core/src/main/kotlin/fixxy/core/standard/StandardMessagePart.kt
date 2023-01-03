package fixxy.core.standard

import fixxy.core.Field
import fixxy.core.MessagePart

@Suppress("DataClassPrivateConstructor")
data class StandardMessagePart private constructor(override val fields: Set<Field>) : MessagePart {

    companion object {

        @JvmStatic
        fun simpleMessagePart(fields: Set<Field>): MessagePart = StandardMessagePart(fields)

        @JvmStatic
        fun simpleMessagePart(vararg fields: Field): MessagePart = StandardMessagePart(fields.toSet())
    }
}