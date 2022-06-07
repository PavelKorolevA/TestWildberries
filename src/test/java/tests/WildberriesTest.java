package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;
import testbase.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class WildberriesTest extends TestBase {

    MainPages mainPages = new MainPages();
    CatalogPages catalogPages = new CatalogPages();
    SearchPages searchPages = new SearchPages();
    ProductPages productPages = new ProductPages();
    BasketPages basketPages = new BasketPages();

    private String searchString = "REDMOND";

    @Test
    @DisplayName("Проверка логотипа в хедере")
    void testLogotip() {
        step("Открыть главную страницу и проверить логотип", () ->
                mainPages.openPage());
    }

    @Test
    @DisplayName("Каталог")
    void testCatalog() {
        step("Открыть главную страницу", () ->
                mainPages.openPage());
        step("Открыть каталог", () ->
                catalogPages.openCatalog());
        step("Открыть секцию Книги", () ->
                catalogPages.selectSection());
        step("Проверить, что открыта секция Книги", () ->
                catalogPages.checkBook());
    }

    @Test
    @DisplayName("Поиск товара")
    void findTovar() {
        step("Открыть главную страницу", () ->
                mainPages.openPage());
        step("Ввести в поиск REDMOND", () ->
                searchPages.searchField(searchString));
        step("Проверить, что поиск осуществлен по названию REDMOND", () ->
                searchPages.checkRedmond());
    }

    @Test
    @DisplayName("Переход на страницу товара")
    void goToProductPage() {
        step("Открыть главную страницу", () ->
                mainPages.openPage());
        step("Ввести в поиск REDMOND", () ->
                searchPages.searchField(searchString));
        step("Проверить, что поиск осуществлен по названию REDMOND", () ->
                searchPages.checkRedmond());
        step("Нажать на товар", () ->
                productPages.productClick());
        step("Проверить, что открыта страница выбранного товара", () ->
                productPages.checkTitleProduct());
    }

    @Test
    @DisplayName("Добавление товара в корзину")
    void addToCart() {
        step("Открыть главную страницу", () ->
                mainPages.openPage());
        step("Ввести в поиск REDMOND", () ->
                searchPages.searchField(searchString));
        step("Проверить, что поиск осуществлен по названию REDMOND", () ->
                searchPages.checkRedmond());
        step("Нажать на товар", () ->
                productPages.productClick());
        step("Проверить, что открыта страница выбранного товара", () ->
                productPages.checkTitleProduct());
        step("Добавить товар в корзину", () ->
                basketPages.basketAdd());
                 sleep(2000);
        step("Перейти в корзину", () ->
                basketPages.goToTheBasket());
        step("Проверить, что товар добавлен в корзину", () ->
                basketPages.checkBasketProduct());
    }
}
