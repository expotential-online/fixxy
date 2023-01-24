package fixxy.core

import fixxy.core.subinterface.HasDescription
import fixxy.core.subinterface.HasSynopsis
import fixxy.core.subinterface.HasTagNumber
import fixxy.core.subinterface.MightHaveEnumerableValues

/**
 * The definition of a FIX field
 */
interface FieldDefinition :
  HasTagNumber,
  HasDescription,
  HasSynopsis,
  MightHaveEnumerableValues