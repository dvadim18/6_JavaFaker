import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static  com.codeborne.selenide.Selenide.open;

public class demoQApracticeForm {

    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";

    }

    @Test
    void studentRegistrationForm () {
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
//        $x("[firstName]").setValue(userFirstName);
//        $(by("id", "firstName")).setValue(userFirstName);
//        $x("[id=firstName]").setValue(userFirstName);
//        $x("#firstName").setValue(userFirstName);
        $x("//div[@id='userName-wrapper']//input[@id='lastName']").setValue(userSecondName);
        $x("//div[@id='userEmail-wrapper']//input[@id='userEmail']").setValue(userEmail);
        $x("//div[@id= 'genterWrapper']//label [text() = 'Male' and @for = 'gender-radio-1']").click();
        $x("//div[@id='userNumber-wrapper']//input[@id='userNumber']").setValue(userPhone);
        $x("//input[@id='dateOfBirthInput']").click();
//        $x("//select[@class='react-datepicker__month-select']").click();
        $x("//option[@value ='4']").click();
        $x("//option[@value ='1994']").click();
        $x("//div[@class ='react-datepicker__day react-datepicker__day--008 react-datepicker__day--weekend']").click();
        $x("//*[@id='subjectsContainer']").click();
        $x("//*[@class='subjects-auto-complete__input']").sendKeys("r");
//        $x("//*[@id='subjectsContainer']").setValue("r");
//        $x("///div[contains(text(), \"Chemistry\")] ").click();










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
