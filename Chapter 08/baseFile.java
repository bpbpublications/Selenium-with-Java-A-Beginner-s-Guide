package chapter8;
import io.github.bonigarcia.wdm.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class baseFile {
	
	static WebDriver driver;

	public static WebDriver setDriver(String browserName) {
	
		if(browserName.equals("chrome")) {
			 WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}else {
			driver=null;
		}
	 
	  return driver;
	}
}
