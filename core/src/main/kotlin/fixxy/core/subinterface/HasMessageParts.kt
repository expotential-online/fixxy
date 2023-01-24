package fixxy.core.subinterface

import fixxy.core.MessagePart

/**
 * Implementor has a set of FIX message parts
 */
interface HasMessageParts {

  /**
   * @return A set of FIX message parts
   */
  fun parts(): Set<MessagePart>
}