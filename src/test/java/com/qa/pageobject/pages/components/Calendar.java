package com.qa.pageobject.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class Calendar {
//    public void setDate(String day, String month, String year) {
//
//        $(".react-datepicker__month-select").selectOption(month);
//        $(".react-datepicker__year-select").selectOption(year);
//        $(".react-datepicker__day--0" + day + "" + ":not(.react-datepicker__day--outside-month").click();

    public void setDate(String date) {
        String[] forNumber = date.split(" ");
        String[] dates = forNumber[1].split(",");

        $(".react-datepicker__month-select").selectOption(dates[0].trim());
        $(".react-datepicker__year-select").selectOption(dates[1]);
        $(".react-datepicker__day--0" + forNumber[0] +
                ":not(.react-datepicker__day--outside-month)").click();

    }
}