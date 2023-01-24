package fixxy.comparison.standard

import fixxy.comparison.ComparisonResultAcceptability
import fixxy.comparison.ComparisonResultAcceptability.Acceptable
import fixxy.comparison.ComparisonResultAcceptability.Unacceptable
import fixxy.comparison.ComparisonResultCategory
import fixxy.comparison.ComparisonResultCategory.Different
import fixxy.comparison.ComparisonResultCategory.DifferentButAccepted
import fixxy.comparison.ComparisonResultCategory.OnlyInOne
import fixxy.comparison.ComparisonResultMessage
import fixxy.comparison.FieldComparison
import fixxy.comparison.FieldInclusion
import fixxy.comparison.FieldInclusion.OnlyInLeft
import fixxy.comparison.FieldInclusion.OnlyInRight
import fixxy.comparison.MessagePartComparison
import fixxy.comparison.comparer.FieldComparerResult
import fixxy.core.Field
import fixxy.core.FieldDefinition

data class StandardFieldComparison(
  private val fieldDefinition: FieldDefinition,
  private val category: ComparisonResultCategory,
  private val message: ComparisonResultMessage,
  private val parts: Set<MessagePartComparison>
) : FieldComparison {

  override fun fieldDefinition(): FieldDefinition = fieldDefinition
  override fun category(): ComparisonResultCategory = category
  override fun message(): ComparisonResultMessage = message
  override fun parts(): Set<MessagePartComparison> = parts

  companion object {

    @JvmStatic
    fun forFieldOnlyInLeft(field: Field): FieldComparison = forFieldOnlyInOne(field, OnlyInLeft)

    @JvmStatic
    fun forFieldOnlyInRight(field: Field): FieldComparison = forFieldOnlyInOne(field, OnlyInRight)

    @JvmStatic
    fun forResult(fieldDefinition: FieldDefinition, comparerResult: FieldComparerResult): FieldComparison =
      StandardFieldComparison(
        fieldDefinition,
        categoryForAcceptability(comparerResult.acceptability()),
        comparerResult.message(),
        setOf()
      )

    private fun forFieldOnlyInOne(field: Field, fieldInclusion: FieldInclusion): FieldComparison =
      StandardFieldComparison(
        field.fieldDefinition(),
        OnlyInOne,
        "${fieldInclusion.description()} with value [${field.fixFieldValue()}]",
        setOf()
      )

    // TODO: Reconsider the modeling here
    private fun categoryForAcceptability(acceptability: ComparisonResultAcceptability): ComparisonResultCategory =
      when (acceptability) {
        Acceptable -> DifferentButAccepted
        Unacceptable -> Different
      }
  }
}
