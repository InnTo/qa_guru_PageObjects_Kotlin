package tests

import org.junit.jupiter.api.Test
import pages.TextBoxPage


class TextBoxTests : TestBase() {
    var name: String = "Test"
    var email: String = "Test@test.ru"
    var currentAddress: String = "Test address"
    var permanentAddress: String = "Another test address"

    var textBoxPage: TextBoxPage = TextBoxPage()

    @Test
    fun fillFormTest() {
        textBoxPage.openPage()
            .setUserName(name)
            .setUserEmail(email)
            .setCurrentAddress(currentAddress)
            .setPermanentAddress(permanentAddress)
            .clickSubmitButton()

            .checkResults("Name:", name)
            .checkResults("Email:", email)
            .checkResults("Current Address :", currentAddress)
            .checkResults("Permananet Address :", permanentAddress)
    }
}