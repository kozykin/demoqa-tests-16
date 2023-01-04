package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
public class PracticeFormTest extends TestBase{

    @Test
    @Tag("smoke")
    void formTest() {

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.userGender)
                .setUserNumber(testData.userPhone)
                .setBirthDate(testData.userBirthDay, testData.userBirthMonth, testData.userBirthYear)
                .setSubject(testData.userSubject)
                .setHobbies(testData.userHobby)
                .uploadPicture(testData.userPicture)
                .setAddress(testData.userLocation)
                .setState(testData.userState)
                .setCity(testData.userCity)
                .clickSubmit();

        registrationPage.verifyResultModalAppears();

        registrationPage.verifyResult("Student Name", testData.firstName + ' ' + testData.lastName)
                .verifyResult("Student Email", testData.userEmail)
                .verifyResult("Gender", testData.userGender)
                .verifyResult("Mobile", testData.userPhone)
                .verifyResult("Date of Birth", testData.userBirthDay + ' ' + testData.userBirthMonth + ',' + testData.userBirthYear)
                .verifyResult("Subjects", testData.userSubject)
                .verifyResult("Hobbies", testData.userHobby)
                .verifyResult("Picture", testData.userPicture)
                .verifyResult("Address", testData.userLocation)
                .verifyResult("State and City", testData.userState + ' ' + testData.userCity);
    }
}