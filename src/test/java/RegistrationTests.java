import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {

        @BeforeAll
        static void beforeAll() {
            Configuration.holdBrowserOpen = true;
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://demoqa.com";
        }

        @Test

        void successfulRegisterTests() {
            String userFirstName = "Botakoz";
            String userLastName = "Utebaliyeva";

            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");


            $("#firstName").setValue(userFirstName);
            $("#lastName").setValue(userLastName);
            $("#userEmail").setValue("Botakoz@gmail.com");
            $("#gender-radio-2").parent().click();
            $("#userNumber").setValue("7777777777");

            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("December");
            $(".react-datepicker__year-select").selectOption("1991");
            $(".react-datepicker__day--017").click();

            $("#subjectsInput").setValue("Maths").pressEnter();
           // $("#hobbies-checkbox-1").click();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("img/my.jpg");

            $("#currentAddress").setValue("Kazakhstan Almaty");

            $("#submit").click();



            $("#output").shouldBe(Condition.visible);


            $("#output #email").shouldHave(text("Botakoz@gmail.com"));
            $("#output #currentAddress").shouldHave(text("address 1"));
            $("#output #permanentAddress").shouldHave(text("address 2"));

        }

    }
