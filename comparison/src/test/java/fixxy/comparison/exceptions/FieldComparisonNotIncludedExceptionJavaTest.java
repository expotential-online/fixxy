package fixxy.comparison.exceptions;

import static fixxy.comparison.exceptions.FieldComparisonNotIncludedExceptionKotlinTest.HasDescriptiveMessageTestName;
import static fixxy.comparison.exceptions.FieldComparisonNotIncludedExceptionKotlinTest.JavaSuiteName;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(JavaSuiteName)
class FieldComparisonNotIncludedExceptionJavaTest {

  @Test
  @DisplayName(HasDescriptiveMessageTestName)
  void testHasDescriptiveMessage() {
    assertEquals(
        "Field comparison with tag [58] is not included",
        new FieldComparisonNotIncludedException(58).getMessage());
  }
}
