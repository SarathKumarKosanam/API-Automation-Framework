package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import utils.ApiUtils;

public class PostRequestTest extends BaseTest {

    @Test
    public void createNewPost() {
        test = extent.createTest("POST Post Test");

        String url = "http://localhost:3000/posts";
        String jsonBody = "{ \"title\": \"Kishore Automation\", \"author\": \"QA Tester\" }";

        Response response = ApiUtils.sendPost(url, jsonBody);

        try {
            Assert.assertEquals(response.getStatusCode(), 201);
            Assert.assertTrue(response.getBody().asString().contains("title"));
            test.pass("POST request successful ✅");
        } catch (AssertionError e) {
            test.fail("POST request failed ❌: " + e.getMessage());
            throw e;
        }
    }
}
