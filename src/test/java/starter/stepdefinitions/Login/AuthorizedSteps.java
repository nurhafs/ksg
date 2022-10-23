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
        authorized.reqestInvalid();
    }


    @Then("I get error not found")
    public void iGetErrorNotFound() {
        authorized.errorNotFound();
    }
}
