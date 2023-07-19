package googleMaps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetTest {
    @Test
    public void testGetBooks() {
        String baseUrl = "https://rahulshettyacademy.com/maps/api/place";
        String booksEndpoint = "/get/json";

        RestAssured.baseURI = baseUrl;

        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("key", "qaclick123")
                .queryParam(" place_id", "bfada973f17a8e8351849119d8da385f")
                .when()
                .get(booksEndpoint)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response();

        System.out.println(response.body().asString());
    }
}
