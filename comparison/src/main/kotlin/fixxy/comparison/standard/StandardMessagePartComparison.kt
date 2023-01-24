package fixxy.comparison.standard

import fixxy.comparison.FieldComparison
import fixxy.comparison.MessagePartComparison
import fixxy.comparison.exceptions.FieldComparisonNotIncludedException
import fixxy.core.TagNumber

@Suppress("DataClassPrivateConstructor")
// TODO: Extract commonality between fields and comparisons
data class StandardMessagePartComparison private constructor(private val fieldComparisons: Set<FieldComparison>) :
  MessagePartComparison {

  private val fieldComparisonsByTagNumber = fieldComparisons.associateBy { it.fieldDefinition().tagNumber() }

  override fun fieldComparisons(): Set<FieldComparison> = fieldComparisons

  override fun fieldComparisonOrNullForTagNumber(tagNumber: TagNumber): FieldComparison? =
    fieldComparisonsByTagNumber[tagNumber]

  override fun fieldComparisonOrThrowForTagNumber(tagNumber: TagNumber): FieldComparison =
    fieldComparisonsByTagNumber.getOrElse(tagNumber) { throw FieldComparisonNotIncludedException(tagNumber) }

  companion object {

    @JvmStatic
    fun simpleMessagePartComparison(fieldComparisons: Set<FieldComparison>): MessagePartComparison =
      StandardMessagePartComparison(fieldComparisons)

    @JvmStatic
    fun simpleMessagePartComparison(vararg fieldComparisons: FieldComparison): MessagePartComparison =
      StandardMessagePartComparison(fieldComparisons.toSet())
  }
}