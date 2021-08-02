
class School {
    var gradeRosterMap: MutableMap<Int, MutableList<String>> = mutableMapOf()

    fun add(student: String, grade: Int) {
        if (grade in gradeRosterMap.keys) {
            gradeRosterMap[grade]?.add(student)
        } else {
            gradeRosterMap[grade] = mutableListOf(student)
        }
    }

    fun grade(grade: Int): List<String> {
        return gradeRosterMap[grade]?.sorted() ?: emptyList()
    }

    fun roster(): List<String> {
        return gradeRosterMap.keys.sorted().fold(mutableListOf<String>()) { allstudents, key -> allstudents.plus(gradeRosterMap[key]?.sorted() as MutableList<String>) as MutableList<String>}
    }
}

