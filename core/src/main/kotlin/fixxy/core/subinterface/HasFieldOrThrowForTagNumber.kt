package fixxy.core.subinterface

import fixxy.core.Field
import fixxy.core.TagNumber
import fixxy.core.exceptions.FieldNotIncludedException

/**
 * Implementor supports requesting the FIX field with a given tag number, returning null if it is not present
 */
interface HasFieldOrThrowForTagNumber {

  /**
   * Returns the FIX field with the given tag number if it is present or else, throws an exception
   *
   * @param tagNumber The FIX tag number to return the corresponding field for
   * @return The FIX field with the given tag number if it is present or else, throws and exception
   * @throws FieldNotIncludedException If the field was not present
   */
  @Throws(FieldNotIncludedException::class)
  fun fieldOrThrowForTagNumber(tagNumber: TagNumber): Field
}