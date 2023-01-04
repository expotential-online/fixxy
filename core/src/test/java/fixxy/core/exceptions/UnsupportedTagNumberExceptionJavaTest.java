package fixxy.core.exceptions;

import static fixxy.core.exceptions.UnsupportedTagNumberExceptionKotlinTest.JavaSuiteName;
import static fixxy.core.exceptions.UnsupportedTagNumberExceptionKotlinTest.MessageTestName;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(JavaSuiteName)
class UnsupportedTagNumberExceptionJavaTest {

  @Test
  @DisplayName(MessageTestName)
  public void testMessage() {
    final Exception exception = new UnsupportedTagNumberException(23);
    assertEquals("Tag [23] is unsupported", exception.getMessage());
  }
}
