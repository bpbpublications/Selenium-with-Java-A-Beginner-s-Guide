package chapter6;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;



public class demoOfAlertBox {

	public static void main(String[] args) throws Exception {
		
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		//open chrome browser with the url.
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(2000); //wait for alert to appear
		Alert alertBox= driver.switchTo().alert(); //accept the alert
		alertBox.accept();
		if(driver.findElement(By.xpath("//p[@id='result']")).getText().contains("You successfully clicked an alert")){
		
			System.out.println("Alert was handled");
		}else {
			System.out.println("Alert was not handled");
			
		}
		driver.close();
	}

}

