package com.edenred.qa.salesforce.login.steps;

import com.edenred.qa.salesforce.login.USERTYPE;
import com.edenred.qa.salesforce.login.pages.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.openqa.selenium.UsernameAndPassword;

import java.util.ResourceBundle;


public class Authenticate {
    final static ResourceBundle testdata = ResourceBundle.getBundle("testdata");

    @Steps
    LoginPage loginPage;
    @Steps
    StartFrom startFrom;
    @Step
    public void as(USERTYPE usertype){
        startFrom.loginPage();
        UsernameAndPassword credentials = new UsernameAndPassword(
                testdata.getString("login.%s.username".formatted(usertype)),
                testdata.getString("login.%s.password".formatted(usertype)));
        loginPage.login(credentials);
    }
}
