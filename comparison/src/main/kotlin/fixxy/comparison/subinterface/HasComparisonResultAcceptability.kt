package fixxy.comparison.subinterface

import fixxy.comparison.ComparisonResultAcceptability

interface HasComparisonResultAcceptability {
  fun acceptability(): ComparisonResultAcceptability
}