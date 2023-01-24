package fixxy.comparison.comparer.implementations

import fixxy.comparison.ComparisonResultAcceptability.Acceptable
import fixxy.comparison.ComparisonResultAcceptability.Unacceptable
import fixxy.comparison.Tests.Java
import fixxy.comparison.Tests.Kotlin
import fixxy.comparison.comparer.implementations.FixValueAsStringFieldComparerKotlinTest.Companion.KotlinSuiteName
import fixxy.core.standard.StandardField.Companion.simpleField
import fixxy.core.standard.StandardFieldDefinition.Companion.simpleFieldDefinition
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class FixValueAsStringFieldComparerKotlinTest {

  @Test
  @DisplayName(AcceptingWithBothEqualButDistinctTestName)
  fun testAcceptingWithBothEqualButDistinct() {
    val left = java.lang.String("kjdasdu").toString()
    val right = java.lang.String("kjdasdu").toString()
    assertNotSame(left, right)
    assertEquals(left, right)
    val result = FixValueAsStringFieldComparer.compare(
      simpleField(simpleFieldDefinition(58, "Text"), left),
      simpleField(simpleFieldDefinition(58, "Text"), right)
    )
    assertEquals(Acceptable, result.acceptability())
    assertEquals("OK", result.message())
  }

  @Test
  @DisplayName(RejectingWithLeftBlankAndRightNonBlankTestName)
  fun testRejectingWithLeftBlankAndRightNonBlank() {
    val left = ""
    val right = "non_blank"
    assertNotEquals(left, right)
    val result = FixValueAsStringFieldComparer.compare(
      simpleField(simpleFieldDefinition(58, "Text"), left),
      simpleField(simpleFieldDefinition(58, "Text"), right)
    )
    assertEquals(Unacceptable, result.acceptability())
    assertEquals("Left [] and right [non_blank] are different", result.message())
  }

  companion object {
    private const val SuiteName = "A 'FIX value as string' field comparer"
    const val KotlinSuiteName = "$Kotlin $SuiteName"
    const val JavaSuiteName = "$Java $SuiteName"

    const val AcceptingWithBothEqualButDistinctTestName =
      "accepts strings which represent the same text but are different objects in memory"
    const val RejectingWithLeftBlankAndRightNonBlankTestName =
      "rejects a blank string on the left and a non-blank string on the right"
  }
}