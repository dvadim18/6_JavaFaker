package com.qa.pageobject.pages;

import com.codeborne.selenide.SelenideElement;
import com.qa.pageobject.pages.components.Calendar;
import com.qa.pageobject.pages.components.FileUpload;
import com.qa.pageobject.pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    Calendar calendar = new Calendar();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    FileUpload fileUpload = new FileUpload();
    private final String TITLE_TEXT = "Student registration Form";
    private SelenideElement
            lastNameInput = $x("//div[@id='userName-wrapper']//input[@id='lastName']"),
            firstNameInput = $("#firstName"),
            emailInput = $x("//div[@id='userEmail-wrapper']//input[@id='userEmail']"),
//            setGenderMale = $x("//div[@id= 'genterWrapper']//label[text() = 'Male' and @for = 'gender-radio-1']"),
//            setGenderFemale = $x("//div[@id= 'genterWrapper']//label[text() = 'Female' and @for = 'gender-radio-2']"),
//            setGenderOther = $x("//div[@id= 'genterWrapper']//label[text() = 'Other' and @for = 'gender-radio-3']"),
            setPhone = $x("//div[@id='userNumber-wrapper']//input[@id='userNumber']");
//            checkBoxSport = $x("//label [@for = 'hobbies-checkbox-1']"),
//            checkBoxReading = $x("//label [contains (@for, 'hobbies-checkbox-2')]"),
//            checkBoxMusic = $x("//label [text() = 'Music']");

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

    public RegistrationPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        setPhone.setValue(value);

        return this;
    }

//    public RegistrationPage setBirthDate(String day, String month, String year) {
//        $("#dateOfBirthInput").click();
//        calendarComponent.setDate(day, month, year);
//
//        return this;
//    }

    public RegistrationPage setBirthDayDate(String birthday) {
        $("#dateOfBirthInput").click();
        calendar.setDate(birthday);
        return this;
    }


    //  считаю autocompleteForm уникальной формой, выделять ее отдельно в компент не стал
    public RegistrationPage autocompleteForm(String value) {
        $x("//*[@id='subjectsInput']").click();
        $x("//*[@id='subjectsInput']").sendKeys(value);
        $x("//*[@id='subjectsInput']").pressTab();

        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        $("#hobbiesWrapper").$(byText(hobbies)).click();

        return this;
    }

    public RegistrationPage fileUploadForm( String value) {
        fileUpload.anyfileUpload(value);

        return this;
    }

    public RegistrationPage setTextArea(String value) {
        $x("//textarea[@id='currentAddress']").setValue(value);

        return this;
    }

    public RegistrationPage setStateDropDownMenu(String value) {
        $x("//div[@id ='stateCity-wrapper']//div[@id= 'state']").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCityDropDownMenu(String value) {
        $x("//input[@id = 'react-select-4-input']").setValue(value).pressTab();
        return this;
    }


    public RegistrationPage submitPracticeForm() {
        $x("//button[@id = 'submit']").click();
        return this;
    }


    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage verifyModalResultSubmit() {
        registrationResultsModal.verifyResultSubmit();

        return this;
    }

//    $x("//button[@data-id= 'professionId_0']").click();
//    $x("value]").click();

//    $x("//input[@aria-controls=  'bs-select-53']").setValue("Инженер");
//    $x("//div[@id='bs-select-53']//span[text() = 'Инженер']/..").click();


}
