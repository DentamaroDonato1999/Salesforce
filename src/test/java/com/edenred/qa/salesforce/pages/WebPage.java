package com.edenred.qa.salesforce.pages;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.SelenidePageFactory;
import com.edenred.qa.salesforce.PageIdentifierException;
import com.edenred.qa.salesforce.annotations.PageIdentifier;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.openqa.selenium.TimeoutException;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;


public abstract class WebPage extends SelenidePageFactory {

    protected WebPage() {
        this.page(WebDriverRunner.driver(), this);
    }

    /**
     * Checks if the page is loaded by verifying the presence and visibility
     * of a web element marked with the {@code @PageIdentifier} annotation.
     *
     * @return {@code true} if the page is loaded, {@code false} otherwise.
     */
    @SneakyThrows
    public boolean isLoaded() {
        Field[] fieldsWithPageIdentifier = Arrays.stream(this.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(PageIdentifier.class)).toArray(Field[]::new);
        List<String> fieldNames = Arrays.stream(fieldsWithPageIdentifier).map(Field::getName).toList();
        checkForIdentifiers(fieldNames);
        Field pageIdentifier = fieldsWithPageIdentifier[0]; // At this point one and only one annotated fields will be present

        pageIdentifier.setAccessible(true);
        SelenideElement element = (SelenideElement) pageIdentifier.get(this);

        try {
            element.shouldBe(visible);
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    /**
     * Checks for the correct usage of the {@code @PageIdentifier} annotation.
     * Throws an exception if there are no identifiers or multiple identifiers.
     *
     * @param pageIdentifierFieldNames the list of field names, filtered for {@code @PageIdentifier} annotations.
     */
    private void checkForIdentifiers(@NonNull List<String> pageIdentifierFieldNames) {
        if (pageIdentifierFieldNames.isEmpty()) {
            throw new PageIdentifierException("No page identifier was found for Page %s [%s]".formatted(this.getClass().getName(), pageIdentifierFieldNames));
        }
        if (pageIdentifierFieldNames.size() > 1) {
            throw new PageIdentifierException("Too many identifiers were found for Page %s [%s]".formatted(this.getClass().getName(), pageIdentifierFieldNames));
        }
    }

}
