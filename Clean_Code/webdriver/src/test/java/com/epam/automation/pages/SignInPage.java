package com.epam.automation.pages;

import com.epam.automation.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    @FindBy(id = "login_field")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement buttonSubmit;

    private WebDriver mDriver;

    public SignInPage(WebDriver mDriver) {
        this.mDriver = mDriver;
        PageFactory.initElements(mDriver, this);
    }

    public void signIn(String userName, String password){
    	loginField.sendKeys(userName);
    	passwordField.sendKeys(password);
        buttonSubmit.click();
    }

    public boolean isReadyToSignIn()  throws Exception{
        if (buttonSubmit.isDisplayed()){
        	return true;
        }
        else {
        	throw new Exception(); 
        }
    }
    public HomePage signIn(User user){
        this.signIn(user.getUserName(), user.getPassword());
        return new HomePage(mDriver);
    }

}
