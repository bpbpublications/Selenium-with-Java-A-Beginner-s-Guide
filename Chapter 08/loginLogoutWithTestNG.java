package chapter8;

import org.testng.annotations.*;
import io.github.bonigarcia.wdm.*;
import java.util.concurrent.TimeUnit;
import org.testng.Reporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;


public class loginLogoutWithTestNG {
	WebDriver driver;
	
  @BeforeMethod
  public void setupBrowser() {
	  //set up chromedriver with webdrivermanager
	  WebDriverManager.chromedriver().setup();
	  //create instance of chrome
	  driver= new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void validLogin() {
		//login.
		driver.get("http://www.practice.bpbonline.com/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.name("email_address")).sendKeys("bpb@bpb.com");
		driver.findElement(By.name("password")).sendKeys("bpb@123");
		driver.findElement(By.id("tdb1")).click();
		if(driver.getPageSource().contains("My Account Information")) {
			//log off action
			driver.findElement(By.linkText("Log Off")).click();
			driver.findElement(By.linkText("Continue")).click();
			Reporter.log("User information is valid");
			}else {
				Reporter.log("User information is invalid");
			}
			
  }
  
  @AfterMethod
  public void cleanUp() {
	//close the browser
	driver.close();
  }

}
