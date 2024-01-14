package com.edenred.qa.salesforce.home;

import com.edenred.qa.salesforce.assertions.WebAssertions;
import com.edenred.qa.salesforce.home.pages.HomePage;
import com.edenred.qa.salesforce.home.pages.NavBar;
import com.edenred.qa.salesforce.home.steps.HomeNavigations;
import com.edenred.qa.salesforce.login.USERTYPE;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageScenario {

    @Inject
    HomeNavigations home;

    @Inject
    NavBar navBar;


    @When("I select the application {string}")
    public void iSelectTheApplication(String appName) {
        home.openApp(appName);
    }

    @Then("Application {string} is displayed")
    public void applicationSalesItaliaIsDisplayed(String appName) {
        WebAssertions.assertThat(navBar.getAppTitle()).isEqualTo(appName);
    }
}
