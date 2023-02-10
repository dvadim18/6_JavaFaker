package com.qa.pageobject.testdata;

import com.github.javafaker.Faker;
import java.util.*;

public class RandomData {
    static Faker faker = new Faker();
    static Random random = new Random();

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress(String.valueOf(new Locale("en")));
    }

    public static String getRandomGender() {
        String[] arrayGenders = {"Male", "Female", "Other"};
        return arrayGenders[random.nextInt(arrayGenders.length)];
    }

    public static String getRandomPhone(int length) {
        return faker.number().digits(length);
    }

    public static Date getRandomBirthday() {
        return faker.date().birthday();
    }

    public static String getRandomSubject() {
        String[] arraySubjects = {"Maths", "Arts", "Commerce", "Civics", "Hindi"};
        return arraySubjects[random.nextInt(arraySubjects.length)];
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomHobbies() {
        String[] arrayHobbies = {"Sport", "Music", "Reading"};
        return arrayHobbies[random.nextInt(arrayHobbies.length)];
    }

    public static String getRandomState() {
        String[] arrayStates = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return arrayStates[random.nextInt(arrayStates.length)];
    }

    public static String getRandomCity(String key) {
        Map<String, String[]> mapStateAndCity = new HashMap<>();
        mapStateAndCity.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        mapStateAndCity.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        mapStateAndCity.put("Haryana", new String[]{"Karnal", "Panipat"});
        mapStateAndCity.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

        String[] arrayCities = mapStateAndCity.get(key);
        return arrayCities[random.nextInt(arrayCities.length)];
    }

}
