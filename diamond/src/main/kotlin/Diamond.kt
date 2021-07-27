class DiamondPrinter {

    fun printToList(letter: Char):List<String> {
        var diamond = mutableListOf<String>()

        var finalNum = letter.toInt() - 64
        var letNum = 0
        var mid = 0
        while (letNum != finalNum) {
            var str = ""
            if (letNum == 0) {
                str = str.plus(" ".repeat(finalNum - letNum - 1)).plus((letNum + 65).toChar()).plus(" ".repeat(finalNum - letNum - 1))
            } else {
                str = str.plus(" ".repeat(finalNum - letNum - 1)).plus((letNum + 65).toChar()).plus(" ".repeat(mid))
                    .plus((letNum + 65).toChar()).plus(" ".repeat(finalNum - letNum - 1))
            }
            if (mid >= 1) {
                mid += 2
            } else {
                mid += 1
            }
            letNum++
            diamond.add(str)
        }
        letNum = finalNum - 2
        mid = (finalNum * 2) - 5
        while (letNum != -1) {
            var str = ""
            if (letNum == 0) {
                str = str.plus(" ".repeat(finalNum - letNum - 1)).plus((letNum + 65).toChar()).plus(" ".repeat(finalNum - letNum - 1))
            } else {
                str = str.plus(" ".repeat(finalNum - letNum - 1)).plus((letNum + 65).toChar()).plus(" ".repeat(mid))
                    .plus((letNum + 65).toChar()).plus(" ".repeat(finalNum - letNum - 1))
            }
            if (mid <= 1) {
                mid -= 1
            } else {
                mid -= 2
            }
            letNum--
            diamond.add(str)
        }

        return diamond
    }



}
