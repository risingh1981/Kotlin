
class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

    init {
        try {
            Triple(a as Int, b as Int, c as Int)
            if ((a + b <= c) || (a + c <= b) || (b + c <= a)) {
                throw IllegalArgumentException("Sides not acceptable sizes.")
            }
        } catch (e: ClassCastException) {
            Triple(a as Double, b as Double, c as Double)
            if ((a + b <= c) || (a + c <= b) || (b + c <= a)) {
                throw IllegalArgumentException("Sides not acceptable sizes.")
            }
        }
    }

    val isEquilateral: Boolean = (setOf(a,b,c).size == 1)
    val isIsosceles: Boolean = ((setOf(a,b,c).size <= 2))
    val isScalene: Boolean = ((setOf(a,b,c).size == 3))
}