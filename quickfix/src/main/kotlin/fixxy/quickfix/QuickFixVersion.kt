package fixxy.quickfix

import quickfix.field.ApplVerID
import quickfix.field.ApplVerID.FIX40
import quickfix.field.ApplVerID.FIX41
import quickfix.field.ApplVerID.FIX42
import quickfix.field.ApplVerID.FIX43
import quickfix.field.ApplVerID.FIX44
import quickfix.field.ApplVerID.FIX50
import quickfix.field.ApplVerID.FIX50SP1
import quickfix.field.ApplVerID.FIX50SP2

enum class QuickFixVersion(private val fixRepresentation: FixVersionFixRepresentation) {
  Fix40(FIX40),
  Fix41(FIX41),
  Fix42(FIX42),
  Fix43(FIX43),
  Fix44(FIX44),
  Fix50(FIX50),
  Fix50sp1(FIX50SP1),
  Fix50sp2(FIX50SP2)
  ;

  fun applVerID(): ApplVerID = ApplVerID(fixRepresentation)
}