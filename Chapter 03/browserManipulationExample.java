package chapter3;



import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class browserManipulationExample {

	public static void main(String[] args) throws Exception {
		
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		//browser manipulation method
		driver.get("http://practice.bpbonline.com/");
		driver.manage().window().maximize();
		driver.navigate().to("http://www.selenium.dev");
		driver.close();
	}
}

