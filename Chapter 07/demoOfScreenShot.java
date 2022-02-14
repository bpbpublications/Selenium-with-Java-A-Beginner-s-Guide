package chapter7;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import org.apache.commons.io.FileUtils;

public class demoOfScreenShot {

	public static void main(String[] args) throws Exception {
		//Read the contents of the csv file
		FileReader readerObj = new FileReader("DataFiles\\logininformation.csv"); //stream object
		BufferedReader bufReader = new BufferedReader(readerObj); //input stream
		String line=bufReader.readLine(); //fetch the first line of the file. 
		
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		//add implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//login.
		driver.get("http://www.practice.bpbonline.com/");
		//Reading the files line by line until we reach end of file
		while(line != null) {
			//spliting the line into two sub strings using comma as seperator.
			//at array position 0 will be username, and at 1 it will be password
			String[] loginDetails=line.split(",");
			driver.findElement(By.linkText("My Account")).click();
			driver.findElement(By.name("email_address")).sendKeys(loginDetails[0]);
			driver.findElement(By.name("password")).sendKeys(loginDetails[1]);
			driver.findElement(By.id("tdb1")).click();
			if(driver.getPageSource().contains("My Account Information")) {
				File scrnsht =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String fname= "Screenshots\\"+loginDetails[0]+".jpg";
				FileUtils.copyFile(scrnsht, new File(fname));
				//log off action
				driver.findElement(By.linkText("Log Off")).click();
				driver.findElement(By.linkText("Continue")).click();
			}else {
				//if user is not valid, then just capture the screenshot
				File scrnsht =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String fname= "Screenshots\\"+loginDetails[0]+".jpg";
				FileUtils.copyFile(scrnsht, new File(fname));
			}
			//read the next line of the file. 
			line=bufReader.readLine();
		}
		//close the browser
		driver.close();
	}
}
