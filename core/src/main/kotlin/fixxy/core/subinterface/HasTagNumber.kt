package fixxy.core.subinterface

import fixxy.core.TagNumber

/**
 * Implementor has a FIX tag number
 */
interface HasTagNumber {

  /**
   * @return A FIX tag number
   */
  fun tagNumber(): TagNumber
}