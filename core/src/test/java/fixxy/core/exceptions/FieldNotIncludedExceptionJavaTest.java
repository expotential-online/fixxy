package fixxy.core.exceptions;

import static fixxy.core.exceptions.FieldNotIncludedExceptionKotlinTest.JavaSuiteName;
import static fixxy.core.exceptions.FieldNotIncludedExceptionKotlinTest.MessageTestName;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(JavaSuiteName)
class FieldNotIncludedExceptionJavaTest {

  @Test
  @DisplayName(MessageTestName)
  void testMessage() {
    assertEquals("Field with tag [44] is not included", new FieldNotIncludedException(44).getMessage());
  }
}
