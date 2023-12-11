package com.edenred.qa.salesforce.login.steps;

import com.edenred.qa.salesforce.login.pages.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.openqa.selenium.UsernameAndPassword;


public class Authenticate {
    @Steps
    LoginPage loginPage;
    @Step
    public void as(UsernameAndPassword credentials){
        loginPage.login(credentials);
    }
}
