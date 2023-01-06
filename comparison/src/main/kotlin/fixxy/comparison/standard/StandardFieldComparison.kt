package fixxy.comparison.standard

import fixxy.comparison.ComparisonResultCategory
import fixxy.comparison.ComparisonResultCategory.OnlyInOne
import fixxy.comparison.ComparisonResultMessage
import fixxy.comparison.FieldComparison
import fixxy.comparison.MessagePartComparison
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
    fun forFieldInLeftOnly(field: Field): FieldComparison =
      StandardFieldComparison(
        field.fieldDefinition(),
        OnlyInOne,
        "Only in left with value [${field.fixFieldValue()}]",
        setOf()
      )
  }
}
