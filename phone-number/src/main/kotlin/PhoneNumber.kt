class PhoneNumber (var input: String) {

    init {
        input = format(input)
    }

    val number: String? = input

    fun format(original: String): String {
        if (original.any { (it.toInt() !in 48..57) && (it != '-') && (it != '.') && (it != ' ') && (it != '(') && (it != ')') && (it != '+')}) {
            throw IllegalArgumentException("Input contains symbols other than digits, SPACE, '-', '.', '(', ')', and '+'.")
        }
        var toModify = original.filter { it.toInt() in 48..57 }
        if ((toModify.length > 11) || (toModify.length < 10)) {
            throw IllegalArgumentException("Number can't contain > 11 or < 10 digits.")
        } else if ((toModify.length == 11) && (toModify[0] != '1')) {
            throw IllegalArgumentException("Number can only have 1 as country code")
        }
        // If Number has country code, remove it.
        if (toModify.length == 11) {
            toModify = toModify.drop(1)
        }
        println("In function, toModify:$toModify")
        if ((toModify[0].toString().toInt() !in 2..9) || (toModify[3].toString().toInt() !in 2..9)) {
            throw IllegalArgumentException("Area code and exchange code can't start with 0 or 1.")
        }

        return toModify
    }
}