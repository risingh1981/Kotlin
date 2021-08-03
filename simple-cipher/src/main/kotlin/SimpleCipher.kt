data class Cipher(var initialKey: String? = null) {
    var key: String
    init {
        if (initialKey == null) {
            val length = 100
            val charPool : List<Char> = ('a'..'z').toList()
            key = (1..length)
                .map { _ -> kotlin.random.Random.nextInt(0, charPool.size) }
                .map(charPool::get)
                .joinToString("")
        } else if ((initialKey == "") || (initialKey!!.filter { it in 'a'..'z' }.length != initialKey!!.length)) {
            throw IllegalArgumentException("Unacceptable key.")
        } else {
            key = initialKey as String
        }
    }

    fun generateKey():String {
        val length = 100
        val charPool : List<Char> = ('a'..'z').toList()
        var tempKey = (1..length)
            .map { _ -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")
        return tempKey
    }

    fun encode(s: String): String {
        var encodedString: String = ""
        s.forEachIndexed { index, c -> encodedString = encodedString.plus(rotate(c,rotAmount(key[index % key.length]))) }
        return encodedString
    }

    fun decode(s: String): String {
        var decodedString: String = ""
        s.forEachIndexed { index, c -> decodedString = decodedString.plus(rotate(c,-rotAmount(key[index % key.length]))) }
        return decodedString
    }

    private fun rotAmount(char: Char): Int {
        return char.toLowerCase().toInt() - 97
    }

    private fun rotate(char: Char, rotIndex:Int): Char {
        var rotIndex2 = rotIndex
        if (rotIndex < 0) {
            rotIndex2 = rotIndex + 26
        }
        return when (val ascii = char.toInt()) {
            in 65..90 -> ((((ascii - 65) + (rotIndex2 % 26)) % 26) + 65).toChar()
            in 97..122 -> ((((ascii - 97) + (rotIndex2 % 26)) % 26) + 97).toChar()
            else -> char
        }
    }
}