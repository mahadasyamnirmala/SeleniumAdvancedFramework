package org.example.Pages.POM.VWO;

import org.example.Utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FreeTrialPage {
    WebDriver driver;
    public FreeTrialPage(WebDriver driver) {
       // Driver
        this.driver = driver;
    }
    //Locators
    private final By Email = By.id("page-v1-step1-email");
    private final By CheckBox = By.xpath("//input[@data-qa='page-free-trial-step1-gdpr-consent-checkbox']");
    private final By CreateAccount = By.xpath("//button[text()='Create a Free Trial Account']");
    // Page Actions
    public void CreateFreeTrialAccount(String email) {
        //WaitHelpers.checkVisibility(driver, By.id(email),10);
        driver.findElement(Email).sendKeys(email);
        driver.findElement(CheckBox).click();
        driver.findElement(CreateAccount).click();
    }


}
