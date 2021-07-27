class RotationalCipher(private val rotIndex: Int) {

    fun encode(text: String): String {
        var cipher = ""
        for (letter in text) {
            cipher = cipher.plus(rotate(letter,rotIndex))
        }
        return cipher
    }

    private fun rotate(char: Char, rotIndex:Int): Char {
        return when (val ascii = char.toInt()) {
            in 65..90 -> ((((ascii - 65) + (rotIndex % 26)) % 26) + 65).toChar()
            in 97..122 -> ((((ascii - 97) + (rotIndex % 26)) % 26) + 97).toChar()
            else -> char
        }
    }
}

