package fixxy.comparison.comparer.implementations;

import static fixxy.comparison.ComparisonResultAcceptability.Acceptable;
import static fixxy.comparison.ComparisonResultAcceptability.Unacceptable;
import static fixxy.comparison.comparer.implementations.FixValueAsStringFieldComparerKotlinTest.AcceptingWithBothEqualButDistinctTestName;
import static fixxy.comparison.comparer.implementations.FixValueAsStringFieldComparerKotlinTest.JavaSuiteName;
import static fixxy.comparison.comparer.implementations.FixValueAsStringFieldComparerKotlinTest.RejectingWithLeftBlankAndRightNonBlankTestName;
import static fixxy.core.standard.StandardField.simpleField;
import static fixxy.core.standard.StandardFieldDefinition.simpleFieldDefinition;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import fixxy.comparison.comparer.FieldComparerResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(JavaSuiteName)
class FixValueAsStringFieldComparerJavaTest {

  @Test
  @DisplayName(AcceptingWithBothEqualButDistinctTestName)
  void testAcceptingWithBothEqualButDistinct() {
    final String left = new String("kjdasdu");
    final String right = new String("kjdasdu");
    assertNotSame(left, right);
    assertEquals(left, right);
    final FieldComparerResult result = FixValueAsStringFieldComparer.INSTANCE.compare(
        simpleField(simpleFieldDefinition(58, "Text"), left),
        simpleField(simpleFieldDefinition(58, "Text"), right));
    assertEquals(Acceptable, result.acceptability());
    assertEquals("OK", result.message());
  }

  @Test
  @DisplayName(RejectingWithLeftBlankAndRightNonBlankTestName)
  void testRejectingWithLeftBlankAndRightNonBlank() {
    final String left = "";
    final String right = "non_blank";
    assertNotEquals(left, right);
    final FieldComparerResult result = FixValueAsStringFieldComparer.INSTANCE.compare(
        simpleField(simpleFieldDefinition(58, "Text"), left),
        simpleField(simpleFieldDefinition(58, "Text"), right));
    assertEquals(Unacceptable, result.acceptability());
    assertEquals("Left [] and right [non_blank] are different", result.message());
  }
}
