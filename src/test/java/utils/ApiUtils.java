package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiUtils {

    // GET request
    public static Response sendGet(String url) {
        return RestAssured.get(url);
    }

    // POST request
    public static Response sendPost(String url, String body) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .post(url);
    }

    // PUT request
    public static Response sendPut(String url, String body) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .put(url);
    }

    // PATCH request
    public static Response sendPatch(String url, String body) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .patch(url);
    }

    // DELETE request
    public static Response sendDelete(String url) {
        return RestAssured.delete(url);
    }
}
