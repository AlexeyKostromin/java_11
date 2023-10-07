package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;


public class StudentRegistrationFormTest extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    TestData testData = new TestData();
    
    @Test
    void successSubmitAllFormTest() {
        final String firstName = testData.generateFirstName();
        final String lastName = testData.generateLastName();
        final String userEmail = testData.generateEmail();
        final String gender= testData.generateGender();
        final String phone= testData.generateStringNumeric(10,10);
        final String[] dateOfBirth = testData.generateDateOfBirth();
        final String subjects= testData.getSubject();
        final String hobby= testData.getHobby();
        final String fileName= "File1.png";
        final String address= testData.generateFullAddress();
        final String state= testData.getState();
        final String city= testData.getCity(state);

        practiceFormPage
                .openPage()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(userEmail)
                .fillGender(gender)
                .fillPhone(phone)
                .setDate(dateOfBirth)
                .setSubject(subjects)
                .setHobby(hobby)
                .uploadPicture(fileName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm()
                .resultTableShouldBeDisplayed(true);

        practiceFormPage
                .checkResult("Student Name",firstName +" " + lastName)
                .checkResult("Student Email",userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile",phone)
                .checkResult("Date of Birth", dateOfBirth[0] + " " + dateOfBirth[1] + "," + dateOfBirth[2])
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", fileName)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void successSubmitRequiredFormTest() {
        final String firstName = testData.generateFirstName();
        final String lastName = testData.generateLastName();
        final String gender= testData.generateGender();
        final String phone= testData.generateStringNumeric(10,10);

        practiceFormPage
                .openPage()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillGender(gender)
                .fillPhone(phone)
                .submitForm()
                .resultTableShouldBeDisplayed(true);

        practiceFormPage
                .checkResult("Student Name",firstName +" " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile",phone);
    }

    @Test
    void failSubmitFormWithEmptyValuesTest() {
        practiceFormPage
                .openPage()
                .submitForm()
                .resultTableShouldBeDisplayed(false);

        practiceFormPage
                .verifyRequiredFieldsColor()
                .verifyNonRequiredFieldsColor();
    }

}
