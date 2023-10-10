package tests;

public class RandomStudentDataGenerator {
    DataStudentHelper dataStudentHelper = new DataStudentHelper();
    final String
            firstName = dataStudentHelper.generateFirstName(),
            lastName = dataStudentHelper.generateLastName(),
            userEmail = dataStudentHelper.generateEmail(),
            gender= dataStudentHelper.generateGender(),
            phone= dataStudentHelper.generatePhone(10),
            subjects= dataStudentHelper.getSubject(),
            hobby= dataStudentHelper.getHobby(),
            fileName= dataStudentHelper.getFilename(),
            address= dataStudentHelper.generateFullAddress(),
            state= dataStudentHelper.getState(),
            city= dataStudentHelper.getCity(state);
            final String[] dateOfBirth = dataStudentHelper.generateDateOfBirthFaker();

}