package fixxy.comparison.comparer

import fixxy.core.Field
import fixxy.comparison.FieldComparisonResult

interface FieldComparer {
  fun compare(leftField: Field, rightField: Field): FieldComparisonResult
}