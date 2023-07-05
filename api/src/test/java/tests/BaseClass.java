package tests;

import io.restassured.RestAssured;
import listener.Log;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Properties;

@SuppressWarnings("all")
public class BaseClass {

    @BeforeSuite
    @Parameters("env")
    public void setup(@Optional("bored") String env) {
        Properties p = System.getProperties();
        if (env.equalsIgnoreCase(("bored"))) {
            RestAssured.baseURI = "https://www.boredapi.com/api";
            p.put("env", "qa");
            System.setProperties(p);
        }
        Log.info("environment: " + RestAssured.baseURI);
    }


}
