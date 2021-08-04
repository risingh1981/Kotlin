object AffineCipher {

    private const val m = 26 // Total number of letters in alphabet: a..z

    fun encode(input: String, a: Int, b: Int): String {
        if (!areCoprime(a,m)) {
            throw IllegalArgumentException("a and m must be coprime.")
        }
        val filteredStr = removeNonAlphaNumeric(input)
        var encodedStr = ""
        var letterCounter = 1
        for (letter in filteredStr) {
            if (letterCounter == 6) {
                encodedStr = encodedStr.plus(" ")
                letterCounter = 1
            }
            if (letter in 'a'..'z') {
                encodedStr = encodedStr.plus(idxToLetter(encryptionFunction(letterIdx(letter),a,b)))
            } else {
                encodedStr = encodedStr.plus(letter)
            }

            letterCounter++
        }
        return encodedStr
    }

    fun decode(input: String, a: Int, b: Int): String {
        if (!areCoprime(a,m)) {
            throw IllegalArgumentException("a and m must be coprime.")
        }
        val filteredStr = removeNonAlphaNumeric(input)
        var decodedStr = ""
        for (letter in filteredStr) {
            if (letter in 'a'..'z') {
                decodedStr = decodedStr.plus(idxToLetter(decryptionFunction(letterIdx(letter),a,b)))
            } else {
                decodedStr = decodedStr.plus(letter)
            }
        }
        return decodedStr
    }

    private fun removeNonAlphaNumeric(input:String): String {
        return input.toLowerCase().filter { it in 'a'..'z'|| it.toInt() in 48..57 }
    }

    private fun areCoprime(a:Int, b:Int): Boolean {
        for (num in (2..min(a,b))) {
            if ((a % num == 0) && (b % num == 0)) {
                return false
            }
        }
        return true
    }

    // Returns -1 if no MMI exists
    private fun mmi(a: Int, m: Int): Int {
        var n: Int
        if (areCoprime(a,m)) {
            for (i in (1..m)) {
                if ((a * i) % m == 1) {
                    return i
                }
            }
        }
        return -1
    }

    private fun encryptionFunction(letterIndex: Int, a: Int, b:Int): Int {
        // E(x) = (ax + b) mod m where m = numbers of letters in alphabet being used(26 letters + 10 digits)
        return ((a * letterIndex) + b) % m
    }

    private fun decryptionFunction(letterIndex: Int, a: Int, b:Int): Int {
        // D(y) = a^-1(y - b) mod m, where a^-1 is MMI of a mod m. y = E(x)
        var aInverse = mmi(a,m)
        return ((aInverse * (letterIndex - b)) % m)
    }

    private fun letterIdx(char: Char): Int {
        return char.toLowerCase().toInt() - 97
    }

    private fun idxToLetter(idx: Int): Char {
        val letters = ('a'..'z').toList()
        var idxToCompute = idx
        if (idxToCompute < 0) {
            idxToCompute = (idxToCompute + m) % m
        }
        return letters[idxToCompute % m]
    }

    private fun min(a:Int, b:Int):Int {
        if (a > b) {
            return b
        } else {
            return a
        }
    }

}