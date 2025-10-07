package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import utils.ApiUtils;

public class PatchRequestTest extends BaseTest {

    @Test
    public void updatePostPartially() {
        test = extent.createTest("PATCH Post Test");

        String url = "http://localhost:3000/posts/1"; // Update post with ID 1
        String jsonBody = "{ \"title\": \"Partially Updated Title\" }";

        Response response = ApiUtils.sendPatch(url, jsonBody);

        try {
            Assert.assertEquals(response.getStatusCode(), 200);
            Assert.assertTrue(response.getBody().asString().contains("Partially Updated Title"));
            test.pass("PATCH request successful ✅");
        } catch (AssertionError e) {
            test.fail("PATCH request failed ❌: " + e.getMessage());
            throw e;
        }
    }
}
