package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private final String TITLE_TEXT = "Student Registration Form";

    private final  SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            email = $("#userEmail"),
            gender = $("#gender-radio-2").parent(),
            number = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobby = $("#hobbiesWrapper").$(byText("Sports")),
            pictureUpload = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateNcrInput = $("#stateCity-wrapper").$(byText("NCR")),
            cityInput = $("#city"),
            cityDelhi = $("#stateCity-wrapper").$(byText("Delhi")),
            submitPush = $("#submit");


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

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirth.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobby() {
        hobby.click();
        return this;
    }

    public RegistrationPage setPicture() {
        pictureUpload.uploadFromClasspath("img/my.jpg");
        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage setState() {
        stateInput.click();
        stateNcrInput.click();
        return this;
    }

    public RegistrationPage setCity() {
        cityInput.click();
        cityDelhi.click();
        return this;
    }

    public RegistrationPage setSubmit() {
        submitPush.click();
        return this;
    }

    public RegistrationPage verifyResultModalAppear() {
        registrationResultsModal.verifyModalAppear();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

}
