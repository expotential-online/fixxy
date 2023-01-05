package fixxy.comparison

import fixxy.comparison.ComparisonResultAcceptability.Acceptable
import fixxy.comparison.ComparisonResultAcceptability.Unacceptable
import fixxy.comparison.ComparisonResultCategory.Different
import fixxy.comparison.ComparisonResultCategory.DifferentButAccepted
import fixxy.comparison.ComparisonResultCategory.ExactlyTheSame
import fixxy.comparison.ComparisonResultCategoryKotlinTest.Companion.KotlinSuiteName
import fixxy.comparison.Tests.Java
import fixxy.comparison.Tests.Kotlin
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class ComparisonResultCategoryKotlinTest {

  @Test
  @DisplayName(AcceptabilityTestName)
  fun testAcceptability() {
    val categories = ComparisonResultCategory.values().toSet()
    assertEquals(expectedAcceptabilityByCategory.keys, categories)
    categories.forEach { assertEquals(expectedAcceptabilityByCategory[it], it.acceptability) }
  }

  companion object {
    private const val SuiteName = "A comparison result category"
    const val KotlinSuiteName = "$Kotlin $SuiteName"
    const val JavaSuiteName = "$Java $SuiteName"

    const val AcceptabilityTestName = "has the right acceptability"

    private val expectedAcceptabilityByCategory = mapOf(
      ExactlyTheSame to Acceptable,
      DifferentButAccepted to Acceptable,
      Different to Unacceptable
    )
  }
}