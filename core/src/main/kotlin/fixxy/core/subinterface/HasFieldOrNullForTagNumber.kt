package fixxy.core.subinterface

import fixxy.core.Field
import fixxy.core.TagNumber

interface HasFieldOrNullForTagNumber {
  fun fieldOrNullForTagNumber(tagNumber: TagNumber): Field?
}