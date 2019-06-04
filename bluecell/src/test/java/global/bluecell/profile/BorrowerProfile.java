package global.bluecell.profile;

import global.bluecell.login.BorrowerLogin;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BorrowerProfile {

    @BeforeClass
    public static void goToGetProfile(){

        RestAssured.baseURI="http://api.bluecell.test";
        RestAssured.basePath="/v1";
    }

    @Test
    public void getBorrowerProfile(){

        BorrowerLogin borrowerLogin = new BorrowerLogin();



        given()
                .header("Authorization","Bearer" + )
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
