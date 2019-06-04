package global.bluecell.login;

import global.bluecell.model.Login;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BorrowerLogin {

    @BeforeClass
    public static void goToLogin(){

        RestAssured.baseURI="http://api.bluecell.test";
        RestAssured.basePath="/v1/login";

    }

    @Test
    public void borrowerLogin(){

        Login borrowerLogin = new Login();

        borrowerLogin.setEmail("sltanatwork+borrower2@gmail.com");
        borrowerLogin.setPassword("Qwer1234");
        borrowerLogin.setCaptcha("aaa");
        borrowerLogin.setLogin_type("member");

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(borrowerLogin)
                .post()
                .then()
                .statusCode(200);

        Response response = given()
                                .contentType(ContentType.JSON)
                                .when()
                                .body(borrowerLogin)
                                .post()
                                .then()
                                .extract().response();

        System.out.print(response.prettyPeek());

        String token = response.path("data.access_token").toString();

        System.out.print(token);

    }

    @Test
    public void getBorrowerProfile(){

        given()
                .header("Authorization","Bearer" + RestAssured.);
                .when()
                .get("/profile")
                .then()
                .statusCode(200);

        Response response = given()
                .when()
                .get("/profile");

        System.out.println(response.body().prettyPrint());
    }

}
