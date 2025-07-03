package pages.components

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide

class CalendarComponent {
    private val monthSelect = Selenide.`$`(".react-datepicker__month-select")
    private val yearSelect = Selenide.`$`(".react-datepicker__year-select")

    private val daySelect = Selenide.`$$`(".react-datepicker__day")

    fun setDate(month: String, year: String, day: String) {
        monthSelect.selectOption(month)
        yearSelect.selectOption(year)
        daySelect.findBy(Condition.text(day)).click()
    }
}