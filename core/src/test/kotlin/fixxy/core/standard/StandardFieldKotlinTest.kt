package fixxy.core.standard

import fixxy.core.Tests.Java
import fixxy.core.Tests.Kotlin
import fixxy.core.standard.StandardField.Companion.groupCountField
import fixxy.core.standard.StandardField.Companion.simpleField
import fixxy.core.standard.StandardFieldDefinition.Companion.simpleFieldDefinition
import fixxy.core.standard.StandardFieldKotlinTest.Companion.KotlinSuiteName
import fixxy.core.standard.StandardMessagePart.Companion.simpleMessagePart
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class StandardFieldKotlinTest {

    @Test
    @DisplayName(ConstructSimpleFieldTestName)
    fun testConstructSimpleField() {
        val value = simpleField(simpleFieldDefinition(54, "Side"), "2")
        assertEquals(54, value.definition().tagNumber)
        assertEquals("Side", value.definition().description)
        assertEquals("2", value.fixFieldValue)
        assertFalse(value.isGroup())
        assertTrue(value.parts.isEmpty())
    }

    @Test
    @DisplayName(ConstructGroupCountFieldFromSetOfPartsTestName)
    fun testConstructGroupCountFieldFromSetOfParts() {
        val part1 = simpleMessagePart(
            simpleField(simpleFieldDefinition(1, "Account"), "account_1"),
            simpleField(simpleFieldDefinition(54, "Side"), "2")
        )
        val part2 = simpleMessagePart(
            simpleField(simpleFieldDefinition(1, "Account"), "account_2"),
            simpleField(simpleFieldDefinition(54, "Side"), "1")
        )
        val value = groupCountField(simpleFieldDefinition(2, "NoEntries"), "2", setOf(part1, part2))
        assertEquals(2, value.definition().tagNumber)
        assertEquals("NoEntries", value.definition().description)
        assertEquals("2", value.fixFieldValue)
        assertTrue(value.isGroup())
        assertEquals(setOf(part1, part2), value.parts)
    }

    @Test
    @DisplayName(ConstructGroupCountFieldFromVarArgPartsTestName)
    fun testConstructGroupCountFieldFromVarArgParts() {
        val part1 = simpleMessagePart(
            simpleField(simpleFieldDefinition(1, "Account"), "account_1"),
            simpleField(simpleFieldDefinition(54, "Side"), "2")
        )
        val part2 = simpleMessagePart(
            simpleField(simpleFieldDefinition(1, "Account"), "account_2"),
            simpleField(simpleFieldDefinition(54, "Side"), "1")
        )
        val value = groupCountField(simpleFieldDefinition(2, "NoEntries"), "2", part1, part2)
        assertEquals(2, value.definition().tagNumber)
        assertEquals("NoEntries", value.definition().description)
        assertEquals("2", value.fixFieldValue)
        assertTrue(value.isGroup())
        assertEquals(setOf(part1, part2), value.parts)
    }

  companion object {
    private const val SuiteName = "A standard field"
    const val KotlinSuiteName = "$Kotlin $SuiteName"
    const val JavaSuiteName = "$Java $SuiteName"

    const val ConstructSimpleFieldTestName = "can be correctly constructed for a simple field"
    const val ConstructGroupCountFieldFromSetOfPartsTestName =
      "can be correctly constructed from a set of parts for a group count field"
    const val ConstructGroupCountFieldFromVarArgPartsTestName =
      "can be correctly constructed from vararg parts for a group count field"
  }
}