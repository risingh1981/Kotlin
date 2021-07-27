data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(val input : List<List<Int>>) {
    var rowMaxes:MutableList<Int> = ArrayList<Int>()
    var colMins:MutableList<Int> = ArrayList<Int>()
    var saddlePoints:MutableSet<MatrixCoordinate> = mutableSetOf<MatrixCoordinate>()
    init {
        if (input.isNotEmpty()) {
            rowMaxes = rowMax(input)
            colMins = colMin(input)
            saddlePoints = saddlePoint(input)
        }


    }

    private fun saddlePoint(matrix:List<List<Int>>):MutableSet<MatrixCoordinate> {
        var points:MutableSet<MatrixCoordinate> = mutableSetOf<MatrixCoordinate>()
        for (row in 0..matrix.lastIndex) {
            for (col in 0..matrix[0].lastIndex) {
                if ((matrix[row][col] >= rowMaxes[row]) && (matrix[row][col] <= colMins[col])) {
                    points.add(MatrixCoordinate(row + 1, col + 1))
                }
            }
        }
        return points
    }



    private fun rowMax(matrix:List<List<Int>>):MutableList<Int> {
        var maxes:MutableList<Int> = ArrayList<Int>()
        for (row in 0..matrix.lastIndex) {
            var max: Int = Int.MIN_VALUE
            for (col in 0..matrix[0].lastIndex) {
                if (matrix[row][col] >= max) {
                    max = matrix[row][col]
                }
            }
            maxes.add(max)
        }
        return maxes
    }

    private fun colMin(matrix:List<List<Int>>):MutableList<Int>{
        var mins:MutableList<Int> = ArrayList<Int>()

        for (col in 0..matrix[0].lastIndex) {
            var min: Int = Int.MAX_VALUE
            for (row in 0..matrix.lastIndex) {
                if (matrix[row][col] <= min) {
                    min = matrix[row][col]
                }
            }
            mins.add(min)
        }
        return mins
    }
}