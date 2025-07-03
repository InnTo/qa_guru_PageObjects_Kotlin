package pages.components

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide

class RegistrationFormResultsComponent {
    fun verifySuccessfulResults(key: String, value: String) {
        Selenide.`$`(".table-responsive").`$`(Selectors.byText(key)).parent()
            .shouldHave(Condition.text(value))
    }

    fun verifyNegativeResults() {
        Selenide.`$`(".modal-content").shouldNot()
    }
}