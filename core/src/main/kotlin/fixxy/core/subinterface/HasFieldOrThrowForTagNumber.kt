package fixxy.core.subinterface

import fixxy.core.Field
import fixxy.core.TagNumber
import fixxy.core.exceptions.FieldNotIncludedException

interface HasFieldOrThrowForTagNumber {
  @Throws(FieldNotIncludedException::class)
  fun fieldOrThrowForTagNumber(tagNumber: TagNumber): Field
}