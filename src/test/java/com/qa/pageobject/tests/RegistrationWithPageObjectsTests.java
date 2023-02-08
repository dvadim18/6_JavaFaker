package com.qa.pageobject.tests;

import com.qa.pageobject.testdata.RandomData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    @DisplayName("check student form")
    void studentRegistrationForm() {
        RandomData randomData = new RandomData();

        registrationPage.openPage()
                .setFirstName(randomData.firstName)
                .setLastName(randomData.lastName)
                .setEmail(randomData.Email)
                .setGenderM()
                .setPhone(randomData.Phone)
                .setBirthDate("30", "July", "2008")
                .autocompleteForm("Hindi")
                .setCheckBoxSport()
                .setCheckBoxReading()
                .setCheckBoxMusic()
                .fileUploadForm("src/test/data/demoPracticeFormUploads/IMG_20220709_205901.jpg")
                .setTextArea("г. Санкт- Петербург, ул. Рубинштейна 26")
                .setStateDropDownMenu("NCR")
                .setCityDropDownMenu("Delhi")
                .submitPracticeForm()

                //Modal window
                .verifyResultsModalAppears()
                .verifyResult("Student Name", randomData.firstName + " " + randomData.lastName)
                .verifyResult("Student Email", randomData.Email)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", randomData.Phone)
                .verifyResult("Date of Birth", "30 July,2008")
                .verifyResult("Subjects", "Hindi")
                .verifyResult("Hobbies", "Sports, Reading, Music")
                .verifyResult("Picture", "IMG_20220709_205901.jpg")
                .verifyResult("Address", "г. Санкт- Петербург, ул. Рубинштейна 26")
                .verifyResult("State and City", "NCR Delhi")
                .verifyModalResultSubmit();


    }
}
