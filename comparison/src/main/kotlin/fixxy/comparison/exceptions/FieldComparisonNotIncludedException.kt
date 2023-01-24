package fixxy.comparison.exceptions

import fixxy.core.TagNumber

class FieldComparisonNotIncludedException(tagNumber: TagNumber) :
  IllegalArgumentException("Field comparison with tag [$tagNumber] is not included")