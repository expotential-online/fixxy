package fixxy.core

abstract class AbstractFieldDefinitionRepository : FieldDefinitionRepository {
    final override fun fieldDefinitionOrNullForTagNumber(tagNumber: TagNumber): FieldDefinition? = try {
        fieldDefinitionOrThrowForTagNumber(tagNumber)
    } catch (e: Exception) {
        null
    }
}