
class RailFenceCipher(val fences: Int) {

    fun getEncryptedData(input: String): String {
        var listOfFences = generateFences(input.length)
        var idxCounter = 0
        while (idxCounter < input.length) {
            for (fence in listOfFences) {
                fence[idxCounter] = input[idxCounter].toString()
                idxCounter++
                if (idxCounter > input.lastIndex) {
                    break
                }
            }
            if (idxCounter > input.lastIndex) {
                break
            }
            for (fence in listOfFences.slice(1..fences - 2).reversed()) {
                fence[idxCounter] = input[idxCounter].toString()
                idxCounter++
                if (idxCounter > input.lastIndex) {
                    break
                }

            }
        }
        var finalOutput = ""

        for (fence in listOfFences){
            finalOutput = finalOutput.plus(fence.joinToString(""))
        }
        return finalOutput
    }

    fun getDecryptedData(input: String): String {
        var listOfFences = generateFences(input.length)
        var gapsMap = generateGapsMap()
        val lastIdxOfInput = input.lastIndex

        var fenceNumber = 0
        var inputIdx = 0
        while (fenceNumber <= fences - 1) {
            var gapMapIdx = 0
            var currentIdx = fenceNumber
            listOfFences[fenceNumber][currentIdx] = input[inputIdx].toString()
            while ((currentIdx <= lastIdxOfInput) && (inputIdx <= lastIdxOfInput)) {
                currentIdx += gapsMap[fenceNumber]!![gapMapIdx]
                inputIdx++
                if ((currentIdx > lastIdxOfInput) || (inputIdx > lastIdxOfInput)) {
                    break
                }
                listOfFences[fenceNumber][currentIdx] = input[inputIdx].toString()
                gapMapIdx = (gapMapIdx + 1) % 2
            }
            fenceNumber++
        }

        var finalOutputStr = ""
        var idx = 0
        while (idx<=lastIdxOfInput) {
            for (fence in listOfFences) {
                finalOutputStr = finalOutputStr.plus(fence[idx])
                idx++
                if (idx > lastIdxOfInput) {
                    break
                }
            }
            if (idx > lastIdxOfInput) {
                break
            }
            for (fenceNum in (listOfFences.lastIndex-1) downTo 1) {
                finalOutputStr = finalOutputStr.plus(listOfFences[fenceNum][idx])
                idx++
                if (idx > lastIdxOfInput) {
                    break
                }
            }
        }
        return finalOutputStr
    }

    fun generateGapsMap():MutableMap<Int,MutableList<Int>> {
        var gapsMap: MutableMap<Int,MutableList<Int>> = mutableMapOf()
        var gap1: Int; var gap2:Int
        val totalGap = fences*2 - 2
        for (fenceNum in 0 until fences) {
            gap1 = totalGap - fenceNum*2
            gap2 = totalGap - gap1
            if ((gap1 == 0) || (gap2 == 0)) {
                gap1 = totalGap
                gap2 = totalGap
            }
            gapsMap[fenceNum] = mutableListOf<Int>(gap1,gap2)
        }
        return gapsMap
    }

    fun generateFences(length: Int): MutableList<MutableList<String>> {
        var listOfFences: MutableList<MutableList<String>> = mutableListOf()
        for (fence in 1..fences) {
            listOfFences.add(generateMutableList(length, ""))
        }
        return listOfFences
    }

    fun <T> generateMutableList(size: Int, value: T): MutableList<T> {
        return (1..size).map { value }.toMutableList()
    }
}

