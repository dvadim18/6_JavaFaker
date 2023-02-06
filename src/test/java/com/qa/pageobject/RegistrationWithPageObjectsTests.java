package com.qa.pageobject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    @DisplayName("check student form")
    void studentRegistrationForm() {
        UserData studentData = new UserData();

        registrationPage.openPage()
                .setFirstName(studentData.firstName)
                .setLastName(studentData.lastName)
                .setEmail(studentData.Email)
                .setGenderM()
                .setPhone(studentData.Phone)
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
                .verifyResult("Student Name", studentData.firstName + " " + studentData.lastName)
                .verifyResult("Student Email", studentData.Email)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", studentData.Phone)
                .verifyResult("Date of Birth", "30 July,2008")
                .verifyResult("Subjects", "Hindi")
                .verifyResult("Hobbies", "Sports, Reading, Music")
                .verifyResult("Picture", "IMG_20220709_205901.jpg")
                .verifyResult("Address", "г. Санкт- Петербург, ул. Рубинштейна 26")
                .verifyResult("State and City", "NCR Delhi")
                .verifyModalResultSubmit();


    }
}
