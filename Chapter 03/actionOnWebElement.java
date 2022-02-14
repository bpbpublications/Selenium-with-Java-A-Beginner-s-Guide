package chapter3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
public class actionOnWebElement {

	public static void main(String[] args) throws Exception {
		
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		//browser manipulation method
		driver.get("http://practice.bpbonline.com/");
		driver.manage().window().maximize();
		WebElement searchField=driver.findElement(By.name("keywords"));
		//clear action
		searchField.clear();
		//type action
		searchField.sendKeys("mouse");
		WebElement quickFind=driver.findElement(By.xpath("//input[@title=' Quick Find ']"));
		//click action
		quickFind.click();
		
		driver.close();
	}
}

