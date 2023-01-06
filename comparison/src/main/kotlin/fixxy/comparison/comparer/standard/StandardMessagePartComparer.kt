package fixxy.comparison.comparer.standard

import fixxy.comparison.FieldComparerSelector
import fixxy.comparison.FieldComparison
import fixxy.comparison.MessagePartComparison
import fixxy.comparison.comparer.MessagePartComparer
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
    throw UnsupportedOperationException()
  }

  companion object {

    @JvmStatic
    fun withFieldComparerSelector(fieldComparerSelector: FieldComparerSelector): MessagePartComparer =
      StandardMessagePartComparer(fieldComparerSelector)
  }
}