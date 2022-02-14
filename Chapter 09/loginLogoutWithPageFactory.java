package chapter9;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginLogoutWithPageFactory {
	
	  WebDriver driver;
	  loginWithPageFactory loginPF;
	  logoutWithPageFactory logoffPF;
	  
  
  @BeforeMethod
  public void beforeMethod() {
	  //set up chromedriver with webdrivermanager
		WebDriverManager.chromedriver().setup();
		//create instance of chrome
		driver= new ChromeDriver();
		loginPF=new loginWithPageFactory(driver);
		logoffPF= new logoutWithPageFactory(driver);
	    //an implicit wait given for each command to search and object and perform operation on it
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    //maximize window
	    driver.manage().window().maximize();
  }
  
 @Test
  public void testLogin() throws Exception {
	  	driver.get("http://practice.bpbonline.com/");
	  	//login using page factory
	  	loginPF.clickAccount();
	  	loginPF.login("bpb@bpb.com", "bpb@123");
	  	//logoff using page factory
	  	logoffPF.logOff();
   }
  
 @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
