package fixxy.diff.comparer

import fixxy.core.Field
import fixxy.diff.FieldComparisonResult

interface FieldComparer {
    fun compare(leftField: Field, rightField: Field): FieldComparisonResult
}