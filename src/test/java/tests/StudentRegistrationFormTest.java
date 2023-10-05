package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class StudentRegistrationFormTest extends TestBase {

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
        final String fileName= "File1.png";
        final String address= "Street 12/44";
        final String state= "Haryana";
        final String city= "Karnal";

        PracticeFormPage practiceFormPage = new PracticeFormPage();

        practiceFormPage
                .openPage()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(userEmail)
                .fillGender(gender)
                .fillPhone(phone)
                .setDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subjects)
                .setHobby(hobby)
                .uploadPicture(fileName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();

        practiceFormPage
                .checkResult("Student Name",firstName +" " + lastName)
                .checkResult("Student Email",userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile",phone)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", fileName)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }

}
