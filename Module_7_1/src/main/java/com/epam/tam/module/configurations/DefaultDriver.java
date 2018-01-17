package com.epam.tam.module.configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DefaultDriver {

	private static WebDriver driver;

	private DefaultDriver() {

	}

	public static WebDriver initializeDriver() {
		if (null == driver) {
			System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			driver = new ChromeDriver(capabilities);
		}
		return driver;
	}
}