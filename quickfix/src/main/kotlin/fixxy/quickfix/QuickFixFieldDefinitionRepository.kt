package fixxy.quickfix

import fixxy.core.*
import fixxy.core.exceptions.UnsupportedTagNumberException
import fixxy.core.standard.StandardFieldDefinition.Companion.enumeratedFieldDefinition
import fixxy.quickfix.QuickFixEnumeratedFieldValueHelper.enumeratedFieldValuesForFieldName
import quickfix.DefaultDataDictionaryProvider

class QuickFixFieldDefinitionRepository(fixVersion: QuickFixVersion) : AbstractFieldDefinitionRepository() {

    private val dictionary = DefaultDataDictionaryProvider().getApplicationDataDictionary(fixVersion.applVerID())
    private val definitionsByTagNumber = mutableMapOf<TagNumber, FieldDefinition>()

    override fun fieldDefinitionOrThrowForTagNumber(tagNumber: TagNumber): FieldDefinition =
        definitionsByTagNumber.computeIfAbsent(tagNumber, this::deriveFieldDefinitionOrThrowForTagNumber)

    @Throws(UnsupportedTagNumberException::class)
    private fun deriveFieldDefinitionOrThrowForTagNumber(tagNumber: TagNumber): FieldDefinition {
        val fieldName = dictionary.getFieldName(tagNumber) ?: throw UnsupportedTagNumberException(tagNumber)
        val enumeratedFieldValues = enumeratedFieldValuesForFieldName(fieldName)
        return enumeratedFieldDefinition(tagNumber, fieldName, enumeratedFieldValues)
    }
}