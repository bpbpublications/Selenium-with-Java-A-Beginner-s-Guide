package chapter5;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;


public class workingWithdropdownelement_manufacturer {

	public static void main(String[] args) throws Exception {
		
		//set system property
		System.setProperty("webdriver.chrome.driver", "driverexes\\chromedriver.exe");
		
		//Initialize driver object
		WebDriver driver = new ChromeDriver();
		
		//launch application
		driver.get("http://practice.bpbonline.com/index.php");
		
		//add implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//create the dropdown element
		Select manufacturers = new Select(driver.findElement(By.xpath("//select[@name='manufacturers_id']")));
		
		//getting all option elements available within the dropdown
		List<WebElement> allmanfs=manufacturers.getOptions();
		allmanfs.remove(0); //removing Please Select from the list. 
		
		//creating an arraylist for all manufacturers name
		ArrayList<String> allNames = new ArrayList<String>();
		for(WebElement man : allmanfs) {
			allNames.add(man.getText());
		}
		
		//selecting each manufacturer one by one
		for(String manname : allNames) {
			//selecting element by its visible text
			manufacturers.selectByVisibleText(manname);
			//handling the stale element exception as page refreshes.
			manufacturers = new Select(driver.findElement(By.xpath("//select[@name='manufacturers_id']")));
			if(driver.getPageSource().contains("There are no products available in this category.")) {
				System.out.println("The manufacturer "+ manname +" has no products");
			}else {
				//create the table element
				WebElement productTable = driver.findElement(By.className("productListingHeader"));
					
				//Fetch all table rows
				System.out.println("\n\nThe manufacturer - "+manname +" products are listed--");
				List<WebElement> rows = productTable.findElements(By.xpath("//*/tbody/tr"));
				for(WebElement row : rows) {
					//Fetch all table cols
					System.out.println(row.getText());
				}
			}	
			
		}
		driver.close();
	}
}




