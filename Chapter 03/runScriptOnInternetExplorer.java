package chapter3;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.*;

public class runScriptOnInternetExplorer {
	public static void main(String[] args) throws Exception {
		//set system property
		System.setProperty("webdriver.ie.driver", "driverexes\\IEDriverServer.exe");
		//Initialize driver object
		WebDriver driver = new InternetExplorerDriver();
		//open ie browser with the url.
		driver.get("http://practice.bpbonline.com/");
		Thread.sleep(5000); //wait for 5 seconds
		driver.close();
	}
}
