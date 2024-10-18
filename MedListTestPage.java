package com.arine.automation.pages;

import com.arine.automation.exception.AutomationException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class MedListTestPage extends PatientPage{

    public void clickOnDropdownAndSelectOption(String dropdown, String option) throws AutomationException {
        WebElement dropdownElement = driverUtil.getWebElement("(//div//span[contains(text(),'"+dropdown+"')]/following-sibling::span//div[@class=' css-6kjl92-control']//div[@class=' css-1jul3cw']//div)[2]");
        if (dropdownElement == null) {
            throw new AutomationException("Unable to locate the dropdown: " + dropdown + " or it is in a disabled state");
        }
        driverUtil.moveToElementAndClick(dropdownElement);
        WebElement optionElement = driverUtil.getWebElement("//div//div[contains(text(),'Available options')]//following-sibling::div//div//div//label[contains(text(),'"+option+"')]");
        if (optionElement == null) {
            throw new AutomationException("Unable to locate the option: " + option + " or it is in a disabled state");
        }
        driverUtil.moveToElementAndClick(optionElement);
    }

    public void verifySelectedOption(String expectedOption) throws AutomationException {
        List<WebElement> selectedElements = driverUtil.getWebElements("//div[@class=' css-117e4ry']//div//div[@class='css-12jo7m5']");
        System.out.println(selectedElements);
        if (selectedElements == null || selectedElements.isEmpty()) {
            throw new AutomationException("No selected options found.");
        }

        List<String> actualSelectedOptions = new ArrayList<>();
        for (WebElement element : selectedElements) {
            actualSelectedOptions.add(element.getText());
        }

        if (!actualSelectedOptions.contains(expectedOption)) {
            throw new AutomationException("Expected option: " + expectedOption + " but it is not selected. Actual selected options: " + actualSelectedOptions);
        }
    }

    public void verifyOptionInSelectedListSection(String expectedOption) throws AutomationException {
        WebElement dropdownElement = driverUtil.getWebElement("(//div[@class=' css-18cdyhl-indicatorContainer'])[2]");
        dropdownElement.click();

        List<WebElement> selectedElements = driverUtil.getWebElements("//div//div[contains(text(),'Selected')]//following-sibling::div//div//div//label");

        if (selectedElements == null || selectedElements.isEmpty()) {
            throw new AutomationException("No options found in the SELECTED list section.");
        }

        List<String> selectedOptions = new ArrayList<>();
        for (WebElement element : selectedElements) {
            selectedOptions.add(element.getText());
        }

        if (!selectedOptions.contains(expectedOption)) {
            throw new AutomationException("Expected option: " + expectedOption + " is not in the SELECTED list. Actual options: " + selectedOptions);
        }
    }


    public void verifyOptionNotInAvailableOptionsListSection(String expectedOption) throws AutomationException {
        List<WebElement> availableOptionsElements = driverUtil.getWebElements("//div//div[contains(text(),'Available options')]//following-sibling::div//div//div//label");

        if (availableOptionsElements == null || availableOptionsElements.isEmpty()) {
            throw new AutomationException("No options found in the AVAILABLE OPTIONS list section.");
        }

        List<String> availableOptions = new ArrayList<>();
        for (WebElement element : availableOptionsElements) {
            availableOptions.add(element.getText());
        }

        if (availableOptions.contains(expectedOption)) {
            throw new AutomationException("Expected option: " + expectedOption + " should not be in the AVAILABLE OPTIONS list, but it is present.");
        }

    }


}
