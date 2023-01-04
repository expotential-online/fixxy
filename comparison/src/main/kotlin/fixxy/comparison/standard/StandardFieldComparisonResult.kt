package fixxy.comparison.standard

import fixxy.comparison.ComparisonResultAcceptability
import fixxy.comparison.ComparisonResultAcceptability.Acceptable
import fixxy.comparison.ComparisonResultAcceptability.Unacceptable
import fixxy.comparison.ComparisonResultMessage
import fixxy.comparison.FieldComparisonResult

@Suppress("DataClassPrivateConstructor")
data class StandardFieldComparisonResult private constructor(
  private val acceptability: ComparisonResultAcceptability,
  private val message: ComparisonResultMessage
) : FieldComparisonResult {

  override fun acceptability(): ComparisonResultAcceptability = acceptability
  override fun message(): ComparisonResultMessage = message

  companion object {

    @JvmStatic
    fun accepting(): FieldComparisonResult = StandardFieldComparisonResult(Acceptable, "OK")

    @JvmStatic
    fun rejectingWithMessage(message: ComparisonResultMessage): FieldComparisonResult =
      StandardFieldComparisonResult(Unacceptable, message)
  }
}
