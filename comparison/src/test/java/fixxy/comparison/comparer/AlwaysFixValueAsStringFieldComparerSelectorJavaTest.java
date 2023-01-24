package fixxy.comparison.comparer;

import fixxy.comparison.comparer.implementations.FixValueAsStringFieldComparer;
import fixxy.core.standard.StandardFieldDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fixxy.comparison.comparer.AlwaysFixValueAsStringFieldComparerSelectorKotlinTest.AlwaysReturnsFixValueAsStringCompararerTestName;
import static fixxy.comparison.comparer.AlwaysFixValueAsStringFieldComparerSelectorKotlinTest.JavaSuiteName;
import static fixxy.core.standard.StandardFieldDefinition.simpleFieldDefinition;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName(JavaSuiteName)
class AlwaysFixValueAsStringFieldComparerSelectorJavaTest {

  @Test
  @DisplayName(AlwaysReturnsFixValueAsStringCompararerTestName)
  void testAlwaysReturnsFixValueAsStringCompararer() {
    assertTrue(
        AlwaysFixValueAsStringFieldComparerSelector.INSTANCE.comparerFor(
            simpleFieldDefinition(58, "Text"))
            instanceof FixValueAsStringFieldComparer
    );
    assertTrue(
        AlwaysFixValueAsStringFieldComparerSelector.INSTANCE.comparerFor(
            simpleFieldDefinition(44, "Price"))
            instanceof FixValueAsStringFieldComparer
    );
  }
}
