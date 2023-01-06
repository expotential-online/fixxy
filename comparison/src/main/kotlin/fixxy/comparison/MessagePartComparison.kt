package fixxy.comparison

interface MessagePartComparison {
  fun fieldComparisons(): Set<FieldComparison>
}