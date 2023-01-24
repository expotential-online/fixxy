package fixxy.comparison.subinterface

import fixxy.comparison.FieldComparison

interface MightHaveFieldComparisons {
  fun fieldComparisons(): Set<FieldComparison>
}