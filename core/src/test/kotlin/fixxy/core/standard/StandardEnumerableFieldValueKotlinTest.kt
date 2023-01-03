package fixxy.core.standard

import fixxy.core.Tests.Java
import fixxy.core.Tests.Kotlin
import fixxy.core.standard.StandardEnumerableFieldValue.Companion.simpleEnumerableFieldValue
import fixxy.core.standard.StandardEnumerableFieldValueKotlinTest.Companion.KotlinSuiteName
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class StandardEnumerableFieldValueKotlinTest {

    @Test
    @DisplayName(ConstructWithDescriptionAndFixFieldValueTestName)
    fun testConstructWithDescriptionAndFixFieldValue() {
        val value = simpleEnumerableFieldValue("some_description", "Z")
        assertEquals("some_description", value.description)
        assertEquals("Z", value.fixFieldValue)
    }

    @Test
    @DisplayName(DataClassTestName)
    fun testDataClass() {
        assertTrue(StandardEnumerableFieldValue::class.isData)
    }

    companion object {
        private const val SuiteName = "A standard enumerable field value"
        const val KotlinSuiteName = "$Kotlin $SuiteName"
        const val JavaSuiteName = "$Java $SuiteName"

        const val ConstructWithDescriptionAndFixFieldValueTestName = "can be correctly constructed with a description and FIX field value"
        const val DataClassTestName = "is a data class"
    }
}