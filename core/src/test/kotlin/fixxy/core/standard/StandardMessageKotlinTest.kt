package fixxy.core.standard

import fixxy.core.Tests
import fixxy.core.standard.StandardField.Companion.simpleField
import fixxy.core.standard.StandardFieldDefinition.Companion.simpleFieldDefinition
import fixxy.core.standard.StandardMessage.Companion.simpleMessage
import fixxy.core.standard.StandardMessageKotlinTest.Companion.KotlinSuiteName
import org.junit.jupiter.api.Assertions.assertEquals
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
  @DisplayName(DataClassTestName)
  fun testDataClass() {
    assertTrue(StandardMessage::class.isData)
  }

  companion object {
    private const val SuiteName = "A standard part"
    const val KotlinSuiteName = "${Tests.Kotlin} $SuiteName"
    const val JavaSuiteName = "${Tests.Java} $SuiteName"

    const val ConstructFromSetOfFieldsTestName = "can be correctly constructed from a set of fields"
    const val ConstructFromVarArgFieldsTestName = "can be correctly constructed from vararg of fields"
    const val DataClassTestName = "is a data class"
  }
}