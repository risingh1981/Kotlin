class Scale(private val tonic: String) {
    private val sharps = listOf("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")
    private val flats = listOf("A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab")
    private val useSharps = listOf("G", "D", "A", "a", "C", "E", "e", "B", "F# major e", "b", "f#", "c#", "g#", "d# minor")
    private val useFlats = listOf("F", "Bb", "Eb", "Ab", "d", "Db", "Gb major d", "g", "c", "f", "bb", "eb minor")
    private val listToUse = if (tonic in useSharps) {sharps} else {flats}

    fun chromatic(): List<String> {
        val startIdx = listToUse.indexOf(tonic)
        var outputList: ArrayList<String> = ArrayList()
        for (num in 0..11) {
            outputList.add(listToUse[(num + startIdx) % 12])
        }
        return outputList
    }


    fun interval(intervals: String): List<String> {
        var intervals = intervals.replace("m","1").replace("M", "2").replace("A", "3")

        var startNote = tonic.capitalize()
        var startIdx = listToUse.indexOf(startNote)
        var outputArr: ArrayList<String> = ArrayList()
        outputArr.add(startNote)
        for (i in 0 until intervals.lastIndex) {
            startNote = listToUse[(intervals[i].toString().toInt() + startIdx) % 12]
            outputArr.add(startNote)
            startIdx = listToUse.indexOf(startNote)
        }

        return outputArr
    }

}