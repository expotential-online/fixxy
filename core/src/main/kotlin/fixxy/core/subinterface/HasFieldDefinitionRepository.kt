package fixxy.core.subinterface

import fixxy.core.FieldDefinitionRepository

/**
 * Implementor has a repository of FIX field definitions
 */
interface HasFieldDefinitionRepository {

  /**
   * @return A FIX field definition
   */
  fun fieldDefinitions(): FieldDefinitionRepository
}