package tests


import org.junit.jupiter.api.Test
import pages.RegistrationPage

class RegistrationFormTests : TestBase() {
    var firstName: String = "Test"
    var lastName: String = "TestLastName"
    var userEmail: String = "Test@test.ru"
    var gender: String = "Male"
    var number: String = "8961530834"
    var month: String = "April"
    var year: String = "2002"
    var day: String = "30"
    var subject: String = "Maths"
    var hobbies: String = "Sports"
    var picture: String = "test.jpg"
    var currentAddress: String = "Current test address"
    var state: String = "Uttar Pradesh"
    var city: String = "Agra"


    var registrationPage: RegistrationPage = RegistrationPage()

    @Test
    fun fillRegistrationFormTest() {
        registrationPage.openPage()
            .removeBanner()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setUserEmail(userEmail)
            .setGender(gender)
            .setUserNumber(number)
            .setBirthday(month, year, day)
            .setSubject(subject)
            .setHobbies(hobbies)
            .setUploadPicture(picture)
            .setAddress(currentAddress)
            .setStateAndCity(state, city)
            .clickSubmit()


            .checkResults("Student Name", "$firstName $lastName")
            .checkResults("Student Email", userEmail)
            .checkResults("Gender", gender)
            .checkResults("Mobile", number)
            .checkResults("Date of Birth", "$day $month,$year")
            .checkResults("Subjects", subject)
            .checkResults("Hobbies", hobbies)
            .checkResults("Picture", picture)
            .checkResults("Address", currentAddress)
            .checkResults("State and City", "$state $city")
    }

    @Test
    fun fillRegistrationFormWithMinDataTest() {
        registrationPage.openPage()
            .removeBanner()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setGender(gender)
            .setUserNumber(number)
            .clickSubmit()


            .checkResults("Student Name", "$firstName $lastName")
            .checkResults("Gender", gender)
            .checkResults("Mobile", number)
    }

    @Test
    fun negativeFillRegistrationFormTest() {
        registrationPage.openPage()
            .removeBanner()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setGender(gender)
            .setUserNumber("0")
            .clickSubmit()

            .checkNegativeResults()
    }
}