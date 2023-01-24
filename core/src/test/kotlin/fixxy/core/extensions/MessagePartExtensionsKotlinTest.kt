package fixxy.core.extensions

import fixxy.core.Tests.Java
import fixxy.core.Tests.Kotlin
import fixxy.core.extensions.MessagePartExtensions.tagNumbers
import fixxy.core.extensions.MessagePartExtensionsKotlinTest.Companion.KotlinSuiteName
import fixxy.core.standard.StandardField.Companion.simpleField
import fixxy.core.standard.StandardFieldDefinition.Companion.simpleFieldDefinition
import fixxy.core.standard.StandardMessagePart.Companion.simpleMessagePart
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class MessagePartExtensionsKotlinTest {

  @Test
  @DisplayName(TagNumberExtensionTestName)
  fun testTagNumbersExtension() {
    val messagePart = simpleMessagePart(
      simpleField(simpleFieldDefinition(58, "Text"), "Some text"),
      simpleField(simpleFieldDefinition(38, "Quantity"), "531"),
      simpleField(simpleFieldDefinition(58, "Text"), "Some other text")
    )
    assertEquals(setOf(38, 58), messagePart.tagNumbers())
  }

  companion object {
    private const val SuiteName = "Message parts"
    const val KotlinSuiteName = "$Kotlin $SuiteName"
    const val JavaSuiteName = "$Java $SuiteName"

    const val TagNumberExtensionTestName = "have a working tag numbers extension"
  }
}