package fixxy.core.standard;

import static fixxy.core.standard.StandardEnumerableFieldValue.simpleEnumerableFieldValue;
import static fixxy.core.standard.StandardEnumerableFieldValueKotlinTest.ConstructWithDescriptionAndFixFieldValueTestName;
import static fixxy.core.standard.StandardEnumerableFieldValueKotlinTest.JavaSuiteName;
import static org.junit.jupiter.api.Assertions.assertEquals;

import fixxy.core.EnumerableFieldValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(JavaSuiteName)
class StandardEnumerableFieldValueJavaTest {

  @Test
  @DisplayName(ConstructWithDescriptionAndFixFieldValueTestName)
  void testConstructWithDescriptionAndFixFieldValue() {
    final EnumerableFieldValue value = simpleEnumerableFieldValue("some_description", "Z");
    assertEquals("some_description", value.getDescription());
    assertEquals("Z", value.getFixFieldValue());
  }
}
