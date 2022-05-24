package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WebPages;
import testbase.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class UiTests extends TestBase {

    WebPages webPages = new WebPages();

    private String
            searchString = "REDMOND";

    @Test
    @DisplayName("Проверка логотипа в хедере")
    void testLogotip() {
        step("Открыть главную страницу и проверить логотип", () -> {
        webPages
                    .openPage();
        });
    }

    @Test
    @DisplayName("Каталог")
    void testCatalog() {
        step("Открыть главную страницу", () -> {
            webPages
                    .openPage();
        });
        step("Открыть каталог", () -> {
            webPages
                    .openCatalog();
        });
        step("Открыть секцию Книги", () -> {
            webPages
                    .selectSection();
        });
        step("Проверить, что открыта секция Книги", () -> {
            webPages
                    .checkBook();
        });
    }

    @Test
    @DisplayName("Поиск товара")
    void findTovar() {
        step("Открыть главную страницу", () -> {
            webPages
                    .openPage();
        });
        step("Ввести в поиск REDMOND", () -> {
            webPages
                    .searchField(searchString);
        });
        step("Проверить, что поиск осуществлен по названию REDMOND", () -> {
            webPages
                    .checkRedmond();
        });
    }

    @Test
    @DisplayName("Переход на страницу товара")
    void goToProductPage() {
        step("Открыть главную страницу", () -> {
            webPages
                    .openPage();
        });
        step("Ввести в поиск REDMOND", () -> {
            webPages
                    .searchField(searchString);
        });
        step("Проверить, что поиск осуществлен по названию REDMOND", () -> {
            webPages
                    .checkRedmond();
        });
        step("Нажать на товар", () -> {
            webPages
                    .productClick();
        });
        step("Проверить, что открыта страница выбранного товара", () -> {
            webPages
                    .checkTitleProduct();
        });
    }

    @Test
    @DisplayName("Добавление товара в корзину")
    void addToCart() {
        step("Открыть главную страницу", () -> {
            webPages
                    .openPage();
        });
        step("Ввести в поиск REDMOND", () -> {
            webPages
                    .searchField(searchString);
        });
        step("Проверить, что поиск осуществлен по названию REDMOND", () -> {
            webPages
                    .checkRedmond();
        });
        step("Нажать на товар", () -> {
            webPages
                    .productClick();
        });
        step("Проверить, что открыта страница выбранного товара", () -> {
            webPages
                    .checkTitleProduct();
        });
        step("Добавить товар в корзину", () -> {
            webPages
                    .basketAdd();
        });
                 sleep(2000);
        step("Перейти в корзину", () -> {
            webPages
                    .goToTheBasket();
        });
        step("Проверить, что товар добавлен в корзину", () -> {
            webPages
                    .checkBasketProduct();
        });
    }
}
