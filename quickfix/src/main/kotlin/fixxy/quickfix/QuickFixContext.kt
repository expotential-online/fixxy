package fixxy.quickfix

import fixxy.core.Context
import fixxy.core.FieldDefinitionRepository

class QuickFixContext(quickFixVersion: QuickFixVersion) : Context {
  override val fieldDefinitions: FieldDefinitionRepository =
    QuickFixFieldDefinitionRepository(quickFixVersion)
}