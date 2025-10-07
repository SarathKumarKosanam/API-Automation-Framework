package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import utils.ApiUtils;

public class DeleteRequestTest extends BaseTest {

    @Test
    public void deletePost() {
        test = extent.createTest("DELETE Post Test");

        String url = "http://localhost:3000/posts/1"; // Delete post with ID 1
        Response response = ApiUtils.sendDelete(url);

        try {
            Assert.assertEquals(response.getStatusCode(), 200);
            test.pass("DELETE request successful ✅");
        } catch (AssertionError e) {
            test.fail("DELETE request failed ❌: " + e.getMessage());
            throw e;
        }
    }
}
