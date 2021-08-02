import java.lang.Math.floorMod

class Clock(hour: Int, minutes: Int) {
    val minutesTotal = hour*60 + minutes
    var hour = floorMod(minutesTotal, 1440) / 60
    var minutes = floorMod(minutesTotal, 1440) % 60


    override fun toString(): String {
        var timeFormatted: String = ""
        if (hour < 10) {
            timeFormatted += "0$hour:"
        } else {
            timeFormatted +="$hour:"
        }
        if (minutes < 10) {
            timeFormatted += "0$minutes"
        } else {
            timeFormatted += "$minutes"
        }
        return timeFormatted
    }
    override fun equals(other: Any?): Boolean {
        return if (other is Clock) {
            (this.hour == other.hour && this.minutes == other.minutes)
        } else {
            false
        }
    }


    fun subtract(minutes: Int) {
        val afterSubtract:Int = minutesTotal - minutes
        this.hour = floorMod(afterSubtract, 1440) / 60
        this.minutes = floorMod(afterSubtract, 1440) % 60
    }

    fun add(minutes: Int) {
        val afterAdd:Int = minutesTotal + minutes
        this.hour = floorMod(afterAdd, 1440) / 60
        this.minutes = floorMod(afterAdd, 1440) % 60
    }
}