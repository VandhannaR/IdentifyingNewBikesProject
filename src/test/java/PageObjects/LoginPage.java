package PageObjects;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtility;

public class LoginPage extends BasePage {

	ExcelUtility excelUtility = new ExcelUtility();

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//locate the google button
	@FindBy(id = "identifierId")
	public WebElement emailInput;

	//locate the "Next" button
	@FindBy(xpath = "//span[normalize-space()='Next']")
	public WebElement nextBtn_loc;

	
	//locate the error message displayed
	@FindBy(xpath = "//div[text()='Couldn’t find your Google Account']")
	public WebElement errorMessage;

	//passing invalid account details
	public void setEmailInput() {
		emailInput.sendKeys(randomString() + "@gmail.com");
	}

	//Click on "Next" button
	public void clickNextBtn() throws InterruptedException {
		nextBtn_loc.click();
		Thread.sleep(5000);
	}

	//capturing the error message and display on the console
	public void handleErrorMsg() throws IOException {
		String errorMsg = errorMessage.getText();
		System.out.println("---------------------------------");
		System.out.println("Error Message: "+ errorMsg);
		excelUtility.setCellData("LoginPage", 0, 0, errorMsg);
	}

	//Generate a random string to type into email input
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
}