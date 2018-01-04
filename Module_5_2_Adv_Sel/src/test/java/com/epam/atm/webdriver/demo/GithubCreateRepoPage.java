package com.epam.atm.webdriver.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GithubCreateRepoPage extends BasePage{

	@FindBy(xpath = "//div[@id='your_repos']//h3[contains(.,'Your repositories')]")
	private WebElement yourRepo;

	public GithubCreateRepoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean isRepositoryDisplayed() {
		return yourRepo.isDisplayed();
	}
}
