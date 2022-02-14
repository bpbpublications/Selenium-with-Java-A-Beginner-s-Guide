package chapter3;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class runScriptOnFirefox {

	public static void main(String[] args) throws Exception {
		
		//set system property
		System.setProperty("webdriver.gecko.driver", "driverexes\\geckodriver.exe");
		//Initialize driver object
		WebDriver driver = new FirefoxDriver();
		//open firefox browser with the url.
		driver.get("http://practice.bpbonline.com/");
		Thread.sleep(5000); //wait for 5 seconds
		driver.close();
	}
}
