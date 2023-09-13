import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1280";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.pageLoadStrategy="eager";
    }

    @Test
    void successSubmitFormTest() {
        final String firstName = "First-name-1";
        final String lastName = "Last-name-1";
        final String userEmail = "user01@mail.com";
        final String gender= "Male";
        final String phone= "1234567890";
        final String yearOfBirth= "1999";
        final String monthOfBirth= "June";
        final String dayOfBirth= "03";
        final String subjects= "Maths";
        final String hobby= "Music";
        final String address= "Street 12/44";
        final String state= "Haryana";
        final String city= "Karnal";

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("[id=firstName]").setValue(firstName);
        $x("//input[@id='lastName']").setValue(lastName);
        $("[id=userEmail]").setValue(userEmail);

        $("[id=genterWrapper]").$(byText(gender)).click();
        $("[id=userNumber]").setValue(phone);

        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__year-select]").selectOption(yearOfBirth);
        $("[class=react-datepicker__month-select]").selectOption(monthOfBirth);
        //$("[class=react-datepicker__day--0"+dayOfBirth).click();
        $(".react-datepicker__day--0"+dayOfBirth).click();

        $("[id=subjectsInput]").setValue(subjects).pressEnter();
        $(byText(hobby)).click();
        //$("[id=uploadPicture]").uploadFile(new File("src/test/resources/File1.png"));
        $("#uploadPicture").uploadFromClasspath("File1.png");
        $("[id=currentAddress]").setValue(address);
        $("[id=state]").click();
        $("[id=react-select-3-input]").setValue(state).pressEnter();
        $("[id=city]").click();
        $("[id=react-select-4-input]").setValue(city).pressEnter();

        $("[id=submit]").click();

        $("[class=table-responsive]").shouldHave(
                text(firstName +" " + lastName),
                text(userEmail),
                text(gender),
                text(phone),
                text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth),
                text(subjects),
                text(hobby),
                text("File1.png"),
                text(address),
                text(state + " " + city)
        );
    }

}
