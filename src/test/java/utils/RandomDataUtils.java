package utils;

import com.github.javafaker.Faker;
import io.netty.util.internal.ThreadLocalRandom;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.Month;

public class RandomDataUtils {
    private Faker faker;
    
    public RandomDataUtils() {
        faker = new Faker();
    }

    public String generateFirstName() {
        return faker.name().firstName();
    }

    public String generateLastName() {
        return faker.name().lastName();
    }

    public String generateEmail() {
        return faker.internet().emailAddress();
    }

    public String generateFullAddress() {
        return faker.address().fullAddress();
    }

    public String[] generateDateOfBirth() {
          var randomYear = Integer.toString(getRandomBetween(1900, 2022));
          var randomMonth = (Month.values()[getRandomBetween(1,11)]).toString().toLowerCase();
          randomMonth = Character.toUpperCase(randomMonth.charAt(0)) + randomMonth.substring(1);
          var randomDay = Integer.toString(getRandomBetween(1,30));
          return new String[] {randomDay, randomMonth, randomYear};
    }

    public String getRandomStringFromArray(String[] array) {
        return array[this.getRandomBetween(0, array.length - 1)];
    }

    public int getRandomBetween(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public String generateStringAlphabetic(int min, int max) {
        return RandomStringUtils.randomAlphabetic(min, max);
    }

    public String generateStringNumeric(int min, int max) {
        return RandomStringUtils.randomNumeric(min, max);
    }

}
