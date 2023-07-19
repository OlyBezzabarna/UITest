package postman;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.HttpHeaders;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static io.restassured.RestAssured.given;

public class WireMockTest {
    private static final String MY_URI = "https://rahulshettyacademy.com/";
    private static final String API = "maps/api/place/";
    private static final String POINT = "get/json";
    private WireMockServer wireMockServer;

    @BeforeEach
    public void setup() {
        wireMockServer = new WireMockServer();
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());
    }

    @Test
    public void getTest() {
        stubFor(WireMock.get(WireMock.urlEqualTo(API))
                .willReturn(aResponse()
                        .withHeaders(HttpHeaders.noHeaders())
                        .withStatus(200)
                        .withBody("{}")));

        given()
                .contentType(ContentType.JSON)
                .queryParam("key", "qaclick123")
                //.queryParam("place_id", "")
                .baseUri(MY_URI)
                .basePath(API)
                .when()
                .get(POINT)
                .then()
                .statusCode(200);
    }

    @AfterEach
    public void tearDown() {
        wireMockServer.stop();
    }
}
