package com.qa.pageobject.testdata;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.qa.pageobject.testdata.RandomData.*;

public class UserData {

    public String
            firsName,
            lastName,
            Email,
            Gender,
            Phone,
            Subjects,
            Hobbies,
            Picture,
            CurrentAddress,
            State,
            City;
    public Date birthday;

    public UserData() {

        this.firsName = getRandomFirstName();
        this.lastName = getRandomLastName();
        this.Email = getRandomEmail();
        this.Gender = getRandomGender();
        this.Phone = getRandomPhone(10);
        this.birthday = getRandomBirthday();
        this.Subjects = getRandomSubject();
        this.Hobbies = getRandomHobbies();
        this.Picture = "img/Wow.jpg";
        this.CurrentAddress = getRandomAddress();
        this.State = getRandomState();
        this.City = getRandomCity(State);

    }

    public String getBirthday() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM,yyyy", Locale.ENGLISH);
        return formatter.format(birthday);
    }


}
