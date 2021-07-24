object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {
        val lenLeft = leftStrand.length
        val lenRight = rightStrand.length
        // If left and right strand not of equal length, throw exception
        if (lenLeft != lenRight) {
            throw IllegalArgumentException("left and right strands must be of equal length")
        }
        // Iterate over strings, comparing differences and incrementing counter if differences
        // found.
        var diffCount = 0
        for (i in 0..(lenLeft - 1)) {
            if (leftStrand[i] != rightStrand[i]) {
                diffCount++
            }
        }
        return diffCount
    }

}
