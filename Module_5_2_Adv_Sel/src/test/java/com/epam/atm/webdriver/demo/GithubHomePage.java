package com.epam.atm.webdriver.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GithubHomePage extends BasePage{

	@FindBy(linkText = "Sign in")
	private WebElement signInButton;

	public GithubHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public GithubSignInPage openSignInForm() {
		System.out.println("Navigating to signIn page...");
		signInButton.click();
		return new GithubSignInPage(driver);
	}
}
