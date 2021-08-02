
object PrimeFactorCalculator {

    fun primeFactors(int: Int): List<Int> {
        var decrementVal = int
        var factorsList = mutableListOf<Int>()
        for (num in 2..int) {
            while (decrementVal % num == 0) {
                factorsList.add(num)
                decrementVal /= num
            }
            if (num>decrementVal) {
                break
            }
        }
        println(factorsList)
        return factorsList
    }

    fun primeFactors(long: Long): List<Long> {
        var decrementVal = long
        var factorsList = mutableListOf<Long>()
        for (num in 2..long) {
            while (decrementVal % num == 0.toLong()) {
                factorsList.add(num)
                decrementVal /= num
            }
            if (num > decrementVal) {
                break
            }
        }
        return factorsList
    }
}
