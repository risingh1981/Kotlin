
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if (naturalNumber < 1) {
        throw java.lang.RuntimeException("Number is not a natural number")
    }
    return when(aliquotSum(naturalNumber)) {
        in -1 until naturalNumber ->Classification.DEFICIENT
        naturalNumber -> Classification.PERFECT
        else -> Classification.ABUNDANT
    }
}

fun aliquotSum(num: Int): Int {
    var sum = 0
    for (i in 1 until num-1) {
        if (num % i == 0) {
            sum += i
        }
    }
    return sum
}