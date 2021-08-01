
import kotlin.math.pow

object Sieve {

    fun primesUpTo(upperBound: Int): List<Int> {
        var rangeList: MutableList<Boolean> = generate(upperBound, true)
        rangeList[0] = false
        rangeList[1] = false
        var currentVal = 2
        while(currentVal < upperBound.toDouble().pow(0.5)) {
            for (i in currentVal..(upperBound/currentVal)) {
                rangeList[currentVal * i] = false
            }
            currentVal++
            while (!rangeList[currentVal]) {
                currentVal++
            }
        }
        var primeList = ArrayList<Int>()
        rangeList.forEachIndexed { i, v -> if (v) { primeList.add(i) } }

        return primeList
    }
    private fun <T> generate(size: Int, value: T):MutableList<T> {
        return (0..size).map { value }.toMutableList()
    }
}