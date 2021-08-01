object RomanNumerals {

    fun value(n: Int): String {
        var romanNumStr = ""
        var tracker = n
        while (tracker != 0) {
            when {
                tracker >= 1000 -> { romanNumStr = romanNumStr.plus('M'); tracker -= 1000}
                tracker >= 900 -> { romanNumStr = romanNumStr.plus("CM"); tracker -= 900 }
                tracker >= 500 -> { romanNumStr = romanNumStr.plus('D'); tracker -= 500}
                tracker >= 400 -> { romanNumStr = romanNumStr.plus("CD"); tracker -= 400 }
                tracker >= 100 -> { romanNumStr = romanNumStr.plus('C'); tracker -= 100}
                tracker >= 90 -> { romanNumStr = romanNumStr.plus("XC"); tracker -= 90 }
                tracker >= 50 -> { romanNumStr = romanNumStr.plus('L'); tracker -= 50}
                tracker >= 40 -> { romanNumStr = romanNumStr.plus("XL"); tracker -= 40 }
                tracker >= 10 -> { romanNumStr = romanNumStr.plus('X'); tracker -= 10}
                tracker >= 9 -> { romanNumStr = romanNumStr.plus("IX"); tracker -= 9 }
                tracker >= 5 -> { romanNumStr = romanNumStr.plus('V'); tracker -= 5}
                tracker >= 4 -> { romanNumStr = romanNumStr.plus("IV"); tracker -= 4 }
                else -> { romanNumStr = romanNumStr.plus('I'); tracker -= 1}
            }
        }
        return romanNumStr
    }
}