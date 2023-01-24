package fixxy.core.extensions

import fixxy.core.MessagePart

object MessagePartExtensions {
  @JvmStatic
  fun MessagePart.tagNumbers(): Set<Int> = this.fields().map { it.fieldDefinition().tagNumber() }.toSet()
}