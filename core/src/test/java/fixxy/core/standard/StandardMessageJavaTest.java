package fixxy.core.standard;

import static fixxy.core.standard.StandardField.simpleField;
import static fixxy.core.standard.StandardFieldDefinition.simpleFieldDefinition;
import static fixxy.core.standard.StandardMessage.simpleMessage;
import static fixxy.core.standard.StandardMessageKotlinTest.ConstructFromVarArgFieldsTestName;
import static fixxy.core.standard.StandardMessageKotlinTest.FieldOrNullForTagNumberTestName;
import static fixxy.core.standard.StandardMessageKotlinTest.FieldOrThrowForTagNumberTestName;
import static fixxy.core.standard.StandardMessageKotlinTest.JavaSuiteName;
import static fixxy.core.standard.StandardMessagePartKotlinTest.ConstructFromSetOfFieldsTestName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import fixxy.core.Field;
import fixxy.core.Message;
import fixxy.core.exceptions.FieldNotIncludedException;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(JavaSuiteName)
class StandardMessageJavaTest {

  @Test
  @DisplayName(ConstructFromSetOfFieldsTestName)
  void testConstructFromSetOfFields() {
    final Field field1 = simpleField(simpleFieldDefinition(1, "Account"), "account_1");
    final Field field2 = simpleField(simpleFieldDefinition(54, "Side"), "2");
    final Message value = simpleMessage(Set.of(field1, field2));
    assertEquals(Set.of(field1, field2), value.fields());
  }

  @Test
  @DisplayName(ConstructFromVarArgFieldsTestName)
  void testConstructFromVarArgFields() {
    final Field field1 = simpleField(simpleFieldDefinition(1, "Account"), "account_2");
    final Field field2 = simpleField(simpleFieldDefinition(54, "Side"), "1");
    final Message value = simpleMessage(field1, field2);
    assertEquals(Set.of(field1, field2), value.fields());
  }

  @Test
  @DisplayName(FieldOrNullForTagNumberTestName)
  void testFieldOrNullForTagNumber() {
    final Field field1 = simpleField(simpleFieldDefinition(1, "Account"), "account_2");
    final Field field2 = simpleField(simpleFieldDefinition(54, "Side"), "1");
    final Message value = simpleMessage(field1, field2);
    assertEquals(field1, value.fieldOrNullForTagNumber(1));
    assertEquals(field2, value.fieldOrNullForTagNumber(54));
    assertNull(value.fieldOrNullForTagNumber(58));
  }

  @Test
  @DisplayName(FieldOrThrowForTagNumberTestName)
  void testFieldOrThrowForTagNumber() {
    final Field field1 = simpleField(simpleFieldDefinition(1, "Account"), "account_2");
    final Field field2 = simpleField(simpleFieldDefinition(54, "Side"), "1");
    final Message value = simpleMessage(field1, field2);
    assertEquals(field1, value.fieldOrThrowForTagNumber(1));
    assertEquals(field2, value.fieldOrThrowForTagNumber(54));
    assertThrows(
        FieldNotIncludedException.class,
        () -> value.fieldOrThrowForTagNumber(58),
        "Field with tag [58] is not included");
  }
}
