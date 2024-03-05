package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginOrSignupPage extends BasePage{
	public LoginOrSignupPage(WebDriver driver) {
		super(driver);
	}

	//Zigwheels logo
	@FindBy(xpath="//a[@class='zw i-b mt-10 pt-2 zw-srch-logo']")
	public WebElement zigwheelsLogo;
	
	//Login/SignUp Button Element
	@FindBy(xpath = "//div[@id='des_lIcon']")
	public WebElement loginSignUpButton;
	
	//Login with google Button
	@FindBy(xpath="//div[@class='lgn-sc c-p txt-l pl-30 pr-30 googleSignIn']")
	public WebElement loginWithGoogleButton;
	
	//Click on Zigwheels logo
	public void clickZigwheels() {
		zigwheelsLogo.click();
	}
	
	//Click on Login/SignUp button 
	public void clickLoginSignUp() {
		loginSignUpButton.click();
	}
	
	//Click on Sign in with Google
	public void selectGoogleButton() {
		loginWithGoogleButton.click();
	}
	
}
