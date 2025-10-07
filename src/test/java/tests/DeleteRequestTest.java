package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;

public class DeleteRequestTest extends BaseTest {

    @Test
    public void verifyDeletePost() {
        test = extent.createTest("DELETE Post Test");

        String endpoint = "/posts/1";

        Response response = ApiUtils.sendDelete(endpoint);

        try {
            Assert.assertEquals(response.getStatusCode(), 200);
            test.pass("DELETE request successful ✅");
        } catch (AssertionError e) {
            test.fail("DELETE request failed ❌: " + e.getMessage());
            throw e;
        }
    }
}
