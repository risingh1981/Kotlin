class Forth {

    private var operationsMap: MutableMap<String, String> = mutableMapOf("+" to "+", "-" to "-", "*" to "*", "/" to "/", "dup" to "dup","drop" to "drop", "swap" to "swap", "over" to "over")

    fun evaluate(vararg line: String): MutableList<Int> {
        var commandsArr: MutableList<String> = line.toMutableList()
        commandsArr = commandsArr.map { it.toLowerCase() }.toMutableList()
        var commandArr:MutableList<String> = mutableListOf()
        for (command in commandsArr) {
            commandArr = command.split(' ').toMutableList()
            if (commandArr[0] == ":") {
                createUserType(commandArr)
            } else {
                for (index in 0..commandArr.lastIndex) {
                    if (commandArr[index] in operationsMap.keys) {
                        commandArr[index] = operationsMap[commandArr[index]].toString()
                    }
                }
            }

        }
        var finalCommand = commandArr.joinToString(" ")
        return determineCommand(finalCommand)
    }


    private fun determineCommand(finalCommand: String):MutableList<Int> {
        var outputList: MutableList<Int> = mutableListOf<Int>()
        var splitCommandArr = finalCommand.split(" ")
        if (splitCommandArr.any { it in operationsMap}) {
            for (ele in splitCommandArr) {
                if (ele.toIntOrNull() != null) {
                    outputList.add(ele.toInt())
                } else {
                    when (ele){
                        "+"-> outputList = plus(outputList)
                        "-" -> outputList = minus(outputList)
                        "*" -> outputList = multiply(outputList)
                        "/" -> outputList = divide(outputList)
                        "dup" -> outputList = dup(outputList)
                        "drop" -> outputList = drop(outputList)
                        "swap" -> outputList = swap(outputList)
                        "over" -> outputList = over(outputList)
                    }
                }
            }
        } else if (splitCommandArr.all { it.toIntOrNull() != null}) {
            outputList = splitCommandArr.map(String::toInt).toMutableList<Int>()
        }
        return outputList
    }

    private fun plus(outputList: MutableList<Int>):MutableList<Int> {
        var outputList = outputList.toMutableList<Int>()
        when (outputList.size) {
            1 -> throw Exception("only one value on stack")
            0 -> throw Exception("empty stack")
            else -> {var result = outputList[outputList.size - 1] + outputList[outputList.size - 2]; outputList =
                outputList.dropLast(2).toMutableList<Int>(); outputList.add(result) }
        }
        return outputList
    }
    private fun minus(outputList: MutableList<Int>):MutableList<Int> {
        var outputList = outputList.toMutableList<Int>()
        when (outputList.size) {
            1 -> throw Exception("only one value on stack")
            0 -> throw Exception("empty stack")
            else -> {var result = outputList[outputList.size - 2] - outputList[outputList.size - 1]; outputList =
                outputList.dropLast(2).toMutableList<Int>(); outputList.add(result) }
        }
        return outputList
    }
    private fun divide(outputList: MutableList<Int>):MutableList<Int> {
        var outputList = outputList.toMutableList<Int>()
        if (outputList[outputList.size - 1] == 0) {
            throw Exception("divide by zero")
        }
        when (outputList.size) {
            1 -> throw Exception("only one value on stack")
            0 -> throw Exception("empty stack")
            else -> {var result = outputList[outputList.size - 2] / outputList[outputList.size - 1]; outputList =
                outputList.dropLast(2).toMutableList<Int>(); outputList.add(result) }
        }
        return outputList
    }
    private fun multiply(outputList: MutableList<Int>):MutableList<Int> {
        var outputList = outputList.toMutableList<Int>()
        when (outputList.size) {
            1 -> throw Exception("only one value on the stack")
            0 -> throw Exception("empty stack")
            else -> {var result = outputList[outputList.size - 2] * outputList[outputList.size - 1]; outputList =
                outputList.dropLast(2).toMutableList<Int>(); outputList.add(result) }
        }
        return outputList
    }
    private fun dup(outputList: MutableList<Int>):MutableList<Int> {
        var outputList = outputList.toMutableList<Int>()
        when (outputList.size) {
            0 -> throw Exception("empty stack")
            else -> { outputList.add(outputList.last()) }
        }
        return outputList
    }
    private fun drop(outputList: MutableList<Int>):MutableList<Int> {
        var outputList = outputList.toMutableList<Int>()
        when (outputList.size) {
            0 -> throw Exception("empty stack")
            else ->  return outputList.dropLast(1).toMutableList<Int>()
        }
    }
    private fun swap(outputList: MutableList<Int>):MutableList<Int> {
        var outputList = outputList.toMutableList<Int>()
        when (outputList.size) {
            0 -> throw Exception("empty stack")
            1 -> throw Exception("only one value on the stack")
            else -> outputList[outputList.size - 1] = outputList[outputList.size - 2].also { outputList[outputList.size - 2] = outputList[outputList.size - 1] }
        }
        return outputList
    }
    private fun over(outputList: MutableList<Int>):MutableList<Int> {
        var outputList = outputList.toMutableList<Int>()
        when (outputList.size) {
            0 -> throw Exception("empty stack")
            1 -> throw Exception("only one value on the stack")
            else -> outputList.add(outputList[outputList.lastIndex - 1])
        }
        return outputList
    }



    private fun createUserType(commandArr:MutableList<String>) {
        if (commandArr[1].toIntOrNull() != null) {
            throw Exception("illegal operation")
        }
        for (i in 2..commandArr.lastIndex){
            if (commandArr[i] in operationsMap) {
                commandArr[i] = operationsMap[commandArr[i]].toString()
            }
        }
        operationsMap[commandArr[1]] = commandArr.slice(2 until commandArr.lastIndex).joinToString(" ")
    }
}