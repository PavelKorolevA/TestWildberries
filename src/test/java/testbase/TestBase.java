package testbase;

import attachment.Attaches;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static config.ConfigHelper.getWebRemoteDriverPassword;
import static config.ConfigHelper.getWebRemoteDriverUser;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://www.wildberries.ru/";
        browserSize = "1920x1080";
 //       Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.remote = "https://" + getWebRemoteDriverUser() + ":" + getWebRemoteDriverPassword() + "@" + System.getProperty("remote.browser.url");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void allure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
    void addAttachments() {
        Attaches.screenshotAs("Последний скриншот");
        Attaches.pageSource();
        Attaches.browserConsoleLogs();
        closeWebDriver();
        Attaches.addVideo();

    }
}
