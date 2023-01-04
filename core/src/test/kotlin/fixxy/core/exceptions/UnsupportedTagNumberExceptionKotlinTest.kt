package fixxy.core.exceptions

import fixxy.core.Tests.Java
import fixxy.core.Tests.Kotlin
import fixxy.core.exceptions.UnsupportedTagNumberExceptionKotlinTest.Companion.KotlinSuiteName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class UnsupportedTagNumberExceptionKotlinTest {

  @Test
  @DisplayName(MessageTestName)
  fun testMessage() {
    val exception = UnsupportedTagNumberException(23)
    assertEquals("Tag [23] is unsupported", exception.message)
  }

  companion object {
    private const val SuiteName = "An unsupported tag number exception"
    const val KotlinSuiteName = "$Kotlin $SuiteName"
    const val JavaSuiteName = "$Java $SuiteName"

    const val MessageTestName = "has the expected message"
  }
}