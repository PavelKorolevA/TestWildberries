package tests.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Ui {

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://www.wildberries.ru/";
        browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Проверка логотипа в хедере")
    void testLogotip() {
        open(baseUrl);
        $(".j-header").should(text("Wildberries"));
    }

    @Test
    @DisplayName("Каталог")
    void testCatalog() {
        open(baseUrl);
        $("[data-wba-header-name=Catalog]").click();

        $(By.linkText("Книги")).click();

        $(".catalog-title").shouldHave(text("Книги"));
    }
}
