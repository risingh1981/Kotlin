object Isogram {

    fun isIsogram(input: String): Boolean {
        val re1 = "-| ".toRegex()
        var wordMinusSpaceHyphen = re1.replace(input, "")
        var wordSet = wordMinusSpaceHyphen.toLowerCase().toSet()
        return (wordMinusSpaceHyphen.length == wordSet.size)
    }
}
