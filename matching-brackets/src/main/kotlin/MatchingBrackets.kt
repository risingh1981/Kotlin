
object MatchingBrackets {

    fun isValid(input: String): Boolean {
        var filteredInputArr = input.filter { it -> (it == '{') || (it == '}') || (it == '(') || (it == ')') || (it == '[') || (it == ']') }.split("").filter { it -> it != "" }.toMutableList()
        val bracketMap: Map<String, String> = mapOf("[" to "]","{" to "}","(" to ")")
        var valid = true
        while (rightMostOpening(filteredInputArr) != -1) {
            val idxOfRtMostOpening = rightMostOpening(filteredInputArr)
            if ((idxOfRtMostOpening >= filteredInputArr.lastIndex) || (filteredInputArr[idxOfRtMostOpening + 1] != bracketMap[filteredInputArr[idxOfRtMostOpening]])) {
                valid = false
                break
            }
            filteredInputArr.removeAt(idxOfRtMostOpening + 1)
            filteredInputArr.removeAt(idxOfRtMostOpening)
        }
        return (valid && filteredInputArr.size == 0)
    }

    private fun rightMostOpening(inputArr: MutableList<String>):Int {
        val openingList: List<String> = listOf("[","{","(")
        var maxOpeningIdx = -1
        for (idx in 0..inputArr.lastIndex) {
            if ((inputArr[idx] in openingList) && (idx > maxOpeningIdx)) {
                maxOpeningIdx = idx
            }
        }
        return maxOpeningIdx
    }

}
