package fixxy.quickfix;

import static fixxy.quickfix.QuickFixFieldDefinitionRepositoryKotlinTest.JavaSuiteName;
import static fixxy.quickfix.QuickFixFieldDefinitionRepositoryKotlinTest.UnsupportedTagNumberTestName;
import static fixxy.quickfix.QuickFixVersion.Fix42;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import fixxy.core.exceptions.UnsupportedTagNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(JavaSuiteName)
class QuickFixFieldDefinitionRepositoryJavaTest {

  @Test
  @DisplayName(UnsupportedTagNumberTestName)
  void testUnsupportedTagNumber() {
    QuickFixFieldDefinitionRepository repo = new QuickFixFieldDefinitionRepository(Fix42);
    assertThrows(
        UnsupportedTagNumberException.class,
        () -> repo.fieldDefinitionOrThrowForTagNumber(Integer.MAX_VALUE),
        "Tag [2147483647] is unsupported");
    assertNull(repo.fieldDefinitionOrNullForTagNumber(Integer.MAX_VALUE));
  }
}
