package fixxy.quickfix;

import static fixxy.quickfix.QuickFixEnumeratedFieldValueHelperKotlinTest.JavaSuiteName;

import org.junit.jupiter.api.DisplayName;

@DisplayName(JavaSuiteName)
class QuickFixEnumeratedFieldValueHelperJavaTest {

  static class ScopingTester {
    public static int nonConstant = 1;
    private static final int nonPublic = 2;
    public static final String serialVersionUID = "inadmissible";
    public static final int FIELD = 3;
    public static final int candidate = 4;
  }
}
