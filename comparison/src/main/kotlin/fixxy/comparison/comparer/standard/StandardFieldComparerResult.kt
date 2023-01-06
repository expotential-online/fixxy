package fixxy.comparison.comparer.standard

import fixxy.comparison.ComparisonResultAcceptability
import fixxy.comparison.ComparisonResultAcceptability.Acceptable
import fixxy.comparison.ComparisonResultAcceptability.Unacceptable
import fixxy.comparison.ComparisonResultMessage
import fixxy.comparison.comparer.FieldComparerResult

@Suppress("DataClassPrivateConstructor")
data class StandardFieldComparerResult private constructor(
  private val acceptability: ComparisonResultAcceptability,
  private val message: ComparisonResultMessage
) : FieldComparerResult {

  override fun acceptability(): ComparisonResultAcceptability = acceptability
  override fun message(): ComparisonResultMessage = message

  companion object {

    @JvmStatic
    fun accepting(): FieldComparerResult = StandardFieldComparerResult(Acceptable, "OK")

    @JvmStatic
    fun rejectingWithMessage(message: ComparisonResultMessage): FieldComparerResult =
      StandardFieldComparerResult(Unacceptable, message)
  }
}
