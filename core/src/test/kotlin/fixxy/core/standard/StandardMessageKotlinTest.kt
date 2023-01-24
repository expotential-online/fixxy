package fixxy.core.standard

import fixxy.core.Tests
import fixxy.core.exceptions.FieldNotIncludedException
import fixxy.core.standard.StandardField.Companion.simpleField
import fixxy.core.standard.StandardFieldDefinition.Companion.simpleFieldDefinition
import fixxy.core.standard.StandardMessage.Companion.simpleMessage
import fixxy.core.standard.StandardMessageKotlinTest.Companion.KotlinSuiteName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class StandardMessageKotlinTest {

  @Test
  @DisplayName(ConstructFromSetOfFieldsTestName)
  fun testConstructFromSetOfFields() {
    val field1 = simpleField(simpleFieldDefinition(1, "Account"), "account_1")
    val field2 = simpleField(simpleFieldDefinition(54, "Side"), "2")
    val value = simpleMessage(setOf(field1, field2))
    assertEquals(setOf(field1, field2), value.fields())
  }

  @Test
  @DisplayName(ConstructFromVarArgFieldsTestName)
  fun testConstructFromVarArgFields() {
    val field1 = simpleField(simpleFieldDefinition(1, "Account"), "account_2")
    val field2 = simpleField(simpleFieldDefinition(54, "Side"), "1")
    val value = simpleMessage(field1, field2)
    assertEquals(setOf(field1, field2), value.fields())
  }

  @Test
  @DisplayName(FieldOrNullForTagNumberTestName)
  fun testFieldOrNullForTagNumber() {
    val field1 = simpleField(simpleFieldDefinition(1, "Account"), "account_2")
    val field2 = simpleField(simpleFieldDefinition(54, "Side"), "1")
    val value = simpleMessage(field1, field2)
    assertEquals(field1, value.fieldOrNullForTagNumber(1))
    assertEquals(field2, value.fieldOrNullForTagNumber(54))
    assertNull(value.fieldOrNullForTagNumber(58))
  }

  @Test
  @DisplayName(FieldOrThrowForTagNumberTestName)
  fun testFieldOrThrowForTagNumber() {
    val field1 = simpleField(simpleFieldDefinition(1, "Account"), "account_2")
    val field2 = simpleField(simpleFieldDefinition(54, "Side"), "1")
    val value = simpleMessage(field1, field2)
    assertEquals(field1, value.fieldOrNullForTagNumber(1))
    assertEquals(field2, value.fieldOrNullForTagNumber(54))
    assertThrows(
      FieldNotIncludedException::class.java,
      { value.fieldOrThrowForTagNumber(58) },
      "Field with tag [58] is not included"
    )
  }

  @Test
  @DisplayName(DataClassTestName)
  fun testDataClass() {
    assertTrue(StandardMessage::class.isData)
  }

  companion object {
    private const val SuiteName = "A standard message"
    const val KotlinSuiteName = "${Tests.Kotlin} $SuiteName"
    const val JavaSuiteName = "${Tests.Java} $SuiteName"

    const val ConstructFromSetOfFieldsTestName = "can be correctly constructed from a set of fields"
    const val ConstructFromVarArgFieldsTestName = "can be correctly constructed from vararg of fields"
    const val FieldOrNullForTagNumberTestName = "returns the field for a tag or null if that tag is not present"
    const val FieldOrThrowForTagNumberTestName = "returns the field for a tag or throws if that tag is not present"
    private const val DataClassTestName = "is a data class"
  }
}