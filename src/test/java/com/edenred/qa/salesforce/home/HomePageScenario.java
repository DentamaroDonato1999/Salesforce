package com.edenred.qa.salesforce.home;

import com.edenred.qa.salesforce.home.steps.NavigateTo;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class HomePageScenario {
    @Steps
    NavigateTo navigateTo;
    @When("I select the application {string}")
    public void iSelectTheApplication(String appName) {
        navigateTo.application(appName);
    }
}
