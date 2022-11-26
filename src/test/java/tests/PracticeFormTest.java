package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    private String firstName = "Ivan",
            lastName = "Ivanov",
            userEmail = "test@test.test",
            userGender = "Male",
            userBirthDay = "30",
            userBirthMonth = "July",
            userBirthYear = "2008",
            userPhone = "8800123456",
            userSubject ="Maths",
            userHobby ="Music",
            userPicture="tst.jpg",
            userLocation = "Test Location 129",
            userState = "NCR",
            userCity = "Delhi";

    @Test
    void formTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userPhone)
                .setBirthDate(userBirthDay, userBirthMonth, userBirthYear)
                .setSubject(userSubject)
                .setHobbies(userHobby)
                .uploadPicture(userPicture)
                .setAddress(userLocation)
                .setState(userState)
                .setCity(userCity)
                .clickSubmit();

        registrationPage.verifyResultModalAppears();

        registrationPage.verifyResult("Student Name", firstName + ' ' + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", userBirthDay + ' ' + userBirthMonth + ',' + userBirthYear)
                .verifyResult("Subjects", userSubject)
                .verifyResult("Hobbies", userHobby)
                .verifyResult("Picture", userPicture)
                .verifyResult("Address", userLocation)
                .verifyResult("State and City", userState + ' ' + userCity);
    }
}