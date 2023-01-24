package fixxy.core.subinterface

import fixxy.core.IsGroup

/**
 * Implementor expresses whether it is the root of a repeating group
 */
interface HasIsGroup {

  /**
   * @return True if this is the root of a repeating group, false otherwise
   */
  fun isGroup(): IsGroup
}