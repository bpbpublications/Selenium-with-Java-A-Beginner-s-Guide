package chapter7;
import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.*;

public class demoWebDriverManagerIE {

	public static void main(String[] args) throws Exception {
		//set up iedriver with webdrivermanager
		WebDriverManager.iedriver().setup();
		//create instance of ie
		WebDriver driver= new InternetExplorerDriver();
		driver.get("http://practice.bpbonline.com/");
		Thread.sleep(2000);
		driver.close();
	}
}
