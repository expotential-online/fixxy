package fixxy.comparison.exceptions

import fixxy.comparison.Tests.Java
import fixxy.comparison.Tests.Kotlin
import fixxy.comparison.exceptions.FieldComparisonNotIncludedExceptionKotlinTest.Companion.KotlinSuiteName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class FieldComparisonNotIncludedExceptionKotlinTest {

  @Test
  @DisplayName(HasDescriptiveMessageTestName)
  fun testHasDescriptiveMessage() {
    assertEquals("Field comparison with tag [58] is not included", FieldComparisonNotIncludedException(58).message)
  }

  companion object {
    private const val SuiteName = "A 'field comparison not included' exception"
    const val KotlinSuiteName = "$Kotlin $SuiteName"
    const val JavaSuiteName = "$Java $SuiteName"

    const val HasDescriptiveMessageTestName = "has a descriptive message"
  }
}