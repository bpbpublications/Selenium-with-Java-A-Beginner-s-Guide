package chapter10;

import org.testng.annotations.*;
import java.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import handlingData.DataReaders;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class loginLogoutUsingExcel {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@DataProvider(name = "loginExcel")
	  public Object[][] loginExcelData() throws IOException  {
		  String[][] data=DataReaders.getExcelDataUsingPoi("src\\test\\resources\\data\\datasheet.xlsx", "Data");
		  return data;
	 }
	
	@Test(dataProvider="loginExcel")
	public void loginUsingWrapperMethods(String uname,String passwd) throws Exception {
		driver.get("http://practice.bpbonline.com/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.name("email_address")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(passwd);
		driver.findElement(By.id("tdb1")).click();
		driver.findElement(By.linkText("Log Off")).click();
		driver.findElement(By.linkText("Continue")).click();
	}

    @AfterMethod
    void after() {
    	driver.close();
    }
 }
