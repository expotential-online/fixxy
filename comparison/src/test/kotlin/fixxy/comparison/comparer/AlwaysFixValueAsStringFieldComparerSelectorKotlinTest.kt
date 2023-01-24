package fixxy.comparison.comparer

import fixxy.comparison.Tests.Java
import fixxy.comparison.Tests.Kotlin
import fixxy.comparison.comparer.AlwaysFixValueAsStringFieldComparerSelectorKotlinTest.Companion.KotlinSuiteName
import fixxy.comparison.comparer.implementations.FixValueAsStringFieldComparer
import fixxy.core.standard.StandardFieldDefinition.Companion.simpleFieldDefinition
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class AlwaysFixValueAsStringFieldComparerSelectorKotlinTest {

  @Test
  @DisplayName(AlwaysReturnsFixValueAsStringCompararerTestName)
  fun testAlwaysReturnsFixValueAsStringCompararer() {
    assertTrue(
      AlwaysFixValueAsStringFieldComparerSelector.comparerFor(
        simpleFieldDefinition(58, "Text")
      ) is FixValueAsStringFieldComparer
    )
    assertTrue(
      AlwaysFixValueAsStringFieldComparerSelector.comparerFor(
        simpleFieldDefinition(44, "Price")
      ) is FixValueAsStringFieldComparer
    )
  }

  companion object {
    private const val SuiteName = "An 'always FIX value as string' field comparer selector"
    const val KotlinSuiteName = "$Kotlin $SuiteName"
    const val JavaSuiteName = "$Java $SuiteName"

    const val AlwaysReturnsFixValueAsStringCompararerTestName =
      "always selects a 'FIX value as string' field compararer"
  }
}