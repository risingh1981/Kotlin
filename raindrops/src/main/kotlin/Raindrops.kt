object Raindrops {

    fun convert(n: Int): String {
        var string = ""
        if (n % 3 == 0) {
            string = "Pling"
        }
        if (n % 5 == 0) {
            string = "${string}Plang"
        }
        if (n % 7 == 0) {
            string = "${string}Plong"
        }
        return if (string == "") {
            n.toString()
        } else {
            string
        }
    }
}
