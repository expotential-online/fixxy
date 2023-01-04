package fixxy.diff.scratch.standard

import fixxy.core.Field
import fixxy.core.FieldDefinition
import fixxy.diff.scratch.FieldComparison

data class StandardFieldComparison(
    override val leftFieldOrNull: Field?,
    override val rightFieldOrNull: Field?
) : FieldComparison {

    // TODO: Resolve nasty null assumption
    override fun definition(): FieldDefinition = if (leftFieldOrNull != null)
        leftFieldOrNull.definition()
    else
        rightFieldOrNull!!.definition()

    override fun isInLeft(): Boolean = leftFieldOrNull != null

    override fun isInRight(): Boolean = rightFieldOrNull != null

    override fun isOnlyInLeft(): Boolean = isInLeft() && !isInRight()

    override fun isOnlyRight(): Boolean = isInRight() && !isInLeft()

    override fun isInBoth(): Boolean = isInLeft() && isInRight()
}