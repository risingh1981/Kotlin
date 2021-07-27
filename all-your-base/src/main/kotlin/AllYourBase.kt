import kotlin.math.pow



class BaseConverter (val base: Int, val digits: IntArray){
    init {
        when {
            base < 2 -> throw IllegalArgumentException("Bases must be at least 2.")
            digits.isEmpty() -> throw IllegalArgumentException("You must supply at least one digit.")
            digits[0] == 0 && digits.size > 1 -> throw IllegalArgumentException("Digits may not contain leading zeros.")
            min(digits) < 0 -> throw IllegalArgumentException("Digits may not be negative.")
            max(digits) >= base -> throw IllegalArgumentException("All digits must be strictly less than the base.")
        }
    }

    fun min(arr:IntArray):Int {
        var min = Int.MAX_VALUE
        for (ele in arr) {
            if (ele < min) {
                min = ele
            }
        }
        return min
    }

    fun max(arr: IntArray):Int {
        var max = Int.MIN_VALUE
        for (ele in arr) {
            if (ele > max) {
                max = ele
            }
        }
        return max
    }

    fun convertToBase(newBase: Int): IntArray {
        if (newBase < 2) {
            throw IllegalArgumentException("Bases must be at least 2.")
        }
        var base10 = convertTo10()
        println("base10: $base10")
        var newDigits = mutableListOf<Int>()
        var rem: Int = 0
        if (base10 == 0) {
            newDigits.add(0)
        }
        while (base10 != 0) {
            rem = base10 % newBase
            base10 /= newBase
            newDigits.add(rem)
        }
        newDigits.reverse()
        println("newDigits: $newDigits")

        return newDigits.toIntArray()
    }

    fun convertTo10():Int {
        var value: Int = 0

        digits.forEachIndexed { i, e -> value += (e * (base.toDouble()).pow(digits.lastIndex - i)).toInt() }

        println("In convTo10, value of value: $value")

        return value


    }
}