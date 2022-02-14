package chapter8;

import org.testng.annotations.*;
import org.testng.Reporter;
import org.openqa.selenium.*;


public class loginLogoutWithParams {
	WebDriver driver;
	
	
  @BeforeMethod
  @Parameters ({"browser"})
  public void setupBrowser(String brow) {
	driver= baseFile.setDriver(brow);
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
