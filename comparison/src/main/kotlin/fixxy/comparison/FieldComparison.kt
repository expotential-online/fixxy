package fixxy.comparison

import fixxy.comparison.subinterface.HasComparisonResultCategory
import fixxy.comparison.subinterface.HasComparisonResultMessage
import fixxy.comparison.subinterface.HasMessagePartComparisons
import fixxy.core.subinterface.HasFieldDefinition

interface FieldComparison :
  HasFieldDefinition,
  HasComparisonResultCategory,
  HasComparisonResultMessage,
  HasMessagePartComparisons