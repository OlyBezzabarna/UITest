package postman;

import api_TDO.ResponseDTO;
import api_TDO.ResponsePostDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AddNewTest {
    @Test
    public void testPostRouteAvailability() {

        String baseUrl = "https://rahulshettyacademy.com/maps/api/place";
        String endpoint = "/add/json";

        String jsonBody = "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"some house\",\n" +
                "  \"phone_number\": \"(+38) 095 66 66 666\",\n" +
                "  \"address\": \"11, Some Adress\",\n" +
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
                .body(jsonBody)
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

        ResponsePostDTO responseDTO = response.getBody().as(ResponsePostDTO.class);
        System.out.println(responseDTO.getStatus());
    }
}
