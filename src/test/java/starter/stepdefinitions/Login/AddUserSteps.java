package starter.stepdefinitions.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Login.AddUser;

public class AddUserSteps {
    @Steps
    AddUser addUser;

    @Given("I set add user url and valid token")
    public void iSetUrl() {
        addUser.setUrlAndValidToken();
    }


    @And("I send request post login")
    public void iSendRequestPostLogin() {
        addUser.sendRequestPostLogin();
    }

    @Then("I am signed in")
    public void iAmSignedIn() {
        addUser.iAmSignedIn();

    }

    @When("I send request post login with valid username and password")
    public void iSendRequestPostLoginWithValidUsernameAndPassword() {
        addUser.sendWithValidUsernameAndPassword();
    }

    @When("I send request post login with valid username and invalid password")
    public void iSendRequestPostLoginWithValidUsernameAndInvalidPassword() {
        addUser.sendWithValidUsernameAndInvalidPassword();
    }

    @Then("I get null error message")
    public void iGetNullErrorMessage() {
        addUser.iGetNullError();

    }

    @Then("I get invalid error message")
    public void iGetInvalidErrorMessage() {
        addUser.iGetInvalidError();
    }

    @When("I send request post login with existing username and password")
    public void iSendRequestPostLoginWithExistingUsernameAndPassword() {


    }

    @Then("I get existed error message")
    public void iGetExistedErrorMessage() {
    }
}
