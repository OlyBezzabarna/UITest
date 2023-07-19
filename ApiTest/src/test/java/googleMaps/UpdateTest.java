package googleMaps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateTest {

    @Test
    public void testPostRouteAvailability() {

        String baseUrl = "https://rahulshettyacademy.com/maps/api/place";
        String endpoint = "/update/json";

        String jsonPayload = "{\n" +
                "  \"place_id\":\"bfada973f17a8e8351849119d8da385f\",\n" +
                "  \"address\":\"Kreshatic 55, UA\",\n" +
                "  \"key\":\"qaclick123\"\n" +
                "}";

        RestAssured.baseURI = baseUrl;

        Response response = given()
                .contentType(ContentType.JSON)
                .body(jsonPayload)
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
