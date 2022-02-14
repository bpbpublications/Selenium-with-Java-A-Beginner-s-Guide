package chapter9;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class loginWithPageFactory {
	 WebDriver driver;
	
	 @FindBy(linkText = "My Account")
	 WebElement myAccLnk;
	 
	 @FindBy(name = "email_address")
	 WebElement uname;

	 @FindBy(name = "password")
	 WebElement pwd;
	 
	 @FindBy(id = "tdb1")
	 WebElement signBtn;
	 
	 public loginWithPageFactory(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
		 }
	 
	 public void clickAccount() {
		 myAccLnk.click();
	}
	 
	 public void typeUser(String user) {
		 uname.clear();
		 uname.sendKeys(user);
	 }
	 
	 public void typePwd(String password) {
		 pwd.clear();
		 pwd.sendKeys(password);
	 }
	 
	 public void clickSign() {
		 signBtn.click();
	 }
	 
	 public void login(String u, String p) {
		 typeUser(u);
		 typePwd(p);
		 clickSign();
	 }
}



