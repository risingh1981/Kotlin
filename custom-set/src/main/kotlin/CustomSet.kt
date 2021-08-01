class CustomSet(vararg nums: Int) {

    var inputSet = nums.toMutableSet()

    fun isEmpty(): Boolean {
        return inputSet.isEmpty()
    }

    fun isSubset(other: CustomSet): Boolean {
        return isEmpty() || (inputSet == other.inputSet) || other.inputSet.containsAll(inputSet)
    }

    fun isDisjoint(other: CustomSet): Boolean {
        return (inputSet.intersect(other.inputSet) == emptySet<Int>())
    }

    fun contains(other: Int): Boolean {
        return inputSet.contains(other)
    }

    fun intersection(other: CustomSet): CustomSet {
        return CustomSet(*(inputSet.intersect(other.inputSet).toIntArray()))
    }

    fun add(other: Int) {
        inputSet.add(other)
    }

    override fun equals(other: Any?): Boolean {
        return if (other is CustomSet) {
            inputSet == other.inputSet
        } else {
            false
        }
    }

    operator fun plus(other: CustomSet): CustomSet {
        return CustomSet(*(inputSet.union(other.inputSet).toIntArray()))
    }

    operator fun minus(other: CustomSet): CustomSet {
        return CustomSet(*(inputSet.minus(other.inputSet).toIntArray()))
    }
}
