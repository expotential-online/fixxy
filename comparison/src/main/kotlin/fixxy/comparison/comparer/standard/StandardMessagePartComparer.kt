package fixxy.comparison.comparer.standard

import fixxy.comparison.FieldComparerSelector
import fixxy.comparison.FieldComparison
import fixxy.comparison.MessagePartComparison
import fixxy.comparison.comparer.MessagePartComparer
import fixxy.comparison.standard.StandardFieldComparison
import fixxy.core.Field
import fixxy.core.MessagePart
import fixxy.core.TagNumber
import fixxy.core.extensions.MessagePartExtensions.tagNumbers
import java.lang.UnsupportedOperationException

class StandardMessagePartComparer private constructor(private val fieldComparerSelector: FieldComparerSelector) :
  MessagePartComparer {

  override fun compare(leftPart: MessagePart, rightPart: MessagePart): MessagePartComparison {
    val leftTagNumbers = leftPart.tagNumbers()
    val rightTagNumbers = rightPart.tagNumbers()
    val allTagNumbers = leftTagNumbers.union(rightTagNumbers)
    throw UnsupportedOperationException()
    //return allTagNumbers.map { compare(it, leftPart, rightPart) }.toSet()
  }

  private fun compare(tagNumber: TagNumber, leftPart: MessagePart, rightPart: MessagePart): FieldComparison {
    val leftFieldOrNull = leftPart.fieldOrNullForTagNumber(tagNumber)
    val rightFieldOrNull = rightPart.fieldOrNullForTagNumber(tagNumber)
    return if (leftFieldOrNull != null) {
      if (rightFieldOrNull != null) {
        // In both left and right
        compare(leftFieldOrNull, rightFieldOrNull)
      } else {
        // In left but not right
        StandardFieldComparison.forFieldOnlyInLeft(leftFieldOrNull)
      }
    } else {
      if (rightFieldOrNull != null) {
        // In right but not left
        StandardFieldComparison.forFieldOnlyInRight(rightFieldOrNull)
      } else {
        // In neither left nor right
        // TODO: Think this through. It should never happen
        throw UnsupportedOperationException()
      }
    }
  }

  private fun compare(leftField: Field, rightField: Field): FieldComparison {
    val comparer = fieldComparerSelector.comparerFor(leftField.fieldDefinition())
    val result = comparer.compare(leftField, rightField)
    return StandardFieldComparison.forResult(leftField.fieldDefinition(), result)
  }

  companion object {

    @JvmStatic
    fun withFieldComparerSelector(fieldComparerSelector: FieldComparerSelector): MessagePartComparer =
      StandardMessagePartComparer(fieldComparerSelector)
  }
}