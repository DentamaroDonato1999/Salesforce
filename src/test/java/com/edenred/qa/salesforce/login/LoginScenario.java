package com.edenred.qa.salesforce.login;

import com.edenred.qa.salesforce.home.pages.HomePage;
import com.edenred.qa.salesforce.login.steps.Authenticate;
import com.edenred.qa.salesforce.login.steps.StartFrom;
import com.google.inject.Inject;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;

import static com.edenred.qa.salesforce.utils.ReportUtils.attachMessage;
import static com.edenred.qa.salesforce.utils.ReportUtils.attachScreenshot;

public class LoginScenario {
    @ParameterType("STANDARD")
    public USERTYPE userType(String userType){
        return USERTYPE.valueOf(userType);
    }
    @Inject
    StartFrom startFrom;
    @Inject
    Authenticate authenticate;


    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        startFrom.loginPage();
        attachScreenshot("startup");
    }

    @When("I Login as {userType} user with the correct credentials")
    public void iLoginAsStandardUser(USERTYPE usertype) {
        authenticate.as(usertype);
    }

    @Then("I am on the Home Page")
    public void iLandedOnTheHomePage() {
        authenticate.homePage();
        attachScreenshot("home");
    }
    @Given("I am logged as {userType} user")
    public void iAmLoggedAsStandardUser(USERTYPE usertype) {
        iLoginAsStandardUser(usertype);
        iLandedOnTheHomePage();
    }
}
