package fixxy.quickfix

import fixxy.core.Context
import fixxy.core.Field
import fixxy.core.Message
import fixxy.core.MessageAdapter
import fixxy.core.standard.StandardField.Companion.groupCountField
import fixxy.core.standard.StandardField.Companion.simpleField
import fixxy.core.standard.StandardMessage.Companion.simpleMessage
import fixxy.core.standard.StandardMessagePart.Companion.simpleMessagePart
import quickfix.FieldMap

class QuickFixMessageAdapter : MessageAdapter<quickfix.Message> {

    override fun adaptOrThrow(source: quickfix.Message, context: Context): Message {
        return simpleMessage(adaptFieldMap(source, context))
    }

    // A QuickFix "field map" could be a message or an individual group of a repeating group
    private fun adaptFieldMap(fieldMap: FieldMap, context: Context): Set<Field> {
        return fieldMap
            .iterator()
            .asSequence()
            .map { adaptField(it, fieldMap, context) }
            .toSet()
    }

    private fun adaptField(quickFixField: quickfix.Field<*>, fieldMap: FieldMap, context: Context): Field =
        if (fieldMap.hasGroup(quickFixField.tag))
            adaptGroupField(quickFixField, fieldMap.getGroups(quickFixField.tag), context)
        else
            adaptNonGroupField(quickFixField, context)

    private fun adaptNonGroupField(quickFixField: quickfix.Field<*>, context: Context): Field {
        val fieldDefinition = context.fieldDefinitions.fieldDefinitionOrThrowForTagNumber(quickFixField.tag)
        return simpleField(fieldDefinition, fixFieldValueFrom(quickFixField))
    }

    private fun adaptGroupField(
        quickFixField: quickfix.Field<*>,
        quickFixGroups: Collection<quickfix.Group>,
        context: Context
    ): Field {
        val groups = quickFixGroups
            .map { adaptFieldMap(it, context) }
            .map { simpleMessagePart(it) }
            .toSet()
        val fieldDefinition = context.fieldDefinitions.fieldDefinitionOrThrowForTagNumber(quickFixField.tag)
        return groupCountField(fieldDefinition, fixFieldValueFrom(quickFixField), groups)
    }

    private fun fixFieldValueFrom(quickFixField: quickfix.Field<*>): String =
        quickFixField.toString().drop(quickFixField.tag.toString().length + 1)
}