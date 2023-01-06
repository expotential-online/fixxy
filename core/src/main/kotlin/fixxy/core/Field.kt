package fixxy.core

import fixxy.core.subinterface.HasFieldDefinition
import fixxy.core.subinterface.HasFixFieldValue
import fixxy.core.subinterface.HasIsGroup
import fixxy.core.subinterface.HasMessageParts

interface Field :
  HasFieldDefinition,
  HasFixFieldValue,
  HasMessageParts,
  HasIsGroup