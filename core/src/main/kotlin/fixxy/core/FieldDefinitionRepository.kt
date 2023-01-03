package fixxy.core

import fixxy.core.exceptions.UnsupportedTagNumberException

interface FieldDefinitionRepository {

    fun fieldDefinitionOrNullForTagNumber(tagNumber: TagNumber): FieldDefinition?

    @Throws(UnsupportedTagNumberException::class)
    fun fieldDefinitionOrThrowForTagNumber(tagNumber: TagNumber): FieldDefinition
}