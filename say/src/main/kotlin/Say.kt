class NumberSpeller {

    fun say(input: Long): String {
        if ((input < 0) || (input >= 1000000000000)) {
            throw IllegalArgumentException("Number out of range.")
        }
        return lessThan1000000000000(input)
    }

    private fun lessThan1000000000000(less1000000000000: Long): String {
        val billions = less1000000000000 / 1000000000
        val rem = less1000000000000 % 1000000000
        if ((billions >= 1) && (rem > 0)) {
            return "${lessThan1000000000(billions)} billion ${lessThan1000000000(rem)}"
        } else if ((billions == 0.toLong()) && (rem > 0)) {
            return "${lessThan1000000000(rem)}"
        } else if ((billions >= 1) && (rem == 0.toLong())){
            return "${lessThan1000000000(billions)} billion"
        } else {
            return "zero"
        }
    }

    private fun lessThan1000000000(less1000000000: Long): String {
        val millions = less1000000000 / 1000000
        val rem = less1000000000 % 1000000
        if ((millions >= 1) && (rem > 0)) {
            return "${lessThan1000000(millions)} million ${lessThan1000000(rem)}"
        } else if ((millions == 0.toLong()) && (rem > 0)) {
            return "${lessThan1000000(rem)}"
        } else {
            return "${lessThan1000000(millions)} million"
        }
    }

    private fun lessThan1000000(less1000000: Long): String {
        val thousands = less1000000 / 1000
        val rem = less1000000 % 1000
        if ((thousands >= 1) && (rem > 0)) {
            return "${lessThan1000(thousands)} thousand ${lessThan1000(rem)}"
        } else if ((thousands == 0.toLong()) && (rem > 0)) {
            return "${lessThan1000(rem)}"
        } else {
            return "${lessThan1000(thousands)} thousand"
        }
    }

    private fun lessThan1000(less1000: Long): String {
        val hundreds = less1000 / 100
        val rem = less1000 % 100
        if ((hundreds >= 1) && (rem > 0)) {
            return "${lessThan20(hundreds)} hundred ${lessThan100(rem)}"
        } else if ((hundreds == 0.toLong()) && (rem > 0)) {
            return "${lessThan100(rem)}"
        } else {
            return "${lessThan20(hundreds)} hundred"
        }
    }

    private fun lessThan100(less100: Long): String {
        val listOfTens = listOf("","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety")
        val tens = less100 / 10
        val rem = less100 % 10
        if (tens < 2) {
            return lessThan20(less100)
        } else if (rem == 0.toLong()){
            return listOfTens[tens.toInt()]
        } else {
            return listOfTens[tens.toInt()] + "-" + lessThan20(rem)
        }

    }

    private fun lessThan20(less20: Long):String {
        val less20List = listOf("zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen")
        return less20List[less20.toInt()]
    }
}

