
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PageObjects extends TestBase {

    @Test
    void successfulRegisterTests() {
        String userFirstName = "Botakoz",
                userLastName = "Utebaliyeva",
                email = "Botakoz@gmail.com",
                number = "7777777777";


        registrationPage.openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(email)
                .setGender()
                .setNumber(number)
                .setBirthDate("17","December","1991");



        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("img/my.jpg");

        $("#currentAddress").setValue("Kazakhstan Almaty");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userFirstName), text(userLastName), text("Delhi"));

    }

}

