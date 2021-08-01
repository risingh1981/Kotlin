class Dna(val inputDNA: String) {


    val nucleotideCounts: Map<Char, Int>
        get() { return counts(inputDNA) }

    fun counts(input: String):Map<Char, Int> {
        var counter = mutableMapOf<Char, Int>('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)
        counter['A'] =input.filter { it == 'A' }.count()
        counter['C'] =input.filter { it == 'C' }.count()
        counter['G'] =input.filter { it == 'G' }.count()
        counter['T'] =input.filter { it == 'T' }.count()
        if (counter.values.sum() != input.length) {
            throw IllegalArgumentException("Input DNA string contains letters other than A,G,C, and T.")
        }
        return counter

    }

}