package stepDefinition;
 
import java.io.IOException;
 
import TestBase.BaseClass;
import TestCase.UpcomingBikeDetailsTestCase;
import TestCase.UsedcarDetailsTest;
import TestCase.GoogleSignInTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
 
public class StepDef {
	BaseClass bs = new BaseClass();
 
	@Given("launch the browser and ZigsWheel Page")
	public void launch_the_browser_and_zigs_wheel_page() {
		try {
			bs.setup("Windows", "chrome");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	@Then("Click on New Bikes and Upcoming bike select honda and get the details of Bikes")
	public void click_on_new_bikes_and_upcoming_bike_select_honda_and_get_the_details_of_bikes() {
		UpcomingBikeDetailsTestCase tc1 = new UpcomingBikeDetailsTestCase();
		try {
			tc1.UpcomingBikes();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//tc1.clickUpcomingBikes();
	}
 
	@Then("Click on Used Cars and select models and Get the model details")
	public void click_on_used_cars_and_select_models_and_get_the_model_details() {
		UsedcarDetailsTest tc2 = new UsedcarDetailsTest();
		try {
			tc2.UsedCarDetails();
		} catch (InterruptedException e) {
 
		} catch (IOException e) {
 
			e.printStackTrace();
		}
	}
 
	@Then("Login\\/signUp tp google and give invalid details and capture error message")
	public void login_sign_up_tp_google_and_give_invalid_details_and_capture_error_message() {
		GoogleSignInTest tc3 = new GoogleSignInTest();
		tc3.verifyLoginPage();
	}
 
	@Then("Close the Browser")
	public void close_the_browser() {
		bs.tearDown();
	}
 
}

