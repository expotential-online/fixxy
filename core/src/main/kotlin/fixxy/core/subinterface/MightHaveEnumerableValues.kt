package fixxy.core.subinterface

import fixxy.core.EnumerableFieldValue

interface MightHaveEnumerableValues {
  fun enumerableValues(): Set<EnumerableFieldValue>
}