package fixxy.core.subinterface

import fixxy.core.FixFieldValue

/**
 * Implementor has a field value expressed as a FIX string
 */
interface HasFixFieldValue {

  /**
   * @return A field value expressed as a FIX string
   */
  fun fixFieldValue(): FixFieldValue
}