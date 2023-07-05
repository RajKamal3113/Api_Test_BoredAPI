package tests;

import boredapi.APIResponseHandler;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class APITests extends BaseClass {

    APIResponseHandler APIResponseHandler;

    @BeforeMethod
    public void setUpTests() {
        APIResponseHandler = new APIResponseHandler();
    }

    @Test(description = "activity by type and for specific no. of participants. Validate response body for activity type and participants")
    public void SpecificActivity() {
        Response Activity = APIResponseHandler.ActivityByTypeAndParticipants("social", 2);
        String activity = Activity.jsonPath().getString("activity");
        String type = Activity.jsonPath().getString("type");
        Integer participants = Activity.jsonPath().getInt("participants");
        Assert.assertEquals(type, "social");
        Assert.assertEquals(participants, 2);
    }
}
