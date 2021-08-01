
object Yacht {
    // Function will return -1 if there was some error in the input.
    fun solve(category: YachtCategory, vararg dices: Int): Int {
        var diceList = dices.toList()
        var diceSet = dices.toSet()
        when (category) {
            YachtCategory.ONES -> return diceList.count{ it == 1 }
            YachtCategory.TWOS -> return diceList.count{ it == 2 } * 2
            YachtCategory.THREES -> return diceList.count{ it == 3 } * 3
            YachtCategory.FOURS -> return diceList.count{ it == 4 } * 4
            YachtCategory.FIVES -> return diceList.count{ it == 5 } * 5
            YachtCategory.SIXES -> return diceList.count{ it == 6 } * 6
            YachtCategory.FULL_HOUSE -> return if ((diceSet.size == 2) && (diceList.count { it == diceSet.elementAt(0) } == 2 || diceList.count { it == diceSet.elementAt(0) } == 3)) {
                diceList.sum()
            } else {
                0
            }
            YachtCategory.FOUR_OF_A_KIND -> return if ((diceSet.size <= 2) && (diceList.count { it == diceSet.elementAt(0) } >= 4)) {
                (4 * diceSet.elementAt(0))
            } else if ((diceSet.size == 2) && (diceList.count { it == diceSet.elementAt(1) } == 4)) {
                (4 * diceSet.elementAt(1))
            } else {
                0
            }
            YachtCategory.LITTLE_STRAIGHT -> return if (diceList.all { it in 1..5 } && (diceSet.size == 5)) {
                30
            } else {
                0
            }
            YachtCategory.BIG_STRAIGHT -> return if (diceList.all { it in 2..6 } && (diceSet.size == 5)) {
                30
            } else {
                0
            }
            YachtCategory.CHOICE -> return (diceList.sum())
            YachtCategory.YACHT -> return if (diceSet.size == 1) {
                50
            } else {
                0
            }
            else -> return -1
        }
    }
}