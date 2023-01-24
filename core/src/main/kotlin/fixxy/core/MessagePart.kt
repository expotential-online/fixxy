package fixxy.core

import fixxy.core.subinterface.HasFieldOrNullForTagNumber
import fixxy.core.subinterface.HasFieldOrThrowForTagNumber
import fixxy.core.subinterface.MightHaveFields

/**
 * Part of a FIX message consisting of fields and methods to access them
 */
interface MessagePart :
  MightHaveFields,
  HasFieldOrNullForTagNumber,
  HasFieldOrThrowForTagNumber