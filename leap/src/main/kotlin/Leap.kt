data class Year(val year: Int) {

    val isLeap: Boolean
        get() = when {
            (year % 4 == 0) && (year % 100 != 0) -> true
            (year % 100 == 0) && (year % 400 != 0) -> false
            (year % 400 == 0) -> true
            else -> false
        }
}