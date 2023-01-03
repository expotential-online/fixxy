package fixxy.core.standard

import fixxy.core.*

@Suppress("DataClassPrivateConstructor")
data class StandardFieldDefinition private constructor(
    override val tagNumber: TagNumber,
    override val description: Description,
    override val synopsis: Synopsis,
    override val enumerableValues: Set<EnumerableFieldValue>
) : FieldDefinition {

    companion object {

        @JvmStatic
        fun simpleFieldDefinition(
            tagNumber: TagNumber,
            description: Description,
            synopsis: Synopsis
        ): FieldDefinition =
            StandardFieldDefinition(tagNumber, description, synopsis, setOf())

        @JvmStatic
        fun simpleFieldDefinition(
            tagNumber: TagNumber,
            description: Description
        ): FieldDefinition =
            StandardFieldDefinition(tagNumber, description, description, setOf())

        @JvmStatic
        fun enumeratedFieldDefinition(
            tagNumber: TagNumber,
            description: Description,
            synopsis: Synopsis,
            enumerableValues: Set<EnumerableFieldValue>
        ): FieldDefinition =
            StandardFieldDefinition(tagNumber, description, synopsis, enumerableValues)

        @JvmStatic
        fun enumeratedFieldDefinition(
            tagNumber: TagNumber,
            description: Description,
            enumerableValues: Set<EnumerableFieldValue>
        ): FieldDefinition =
            StandardFieldDefinition(tagNumber, description, description, enumerableValues)
    }
}
