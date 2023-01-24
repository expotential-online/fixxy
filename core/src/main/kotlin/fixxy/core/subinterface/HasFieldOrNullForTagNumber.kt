package fixxy.core.subinterface

import fixxy.core.Field
import fixxy.core.TagNumber

/**
 * Implementor supports requesting the FIX field with a given tag number, returning null if it is not present
 */
interface HasFieldOrNullForTagNumber {

  /**
   * Returns the FIX field with the given tag number if it is present or else, returns null
   *
   * @param tagNumber The FIX tag number to return the corresponding field for
   * @return The FIX field with the given tag number if it is present or else, returns null
   */
  fun fieldOrNullForTagNumber(tagNumber: TagNumber): Field?
}