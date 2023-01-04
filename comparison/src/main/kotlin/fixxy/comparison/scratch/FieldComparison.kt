package fixxy.diff.scratch

import fixxy.core.HasFieldDefinition

interface FieldComparison :
        HasFieldDefinition,
        MightHaveLeftField,
        MightHaveRightField,
        HasIsInLeft,
        HasIsInRight,
        HasIsOnlyInLeft,
        HasIsOnlyInRight,
        HasIsInBoth