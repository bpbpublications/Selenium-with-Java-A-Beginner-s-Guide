package chapter6;

import java.util.Set;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class demoOfWindow {

	public static void main(String[] args) throws Exception {
		
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		//open chrome browser with the url.
		driver.get("https://the-internet.herokuapp.com/windows");
		//Click on Click Here
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> allWindowHandles = driver. getWindowHandles(); 
		for(String handle: allWindowHandles) {
			System.out.println(handle);
		}
		//convert the set into an array so that we can access the window.
		//at array 0 position, the main window handle will be there, and after that based on when a new window is openned
		//it will take the next position in the array
		Object[] windows= allWindowHandles.toArray();
		//Swtich to new window
		driver.switchTo().window(windows[1].toString());
		if(driver.getPageSource().contains("New Window")) {
			System.out.println("we are now on new window");
			System.out.println("closing the child window");
			driver.close();
		}
		//switch to the main window
		System.out.println("closing the main window");
		driver.switchTo().window(windows[0].toString());
		driver.close();
		
	}

}

