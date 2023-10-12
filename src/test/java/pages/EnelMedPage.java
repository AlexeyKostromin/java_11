package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.TypeOptions.text;

public class EnelMedPage {
    SelenideElement
            langSwitchBlock = $x("//ul[contains(@class, 'lang-switch')]"),
            menuItemsBlock= $("[class = navbar-menu]/ul");

    public EnelMedPage openPage() {
        open("https://cm.enel.pl/centrum-medyczne/");
        return this;
    }

    public EnelMedPage selectLanguage(Language language) {
        var lang = language.name().toString();
        //langSwitchBlock.find(text(language.name()).toString()).click();
        //langSwitchBlock.find(text(lang)).click();
        return this;
    }
    public enum Language {
        PL, EN
    }

}
