package boredapi;

import io.restassured.response.Response;

public interface APIHandler {
    String activityResource = "/activity";
    Response ActivityByTypeAndParticipants(String type, int participants);
}
