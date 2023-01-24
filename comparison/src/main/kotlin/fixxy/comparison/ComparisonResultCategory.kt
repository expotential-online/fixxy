package fixxy.comparison

import fixxy.comparison.ComparisonResultAcceptability.Acceptable
import fixxy.comparison.ComparisonResultAcceptability.Unacceptable

enum class ComparisonResultCategory(val acceptability: ComparisonResultAcceptability) {
  ExactlyTheSame(Acceptable),
  DifferentButAccepted(Acceptable),
  Different(Unacceptable),
  OnlyInOne(Unacceptable)
}