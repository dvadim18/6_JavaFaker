package com.qa.pageobject.pages.components;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationResultsModal {

    public void verifyModalAppears(){

        $(".modal-dialog").should(appear); // появился или нет :)
        $x("//*[@class = 'modal-dialog modal-lg']").shouldBe(Condition.visible, Duration.ofMillis(30));
    }

    public void verifyResult(String key, String value){
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }

    public  void verifyResultSubmit() {
        $x("//button[@id='closeLargeModal']").click();

    }


}

