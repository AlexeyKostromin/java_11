package tests;

import utils.RandomDataUtils;

public class TestData extends RandomDataUtils {

    public String generateGender() {
        String[] array = {"Male", "Female", "Other"};
        return getRandomStringFromArray(array);
    }
    public String getSubject() {
        String[] array = {"Maths", "English", "Chemistry", "Hindi", "Commerce", "Economics"};
        return getRandomStringFromArray(array);
    }

    public String getHobby() {
        String[] array = {"Sports", "Reading", "Music"};
        return getRandomStringFromArray(array);
    }

    public String getState() {
        String[] array = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomStringFromArray(array);
    }

    public String getCity(String state) {
        var result = "";
        if(state.equals("NCR")) {
            String[] arrayNcr = {"Delhi", "Gurgaon", "Noida"};
            result= getRandomStringFromArray(arrayNcr);
        }
        if(state.equals("Uttar Pradesh")) {
            String[] arrayNcr = {"Agra", "Lucknow", "Merrut"};
            result= getRandomStringFromArray(arrayNcr);
        }
        if(state.equals("Haryana")) {
            String[] arrayNcr = {"Karnal", "Panipat"};
            result= getRandomStringFromArray(arrayNcr);
        }
        if(state.equals("Rajasthan")) {
            String[] arrayNcr = {"Jaipur", "Jaiselmer"};
            result= getRandomStringFromArray(arrayNcr);
        }
        return result;
    }





}
