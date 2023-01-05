package fixxy.comparison;

import static fixxy.comparison.ComparisonResultAcceptability.Acceptable;
import static fixxy.comparison.ComparisonResultAcceptability.Unacceptable;
import static fixxy.comparison.ComparisonResultCategory.Different;
import static fixxy.comparison.ComparisonResultCategory.DifferentButAccepted;
import static fixxy.comparison.ComparisonResultCategory.ExactlyTheSame;
import static fixxy.comparison.ComparisonResultCategory.values;
import static fixxy.comparison.ComparisonResultCategoryKotlinTest.AcceptabilityTestName;
import static fixxy.comparison.ComparisonResultCategoryKotlinTest.JavaSuiteName;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(JavaSuiteName)
class ComparisonResultCategoryJavaTest {

  @Test
  @DisplayName(AcceptabilityTestName)
  void testAcceptability() {
    final Set<ComparisonResultCategory> categories = stream(values()).collect(toSet());
    assertEquals(expectedAcceptabilityByCategory.keySet(), categories);
    categories.forEach(it -> assertEquals(expectedAcceptabilityByCategory.get(it), it.getAcceptability()));
  }

  private static final Map<ComparisonResultCategory, ComparisonResultAcceptability> expectedAcceptabilityByCategory;

  static {
    expectedAcceptabilityByCategory = new EnumMap<>(ComparisonResultCategory.class);
    expectedAcceptabilityByCategory.put(ExactlyTheSame, Acceptable);
    expectedAcceptabilityByCategory.put(DifferentButAccepted, Acceptable);
    expectedAcceptabilityByCategory.put(Different, Unacceptable);
  }
}
