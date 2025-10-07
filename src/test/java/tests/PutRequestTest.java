package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import utils.ApiUtils;

public class PutRequestTest extends BaseTest {

    @Test
    public void updatePostFully() {
        test = extent.createTest("PUT Post Test");

        String url = "http://localhost:3000/posts/1"; // Update post with ID 1
        String jsonBody = "{ \"title\": \"Updated Title\", \"author\": \"Updated Author\" }";

        Response response = ApiUtils.sendPut(url, jsonBody);

        try {
            Assert.assertEquals(response.getStatusCode(), 200);
            Assert.assertTrue(response.getBody().asString().contains("Updated Title"));
            Assert.assertTrue(response.getBody().asString().contains("Updated Author"));
            test.pass("PUT request successful ✅");
        } catch (AssertionError e) {
            test.fail("PUT request failed ❌: " + e.getMessage());
            throw e;
        }
    }
}
