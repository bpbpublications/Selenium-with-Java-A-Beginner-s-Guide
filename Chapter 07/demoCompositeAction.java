package chapter7;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import  org.openqa.selenium.interactions.*;

public class demoCompositeAction {

	public static void main(String[] args) throws Exception {
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//open chrome browser with the url.
		driver.get("https://the-internet.herokuapp.com/key_presses");
		WebElement textBox=driver.findElement(By.id("target"));
		//Create action object
		Actions act=new Actions(driver);
		//press tab key first and then wait for 5 seconds, and then press space
		act.sendKeys(textBox, Keys.TAB).pause(5000).sendKeys(textBox,Keys.SPACE).build().perform();
		//wait for 5 seconds before closing the browser
		Thread.sleep(5000);
		//close the browser
		driver.close();
	}
}
