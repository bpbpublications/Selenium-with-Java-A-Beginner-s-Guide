package chapter3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.util.*;
public class findingAllLinks {

	public static void main(String[] args) throws Exception {
		
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		//browser manipulation method
		driver.get("http://practice.bpbonline.com/");
		driver.manage().window().maximize();
		List<WebElement> allLinks=driver.findElements(By.xpath("//a"));
		for(WebElement lnk:allLinks) {
			System.out.println(lnk.getText());
		}
		driver.close();
	}
}

