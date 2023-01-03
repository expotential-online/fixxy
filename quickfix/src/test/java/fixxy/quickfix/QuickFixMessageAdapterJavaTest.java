package fixxy.quickfix;

import fixxy.core.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fixxy.core.standard.StandardField.groupCountField;
import static fixxy.core.standard.StandardField.simpleField;
import static fixxy.core.standard.StandardFieldDefinition.enumeratedFieldDefinition;
import static fixxy.core.standard.StandardFieldDefinition.simpleFieldDefinition;
import static fixxy.core.standard.StandardMessage.simpleMessage;
import static fixxy.core.standard.StandardMessagePart.simpleMessagePart;
import static fixxy.quickfix.QuickFixEnumeratedFieldValueHelper.enumeratedFieldValuesForFieldName;
import static fixxy.quickfix.QuickFixMessageAdapterKotlinTest.JavaSuiteName;
import static fixxy.quickfix.QuickFixMessageAdapterKotlinTest.StructureWithRepeatingGroupsTestName;
import static fixxy.quickfix.QuickFixVersion.Fix_4_2;
import static fixxy.quickfix.Tests.quickFixMessage;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName(JavaSuiteName)
public class QuickFixMessageAdapterJavaTest {

    @Test
    @DisplayName(StructureWithRepeatingGroupsTestName)
    public void testStructureWithRepeatingGroups() {

        final quickfix.Message quickFixMessage = quickFixMessage(Fix_4_2, "8=FIX.4.2|9=185|35=W|34=328|49=***|52=20190322-15:31:36.850|56=***|55=EUR/USD|262=2-1553282994.168723|268=2|269=0|270=1.127870|271=1000000|269=1|270=1.127900|271=1000000|10=082|");

        final QuickFixMessageAdapter adapter = new QuickFixMessageAdapter();
        final QuickFixContext context = new QuickFixContext(Fix_4_2);

        final Message actualFixxyMessage = adapter.adaptOrThrow(quickFixMessage, context);

        final Message expectedFixxyMessage = simpleMessage(
                simpleField(simpleFieldDefinition(55, "Symbol"), "EUR/USD"),
                simpleField(simpleFieldDefinition(262, "MDReqID"), "2-1553282994.168723"),
                groupCountField(
                        simpleFieldDefinition(268, "NoMDEntries"), "2",
                        simpleMessagePart(
                                simpleField(
                                        enumeratedFieldDefinition(
                                                269,
                                                "MDEntryType",
                                                "MDEntryType",
                                                enumeratedFieldValuesForFieldName("MDEntryType")
                                        ), "0"),
                                simpleField(simpleFieldDefinition(270, "MDEntryPx"), "1.127870"),
                                simpleField(simpleFieldDefinition(271, "MDEntrySize"), "1000000")),
                        simpleMessagePart(
                                simpleField(
                                        enumeratedFieldDefinition(
                                                269,
                                                "MDEntryType",
                                                "MDEntryType",
                                                enumeratedFieldValuesForFieldName("MDEntryType")
                                        ), "1"
                                ),
                                simpleField(simpleFieldDefinition(270, "MDEntryPx"), "1.127900"),
                                simpleField(simpleFieldDefinition(271, "MDEntrySize"), "1000000"))));

        assertEquals(expectedFixxyMessage, actualFixxyMessage);
    }
}
