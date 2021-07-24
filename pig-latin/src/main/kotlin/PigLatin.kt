object PigLatin {

    fun translate(phrase: String): String {
        var words = phrase.split(" ")
        var pigLatinArr = listOf<String>()
        val vowels = "a|e|i|o|u|y".toRegex()
        for(word in words) {
            if (word.substring(0,2) == "xr" || word.substring(0,2) == "yt") {
                pigLatinArr += word + "ay"
                continue
            }
            try {
                val match = vowels.find(word)!!
                val startIdx = match.range.first
                if (match.value == "u" && startIdx != 0 && word[startIdx-1] == 'q') {
                    var newWord = word.substring(startIdx + 1) + word.substring(0,startIdx+1) + "ay"
                    pigLatinArr += newWord
                } else if (match.value == "y" && startIdx != 0) {
                    var newWord = word.substring(startIdx) + word.substring(0, startIdx) + "ay"
                    pigLatinArr += newWord
                } else if (match.value == "y" && startIdx == 0) {
                    var newWord = word.substring(startIdx + 1) + word[startIdx] + "ay"
                    pigLatinArr += newWord
                } else {
                    var newWord = word.substring(startIdx) + word.substring(0,startIdx) + "ay"
                    pigLatinArr += newWord
                }
            } catch (exception: NullPointerException) {
                // None of letters in Regex found.
                pigLatinArr += word
                continue
            }
        }
        return pigLatinArr.joinToString(separator = " ")
    }
}
