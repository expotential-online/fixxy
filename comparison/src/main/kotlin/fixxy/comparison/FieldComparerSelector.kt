package fixxy.comparison

import fixxy.comparison.comparer.FieldComparer
import fixxy.core.FieldDefinition

interface FieldComparerSelector {
  fun comparerFor(fieldDefinition: FieldDefinition): FieldComparer
}