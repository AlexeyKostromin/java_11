package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.innerText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CvCreatorPage {
    SelenideElement submitCookieBtn = $(".cookies_awqum01").$("[data-test='button-submitCookie']");
    ElementsCollection cvTypeCollection = $$x("//div[@class = 'type-options cv-type']/button");
    SelenideElement cvImage = $(".template-preview__image");

    public CvCreatorPage openPage() {
        open("https://cv.pracuj.pl/");
        return this;
    }

    public CvCreatorPage submitCookie() {
        try {
            submitCookieBtn.click();
        }
        catch (ElementNotFound e){}

        return this;
    }

    public CvCreatorPage selectCvType(String cvType){
        cvTypeCollection.find(innerText(cvType)).click();
        return this;
    }

    public CvCreatorPage verifyCvPicture(String expectedImageName){
        var src = cvImage.attr("src");
        Assertions.assertTrue(src.contains(expectedImageName),
                "Expected image should contains text: " + expectedImageName + " but was" + src);
        return this;
    }



}
