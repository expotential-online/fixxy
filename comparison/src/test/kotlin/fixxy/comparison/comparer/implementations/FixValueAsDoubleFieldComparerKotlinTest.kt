package fixxy.comparison.comparer.implementations

import fixxy.core.standard.StandardField.Companion.simpleField
import fixxy.core.standard.StandardFieldDefinition.Companion.simpleFieldDefinition
import fixxy.comparison.ComparisonResultAcceptability.Acceptable
import fixxy.comparison.ComparisonResultAcceptability.Unacceptable
import fixxy.comparison.Tests.Java
import fixxy.comparison.Tests.Kotlin
import fixxy.comparison.comparer.implementations.FixValueAsDoubleFieldComparerKotlinTest.Companion.KotlinSuiteName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class FixValueAsDoubleFieldComparerKotlinTest {

  @Test
  @DisplayName(AcceptingWithJustDecimalPlaceDifferenceTestName)
  fun testAcceptingWithJustDecimalPlaceDifference() {
    val result = FixValueAsDoubleFieldComparer.withAllowedDifference(1E-6).compare(
      simpleField(simpleFieldDefinition(44, "Price"), "187.00"),
      simpleField(simpleFieldDefinition(44, "Price"), "187")
    )
    assertEquals(Acceptable, result.acceptability())
    assertEquals("OK", result.message())
  }

  @Test
  @DisplayName(AcceptingWithinToleranceTestName)
  fun testAcceptingWithinTolerance() {
    val result = FixValueAsDoubleFieldComparer.withAllowedDifference(0.05).compare(
      simpleField(simpleFieldDefinition(44, "Price"), "187.04"),
      simpleField(simpleFieldDefinition(44, "Price"), "187")
    )
    assertEquals(Acceptable, result.acceptability())
    assertEquals("OK", result.message())
  }

  @Test
  @DisplayName(RejectingOutsideToleranceTestName)
  fun testRejectingOutsideTolerance() {
    val result = FixValueAsDoubleFieldComparer.withAllowedDifference(0.05).compare(
      simpleField(simpleFieldDefinition(44, "Price"), "187"),
      simpleField(simpleFieldDefinition(44, "Price"), "187.06")
    )
    assertEquals(Unacceptable, result.acceptability())
    assertEquals("Left [187] and right [187.06] are not within tolerance of [0.05]", result.message())
  }

  @Test
  @DisplayName(RejectingWhenOnlyLeftNonDoubleTestName)
  fun testRejectingWhenOnlyLeftNonDouble() {
    val result = FixValueAsDoubleFieldComparer.withAllowedDifference(0.05).compare(
      simpleField(simpleFieldDefinition(44, "Price"), "not_a_double"),
      simpleField(simpleFieldDefinition(44, "Price"), "187.06")
    )
    assertEquals(Unacceptable, result.acceptability())
    assertEquals("Left [not_a_double] and right [187.06] are not both doubles", result.message())
  }

  @Test
  @DisplayName(RejectingWhenOnlyRightNonDoubleTestName)
  fun testRejectingWhenOnlyRightNonDouble() {
    val result = FixValueAsDoubleFieldComparer.withAllowedDifference(0.05).compare(
      simpleField(simpleFieldDefinition(44, "Price"), "187"),
      simpleField(simpleFieldDefinition(44, "Price"), "not_a_double")
    )
    assertEquals(Unacceptable, result.acceptability())
    assertEquals("Left [187] and right [not_a_double] are not both doubles", result.message())
  }

  @Test
  @DisplayName(RejectingWhenBothNonDoubleTestName)
  fun testRejectingWhenBothNonDouble() {
    val result = FixValueAsDoubleFieldComparer.withAllowedDifference(0.05).compare(
      simpleField(simpleFieldDefinition(44, "Price"), "not_a_double"),
      simpleField(simpleFieldDefinition(44, "Price"), "not_a_double_either")
    )
    assertEquals(Unacceptable, result.acceptability())
    assertEquals("Left [not_a_double] and right [not_a_double_either] are not both doubles", result.message())
  }

  companion object {
    private const val SuiteName = "A 'FIX value as double' field comparer"
    const val KotlinSuiteName = "$Kotlin $SuiteName"
    const val JavaSuiteName = "$Java $SuiteName"

    const val AcceptingWithJustDecimalPlaceDifferenceTestName = "accepts just a difference in decimal places"
    const val AcceptingWithinToleranceTestName = "accepts within tolerance"
    const val RejectingOutsideToleranceTestName = "rejects outside tolerance"
    const val RejectingWhenOnlyLeftNonDoubleTestName = "rejects when left only is non-double"
    const val RejectingWhenOnlyRightNonDoubleTestName = "rejects when right only is non-double"
    const val RejectingWhenBothNonDoubleTestName = "rejects when both left and right are non-double"
  }
}