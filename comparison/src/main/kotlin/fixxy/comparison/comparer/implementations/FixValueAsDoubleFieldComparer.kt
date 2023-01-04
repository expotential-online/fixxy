package fixxy.comparison.comparer.implementations

import com.google.common.math.DoubleMath.fuzzyEquals
import fixxy.core.Field
import fixxy.comparison.FieldComparisonResult
import fixxy.comparison.comparer.FieldComparer
import fixxy.comparison.standard.StandardFieldComparisonResult.Companion.accepting
import fixxy.comparison.standard.StandardFieldComparisonResult.Companion.rejectingWithMessage

class FixValueAsDoubleFieldComparer private constructor(private val allowedDifference: Double) : FieldComparer {

  override fun compare(leftField: Field, rightField: Field): FieldComparisonResult {

    val leftDoubleOrNull = leftField.fixFieldValue.toDoubleOrNull()
    val rightDoubleOrNull = rightField.fixFieldValue.toDoubleOrNull()

    return if (leftDoubleOrNull != null && rightDoubleOrNull != null) {
      if (fuzzyEquals(leftDoubleOrNull, rightDoubleOrNull, allowedDifference)) {
        accepting()
      } else {
        rejectingWithMessage(
          "Left [${leftField.fixFieldValue}] and right [${rightField.fixFieldValue}] are not within tolerance of [$allowedDifference]"
        )
      }
    } else {
      rejectingWithMessage(
        "Left [${leftField.fixFieldValue}] and right [${rightField.fixFieldValue}] are not both doubles"
      )
    }
  }

  companion object {

    @JvmStatic
    fun withAllowedDifference(allowedDifference: Double): FieldComparer =
      FixValueAsDoubleFieldComparer(allowedDifference)
  }
}