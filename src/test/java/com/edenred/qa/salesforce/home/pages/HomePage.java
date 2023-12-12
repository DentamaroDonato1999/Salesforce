package com.edenred.qa.salesforce.home.pages;

import com.edenred.qa.salesforce.pages.WebPage;
import net.serenitybdd.annotations.WhenPageOpens;

public class HomePage extends WebPage {

    public HeaderPage header;


    public HeaderPage getHeader() {
        return header;
    }


    @Override
    @WhenPageOpens
    public void waitUntilTitleAppears() {
        //unnecessary
    }
}
