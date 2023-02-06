import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class practiceFormDemoQa {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";

    }

    @Test
    void studentRegistrationForm() {
        String userFirstName = "Vadim";
        String userSecondName = "Dinislamov";
        String userEmail = "nokia.finlyandia@yandex.ru";
        String userPhone = "89068417552";

        open("/automation-practice-form"); // relative link
//        Selenide.executeJavaScript("$('#fixedban').remove()"); remove elements
//        Selenide.executeJavaScript("$('footer').remove()");

        //fill form

        //css
        $("#firstName").setValue(userFirstName);
        //$ ("#lastName").setValue(userSecondName);
        //$ ("submit").click();

        //xpath
        /* $x("[firstName]").setValue(userFirstName);
        $(by("id", "firstName")).setValue(userFirstName);
        $x("[id=firstName]").setValue(userFirstName);
        $x("#firstName").setValue(userFirstName);*/

        $x("//div[@id='userName-wrapper']//input[@id='lastName']").setValue(userSecondName);
        $x("//div[@id='userEmail-wrapper']//input[@id='userEmail']").setValue(userEmail);

        //<label title="" for="gender-radio-1" class="custom-control-label">Male</label>
        $x("//div[@id= 'genterWrapper']//label [text() = 'Male' and @for = 'gender-radio-1']").click();
        $x("//div[@id='userNumber-wrapper']//input[@id='userNumber']").setValue(userPhone);

        //calendar picker

        $x("//input[@id='dateOfBirthInput']").click();
        $x("//*[@class='react-datepicker__month-select']").selectOption("February");
//        $x("//option[@value ='4']").click();
//        $x("//option[@value ='1994']").click();
        $x("//*[@class ='react-datepicker__year-dropdown-container react-datepicker__year-dropdown-container--select']").click();
        $x("//*[@class ='react-datepicker__year-select']").selectOptionByValue("2082");
        $x("//div[@class ='react-datepicker__day react-datepicker__day--017']").click();

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

        $(".modal-dialog").should(appear); // появился или нет :) its alive
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
