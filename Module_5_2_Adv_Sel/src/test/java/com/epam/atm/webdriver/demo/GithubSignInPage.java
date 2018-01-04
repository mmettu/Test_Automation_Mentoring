package com.epam.atm.webdriver.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GithubSignInPage extends BasePage{

	@FindBy(id = "login_field")
	private WebElement loginInput;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordInput;

	@FindBy(xpath = "//input[@value='Sign in']")
	private WebElement signInBtn;

	public GithubSignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public GithubCreateRepoPage loginToGitHub(String user, String pwd) {
		loginInput.clear();
		loginInput.sendKeys(user);

		passwordInput.clear();
		passwordInput.sendKeys(pwd);

		signInBtn.click();

		return new GithubCreateRepoPage(driver);
	}

}
