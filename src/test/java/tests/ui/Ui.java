package tests.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.WebPages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Ui {
    WebPages webPages = new WebPages();
    private String
            searchString = "REDMOND";

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://www.wildberries.ru/";
        browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Проверка логотипа в хедере")
    void testLogotip() {
        webPages
                .openPage();
    }

    @Test
    @DisplayName("Каталог")
    void testCatalog() {
        webPages
                .openPage()
                .openCatalog()
                .selectSection()
                .checkBook();
    }

    @Test
    @DisplayName("Поиск товара")
    void findTovar() {
        webPages
                .openPage()
                .searchField(searchString)
                .checkRedmond();
    }

    @Test
    @DisplayName("Переход на страницу товара")
    void GoToProductPage() {
        webPages
                .openPage()
                .searchField(searchString)
                .checkRedmond()
                .productClick()
                .checkTitleProduct();
    }

    @Test
    @DisplayName("Добавление товара в корзину")
    void AddToCart() {
        webPages
                .openPage()
                .searchField(searchString)
                .checkRedmond()
                .productClick()
                .checkTitleProduct()
                .basketAdd();
        sleep(2000);
        webPages
                .goToTheBasket()
                .checkBasketProduct();
    }
}
