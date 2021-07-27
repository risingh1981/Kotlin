object BeerSong {

    fun verses(startBottles: Int, takeDown: Int): String{
        var finalStr = ""
        for (i in startBottles downTo takeDown) {
            if (i != startBottles) {
                finalStr = finalStr.plus("\n")
            }
            finalStr = finalStr.plus(verse(i))
        }
        return finalStr
    }

    private fun verse(num: Int): String {
        return when (num) {
            in 3..99 -> "$num bottles of beer on the wall, $num bottles of beer.\nTake one down and pass it around, ${num-1} bottles of beer on the wall.\n"
            in 2..2 -> "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n"
            in 1..1 -> "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
            else -> "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
        }
    }
}
