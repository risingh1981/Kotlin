import java.lang.IllegalArgumentException
import kotlin.math.ln
import kotlin.math.pow

object Prime {
    // nth prime number(pn) is close to n*ln(n) (and closer when n is very large)
    fun nth(n: Int): Int {
        if (n == 0) {
            throw IllegalArgumentException("There is no zeroth prime.")
        }
        val apprxValOfNthPrime = (2 * n * ln(n.toDouble()) + 100).toInt()

        val primeArr = sieve(apprxValOfNthPrime)
        return primeArr[n-1]
    }

    fun sieve(end: Int): List<Int> {
        var rangeArr = generate(end, true)
        rangeArr[0] = false
        rangeArr[1] = false
        for (num in 2..end.toDouble().pow(0.5).toInt()) {
            for (multiplier in num..end / num) {
                rangeArr[num * multiplier] = false
            }
        }
        var primeArr = mutableListOf<Int>()
        rangeArr.forEachIndexed { index, b -> if (b) { primeArr.add(index) } }
        return primeArr
    }


    fun <T> generate(upperBound: Int, value:T): MutableList<T> {
        return (0..upperBound).map { value }.toMutableList()
    }
}


