import java.math.BigInteger


object Board {

    private val TWO = BigInteger.TWO

    fun getGrainCountForSquare(number: Int): BigInteger {
        if (number < 1 || number > 64) {
            throw java.lang.IllegalArgumentException("Number of square out-of-range")
        }
        return TWO.pow((number - 1))

    }

    fun getTotalGrainCount(): BigInteger {
        var sum = BigInteger.ZERO
        for (i in 1..64) {
            sum = sum.plus(getGrainCountForSquare(i))
        }
        return sum
    }
}