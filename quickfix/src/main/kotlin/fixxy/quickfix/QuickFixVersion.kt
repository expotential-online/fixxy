package fixxy.quickfix

import quickfix.field.ApplVerID
import quickfix.field.ApplVerID.*

enum class QuickFixVersion(val fixRepresentation: FixVersionFixRepresentation) {
    Fix_4_0(FIX40),
    Fix_4_1(FIX41),
    Fix_4_2(FIX42),
    Fix_4_3(FIX43),
    Fix_4_4(FIX44),
    Fix_5_0(FIX50),
    Fix_5_0_sp_1(FIX50SP1),
    Fix_5_0_sp_2(FIX50SP2)
    ;

    fun applVerID(): ApplVerID = ApplVerID(fixRepresentation)
}