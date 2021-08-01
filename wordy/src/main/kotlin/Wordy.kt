import kotlin.math.pow

object Wordy {

    fun answer(input: String): Int {
        var inputModified = input.replace("plus", "+")
        inputModified = inputModified.replace("minus", "-")
        inputModified = inputModified.replace("multiplied by", "*")
        inputModified = inputModified.replace("divided by", "/")
        inputModified = inputModified.replace("raised to the", "^")
        inputModified = inputModified.filter{ it.toInt() in 48..57 || it == ' ' || it == '-' || it == '+' || it == '/' || it == '*' || it == '^'}.trim()
        var inputArr = inputModified.split(' ').toMutableList()
        var numOps = inputArr.count { it == "-" || it == "+" || it == "/"|| it == "*"|| it == "^" }
        var numInts = inputArr.count { it.toIntOrNull() != null}
        // Throw Exception if numInts != (numOps+1) or numInts = 0 or if input contains word "cubed"
        if ((numInts != numOps + 1) || numInts == 0 || input.contains( "cubed")) {
            throw Exception("Invalid input string")
        }
        if ((numInts == 1) && (numOps == 0)) {
            return inputArr[0].toInt()
        }
        // So far we the right number of operations for amount of numbers. Check order of ops/nums next.
        // Every num should be followed by an operation and every operation by a number.
        var lastNumIdx = inputArr.size
        var lastOpsIdx = inputArr.size
        // Check that order of nums/ops is correct and calculate
        var total = 0
        for (index in 0..inputArr.lastIndex) {
            var test = inputArr[index].toIntOrNull()
            if (test == null) {
                lastOpsIdx = index
                if (lastOpsIdx != lastNumIdx + 1) {
                    throw Exception("Operation not preceded by number.")
                }
            } else {
                lastNumIdx = index
                if ((index != 0) && (lastOpsIdx + 1 != lastNumIdx)) {
                    throw Exception("Number not preceded by operation")
                }
                if (index != 0) {
                    when {
                        inputArr[lastNumIdx - 1] == "-" -> total =
                            inputArr[lastNumIdx - 2].toInt() - inputArr[lastNumIdx].toInt()
                        inputArr[lastNumIdx - 1] == "+" -> total =
                            inputArr[lastNumIdx - 2].toInt() + inputArr[lastNumIdx].toInt()
                        inputArr[lastNumIdx - 1] == "*" -> total =
                            inputArr[lastNumIdx - 2].toInt() * inputArr[lastNumIdx].toInt()
                        inputArr[lastNumIdx - 1] == "/" -> total =
                            inputArr[lastNumIdx - 2].toInt() / inputArr[lastNumIdx].toInt()
                        inputArr[lastNumIdx - 1] == "^" -> total =
                            (inputArr[lastNumIdx - 2].toInt().toDouble()).pow(inputArr[lastNumIdx].toInt()).toInt()
                    }
                    inputArr[lastNumIdx] = total.toString()
                }
            }
        }
        return inputArr[inputArr.lastIndex].toInt()
    }
}
