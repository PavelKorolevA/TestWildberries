package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPages {
    // locators
    private SelenideElement
    catalogMenu = $("[data-wba-header-name=Catalog]"),
    clickOnTheBook = $(By.linkText("Книги")),
    titleBook = $(".catalog-title");

    // actions
    public CatalogPages openCatalog() {
        catalogMenu.click();
        return this;
    }

    public CatalogPages selectSection() {
        clickOnTheBook.click();
        return this;
    }

    public CatalogPages checkBook() {
        titleBook.shouldHave(text("Книги"));
        return this;
    }
}
