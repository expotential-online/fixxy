package fixxy.quickfix

import fixxy.core.exceptions.UnsupportedTagNumberException
import fixxy.quickfix.QuickFixFieldDefinitionRepositoryKotlinTest.Companion.KotlinSuiteName
import fixxy.quickfix.QuickFixVersion.Fix42
import fixxy.quickfix.Tests.Java
import fixxy.quickfix.Tests.Kotlin
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class QuickFixFieldDefinitionRepositoryKotlinTest {

  @Test
  @DisplayName(UnsupportedTagNumberTestName)
  fun testUnsupportedTagNumber() {
    val repo = QuickFixFieldDefinitionRepository(Fix42)
    assertThrows(
      UnsupportedTagNumberException::class.java,
      { repo.fieldDefinitionOrThrowForTagNumber(Int.MAX_VALUE) },
      "Tag [2147483647] is unsupported"
    )
    assertNull(repo.fieldDefinitionOrNullForTagNumber(Int.MAX_VALUE))
  }

  companion object {
    private const val SuiteName = "A QuickFix field definition repository"
    const val KotlinSuiteName = "$Kotlin $SuiteName"
    const val JavaSuiteName = "$Java $SuiteName"

    const val UnsupportedTagNumberTestName = "throws an unsupported tag number exception or returns null as appropriate"
  }
}