package global.bluecell.registration;

import global.bluecell.model.Registration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BorrowerRegistration {

    @BeforeClass
    public static void goToRegistration(){

        RestAssured.baseURI="http://api.bluecell.test/";
        RestAssured.basePath="/v1/register";

    }

    @Test
    public void borrowerRegistration(){

        Registration borrowerRegistration = new Registration();

        borrowerRegistration.setName("Dereg Br 3");
        borrowerRegistration.setEmail("sltanatwork+deregbr3@gmail.com");
        borrowerRegistration.setPassword("Qwer1234");
        borrowerRegistration.setPassword_confirmation("Qwer1234");
        borrowerRegistration.setPosition("Dereg Br 3 Position");
        borrowerRegistration.setUen("S61SS0164K");
        borrowerRegistration.setCompany_name("Nam Hong Siang Theon");
        borrowerRegistration.setAccount_type(1);

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(borrowerRegistration)
                .post()
                .then()
                .statusCode(201);

    }

}
