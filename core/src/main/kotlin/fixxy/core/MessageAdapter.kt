package fixxy.core

/**
 * Implementor is able to translate objects of some given type to a Fixxy message representation
 *
 * @param T The type of objects the adapter can convert into a Fixxy message representation
 */
interface MessageAdapter<T> {

  /**
   * Translates an object of some given type to a Fixxy message representation
   *
   * @param source The object to translate
   * @param context The context to facilitate the translation
   * @return A Fixxy message representation
   */
  // TODO: Throwing
  fun adaptOrThrow(source: T, context: Context): Message
}