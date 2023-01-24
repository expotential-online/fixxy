package fixxy.core

import fixxy.core.exceptions.UnsupportedTagNumberException

// TODO: Extract to sub-interfaces
interface FieldDefinitionRepository {

  fun fieldDefinitionOrNullForTagNumber(tagNumber: TagNumber): FieldDefinition?

  @Throws(UnsupportedTagNumberException::class)
  fun fieldDefinitionOrThrowForTagNumber(tagNumber: TagNumber): FieldDefinition
}