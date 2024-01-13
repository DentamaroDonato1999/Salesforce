package com.edenred.qa.salesforce.configuration;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class ScenarioHooks {

    @Before
    public void start(Scenario scenario){
        Allure.step("Starting scenario: %s".formatted(scenario.getName()));
    }

    @After
    public void end(Scenario scenario){
        Allure.step("Starting scenario: %s -> status: %s".formatted(scenario.getName(), scenario.getStatus()));
    }

    @After(order = 0)
    public void closeBrowser() {
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }

}