package fixxy.quickfix;

import static fixxy.quickfix.QuickFixEnumeratedFieldValueHelperKotlinTest.JavaSuiteName;
import static java.util.Arrays.stream;

import org.junit.jupiter.api.DisplayName;
import quickfix.DataDictionary;
import quickfix.DefaultDataDictionaryProvider;

import java.util.List;

@DisplayName(JavaSuiteName)
class QuickFixEnumeratedFieldValueHelperJavaTest {

  private void testAllQuickFixFieldsWithEnumeratedFieldValuesForFixVersion(final QuickFixVersion quickFixVersion) {
    final DataDictionary dictionary = dictionaryForVersion(quickFixVersion);
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

  private static class Field {
    private final int tagNumber;
    private final String name;

    private Field(final int tagNumber, final String name) {
      this.tagNumber = tagNumber;
      this.name = name;
    }
  }

  static class ScopingTester {
    public static int nonConstant = 1;
    private static final int nonPublic = 2;
    public static final String serialVersionUID = "inadmissible";
    public static final int FIELD = 3;
    public static final int candidate = 4;
  }
}
