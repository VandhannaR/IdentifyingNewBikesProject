package PageObjects;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import TestBase.BaseClass;
import Utilities.JavaScriptManager;

public class zigWheelsPage extends BasePage {

	JavaScriptManager javaScriptManager = new JavaScriptManager();
	public zigWheelsPage(WebDriver driver) {
		super(driver);
	}

	//New Bikes Element
	@FindBy(xpath = "//a[normalize-space()='New Bikes']")
	public WebElement NewBikesElement;

	//Upcoming Bikes element
	@FindBy(xpath = "//span[normalize-space()='Upcoming Bikes']")
	public WebElement upcomingBikes;

	
	//Hover to new bikes element 
	public void clickNewBikes() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(NewBikesElement).perform();
		Thread.sleep(3000);
	}
	
	//Click on upcoming Bikes
	public void selectUpcomingBikes() throws IOException {
		//hover
		Actions actions = new Actions(driver);
		actions.moveToElement(upcomingBikes).perform();
		
		new BaseClass().screenshot("UpcomingBike");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", upcomingBikes);
	}
}
