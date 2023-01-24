package fixxy.core.subinterface

import fixxy.core.Field

/**
 * Implementor contains a set of fields (which may be empty - hence the "might have")
 */
interface MightHaveFields {

  /**
   * @return A set of fields (which may be empty)
   */
  fun fields(): Set<Field>
}