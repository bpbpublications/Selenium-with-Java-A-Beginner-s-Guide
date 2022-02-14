package chapter9;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class logoutWithPageFactory {
	 WebDriver driver;
	
	 @FindBy(linkText = "Log Off")
	 WebElement logoffLnk;
	 
	 @FindBy(linkText = "Continue")
	 WebElement continueLnk;
	 
	 public logoutWithPageFactory(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
		 }
	 
	 public void logOffClick() {
		 logoffLnk.click();
	}
	 public void ctnClick() {
		 continueLnk.click();
	}
	 
	 
	 public void logOff() {
		logOffClick();
		ctnClick();
	 }
}



