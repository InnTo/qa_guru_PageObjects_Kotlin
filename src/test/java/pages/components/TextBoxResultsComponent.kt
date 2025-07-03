package pages.components

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide

class TextBoxResultsComponent {
    fun verifySuccessfulResults(key: String, value: String) {
        Selenide.`$`("#output").`$`(Selectors.byText(key)).parent()
            .shouldHave(Condition.text(value))
    }
}