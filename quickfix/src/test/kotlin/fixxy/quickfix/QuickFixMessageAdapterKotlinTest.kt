package fixxy.quickfix

import fixxy.core.standard.StandardField.Companion.groupCountField
import fixxy.core.standard.StandardField.Companion.simpleField
import fixxy.core.standard.StandardFieldDefinition.Companion.enumeratedFieldDefinition
import fixxy.core.standard.StandardFieldDefinition.Companion.simpleFieldDefinition
import fixxy.core.standard.StandardMessage.Companion.simpleMessage
import fixxy.core.standard.StandardMessagePart.Companion.simpleMessagePart
import fixxy.quickfix.QuickFixEnumeratedFieldValueHelper.enumeratedFieldValuesForFieldName
import fixxy.quickfix.QuickFixMessageAdapterKotlinTest.Companion.KotlinSuiteName
import fixxy.quickfix.QuickFixVersion.Fix_4_2
import fixxy.quickfix.Tests.Java
import fixxy.quickfix.Tests.Kotlin
import fixxy.quickfix.Tests.quickFixMessage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName(KotlinSuiteName)
internal class QuickFixMessageAdapterKotlinTest {

    @Test
    @DisplayName(StructureWithRepeatingGroupsTestName)
    fun testStructureWithRepeatingGroups() {

        val quickFixMessage = quickFixMessage(
            Fix_4_2,
            "8=FIX.4.2|9=185|35=W|34=328|49=***|52=20190322-15:31:36.850|56=***|55=EUR/USD|262=2-1553282994.168723|268=2|269=0|270=1.127870|271=1000000|269=1|270=1.127900|271=1000000|10=082|"
        )

        val adapter = QuickFixMessageAdapter()
        val context = QuickFixContext(Fix_4_2)

        val actualFixxyMessage = adapter.adaptOrThrow(quickFixMessage, context)

        val expectedFixxyMessage = simpleMessage(
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
                        ), "0"
                    ),
                    simpleField(simpleFieldDefinition(270, "MDEntryPx"), "1.127870"),
                    simpleField(simpleFieldDefinition(271, "MDEntrySize"), "1000000")
                ),
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
                    simpleField(simpleFieldDefinition(271, "MDEntrySize"), "1000000")
                )
            )
        )

        assertEquals(expectedFixxyMessage, actualFixxyMessage)
    }

    companion object {
        private const val SuiteName = "QuickFix message adapter"
        const val KotlinSuiteName = "$Kotlin $SuiteName"
        const val JavaSuiteName = "$Java $SuiteName"

        const val StructureWithRepeatingGroupsTestName = "Structure with repeating groups"
    }
}