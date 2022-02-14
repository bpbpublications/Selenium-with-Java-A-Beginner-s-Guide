package chapter3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
public class fetchElementInformation {

	public static void main(String[] args) throws Exception {
		
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		//browser manipulation method
		driver.get("http://practice.bpbonline.com/");
		driver.manage().window().maximize();
		WebElement quickFind=driver.findElement(By.xpath("//input[@title=' Quick Find ']"));
		System.out.println(quickFind.getAttribute("alt"));
		System.out.println(quickFind.getTagName());
		System.out.println(quickFind.getText());
		System.out.println(quickFind.getCssValue("background-color"));
		System.out.println(quickFind.getSize().height);
		System.out.println(quickFind.getRect().height);
		driver.close();
	}
}

