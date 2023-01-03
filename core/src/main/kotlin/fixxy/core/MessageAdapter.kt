package fixxy.core

interface MessageAdapter<T> {
    fun adaptOrThrow(source: T, context: Context): Message
}