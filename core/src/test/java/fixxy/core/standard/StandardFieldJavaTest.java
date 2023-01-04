package fixxy.core.standard;

import static fixxy.core.standard.StandardField.groupCountField;
import static fixxy.core.standard.StandardField.simpleField;
import static fixxy.core.standard.StandardFieldDefinition.simpleFieldDefinition;
import static fixxy.core.standard.StandardFieldKotlinTest.ConstructGroupCountFieldFromSetOfPartsTestName;
import static fixxy.core.standard.StandardFieldKotlinTest.ConstructGroupCountFieldFromVarArgPartsTestName;
import static fixxy.core.standard.StandardFieldKotlinTest.ConstructSimpleFieldTestName;
import static fixxy.core.standard.StandardFieldKotlinTest.JavaSuiteName;
import static fixxy.core.standard.StandardMessagePart.simpleMessagePart;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fixxy.core.Field;
import fixxy.core.MessagePart;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(JavaSuiteName)
class StandardFieldJavaTest {

  @Test
  @DisplayName(ConstructSimpleFieldTestName)
  void testConstructSimpleField() {
    final Field value = simpleField(simpleFieldDefinition(54, "Side"), "2");
    assertEquals(54, value.definition().getTagNumber());
    assertEquals("Side", value.definition().getDescription());
    assertEquals("2", value.getFixFieldValue());
    assertFalse(value.isGroup());
    assertTrue(value.getParts().isEmpty());
  }

  @Test
  @DisplayName(ConstructGroupCountFieldFromSetOfPartsTestName)
  void testConstructGroupCountFieldFromSetOfParts() {
    final MessagePart part1 = simpleMessagePart(
        simpleField(simpleFieldDefinition(1, "Account"), "account_1"),
        simpleField(simpleFieldDefinition(54, "Side"), "2"));
    final MessagePart part2 = simpleMessagePart(
        simpleField(simpleFieldDefinition(1, "Account"), "account_2"),
        simpleField(simpleFieldDefinition(54, "Side"), "1"));
    final Field value = groupCountField(simpleFieldDefinition(2, "NoEntries"), "2", Set.of(part1, part2));
    assertEquals(2, value.definition().getTagNumber());
    assertEquals("NoEntries", value.definition().getDescription());
    assertEquals("2", value.getFixFieldValue());
    assertTrue(value.isGroup());
    assertEquals(Set.of(part1, part2), value.getParts());
  }

  @Test
  @DisplayName(ConstructGroupCountFieldFromVarArgPartsTestName)
  void testConstructGroupCountFieldFromVarArgParts() {
    final MessagePart part1 = simpleMessagePart(
        simpleField(simpleFieldDefinition(1, "Account"), "account_3"),
        simpleField(simpleFieldDefinition(54, "Side"), "4"));
    final MessagePart part2 = simpleMessagePart(
        simpleField(simpleFieldDefinition(1, "Account"), "account_4"),
        simpleField(simpleFieldDefinition(54, "Side"), "3"));
    final Field value = groupCountField(simpleFieldDefinition(2, "NoEntries"), "2", part1, part2);
    assertEquals(2, value.definition().getTagNumber());
    assertEquals("NoEntries", value.definition().getDescription());
    assertEquals("2", value.getFixFieldValue());
    assertTrue(value.isGroup());
    assertEquals(Set.of(part1, part2), value.getParts());
  }
}
