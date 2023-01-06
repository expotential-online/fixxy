package fixxy.core.extensions

import fixxy.core.MessagePart

object MessagePartExtensions {
  fun MessagePart.tagNumbers(): Set<Int> = this.fields().map { it.fieldDefinition().tagNumber() }.toSet()
}