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

public class GitHubTest {

    private static final String SIGN_IN_INPUT = "//input[@value='Sign in']";
    private static final String INPUT_PASSWORD = "//input[@id='password']";
    private static final String LOGIN_FIELD = "login_field";
    private static final String GO_TO_SIGN_IN_TEXT = "Sign in";
    private static final String YOUR_REPOSITORIES = "//div[@id='your_repos']//h3[contains(.,'Your repositories')]";
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
        goToSignIn();
        doLogin(LOGIN, PASSWORD);

        Assert.assertTrue(isElementPresent(By.xpath(YOUR_REPOSITORIES)), "Looks you are NOT logged in correctly!");
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        return !driver.findElements(by).isEmpty();
    }

    private void doLogin(String login, String password) {

        By loginField = By.id(LOGIN_FIELD);
        waitForElementClickable(3, loginField);
        WebElement loginInput = driver.findElement(loginField);
        loginInput.clear();
        loginInput.sendKeys(login);

        WebElement passwordInput = driver.findElement(By.xpath(INPUT_PASSWORD));
        passwordInput.clear();
        passwordInput.sendKeys(password);

        driver.findElement(By.xpath(SIGN_IN_INPUT)).click();
    }

    private void goToSignIn() {
        By goToSignIn = By.linkText(GO_TO_SIGN_IN_TEXT);
        waitForElementClickable(3, goToSignIn);
		/* Find and click the "button" input element by link text */
        driver.findElement(goToSignIn).click();
    }

    private void waitForElementClickable(int timeout, final By by) {
        new WebDriverWait(driver, timeout).pollingEvery(2, TimeUnit.SECONDS)
                .until(ExpectedConditions.elementToBeClickable(by));
    }
}
