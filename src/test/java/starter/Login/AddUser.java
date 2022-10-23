package starter.Login;

import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;

public class AddUser {
    private String url, token;

    public void setUrlAndValidToken() {
        url="https://demoqa.com/Account/v1/User";
        token = "Basic " + "Z2Y6S0hBODkzMHV0OTsnOyc7JztfXyErZGY=";
    }

    public JSONObject validUsernameAndPassword() {
        JSONObject body = new JSONObject();
        body.put("userName", "orz");
        body.put("password", "AkjHg2397><.,fe!");
        return body;
    }

    public JSONObject noUsernameOrPassword() {
        JSONObject body = new JSONObject();
        body.put("userName", "");
        body.put("password", "");
        return body;
    }

    public JSONObject usernameInvalidPassword() {
        JSONObject body = new JSONObject();
        body.put("userName", "haha");
        body.put("password", "87");
        return body;
    }

    public JSONObject existingUsernameAndPassword() {
        JSONObject body = new JSONObject();
        body.put("userName", "b");
        body.put("password", "AkjHg2397><.,fe!");
        return body;
    }

    public void sendWithValidUsernameAndPassword() {
        given().header("Content-Type", "application/json")
                .body(validUsernameAndPassword().toJSONString());
        when().post(url);
    }

    public void sendRequestPostLogin() {
        given().header("Content-Type", "application/json")
                .body(noUsernameOrPassword().toJSONString());
        when().post(url);
    }

    public void sendWithValidUsernameAndInvalidPassword() {
        given().header("Content-Type", "application/json")
                .body(usernameInvalidPassword().toJSONString());
        when().post(url);
    }

    public void iSendRequestPostLoginWithExistingUsernameAndPassword() {
        given().header("Content-Type", "application/json")
                .body(existingUsernameAndPassword().toJSONString());
        when().post(url);
    }

    public void iAmSignedIn() {
        then().statusCode(201);
    }

    public void iGetNullError() {
        then().statusCode(400);
        then().body("code", equalTo("1200"));
        then().body("message", equalTo("UserName and Password required."));
    }

    public void iGetInvalidError() {
        then().statusCode(400);
        then().body("code", equalTo("1300"));
    }

    public void iGetExistedErrorMessage() {
        then().statusCode(406);
        then().body("code", equalTo("1204"));
        then().body("message", equalTo("User exists!"));
    }

}
