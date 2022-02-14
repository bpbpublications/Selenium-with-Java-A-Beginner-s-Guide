package chapter3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class webPageInformation {

	public static void main(String[] args) throws Exception {
		
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		//browser manipulation method
		driver.get("http://practice.bpbonline.com/");
		System.out.println(driver.getTitle());
		if(driver.getPageSource().contains("Welcome to BPB PUBLICATIONS")) {
			System.out.println("Page is loaded");
		}
		driver.manage().window().maximize();
		driver.navigate().to("http://www.selenium.dev");
		if(driver.getCurrentUrl().contains("selenium")) {
			System.out.println("Page is now changed to Selenium website");
		}
		driver.close();
	}
}

