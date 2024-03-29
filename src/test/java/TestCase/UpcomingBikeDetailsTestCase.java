package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.UpcomingBikes;
import PageObjects.zigWheelsPage;
import TestBase.BaseClass;

public class UpcomingBikeDetailsTestCase extends BaseClass {

	
	
	@Test(groups= {"smoke","regression","master"})
	public void UpcomingBikes() throws InterruptedException {
		logger.info("**** Starting UpcomingBikeTest ****");
		try {
			logger.info("clicking on  New Bikes ");
			
			zigWheelsPage zwg = new zigWheelsPage(driver);
			
			// click on new bikes
			zwg.clickNewBikes();
			
			//Click on upcoming bikes under new bikes
			zwg.selectUpcomingBikes();
			
			UpcomingBikes upcomingBike = new UpcomingBikes(driver);
			//Click on Manufacturer
			upcomingBike.clickManufacturer();
			
			//Click on the view more bikes button
			upcomingBike.clickViewMoreButton();
			
			System.out.println("Capturing upcoming bike details:");
			
			//Displaying the details of the bikes
			upcomingBike.bikeDetails();
		} 
		catch (Exception e) {
			logger.info("Failed to click New Bikes");
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**** Finished UpcomingBikeTest ****");
	}
	
	
	
	/*@Test(groups= {"smoke","regression","master"})
	public void clickNewBikes() throws InterruptedException {
		logger.info("**** Starting UpcomingBikeTest ****");
		try {
			logger.info("clicking on  New Bikes ");
			
			zigWheelsPage zwg = new zigWheelsPage(driver);
			
			// click on new bikes
			zwg.clickNewBikes();
			// Click on upcoming bikes under new bikes
			zwg.selectUpcomingBikes();
		} 
		catch (Exception e) {
			logger.info("Failed to click New Bikes");
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test( dependsOnMethods = { "clickNewBikes" }, groups= {"smoke","regression","master"})
	public void clickUpcomingBikes() {
		try {
			logger.info("clicking on Upcoming Bikes");
			UpcomingBikes upcomingBike = new UpcomingBikes(driver);
			// Click on Manufacturer
			upcomingBike.clickManufacturer();
			
			// Click on the view more bikes button
			upcomingBike.clickViewMoreButton();
			
			// Displaying the details of the bikes
			upcomingBike.bikeDetails();
		} catch (Exception e) {
			logger.info("Failed to click upcoming bikes");
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**** Finished UpcomingBikeTest ****");
	}*/

}

