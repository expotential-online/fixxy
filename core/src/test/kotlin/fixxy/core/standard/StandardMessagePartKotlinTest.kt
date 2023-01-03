package fixxy.core.standard

import fixxy.core.Tests.Java
import fixxy.core.Tests.Kotlin
import fixxy.core.standard.StandardField.Companion.simpleField
import fixxy.core.standard.StandardFieldDefinition.Companion.simpleFieldDefinition
import fixxy.core.standard.StandardMessagePart.Companion.simpleMessagePart
import fixxy.core.standard.StandardMessagePartKotlinTest.Companion.KotlinSuiteName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class StandardMessagePartKotlinTest {

    @Test
    @DisplayName(ConstructFromSetOfFieldsTestName)
    fun testConstructFromSetOfFields() {
        val field1 = simpleField(simpleFieldDefinition(1, "Account"), "account_1")
        val field2 = simpleField(simpleFieldDefinition(54, "Side"), "2")
        val value = simpleMessagePart(setOf(field1, field2))
        assertEquals(setOf(field1, field2), value.fields)
    }

    @Test
    @DisplayName(ConstructFromVarArgFieldsTestName)
    fun testConstructFromVarArgFields() {
        val field1 = simpleField(simpleFieldDefinition(1, "Account"), "account_1")
        val field2 = simpleField(simpleFieldDefinition(54, "Side"), "2")
        val value = simpleMessagePart(field1, field2)
        assertEquals(setOf(field1, field2), value.fields)
    }

    @Test
    @DisplayName(DataClassTestName)
    fun testDataClass() {
        assertTrue(StandardMessagePart::class.isData)
    }

    companion object {
        private const val SuiteName = "A standard message part"
        const val KotlinSuiteName = "$Kotlin $SuiteName"
        const val JavaSuiteName = "$Java $SuiteName"

        const val ConstructFromSetOfFieldsTestName = "can be correctly constructed from a set of fields"
        const val ConstructFromVarArgFieldsTestName = "can be correctly constructed from vararg of fields"
        const val DataClassTestName = "is a data class"
    }
}