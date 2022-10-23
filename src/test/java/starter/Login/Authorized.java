package starter.Login;


import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;

public class Authorized {
    private String url;

    public void setUrl() {
        url="https://demoqa.com/Account/v1/Authorized";
    }

    public JSONObject validAccount() {
        JSONObject body = new JSONObject();
        body.put("userName", "b");
        body.put("password", "AkjHg2397><.,fe!");
        return body;
    }

    public JSONObject invalidAccount() {
        JSONObject body = new JSONObject();
        body.put("userName", "sadohnf");
        body.put("password", "AkjHg2397><.,fe!");
        return body;
    }

    public void requestValid() {
        given().header("Content-Type", "application/json")
                .body(validAccount().toJSONString());
        when().post(url);
    }

    public void reqestInvalid() {
        given().header("Content-Type", "application/json")
                .body(invalidAccount().toJSONString());
        when().post(url);
    }

    public void isAuthorized() {
        then().statusCode(200);
    }

    public void errorNotFound() {
        then().statusCode(404);
        then().body("code", equalTo("1207"));
        then().body("message", equalTo("User not found!"));

    }
}
