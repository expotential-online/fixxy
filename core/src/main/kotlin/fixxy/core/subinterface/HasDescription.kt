package fixxy.core.subinterface

import fixxy.core.Description

/**
 * Implementor has a human-readable description
 */
interface HasDescription {

  /**
   * @return A human-readable description
   */
  fun description(): Description
}