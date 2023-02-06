package com.qa.pageobject;

import com.codeborne.selenide.SelenideElement;
import com.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    private final String TITLE_TEXT = "Student registration Form";
    private SelenideElement
            lastNameInput = $x("//div[@id='userName-wrapper']//input[@id='lastName']"),
            firstNameInput = $("#firstName"),
            emailInput = $x("//div[@id='userEmail-wrapper']//input[@id='userEmail']"),
            setGenderMale = $x("//div[@id= 'genterWrapper']//label[text() = 'Male' and @for = 'gender-radio-1']"),
            setGenderFemale = $x("//div[@id= 'genterWrapper']//label[text() = 'Female' and @for = 'gender-radio-2']"),
            setGenderOther = $x("//div[@id= 'genterWrapper']//label[text() = 'Other' and @for = 'gender-radio-3']"),

    setPhone = $x("//div[@id='userNumber-wrapper']//input[@id='userNumber']");

    public RegistrationPage openPage() {
        open("/automation-practice-form"); // relative link
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.clear();
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender() {
        setGenderMale.click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        setPhone.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateofBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }


}
