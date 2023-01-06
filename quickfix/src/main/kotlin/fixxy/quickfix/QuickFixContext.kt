package fixxy.quickfix

import fixxy.core.Context
import fixxy.core.FieldDefinitionRepository

class QuickFixContext(quickFixVersion: QuickFixVersion) : Context {
  private val fieldDefinitions: FieldDefinitionRepository = QuickFixFieldDefinitionRepository(quickFixVersion)
  override fun fieldDefinitions(): FieldDefinitionRepository = fieldDefinitions
}