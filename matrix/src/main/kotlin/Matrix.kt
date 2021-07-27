
class Matrix(private val matrixAsString: String) {

    fun column(colNr: Int): List<Int> {
        var matrixList = this.convertToList()
        var colResult = MutableList(matrixList.size) { 0 }
        for (row in 0..matrixList.lastIndex) {
            colResult[row] = matrixList[row][colNr - 1]
        }

        return colResult
    }

    fun row(rowNr: Int): List<Int> {
        var matrixList = this.convertToList()
        var rowResult = MutableList(matrixList[0].size) { 0 }
        for (col in 0..matrixList[0].lastIndex) {
            rowResult[col] = matrixList[rowNr - 1][col]
        }

        return rowResult
    }

    fun convertToList(): MutableList<MutableList<Int>> {
        var matrixList = this.matrixAsString.split("\n")
        var widthRowSize = matrixList[0].split(" ").filter{ it != ""}.size
        var matrixListB = MutableList(matrixList.size) { MutableList<Int>(widthRowSize) { 0 } }

        var indexRow = 0
        for (row in matrixList) {
            val rowList = row.split(" ").filter{ it != ""}
            var indexCol = 0
            for (ele in rowList) {
                matrixListB[indexRow][indexCol] = ele.toInt()
                indexCol += 1
            }
            indexRow += 1
        }

        return matrixListB
    }
}