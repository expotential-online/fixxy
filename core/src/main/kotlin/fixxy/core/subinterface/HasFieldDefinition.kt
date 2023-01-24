package fixxy.core.subinterface

import fixxy.core.FieldDefinition

/**
 * Implementor has a FIX field definition
 */
interface HasFieldDefinition {

    /**
     * @return A FIX field definition
     */
    fun fieldDefinition(): FieldDefinition
}