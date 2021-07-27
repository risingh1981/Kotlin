object Atbash {

    fun encode(s: String): String{
        var cipherText = ""
        var counter = 0
        var lengthCounter = 1
        for (letter in s) {
            lengthCounter++
            if ((letter.toInt() in 65..90) || (letter.toInt() in 97..122) || (letter.toInt() in 48..57)) {
                cipherText = cipherText.plus(rotateEncrypt(letter))
                counter++
            } else {
                continue
            }
            if (counter % 5 == 0 && counter != 0 && lengthCounter != s.length) {
                cipherText = cipherText.plus(" ")
            }
        }
        return cipherText
    }

    private fun rotateEncrypt(char: Char): Char {
        val keyLC = "zyxwvutsrqponmlkjihgfedcba"

        return when (val ascii = char.toInt()) {
            in 65..90 -> keyLC[(ascii - 65)]
            in 97..122 -> keyLC[(ascii - 97)]
            else -> char
        }
    }

    fun decode(s: String): String{
        val plain = "abcdefghijklmnopqrstuvwxyz"
        val cipher = "zyxwvutsrqponmlkjihgfedcba"
        var decodedPlain = ""
        for (char in s) {
            if (char.toInt() in 97..122) {
                decodedPlain = decodedPlain.plus(plain[cipher.indexOf(char)])
            } else if (char.toInt() in 48..57) {
                decodedPlain = decodedPlain.plus(char)
            }
            else {
                continue
            }
        }
        return decodedPlain
    }
}