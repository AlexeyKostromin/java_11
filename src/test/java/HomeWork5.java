import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverConditions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork5 {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1280";
    }

    @Test
    public void solutionsEnterprizeTest(){
        open("https://github.com");
        $("[aria-label=Global]").$(byText("Solutions")).hover();
        $("[aria-labelledby=solutions-for-heading]").$(byText("Enterprise")).click();
        webdriver().shouldHave(WebDriverConditions.url("https://github.com/enterprise"));
        $("[class=font-mktg]").shouldHave(Condition.text("Build like the best"));
    }

    @Test
    public void dragAndDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        var elementA = $("[id=column-a]");
        var elementB = $("[id=column-b]");

        elementA.shouldHave(Condition.text("A"));
        elementB.shouldHave(Condition.text("B"));
        $(elementA).dragAndDrop(to(elementB).usingJS());
        elementA.shouldHave(Condition.text("B"));
        elementB.shouldHave(Condition.text("A"));
        //does not work on this site
        //actions().moveToElement(elementA).clickAndHold().moveToElement(elementB).release().perform();
    }

    @Test
    public void dragAndDropWebDriverMethodTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //does not work on this site
        WebElement element1 = webdriver().object().findElement(By.id("column-a"));
        WebElement element2 = webdriver().object().findElement(By.id("column-b"));

        WebDriver driver = webdriver().object();
        Actions actions = new Actions(driver);
        actions.moveToElement(element1);
        actions.clickAndHold();
        actions.moveToElement(element2);
        actions.release();
        actions.build().perform();

    }
}
