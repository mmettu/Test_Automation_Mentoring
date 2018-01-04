package com.epam.atm.webdriver.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GitHubLoginTest {

    private static final String PASSWORD = "ftm2016q4_!";
    private static final String LOGIN = "ftm2016q4";
    private static final String START_URL = "https://github.com/";

    private WebDriver driver;

    @BeforeClass(description = "Start browser")
    public void startBrowser() {
		System.setProperty("webdriver.chrome.driver",
                ".\\src\\test\\resources\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        driver = new ChromeDriver(capabilities);
        driver.get(START_URL);
    }

    @BeforeClass(dependsOnMethods = "startBrowser", description = "Add implicite wait and maximize window")
    public void addImplicitly() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
    }

    @Test(description = "Login to Github account")
    public void loginToGithub() {

        GithubHomePage homePage = new GithubHomePage(driver);
        Assert.assertTrue(
                homePage.openSignInForm().loginToGitHub(LOGIN,PASSWORD).isRepositoryDisplayed()
                ,"Failed to login to GITHUB");
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        driver.quit();
    }

}
