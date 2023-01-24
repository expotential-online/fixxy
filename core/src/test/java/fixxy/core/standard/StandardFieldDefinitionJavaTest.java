package fixxy.core.standard;

import static fixxy.core.standard.StandardEnumerableFieldValue.simpleEnumerableFieldValue;
import static fixxy.core.standard.StandardFieldDefinition.enumeratedFieldDefinition;
import static fixxy.core.standard.StandardFieldDefinition.simpleFieldDefinition;
import static fixxy.core.standard.StandardFieldDefinitionKotlinTest.ConstructFromTagNumberAndDescriptionAndEnumerableValuesTestName;
import static fixxy.core.standard.StandardFieldDefinitionKotlinTest.ConstructFromTagNumberAndDescriptionAndSynopsisAndEnumerableValuesTestName;
import static fixxy.core.standard.StandardFieldDefinitionKotlinTest.ConstructFromTagNumberAndDescriptionAndSynopsisTestName;
import static fixxy.core.standard.StandardFieldDefinitionKotlinTest.ConstructFromTagNumberAndDescriptionTestName;
import static fixxy.core.standard.StandardFieldDefinitionKotlinTest.JavaSuiteName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fixxy.core.EnumerableFieldValue;
import fixxy.core.FieldDefinition;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(JavaSuiteName)
class StandardFieldDefinitionJavaTest {

  @Test
  @DisplayName(ConstructFromTagNumberAndDescriptionAndSynopsisTestName)
  void testConstructFromTagNumberAndDescriptionAndSynopsis() {
    final FieldDefinition value = simpleFieldDefinition(1, "Account", "An account");
    assertEquals(1, value.tagNumber());
    assertEquals("Account", value.description());
    assertEquals("An account", value.synopsis());
    assertTrue(value.enumerableValues().isEmpty());
  }

  @Test
  @DisplayName(ConstructFromTagNumberAndDescriptionTestName)
  void testConstructFromTagNumberAndDescription() {
    final FieldDefinition value = simpleFieldDefinition(1, "Account");
    assertEquals(1, value.tagNumber());
    assertEquals("Account", value.description());
    assertEquals("Account", value.synopsis());
    assertTrue(value.enumerableValues().isEmpty());
  }

  @Test
  @DisplayName(ConstructFromTagNumberAndDescriptionAndSynopsisAndEnumerableValuesTestName)
  void testConstructFromTagNumberAndDescriptionAndSynopsisAndEnumerableValues() {
    final EnumerableFieldValue fieldValue1 = simpleEnumerableFieldValue("account_1", "X");
    final EnumerableFieldValue fieldValue2 = simpleEnumerableFieldValue("account_2", "Y");
    final FieldDefinition value = enumeratedFieldDefinition(1, "Account", "An account",
        Set.of(fieldValue1, fieldValue2));
    assertEquals(1, value.tagNumber());
    assertEquals("Account", value.description());
    assertEquals("An account", value.synopsis());
    assertEquals(Set.of(fieldValue1, fieldValue2), value.enumerableValues());
  }

  @Test
  @DisplayName(ConstructFromTagNumberAndDescriptionAndEnumerableValuesTestName)
  void testConstructFromTagNumberAndDescriptionAndEnumerableValues() {
    final EnumerableFieldValue fieldValue1 = simpleEnumerableFieldValue("account_3", "Z");
    final EnumerableFieldValue fieldValue2 = simpleEnumerableFieldValue("account_4", "A");
    final FieldDefinition value = enumeratedFieldDefinition(1, "Account", Set.of(fieldValue1, fieldValue2));
    assertEquals(1, value.tagNumber());
    assertEquals("Account", value.description());
    assertEquals("Account", value.synopsis());
    assertEquals(Set.of(fieldValue1, fieldValue2), value.enumerableValues());
  }
}
