package fixxy.quickfix

import fixxy.quickfix.QuickFixVersion.Fix42
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class QuickFixFieldDefinitionRepositoryTest {

  @Test
  fun testUnsupportedTagNumber() {

    val repo = QuickFixFieldDefinitionRepository(Fix42)

    assertThrows(
      IllegalArgumentException::class.java,
      { repo.fieldDefinitionOrThrowForTagNumber(Int.MAX_VALUE) },
      "Tag [2147483647] is unsupported"
    )

    assertNull(repo.fieldDefinitionOrNullForTagNumber(Int.MAX_VALUE))
  }
}