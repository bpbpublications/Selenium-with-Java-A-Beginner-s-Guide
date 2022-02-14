package chapter12;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginLogoutWithChrome {
  WebDriver driver;
 
  @BeforeMethod
  public void setUp() throws Exception {
	   DesiredCapabilities capability = DesiredCapabilities.chrome();
	   driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRecordedLogin() throws Exception {
    driver.get("http://practice.bpbonline.com/");
    driver.findElement(By.linkText("My Account")).click();
    driver.findElement(By.name("email_address")).clear();
    driver.findElement(By.name("email_address")).sendKeys("bpb@bpb.com");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("bpb@123");
    driver.findElement(By.id("tdb1")).click();
     driver.findElement(By.linkText("Log Off")).click();
     driver.findElement(By.linkText("Continue")).click();
   }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.quit();
  }
}
