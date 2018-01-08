package com.epam.tam.module.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By by) {
        return !driver.findElements(by).isEmpty();
    }
}
