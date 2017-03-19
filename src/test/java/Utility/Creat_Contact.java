package Utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import PageObjects.LoginPage;
import PageObjects.Logout;

public class Creat_Contact {
	
	public WebDriver driver;
	  static String ContactName="";
        @Test(priority=0)
        
		public   void Contact() throws InterruptedException{
        	
        	WebDriver driver = BrowserFactory.getBrowser(DataProviderFactory.getProperty().getBrowser());
			driver.get(DataProviderFactory.getConfig().getData(0, 2, 1));
			LoginPage login = PageFactory.initElements(driver, LoginPage.class);
			login.loginToSalesforce(DataProviderFactory.getConfig().getData(00, 3, 2),
					DataProviderFactory.getConfig().getData(00, 1, 3));
		    Thread.sleep(5000);
			driver.findElement(By.linkText("Contacts")).click();
			
			driver.findElement(By.xpath("//*[@name='new']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[contains(text(),'Record Type of new record')]//following::select[1]")).click();
			driver.findElement(By.xpath("//*[contains(text(),'Record Type of new record')]//following::input[1]")).click();
			driver.findElement(By.xpath("//*[contains(text(),'Search criteria')]//following::input[2]")).sendKeys("Test");
			driver.findElement(By.xpath("//*[contains(text(),'Search criteria')]//following::input[3]")).sendKeys("Contact");			
			driver.findElement(By.xpath("//*[@onclick='validateForSearch2();']")).click();
			Thread.sleep(5000);
			////input[contains(@value,'New Contact')]
			driver.findElement(By.xpath("//input[contains(@value,'New Contact')]")).click();			
			Select gender = new Select(driver.findElement(By.xpath("//*[contains(text(),'ISI Title')]//following::select[2]")));
			gender.selectByVisibleText("Surgeon");			
			driver.findElement(By.xpath("//*[contains(text(),'ISI Title')]//following::img[@id[contains(.,'B2C_right')]]")).click();
			driver.findElement(By.xpath("//input[@tabindex='12']")).sendKeys("Valley Hospital & Medical Center");
			driver.findElement(By.xpath("//input[@tabindex='13']")).sendKeys("GEN:GEN");
			driver.findElement(By.xpath("//*[contains(text(),'Email')]//following::input[@id='con15']")).sendKeys("1243@intusurg.com");
			driver.findElement(By.xpath("//*[contains(text(),'Phone')]//following::input[1]")).sendKeys("000-000-0000");		
			driver.findElement(By.xpath("//*[@name='save']")).click();
			Thread.sleep(5000);
			
			ContactName=driver.findElement(By.xpath("//div[contains(@id,'con2_ileinner')]")).getText();
			System.out.println("Contact name is ="+  ContactName);
			Logout logout = PageFactory.initElements(driver, Logout.class);
			logout.logOutApplication();}
			
			
        
        @Test(priority=1)
        
		public  void Del_Contact() throws InterruptedException{			
			WebDriver driver = BrowserFactory.getBrowser(DataProviderFactory.getProperty().getBrowser());
			driver.get(DataProviderFactory.getConfig().getData(0, 2, 1));
			LoginPage login = PageFactory.initElements(driver, LoginPage.class);
			login.loginToSalesforce(DataProviderFactory.getConfig().getData(00, 2, 2),
					DataProviderFactory.getConfig().getData(00, 1, 3));
			Thread.sleep(10000);
			
			driver.findElement(By.id("phSearchInput")).sendKeys(ContactName);
			driver.findElement(By.xpath("//*[@id='phSearchButton']")).click();
            driver.findElement(By.linkText("Test Contact")).click();
			
			driver.findElement(By.xpath("//*[@name='del']")).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			driver.findElement(By.partialLinkText("Address-")).click();
			driver.findElement(By.xpath("//*[@name='del']")).click();
			Alert alert1 = driver.switchTo().alert();
			alert1.accept();
			Logout logout = PageFactory.initElements(driver, Logout.class);
			logout.logOutApplication();
			}
        
        
        
}
