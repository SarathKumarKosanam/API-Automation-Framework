package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import utils.ApiUtils;

public class GetRequestTest extends BaseTest {

    @Test
    public void verifyGetPosts() {
        test = extent.createTest("GET Posts Test");

        String endpoint = "/posts";  // relative endpoint only
        Response response = ApiUtils.sendGet(endpoint);

        try {
            Assert.assertEquals(response.getStatusCode(), 200);
            Assert.assertTrue(response.getBody().asString().contains("title"));
            test.pass("GET request successful ✅");
        } catch (AssertionError e) {
            test.fail("GET request failed ❌: " + e.getMessage());
            throw e;
        }
    }
}
