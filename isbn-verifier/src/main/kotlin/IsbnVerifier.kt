class IsbnVerifier {

    fun isValid(number: String): Boolean {
        var toModify = number.map{ if((it.toInt() in 48..57) || (it == 'X')) { it } else { "" } }.filter { it != "" }
        // Verify there are 10 chars
        if (toModify.size != 10) {
            println("size != 10")
            return false
        }
        // Check if letters appear any where except last spot.
        toModify.forEachIndexed{ i, v -> if ((v == 'X') && (i != 9)) { return false} }
        // Check that last char is a digit or 'X'
        if ((toModify[9] != 'X') && (toModify[9].toString().toInt() !in 0..9)) {
            return false
        }
        // Calculate product sum of ISBN
        var sum = 0
        toModify.forEachIndexed{ i, v -> if (v != 'X') {sum += (10-i) * v.toString().toInt()} else { sum += 10 } }

        return (sum % 11 == 0)
    }
}