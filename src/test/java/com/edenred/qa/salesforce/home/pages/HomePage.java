package com.edenred.qa.salesforce.home.pages;

import com.edenred.qa.salesforce.pages.WebPage;
import com.google.inject.Inject;

public class HomePage extends WebPage {

    @Inject
    public HeaderPage header;


    public HeaderPage getHeader() {
        return header;
    }


}
