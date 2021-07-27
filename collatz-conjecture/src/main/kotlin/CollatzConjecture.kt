object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        var steps = 0
        var value = start
        if (value < 1) {
            throw java.lang.IllegalArgumentException("Number cannot be less than 1")
        } else {
            while (value > 1) {
                if (value % 2 == 0) {
                    value /= 2
                } else {
                    value = (3 * value) + 1
                }
                steps += 1
            }
        }
        return steps
    }
}