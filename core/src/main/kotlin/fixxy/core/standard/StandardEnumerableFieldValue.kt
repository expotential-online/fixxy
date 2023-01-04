package fixxy.core.standard

import fixxy.core.Description
import fixxy.core.EnumerableFieldValue
import fixxy.core.FixFieldValue

@Suppress("DataClassPrivateConstructor")
data class StandardEnumerableFieldValue private constructor(
  override val description: Description,
  override val fixFieldValue: FixFieldValue
) : EnumerableFieldValue {

  companion object {

    @JvmStatic
    fun simpleEnumerableFieldValue(description: Description, fixFieldValue: FixFieldValue): EnumerableFieldValue =
      StandardEnumerableFieldValue(description, fixFieldValue)
  }
}
