package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiUtils {

    private static final String BASE_URL = ConfigReader.getProperty("baseUrl");

    // Helper to combine base URL + endpoint
    private static String buildUrl(String endpoint) {
        return BASE_URL + endpoint;
    }

    public static Response sendGet(String endpoint) {
        return RestAssured.get(buildUrl(endpoint));
    }

    public static Response sendPost(String endpoint, String body) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .post(buildUrl(endpoint));
    }

    public static Response sendPut(String endpoint, String body) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .put(buildUrl(endpoint));
    }

    public static Response sendPatch(String endpoint, String body) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .patch(buildUrl(endpoint));
    }

    public static Response sendDelete(String endpoint) {
        return RestAssured.delete(buildUrl(endpoint));
    }
}
