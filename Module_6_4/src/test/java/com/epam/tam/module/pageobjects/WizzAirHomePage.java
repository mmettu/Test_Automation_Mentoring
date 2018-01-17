package com.epam.tam.module.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.tam.module.testdata.Country;
import com.epam.tam.module.utils.Waiter;

public class WizzAirHomePage extends BasePage{

    @FindBy(xpath="//div/h2[contains(text(),'Explore your travel')]")
    private WebElement HomePageText;
    @FindBy(xpath="//input[@id='search-departure-station']")
    private WebElement origin;
    @FindBy(xpath="//*[(@class='locations-container__location__name') and (contains(.,' Brussels Charleroi '))]")
    private WebElement originAirport;
    @FindBy(xpath="//div[@class='rf-input__location rf-input__location--hint' and text()='Brussels Charleroi']")
    private WebElement originValue;
    @FindBy(xpath="//input[@id='search-arrival-station']")
    private WebElement destination;
    @FindBy(xpath="//div[@class='locations-container__no-results']/span")
    private WebElement destinationResult;
    @FindBy(xpath="//*[(@class='locations-container__location__name') and (contains(.,' Budapest '))]")
    private WebElement destinationAirport;
    @FindBy(xpath="//div[@class='rf-input__location rf-input__location--hint' and text()='Budapest']")
    private WebElement destinationValue;
    
    @FindBy(xpath="//div[@id='search-departure-date']")    
    private WebElement departureDate;
    @FindBy(xpath="//div[@class='pika-lendar'][1]//td[@class='is-today']/following-sibling::td[2]")
    private WebElement departureDateSelect;
    @FindBy(xpath="//div[@class='calendar__button']/button[text()='OK']")
    private WebElement calenderOkButton;
    
    @FindBy(xpath="//div[@id='search-return-date']")
    private WebElement returnDate;
    @FindBy(xpath="//div[@class='pika-lendar'][1]//td[@class='is-selected']/following-sibling::td[2]")
    private WebElement returnDateSelect;
    @FindBy(xpath="//div[@class='pika-lendar'][1]//td[@class='is-selected']/../following-sibling::tr[1]/td[1]/button")
    private WebElement returnDateSelect1;
    
    @FindBy(xpath="//div[@id='search-passenger']")
    private WebElement passengers;
    @FindBy(xpath="//div[@class='stepper stepper--flight-search'][2]/button[@class='stepper__button stepper__button--add']")
    private WebElement childPlusButton;
    @FindBy(xpath="//div[@class='flight-search__panel__done-btn gutter-bottom']/button[@class='rf-button rf-button--medium rf-button--primary']")
    private WebElement passengersOkButton;
    @FindBy(xpath="//div[@class='rf-input__input passenger-counter-input__input']")
    private WebElement passengerCount;    
    @FindBy(xpath="//div/button[@class='rf-button rf-button--medium rf-button--primary flight-search__panel__cta-btn']")
    private WebElement searchButton;
    
	public WizzAirHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}   
    public String verifyHomePage(){
    	   return   HomePageText.getText();
    }
    public String originField(Country country){
    	origin.click();
    	origin.sendKeys(country.getoriginCountry());
    	originAirport.click();
		return originValue.getText();
    }
    public String destinationFieldNegative(Country country){
    	destination.click();
    	destination.sendKeys(country.getdestinationCountry1());
		return destinationResult.getText();
    }
    public String destinationField(Country country){
    	destination.click();
    	destination.sendKeys(country.getdestinationCountry2());
    	destinationAirport.click();
		return destinationValue.getText();
    }
    public boolean selectDepartureDate(){
    	departureDate.click();
    	Waiter.waitForElementClickable(driver, 4, departureDateSelect);
    	departureDateSelect.click();
    	calenderOkButton.click();
		return true;    	
    }
    public boolean selectReturnDate(){
    	returnDate.click();
    	Waiter.hardWait(3000);
    	try{
        	Waiter.waitForElementPresent(driver, 10, returnDateSelect);
    		returnDateSelect.click();
    	}
    	catch(Exception e){
    		returnDateSelect1.click();
    	}
    	calenderOkButton.click();
		return true;    	
    }
    public String selectPassengers(){
    	passengers.click();
    	Waiter.hardWait(2000);
    	childPlusButton.click();
    	passengersOkButton.click();
		return passengerCount.getText();    	
    }
    public WizzAirSearchPage performSearch(){
    	String currentWindow = driver.getWindowHandle();
    	searchButton.click();
        for(String winHandle : driver.getWindowHandles()){
            if(currentWindow.equalsIgnoreCase(winHandle))
               continue; 
            driver.switchTo().window(winHandle);
        }
		return new WizzAirSearchPage(driver);  	
    }
}
