package chapter5;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;


public class workingWithwebTables_producttable {

	public static void main(String[] args) throws Exception {
		
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		
		//launch application
		driver.get("http://practice.bpbonline.com/index.php");
		
		//add implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//create the table element
		WebElement productTable = driver.findElement(By.tagName("table"));
			
		//Fetch all table rows
		List<WebElement> rows = productTable.findElements(By.xpath("//*/tbody/tr"));
		for(WebElement row : rows) {
			//Fetch all table cols
			List<WebElement> cols = row.findElements(By.xpath("td"));
			for(WebElement col: cols) {
				//print cell content
				String content = col.getText();
				System.out.println(content);
			}
		}
		
	}
}



