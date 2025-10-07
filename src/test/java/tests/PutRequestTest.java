package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;

public class PutRequestTest extends BaseTest {

    @Test
    public void verifyUpdatePost() {
        test = extent.createTest("PUT Update Post Test");

        String endpoint = "/posts/1";

        String requestBody = """
                {
                    "id": 1,
                    "title": "Updated Title",
                    "body": "This post was updated using PUT request",
                    "userId": 1
                }
                """;

        Response response = ApiUtils.sendPut(endpoint, requestBody);

        try {
            Assert.assertEquals(response.getStatusCode(), 200);
            Assert.assertTrue(response.getBody().asString().contains("Updated Title"));
            test.pass("PUT request successful ✅");
        } catch (AssertionError e) {
            test.fail("PUT request failed ❌: " + e.getMessage());
            throw e;
        }
    }
}
