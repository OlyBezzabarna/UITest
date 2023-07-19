package postman;
import api_TDO.LocationDTO;
import api_TDO.PostDTOLombock;
import api_TDO.ResponsePostDTO;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiTests {
    private static final String BASE_URL = "https://example.com/";
    private static final String ENDPOINT = "api/entity";


    private List<String> generateTypes() {
        ArrayList<String> types = new ArrayList<String>();
        types.add("shoe park");
        types.add("shop");
        return types;
    }

    private PostDTOLombock createEntity() {
        PostDTOLombock entityDTO = PostDTOLombock.builder()
                .location(new LocationDTO(-38.4444, 33.444444))
                .accuracy(50)
                .name("some house")
                .language("French-IN")
                .types(this.generateTypes())
                .build();

        ResponsePostDTO responseDTO = given()
                .contentType(ContentType.JSON)
                .body(entityDTO)
                .when()
                .post(BASE_URL + ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(ResponsePostDTO.class);

        Assertions.assertNotNull(responseDTO.getPlace_id(), "Failed to create entity");

        return entityDTO;
    }

    private void verifyEntityFields(PostDTOLombock expectedEntity, PostDTOLombock actualEntity) {
        Assertions.assertEquals(expectedEntity.getLocation().getLat(), actualEntity.getLocation().getLat());
        Assertions.assertEquals(expectedEntity.getLocation().getLng(), actualEntity.getLocation().getLng());
        Assertions.assertEquals(expectedEntity.getAccuracy(), actualEntity.getAccuracy());
        Assertions.assertEquals(expectedEntity.getName(), actualEntity.getName());
        Assertions.assertEquals(expectedEntity.getLanguage(), actualEntity.getLanguage());
        Assertions.assertEquals(expectedEntity.getTypes(), actualEntity.getTypes());
    }

    @Test
    public void testCreateAndGetEntity() {
        PostDTOLombock expectedEntity = createEntity();

        PostDTOLombock actualEntity = given()
                .contentType(ContentType.JSON)
                .queryParam("place_id", expectedEntity.getPlace_id())
                .when()
                .get(BASE_URL + ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(PostDTOLombock.class);

        verifyEntityFields(expectedEntity, actualEntity);

        // Cleanup
        given()
                .contentType(ContentType.JSON)
                .queryParam("place_id", expectedEntity.getPlace_id())
                .when()
                .delete(BASE_URL + ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testCreateGetAndUpdateEntity() {
        PostDTOLombock expectedEntity = createEntity();

        String jsonBody = "{\n" +
                "  \"place_id\":\"" + expectedEntity.getPlace_id() + "\",\n" +
                "  \"address\":\"70 Summer walk, USA\",\n" +
                "  \"key\":\"qaclick123\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .put(BASE_URL + ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK);
        System.out.println(jsonBody);

        PostDTOLombock actualEntity = given()
                .contentType(ContentType.JSON)
                .queryParam("place_id", expectedEntity.getPlace_id())
                .when()
                .get(BASE_URL + ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(PostDTOLombock.class);

        verifyEntityFields(expectedEntity, actualEntity);
        System.out.println (expectedEntity);
        System.out.println (actualEntity);

        // Cleanup
        given()
                .contentType(ContentType.JSON)
                .queryParam("place_id", expectedEntity.getPlace_id())
                .when()
                .delete(BASE_URL + ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
        System.out.println(actualEntity);
    }

//    @Test
//    public void testCreateGetAndUpdateEntity() {
//        PostDTOLombock expectedEntity = createEntity();
//
//        // Update the entity
//
//        expectedEntity.setName("updated house");
//        expectedEntity.getTypes().add("park");
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(expectedEntity)
//                .when()
//                .put(BASE_URL + ENDPOINT)
//                .then()
//                .statusCode(HttpStatus.SC_OK);
//
//        PostDTOLombock actualEntity = given()
//                .contentType(ContentType.JSON)
//                .queryParam("place_id", expectedEntity.getPlace_id())
//                .when()
//                .get(BASE_URL + ENDPOINT)
//                .then()
//                .statusCode(HttpStatus.SC_OK)
//                .extract()
//                .as(PostDTOLombock.class);
//
//        verifyEntityFields(expectedEntity, actualEntity);
//
//        // Cleanup
//        given()
//                .contentType(ContentType.JSON)
//                .queryParam("place_id", expectedEntity.getPlace_id())
//                .when()
//                .delete(BASE_URL + ENDPOINT)
//                .then()
//                .statusCode(HttpStatus.SC_NOT_FOUND);
//    }

    @Test
    public void testDeleteNonExistingEntity() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("place_id", "non_existing_id")
                .when()
                .delete(BASE_URL + ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void testUpdateNonExistingEntity() {
        PostDTOLombock nonExistingEntity = PostDTOLombock.builder()
                .location(new LocationDTO(-38.4444, 33.444444))
                .accuracy(50)
                .name("non_existing")
                .language("English")
                .types(this.generateTypes())
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(nonExistingEntity)
                .when()
                .put(BASE_URL + ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void testGetNonExistingEntity() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("place_id", "non_existing_id")
                .when()
                .get(BASE_URL + ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
