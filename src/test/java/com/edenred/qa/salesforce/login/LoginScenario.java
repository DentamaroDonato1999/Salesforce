package com.edenred.qa.salesforce.login;

import com.edenred.qa.salesforce.login.steps.Authenticate;
import com.edenred.qa.salesforce.login.steps.StartFrom;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.openqa.selenium.UsernameAndPassword;

import java.util.Map;

public class LoginScenario {

    @Steps
    StartFrom startFrom;
    @Steps
    Authenticate authenticate;
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        startFrom.loginPage();
    }

    @When("I Login as standard user with the correct credentials")
    public void iLoginAsStandardUser(DataTable data) {
        Map<String,String> credentials = data.asMaps(String.class, String.class).get(0);
        authenticate.as(new UsernameAndPassword(credentials.get("username"), credentials.get("password")));
    }

    @Then("I am on the Home Page")
    public void iLandOnTheHomePage() {

    }
}
