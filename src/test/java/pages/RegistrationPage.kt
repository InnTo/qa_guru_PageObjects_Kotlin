package pages

import com.codeborne.selenide.*
import pages.components.CalendarComponent
import pages.components.RegistrationFormResultsComponent

class RegistrationPage {
    private val firstNameInput = Selenide.`$`("#firstName")
    private val lastNameInput = Selenide.`$`("#lastName")
    private val userEmailInput = Selenide.`$`("#userEmail")
    private val userNumberInput = Selenide.`$`("#userNumber")
    private val subjectsInput = Selenide.`$`("#subjectsInput")
    private val uploadPicture = Selenide.`$`("#uploadPicture")
    private val currentAddressInput = Selenide.`$`("#currentAddress")
    private val stateInput = Selenide.`$`("#state")
    private val cityInput = Selenide.`$`("#city")
    private val submitClick = Selenide.`$`("#submit")
    private val calendarInput = Selenide.`$`("#dateOfBirthInput")

    private val subjectsSelect = Selenide.`$$`(".subjects-auto-complete__option")

    var calendarComponent: CalendarComponent = CalendarComponent()

    fun openPage(): RegistrationPage {
        Selenide.open("/automation-practice-form")

        return this
    }

    fun removeBanner(): RegistrationPage {
        Selenide.executeJavaScript<Any>("$('footer').remove();")
        Selenide.executeJavaScript<Any>("$('#fixedban').remove();")

        return this
    }

    fun setFirstName(firstName: String): RegistrationPage {
        firstNameInput.setValue(firstName)

        return this
    }

    fun setLastName(lastName: String): RegistrationPage {
        lastNameInput.setValue(lastName)

        return this
    }

    fun setUserEmail(userEmail: String): RegistrationPage {
        userEmailInput.setValue(userEmail)

        return this
    }

    fun setGender(gender: String): RegistrationPage {
        Selenide.`$`(Selectors.byText(gender)).click()

        return this
    }

    fun setUserNumber(number: String): RegistrationPage {
        userNumberInput.setValue(number)

        return this
    }

    fun setBirthday(month: String, year: String, day: String): RegistrationPage {
        calendarInput.clear()
        calendarComponent.setDate(month, year, day)

        return this
    }

    fun setSubject(subject: String): RegistrationPage {
        subjectsInput.setValue(subject)
        subjectsSelect.findBy(Condition.text(subject)).click()

        return this
    }

    fun setHobbies(hobbies: String): RegistrationPage {
        Selenide.`$`(Selectors.byText(hobbies)).click()

        return this
    }

    fun setUploadPicture(picture: String): RegistrationPage {
        uploadPicture.uploadFromClasspath(picture)

        return this
    }

    fun setAddress(currentAddress: String): RegistrationPage {
        currentAddressInput.setValue(currentAddress)

        return this
    }

    fun setStateAndCity(state: String, city: String): RegistrationPage {
        stateInput.click()
        Selenide.`$`(Selectors.byText(state)).click()
        cityInput.click()
        Selenide.`$`(Selectors.byText(city)).click()

        return this
    }

    fun clickSubmit(): RegistrationPage {
        submitClick.click()

        return this
    }

    fun checkResults(key: String, value: String): RegistrationPage {
        RegistrationFormResultsComponent().verifySuccessfulResults(key, value)

        return this
    }

    fun checkNegativeResults(): RegistrationPage {
        RegistrationFormResultsComponent().verifyNegativeResults()

        return this
    }
}