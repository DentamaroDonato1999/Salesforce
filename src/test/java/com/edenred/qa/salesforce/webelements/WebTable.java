package com.edenred.qa.salesforce.webelements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
public class WebTable {
    private SelenideElement table;
    private SelenideElement tbody;
    private final List<WebElement> header;
    List<WebElement> rows;
    int numRows;
    int numColumns;

    private List<String> columnNames;
    private Map<String, Integer> columnMap;
    public static final By DEFAULT_ROWLOCATOR = By.tagName("tr");
    public WebTable(List<WebElement> header) {
        this.header = header;
    }
}