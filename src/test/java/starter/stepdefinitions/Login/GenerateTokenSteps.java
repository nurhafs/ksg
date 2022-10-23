package starter.stepdefinitions.Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Login.GenerateToken;

public class GenerateTokenSteps {
    @Steps
    GenerateToken generateToken;

    @Given("I set generate token url with authorization")
    public void iSetUrl() {
        generateToken.setUrl();
        generateToken.setValidToken();
    }
    @Then("I get token")
    public void iGetToken() {
        generateToken.verifyGetToken();
    }

    @Then("I don't get token")
    public void iDonTGetToken() {
        generateToken.verifyDontGetToken();
    }

    @When("I send request post with registered username and password")
    public void iSendRequestPostWithRegisteredUsernameAndPassword() {
        generateToken.requestWithRegisteredAccount();
    }

    @When("I send request post with unregistered username and password")
    public void iSendRequestPostWithUnregisteredUsernameAndPassword() {
        generateToken.requestWithUnregisteredAccount();
    }
}
