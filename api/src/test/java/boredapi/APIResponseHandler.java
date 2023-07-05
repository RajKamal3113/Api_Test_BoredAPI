package boredapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import listener.Log;
import org.testng.Assert;
import tests.BaseClass;

import static io.restassured.RestAssured.given;

@SuppressWarnings("all")
public class APIResponseHandler extends BaseClass implements APIHandler {
    @Override
    public Response ActivityByTypeAndParticipants(String type, int participants) {
        Log.info("Get activity by type and by quantity of participants");
        Log.info("Endpoint: " + RestAssured.baseURI + APIHandler.activityResource);
        Response RandomActivityResponse =
                given()
                        .queryParam("type", type)
                        .queryParam("participants", participants)
                        .get(APIHandler.activityResource)
                        .then()
                        .extract().response();
        try {
            Assert.assertEquals(RandomActivityResponse.statusCode(), 200);
            Log.info("Activity for " + participants + " participant(s) and type " + type + " retrieved successfully");
            Log.info("Response body: \n" + RandomActivityResponse.getBody().asString());
            return RandomActivityResponse;

        } catch (AssertionError e) {
            Log.info("Get activity by type and by quantity of participants failed with status code of: " + RandomActivityResponse.statusCode());
            Log.info("Response body: \n" + RandomActivityResponse.getBody().asString());
            Assert.assertEquals(RandomActivityResponse.statusCode(), 200);
            return RandomActivityResponse;
        }
    }
}
