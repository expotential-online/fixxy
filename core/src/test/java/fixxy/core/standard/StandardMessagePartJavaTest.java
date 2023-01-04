package fixxy.core.standard;

import static fixxy.core.standard.StandardField.simpleField;
import static fixxy.core.standard.StandardFieldDefinition.simpleFieldDefinition;
import static fixxy.core.standard.StandardMessagePart.simpleMessagePart;
import static fixxy.core.standard.StandardMessagePartKotlinTest.ConstructFromSetOfFieldsTestName;
import static fixxy.core.standard.StandardMessagePartKotlinTest.ConstructFromVarArgFieldsTestName;
import static fixxy.core.standard.StandardMessagePartKotlinTest.JavaSuiteName;
import static org.junit.jupiter.api.Assertions.assertEquals;

import fixxy.core.Field;
import fixxy.core.MessagePart;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(JavaSuiteName)
class StandardMessagePartJavaTest {

  @Test
  @DisplayName(ConstructFromSetOfFieldsTestName)
  public void testConstructFromSetOfFields() {
    final Field field1 = simpleField(simpleFieldDefinition(1, "Account"), "account_1");
    final Field field2 = simpleField(simpleFieldDefinition(54, "Side"), "2");
    final MessagePart value = simpleMessagePart(Set.of(field1, field2));
    assertEquals(Set.of(field1, field2), value.getFields());
  }

  @Test
  @DisplayName(ConstructFromVarArgFieldsTestName)
  public void testConstructFromVarArgFields() {
    final Field field1 = simpleField(simpleFieldDefinition(1, "Account"), "account_2");
    final Field field2 = simpleField(simpleFieldDefinition(54, "Side"), "1");
    final MessagePart value = simpleMessagePart(field1, field2);
    assertEquals(Set.of(field1, field2), value.getFields());
  }
}
