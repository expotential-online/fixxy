package fixxy.comparison.comparer

import fixxy.comparison.FieldComparerSelector
import fixxy.comparison.comparer.implementations.FixValueAsStringFieldComparer
import fixxy.core.FieldDefinition

object AlwaysFixValueAsStringFIeldComparerSelector : FieldComparerSelector {
  override fun comparerFor(fieldDefinition: FieldDefinition): FieldComparer = FixValueAsStringFieldComparer
}