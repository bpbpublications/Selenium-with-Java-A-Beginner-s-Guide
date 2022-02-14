package chapter4;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class demoOfExplicitWait {

	public static void main(String[] args) throws Exception {
		
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		
		//add implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//login.
		driver.get("http://practice.bpbonline.com/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.name("email_address")).sendKeys("bpb@bpb.com");
		driver.findElement(By.name("password")).sendKeys("bpb@123");
		
		driver.findElement(By.id("tdb1")).click();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		//explicit wait
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Junk")));
		
		//logout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Log Off")).click();
		driver.findElement(By.linkText("Continue")).click();
		driver.close();
	}
}



