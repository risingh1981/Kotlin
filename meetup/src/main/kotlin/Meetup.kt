import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

class Meetup(private val month: Int, private val year: Int) {
    private var monthYearDate: LocalDate = LocalDate.of(year,month,1)
    private var lastDateOfMonth: LocalDate = monthYearDate.with(TemporalAdjusters.lastDayOfMonth())
    private var dateOfFirstTeenth: LocalDate = LocalDate.of(year,month,13)


    fun day(dayOfWeek: DayOfWeek, schedule: MeetupSchedule): LocalDate {
        val dayOnFirst = monthYearDate.dayOfWeek
        val dayOnLast = lastDateOfMonth.dayOfWeek
        val dayOnFirstTeenth = dateOfFirstTeenth.dayOfWeek
        val dayArr: List<DayOfWeek> = listOf(DayOfWeek.SUNDAY,DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY)
        var date = 0
        when (schedule) {
            MeetupSchedule.FIRST -> { if (dayArr.indexOf(dayOnFirst) < dayArr.indexOf(dayOfWeek)) { date = (dayArr.indexOf(dayOfWeek) - dayArr.indexOf(dayOnFirst)) + 1} else { date = 1 + ((7 - (dayArr.indexOf(dayOnFirst) - dayArr.indexOf(dayOfWeek))) % 7)}}
            MeetupSchedule.SECOND -> { if (dayArr.indexOf(dayOnFirst) < dayArr.indexOf(dayOfWeek)) { date = (dayArr.indexOf(dayOfWeek) - dayArr.indexOf(dayOnFirst)) + 8} else { date = 8 + ((7 - (dayArr.indexOf(dayOnFirst) - dayArr.indexOf(dayOfWeek))) % 7)}}
            MeetupSchedule.THIRD -> { if (dayArr.indexOf(dayOnFirst) < dayArr.indexOf(dayOfWeek)) { date = (dayArr.indexOf(dayOfWeek) - dayArr.indexOf(dayOnFirst)) + 15} else { date = 15 + ((7 - (dayArr.indexOf(dayOnFirst) - dayArr.indexOf(dayOfWeek))) % 7)}}
            MeetupSchedule.FOURTH -> { if (dayArr.indexOf(dayOnFirst) < dayArr.indexOf(dayOfWeek)) { date = (dayArr.indexOf(dayOfWeek) - dayArr.indexOf(dayOnFirst)) + 22} else { date = 22 + ((7 - (dayArr.indexOf(dayOnFirst) - dayArr.indexOf(dayOfWeek))) % 7)}}
            MeetupSchedule.LAST -> { if (dayArr.indexOf(dayOfWeek) <= dayArr.indexOf(dayOnLast)) { date = lastDateOfMonth.dayOfMonth - (dayArr.indexOf(dayOnLast) - dayArr.indexOf(dayOfWeek))} else { date = lastDateOfMonth.dayOfMonth - (7 - (dayArr.indexOf(dayOfWeek) - dayArr.indexOf(dayOnLast)))}}
            else -> { if (dayArr.indexOf(dayOnFirstTeenth) < dayArr.indexOf(dayOfWeek)) { date = (dayArr.indexOf(dayOfWeek) - dayArr.indexOf(dayOnFirstTeenth)) + 13} else { date = 13 + ((7 - (dayArr.indexOf(dayOnFirstTeenth) - dayArr.indexOf(dayOfWeek))) % 7)}}
        }
        return LocalDate.of(year, month, date)
    }

}