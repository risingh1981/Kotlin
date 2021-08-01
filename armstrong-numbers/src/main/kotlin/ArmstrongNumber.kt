import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        var digits = input.toString().length
        var num = input

        var sum = 0.0
        while (num > 0) {
            val r = num % 10
            sum += r.toDouble().pow(digits)
            num /= 10
        }
        return (sum.toInt() == input)
    }
}