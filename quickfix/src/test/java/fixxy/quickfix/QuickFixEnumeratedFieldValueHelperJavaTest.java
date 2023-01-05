package fixxy.quickfix;

import static fixxy.quickfix.QuickFixEnumeratedFieldValueHelper.enumeratedFieldValuesForFieldName;
import static fixxy.quickfix.QuickFixEnumeratedFieldValueHelperKotlinTest.AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix;
import static fixxy.quickfix.QuickFixEnumeratedFieldValueHelperKotlinTest.JavaSuiteName;
import static fixxy.quickfix.QuickFixVersion.Fix40;
import static fixxy.quickfix.QuickFixVersion.Fix41;
import static fixxy.quickfix.QuickFixVersion.Fix42;
import static fixxy.quickfix.QuickFixVersion.Fix43;
import static fixxy.quickfix.QuickFixVersion.Fix44;
import static fixxy.quickfix.QuickFixVersion.Fix50;
import static fixxy.quickfix.QuickFixVersion.Fix50sp1;
import static fixxy.quickfix.QuickFixVersion.Fix50sp2;
import static java.lang.String.format;
import static java.util.Arrays.stream;

import fixxy.core.EnumerableFieldValue;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import quickfix.DataDictionary;
import quickfix.DefaultDataDictionaryProvider;

@DisplayName(JavaSuiteName)
class QuickFixEnumeratedFieldValueHelperJavaTest {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Test
  @DisplayName("[ FIX 4.0 ] " + AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix)
  void testAllQuickFixFieldsWithEnumeratedFieldValues_Fix_4_0() {
    testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(Fix40);
  }

  @Test
  @DisplayName("[ FIX 4.1 ] " + AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix)
  void testAllQuickFixFieldsWithEnumeratedFieldValues_Fix_4_1() {
    testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(Fix41);
  }

  @Test
  @DisplayName("[ FIX 4.2 ] " + AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix)
  void testAllQuickFixFieldsWithEnumeratedFieldValues_Fix_4_2() {
    testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(Fix42);
  }

  @Test
  @DisplayName("[ FIX 4.3 ] " + AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix)
  void testAllQuickFixFieldsWithEnumeratedFieldValues_Fix_4_3() {
    testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(Fix43);
  }

  @Test
  @DisplayName("[ FIX 4.4 ] " + AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix)
  void testAllQuickFixFieldsWithEnumeratedFieldValues_Fix_4_4() {
    testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(Fix44);
  }

  @Test
  @DisplayName("[ FIX 5.0 ] " + AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix)
  void testAllQuickFixFieldsWithEnumeratedFieldValues_Fix_5_0() {
    testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(Fix50);
  }

  @Test
  @DisplayName("[ FIX 5.0 sp1 ] " + AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix)
  void testAllQuickFixFieldsWithEnumeratedFieldValues_Fix_5_0_sp_1() {
    testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(Fix50sp1);
  }

  @Test
  @DisplayName("[ FIX 5.0 sp2 ] " + AllQuickFixFieldsWithEnumeratedFieldValuesTestNameSuffix)
  void testAllQuickFixFieldsWithEnumeratedFieldValues_Fix_5_0_sp_2() {
    testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(Fix50sp2);
  }

  private void testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(final QuickFixVersion quickFixVersion) {
    final DataDictionary dictionary = dictionaryForVersion(quickFixVersion);
    final List<Field> fieldsWithEnumeratedFieldValues = fieldsWithEnumeratedFieldValues(dictionary);
    final List<String> summaries = fieldsWithEnumeratedFieldValues.stream()
        .map(this::testQuickFixFieldWithEnumeratedValues).toList();
    logger.info(() -> "Found [" + summaries.size() + "] FIX fields with enumerated values. Details follow...");
    for (final String it : summaries) {
      logger.info(() -> it);
    }
  }

  private DataDictionary dictionaryForVersion(final QuickFixVersion quickFixVersion) {
    return new DefaultDataDictionaryProvider().getApplicationDataDictionary(quickFixVersion.applVerID());
  }

  private List<Field> fieldsWithEnumeratedFieldValues(final DataDictionary dictionary) {
    return stream(dictionary.getOrderedFields())
        .filter(dictionary::hasFieldValue)
        .mapToObj(it -> new Field(it, dictionary.getFieldName(it)))
        .toList();
  }

  private String testQuickFixFieldWithEnumeratedValues(final Field field) {
    Set<EnumerableFieldValue> values = enumeratedFieldValuesForFieldName(field.name);
    return summary(field, values);
  }

  private String summary(final Field field, final Set<EnumerableFieldValue> enumerableFieldValues) {
    final int longestFixFieldValue = enumerableFieldValues.stream()
        .map(it -> it.getFixFieldValue().length())
        .max(Integer::compare)
        .orElse(1);
    final StringBuilder summary = new StringBuilder("FIX field [")
        .append(field.tagNumber)
        .append("] with name [")
        .append(field.name)
        .append("] has enumerated values:\n\n");
    for (final EnumerableFieldValue it : enumerableFieldValues) {
      final String paddedFixFieldValue = format("%-" + longestFixFieldValue + "s", it.getFixFieldValue());
      summary.append(" - ")
          .append(paddedFixFieldValue)
          .append(" | ")
          .append(it.getDescription())
          .append("\n");
    }
    return summary.toString();
  }

  private record Field(int tagNumber, String name) {
  }

  static class ScopingTester {
    public static int nonConstant = 1;
    private static final int nonPublic = 2;
    public static final String serialVersionUID = "inadmissible";
    public static final int FIELD = 3;
    public static final int candidate = 4;
  }
}
