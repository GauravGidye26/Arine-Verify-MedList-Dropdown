package com.arine.automation.glue;

import com.arine.automation.exception.AutomationException;
import com.arine.automation.pages.PageFactory;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.arine.automation.glue.CommonSteps.takeScreenshot;

public class MedListStepsDropdown {
    CommonSteps common = new CommonSteps();

    @When("^User click on \"([^\"]*)\" Dropdown and select option \"([^\"]*)\"$")
    public void clickOnDropdownAndSelectOption(String dropdown, String option) throws AutomationException {
        common.logInfo("Clicking on dropdown: " + dropdown + " and selecting option: " + option);
        PageFactory.medListTestPage().clickOnDropdownAndSelectOption(dropdown, option);
    }

    @Then("^Verify \"([^\"]*)\" option is selected in Dropdown field$")
    public void verifyOptionIsSelected(String expectedOption) throws AutomationException {
        common.logInfo("Verifying that the option: " + expectedOption + " is selected");
        PageFactory.medListTestPage().verifySelectedOption(expectedOption);
        takeScreenshot();
    }

    @Then("^Verify \"([^\"]*)\" option is in SELECTED list section in Dropdown$")
    public void verifyOptionIsInSelectedListSection(String expectedOption) throws AutomationException {
        common.logInfo("Verifying that the option: " + expectedOption + " is in the SELECTED list section");
        PageFactory.medListTestPage().verifyOptionInSelectedListSection(expectedOption);
        takeScreenshot();
    }

    @Then("^Verify \"([^\"]*)\" option is not in AVAILABLE OPTIONS list section in Dropdown$")
    public void verifyOptionIsNotInAvailableOptionsListSection(String expectedOption) throws AutomationException {
        common.logInfo("Verifying that the option: " + expectedOption + " is not in the AVAILABLE OPTIONS list section");
        PageFactory.medListTestPage().verifyOptionNotInAvailableOptionsListSection(expectedOption);
        takeScreenshot();
    }


}
