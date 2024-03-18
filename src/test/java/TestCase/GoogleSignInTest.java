package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.LoginOrSignupPage;
import TestBase.BaseClass;
import Utilities.WindowHandle;

public class GoogleSignInTest extends BaseClass {

	@Test(groups= {"regression","master"})
	public void verifyLoginPage() {
		logger.info("**** Starting SignInPageTest ****");
		try {
			logger.info("Verifying loginPage");
			
            LoginOrSignupPage loginSignupPage = new LoginOrSignupPage(driver);
			
			// click on the Zigwheels link to navigate back
			loginSignupPage.clickZigwheels();
			
			// Click on the Login/Signup button
			loginSignupPage.clickLoginSignUp();
			
			
			// Select the google button
			loginSignupPage.selectGoogleButton();
			// Implementing window handles
			WindowHandle windowHandle = new WindowHandle(driver);
			windowHandle.windowNavigate("Sign in - Google Accounts");

			LoginPage loginPage = new LoginPage(driver);

			// Click on the email input button
			loginPage.setEmailInput();

			// Click on the next button displayed on the login page
			loginPage.clickNextBtn();

			// Display the error message displayed on the screejn
			loginPage.handleErrorMsg();

			// Taking screenshot
			screenshot("LoginErrorMsg");
		} catch (Exception e) {
			logger.info("LoginPage verification failed!!");
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**** Finished SignInPageTest ****");
	}
}

