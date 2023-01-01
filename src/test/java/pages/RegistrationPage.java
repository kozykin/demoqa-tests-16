package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModel;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultModel registrationResultModel = new RegistrationResultModel();
    public final String TITLE_TEXT="Student Registration Form";

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput =  $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement genderRadioButtons = $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement userBirthDayInput = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesCheckBoxes = $("#hobbiesWrapper");
    private SelenideElement uploadPictureButton = $("#uploadPicture");
    private SelenideElement addressField = $("#currentAddress");
    private SelenideElement stateButton = $("#state");
    private SelenideElement cityButton = $("#city");
    private SelenideElement stateCityList =$("#stateCity-wrapper");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement modalContent = $(".modal-content");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
               $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderRadioButtons.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        userBirthDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesCheckBoxes.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPictureButton.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressField.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateButton.click();
        stateCityList.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityButton.click();
        stateCityList.$(byText(value)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyResultModalAppears() {
        registrationResultModel.verifyModalAppears("Thanks for submitting the form");
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModel.verifyResult(key, value);
        return this;
    }

}
