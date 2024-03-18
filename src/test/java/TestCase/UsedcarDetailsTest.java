package TestCase;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.UsedCars;
import TestBase.BaseClass;


public class UsedcarDetailsTest extends BaseClass {
	
	@Test(groups= {"regression","master"})
	public void UsedCarDetails() throws InterruptedException, IOException {

		try {
			logger.info("Starting used car testcase");
			
			System.out.println("Capturing used car details in chennai:");
			UsedCars usedCar = new UsedCars(driver);
			
			//Hover and select used cars
			usedCar.selectUsedCars();
			
			//Click on the selected car location
			usedCar.clickSelectedCar();

			//Click on the popular models
			usedCar.extractPopularModels();
		} catch (Exception e) {
			logger.info("Failed to click used cars in chennai");
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**** Finished used car testcase ****");
	}
}

