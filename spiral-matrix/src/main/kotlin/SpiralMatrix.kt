object SpiralMatrix {

    fun ofSize(size: Int): Array<IntArray> {
        var matrix = Array<IntArray>(size) { (IntArray(size) { 0 }) }
        var counter = 1
        var layer = 0
        var dim = size
        while (counter != size * size + 1) {
            for (i in layer until dim) {
                matrix[layer][i] = counter
                counter++
            }
            for (j in layer + 1 until dim) {
                matrix[j][dim - 1] = counter
                counter++
            }
            for (r in dim - 2 downTo layer) {
                matrix[dim - 1][r] = counter
                counter++
            }
            for (p in dim - 2 downTo layer+1) {
                matrix[p][layer] = counter
                counter++
            }
            layer++
            dim--

        }
        return matrix

    }
}

