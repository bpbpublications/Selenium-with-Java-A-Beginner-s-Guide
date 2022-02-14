package chapter9;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class Login_Pom {
	private WebDriver driver;
	//Constructor of the class
	public Login_Pom(WebDriver driver) {
        this.driver = driver;
     }

 // The login page contains several HTML elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.
    	By myaccount = By.linkText("My Account");
        By usernameLocator = By.name("email_address");
        By passwordLocator = By.name("password");
        By loginButtonLocator = By.id("tdb1");

     // This will click on the MyAccount link
        public Login_Pom clickMyAccount() {
              driver.findElement(myaccount).click();
           // Return the current page object as this action doesn't navigate to a page represented by another PageObject
            return this;    
        }

        
    // The login page allows the user to type their username into the username field
    public Login_Pom typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;    
    }

    // The login page allows the user to type their password into the password field
    public Login_Pom typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;    
    }

    // The login page allows the user to submit the login form
    public Login_Pom submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return this;    
    }
    
    public boolean validateLogin(String srchTxt) {
        if (driver.getPageSource().contains(srchTxt)){
        	return true;
        }else{
        	return false;
        }
    }
    
 // Conceptually, the login page offers the user the service of being able to "log into"
    // the application using a user name and password. 
  
    public Login_Pom loginAs(String username, String password) {
        // The PageObject methods that enter username, password & submit login have already defined and should not be repeated here.
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}



