object ResistorColorDuo {

    fun value(vararg colors: Color): Int {
        val colorArr = listOf(Color.BLACK, Color.BROWN, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.VIOLET, Color.GREY, Color.WHITE)
        var sliceColors = colors.slice(0..1)
        var colorInt = ""
        for (color in sliceColors) {
            colorInt = colorInt.plus(colorArr.indexOf(color))
        }
        return colorInt.toInt()
    }
}