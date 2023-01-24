package fixxy.comparison.comparer

import fixxy.comparison.MessagePartComparison
import fixxy.core.MessagePart

interface MessagePartComparer {
  fun compare(leftPart: MessagePart, rightPart: MessagePart): MessagePartComparison
}