package fixxy.core.standard

import fixxy.core.Tests.Java
import fixxy.core.Tests.Kotlin
import fixxy.core.standard.StandardEnumerableFieldValue.Companion.simpleEnumerableFieldValue
import fixxy.core.standard.StandardFieldDefinition.Companion.enumeratedFieldDefinition
import fixxy.core.standard.StandardFieldDefinition.Companion.simpleFieldDefinition
import fixxy.core.standard.StandardFieldDefinitionKotlinTest.Companion.KotlinSuiteName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class StandardFieldDefinitionKotlinTest {

  @Test
  @DisplayName(ConstructFromTagNumberAndDescriptionAndSynopsisTestName)
  fun testConstructFromTagNumberAndDescriptionAndSynopsis() {
    val value = simpleFieldDefinition(1, "Account", "An account")
    assertEquals(1, value.tagNumber)
    assertEquals("Account", value.description)
    assertEquals("An account", value.synopsis)
    assertTrue(value.enumerableValues.isEmpty())
  }

  @Test
  @DisplayName(ConstructFromTagNumberAndDescriptionTestName)
  fun testConstructFromTagNumberAndDescription() {
    val value = simpleFieldDefinition(1, "Account")
    assertEquals(1, value.tagNumber)
    assertEquals("Account", value.description)
    assertEquals("Account", value.synopsis)
    assertTrue(value.enumerableValues.isEmpty())
  }

  @Test
  @DisplayName(ConstructFromTagNumberAndDescriptionAndSynopsisAndEnumerableValuesTestName)
  fun testConstructFromTagNumberAndDescriptionAndSynopsisAndEnumerableValues() {
    val fieldValue1 = simpleEnumerableFieldValue("account_1", "X")
    val fieldValue2 = simpleEnumerableFieldValue("account_2", "Y")
    val value = enumeratedFieldDefinition(1, "Account", "An account", setOf(fieldValue1, fieldValue2))
    assertEquals(1, value.tagNumber)
    assertEquals("Account", value.description)
    assertEquals("An account", value.synopsis)
    assertEquals(setOf(fieldValue1, fieldValue2), value.enumerableValues)
  }

  @Test
  @DisplayName(ConstructFromTagNumberAndDescriptionAndEnumerableValuesTestName)
  fun testConstructFromTagNumberAndDescriptionAndEnumerableValues() {
    val fieldValue1 = simpleEnumerableFieldValue("account_1", "X")
    val fieldValue2 = simpleEnumerableFieldValue("account_2", "Y")
    val value = enumeratedFieldDefinition(1, "Account", setOf(fieldValue1, fieldValue2))
    assertEquals(1, value.tagNumber)
    assertEquals("Account", value.description)
    assertEquals("Account", value.synopsis)
    assertEquals(setOf(fieldValue1, fieldValue2), value.enumerableValues)
  }


  @Test
  @DisplayName(DataClassTestName)
  fun testDataClass() {
    assertTrue(StandardFieldDefinition::class.isData)
  }

  companion object {
    private const val SuiteName = "A standard field definition"
    const val KotlinSuiteName = "$Kotlin $SuiteName"
    const val JavaSuiteName = "$Java $SuiteName"

    const val ConstructFromTagNumberAndDescriptionAndSynopsisTestName =
      "can be correctly constructed from a tag number, description and synopsis"
    const val ConstructFromTagNumberAndDescriptionTestName =
      "can be correctly constructed from a tag number, description and synopsis"
    const val ConstructFromTagNumberAndDescriptionAndSynopsisAndEnumerableValuesTestName =
      "can be correctly constructed from a tag number, description, synopsis and enumerable values"
    const val ConstructFromTagNumberAndDescriptionAndEnumerableValuesTestName =
      "can be correctly constructed from a tag number, description and enumerable values"
    const val DataClassTestName = "is a data class"
  }
}