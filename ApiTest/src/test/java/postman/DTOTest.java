package postman;


import api_TDO.LocationDTO;
import api_TDO.PostDTOLombock;
import api_TDO.ResponseDTO;
import api_TDO.ResponsePostDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class DTOTest {
    private static final String POST_ENDPOINT = "/add/json";
    private static final String GET_ENDPOINT = "/get/json";
    private static final String DELETE_ENDPOINT = "/delete/json";
    private static final String UPDATE_ENDPOINT = "/update/json";
    private static final String URL = "https://rahulshettyacademy.com/maps/api/place";

    private static final String KEY = "key";
    private static final String VALUE_KEY = "qaclick123";

//    private String body = "{\n" +
//            "  \"location\": {\n" +
//            "    \"lat\": -38.383494,\n" +
//            "    \"lng\": 33.427362\n" +
//            "  },\n" +
//            "  \"accuracy\": 50,\n" +
//            "  \"name\": \"Some house\",\n" +
//            "  \"phone_number\": \"(+38) 095 66 66 666\",\n" +
//            "  \"address\": \"11, Some Adress\",\n" +
//            "  \"types\": [\n" +
//            "    \"shoe park\",\n" +
//            "    \"shop\"\n" +
//            "  ],\n" +
//            "  \"website\": \"http://google.com\",\n" +
//            "  \"language\": \"French-IN\"\n" +
//            "}";


    private List<String> generateTypes() {
        ArrayList<String> types = new ArrayList<String>();
        types.add("shoe park");
        types.add("shop");
        return types;
    }


    PostDTOLombock bodyDTO = PostDTOLombock.builder()
            .location(new LocationDTO(-38.383494, 33.427362))
            .accuracy(50)
            .name("Some house")
            .phoneNumber("(+38) 095 66 66 666")
            .address("11, Some Adress")
            .types(this.generateTypes())
            .website("http://google.com")
            .language("French-IN")
            .build();

    public ResponsePostDTO sendPostForGet() {
       // String KEY, String VALUE_KEY, PostDTOLombock bodyDTO,
               // String URL, String POST_ENDPOINT
        return given()
                .contentType(ContentType.JSON)
                .body(bodyDTO)
                .queryParam(KEY, VALUE_KEY)
                .basePath(URL)
                .when()
                .post(POST_ENDPOINT)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response()
                .getBody()
                .as(ResponsePostDTO.class);
    }
    @Test
    public void testPostRouteAvailability() {
        RestAssured.baseURI = URL;
        Response response = given()
                .contentType(ContentType.JSON)
                .body(bodyDTO)
                .queryParam(KEY, VALUE_KEY)
                .when()
                .post(URL+POST_ENDPOINT)
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

    @Test
    public void testAddEntityAndGetFields() {
        // Додавання сутності
        RestAssured.baseURI = URL;
        ResponsePostDTO addResponse = sendPostForGet();
       // KEY, VALUE_KEY, bodyDTO, URL, POST_ENDPOINT
        Assertions.assertNotNull(addResponse);
        Assertions.assertNotNull(addResponse.getPlace_id());

        // Отримання сутності та перевірка значень полів
        String getURL = URL + GET_ENDPOINT + "?" + KEY + "=" + VALUE_KEY + "&place_id=" + addResponse.getPlace_id();
        ResponseDTO getResponse;
        getResponse = given()
                .get(getURL)
                .then()
                .statusCode(200)
                .extract()
                .as(ResponseDTO.class);
        Assertions.assertNotNull(getResponse);
        Assertions.assertEquals(bodyDTO.getLocation(), getResponse.getLocation());
        Assertions.assertEquals(bodyDTO.getAccuracy(), getResponse.getAccuracy());
        Assertions.assertEquals(bodyDTO.getName(), getResponse.getName());
        Assertions.assertEquals(bodyDTO.getPhoneNumber(), getResponse.getPhoneNumber());
        Assertions.assertEquals(bodyDTO.getAddress(), getResponse.getAddress());
        Assertions.assertEquals(bodyDTO.getTypes(), getResponse.getTypes());
        Assertions.assertEquals(bodyDTO.getWebsite(), getResponse.getWebsite());
        Assertions.assertEquals(bodyDTO.getLanguage(), getResponse.getLanguage());

        // Видалення сутності
      //  String deleteURL = URL + "/delete/json";
        String deleteBody = "{\"place_id\":\"" + addResponse.getPlace_id() + "\"}";
        given()
                .contentType(ContentType.JSON)
                .body(deleteBody)
                .post(URL+DELETE_ENDPOINT)
                .then()
                .statusCode(200);
    }

    @Test
    public void testAddEntityEditAndGetFields() {
        // Додавання сутності
        RestAssured.baseURI = URL;
        ResponsePostDTO addResponse = sendPostForGet();
        //KEY, VALUE_KEY, bodyDTO, URL, POST_ENDPOINT
        Assertions.assertNotNull(addResponse);
        Assertions.assertNotNull(addResponse.getPlace_id());

        // Отримання сутності та перевірка значень полів
        String getURL = URL + GET_ENDPOINT + "?" + KEY + "=" + VALUE_KEY + "&place_id=" + addResponse.getPlace_id();
        ResponseDTO getResponse = given()
                .get(getURL)
                .then()
                .statusCode(200)
                .extract()
                .as(ResponseDTO.class);
        Assertions.assertNotNull(getResponse);
        Assertions.assertEquals(bodyDTO.getLocation(), getResponse.getLocation());
        Assertions.assertEquals(bodyDTO.getAccuracy(), getResponse.getAccuracy());
        Assertions.assertEquals(bodyDTO.getName(), getResponse.getName());
        Assertions.assertEquals(bodyDTO.getPhoneNumber(), getResponse.getPhoneNumber());
        Assertions.assertEquals(bodyDTO.getAddress(), getResponse.getAddress());
        Assertions.assertEquals(bodyDTO.getTypes(), getResponse.getTypes());
        Assertions.assertEquals(bodyDTO.getWebsite(), getResponse.getWebsite());
        Assertions.assertEquals(bodyDTO.getLanguage(), getResponse.getLanguage());

        // Редагування сутності
       // String editURL = URL + "/update/json";
        String editBody = "{\"place_id\":\"" + addResponse.getPlace_id() + "\",\"address\":\"New Address\",\"key\":\"" + VALUE_KEY + "\"}";
        given()
                .contentType(ContentType.JSON)
                .body(editBody)
                .put(URL+UPDATE_ENDPOINT)
                .then()
                .statusCode(200);

        // Отримання оновленої сутності та перевірка значень полів
        getResponse = given()
                .get(getURL)
                .then()
                .statusCode(200)
                .extract()
                .as(ResponseDTO.class);
        Assertions.assertNotNull(getResponse);
        Assertions.assertEquals("New Address", getResponse.getAddress());

        // Видалення сутності
      //  String deleteURL = URL + "/delete/json";
        String deleteBody = "{\"place_id\":\"" + addResponse.getPlace_id() + "\"}";
        given()
                .contentType(ContentType.JSON)
                .body(deleteBody)
                .post(URL+DELETE_ENDPOINT)
                .then()
                .statusCode(200);
    }

    @Test
    public void testDeleteNonExistingEntity() {
        // Видалення неіснуючої сутності
       // String deleteURL = URL + "/delete/json";
        String deleteBody = "{\"place_id\":\"non_existing_id\"}";
        given()
                .contentType(ContentType.JSON)
                .body(deleteBody)
                .post(URL+DELETE_ENDPOINT)
                .then()
                .statusCode(200);
    }

    @Test
    public void testEditNonExistingEntity() {
        // Редагування неіснуючої сутності
       // String editURL = URL + "/update/json";
        String editBody = "{\"place_id\":\"non_existing_id\",\"address\":\"New Address\",\"key\":\"" + VALUE_KEY + "\"}";
        given()
                .contentType(ContentType.JSON)
                .body(editBody)
                .put(URL+UPDATE_ENDPOINT)
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetNonExistingEntity() {
        // Отримання неіснуючої сутності
        String getURL = URL + GET_ENDPOINT + "?" + KEY + "=" + VALUE_KEY + "&place_id=non_existing_id";
        given()
                .get(getURL)
                .then()
                .statusCode(200);
    }
}

