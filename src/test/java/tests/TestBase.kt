package tests

import com.codeborne.selenide.Configuration
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class TestBase {

    @BeforeAll
    fun setUp() {
        Configuration.browserSize = "1920x1080"
        Configuration.pageLoadStrategy = "eager"
        Configuration.baseUrl = "https://demoqa.com"
    }
}