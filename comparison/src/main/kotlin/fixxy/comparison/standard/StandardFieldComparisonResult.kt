package fixxy.diff.standard

import fixxy.diff.ComparisonResultAcceptability
import fixxy.diff.ComparisonResultAcceptability.Acceptable
import fixxy.diff.ComparisonResultAcceptability.Unacceptable
import fixxy.diff.ComparisonResultMessage
import fixxy.diff.FieldComparisonResult

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
