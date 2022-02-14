package chapter8;

import org.testng.annotations.*;
import org.testng.Reporter;
import java.io.*;
import org.openqa.selenium.*;


public class loginLogoutWithDataProvider {
	WebDriver driver;
	
	
  @BeforeMethod
  @Parameters ({"browser"})
  public void setupBrowser(String brow) {
	driver= baseFile.setDriver(brow);
  }

  @DataProvider (name = "logininformation")
  public Object[][] dpMethod() {
	  
	  String data[][]=new String[2][2];//declaring the 2D array with dimensions
	  int i=0;
	  try {
	      //parsing a CSV file into BufferedReader class constructor  
	      BufferedReader br = new BufferedReader(new FileReader("D:\\WORK\\BPB PUBLICATIONS\\SECOND BOOK\\CODEFILES\\SeleniumWithJava\\DataFiles\\logininformation.csv"));
	      String line=br.readLine();
	      while (line!= null)
	      //returns a Boolean value  
	      {
	        String[] userInfo = line.split(",");
	        data[i][0]=userInfo[0];
	        data[i][1]=userInfo[1];
	        i++;
		    line=br.readLine();
	      }
	     
	    }
	    catch(IOException e) {
	      e.printStackTrace();
	    }
	  
      return data;
   }
  
  @Test(dataProvider = "logininformation")
  public void validLogin(String user, String pwd) {
		//login.
		driver.get("http://www.practice.bpbonline.com/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.name("email_address")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pwd);
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
