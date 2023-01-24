package fixxy.comparison

enum class FieldInclusion(private val capitalisedDescription: String) {
  OnlyInLeft("Only in left"),
  OnlyInRight("Only in right"),
  InBothLeftAndRight("In both left and right"),
  InNeitherLeftNorRight("In neither left nor right");

  fun description(): String = capitalisedDescription
}