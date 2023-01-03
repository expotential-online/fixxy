package fixxy.core

import fixxy.core.AbstractFieldDefinitionRepositoryKotlinTest.Companion.KotlinSuiteName
import fixxy.core.Tests.Java
import fixxy.core.Tests.Kotlin
import fixxy.core.exceptions.UnsupportedTagNumberException
import fixxy.core.standard.StandardFieldDefinition.Companion.simpleFieldDefinition
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class AbstractFieldDefinitionRepositoryKotlinTest {

    @Test
    @DisplayName(NullOrThrowingTestName)
    fun testNullOrThrowing() {
        val repo = TestFieldDefinitionRepository(true)
        assertThrows(UnsupportedTagNumberException::class.java) { repo.fieldDefinitionOrThrowForTagNumber(54) }
        assertNull(repo.fieldDefinitionOrNullForTagNumber(54))
    }

    @Test
    @DisplayName(NotNullAndNotThrowingTestName)
    fun testNotNullAndNotThrowing() {
        val repo = TestFieldDefinitionRepository(false)
        assertEquals(54, repo.fieldDefinitionOrThrowForTagNumber(54).tagNumber)
        assertEquals(54, repo.fieldDefinitionOrNullForTagNumber(54)?.tagNumber)
    }

    private class TestFieldDefinitionRepository(private val throwing: Boolean) : AbstractFieldDefinitionRepository() {
        override fun fieldDefinitionOrThrowForTagNumber(tagNumber: TagNumber): FieldDefinition =
            if (throwing)
                throw UnsupportedTagNumberException(tagNumber)
            else
                simpleFieldDefinition(tagNumber, "Field [$tagNumber]")
    }

    companion object {
        private const val SuiteName = "An abstract field definition repository"
        const val KotlinSuiteName = "$Kotlin $SuiteName"
        const val JavaSuiteName = "$Java $SuiteName"

        const val NullOrThrowingTestName = "gives null or throws when applicable"
        const val NotNullAndNotThrowingTestName = "gives non-null and does not throw when applicable"
    }
}