package fixxy.core

import fixxy.core.subinterface.HasFieldOrNullForTagNumber
import fixxy.core.subinterface.HasFieldOrThrowForTagNumber
import fixxy.core.subinterface.MightHaveFields

interface MessagePart :
  MightHaveFields,
  HasFieldOrNullForTagNumber,
  HasFieldOrThrowForTagNumber