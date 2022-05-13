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
import static com.codeborne.selenide.Selenide.*;

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

    @Test
    @DisplayName("Поиск товара")
    void findTovar() {

        open(baseUrl);

        $("#searchInput").setValue("REDMOND").pressEnter();

        $(".brand-custom-header__name").shouldHave(text("REDMOND"));
    }

    @Test
    @DisplayName("Переход на страницу товара")
    void GoToProductPage() {

        open(baseUrl);

        $("#searchInput").setValue("REDMOND").pressEnter();

        $(".brand-custom-header__name").shouldHave(text("REDMOND"));

        $("#c38776931").click();

        $(".same-part-kt__header").shouldHave(text("REDMOND / Пылесос-робот REDMOND RV-R150, Белый"));
    }

    @Test
    @DisplayName("Добавление товара в корзину")
    void AddToCart() {

        open(baseUrl);

        $("#searchInput").setValue("REDMOND").pressEnter();

        $(".brand-custom-header__name").shouldHave(text("REDMOND"));

        $("#c38776931").click();

        $(".same-part-kt__header").shouldHave(text("REDMOND / Пылесос-робот REDMOND RV-R150, Белый"));

        $(".same-part-kt__order").$(byText("Добавить в корзину")).click();

        sleep(2000);

        $(".j-item-basket").click();

        $("#body-layout").shouldHave(text(" Пылесос-робот REDMOND RV-R150, Белый, REDMOND"));
    }
}
