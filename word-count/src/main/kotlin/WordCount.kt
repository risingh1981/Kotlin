object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        var dict: MutableMap<String, Int> = mutableMapOf<String, Int>()
        val phraseArr = phrase.toLowerCase().split(" ","\n",".","' ",":",",","!","&","@","$","%","^").filter { it != "" }

        for (word in phraseArr) {
            var wordCheck = word
            if (wordCheck[0] == '\'') {
                wordCheck = wordCheck.drop(1)
            }
            if (wordCheck[wordCheck.lastIndex] == '\'') {
                wordCheck = wordCheck.dropLast(1)
            }
            if (wordCheck in dict.keys) {
                dict[wordCheck] = 1 + dict[wordCheck]!!
            } else {
                dict[wordCheck] = 1
            }
        }

        return dict
    }
}
