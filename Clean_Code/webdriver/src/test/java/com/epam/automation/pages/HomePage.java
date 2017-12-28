package com.epam.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//button[@aria-label='Switch account context']/span")
    private WebElement linkLoggedInUser;

    @SuppressWarnings("unused")
	private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getLoggedInUserName() {
        return linkLoggedInUser.getText();
    }

    public boolean hasUserLoggedIn(){
        if ((this.getLoggedInUserName()) != ""){
            return true;
        }
        else{
            return false;
        }
    }
}
