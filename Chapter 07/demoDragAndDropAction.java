package chapter7;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import  org.openqa.selenium.interactions.*;

public class demoDragAndDropAction {

	public static void main(String[] args) throws Exception {
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//open chrome browser with the url.
		driver.get("https://jqueryui.com/droppable/");
		//to perform scroll on an application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//switch to the iframe
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		//source element
		WebElement drag=driver.findElement(By.id("draggable"));
		//target element
		WebElement drop=driver.findElement(By.id("droppable"));
		//Create action object
		Actions act=new Actions(driver);
		//call the drag drop action
		act.dragAndDrop(drag, drop).perform();
		//wait for 5 seconds before closing the browser
		Thread.sleep(5000);
		//close the browser
		driver.close();
		

	}

	private static Actions Actions(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

}
