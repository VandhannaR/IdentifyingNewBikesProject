package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginOrSignupPage;
import TestBase.BaseClass;

public class GoogleLoginOrSignUpTest extends BaseClass {

	@Test(groups= {"smoke","regression","master"})
	public void verifyLoginPage() {
		logger.info("**** Starting LoginOrSignupTest ****");
		try {
			logger.info("Verifying login/SignUp");
			LoginOrSignupPage loginSignupPage = new LoginOrSignupPage(driver);
			
			// click on the Zigwheels link to navigate back
			loginSignupPage.clickZigwheels();
			
			// Click on the Login/Signup button
			loginSignupPage.clickLoginSignUp();
			// Taking screenshot
			screenshot("LoginSignUpCard");
			
			// Select the google button
			loginSignupPage.selectGoogleButton();
		} 
		catch (Exception e) {
			logger.info("Verifying Login/SignUp failed!!");
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**** Finished LoginOrSignupTest ****");
	}
}
