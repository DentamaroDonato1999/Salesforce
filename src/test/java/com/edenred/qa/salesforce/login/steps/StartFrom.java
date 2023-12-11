package com.edenred.qa.salesforce.login.steps;

import com.edenred.qa.salesforce.login.pages.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;

public class StartFrom {
    @Steps
    LoginPage loginPage;

    @Step
    public void loginPage(){
        loginPage.open();
        loginPage.waitUntilTitleAppears();
    }

}
