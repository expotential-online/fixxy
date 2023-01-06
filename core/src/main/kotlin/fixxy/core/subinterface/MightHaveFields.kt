package fixxy.core.subinterface

import fixxy.core.Field

interface MightHaveFields {
  fun fields(): Set<Field>
}