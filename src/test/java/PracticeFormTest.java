import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    private String firstName = "Ivan";
    private String lastName = "Ivanov";
    private String userEmail = "test@test.test";
    private String userPhone = "8800123456";
    private String userLocation = "Test Location 129";

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void formTest() {

        open("https://demoqa.com/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);

        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue(userPhone);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__year-select").selectOptionByValue("1987");
        $(".react-datepicker__day--001").click();

        $("#subjectsInput").setValue("Maths").pressEnter();

        $("[for='hobbies-checkbox-3']").click();

        $("#uploadPicture").uploadFromClasspath("tst.jpg");

        $("#currentAddress").setValue(userLocation);

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        $(".modal-content").shouldHave(text(firstName),
                text(lastName),
                text(userEmail),
                text("Male"),
                text(userPhone),
                text("01 January,1987"),
                text("Maths"),
                text("Music"),
                text("tst.jpg"),
                text(userLocation),
                text("NCR Delhi"));

    }
}