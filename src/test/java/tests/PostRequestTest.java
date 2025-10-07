package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;

public class PostRequestTest extends BaseTest {

    @Test
    public void verifyCreatePost() {
        test = extent.createTest("POST Create Post Test");

        String endpoint = "/posts";

        String requestBody = """
                {
                    "title": "API Automation Post",
                    "body": "This post was created using RestAssured",
                    "userId": 1
                }
                """;

        Response response = ApiUtils.sendPost(endpoint, requestBody);

        try {
            Assert.assertEquals(response.getStatusCode(), 201, "Status code mismatch");
            Assert.assertTrue(response.getBody().asString().contains("API Automation Post"));
            test.pass("POST request successful ✅");
        } catch (AssertionError e) {
            test.fail("POST request failed ❌: " + e.getMessage());
            throw e;
        }
    }
}
