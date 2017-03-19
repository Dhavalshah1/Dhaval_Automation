package Factory;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import Utility.Utility;

public class LoginPage1 {

	 WebDriver driver;

	public LoginPage1(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "user-signin")
	WebElement username;

	@FindBy(id = "pass-signin")
	WebElement password;

	@FindBy(id = "signin-button")
	WebElement loginbutton;
	@FindBy(xpath = "//*[@href='http://www.intuitivesurgical.com/']")
	
	WebElement Comanylogo;

	public  void loginToServicenow(String uname,String pass)  {
		Utility.Highlightelements(driver, username);
		username.sendKeys(uname);
		Utility.Highlightelements(driver, password);
		password.sendKeys(pass);
		Utility.Highlightelements(driver, loginbutton);
		loginbutton.click();
		
		
		Utility.static_wait(5);
		
		Utility.Highlightelements(driver, Comanylogo);
		// Comanylogo.click();
		Assert.assertEquals("Intuitive Surgical - My Applications", driver.getTitle());
		// Utility.Highlightelements(driver, username);

		driver.findElement(By.xpath("//img[@alt='Graphic Link ServiceNow-Dev']")).click();
		//driver.findElement(By.xpath("//img[@alt='Graphic Link ServiceNow-IT Test']")).click();
		

		//driver.findElement(By.xpath("")).click();
		
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.manage().window().maximize();
		Utility.static_wait(5);
		// Assert.assertEquals(driver.getTitle(), "Salesforce - Unlimited
		// Edition");
		
	}
	
	
	
	
}
