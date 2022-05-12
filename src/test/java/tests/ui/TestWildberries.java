package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestWildberries extends TestBase {
    @Test
    @DisplayName("Проверка Wildberries в хедере")
    void testLogotipWildberries() {
        step("Открыть главную страницу", () -> {
            open("https://www.wildberries.ru/");
        });
        step("Проверить наличие надписи Wildberries в хедере", () -> {
            $(".header").should(text("Wildberries"));
        });

    }
    @Test
    @DisplayName("Навигация по каталогу")
    void testKatalog(){

        step("Открыть главную страницу", () -> {
            open("https://www.wildberries.ru/");
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
}
