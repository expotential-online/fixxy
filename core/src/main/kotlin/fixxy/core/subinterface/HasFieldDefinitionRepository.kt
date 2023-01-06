package fixxy.core.subinterface

import fixxy.core.FieldDefinitionRepository

interface HasFieldDefinitionRepository {
  fun fieldDefinitions(): FieldDefinitionRepository
}