package postman;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateNewTest {
    @Test
    public void testPostRouteAvailability() {

        String baseUrl = "https://rahulshettyacademy.com/maps/api/place";
        String endpoint = "/update/json";

        String jsonBody = "{\n" +
                "  \"place_id\":\"8d2573bdf6ceec0e474c5f388fa917fb\",\n" +
                "  \"address\":\"70 Summer walk, USA\",\n" +
                "  \"key\":\"qaclick123\"\n" +
                "}";

        RestAssured.baseURI = baseUrl;

        Response response = given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .queryParam("key", "qaclick123")
                .when()
                .put(endpoint)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response();

        System.out.println(response.body().asString());
    }
}
