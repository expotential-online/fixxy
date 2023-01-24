package fixxy.comparison.subinterface

import fixxy.comparison.MessagePartComparison

interface HasMessagePartComparisons {
  fun parts(): Set<MessagePartComparison>
}