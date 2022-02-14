package chapter9;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import io.github.bonigarcia.wdm.WebDriverManager;


public class loginLogoutUsingPOM {
	  private WebDriver driver;
	 	
	 @Before
	  public void setUp() throws Exception {
		 //set up chromedriver with webdrivermanager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	 
	 @Test
	 public void test() throws Exception{
		 driver.get("http://practice.bpbonline.com/");
		 Login_Pom login = new Login_Pom(driver);
		 Logout_Pom logout = new Logout_Pom(driver);
		
		 login.clickMyAccount();
		 login.loginAs("bpb@bpb.com", "bpb@123");
		 login.validateLogin("My Account Information");
		 logout.logOff();
		
	 }
	 
	 @After
	 public void cleanup(){
		 driver.quit();
	}
}
