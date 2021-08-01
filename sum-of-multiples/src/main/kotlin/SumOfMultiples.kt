
object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        if (factors.isEmpty()) {
            return 0
        }
        var factors = factors as MutableSet
        var multiples: MutableSet<Int> = mutableSetOf()
        factors.remove(0)
        val minOfSet = min(factors)

        for (num in minOfSet!! until limit) {
            if (factors.any { num % it == 0 }) {
                multiples.add(num)
            }
        }
        return multiples.sum()
    }

    private fun min(inputSet: Set<Int>):Int {
        var min = Int.MAX_VALUE
        for (element in inputSet) {
            if (element < min) {
                min = element
            }
        }
        return min
    }
}
