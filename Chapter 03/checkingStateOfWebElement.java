package chapter3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
public class checkingStateOfWebElement {

	public static void main(String[] args) throws Exception {
		
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		//browser manipulation method
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		driver.manage().window().maximize();
		WebElement firstCheckbox=driver.findElement(By.cssSelector("#checkboxes"));
		System.out.println(firstCheckbox.isDisplayed());
		System.out.println(firstCheckbox.isEnabled());
		System.out.println(firstCheckbox.isSelected());
		firstCheckbox.click();
		System.out.println(firstCheckbox.isSelected());
		driver.close();
	}
}

