package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebPages {
    // locators
    private SelenideElement
            headerTitle = $(".j-header"),
            catalogMenu = $("[data-wba-header-name=Catalog]"),
            clickOnTheBook = $(By.linkText("Книги")),
            titleBook = $(".catalog-title"),
            searchInput =  $("#searchInput"),
            titleRedmond = $(".brand-custom-header__name"),
            clickOnProduct = $("#c38776931"),
            titleCheck = $(".same-part-kt__header"),
            addBasket = $(".same-part-kt__order"),
            clickBasket = $(".j-item-basket"),
            checkBasket = $("#body-layout");

    // actions
    public WebPages openPage() {
        open(baseUrl);
        headerTitle.should(text("Wildberries"));
        return this;
    }

    public WebPages openCatalog() {
        catalogMenu.click();
        return this;
    }

    public WebPages selectSection() {
        clickOnTheBook.click();
        return this;
    }

    public WebPages checkBook() {
        titleBook.shouldHave(text("Книги"));
        return this;
    }

    public WebPages searchField (String searchString) {
        searchInput.setValue(searchString).pressEnter();
        return this;
    }

    public WebPages checkRedmond() {
        titleRedmond.shouldHave(text("REDMOND"));
        return this;
    }

    public WebPages productClick() {
        clickOnProduct.click();
        return this;
    }

    public WebPages checkTitleProduct() {
        titleCheck.shouldHave(text("REDMOND / Пылесос-робот REDMOND RV-R150, Белый"));
        return this;
    }

    public WebPages basketAdd() {
        addBasket.$(byText("Добавить в корзину")).click();
        return this;
    }

    public WebPages goToTheBasket() {
        clickBasket.click();
        return this;
    }

    public WebPages checkBasketProduct() {
        checkBasket.shouldHave(text(" Пылесос-робот REDMOND RV-R150, Белый, REDMOND"));
        return this;
    }
}
