package fixxy.comparison.subinterface

import fixxy.comparison.FieldComparison
import fixxy.comparison.exceptions.FieldComparisonNotIncludedException
import fixxy.core.TagNumber

interface HasFieldComparisonOrThrowForTagNumber {
  @Throws(FieldComparisonNotIncludedException::class)
  fun fieldComparisonOrThrowForTagNumber(tagNumber: TagNumber): FieldComparison
}