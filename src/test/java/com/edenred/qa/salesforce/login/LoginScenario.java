package com.edenred.qa.salesforce.login;

import com.edenred.qa.salesforce.login.steps.Authenticate;
import com.edenred.qa.salesforce.login.steps.StartFrom;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class LoginScenario {
    @ParameterType("STANDARD")
    public USERTYPE userType(String userType){
        return USERTYPE.valueOf(userType);
    }
    @Steps
    StartFrom startFrom;
    @Steps
    Authenticate authenticate;
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        startFrom.loginPage();
    }

    @When("I Login as {userType} user with the correct credentials")
    public void iLoginAsStandardUser(USERTYPE usertype) {
        authenticate.as(usertype);
    }

    @Then("I am on the Home Page")
    public void iLandOnTheHomePage() {

    }
}
