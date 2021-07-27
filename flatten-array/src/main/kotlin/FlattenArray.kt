
object Flattener {
    var newFinal = mutableListOf<Int>()


    fun flatten(source: List<*>): List<Any> {
        newFinal.clear()
        perform(source, newFinal)
        return newFinal
    }

    private fun perform(nestList:List<*>, final: List<Int>): MutableList<Int> {
        newFinal = final.toMutableList()
        for (element in nestList){
            if (element is List<*>) {
                newFinal = perform(element, newFinal)
            } else if (element is Int) {
                newFinal.add(element)
            }
        }
        return newFinal
    }
}
