package chapter3;
import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class demoWebDriverManagerFirefox {

	public static void main(String[] args) throws Exception {
		//set up firefox driver[geckodriver] with webdrivermanager
		WebDriverManager.firefoxdriver().setup();
		//create instance of firefox
		WebDriver driver= new FirefoxDriver();
		driver.get("http://practice.bpbonline.com/");
		Thread.sleep(2000);
		driver.close();
	}
}
