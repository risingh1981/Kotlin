class Series(val input:String) {
    init {
        if (input.any { (it.toInt() !in 48..57) }) {
            throw IllegalArgumentException("Input string contains non-digits")
        }
    }

    fun getLargestProduct(span: Int): Long {
        if (span == 0) {
            return 1
        } else if (span > input.length) {
            throw IllegalArgumentException("Span > Length of input string")
        }
        var windows = input.windowed(span)
        var max = 0
        windows.forEach { if(it.fold(1) { acc, c -> acc * c.toString().toInt() } > max) { max = it.fold(1) { acc, c -> acc * c.toString().toInt() }}}

        return max
    }
}