class Allergies(private val score: Int){

    private val binary = score.toString(2)
    private val allergiesList: List<Allergen> = getList()

    fun getList(): List<Allergen> {
        var createList: MutableList<Allergen> = mutableListOf()
        if (allergiesList == null) {
            var binaryReverse = binary.reversed()
            if (binaryReverse.length > 8) {
                binaryReverse = binaryReverse.dropLast(binaryReverse.length - 8)
            }
            binaryReverse.forEachIndexed { i, v -> if (v == '1') {createList.add(Allergen.values()[i]) }}
            return createList
        }
        return allergiesList
    }

    fun isAllergicTo(allergen: Allergen): Boolean {
        return (allergiesList.contains(allergen))
    }
}
