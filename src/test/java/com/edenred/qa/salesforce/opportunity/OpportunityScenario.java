package com.edenred.qa.salesforce.opportunity;

import com.edenred.qa.salesforce.assertions.WebAssertions;
import com.edenred.qa.salesforce.home.pages.NavBar;
import com.edenred.qa.salesforce.home.steps.HomeNavigations;
import com.edenred.qa.salesforce.opportunity.pages.AccountPage;
import com.google.inject.Inject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpportunityScenario {
    @Inject
    HomeNavigations home;
    @Inject
    NavBar navBar;
    @Inject
    AccountPage accountPage;
    @When("I opened the application {string}")
    public void iOpenedApplication(String appName) {
        home.openApp(appName);
    }

    @When("I open {string}")
    public void iOpenPage(String page) {
        navBar.openPage(page);
    }

    @Then("Account page is displayed")
    public void accountPageIsDisplayed() {
        WebAssertions.assertThat(accountPage).isLoaded();
    }
}
