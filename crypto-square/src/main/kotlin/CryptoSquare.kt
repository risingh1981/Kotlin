import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.pow
object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        var normalized = plaintext.toLowerCase().filter{ it.toInt() in 97..122 || it.toInt() in 48..57 }
        val root = normalized.length.toDouble().pow(0.5)
        var rows = floor(root).toInt()
        val cols = ceil(root).toInt()
        if (rows*cols < normalized.length) {
            rows++
        }
        var rectangle: MutableList<MutableList<Char?>> = MutableList(rows) { MutableList<Char?>(cols) {null} }
        var counter = 0
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (counter < normalized.length) {
                    rectangle[r][c] = normalized[counter]
                    counter++
                } else {
                    rectangle[r][c] = ' '
                }
            }
        }
        // Create coded message as String and Arr
        var codedArr:MutableList<String> = MutableList(cols) { "" }
        var codedStr = ""
        for (c in 0 until cols) {
            for (r in 0 until rows) {
                codedArr[c] = codedArr[c].plus(rectangle[r][c])
                if (rectangle[r][c] != ' ') {
                    codedStr = codedStr.plus(rectangle[r][c])
                }
            }
        }
        return codedArr.joinToString(" ")
    }

}