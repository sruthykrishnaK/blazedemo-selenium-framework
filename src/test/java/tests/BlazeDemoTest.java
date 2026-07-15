package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ConfirmationPage;
import pages.FlightsPage;
import pages.HomePage;
import pages.PurchasePage;
import utilities.ExcelReader;
import utilities.ScreenshotUtil;

public class BlazeDemoTest extends BaseTest {

	@Test
	public void searchFlightAndSelectCheapest() throws Exception {

	    test = extent.createTest("Search Flight & Select Cheapest");

	    HomePage home = new HomePage(driver);

	    String fromCity = ExcelReader.getData(1, 0);
	    String toCity = ExcelReader.getData(1, 1);

	    home.selectFromCity(fromCity);
	    home.selectToCity(toCity);
	    home.clickFindFlights();

	    FlightsPage flights = new FlightsPage(driver);

	    Assert.assertTrue(flights.isFlightTableDisplayed());
	    test.pass("Flights displayed successfully");

	    flights.selectCheapestFlight(test);
	    test.pass("Cheapest flight selected");
	    
	    System.out.println("Current URL: " + driver.getCurrentUrl());
	    
	    PurchasePage purchase = new PurchasePage(driver);

	    purchase.fillPassengerDetails(
	            ExcelReader.getData(1, 2),
	            ExcelReader.getData(1, 3),
	            ExcelReader.getData(1, 4),
	            ExcelReader.getData(1, 5),
	            ExcelReader.getData(1, 6),
	            ExcelReader.getData(1, 7),
	            ExcelReader.getData(1, 8),
	            ExcelReader.getData(1, 9)
	    );

	    test.pass("Passenger details filled");

	    purchase.clickPurchase();
	    test.pass("Clicked on Purchase button");
	    
	    Thread.sleep(3000);
	    
	    ConfirmationPage confirm = new ConfirmationPage(driver);

	    String message = confirm.getSuccessMessage();
	    System.out.println(message);

	    Assert.assertEquals(message, "Thank you for your purchase today!");
	    test.pass("Booking confirmed");

	    String id = confirm.getBookingId();
	    System.out.println("Booking ID: " + id);
	    test.pass("Booking ID: " + id);

	    ScreenshotUtil.capture(driver, "BookingConfirmation");
	    test.pass("Screenshot captured");
	    
	    String currentUrl = driver.getCurrentUrl();
	    System.out.println(currentUrl);

	    Assert.assertTrue(driver.getCurrentUrl().contains("confirmation"),
	            "Booking not completed");
	}
    }

