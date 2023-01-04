package fixxy.diff

import fixxy.diff.ComparisonResultAcceptability.Acceptable
import fixxy.diff.ComparisonResultAcceptability.Unacceptable

enum class ComparisonResultCategory(val acceptability: ComparisonResultAcceptability) {
    ExactlyTheSame(Acceptable),
    DifferentButAccepted(Acceptable),
    Different(Unacceptable)
}