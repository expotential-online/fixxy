package fixxy.core

import fixxy.core.subinterface.HasFieldDefinition
import fixxy.core.subinterface.HasFixFieldValue
import fixxy.core.subinterface.HasIsGroup
import fixxy.core.subinterface.HasMessageParts

/**
 * A FIX field consisting of its definition and value
 */
interface Field :
  HasFieldDefinition,
  HasFixFieldValue,
  HasMessageParts,
  HasIsGroup