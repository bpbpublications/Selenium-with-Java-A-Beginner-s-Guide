package chapter10;

import org.testng.annotations.*;
import java.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import handlingData.DataReaders;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class loginLogoutUsingCSV {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@DataProvider(name = "logincsv")
	  public Object[][] loginCSVData() throws IOException  {
		List<String[]> allData=DataReaders.getCSVData("src\\test\\resources\\Data\\logindetails.csv",1);
		String[][] data=new String[allData.size()][allData.get(0).length];
		// read data in 2D array
		int i=0;
		for (String[] row : allData) {
			int j=0;
	        for (String cell : row) {
	        	data[i][j]=cell;
	            j=j+1;
	            }
	            i=i+1;
	       }
		  return data;
	}
	
	@Test(dataProvider="logincsv")
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
