
import org.junit.jupiter.api.Test;


public class PageObjects extends TestBase {

    @Test
    void successfulRegisterTests() {
        String userFirstName = "Botakoz",
                userLastName = "Utebaliyeva",
                email = "Botakoz@gmail.com",
                number = "7777777777",
                day = "17",
                month = "December",
                year = "1991",
                subject = "Maths",
                address = "Kazakhstan Almaty";


        registrationPage.openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(email)
                .setGender()
                .setNumber(number)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobby()
                .setPicture()
                .setAddress(address)
                .setState()
                .setCity()
                .setSubmit();

        registrationPage.verifyResultModalAppear()
                .verifyResult("Student Name", userFirstName + " " + userLastName)
                .verifyResult("Student Email", email)
                .verifyResult("Subjects", subject)
                .verifyResult("Address", address)
                .verifyResult("Mobile", number);

    }

}

