object ETL {
    fun transform(source: Map<Int, Collection<Char>>): Map<Char, Int> {
        var newScoring:MutableMap<Char, Int> = mutableMapOf<Char,Int>()
        for ((k,v) in source) {
            for (letter in v) {
                newScoring[letter.toLowerCase()] = k
            }

        }
        return newScoring
    }
}
