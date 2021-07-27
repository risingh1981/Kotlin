
enum class Relationship {

    EQUAL, SUBLIST, SUPERLIST, UNEQUAL

}

fun <T> List<T>.relationshipTo(secondList: List<T>):Relationship {

    return when {
        this == secondList -> Relationship.EQUAL
        (this.size == secondList.size) && (this.windowed(this.size).contains(secondList)) -> Relationship.EQUAL
        this.isEmpty() && secondList.isNotEmpty() -> Relationship.SUBLIST
        secondList.isEmpty() && this.isNotEmpty() -> Relationship.SUPERLIST
        (this.size > secondList.size) && this.windowed(secondList.size).any { it == secondList} -> Relationship.SUPERLIST
        (secondList.size > this.size) && secondList.windowed(this.size).any { it == this } -> Relationship.SUBLIST
        else -> Relationship.UNEQUAL
    }

}
