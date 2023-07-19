package googleMaps;

import api_TDO.LocationDTO;
import api_TDO.PostDTOLombock;
import api_TDO.ResponsePostDTO;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class DtoExampleTest {

    private static final String ENDPOINT = "/add/json";
    private String url = "https://rahulshettyacademy.com/maps/api/place";
    private String body = "{\n" +
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

    private List<String> generateTypes() {
        ArrayList<String> types = new ArrayList<String>();
        types.add("shoe park");
        types.add("shop");
        return types;
    }

    PostDTOLombock bodyDTO = PostDTOLombock.builder()
            .location(new LocationDTO(-38.4444, 33.444444))
            .accuracy(50)
            .name("some house")
            .language("French-IN")
            .types(this.generateTypes())
            .build();

    public ResponsePostDTO sendPostForGet(String key, String valueKey, String body, String url) {
        return given()
                .contentType(ContentType.JSON)
                .body(bodyDTO)
                .queryParam(key, valueKey)
                .basePath(url)
                .when()
                .post(ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .response()
                .getBody()
                .as(ResponsePostDTO.class);
    }
}
