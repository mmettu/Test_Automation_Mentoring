package com.epam.tam.module.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.epam.tam.module.configurations.DefaultDriver;
import com.epam.tam.module.pageobjects.WizzAirHomePage;
import com.epam.tam.module.pageobjects.WizzAirSearchPage;
import com.epam.tam.module.testdata.Country;
import junit.framework.Assert;

//import junit.framework.Assert;

public class RunnerTest {
	private static final String START_URL = "https://wizzair.com/";
	private static final String originAirport = "Brussels Charleroi CRL";
	private static final String destinationCountry1 = "Germany";
	private static final String destinationResult = "There is no result for this search.! :(";
	private static final String destinationCountry2 = "Hungary";
	private static final String destinationAirport = "Budapest BUD";
	private static final String homePageText = "Explore your travel opportunities with WIZZ!";
	private static final String passengersCount ="1 adult 1 child";
	private static final String searchPageHeading ="SELECT FLIGHTS";
	
	private WebDriver driver ;
	WizzAirHomePage homePage;
	WizzAirSearchPage searchPage;

    @BeforeClass(description = "Start browser")
    public void startBrowser() {
    	driver =DefaultDriver.initializeDriver();
        driver.get(START_URL);
    }
    @AfterClass(description = "Close browser")
    public void closeBrowser() {
		driver.quit();
    }
    @Test(priority =0)
    public void addImplicitly() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		homePage = new WizzAirHomePage(driver);
    }
    @Test(priority =1)
    public void verifyHomePage(){    
    	Assert.assertEquals("Home page not opened Successfully", homePageText, homePage.verifyHomePage());
    }
    @Test(priority =2)
    public void verifyOriginValue(){
    	Assert.assertEquals("Wrong Airport value taken", originAirport, homePage.originField(new Country()));
    }
    @Test(priority =3)
    public void verifyDestinationValueNegative(){
    	Assert.assertEquals(destinationCountry1+" Country had Airports", destinationResult, homePage.destinationFieldNegative(new Country()));
    }
    @Test(priority =4)
    public void verifyDestinationValue(){
    	Assert.assertEquals("Wrong Airport value taken for country "+destinationCountry2, destinationAirport, homePage.destinationField(new Country()));
    }
    @Test(priority =5)
    public void selectDepartureDate(){
    	Assert.assertEquals("Departuredate not selected Properly",true, homePage.selectDepartureDate());
    }
    @Test(priority =6)
    public void selectReturnDate(){
    	Assert.assertEquals("Return not selected Properly",true, homePage.selectReturnDate());
    }
    @Test(priority =7)
    public void verifyPassengers(){
    	Assert.assertEquals("Return date not selected ", passengersCount, homePage.selectPassengers());
    }
    @Test(priority =8)
    public void verifySearchPage(){
    	Assert.assertEquals("Return date not selected ", searchPageHeading, homePage.performSearch().verifySearchPage());
    }
}
