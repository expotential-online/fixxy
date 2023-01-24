package fixxy.comparison;

import static fixxy.comparison.FieldInclusionKotlinTest.AllDescriptionsAreCapitalisedTestName;
import static fixxy.comparison.FieldInclusionKotlinTest.JavaSuiteName;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(JavaSuiteName)
class FieldInclusionJavaTest {

  @Test
  @DisplayName(AllDescriptionsAreCapitalisedTestName)
  void testAllDescriptionsAreCapitalised() {
    for (final FieldInclusion fieldInclusion : FieldInclusion.values()) {
      assertTrue(Character.isUpperCase(fieldInclusion.description().charAt(0)));
    }
  }
}
