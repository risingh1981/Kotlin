object ResistorColorTrio {

    fun text(vararg input: Color): String {
        val unitArr = listOf(Unit.OHMS, Unit.KILOOHMS, Unit.MEGAOHMS, Unit.GIGAOHMS, Unit.TERAOHMS, Unit.PETAOHMS, Unit.EXAOHMS)
        val colorArr = listOf(Color.BLACK, Color.BROWN, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.VIOLET, Color.GREY, Color.WHITE)
        var sliceColors = input.slice(0..1)
        var colorStr = ""
        for (color in sliceColors) {
            colorStr = colorStr.plus(colorArr.indexOf(color))
        }
        colorStr = colorStr.plus("0".repeat(colorArr.indexOf(input[2])))
        var numZeros = colorStr.filter{ it == '0'}.count()

        when {
            numZeros >= 18 -> { colorStr = colorStr.dropLast(18); colorStr = colorStr.plus(" exaohms") }
            numZeros >= 15 -> { colorStr = colorStr.dropLast(15); colorStr = colorStr.plus(" petaohms") }
            numZeros >= 12 -> { colorStr = colorStr.dropLast(12); colorStr = colorStr.plus(" teraohms") }
            numZeros >= 9 -> { colorStr = colorStr.dropLast(9); colorStr = colorStr.plus(" gigaohms") }
            numZeros >= 6 -> { colorStr = colorStr.dropLast(6); colorStr = colorStr.plus(" megaohms") }
            numZeros >= 3 -> { colorStr = colorStr.dropLast(3); colorStr = colorStr.plus(" kiloohms") }
            else -> { colorStr = colorStr.dropLast(0); colorStr = colorStr.plus(" ohms") }

        }

        return colorStr

    }

}