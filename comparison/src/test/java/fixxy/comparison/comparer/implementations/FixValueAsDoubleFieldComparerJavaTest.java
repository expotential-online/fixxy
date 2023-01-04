package fixxy.comparison.comparer.implementations;

import static fixxy.core.standard.StandardField.simpleField;
import static fixxy.core.standard.StandardFieldDefinition.simpleFieldDefinition;
import static fixxy.comparison.ComparisonResultAcceptability.Acceptable;
import static fixxy.comparison.ComparisonResultAcceptability.Unacceptable;
import static fixxy.comparison.comparer.implementations.FixValueAsDoubleFieldComparerKotlinTest.AcceptingWithJustDecimalPlaceDifferenceTestName;
import static fixxy.comparison.comparer.implementations.FixValueAsDoubleFieldComparerKotlinTest.AcceptingWithinToleranceTestName;
import static fixxy.comparison.comparer.implementations.FixValueAsDoubleFieldComparerKotlinTest.JavaSuiteName;
import static fixxy.comparison.comparer.implementations.FixValueAsDoubleFieldComparerKotlinTest.RejectingOutsideToleranceTestName;
import static fixxy.comparison.comparer.implementations.FixValueAsDoubleFieldComparerKotlinTest.RejectingWhenBothNonDoubleTestName;
import static fixxy.comparison.comparer.implementations.FixValueAsDoubleFieldComparerKotlinTest.RejectingWhenOnlyLeftNonDoubleTestName;
import static fixxy.comparison.comparer.implementations.FixValueAsDoubleFieldComparerKotlinTest.RejectingWhenOnlyRightNonDoubleTestName;
import static org.junit.jupiter.api.Assertions.assertEquals;

import fixxy.comparison.FieldComparisonResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(JavaSuiteName)
class FixValueAsDoubleFieldComparerJavaTest {

  @Test
  @DisplayName(AcceptingWithJustDecimalPlaceDifferenceTestName)
  void testAcceptingWithJustDecimalPlaceDifference() {
    final FieldComparisonResult result = FixValueAsDoubleFieldComparer.withAllowedDifference(1E-6).compare(
        simpleField(simpleFieldDefinition(44, "Price"), "187.00"),
        simpleField(simpleFieldDefinition(44, "Price"), "187"));
    assertEquals(Acceptable, result.acceptability());
    assertEquals("OK", result.message());
  }

  @Test
  @DisplayName(AcceptingWithinToleranceTestName)
  void testAcceptingWithinTolerance() {
    final FieldComparisonResult result = FixValueAsDoubleFieldComparer.withAllowedDifference(0.05).compare(
        simpleField(simpleFieldDefinition(44, "Price"), "187.04"),
        simpleField(simpleFieldDefinition(44, "Price"), "187"));
    assertEquals(Acceptable, result.acceptability());
    assertEquals("OK", result.message());
  }

  @Test
  @DisplayName(RejectingOutsideToleranceTestName)
  void testRejectingOutsideTolerance() {
    final FieldComparisonResult result = FixValueAsDoubleFieldComparer.withAllowedDifference(0.05).compare(
        simpleField(simpleFieldDefinition(44, "Price"), "187"),
        simpleField(simpleFieldDefinition(44, "Price"), "187.06"));
    assertEquals(Unacceptable, result.acceptability());
    assertEquals("Left [187] and right [187.06] are not within tolerance of [0.05]", result.message());
  }

  @Test
  @DisplayName(RejectingWhenOnlyLeftNonDoubleTestName)
  void testRejectingWhenOnlyLeftNonDouble() {
    final FieldComparisonResult result = FixValueAsDoubleFieldComparer.withAllowedDifference(0.05).compare(
        simpleField(simpleFieldDefinition(44, "Price"), "not_a_double"),
        simpleField(simpleFieldDefinition(44, "Price"), "187.06"));
    assertEquals(Unacceptable, result.acceptability());
    assertEquals("Left [not_a_double] and right [187.06] are not both doubles", result.message());
  }

  @Test
  @DisplayName(RejectingWhenOnlyRightNonDoubleTestName)
  void testRejectingWhenOnlyRightNonDouble() {
    final FieldComparisonResult result = FixValueAsDoubleFieldComparer.withAllowedDifference(0.05).compare(
        simpleField(simpleFieldDefinition(44, "Price"), "187"),
        simpleField(simpleFieldDefinition(44, "Price"), "not_a_double"));
    assertEquals(Unacceptable, result.acceptability());
    assertEquals("Left [187] and right [not_a_double] are not both doubles", result.message());
  }

  @Test
  @DisplayName(RejectingWhenBothNonDoubleTestName)
  void testRejectingWhenBothNonDouble() {
    final FieldComparisonResult result = FixValueAsDoubleFieldComparer.withAllowedDifference(0.05).compare(
        simpleField(simpleFieldDefinition(44, "Price"), "not_a_double"),
        simpleField(simpleFieldDefinition(44, "Price"), "not_a_double_either"));
    assertEquals(Unacceptable, result.acceptability());
    assertEquals("Left [not_a_double] and right [not_a_double_either] are not both doubles", result.message());
  }
}
