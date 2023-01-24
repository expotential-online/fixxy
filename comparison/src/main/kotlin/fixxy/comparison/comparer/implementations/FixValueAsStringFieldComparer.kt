package fixxy.comparison.comparer.implementations

import fixxy.comparison.comparer.FieldComparer
import fixxy.comparison.comparer.FieldComparerResult
import fixxy.comparison.comparer.standard.StandardFieldComparerResult.Companion.accepting
import fixxy.comparison.comparer.standard.StandardFieldComparerResult.Companion.rejectingWithMessage
import fixxy.core.Field

object FixValueAsStringFieldComparer : FieldComparer {
  // TODO: How can we avoid the INSTANCE in Java usage?
  override fun compare(leftField: Field, rightField: Field): FieldComparerResult =
    if (leftField.fixFieldValue() == rightField.fixFieldValue()) {
      accepting()
    } else {
      rejectingWithMessage(
        "Left [${leftField.fixFieldValue()}] and right [${rightField.fixFieldValue()}] are different"
      )
    }
}