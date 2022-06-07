package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductPages {
    // locators
    private SelenideElement
            clickOnProduct = $("#c38776931"),
            titleCheck = $(".same-part-kt__header");


    // actions
    public ProductPages productClick() {
        clickOnProduct.click();
        return this;
    }

    public ProductPages checkTitleProduct() {
        titleCheck.shouldHave(text("REDMOND / Пылесос-робот REDMOND RV-R150, Белый"));
        return this;
    }
}
