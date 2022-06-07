package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPages {
    // locators
    private SelenideElement
            headerTitle = $(".j-header");

    // actions
    public MainPages openPage() {
        open(baseUrl);
        headerTitle.should(text("Wildberries"));
        return this;
    }
}
