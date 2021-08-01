object RunLengthEncoding {

    fun encode(input: String): String {

        if (input.isBlank()){
            return input
        }
        // Just add an additional last character to input that is different form the actual last character.
        var input = input.plus((input[input.lastIndex].toInt()+1).toChar())
        var counter = 0
        var lastChar = input[0]
        var encodedStr: String = ""
        for (charIdx in 0..input.lastIndex) {
            if ((input[charIdx] != lastChar)) {
                if (counter == 1) {
                    encodedStr = encodedStr.plus(lastChar)
                    counter = 0
                } else {
                    encodedStr = encodedStr.plus("${counter}${lastChar}")
                    counter = 0
                }
            }
            lastChar = input[charIdx]
            counter++
        }
        return encodedStr
    }

    fun decode(input: String): String {
        var numStr: String = ""
        var decoded: String = ""
        for (charIdx in 0..input.lastIndex){
            if (input[charIdx].toInt() in 48..57) {
                numStr = numStr.plus(input[charIdx])
            } else {
                var value = if (numStr == "") {
                    1
                } else {
                    numStr.toInt()
                }
                decoded = decoded.plus(input[charIdx].toString().repeat(value))
                numStr = ""
            }
        }
        return decoded
    }
}
