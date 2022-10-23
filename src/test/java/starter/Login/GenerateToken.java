package starter.Login;

import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class GenerateToken {
    private String url, token;

    public void setUrl() {
        url="https://demoqa.com/Account/v1/GenerateToken";
    }

    public void setValidToken() {
        token = "Basic " + "Z2Y6S0hBODkzMHV0OTsnOyc7JztfXyErZGY=";
    }

    public JSONObject registeredAccount() {
        JSONObject body = new JSONObject();
        body.put("userName", "b");
        body.put("password", "AkjHg2397><.,fe!");
        return body;
    }

    public JSONObject unregisteredAccount() {
        JSONObject body = new JSONObject();
        body.put("userName", "sadohnf");
        body.put("password", "AkjHg2397><.,fe!");
        return body;
    }

    public void requestWithRegisteredAccount() {
        given().header("Content-Type", "application/json")
                .header("accept", "application/json")
                .header("Authorization", "piplup")
                .header("authorization", token)
                .body(registeredAccount().toJSONString());
        when().post(url);
    }

    public void requestWithUnregisteredAccount() {
        given().header("Content-Type", "application/json")
                .header("accept", "application/json")
                .header("Authorization", "piplup")
                .header("authorization", token)
                .body(unregisteredAccount().toJSONString());
        when().post(url);
    }

    public void requestWithoutAuthorization() {
        given().header("Content-Type", "application/json")
                .header("accept", "application/json")
                .body(registeredAccount().toJSONString());
        when().post(url);
    }
    public void verifyGetToken() {
        then().statusCode(200);
        then().body("token", notNullValue());
        then().body("expires", notNullValue());
        then().body("status", equalTo("Success"));
        then().body("result", equalTo("User authorized successfully."));
    }


    public void verifyDontGetToken() {
        then().statusCode(200);
        then().body("token", nullValue());
        then().body("expires", nullValue());
        then().body("status", equalTo("Failed"));
        then().body("result", equalTo("User authorization failed."));
    }

    public void verifyBanned() {
        then().statusCode(406);
    }
}
