import kotlin.math.max
import kotlin.math.min

data class MinesweeperBoard(val inputBoard: List<String>) {

    fun withNumbers(): List<String> {
        if (inputBoard.isEmpty()){
            return inputBoard
        }
        val width = inputBoard[0].lastIndex
        val height = inputBoard.lastIndex
        // Create a List of Lists of inputBoard
        var boardList = MutableList(height + 1) { MutableList<Int>(width + 1) { 0 } }

        for (row in 0..height) {
            for (col in 0..width) {
                if (inputBoard[row][col] == '*') {
                    boardList[row][col] = -1
                }
            }
        }

        for (row in 0..height) {
            for (col in 0..width) {
                if (boardList[row][col] == -1) {
                    for (i in max(0, row - 1)..min(height, row + 1)) {
                        for (j in max(0, col - 1)..min(width, col + 1)) {
                            if (boardList[i][j] != -1) {
                                boardList[i][j] += 1
                            }
                        }
                    }
                }

            }
        }
        var expectedBoard = mutableListOf<String>()
        for (row in 0..height) {
            var toAdd = ""
            for (col in 0..width) {
                if (boardList[row][col] == -1) {
                    toAdd = toAdd.plus("*")
                } else if (boardList[row][col] == 0) {
                    toAdd = toAdd.plus(" ")
                } else {
                    toAdd = toAdd.plus("${boardList[row][col]}")
                }
            }
            expectedBoard.add(toAdd)
        }

        return expectedBoard
    }


}
