
class Anagram (private val source: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        val origList = normalize(source.toLowerCase())
        var matches = mutableSetOf<String>()
        for (ele in anagrams) {
            if (source.toLowerCase() != ele.toLowerCase() && origList == normalize(ele.toLowerCase())) {
                matches.add(ele)
            }
        }

        return matches
    }

    private fun normalize(word: String): List<String> {
        return word.split("").sorted().filter { it.isNotBlank() }
    }
}
