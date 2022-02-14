package chapter9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Logout_Pom {
	private WebDriver driver;
	
    public Logout_Pom(WebDriver driver) {
        this.driver = driver;
       }

    	By logOff = By.linkText("Log Off");
        By continueButton = By.linkText("Continue");
   
       public Logout_Pom clickLogOff() {
            // This is the only place that "knows" how to enter a username
            driver.findElement(logOff).click();
            return this;    
        }

        public Logout_Pom clickContinue() {
            // This is the only place that "knows" how to enter a username
            driver.findElement(continueButton).click();
            return this;    
        }

        
    public Logout_Pom logOff() {
      clickLogOff();
      return clickContinue();
    }
}
