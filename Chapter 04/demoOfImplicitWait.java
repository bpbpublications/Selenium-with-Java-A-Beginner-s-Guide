package chapter4;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;


public class demoOfImplicitWait {

	public static void main(String[] args) throws Exception {
		
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		
		//add implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//login.
		driver.get("http://www.practice.bpbonline.com/");
		driver.findElement(By.linkText("My Account")).click();
	    driver.findElement(By.name("email_address")).sendKeys("bpb@bpb.com");
		driver.findElement(By.name("password")).sendKeys("bpb@123");
		driver.findElement(By.id("tdb1")).click();
		
		//logout
		driver.findElement(By.linkText("Log Off")).click();
		driver.findElement(By.linkText("Continue")).click();
		driver.close();
	}
}



