package com.edenred.qa.salesforce.home;

import com.edenred.qa.salesforce.login.USERTYPE;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageScenario {



    @When("I select the application {string}")
    public void iSelectTheApplication(String appName) {
        //navigateTo.application(appName);
    }

    @Given("I am logged as {userType} user")
    public void iAmLoggedAsStandardUser(USERTYPE usertype) {
        //navigateTo.homePage(usertype);
    }

}
