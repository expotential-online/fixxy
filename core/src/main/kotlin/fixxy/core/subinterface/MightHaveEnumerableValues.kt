package fixxy.core.subinterface

import fixxy.core.EnumerableFieldValue

/**
 * Implementor has a set of enumerable field values. This may be empty (hence the "might have) in which case the
 * implementor is considered not to have a predefined set of possible values
 */
interface MightHaveEnumerableValues {

  /**
   * @return A set of enumerable field values. This may be empty in which case it is considered that there is no
   * predefined set of possible values
   */
  fun enumerableValues(): Set<EnumerableFieldValue>
}