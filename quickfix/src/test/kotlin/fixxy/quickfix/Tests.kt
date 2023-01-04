package fixxy.quickfix

import quickfix.DefaultDataDictionaryProvider
import quickfix.DefaultMessageFactory
import quickfix.MessageUtils.parse

object Tests {

  const val Kotlin = "[ Kotlin ]"
  const val Java = "[ Java ]"

  @JvmStatic
  fun quickFixMessageFromPipeDelimited(pipeDelimitedFixMessage: String) =
    pipeDelimitedFixMessage.replace('|', Char(1), false)

  @JvmStatic
  fun quickFixMessage(quickFixVersion: QuickFixVersion, pipeDelimitedFixMessage: String): quickfix.Message {
    val messageFactory = DefaultMessageFactory()
    val dictionaryProvider = DefaultDataDictionaryProvider()
    val dictionary = dictionaryProvider.getApplicationDataDictionary(quickFixVersion.applVerID())
    val messageString = quickFixMessageFromPipeDelimited(pipeDelimitedFixMessage)
    return parse(messageFactory, dictionary, messageString)
  }
}