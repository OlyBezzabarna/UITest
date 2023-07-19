package googleMaps;

import api_TDO.ResponseDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AddTest {

    @Test
    public void testPostRouteAvailability() {

        String baseUrl = "https://rahulshettyacademy.com/maps/api/place";
        String endpoint = "/add/json";

        String jsonPayload = "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.4444,\n" +
                "    \"lng\": 33.444444\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"some house\",\n" +
                "  \"phone_number\": \"(+38) 555 555 5555\",\n" +
                "  \"address\": \"some adress\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";

        RestAssured.baseURI = baseUrl;

        Response response = given()
                .contentType(ContentType.JSON)
                .body(jsonPayload)
                .queryParam("key", "qaclick123")
                .when()
                .post(endpoint)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response();

        System.out.println(response.body().asString());

        String msg = JsonPath.from(response.asString()).getString("place_id");
        System.out.println(msg);

        ResponseDTO responseDTO = response.getBody().as(ResponseDTO.class);
        System.out.println(responseDTO.getStatus());
    }
}