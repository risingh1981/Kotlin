import kotlin.math.pow

object Darts {

    fun score(x: Number, y: Number): Int {
        var newX = x.toDouble()
        var newY = y.toDouble()

        return when (distanceFromOrigin(newX,newY)) {
            in 0.toDouble()..1.toDouble() -> 10
            in 1.toDouble()..5.toDouble() -> 5
            in 5.toDouble()..10.toDouble() -> 1
            else -> 0
        }
    }

    private fun distanceFromOrigin(x: Double,y:Double):Double {
        return (x.pow(2) +y.pow(2)).pow(0.5)
    }
}


