package fixxy.core.standard

import fixxy.core.Description
import fixxy.core.EnumerableFieldValue
import fixxy.core.FieldDefinition
import fixxy.core.Synopsis
import fixxy.core.TagNumber

@Suppress("DataClassPrivateConstructor")
data class StandardFieldDefinition private constructor(
  private val tagNumber: TagNumber,
  private val description: Description,
  private val synopsis: Synopsis,
  private val enumerableValues: Set<EnumerableFieldValue>
) : FieldDefinition {

  override fun tagNumber(): TagNumber = tagNumber
  override fun description(): Description = description
  override fun synopsis(): Synopsis = synopsis
  override fun enumerableValues(): Set<EnumerableFieldValue> = enumerableValues

  companion object {

    @JvmStatic
    fun simpleFieldDefinition(
      tagNumber: TagNumber,
      description: Description,
      synopsis: Synopsis
    ): FieldDefinition =
      StandardFieldDefinition(tagNumber, description, synopsis, setOf())

    @JvmStatic
    fun simpleFieldDefinition(
      tagNumber: TagNumber,
      description: Description
    ): FieldDefinition =
      StandardFieldDefinition(tagNumber, description, description, setOf())

    @JvmStatic
    fun enumeratedFieldDefinition(
      tagNumber: TagNumber,
      description: Description,
      synopsis: Synopsis,
      enumerableValues: Set<EnumerableFieldValue>
    ): FieldDefinition =
      StandardFieldDefinition(tagNumber, description, synopsis, enumerableValues)

    @JvmStatic
    fun enumeratedFieldDefinition(
      tagNumber: TagNumber,
      description: Description,
      enumerableValues: Set<EnumerableFieldValue>
    ): FieldDefinition =
      StandardFieldDefinition(tagNumber, description, description, enumerableValues)
  }
}