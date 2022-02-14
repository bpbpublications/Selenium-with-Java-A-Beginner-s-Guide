package chapter5;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;


public class handlingInputElements_changeProfile {

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
		
		//change profile
		driver.findElement(By.linkText("View or change my account information.")).click();
		//change gender-if male is selected, select female else select male.
		if(driver.findElement(By.xpath("//input[@value='m']")).isSelected()){
			driver.findElement(By.xpath("//input[@value='f']")).click();
		}else {
			driver.findElement(By.xpath("//input[@value='m']")).click();
		}
		//change phone
		driver.findElement(By.name("telephone")).clear();
		driver.findElement(By.name("telephone")).sendKeys("23838393");
		driver.findElement(By.id("tdb5")).click(); //continue button
		if(driver.getPageSource().contains("account has been successfully updated")) {
			System.out.println("Change profile successful");
		}else {
			System.out.println("Profile information not changed");
		}
		
		//logout
		driver.findElement(By.linkText("Log Off")).click();
		driver.findElement(By.linkText("Continue")).click();
		driver.close();
	}
}



