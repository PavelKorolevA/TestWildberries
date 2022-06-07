package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPages {
    // locators
    private SelenideElement
    searchInput =  $("#searchInput"),
    titleRedmond = $(".brand-custom-header__name");

    // actions
    public SearchPages searchField (String searchString) {
        searchInput.setValue(searchString).pressEnter();
        return this;
    }

    public SearchPages checkRedmond() {
        titleRedmond.shouldHave(text("REDMOND"));
        return this;
    }
}
