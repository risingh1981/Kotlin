object Acronym {

    fun generate(phrase: String) : String {
        var phraseList = phrase.split(" ","-","_")
        var acronym = ""
        println(phraseList)
        for (ele in phraseList) {
            if (ele != "" && ele[0].isLetter()){
                acronym += ele[0].toUpperCase()
            }
        }
        return acronym
    }
}


