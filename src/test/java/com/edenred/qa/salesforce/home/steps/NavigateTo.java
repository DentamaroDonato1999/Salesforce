package com.edenred.qa.salesforce.home.steps;

import com.edenred.qa.salesforce.home.pages.HomePage;
import net.serenitybdd.annotations.Steps;

public class NavigateTo{
    @Steps
    HomePage homePage;
    public void application(String appName){
        homePage.getHeader().selectApp(appName);
    }
}
