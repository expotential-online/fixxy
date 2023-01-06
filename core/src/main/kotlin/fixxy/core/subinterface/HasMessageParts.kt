package fixxy.core.subinterface

import fixxy.core.MessagePart

interface HasMessageParts {
  fun parts(): Set<MessagePart>
}