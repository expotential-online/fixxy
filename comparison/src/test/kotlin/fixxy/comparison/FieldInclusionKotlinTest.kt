package fixxy.comparison

import fixxy.comparison.FieldInclusionKotlinTest.Companion.KotlinSuiteName
import fixxy.comparison.Tests.Java
import fixxy.comparison.Tests.Kotlin
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class FieldInclusionKotlinTest {

  @Test
  @DisplayName(AllDescriptionsAreCapitalisedTestName)
  fun testAllDescriptionsAreCapitalised() {
    FieldInclusion.values().forEach { assertTrue(it.description()[0].isUpperCase()) }
  }

  companion object {
    private const val SuiteName = "Field inclusions"
    const val KotlinSuiteName = "$Kotlin $SuiteName"
    const val JavaSuiteName = "$Java $SuiteName"

    const val AllDescriptionsAreCapitalisedTestName = "all have capitalised first letter"
  }
}