package com.edenred.qa.salesforce.login.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.edenred.qa.salesforce.login.pages.LoginPage;
import com.google.inject.Inject;
import io.qameta.allure.Step;


public class StartFrom {
    @Inject
    LoginPage loginPage;

    @Step
    public void loginPage() {
        Selenide.open(Configuration.baseUrl);
        loginPage.isLoaded();
    }

}
