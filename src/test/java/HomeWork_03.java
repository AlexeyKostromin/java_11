import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class HomeWork_03 {

    @BeforeAll
    static void beforeAll() {
        //Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1280";
        Configuration.baseUrl = "https://demoqa.com/";
        //Configuration.pageLoadStrategy="eager";

    }


    @Test
    void fillAllForm() {
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("[id=firstName]").setValue("First-name-1");
        $x("//input[@id='lastName']").setValue("Last-name-3");
        $("[id=userEmail]").setValue("user01@mail.com");
        //$("[id=gender-radio-1]").click();
        //$("[id=gender-radio-1]").selectRadio("Male");
        $("[id=genterWrapper]").selectRadio("Male");
        $("[placeholder=Mobile Number]").setValue("1234567890");
        $("[id=dateOfBirthInput]").setValue("12 Sep 2023").pressEnter();
        $("[id=hobbies-checkbox-3]").click();
        $("[id=hobbies-checkbox-3]").click();

    }

}
