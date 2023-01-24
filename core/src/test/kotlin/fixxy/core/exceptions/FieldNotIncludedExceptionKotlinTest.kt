package fixxy.core.exceptions

import fixxy.core.Tests.Java
import fixxy.core.Tests.Kotlin
import fixxy.core.exceptions.FieldNotIncludedExceptionKotlinTest.Companion.KotlinSuiteName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class FieldNotIncludedExceptionKotlinTest {

  @Test
  @DisplayName(MessageTestName)
  fun testMessage() {
    assertEquals("Field with tag [44] is not included", FieldNotIncludedException(44).message)
  }

  companion object {
    private const val SuiteName = "A field not included exception"
    const val KotlinSuiteName = "$Kotlin $SuiteName"
    const val JavaSuiteName = "$Java $SuiteName"

    const val MessageTestName = "has a descriptive message"
  }
}