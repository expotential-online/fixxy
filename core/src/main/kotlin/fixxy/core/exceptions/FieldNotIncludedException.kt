package fixxy.core.exceptions

import fixxy.core.TagNumber

class FieldNotIncludedException(tagNumber: TagNumber) :
  IllegalArgumentException("Field with tag [$tagNumber] is not included")