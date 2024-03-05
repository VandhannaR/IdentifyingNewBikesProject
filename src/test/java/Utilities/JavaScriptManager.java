package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptManager {
	JavascriptExecutor jse;
	//Scroll into an element
	public void scrollIntoView(WebDriver driver, WebElement element) {
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Scroll to the top
	public void scrollToTop(WebDriver driver) {
		jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, 0);");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Highlight element
	public void highlightElement(WebDriver driver, WebElement element) {
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].style.border='2px solid blue'", element);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Scroll inside div
	public void scrollInsideDiv(WebDriver driver, WebElement element, int vertical) {
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollTop +=" + vertical + ";", element);
	}
}

