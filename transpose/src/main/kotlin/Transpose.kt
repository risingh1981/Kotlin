object Transpose {

    fun transpose(input: List<String>): List<String> {
        if (input.isEmpty()) {
            return input
        }
        var maxStrLen = 0
        input.forEach{ if (it.length>maxStrLen) { maxStrLen = it.length } }
        println(maxStrLen)
        var newList = mutableListOf<List<Char>>()
        for (phrase in input) {
            var subList = mutableListOf<Char>()
            for (i in 0 until maxStrLen) {
                if (i > phrase.lastIndex) {
                    subList.add(' ')
                } else {
                    subList.add(phrase[i])
                }
            }
            newList.add(subList)
        }

        var transposeList:MutableList<MutableList<Char>> = mutableListOf<MutableList<Char>>()
        for (col in 0..newList[0].lastIndex) {
            var subList:MutableList<Char> = mutableListOf<Char>()
            for (row in 0..newList.lastIndex) {
                subList.add(newList[row][col])
            }
            transposeList.add(subList)
        }
        for (subL in 0..transposeList.lastIndex) {
            for (phraseIdx in transposeList[0].lastIndex downTo 0) {
                var nonSpaceIdx = transposeList[subL].lastIndex
                for (rev in transposeList[subL].lastIndex downTo 0) {
                    if (transposeList[subL][rev] != ' ') {
                        nonSpaceIdx = rev
                        break
                    }
                }
                if ((transposeList[subL][phraseIdx] == ' ') && (subL > input[phraseIdx].lastIndex) && (phraseIdx > nonSpaceIdx)) {
                    transposeList[subL].removeAt(phraseIdx)
                }
            }
        }
        var finalList: MutableList<String> = mutableListOf()
        for (subL in transposeList) {
            finalList.add(subL.joinToString(separator = ""))
        }
        return finalList

    }
}
