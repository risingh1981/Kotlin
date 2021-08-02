object PascalsTriangle {

    fun computeTriangle(rows: Int): List<List<Int>> {
        var triangle: MutableList<MutableList<Int>> = mutableListOf()
        for (row in 0 until rows) {
            var listRow: MutableList<Int> = mutableListOf()
            listRow.add(1)
            for (col in 1 until row) {
                listRow.add(triangle[row-1][col - 1] + triangle[row-1][col])
            }
            if (row != 0) {
                listRow.add(1)
            }
            triangle.add(listRow)
        }
        return triangle.toList()
    }
}
