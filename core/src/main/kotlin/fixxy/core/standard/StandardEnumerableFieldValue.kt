package fixxy.core.standard

import fixxy.core.Description
import fixxy.core.EnumerableFieldValue
import fixxy.core.FixFieldValue

@Suppress("DataClassPrivateConstructor")
data class StandardEnumerableFieldValue private constructor(
  private val description: Description,
  private val fixFieldValue: FixFieldValue
) : EnumerableFieldValue {

  override fun description(): Description = description
  override fun fixFieldValue(): FixFieldValue = fixFieldValue

  companion object {

    @JvmStatic
    fun simpleEnumerableFieldValue(description: Description, fixFieldValue: FixFieldValue): EnumerableFieldValue =
      StandardEnumerableFieldValue(description, fixFieldValue)
  }
}
