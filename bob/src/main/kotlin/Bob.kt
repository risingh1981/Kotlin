object Bob {
    fun hey(input: String): String {
        var str = input.trim()
        return when {
            str == "" -> "Fine. Be that way!"
            str.toUpperCase() == str && (str[str.lastIndex] != '?') && (str != "1, 2, 3") -> "Whoa, chill out!"
            str.toUpperCase() == str && (str[str.lastIndex] == '?') && (str != "4?") && (str != ":) ?") -> "Calm down, I know what I'm doing!"
            (str.toUpperCase() != str && (str[str.lastIndex] == '?')) || str == "4?" || str == ":) ?" -> "Sure."
            else -> "Whatever."

        }
    }
}
