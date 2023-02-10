package com.qa.pageobject.tests;

import com.qa.pageobject.testdata.UserData;
import org.junit.jupiter.api.Test;


public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void studentRegistrationForm() {

        UserData userData = new UserData();

        registrationPage.openPage()
                .setFirstName(userData.firsName)
                .setLastName(userData.lastName)
                .setEmail(userData.Email)
                .setGender (userData.Gender)
                .setPhone(userData.Phone)
                .setBirthDayDate(userData.getBirthday())
                .autocompleteForm(userData.Subjects)
                .setHobbies(userData.Hobbies)
                .fileUploadForm(userData.Picture)
                .setTextArea(userData.CurrentAddress)
                .setStateDropDownMenu(userData.State)
                .setCityDropDownMenu(userData.City)
                .submitPracticeForm()

                //Modal window
                .verifyResultsModalAppears()
                .verifyResult("Student Name", userData.firsName + " " + userData.lastName)
                .verifyResult("Student Email", userData.Email)
                .verifyResult("Gender", userData.Gender)
                .verifyResult("Mobile", userData.Phone)
                .verifyResult("Date of Birth", userData.getBirthday())
                .verifyResult("Subjects", userData.Subjects)
                .verifyResult("Hobbies", userData.Hobbies)
                .verifyResult("Picture", userData.Picture.substring(4))
                .verifyResult("Address", userData.CurrentAddress)
                .verifyResult("State and City", userData.State+" " +userData.City)
                .verifyModalResultSubmit();


    }
}
