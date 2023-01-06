package fixxy.comparison

import fixxy.core.subinterface.HasFieldDefinition

interface FieldComparison :
  HasFieldDefinition,
  HasComparisonResultCategory,
  HasComparisonResultMessage,
  HasMessagePartComparisons