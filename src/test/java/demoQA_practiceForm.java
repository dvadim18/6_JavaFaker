import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static  com.codeborne.selenide.Selenide.open;

public class demoQA_practiceForm {

    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";

    }

    @Test
    void studentRegistrationForm () throws InterruptedException {
        String userFirstName = "Vadim";
        String userSecondName = "Dinislamov";
        String userEmail = "nokia.finlyandia@yandex.ru";
        String userPhone = "89068417552";

        open( "/automation-practice-form"); // relative link

        //fill form
        //css
        $ ("#firstName").setValue(userFirstName);
//        $ ("#lastName").setValue(userSecondName);
//        $ ("submit").click();

        //xpath
//         $x("[firstName]").setValue(userFirstName);
//        $(by("id", "firstName")).setValue(userFirstName);
//        $x("[id=firstName]").setValue(userFirstName);
//        $x("#firstName").setValue(userFirstName);
        $x("//div[@id='userName-wrapper']//input[@id='lastName']").setValue(userSecondName);
        $x("//div[@id='userEmail-wrapper']//input[@id='userEmail']").setValue(userEmail);
        $x("//div[@id= 'genterWrapper']//label [text() = 'Male' and @for = 'gender-radio-1']").click();
        $x("//div[@id='userNumber-wrapper']//input[@id='userNumber']").setValue(userPhone);

        //calendar picker
        $x("//input[@id='dateOfBirthInput']").click();
        $x("//option[@value ='4']").click();
        $x("//option[@value ='1994']").click();
        $x("//div[@class ='react-datepicker__day react-datepicker__day--008 react-datepicker__day--weekend']").click();

        // autocomplete form
        $x("//*[@id='subjectsInput']").click();
        $x("//*[@id='subjectsInput']").sendKeys("Hindi");
        $x("//*[@id='subjectsInput']").pressTab();











        //selenide assertions
//        $ ("#output").shouldBe(Condition.visible);
//        $ ("#output #name").shouldHave(text(userFirstName));
//        $ ("#output #email").shouldHave(text(userEmail));

    }
/*    void setDateByNme(String name, String date) {
        executeJavaScript(
                String.format("$('[name=\"%s\"]').val('%s')", name , date)
        )
    }*/

}
