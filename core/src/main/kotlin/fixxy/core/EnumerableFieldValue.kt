package fixxy.core

import fixxy.core.subinterface.HasDescription
import fixxy.core.subinterface.HasFixFieldValue

/**
 * A value that a particular FIX field could take
 */
interface EnumerableFieldValue :
  HasDescription,
  HasFixFieldValue