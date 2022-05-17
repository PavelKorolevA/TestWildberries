package attachment;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Attaches {
    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment
    public static byte[] screenshotAs(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public static void browserConsoleLogs() {
        attachAsText(
                "Browser console logs",
                String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
    }

    public static void addVideo(String sessionId) {
        URL videoUrl = getVideoUrl(sessionId);
        InputStream videoInputStream = null;
        sleep(1000);

        for (int i = 0; i < 10; i++) {
            try {
                videoInputStream = videoUrl.openStream();
                break;
            } catch (FileNotFoundException e) {
                sleep(1000);
            } catch (IOException e) {
                throw new RuntimeException("[ALLURE VIDEO ATTACHMENT ERROR] Cant attach allure video");
            }
        }

        if (videoInputStream != null)
            Allure.addAttachment("Video", "video/mp4", videoInputStream, "mp4");
    }

    private static URL getVideoUrl(String sessionId) {
        String videoUrl = "https://selenoid.autotests.cloud/video/" + sessionId + ".mp4";

        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException("[ALLURE VIDEO ATTACHMENT ERROR] Wrong test video url");
        }
    }
}
