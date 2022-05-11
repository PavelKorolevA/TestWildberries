package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static config.ConfigHelper.getWebRemoteDriverPassword;
import static config.ConfigHelper.getWebRemoteDriverUser;

public class TestBase {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://www.wildberries.ru/";
        Configuration.browserSize = "1920x1080";
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.remote = "https://" + getWebRemoteDriverUser() + ":" + getWebRemoteDriverPassword() + "@" + System.getProperty("remote.browser.url");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void beforeeach() {
        SelenideLogger.addListener("allureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}