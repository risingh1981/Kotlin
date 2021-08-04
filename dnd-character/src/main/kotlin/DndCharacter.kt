import kotlin.math.floor


class DndCharacter {

    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = 10 + modifier(constitution)
    // initial hitpoints are 10 + your character's constitution modifier


    companion object {

        fun ability(): Int {
            val randNumList: MutableList<Int> = (1..4).map { (1..6).random()}.toMutableList()
            randNumList.remove(min(randNumList))
            return randNumList.sum()
        }
        // modifier obtained by subtracting 10 from your character's constitution,
        // divide by 2 and round down.
        fun modifier(score: Int): Int {
            return floor((score - 10).toDouble()/2).toInt()
        }

        fun min(inputList: List<Int>):Int {
            return inputList.reduce {min, curr -> if (min < curr) { min } else { curr } }
        }
    }

}
