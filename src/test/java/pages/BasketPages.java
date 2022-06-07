package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BasketPages {
    // locators
    private SelenideElement
            addBasket = $(".same-part-kt__order"),
            clickBasket = $(".j-item-basket"),
            checkBasket = $("#body-layout");


    // actions
    public BasketPages basketAdd() {
        addBasket.$(byText("Добавить в корзину")).click();
        return this;
    }

    public BasketPages goToTheBasket() {
        clickBasket.click();
        return this;
    }

    public BasketPages checkBasketProduct() {
        checkBasket.shouldHave(text(" Пылесос-робот REDMOND RV-R150, Белый, REDMOND"));
        return this;
    }
}
