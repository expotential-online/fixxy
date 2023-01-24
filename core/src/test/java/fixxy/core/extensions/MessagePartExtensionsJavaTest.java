package fixxy.core.extensions;

import static fixxy.core.extensions.MessagePartExtensionsKotlinTest.JavaSuiteName;
import static fixxy.core.extensions.MessagePartExtensionsKotlinTest.TagNumberExtensionTestName;
import static fixxy.core.standard.StandardField.simpleField;
import static fixxy.core.standard.StandardFieldDefinition.simpleFieldDefinition;
import static fixxy.core.standard.StandardMessagePart.simpleMessagePart;
import static org.junit.jupiter.api.Assertions.assertEquals;

import fixxy.core.MessagePart;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(JavaSuiteName)
class MessagePartExtensionsJavaTest {

  @Test
  @DisplayName(TagNumberExtensionTestName)
  void testTagNumbersExtension() {
    final MessagePart messagePart = simpleMessagePart(
        simpleField(simpleFieldDefinition(58, "Text"), "Some text"),
        simpleField(simpleFieldDefinition(38, "Quantity"), "531"),
        simpleField(simpleFieldDefinition(58, "Text"), "Some other text"));
    assertEquals(Set.of(38, 58), MessagePartExtensions.tagNumbers(messagePart));
  }
}
