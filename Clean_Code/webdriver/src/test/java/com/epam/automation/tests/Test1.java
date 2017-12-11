package com.epam.automation.tests;

import com.epam.automation.model.HomePage;
import com.epam.automation.pages.SignInPage;
import com.epam.automation.pages.StartPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Test1 {

    private static final String USERNAME = "testautomationuser";
    private static final String PASSWORD = "Time4Death!";

    @Test
    public void testOneCanLoginGithub(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        StartPage startPage = new StartPage(driver);
        startPage.open();
        startPage.invokeSignIn();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(USERNAME, PASSWORD);
        HomePage homePage = new HomePage(driver);
        String loggedInUserName = homePage.getLoggedInUserName();
        Assert.assertEquals(USERNAME, loggedInUserName);
        driver.quit();
    }
}
