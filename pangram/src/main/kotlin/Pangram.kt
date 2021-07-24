object Pangram {

    fun isPangram(input: String): Boolean {
        return ('a'..'z').all{input.toLowerCase().contains(it)}
    }
    /*
    fun isPangram(input: String): Boolean {
        // Create Regex to find all non-alphabetic characters
        val re = Regex("[^A-za-z|_]")
        var justAlpha = re.replace(input, "")
        val reUs = Regex( "[_]")
        var justAlphaWithNoUnderscore = reUs.replace(justAlpha,"")
        // Convert the remaining alphabetic string to a set
        var stringSet = justAlphaWithNoUnderscore.toLowerCase().toSet()
        // Get size of this set.
        var sizeSet = stringSet.size
        // If size == 26, return true, else return false
        return (sizeSet == 26)
    }
    */

}

