package fixxy.comparison.subinterface

import fixxy.comparison.FieldComparison
import fixxy.core.TagNumber

interface HasFieldComparisonOrNullForTagNumber {
  fun fieldComparisonOrNullForTagNumber(tagNumber: TagNumber): FieldComparison?
}