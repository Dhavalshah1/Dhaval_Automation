package Utility;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import PageObjects.LoginPage;
import PageObjects.Logout;
import TestCases.Dynamic_Training;

public class Delete_object {
	
	public WebDriver driver;
	@Test
	public void deleteEvent() throws IOException, InterruptedException {
	/**
	 * Login as a Admin;
	 */
	WebDriver driver = BrowserFactory.getBrowser(DataProviderFactory.getProperty().getBrowser());
	LoginPage login = new LoginPage(driver);
	//login.Login_Admin();
	driver.get(DataProviderFactory.getConfig().getData(0, 1, 1));
	//LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	//login.loginToSalesforce(DataProviderFactory.getConfig().getData(00, 2, 2),
			//DataProviderFactory.getConfig().getData(00, 1, 3));
	Utility.static_wait(5);	
	
	/**
	 * delete resource
	 */
	driver.findElement(By.id("phSearchInput")).sendKeys(Dynamic_Training.TxtBoxContent);
	driver.findElement(By.xpath("//*[@id='phSearchButton']")).click();
	driver.findElement(By.partialLinkText("TRE-")).click();
	driver.findElement(By.xpath("//a[contains(@title,'Delete - Record 1 - RR')]")).click();
	Alert alert = driver.switchTo().alert();
	alert.accept();
	Utility.static_wait(5);	
	/**
	 * delete Event
	 */
	driver.findElement(By.name("del")).click();
	Alert alert1 = driver.switchTo().alert();
	alert1.accept();
	Utility.static_wait(5);
	/**
	 * logout
	 */
	Logout logout = PageFactory.initElements(driver, Logout.class);
	logout.logOutApplication();		
	}

}
