
class KindergartenGarden(private val diagram: String) {
    private val mapOfPlants: Map<String, String> = mapOf("C" to "clover", "G" to "grass", "R" to "radishes", "V" to "violets")
    private val students = listOf("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry")
    private val diagramList = diagram.split("\n")

    fun getPlantsOfStudent(student: String): List<String> {
        val studentIndex = students.indexOf(student)
        var studentsPlants: MutableList<String> = mutableListOf()
        for (i in 0..1) {
            for (j in 0..1) {
                studentsPlants.add(diagramList[i][studentIndex*2 + j].toString())
            }
        }
        return studentsPlants.map { mapOfPlants[it]!!}
    }
}