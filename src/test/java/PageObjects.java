
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;


public class PageObjects extends TestBase {

    @Test
    void successfulRegisterTests() {
        Faker faker = new Faker( (new Locale("en")) );

       String userFirstName = faker.name().firstName(),
                userLastName = faker.name().lastName(),
                email = faker.internet().emailAddress() ,
                number = faker.phoneNumber().subscriberNumber(10) ,
                day = "17",
                month = "December",
                year = "1991",
                subject = "Maths",
                address = faker.lebowski().quote() ;


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

