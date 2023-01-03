package fixxy.core.exceptions

import fixxy.core.TagNumber

class UnsupportedTagNumberException(tagNumber: TagNumber) : IllegalArgumentException("Tag [$tagNumber] is unsupported")