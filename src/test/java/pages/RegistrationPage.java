package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private final String TITLE_TEXT = "Student Registration Form";

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            email = $("#userEmail"),
            gender = $("#gender-radio-2").parent(),
            number = $("#userNumber");

    public RegistrationPage openPage() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
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
        email.setValue(value);
        return this;
    }

    public RegistrationPage setGender() {
        gender.click();
        return this;
    }

    public RegistrationPage setNumber(String value) {
        number.setValue(value);
        return this;
    }

}
