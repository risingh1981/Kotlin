object Luhn {

    fun isValid(candidate: String): Boolean {
        val revCandidate = candidate.reversed()
        var revCandArr = revCandidate.map {
            if (it.toInt() in 48..57) {
                it
            } else if (it == ' ' ) {
                ""
            } else {
                return false
            }
        }.filter { it != "" }
        if (revCandArr.size <= 1){ return false}
        println(revCandArr)
        var sum: Int = 0
        for ((index, ele) in revCandArr.withIndex()) {
            sum += if (index % 2 == 0) {
                ele.toString().toInt()
            } else {
                var double = ele.toString().toInt() * 2
                if (double > 9) {
                    (double - 9)
                } else {
                    double
                }
            }
        }
        return (sum % 10 == 0)
    }
}
