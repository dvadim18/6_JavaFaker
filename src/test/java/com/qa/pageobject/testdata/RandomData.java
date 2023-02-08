package com.qa.pageobject.testdata;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomData {
    Faker faker = new Faker(new Locale("ru"));

   public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            Email = faker.internet().emailAddress(String.valueOf(new Locale("en"))),
            Phone = faker.number().digits(10);





}
