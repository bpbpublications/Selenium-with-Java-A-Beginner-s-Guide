package chapter7;
import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class demoWebDriverManagerChrome {

	public static void main(String[] args) throws Exception {
		//set up chromedriver with webdrivermanager
		WebDriverManager.chromedriver().setup();
		//create instance of chrome
		WebDriver driver= new ChromeDriver();
		driver.get("http://practice.bpbonline.com/");
		Thread.sleep(2000);
		driver.close();
	}
}
