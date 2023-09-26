import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWikiTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1280";
    }

    @Test
    public void wikiPageTest(){
        open("https://github.com/selenide/selenide");
        $("[id=wiki-tab]").click();
        $("[id=wiki-body]").shouldHave(Condition.text("Soft assertions"));
        $("[id=wiki-tab]");


    }

}
