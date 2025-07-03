package pages

import com.codeborne.selenide.Selenide
import pages.components.TextBoxResultsComponent

class TextBoxPage {
    private val userNameInput = Selenide.`$`("#userName")
    private val userEmailInput = Selenide.`$`("#userEmail")
    private val currentAddressInput = Selenide.`$`("#currentAddress")
    private val permanentAddressInput = Selenide.`$`("#permanentAddress")
    private val submitButton = Selenide.`$`("#submit")

    fun openPage(): TextBoxPage {
        Selenide.open("/text-box")

        return this
    }

    fun setUserName(name: String): TextBoxPage {
        userNameInput.setValue(name)

        return this
    }

    fun setUserEmail(email: String): TextBoxPage {
        userEmailInput.setValue(email)

        return this
    }

    fun setCurrentAddress(currentAddress: String): TextBoxPage {
        currentAddressInput.setValue(currentAddress)

        return this
    }

    fun setPermanentAddress(permanentAddress: String): TextBoxPage {
        permanentAddressInput.setValue(permanentAddress)

        return this
    }

    fun clickSubmitButton(): TextBoxPage {
        submitButton.click()

        return this
    }

    fun checkResults(key: String, value: String): TextBoxPage {
        TextBoxResultsComponent().verifySuccessfulResults(key, value)

        return this
    }
}