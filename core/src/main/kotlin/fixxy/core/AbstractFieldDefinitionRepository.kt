package fixxy.core

import fixxy.core.exceptions.UnsupportedTagNumberException

abstract class AbstractFieldDefinitionRepository : FieldDefinitionRepository {
  final override fun fieldDefinitionOrNullForTagNumber(tagNumber: TagNumber): FieldDefinition? = try {
    fieldDefinitionOrThrowForTagNumber(tagNumber)
  } catch (e: UnsupportedTagNumberException) {
    null
  }
}