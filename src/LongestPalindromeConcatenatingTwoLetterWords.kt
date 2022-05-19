import kotlin.math.min

fun longestPalindromeConcatenatingTwoLetterWords(words: Array<String>): Int {
    val wordFrequencyMap = mutableMapOf<String, Int>()
    words.forEach {
        if (wordFrequencyMap.containsKey(it)) {
            wordFrequencyMap[it] = wordFrequencyMap[it]!! + 1
        } else {
            wordFrequencyMap[it] = 1
        }
    }

    var counter = 0
    var centerPosUsed = false
    wordFrequencyMap.forEach { (word, frequency) ->
        if (frequency <= 0)
            return@forEach
        if (word[0] == word[1]) {
            if (frequency % 2 == 0) {
                counter += frequency * 2
                wordFrequencyMap[word] = 0
            } else {
                if (!centerPosUsed) {
                    counter += frequency * 2
                    centerPosUsed = true
                    wordFrequencyMap[word] = 0
                }
                else {
                    counter += (frequency - 1) * 2
                    wordFrequencyMap[word] = 1
                }

            }
            return@forEach
        }
        val reversedWord = word.reversed()
        if (wordFrequencyMap.containsKey(reversedWord) && wordFrequencyMap[reversedWord]!! > 0) {
            val reversedFreq = wordFrequencyMap[reversedWord]!!
            val repeat = min(frequency, reversedFreq)
            counter += repeat*4
            wordFrequencyMap[word] = frequency - repeat
            wordFrequencyMap[reversedWord] = reversedFreq - repeat
        }
    }

    return counter
}