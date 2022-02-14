package chapter3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;


public class runScriptOnChrome {

	public static void main(String[] args) throws Exception {
		
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		//open chrome browser with the url.
		driver.get("http://practice.bpbonline.com/");
		Thread.sleep(5000); //wait for 5 seconds
		driver.close();
	}

}

