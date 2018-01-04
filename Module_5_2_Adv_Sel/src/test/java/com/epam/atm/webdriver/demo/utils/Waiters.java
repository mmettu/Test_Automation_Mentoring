package com.epam.atm.webdriver.demo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waiters {
	public static void waitForElementClickable(WebDriver driver, int timeout, final By by) {
		new WebDriverWait(driver, timeout).pollingEvery(2, TimeUnit.SECONDS)
				.until(ExpectedConditions.elementToBeClickable(by));
	}

}
