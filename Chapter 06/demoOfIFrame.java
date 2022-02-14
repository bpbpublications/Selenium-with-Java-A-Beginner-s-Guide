package chapter6;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class demoOfIFrame {

	public static void main(String[] args) throws Exception {
		
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		//open chrome browser with the url.
		driver.get("https://the-internet.herokuapp.com/iframe");
		//switch the focus to the iframe, we identify in here the iframe using its id property
		driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
		//Your content goes here is associated with the paragraph html element
		String contents = driver.findElement(By.xpath("//p")).getText();
		System.out.println(contents);
		driver.switchTo().defaultContent(); //switch back to the parent html document
		driver.close();
	}

}

