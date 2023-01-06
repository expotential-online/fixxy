package fixxy.comparison.comparer

import fixxy.core.Field

interface FieldComparer {
  fun compare(leftField: Field, rightField: Field): FieldComparerResult
}