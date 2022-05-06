package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestWildberries {
    @Test
    @DisplayName("Проверка Wildberries в хедере")
    void testLogotipWildberries() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Проверить наличие надписи Wildberries в хедере", () -> {
            $(".header").should(text("Wildberries"));
        });

    }
    @Test
    @DisplayName("Навигация по каталогу")
    void testKatalog(){

        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Кликнуть на кнопку Каталог", () -> {
            $(".nav-element__burger").click();
        });
        step("Кликнуть на пункт Бытовая техника", () -> {
            $(By.linkText("Бытовая техника")).click();
        });
        step("Проверить что нахожусь в раздере Бытовая техника", () -> {
            $("#body-layout").shouldHave(text("Бытовая техника"));
        });
    }
    @Test
    @DisplayName("Поиск бренда Xiaomi")
    void testSearchXiaomi() {

        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("В строку поиска ввести Xiaomi", () -> {
            $("[name=text]").setValue("Xiaomi");
        });
        step("В выпадающем меню выбрать пункт 'бренд Xiaomi'", () -> {
            $("[href='/brand/xiaomi-32686750/']").click();
        });
        step("Проверить что нахожусь на странице бренда Xiaomi", () -> {
            $("[data-widget=meta]").shouldHave(text("Xiaomi"));
        });
    }
    @Test
    @DisplayName("Добавление товара в корзину")
    void testItemCart() {

        step("Открыть карточку c товаром", () -> {
            open(baseUrl +
                    "product/derevyannyy-pazl-mayllo-koshka-28h33-sm-200-detaley-podarok-rebenku-podarok-zhenshchine-397581464/?sh=txD9WOl_qQ");
        });
        step("Нажать на кнопку Добавить в корзину", () -> {
            $("[data-widget=webAddToCart]").click();
        });
        step("Перейти в корзину", () -> {
            $("[href='/cart']").click();
        });
        step("Проверить что товар в корзине", () -> {
            $("[class='ta4 ta5']").shouldHave(text("Деревянный пазл MAYLLO"));
        });
    }
    @Test
    @DisplayName("Навигация Ozon Travel")
    void testNavigation() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Нажать на пункт Ozon Travel", () -> {
            $("[href='https://www.ozon.ru/travel?perehod=ozon_menu_header']").click();
        });
        step("Проверить что попал на страницу Ozon Travel", () -> {
            $("[data-widget='seoPurchaseAdvantages']")
                    .shouldHave(text("Покупать авиа- и ж/д билеты на Ozon удобно!"));
        });

    }
}
