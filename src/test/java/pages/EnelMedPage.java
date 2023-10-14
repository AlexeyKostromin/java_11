package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class EnelMedPage {
    ElementsCollection langSwitchCollection = $$x("//ul[contains(@class, 'lang-switch')]//a");
    ElementsCollection menuItemsBlock= $$("[class = navbar-menu] a");

    public EnelMedPage openPage() {
        open("https://cm.enel.pl/centrum-medyczne/");
        return this;
    }

    public EnelMedPage selectLanguage(Language language) {
        langSwitchCollection.find(text(language.name())).click();
        return this;
    }

    public EnelMedPage verifyMenuItems(List<String> expectedMenuItems) {
        menuItemsBlock.shouldHave(CollectionCondition.texts(expectedMenuItems));
        return this;
    }

    public enum Language {
        PL, EN
    }

}
