package starter.stepdefinitions.Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Login.Authorized;

public class AuthorizedSteps {
    @Steps
    Authorized authorized;

    @Given("I set authorization url")
    public void iSetUrl() {
        authorized.setUrl();
    }
    @When("I send request post with valid username and password")
    public void iSendRequestPostWithValidUsernameAndPassword() {
        authorized.requestValid();
    }

    @Then("My username and password is authorized")
    public void myUsernameAndPasswordIsAuthorized() {
        authorized.isAuthorized();
    }

    @When("I send request post with invalid username and password")
    public void iSendRequestPostWithInvalidUsernameAndPassword() {
        authorized.requestInvalid();
    }


    @Then("I get error not found")
    public void iGetErrorNotFound() {
        authorized.errorNotFound();
    }

    @Then("I get error code {int}")
    public void iGotErrorCode(int code) {
        authorized.errorCode(code);
    }

    @When("I send request post with null username and password")
    public void iSendRequestPostWithNullUsernameAndPassword() {
    }
}
