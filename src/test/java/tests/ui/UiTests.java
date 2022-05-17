package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WebPages;
import testbase.TestBase;

import static com.codeborne.selenide.Selenide.*;

public class UiTests extends TestBase {

    WebPages webPages = new WebPages();

    private String
            searchString = "REDMOND";

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
