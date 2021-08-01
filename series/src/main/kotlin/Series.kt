
object Series {

    fun slices(n: Int, s: String): List<List<Int>> {
        if ((n < 1) || (n > s.length) || (s.isEmpty())) {
            throw IllegalArgumentException("Invalid input parameters.")
        }
        val windows = s.windowed(n)
        var listOfSlices = mutableListOf<List<Int>>()
        for (window in windows) {
            listOfSlices.add(window.map { it.toString().toInt() }.toList())
        }
        return listOfSlices
    }
}
