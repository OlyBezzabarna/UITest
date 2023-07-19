package postman;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetNewTest {
    @Test
    public void testGetText() {
        String baseUrl = "https://rahulshettyacademy.com/maps/api/place";
        String booksEndpoint = "/get/json";

        RestAssured.baseURI = baseUrl;

        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("key", "qaclick123")
                .queryParam(" place_id", "8d2573bdf6ceec0e474c5f388fa917fb")
                .when()
                .get(booksEndpoint)
                .then()
          //      .statusCode(200)
                .and()
                .extract()
                .response();

        System.out.println(response.body().asString());
    }
}
