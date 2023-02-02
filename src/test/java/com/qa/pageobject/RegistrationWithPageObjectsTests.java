package com.qa.pageobject;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void studentRegistrationForm() {
        String firstName = "Vadim";
        String lastName = "Dinislamov";
        String Email = "nokia.finlyandia@yandex.ru";
        String Phone = "01234567890";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(Email)
                .setGender()
                .setPhone(Phone)
                .setBirthDate("30", "Jul", "2008");


        // autocomplete form

        $x("//*[@id='subjectsInput']").click();
        $x("//*[@id='subjectsInput']").sendKeys("Hindi");
        $x("//*[@id='subjectsInput']").pressTab();

        // check-box

        $x("//label [@for = 'hobbies-checkbox-1']").click();
        //<label title="" for="hobbies-checkbox-1" class="custom-control-label">Sports</label>
        $x("//label [contains (@for, 'hobbies-checkbox-2')]").click();
        //<label title= for="hobbies-checkbox-2" class="custom-control-label">Reading</label>
        $x("//label [text() = 'Music']").click();
        //<label title="" for="hobbies-checkbox-3" class="custom-control-label">Music</label>

        //label[.='Sports']


        //fileUpload
//        $x("//input[@id ='uploadPicture']").uploadFile(new File("src/test/data/IMG_20220709_205901.jpg"));
        $x("//input[@id ='uploadPicture']").uploadFromClasspath("1.png"); // смотрит сразу в папку resourses, работает только с элеменотом у которого есть type=file

        //text area
        $x("//textarea[@id='currentAddress']").setValue("г. Санкт- Петербург, ул. Рубинштейна 26");

        // drop down menu
//        $x("//div[@class=' css-2b097c-container']//input[@id = 'react-select-3-input']").setValue("NCR").pressTab();
        $x("//div[@id ='stateCity-wrapper']//div[@id= 'state']").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
//        $x("//div[@id='react-select-3-option-0']").click();//NCR, devtools break point
        $x("//input[@id = 'react-select-4-input']").setValue("Delhi").pressTab();

        //Submit button
        $x("//button[@id = 'submit']").click();
        //Modal window

        $(".modal-dialog").should(appear); // появился или нет :)
        $x("//*[@class = 'modal-dialog modal-lg']").shouldBe(Condition.visible, Duration.ofMillis(30));

        $x("//*[@class = 'modal-dialog modal-lg']//thead").shouldHave(text("Label Values"));
        $x("//*[@class = 'modal-dialog modal-lg']//tbody").shouldHave(text("Student Name Vadim Dinislamov"), text("Student Email nokia.finlyandia@yandex.ru"), text("Gender Male"), text("Mobile 8906841755"));
//        $x("//*[@class = 'modal-dialog modal-lg']//tbody").shouldHave(text("Student Email nokia.finlyandia@yandex.ru"));
//        $x("//*[@class = 'modal-dialog modal-lg']//tbody").shouldHave(text("Gender Male"));
//        $x("//*[@class = 'modal-dialog modal-lg']//tbody").shouldHave(text("Mobile 8906841755"));
        $x("//*[@class = 'modal-dialog modal-lg']//tbody").shouldHave(text("Date of Birth 17 February,2082"));
        $x("//*[@class = 'modal-dialog modal-lg']//tbody").shouldHave(text("Subjects Hindi"));
        $x("//*[@class = 'modal-dialog modal-lg']//tbody").shouldHave(text("Hobbies Sports, Reading, Music"));
        $x("//*[@class = 'modal-dialog modal-lg']//tbody").shouldHave(text("1.png"));
        $x("//*[@class = 'modal-dialog modal-lg']//tbody").shouldHave(text("Address г. Санкт- Петербург, ул. Рубинштейна 26"));
        $x("//*[@class = 'modal-dialog modal-lg']//tbody").shouldHave(text("State and City NCR Delhi"));
        $x("//button[@id='closeLargeModal']").click();

    }
}
