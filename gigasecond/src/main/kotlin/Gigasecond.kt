import java.time.LocalDateTime
import java.time.LocalDate

class Gigasecond(inDateTime : LocalDateTime) {

    constructor (inDate: LocalDate) : this(inDate.atStartOfDay())

    val date: LocalDateTime = inDateTime.plusSeconds(1000000000)
}
