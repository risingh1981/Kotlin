object ResistorColor {

    val rColors = listOf("black","brown","red","orange","yellow","green","blue","violet","grey","white")

    fun colorCode(input: String): Int {
        return rColors.indexOf(input)
    }

    fun colors(): List<String> {
        return rColors
    }

}
