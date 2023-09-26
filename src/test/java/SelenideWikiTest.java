import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

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
        $(byText("Soft assertions")).click();
        $("[id=user-content-3-using-junit5-extend-test-class]").scrollTo();
        $("[id=user-content-3-using-junit5-extend-test-class]").shouldHave(text("3. Using JUnit5 extend test class:"));
        //$("[id=user-content-3-using-junit5-extend-test-class]").sibling(0).shouldHave(text("SoftAssertsExtension"));
        $x("//*[contains(@id, 'using-junit5-extend')]/following-sibling::div[1]").shouldHave(text("SoftAssertsExtension"));
    }

}
