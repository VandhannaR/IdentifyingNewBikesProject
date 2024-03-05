package PageObjects;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Utilities.ExcelUtility;
import Utilities.JavaScriptManager;

public class UpcomingBikes extends BasePage {

	JavaScriptManager javaScriptManager = new JavaScriptManager();
	Utilities.ExcelUtility excelUtility = new ExcelUtility();

	public UpcomingBikes(WebDriver driver) {
		super(driver);
	}

	//Manufacturer Element
	@FindBy(id = "makeId")
	public WebElement Manufacturer;

	//View More Bikes Button 
	@FindBy(xpath = "//span[@class='zw-cmn-loadMore']")
	public WebElement viewMoreBikesButton;

	//Honda bike model names
	@FindBy(css = ".lnk-hvr.block.of-hid.h-height")
	public List<WebElement> modelName;

	//Honda bikes prices
	@FindBy(xpath = "//li[contains(@class,'modelItem')]")
	public List<WebElement> bikePrice;

	//Launch date of Honda bikes
	@FindBy(css = ".clr-try.fnt-14")
	public List<WebElement> dateOfBikes;

	//Element to scroll based on it
	@FindBy(xpath = "//a[normalize-space()='Latest Bikes']")
	public WebElement scrollElement;

	//Select Manufacturer
	public void clickManufacturer() {
		Manufacturer.click();
		Select select = new Select(Manufacturer);
		select.selectByVisibleText("Honda");
	}

	//Locating the view more bikes button and click on it
	public void clickViewMoreButton() throws InterruptedException {

		javaScriptManager.scrollIntoView(driver, scrollElement);
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", viewMoreBikesButton);
		Thread.sleep(2000);
	}

	//Get the details of the bikes and store in the excel file
	public void bikeDetails() throws IOException {
		excelUtility.setCellData("UpcomingBike", 0, 0, "BikeName");
		excelUtility.setCellData("UpcomingBike", 0, 1, "Price");
		excelUtility.setCellData("UpcomingBike", 0, 2, "LaunchDate");
		int row = 1;
		for (int i = 0; i < modelName.size(); i++) {
			String bikeName = modelName.get(i).getText();
			String launchDate = dateOfBikes.get(i).getText();
			int price = Integer.parseInt(bikePrice.get(i).getAttribute("data-price"));
			if (price < 400000) {
				System.out.println(bikeName + "\n" + price + "\n" + launchDate);
				System.out.println("****************************");
				excelUtility.setCellData("UpcomingBike", row, 0, bikeName);
				excelUtility.setCellData("UpcomingBike", row, 1, price + "");
				excelUtility.setCellData("UpcomingBike", row, 2, launchDate);
				row++;
			}
		}
	}

	}


