package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigReader;
import config.ProjectConfiguration;
import config.WebConfig;
import io.qameta.allure.selenide.AllureSelenide;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.RegistrationPage;
import testdata.TestData;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    private static final WebConfig webConfig = ConfigReader.Instance.read();
    @BeforeAll
    static void beforeAll() {
        ProjectConfiguration projectConfiguration = new ProjectConfiguration(webConfig);
        projectConfiguration.webConfig();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
