package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;

public class PatchRequestTest extends BaseTest {

    @Test
    public void verifyPartialUpdatePost() {
        test = extent.createTest("PATCH Update Post Title Test");

        String endpoint = "/posts/1";

        String requestBody = """
                {
                    "title": "Patched Title"
                }
                """;

        Response response = ApiUtils.sendPatch(endpoint, requestBody);

        try {
            Assert.assertEquals(response.getStatusCode(), 200);
            Assert.assertTrue(response.getBody().asString().contains("Patched Title"));
            test.pass("PATCH request successful ✅");
        } catch (AssertionError e) {
            test.fail("PATCH request failed ❌: " + e.getMessage());
            throw e;
        }
    }
}
