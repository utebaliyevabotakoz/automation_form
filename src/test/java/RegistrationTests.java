import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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


            $("#firstName").setValue(userFirstName);
            $("#lastName").setValue(userLastName);
            $("#userEmail").setValue("Botakoz@gmail.com");
            $("#gender-radio-2").parent().click();
            $("#userNumber").setValue("+77073011202");


            $("#currentAddress").setValue("Kazakhstan Almaty");

            $("#submit").click();


            $("#output").shouldBe(Condition.visible);


            $("#output #email").shouldHave(text("Botakoz@gmail.com"));
            $("#output #currentAddress").shouldHave(text("address 1"));
            $("#output #permanentAddress").shouldHave(text("address 2"));

        }

    }
