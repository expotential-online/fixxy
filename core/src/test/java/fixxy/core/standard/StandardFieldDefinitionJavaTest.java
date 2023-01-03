package fixxy.core.standard;

import fixxy.core.EnumerableFieldValue;
import fixxy.core.FieldDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static fixxy.core.standard.StandardEnumerableFieldValue.simpleEnumerableFieldValue;
import static fixxy.core.standard.StandardFieldDefinition.enumeratedFieldDefinition;
import static fixxy.core.standard.StandardFieldDefinition.simpleFieldDefinition;
import static fixxy.core.standard.StandardFieldDefinitionKotlinTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName(JavaSuiteName)
public class StandardFieldDefinitionJavaTest {

    @Test
    @DisplayName(ConstructFromTagNumberAndDescriptionAndSynopsisTestName)
    public void testConstructFromTagNumberAndDescriptionAndSynopsis() {
        final FieldDefinition value = simpleFieldDefinition(1, "Account", "An account");
        assertEquals(1, value.getTagNumber());
        assertEquals("Account", value.getDescription());
        assertEquals("An account", value.getSynopsis());
        assertTrue(value.getEnumerableValues().isEmpty());
    }

    @Test
    @DisplayName(ConstructFromTagNumberAndDescriptionTestName)
    public void testConstructFromTagNumberAndDescription() {
        final FieldDefinition value = simpleFieldDefinition(1, "Account");
        assertEquals(1, value.getTagNumber());
        assertEquals("Account", value.getDescription());
        assertEquals("Account", value.getSynopsis());
        assertTrue(value.getEnumerableValues().isEmpty());
    }

    @Test
    @DisplayName(ConstructFromTagNumberAndDescriptionAndSynopsisAndEnumerableValuesTestName)
    public void testConstructFromTagNumberAndDescriptionAndSynopsisAndEnumerableValues() {
        final EnumerableFieldValue fieldValue1 = simpleEnumerableFieldValue("account_1", "X");
        final EnumerableFieldValue fieldValue2 = simpleEnumerableFieldValue("account_2", "Y");
        final FieldDefinition value = enumeratedFieldDefinition(1, "Account", "An account",
                Set.of(fieldValue1, fieldValue2));
        assertEquals(1, value.getTagNumber());
        assertEquals("Account", value.getDescription());
        assertEquals("An account", value.getSynopsis());
        assertEquals(Set.of(fieldValue1, fieldValue2), value.getEnumerableValues());
    }

    @Test
    @DisplayName(ConstructFromTagNumberAndDescriptionAndEnumerableValuesTestName)
    public void testConstructFromTagNumberAndDescriptionAndEnumerableValues() {
        final EnumerableFieldValue fieldValue1 = simpleEnumerableFieldValue("account_1", "X");
        final EnumerableFieldValue fieldValue2 = simpleEnumerableFieldValue("account_2", "Y");
        final FieldDefinition value = enumeratedFieldDefinition(1, "Account", Set.of(fieldValue1, fieldValue2));
        assertEquals(1, value.getTagNumber());
        assertEquals("Account", value.getDescription());
        assertEquals("Account", value.getSynopsis());
        assertEquals(Set.of(fieldValue1, fieldValue2), value.getEnumerableValues());
    }
}
