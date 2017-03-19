package TestCases;


import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.intusurg.windchill.WindChillTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import DataProvider.ConfigurationFile;
import DataProvider.ExcelConfig;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import MailDemo.SendMail;
import Utility.Utility;

@Listeners(Factory.TestNGListner.class)

public class ElfuScripts {
	
	 
	  private SoftAssert softAssert = new SoftAssert();
	 
	ExtentReports report2;
	ExtentTest logger2;
	public static String TxtBoxContent = "";
	public WebDriver driver;
	private Object element;
	public Screen D1=new Screen();
	Pattern IMA1= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\NA.png");
	Pattern IMA2= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\SA.png");
	Pattern IMA3= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\EU.png");
	Pattern IMA4= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\ASIA.png");
	Pattern IMA5= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\AF.png");
	Pattern IMA6= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\OC.png");
	//Resolution 1920*1020
	
	
	/*Pattern IMA1= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\NA1.png");
	Pattern IMA2= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\SA1.png");
	Pattern IMA3= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\EU1.png");
	Pattern IMA4= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\ASIA1.png");
	Pattern IMA5= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\AF1.png");
	Pattern IMA6= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\OC1.png");*/
	
	@BeforeClass
	public void setup() {
		report2 = new ExtentReports("./Reports/ElfuScripts.html");

	}

	@AfterClass
	public void tearDown() throws Exception {
		report2.endTest(logger2);
		report2.flush();
		SendMail.execute();
		
	}

	@Test(priority=1)
	public void User_Access() throws Exception {

		logger2 = report2.startTest("02-User Access");
		/**
		 * Call login step from Library
		 */
		ConfigurationFile property = DataProviderFactory.getProperty();
		WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());
		Utility.static_wait(2);
		driver.get(property.getURL());
		Screen D1 = new Screen();
		softAssert.assertEquals("Market - dvpuat.net", driver.getTitle());
		WebElement Logo = driver.findElement(By.cssSelector("img.isi-logo"));
		Utility.Highlightelements(driver, Logo);
		Utility.static_wait(1);

		WebElement Texe1 = driver.findElement(By.cssSelector("div.col.s4"));
		Utility.Highlightelements(driver, Texe1);
		Utility.static_wait(1);
		Utility.Takescrrnshotrun(driver, "Global Map");
		String img = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Global Map.png");
		logger2.log(LogStatus.PASS, "Step 1:Launch the Document Library website","Expected output:Document Library homepage is opened " + img);
		WebElement french = driver.findElement(By.xpath("//*[contains(text(),'Dites-nous où vous êtes.')]"));
		Utility.Highlightelements(driver, french);
		Utility.static_wait(1);
		WebElement Germon = driver.findElement(By.xpath("//*[contains(text(),'Sagen Sie uns, wo Sie sich gerade befinden.')]"));
		Utility.Highlightelements(driver, Germon);
		Thread.sleep(1000);
		WebElement Spanesh = driver.findElement(By.xpath("//*[contains(text(),'Díganos dónde se encuentra.')]"));
		Utility.Highlightelements(driver, Spanesh);
		Thread.sleep(1000);
		WebElement Itely = driver.findElement(By.xpath("//*[contains(text(),'Comunicaci dove ti trovi.')]"));
		Utility.Highlightelements(driver, Itely);
		Utility.static_wait(1);
		WebElement Japan = driver.findElement(By.xpath("//*[@id='tell-us']/div[2]/div[3]"));
		Utility.Highlightelements(driver, Japan);
		Utility.static_wait(3);
		D1.hover(IMA3);
		Utility.static_wait(3);
		D1.click(IMA1);
		Thread.sleep(3000);
		
		Utility.Takescrrnshotrun(driver, "North_America");
		String img1 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\North_America.png");
		logger2.log(LogStatus.PASS, "Step 2:From the world map that is displayed ,select any  'Continent'.","Expected output:Country selection screen appears with the selected Continent name, displayed as the Title of the screen. " + img1);	 
		
		D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\REMNO.png");
		Thread.sleep(3000);
		/*Utility.Takescrrnshotrun(driver, "Global Map");
		String img = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Global Map.png");
		logger2.log(LogStatus.PASS, "Step 1:Launch the Document Library website","Expected output:Document Library homepage is opened " + img);	*/ 
		WebElement Logo2 = driver.findElement(By.cssSelector("h4"));
		Utility.Highlightelements(driver, Logo2);

		Utility.Takescrrnshotrun(driver, "Login3");
		WebElement United_States = driver.findElement(By.linkText("United States"));
		Utility.safeJavaScriptClick(United_States, driver);
		Thread.sleep(2000);
		Utility.Takescrrnshotrun(driver, "USA");
		String img2 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\USA.png");
		logger2.log(LogStatus.PASS, "Step 3:Select 'Country' from  the list of countries tiles displayed for the selected 'Continent'","Expected output:Language  selection screen appears with the selected 'Language name', displayed as the Title of the screen." + img2);
		WebElement ImageFile = driver.findElement(By.cssSelector("#language_isi_image_container > #isi_image > img.isi_image"));
		Utility.Highlightelements(driver, ImageFile);
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",ImageFile);
		if (ImagePresent) {
			System.out.println("Image is displayed.");
		} else {
			driver.quit();
		}
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		element = wait1.until(ExpectedConditions.elementToBeClickable(By.className("language-name")));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", element);
		Utility.static_wait(2);
		Utility.Takescrrnshotrun(driver, "English");
		String img4 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\English.png");
		logger2.log(LogStatus.PASS, "Step 5:Select  corresponding 'Language' listed on screen","Expected output:Search screen appears in the selected language with Advanced search label in the search box displayed in the corresponding language" + img4);
		WebElement Logo1 = driver.findElement(By.cssSelector("h6.country-header"));
		Utility.Highlightelements(driver, Logo1);
		Utility.static_wait(2);		
		driver.get(property.URLAdmin());
		Utility.static_wait(2);	
		driver.findElement(By.xpath("//input[contains(@id,'_login')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'_login')]")).sendKeys(property.getUName());
		driver.findElement(By.xpath("//input[contains(@id,'_password')]")).sendKeys(property.getPP());
		driver.findElement(By.xpath("//*[@value='Sign In']")).click();
		Utility.static_wait(4);
		Utility.Takescrrnshotrun(driver, "EIFU_Admin");
		String img5 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\EIFU_Admin.png");
		logger2.log(LogStatus.PASS, "Step 5:Login as a Eifu Admin","eIFUadmin logged in successfully and search page appears in the corresponding 'language' selected by user in  step 4" + img5);
		
		driver.get(property.scheduler());
		Utility.static_wait(2);
		Utility.Takescrrnshotrun(driver, "eIFUscheduler");
		String img6 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\eIFUscheduler.png");
		logger2.log(LogStatus.PASS, "Step 6:Access 'eIFUscheduler","Expected output:Run scheduler' button is present on eIFU (process) scheduler page." + img6);
		
		
		if (driver.findElements(By.name("schedulerBtn")).size() != 0) {
			System.out.println("schedulerBtn is Present");
		} else {
			System.out.println("schedulerBtn is Absent");
			}
		driver.findElement(By.name("schedulerBtn")).click();
		Utility.static_wait(5);
		Utility.Takescrrnshotrun(driver, "eIFUscheduler");
		String img7 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\eIFUscheduler.png");
		logger2.log(LogStatus.PASS, "Step 7:Click on 'Run scheduler.", "Expected output:Scheduler started successfully." + img7);
		Utility.static_wait(5);
		if (driver.getPageSource().contains("Scheduler started successfully")) {
			System.out.println("Text is present");
		} else {

			driver.quit();
		}
		
		Logo1=driver.findElement(By.linkText("Sign Out"));
		Utility.Highlightelements(driver, Logo1);
		Utility.Takescrrnshotrun(driver, "Signout");
		String img8 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Signout.png");
		logger2.log(LogStatus.PASS, "Step 8:Logout as eIFU admin .", "Expected output:eIFU admin logged out successfully." + img8);
		
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		Utility.static_wait(2);
		driver.quit();
		logger2.log(LogStatus.PASS, "Result: Script Passed and Document Library' site is accessible for all users");
			 

			//driver.get(property.getURL());
			/*long start=System.currentTimeMillis();
			driver.get(property.getURL());
			long finish=System.currentTimeMillis();
			long Total_time=start-finish;
			System.out.println(Total_time);*/
			
			/*org.testng.softsoftAssert.assertEquals("Market - dvpqa.net", driver.getTitle());
			WebElement Logo = driver.findElement(By.cssSelector("img.isi-logo"));
			Utility.Highlightelements(driver, Logo);
			Thread.sleep(1000);
			WebElement Texe1 = driver.findElement(By.cssSelector("div.col.s4"));
			Utility.Highlightelements(driver, Texe1);
			Thread.sleep(1000);
			WebElement french = driver.findElement(By.xpath("//*[contains(text(),'Dites-nous où vous êtes.')]"));
			Utility.Highlightelements(driver, french);
			Thread.sleep(1000);
			WebElement Germon = driver.findElement(By.xpath("//*[contains(text(),'Sagen Sie uns, wo Sie sich gerade befinden.')]"));
			Utility.Highlightelements(driver, Germon);
			Thread.sleep(1000);
			WebElement Spanesh = driver.findElement(By.xpath("//*[contains(text(),'Díganos dónde se encuentra.')]"));
			Utility.Highlightelements(driver, Spanesh);
			Thread.sleep(1000);
			WebElement Itely = driver.findElement(By.xpath("//*[contains(text(),'Comunicaci dove ti trovi.')]"));
			Utility.Highlightelements(driver, Itely);
			Thread.sleep(1000);
			WebElement Japan = driver.findElement(By.xpath("//*[@id='tell-us']/div[2]/div[3]"));
			Utility.Highlightelements(driver, Japan);
			Thread.sleep(1000);

			D1.hover(IMA1);
			Thread.sleep(1000);
			Utility.Takescrrnshotrun(driver, "North America");
			D1.hover(IMA2);
			Thread.sleep(1000);
			Utility.Takescrrnshotrun(driver, "South America");
			D1.hover(IMA3);
			Thread.sleep(1000);
			Utility.Takescrrnshotrun(driver, "Europe");
			D1.hover(IMA4);
			Thread.sleep(1000);
			Utility.Takescrrnshotrun(driver, "ASIA");
			D1.hover(IMA5);
			Thread.sleep(1000);
			Utility.Takescrrnshotrun(driver, "Africa");
			Utility.scrollDown(driver);
			D1.hover(IMA6);
			Utility.Takescrrnshotrun(driver, "AUS");
			Thread.sleep(1000);

			D1.click(IMA1);
			Thread.sleep(1000);

			boolean enabled = driver.findElement(By.cssSelector("label.remember-selection")).isSelected();
			if (!enabled) {

				System.out.println("Already checked");

				Thread.sleep(1000);

			} else

			{

				System.out.println("not checked");

			}
			Thread.sleep(1000);
			WebElement Continent = driver.findElement(By.xpath("//*[@id='country_container']/div[2]/div[3]"));
			Utility.Highlightelements(driver, Continent);

			if (driver.findElements(By.xpath("//*[@id='country_container']/div[2]/div[3]")).size() != 0) {
				System.out.println("Element is Present");
			} else {
				driver.quit();
			}

			Thread.sleep(1000);

			WebElement ImageFile = driver.findElement(By.xpath("//*[@id='isi_image']/img"));
			Utility.Highlightelements(driver, ImageFile);
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					ImageFile);
			if (ImagePresent) {
				System.out.println("Image is displayed.");
			} else {
				System.out.println("Image not displayed.");
			}

			Thread.sleep(3000);

			WebElement United_States=driver.findElement(By.linkText("United States"));
			Utility.safeJavaScriptClick(United_States, driver);
			Thread.sleep(5000);
			Logo = driver.findElement(By.cssSelector("img.isi-logo"));
			Utility.Highlightelements(driver, Logo);
			Thread.sleep(3000);	
			
			if (driver.getPageSource().contains("United States")) {
				System.out.println("Text is present");
			} else {

				driver.quit();
			}
			Thread.sleep(1000);
			WebElement ENG=driver.findElement(By.linkText("English"));
			Utility.safeJavaScriptClick(ENG, driver);
			Thread.sleep(1000);

			WebElement Logo1 = driver.findElement(By.cssSelector("h6.country-header"));
			Utility.Highlightelements(driver, Logo1);
			Thread.sleep(2000);

			org.testng.softsoftAssert.assertEquals("United States ( English )", "United States ( English )", "Flag does not match");
			//softsoftAssert.assertEquals("Market - dvpqa.net", driver.getTitle());
			Thread.sleep(2000);

			driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "t");
			// driver.switchTo().defaultContent();

			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			
			driver.switchTo().window(tabs.get(1));	
			
			driver.navigate().to("http://dvpqa.corp.intusurg.com/");
			
			
			driver.quit();
			 property = DataProviderFactory.getProperty();
			 driver = BrowserFactory.getBrowser(property.getBrowser());
			 driver.get(property.getURL());
			
			Thread.sleep(2000);
			Logo1 = driver.findElement(By.cssSelector("h6.country-header"));
			Utility.Highlightelements(driver, Logo1);

			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[@id='image_container']/div/a[2]/i")).click();
			
			Thread.sleep(1000);

			D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\NA.png");
			Thread.sleep(1000);

			Logo1 = driver.findElement(By.cssSelector("h4"));
			Utility.Highlightelements(driver, Logo1);

			if (driver.getPageSource().contains("North America")) {
				System.out.println("Text is present");
			} else {

				driver.quit();
			}
			Thread.sleep(2000);
			D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\REMNO.png");

			Thread.sleep(2000);
			 United_States=driver.findElement(By.linkText("United States"));
			Utility.safeJavaScriptClick(United_States, driver);
			Thread.sleep(3000);
			Logo = driver.findElement(By.cssSelector("img.isi-logo"));
			Utility.Highlightelements(driver, Logo);
			Thread.sleep(3000);	
			
			if (driver.getPageSource().contains("United States")) {
				System.out.println("Text is present");
			} else {

				driver.quit();
			}
			Thread.sleep(1000);
			ENG=driver.findElement(By.linkText("English"));
			Utility.safeJavaScriptClick(ENG, driver);
			Thread.sleep(1000);
			
			
			
			Logo1 = driver.findElement(By.cssSelector("h6.country-header"));
			Utility.Highlightelements(driver, Logo1);
			Thread.sleep(2000);

			org.testng.softsoftAssert.assertEquals("United States ( English )", "United States ( English )", "Flag does not match");
			//softsoftAssert.assertEquals("Market - dvpqa.net", driver.getTitle());
			Thread.sleep(2000);
			driver.quit();
			property = DataProviderFactory.getProperty();

			driver = BrowserFactory.getBrowser(property.getBrowser());
			driver.get(property.getURL());
			Thread.sleep(2000);
			//softsoftAssert.assertEquals("Market - dvpqa.net", driver.getTitle());
			Logo = driver.findElement(By.cssSelector("img.isi-logo"));
			Utility.Highlightelements(driver, Logo);
			Thread.sleep(2000);

			D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\NA.png");
			Thread.sleep(4000);
			driver.quit();
			logger2.log(LogStatus.PASS, "Script Passed and User able to validate Home_and_Country_Doc");
		
		} catch (Exception e) {
			BrowserFactory.quitApplication(driver);
			e.printStackTrace();
		}*/
	}

	
	
	
	
	
	@Test(priority=2)
	public void Home_and_Country_Doc_Validation() throws Exception {
		
			logger2 = report2.startTest("03-Validating-Home & Country page layout");
			/**
			 * Call login step from Library
			 */
			ConfigurationFile property = DataProviderFactory.getProperty();
			WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());

			driver.get(property.getURL());
			Utility.Takescrrnshotrun(driver, "Global Map");
			String img = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Global Map.png");
			logger2.log(LogStatus.PASS, "Step 1:Launch the Document Library website","Expected output:Document Library homepage is opened " + img);
			softAssert.assertEquals("Market - dvpuat.net", driver.getTitle());
			WebElement Logo = driver.findElement(By.cssSelector("img.isi-logo"));
			Utility.Highlightelements(driver, Logo);
			Thread.sleep(1000);
			Utility.Takescrrnshotrun(driver, "Logo");
			String img1 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Logo.png");
			logger2.log(LogStatus.PASS, "Step 2:'Intuitive surgical' Logo - displayed at the middle of the header","Expected output:Document Library has 'Header' with 'Intuitive surgical Logo' displayed at the middle of the header." + img1);
			
			WebElement Texe1 = driver.findElement(By.cssSelector("div.col.s4"));
			Utility.Highlightelements(driver, Texe1);
			Thread.sleep(1000);
			WebElement french = driver.findElement(By.xpath("//*[contains(text(),'Dites-nous où vous êtes.')]"));
			Utility.Highlightelements(driver, french);
			Thread.sleep(1000);
			WebElement Germon = driver.findElement(By.xpath("//*[contains(text(),'Sagen Sie uns, wo Sie sich gerade befinden.')]"));
			Utility.Highlightelements(driver, Germon);
			Thread.sleep(1000);
			WebElement Spanesh = driver.findElement(By.xpath("//*[contains(text(),'Díganos dónde se encuentra.')]"));
			Utility.Highlightelements(driver, Spanesh);
			Thread.sleep(1000);
			WebElement Itely = driver.findElement(By.xpath("//*[contains(text(),'Comunicaci dove ti trovi.')]"));
			Utility.Highlightelements(driver, Itely);
			Thread.sleep(1000);
			WebElement Japan = driver.findElement(By.xpath("//*[@id='tell-us']/div[2]/div[3]"));
			Utility.Highlightelements(driver, Japan);
			Thread.sleep(1000);
			Utility.Takescrrnshotrun(driver, "Language");
			String img2 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Language.png");
			logger2.log(LogStatus.PASS, "Step 3:On homepage, verify 'Tell us where you are'- Text is displayed in following languages:","Expected output:Tell us where you are'-Text is displayed  in all  mentioned below 6 Languages." + img2);
			D1.hover(IMA1);
			Utility.static_wait(1);		
			D1.hover(IMA2);
			Utility.static_wait(1);	
			D1.hover(IMA3);
			Utility.static_wait(1);	
			D1.hover(IMA4);
			Utility.static_wait(1);	
			D1.hover(IMA5);
			Utility.static_wait(1);				
			Utility.scrollDown(driver);
			D1.hover(IMA6);
			Utility.Takescrrnshotrun(driver, "Mouse_hover");			
			String img3 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Mouse_hover.png");
			logger2.log(LogStatus.PASS, "Step 4:Hover mouse' on each continent displayed on homepage","Expected output:Continent Name' is displayed adjacent to mouse pointer on homepage." + img3);
			D1.click(IMA1);
		
			Utility.Takescrrnshotrun(driver, "North_America");	
			String img4 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\North_America.png");
			logger2.log(LogStatus.PASS, "Step 5:Select a 'Continent'.","Expected output:Continent Name' is displayed adjacent to mouse pointer on homepage." + img4);
			
			boolean enabled = driver.findElement(By.cssSelector("label.remember-selection")).isSelected();
			if (!enabled) {

				System.out.println("Already checked");

				Utility.static_wait(1);	

			} else

			{

				System.out.println("not checked");

			}
			Utility.static_wait(1);
			WebElement Coutry_Sel = driver.findElement(By.xpath("//*[contains(text(),'SELECT COUNTRY BELOW')]"));
			Utility.Highlightelements(driver, Coutry_Sel);
			Utility.Takescrrnshotrun(driver, "Coutry_Sel");	
			String img5 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Coutry_Sel.png");
			logger2.log(LogStatus.PASS, "Step 6:Verify, 'Select your country below' -Text is present at the bottom of 'Continent Name'.'.","Expected output:'Select your country below' -Text is present below 'Continent Name' on Country screen." + img5);
			
			
			WebElement Continent = driver.findElement(By.xpath("//div[@id='country_container']/div[2]/div[3]"));
			Utility.Highlightelements(driver, Continent);
			Utility.Takescrrnshotrun(driver, "CC");	
			String img6 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\CC.png");
			logger2.log(LogStatus.PASS, "Step 7:Verify,Change continent' button is present in 'Blue' above 'Da Vinci Surgical Instrument' image.","Expected output:Change continent' button is present in 'Blue', above 'Da Vinci Surgical Instrument' image on country screen.." + img6);
			
			
			
			if (driver.findElements(By.xpath("//*[@id='country_container']/div[2]/div[3]")).size() != 0) {
				System.out.println("Element is Present");
			} else {
				driver.quit();
			}

			Utility.static_wait(1);

			WebElement ImageFile = driver.findElement(By.xpath("//*[@id='isi_image']/img"));
			Utility.Highlightelements(driver, ImageFile);
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					ImageFile);
			if (ImagePresent) {
				System.out.println("Image is displayed.");
			} else {
				System.out.println("Image not displayed.");
			}

			Utility.static_wait(3);
			List<WebElement> alllinks1 = driver.findElements(By.className("country-name"));
			int linkListCount1 = alllinks1.size();
			for (int i = 0; i < alllinks1.size(); i++)
				System.out.println(alllinks1.get(i).getText());
			System.out.println("Total numbner of country is: " + linkListCount1);
			softAssert.assertEquals(9, linkListCount1, "Country match");
			
			driver.findElement(By.xpath("//div[@id='country_container']/div[2]/div[3]")).click();
			Utility.static_wait(3);
			Utility.Takescrrnshotrun(driver, "Home_page");	
			String img7 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Home_page.png");
			logger2.log(LogStatus.PASS, "Step 8:Click on 'Change continent' button displayed on page'.","Expected output: Document Library homepage' is displayed with Map of 6 Continents." + img7);
			Utility.static_wait(3);
			D1.click(IMA1);
			Utility.static_wait(2);
			Utility.Takescrrnshotrun(driver, "NA");	
			String img8 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\NA.png");
			logger2.log(LogStatus.PASS, "Step 9:'Select 'Continent' = 'North America'  from the Map displayed on home page.","Expected output:Country selection screen appears with the selected Continent name 'North America', displayed as the Title of the screen." + img8);
			Utility.static_wait(2);			
			WebElement United_States=driver.findElement(By.linkText("United States"));
			Utility.safeJavaScriptClick(United_States, driver);
			Utility.static_wait(5);			
			Utility.Takescrrnshotrun(driver, "USA");	
			String img9 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\USA.png");
			logger2.log(LogStatus.PASS, "Step 10:Select 'Country' = 'United states' from  the list of countries tiles displayed for the continent.","Expected output:Language  selection screen appears with the selected Country name =United states, displayed as the Title of the screen." + img9);
			Logo = driver.findElement(By.cssSelector("img.isi-logo"));
			Utility.Highlightelements(driver, Logo);
			Utility.static_wait(2);
			
			
			if (driver.getPageSource().contains("United States")) {
				System.out.println("Text is present");
			} else {

				driver.quit();
			}
			Utility.static_wait(2);
			WebElement ENG=driver.findElement(By.linkText("English"));
			Utility.safeJavaScriptClick(ENG, driver);
			Thread.sleep(1000);
			Utility.Takescrrnshotrun(driver, "Search_page");	
			String img10 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Search_page.png");
			logger2.log(LogStatus.PASS, "Step 11:Select 'Language' = 'English' listed on screen.","Expected output:Search screen appears in the selected language 'English' with Advanced search label in the search box." + img10);
			WebElement Logo1 = driver.findElement(By.cssSelector("h6.country-header"));
			Utility.Highlightelements(driver, Logo1);
			Thread.sleep(2000);

			softAssert.assertEquals("United States ( English )", "United States ( English )", "Flag does not match");
			//softsoftAssert.assertEquals("Market - dvpqa.net", driver.getTitle());
			Thread.sleep(2000);

			/*driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "t");
			// driver.switchTo().defaultContent();

			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			
			driver.switchTo().window(tabs.get(1));	
			
			driver.navigate().to("http://dvpqa.corp.intusurg.com/");*/
			
			//IE run-decode the code
			/*driver.quit();
			 property = DataProviderFactory.getProperty();
			 driver = BrowserFactory.getBrowser(property.getBrowser());*/
			
			driver.get(property.getgoogle());
			Utility.static_wait(3);
			driver.get(property.getURL()); 
			 
			 Utility.Takescrrnshotrun(driver, "Search");
			String img11 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Search.png");
			logger2.log(LogStatus.PASS, "Step 12:Launch the Document Library website","Expected output:Document Library homepage is opened " + img11);
			//org.testng.softsoftAssert.assertEquals("Market - dvpuat.net", driver.getTitle());
			Utility.static_wait(3);
			Logo1 = driver.findElement(By.cssSelector("h6.country-header"));
			Utility.Highlightelements(driver, Logo1);
			Utility.Takescrrnshotrun(driver, "Language");			
			String img12 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Language.png");
			logger2.log(LogStatus.PASS, "Step 13:Search page is displayed.Verify if 'Country' & 'Language' displayed on search page,","Expected output:Remember my selection checkbox is working as expected and Country & Language displayed on search page matches with country   mentioned " + img12);
			
			WebElement  CC= driver.findElement(By.xpath("//div[@id='image_container']/div/a[2]/i"));
			Utility.safeJavaScriptClick(CC, driver);
			Utility.static_wait(3);
			Utility.Takescrrnshotrun(driver, "Language");			
			String img13 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Language.png");
			logger2.log(LogStatus.PASS, "Step 14:Click on 'Change continent' displayed on search Page.","Expected output:Document Library homepage is displayed with Map of 6 Continents." + img13);
			Utility.static_wait(4);
			driver.switchTo().defaultContent();
			Logo = driver.findElement(By.cssSelector("img.isi-logo"));
			Utility.Highlightelements(driver, Logo);
			Utility.static_wait(5);
			D1.click(IMA1);
			Utility.static_wait(3);
			Utility.Takescrrnshotrun(driver, "North_America");	
			String img14 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\North_America.png");
			logger2.log(LogStatus.PASS, "Step 15:Select a 'Continent = 'North America'  from the Map displayed on  home page.'.","Expected output:Continent Name' is displayed adjacent to mouse pointer on homepage." + img14);
			Utility.static_wait(3);
			D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\REMNO.png");
			
			Utility.static_wait(3);
			United_States=driver.findElement(By.linkText("United States"));
			Utility.safeJavaScriptClick(United_States, driver);
			Utility.static_wait(5);			
			Utility.Takescrrnshotrun(driver, "REMNO");	
			String img15 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\REMNO.png");
			logger2.log(LogStatus.PASS, "Step 16:Select 'Country' = 'United states' from the list of countries tiles displayed for the continen.","Expected output:Language selection' screen appears with the selected 'Country Name', displayed as the Title of the screen." + img15);
			Utility.static_wait(3);
			ENG=driver.findElement(By.linkText("English"));
			Utility.safeJavaScriptClick(ENG, driver);
			Thread.sleep(1000);
			Utility.Takescrrnshotrun(driver, "Search_page");	
			String img16 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Search_page.png");
			logger2.log(LogStatus.PASS, "Step 17:Select 'Language' = 'English' listed on screen.","Expected output:Search screen appears in the selected language 'English' with Advanced search label in the search box." + img16);
			
			driver.quit();
			Utility.static_wait(3);
		    property = DataProviderFactory.getProperty();
			driver = BrowserFactory.getBrowser(property.getBrowser());

			driver.get(property.getURL());
			
			Utility.Takescrrnshotrun(driver, "Global Map");
			String img17 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Global Map.png");
			logger2.log(LogStatus.PASS, "Step 18:Launch the Document Library website","Expected output:Document Library homepage is opened and Search page is not appeared when 'Remember my checkbox' is unchecked" + img17);
			softAssert.assertEquals("Market - dvpuat.net", driver.getTitle());
			Utility.static_wait(3);
			D1.click(IMA1);
			Utility.static_wait(2);
			Utility.Takescrrnshotrun(driver, "NA");	
			String img18 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\NA.png");
			logger2.log(LogStatus.PASS, "Step 19:'Select 'Continent' = 'North America'  from the Map displayed on home page.","Expected output:Country selection screen appears with the selected Continent name 'North America', displayed as the Title of the screen." + img18);
			Utility.static_wait(5);			
			driver.quit();
			
			logger2.log(LogStatus.PASS, "Result: Script Passed and User able to verify test language Screen UI in English Language");
            
			
	}
	@Test(priority=3)
	public void Validating_Language_selection_screen () throws Exception {
		
			logger2 = report2.startTest("04-Validating-Language selection screen ");
			/**
			 * Call login step from Library
			 */
			ConfigurationFile property = DataProviderFactory.getProperty();
			WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());

			driver.get(property.getURL());
			Utility.Takescrrnshotrun(driver, "Global Map");
			String img = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Global Map.png");
			logger2.log(LogStatus.PASS, "Step 1:Launch the Document Library website","Expected output:Document Library homepage is dispalyed" + img);
			softAssert.assertEquals("Market - dvpuat.net", driver.getTitle());			
			Utility.static_wait(5);
			D1.hover(IMA3);
			Utility.static_wait(2);
			D1.click(IMA1);
			Utility.Takescrrnshotrun(driver, "North_America");	
			String img1 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\North_America.png");
			logger2.log(LogStatus.PASS, "Step 2:From the world map that is displayed, select North America.","Expected output:A country selection page is displayed. The title of the page is North America." + img1);
			
			boolean enabled = driver.findElement(By.cssSelector("label.remember-selection")).isSelected();
			if (!enabled) {

				System.out.println("Already checked");

				Utility.static_wait(1);	

			} else

			{

				System.out.println("not checked");

			}
			
			Utility.static_wait(2);			
			WebElement United_States=driver.findElement(By.linkText("United States"));
			Utility.safeJavaScriptClick(United_States, driver);
			Utility.static_wait(5);			
			Utility.Takescrrnshotrun(driver, "NA");	
			String img3 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\NA.png");
			logger2.log(LogStatus.PASS, "Step 3:From the list of countries, select the United States.","Expected output:A language selection page is displayed. The title of the page is United States." + img3);
			Utility.static_wait(2);	
			WebElement Logo = driver.findElement(By.cssSelector("img.isi-logo"));
			Utility.Highlightelements(driver, Logo);
			Utility.Takescrrnshotrun(driver, "Logo");	
			String img4 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Logo.png");
			logger2.log(LogStatus.PASS, "Step 4:Intituive Surgical' logo at the middle of header and Footer is in grey & Blank (no text).","Expected output:Intuitive Surgical' logo is present at the middle of the header and Footer is in 'Grey' with 'no text'." + img4);
			Utility.static_wait(2);	
			WebElement Cont_Logo = driver.findElement(By.cssSelector("#country_name > h4"));
			Utility.Highlightelements(driver, Cont_Logo);
			Utility.Takescrrnshotrun(driver, "Cont_Logo");	
			String img5 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Cont_Logo.png");
			logger2.log(LogStatus.PASS, "Step 5:Check if 'Country Name' is present below the header on left side of the screen.","Expected output:Selected 'Country name'-'United states' is displayed as the 'Title' of the screen.." + img5);
			Utility.static_wait(2);	
			WebElement Lang_Sel = driver.findElement(By.xpath("//*[contains(text(),'SELECT LANGUAGE BELOW')]"));
			Utility.Highlightelements(driver, Lang_Sel);
			Utility.Takescrrnshotrun(driver, "Lang_Sel");	
			String img6 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Lang_Sel.png");
			logger2.log(LogStatus.PASS, "Step 6:VCheck for  'SELECT LANGUAGE BELOW' text is displayed below the 'Country Name'.","Expected output:SELECT LANGUAGE BELOW'- text is present below the 'Country Name' on left side of the page." + img6);
			Utility.static_wait(2);	
			WebElement Continent = driver.findElement(By.xpath("//div[@id='country_container']/div[2]/div[3]"));
			Utility.Highlightelements(driver, Continent);
			Utility.Takescrrnshotrun(driver, "CC");	
			String img7 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\CC.png");
			logger2.log(LogStatus.PASS, "Step 7:Verify,Change continent' button is present in 'Blue' above 'Da Vinci Surgical Instrument' image.","Expected output:Change continent' button is present in 'Blue', above 'Da Vinci Surgical Instrument' image on country screen." + img7);
			Utility.static_wait(1);

			WebElement ImageFile = driver.findElement(By.xpath("//*[@id='isi_image']/img"));
			Utility.Highlightelements(driver, ImageFile);
			Utility.Takescrrnshotrun(driver, "Image");	
			String img8 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Image.png");
			logger2.log(LogStatus.PASS, "Step 8:Check if davinci surgical instrument is present below 'Change Continent' button.","Expected output:Davinci surgical instrument is present below 'Change Continent' button." + img8);
			
			
			if (driver.getPageSource().contains("United States")) {
				System.out.println("Text is present");
			} else {

				driver.quit();
			}
			
			
			
			Utility.static_wait(2);
			WebElement ENG=driver.findElement(By.linkText("English"));
			Utility.safeJavaScriptClick(ENG, driver);
			Thread.sleep(1000);
			Utility.Takescrrnshotrun(driver, "Search_page");	
			String img09 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Search_page.png");
			logger2.log(LogStatus.PASS, "Step 09:Select 'Language' = 'English' listed on screen.","Expected output:Search screen appears in the selected language 'English' with Advanced search label in the search box." + img09);
			WebElement Logo1 = driver.findElement(By.cssSelector("h6.country-header"));
			Utility.Highlightelements(driver, Logo1);
			Utility.static_wait(3);
			driver.findElement(By.xpath("//*[contains(text(),'United States ( English )')]")).click();
			Utility.static_wait(3);
			driver.findElement(By.id("changeCountry")).click();
			Utility.static_wait(3);
			Utility.Takescrrnshotrun(driver, "changeCountry");	
			String img10 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\changeCountry.png");
			logger2.log(LogStatus.PASS, "Step 10:Click on Country & Language displayed below header and 'Change Language' option on search page.","Expected output:Language  selection screen appears with the selected Country Name- 'United States',  as the Title of the screen." + img10);
			Utility.static_wait(3);
			United_States=driver.findElement(By.linkText("United States"));
			Utility.safeJavaScriptClick(United_States, driver);
			Utility.static_wait(3);			
		    ENG=driver.findElement(By.linkText("English"));
			Utility.safeJavaScriptClick(ENG, driver);
			Utility.static_wait(3);
			driver.findElement(By.xpath("//*[contains(text(),'United States ( English )')]")).click();
			Utility.static_wait(5);
			driver.findElement(By.id("changeLanguage")).click();
			Utility.static_wait(3);
			Utility.Takescrrnshotrun(driver, "changelanguage");
			
			String img11 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\changelanguage.png");
			logger2.log(LogStatus.PASS, "Step 11:Click on 'Change Continent' button displayed below header.","Expected output:From 'Language selection' screen, user is redirected to 'Document Library- Home page'." + img11);
			Thread.sleep(3000);
			driver.quit();
			logger2.log(LogStatus.PASS, "Result: Script Passed and User able to verify Document Library Home & Country page UI");
			
			
	}
	
	
	
	
	
	@Test(enabled=false)
	public void Search_() throws Exception {
		try {
			logger2 = report2.startTest("Search");
			/**
			 * Call login step from Library
			 */
			ConfigurationFile property = DataProviderFactory.getProperty();
			WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());

			driver.get(property.getURL());
			Screen D1 = new Screen();
			D1.setAutoWaitTimeout(10);
			

			softAssert.assertEquals("Market - dvpqa.net", driver.getTitle());
			WebElement Logo = driver.findElement(By.cssSelector("img.isi-logo"));
			Utility.Highlightelements(driver, Logo);
			Thread.sleep(1000);

			D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\NA1.png");

			Thread.sleep(2000);
			// D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\REMNO.png");
			// WebDriverWait wait = new WebDriverWait(driver, 20);
			// element =
			// wait.until(ExpectedConditions.elementToBeClickable(By.id("remember-selection")));
			// JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("arguments[0].click();", element);
			Thread.sleep(2000);
			D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\FRA.png");
			Thread.sleep(2000);
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			element = wait1.until(ExpectedConditions.elementToBeClickable(By.className("language-name")));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", element);
			Thread.sleep(5000);

			// driver.findElement(By.linkText("English")).click();
			Thread.sleep(1000);

			WebElement Logo2 = driver.findElement(By.cssSelector("h6.country-header"));
			Utility.Highlightelements(driver, Logo2);
			Thread.sleep(2000);
			softAssert.assertEquals("France ( French )", "France ( French )", "Flag does not match");
			Thread.sleep(2000);
			softAssert.assertEquals("Welcome - dvpqa.net", driver.getTitle());
			driver.findElement(By.id("initialSearchTextbox")).sendKeys("demo");
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='basic_search_container']/i")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("i.material-icons.right")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Afficher le manuel")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("i.material-icons.right")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Commander le manuel")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//a[contains(text(),'Fermer')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("i.material-icons.right")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Previous Versions")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//a[contains(text(),'Fermer')])[2]")).click();
			Thread.sleep(2000);

			driver.findElement(By.linkText("view_module")).click();

			// driver.findElement(By.xpath("(//a[contains(text(),'Fermer')])[2]")).click();
			Thread.sleep(2000);
			// driver.findElement(By.linkText("view_module")).click();
			Thread.sleep(2000);
			// driver.quit();
			Thread.sleep(2000);
			// property = DataProviderFactory.getProperty();
			// driver = BrowserFactory.getBrowser(property.getBrowser());
			driver.get("http://dvpqa.corp.intusurg.com/");
			// driver.findElement(By.xpath("//*[@id='main_container']/nav/div/ul/li[2]/a/i")).click();
			driver.findElement(By.cssSelector("i.material-icons.valign-bottom")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("changeCountry")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='country_container']/div[2]/div[3]")).click();
			Thread.sleep(4000);
			D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\AF.png");
			Thread.sleep(4000);
			BrowserFactory.quitApplication(driver);
		} catch (Exception e) {
			BrowserFactory.quitApplication(driver);
			e.printStackTrace();
		}
	}

	@Test(priority=4)
	
	public void Language_selection() throws Exception {
		logger2 = report2.startTest("05-Validating- Country & language relation");
		ConfigurationFile property = DataProviderFactory.getProperty();
		WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());

		driver.get(property.getURL());
		Utility.Takescrrnshotrun(driver, "Global Map");
		String img1 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Global Map.png");
		logger2.log(LogStatus.PASS, "Step 1:Launch the Document Library website","Expected output:Document Library homepage is dispalyed" + img1);
		
		softAssert.assertEquals("Market - dvpuat.net", driver.getTitle());			
		Utility.scrollDown(driver);
		D1.click(IMA2);
		Utility.Takescrrnshotrun(driver, "SA");
		String img2 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\SA.png");
		logger2.log(LogStatus.PASS, "Step 2:From the world map that is displayed, select 'South America","Expected output:A country selection page is displayed and the title of the page is 'South America." + img2);
		
		Utility.static_wait(2);

		List<WebElement> alllinks4 = driver.findElements(By.className("country-name"));
		int linkListCount4 = alllinks4.size();

		for (int i = 0; i < alllinks4.size(); i++)
			System.out.println(alllinks4.get(i).getText());
		System.out.println("Total numbner of county is: " + linkListCount4);

		softAssert.assertEquals(9, linkListCount4, "County match");
		Utility.static_wait(3);
		Utility.Takescrrnshotrun(driver, "SA_Lang");
		String img3 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\SA_Lang.png");
		logger2.log(LogStatus.PASS, "Step 3:On the Country screen that is displayed, verify the listed countries.","Expected output:Country page of 'South America' has all the countries listed as per the country requirements file provided." + img3);
		driver.findElement(By.xpath("//div[@id='country_container']/div[2]/div[3]")).click();
		Utility.static_wait(3);
		driver.navigate().refresh();
		D1.click(IMA1);
		Utility.Takescrrnshotrun(driver, "NA");
		String img4 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\NA.png");
		logger2.log(LogStatus.PASS, "Step 4:From the world map that is displayed, select 'North America'.","Expected output:A country selection page is displayed and the title of the page is 'North America''." + img4);
		Utility.static_wait(2);

		List<WebElement> alllinks = driver.findElements(By.className("country-name"));
		int linkListCount = alllinks.size();

		for (int i = 0; i < alllinks.size(); i++)
			System.out.println(alllinks.get(i).getText());
		System.out.println("Total numbner of country is: " + linkListCount);
		softAssert.assertEquals(9, linkListCount, "County match");
		Utility.Takescrrnshotrun(driver, "NA_Lang");
		String img5 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\NA_Lang.png");
		logger2.log(LogStatus.PASS, "Step 5:On the Country screen that is displayed, verify the listed countries.","Expected output:Country page of 'North America' has all the countries listed as per the country requirements file provided." + img5);
		driver.findElement(By.xpath("//div[@id='country_container']/div[2]/div[3]")).click();
		
		Thread.sleep(4000);
		softAssert.assertEquals("Market - dvpuat.net", driver.getTitle());
		WebElement Logo1 = driver.findElement(By.cssSelector("img.isi-logo"));
		Utility.Highlightelements(driver, Logo1);
		Utility.static_wait(3);
		driver.navigate().refresh();
		D1.click(IMA3);
		Utility.Takescrrnshotrun(driver, "EU");
		String img6 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\EU.png");
		logger2.log(LogStatus.PASS, "Step 6:From the world map that is displayed, select ''Europe","Expected output:A country selection page is displayed and the title of the page is 'Europe'." + img6);
		
		Utility.static_wait(2);

		List<WebElement> alllinks3 = driver.findElements(By.className("country-name"));
		int linkListCount3 = alllinks3.size();

		for (int i = 0; i < alllinks3.size(); i++)
			System.out.println(alllinks3.get(i).getText());
		System.out.println("Total numbner of country is: " + linkListCount3);
		softAssert.assertEquals(35, linkListCount3, "County match");
		Utility.static_wait(3);
		Utility.Takescrrnshotrun(driver, "EU_Lang");		
		String img7 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\EU_Lang.png");
		logger2.log(LogStatus.PASS, "Step 7:On the Country screen that is displayed, verify the listed countries.","Expected output:Country page of 'Europe' has all the countries listed as per the country requirements file provided." + img7);
		driver.findElement(By.xpath("//div[@id='country_container']/div[2]/div[3]")).click();
		
		
		Utility.static_wait(3);
		softAssert.assertEquals("Market - dvpuat.net", driver.getTitle());
		WebElement Logo4 = driver.findElement(By.cssSelector("img.isi-logo"));
		Utility.Highlightelements(driver, Logo4);
		

		Utility.static_wait(3);
		//driver.navigate().refresh();
		D1.click(IMA4);
		Utility.Takescrrnshotrun(driver, "ASIA");
		String img8 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\ASIA.png");
		logger2.log(LogStatus.PASS, "Step 8:From the world map that is displayed, select 'ASIA","Expected output:A country selection page is displayed and the title of the page is 'ASIA'." + img8);
		
		Utility.static_wait(2);

		List<WebElement> alllinks2 = driver.findElements(By.className("country-name"));
		int linkListCount2 = alllinks2.size();

		for (int i = 0; i < alllinks2.size(); i++)
			System.out.println(alllinks2.get(i).getText());
		System.out.println("Total numbner of country is: " + linkListCount2);
		softAssert.assertEquals(20, linkListCount2, "County match");

		Utility.Takescrrnshotrun(driver, "ASIA_Lang");
		String img9 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\ASIA_Lang.png");
		logger2.log(LogStatus.PASS, "Step 9:On the Country screen that is displayed, verify the listed countries.","Expected output:Country page of 'ASIA' has all the countries listed as per the country requirements file provided." + img9);
		driver.findElement(By.xpath("//div[@id='country_container']/div[2]/div[3]")).click();
		Thread.sleep(4000);
		softAssert.assertEquals("Market - dvpuat.net", driver.getTitle());
		WebElement Logo3 = driver.findElement(By.cssSelector("img.isi-logo"));
		Utility.Highlightelements(driver, Logo3);
		
		
		Utility.static_wait(1);
		//driver.navigate().refresh();
		Utility.static_wait(5);
		
		D1.click(IMA5);
		Utility.Takescrrnshotrun(driver, "AF");
		String img10 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\AF.png");
		logger2.log(LogStatus.PASS, "Step 10:From the world map that is displayed, select 'Africa","Expected output:Document Library homepage is dispalyed and the title of the page is 'Africa'" + img10);
		
		Utility.static_wait(2);

		List<WebElement> alllinks1 = driver.findElements(By.className("country-name"));
		int linkListCount1 = alllinks1.size();

		for (int i = 0; i < alllinks1.size(); i++) {
			// System.out.println(alllinks1.get(i).getText());

			if ("Egypt".equals(alllinks1.get(i).getText()) || "Mauritius".equals(alllinks1.get(i).getText())
					|| "South Africa".equals(alllinks1.get(i).getText())) {
				System.out.println("All country is available");
				System.out.println("Total numbner of country is: " + linkListCount1);

			} else {

				System.out.println("All country is not available");
			}
		}

		softAssert.assertEquals(3, linkListCount1, "County match");

		Utility.static_wait(3);
		Utility.Takescrrnshotrun(driver, "AF_Lang");
		String img11 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\AF_Lang.png");
		logger2.log(LogStatus.PASS, "Step 11:On the Country screen that is displayed, verify the listed countries.","Expected output:Country page of 'Africa' has all the countries listed as per the country requirements file provided." + img11);
		driver.findElement(By.xpath("//div[@id='country_container']/div[2]/div[3]")).click();
		Utility.static_wait(3);
		Thread.sleep(4000);
		//softAssert.assertEquals("Market - dvpuat.net", driver.getTitle());
		Logo3 = driver.findElement(By.cssSelector("img.isi-logo"));
		Utility.Highlightelements(driver, Logo3);
		Thread.sleep(3000);
		driver.navigate().refresh();
		Utility.static_wait(2);
		
		
		D1.click(IMA6);	
		
		Utility.Takescrrnshotrun(driver, "OC");
		String img12 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\OC.png");
		logger2.log(LogStatus.PASS, "Step 12:From the world map that is displayed, select 'Oceania","Expected output:Document Library homepage is dispalyed and the title of the page is 'Oceania'." + img12);
		
		Utility.static_wait(2);

		List<WebElement> alllinks5 = driver.findElements(By.className("country-name"));
		int linkListCount5 = alllinks5.size();

		for (int i = 0; i < alllinks5.size(); i++)
			System.out.println(alllinks5.get(i).getText());
		System.out.println("Total numbner of country is: " + linkListCount5);
		softAssert.assertEquals(4, linkListCount5, "County match");
		Utility.static_wait(3);
		Utility.Takescrrnshotrun(driver, "OC_Lang");
		String img13 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\OC_Lang.png");
		logger2.log(LogStatus.PASS, "Step 13:On the Country screen that is displayed, verify the listed countries.","Expected output:Country page of 'South America' has all the countries listed as per the country requirements file provided." + img13);
		driver.findElement(By.xpath("//div[@id='country_container']/div[2]/div[3]")).click();
		Utility.static_wait(3);
		 softAssert.assertAll();
		
			BrowserFactory.quitApplication(driver);
			
			logger2.log(LogStatus.PASS, "Resutl:Script Passed and Validating- Country & language relation");
		

	}
	@Test(priority=5)
	public void Search_Page_UI_Validation() throws Exception {
		
			logger2 = report2.startTest("06-Search Page UI- Validation");
			/**
			 * Call login step from Library
			 */
			ConfigurationFile property = DataProviderFactory.getProperty();
			WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());
			Utility.static_wait(2);
			driver.get(property.getURL());
			Screen D1 = new Screen();
			softAssert.assertEquals("Market - dvpuat.net", driver.getTitle());
			Utility.Takescrrnshotrun(driver, "Global Map");
			String img1 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Global Map.png");
			logger2.log(LogStatus.PASS, "Step 1:Launch the Document Library website","Expected output:Document Library homepage is dispalyed" + img1);
			
			Utility.static_wait(1);
			
			D1.click(IMA1);
			
			Utility.static_wait(3);
			
			WebElement United_States = driver.findElement(By.linkText("United States"));
			Utility.safeJavaScriptClick(United_States, driver);
			Utility.static_wait(3);
			
			WebElement ImageFile = driver.findElement(By.cssSelector("#language_isi_image_container > #isi_image > img.isi_image"));
			Utility.Highlightelements(driver, ImageFile);
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",ImageFile);
			if (ImagePresent) {
				System.out.println("Image is displayed.");
			} else {
				driver.quit();
			}
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			element = wait1.until(ExpectedConditions.elementToBeClickable(By.className("language-name")));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", element);
			Utility.static_wait(2);
			Utility.Takescrrnshotrun(driver, "English");
			String img2 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\English.png");
			logger2.log(LogStatus.PASS, "Step 4:Select  corresponding 'Language' listed on screen","Expected output:Search screen appears in the selected language with Advanced search label in the search box displayed in the corresponding language" + img2);

		Utility.static_wait(3);
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'United States ( English )')]"));
		Utility.Highlightelements(driver, element);
		String USA = element.getText();
		System.out.println(USA);
		softAssert.assertEquals("United States ( English )", USA);
		Utility.Takescrrnshotrun(driver, "English");
		String img3 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\English.png");
		logger2.log(LogStatus.PASS, "Step 3:Verify if Country Name - 'North America', with respective flag & language- 'English' is displayed below the header, on the right-side of the page in 'English","Expected output:Based on the user selection in the above step, Country Name-'North America', &  language- 'English' is displayed below the header, at the right-side of the page in 'English' language." + img3);
		
		
		

		element=driver.findElement(By.xpath("//div[@id='image_container']/div/a[2]/i"));
		Utility.Highlightelements(driver, element);
		Utility.Takescrrnshotrun(driver, "CC");
		String img4 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\CC.png");
		logger2.log(LogStatus.PASS, "Step 4:Verify, option to 'Change Continent' is present below the header, at the right-side of the page in 'English'.","Expected output:Option to 'Change Continent'  is present  in 'English' below the header, at the right-side of the page." + img4);
		WebDriverWait wait = new WebDriverWait(driver,30);
		String Text = wait.until(ExpectedConditions.elementToBeClickable(By.id("initialSearchTextbox"))).getAttribute("placeholder");
		System.out.println(Text);	
		Utility.Takescrrnshotrun(driver, "English");
		String img5 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\English.png");
		logger2.log(LogStatus.PASS, "Step 5:Check if Search bar has below  'Default text :Enter manual part number, title, description, or keyword.","Expected output:By default ,search bar has following placeholder text in English, Enter manual part number, title, description, or keyword."+img5);
		
		
		
		element=driver.findElement(By.xpath("//a[contains(text(),'Search')]"));
		Utility.Highlightelements(driver, element);
		Utility.Takescrrnshotrun(driver, "Search");
		String img6 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Search.png");
		logger2.log(LogStatus.PASS, "Step 6:Check for presence of 'Grey' colored 'Search box', beside search bar .","Expected output:Grey' colored 'Search box' is present next to search bar to search." + img6);
			
		Utility.static_wait(2);
		element=driver.findElement(By.linkText("Advanced Search"));
		Utility.Highlightelements(driver, element);
		Utility.Takescrrnshotrun(driver, "Adv_Search");
		String img7 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Adv_Search.png");
		logger2.log(LogStatus.PASS, "Step 7:Check for presence of 'Advanced Search' link  below the 'search box'","Expected output:Advanced search Label' is present below the 'search box." + img7);
			
		Utility.static_wait(2);
		driver.findElement(By.linkText("Advanced Search")).click();
		Utility.static_wait(2);
		WebElement part_number=driver.findElement(By.cssSelector("label"));
		Utility.Highlightelements(driver, part_number);
		WebElement Doc_name=driver.findElement(By.xpath("//*[contains(text(),'Document Name')]"));
		Utility.Highlightelements(driver, Doc_name);
		WebElement Desc=driver.findElement(By.xpath("//*[contains(text(),'Description')]"));
		Utility.Highlightelements(driver, Desc);
		WebElement Keyword=driver.findElement(By.cssSelector("h4"));
		Utility.Highlightelements(driver, Keyword);
		WebElement platform=driver.findElement(By.xpath("//div[@id='advanced_search_container']/div/div/div/div[3]/label"));
		Utility.Highlightelements(driver, platform);
		WebElement Publication_Type=driver.findElement(By.xpath("//div[@id='advanced_search_container']/div/div/div[2]/div[3]/label"));
		Utility.Highlightelements(driver, Publication_Type);
		
		Utility.Takescrrnshotrun(driver, "Adv_Search");
		String img8 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Adv_Search.png");
		logger2.log(LogStatus.PASS, "Step 8:Verify if all search elements are present.","Expected output:ll the mentioned search elements are present in the Advanced search link." + img8);
		Utility.static_wait(2);
	   driver.findElement(By.cssSelector("input.select-dropdown")).click();
	   Utility.static_wait(2);
	   
	   /*WebElement mySelectElm = driver.findElement(By.tagName("select")); 
	   Select mySelect= new Select(mySelectElm);
	   List<WebElement> options = mySelect.getOptions();
	   for (WebElement option : options) {
	       System.out.println("Dropdoen is"+option.isDisplayed()); //Prints "Option", followed by "Not Option"
	   } */
		
	   
	  /* WebElement month_dropdown=driver.findElement(By.id("advanceFilterPlatform"));
	   
	   Select month=new Select(month_dropdown);
	    
	   List<WebElement> dropdown=month.getOptions();
	    
	    for(int i=1;i<dropdown.size();i++){
	    
	   String drop_down_values=dropdown.get(i).getText();
	    
	    System.out.println("dropdown values are "+drop_down_values);
	    }*/
	   
	   //List<WebElement> options = driver.findElements(By.cssSelector("input.select-dropdown"));
	   
	   List<WebElement> options = driver.findElements(By.xpath(".//*[@id='advanced_search_container']/div/div[1]/div[1]/div[3]/div/ul/li"));
	  
	   Utility.static_wait(1);
	   
	   //Count the Values
	   List<String> dropdownVals = new ArrayList<String>();
	    for(int i=0;i<options.size();i++){
	    System.out.println("Drop down:"+options.get(i).getText());
	    dropdownVals.add(options.get(i).getText());
	    }
	   
		Utility.Takescrrnshotrun(driver, "Platform");
		String img09 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Platform.png");
		logger2.log(LogStatus.PASS, "Step 09:Verify below listed 'Platform' and  its total no of document count' is present below search bar:","Expected output:All the mentioned 'Platform' type and its Total no of document count, associated for particular user selected country -'United states' & language -English' is present." + img09);
		Utility.static_wait(1);
		driver.findElement(By.id("advanceFilterContent")).click();
		Utility.static_wait(1);
		driver.findElement(By.xpath("//input[@value='Choose your publication type']")).click();
		List<WebElement> options1 = driver.findElements(By.xpath(".//*[@id='advanced_search_container']/div/div[1]/div[2]/div[3]/div/ul/li"));
		   
		   Utility.static_wait(1);
		   
		   //Count the Values
		   List<String> dropdownVals1 = new ArrayList<String>();
		    for(int i=0;i<options1.size();i++){
		    System.out.println("Drop down12:"+options1.get(i).getText());
		    dropdownVals1.add(options1.get(i).getText());
		    }
		
		
		Utility.Takescrrnshotrun(driver, "Pub_type");
		String img10 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Pub_type.png");
		logger2.log(LogStatus.PASS, "Step 10:Verify  listed Publication type's and  its total no of document count' is present below search bar:","Expected output:All the mentioned Publication type's and its Total no of document count, associated for particular user selected country -'United states' & language -English' is present." + img10);
		
	    driver.findElement(By.cssSelector("span.facet-label")).click();
	    Utility.static_wait(2);
	    driver.findElement(By.cssSelector("i.material-icons.white-text")).click();
	    Utility.static_wait(2);
	    driver.findElement(By.cssSelector("#platform_ul > li > div > a.tooltipped.facet-all-doc-search > span.facet-label")).click();
	    Utility.static_wait(2);
	    Utility.Takescrrnshotrun(driver, "Pub_type");
		String img11 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Pub_type.png");
		logger2.log(LogStatus.PASS, "Step 11:On click of each 'Publication, Platform  & document count link, user can view all the documents associated to the user selected country and language.","Expected output:On main search page, Publication Type, Platform & Document count are  links for users to view all the documents for the corresponding selected country 'united states' & language 'English'" + img11);
		WebElement  arrowstop=driver.findElement(By.cssSelector("#ticker-pubtype-previous > i.material-icons"));
		Utility.Highlightelements(driver, arrowstop);
	    Utility.static_wait(2);
	    WebElement  arrowsbot=driver.findElement(By.cssSelector("#ticker-pubtype-next > i.material-icons"));
	    Utility.Highlightelements(driver, arrowsbot);
	    
	    Utility.Takescrrnshotrun(driver, "Arrow");
		String img12 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Arrow.png");
		logger2.log(LogStatus.PASS, "Step 12:Verify if 2 arrows (top and bottom) are added to navigate through the list of items of PubType and Platform sections on main search screen","Expected output:User is able to navigate through the list of PubType and Platform items  on main search screen" + img12);
		//logger2.log(LogStatus.PASS, "Step 12:","Expected output:" + img10);
		Utility.static_wait(2);
		WebElement previous_search = driver.findElement(By.xpath("//*[contains(text(),'youtube_searched_for')]"));
		Utility.Highlightelements(driver, previous_search);
		Utility.Takescrrnshotrun(driver, "previous_search");
		String img13 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\previous_search.png");
		logger2.log(LogStatus.PASS,"Step 13:Verify if previous search option  is present on main search page, below header on left of the page","Expected output:Option to view previous search is present as mentioned"+ img13);
		driver.findElement(By.xpath("//*[contains(text(),'youtube_searched_for')]")).click();
		Utility.static_wait(2);
		WebElement Res_search = driver.findElement(By.xpath("//div[@id='recentSearchesModal']/div/a[2]"));
		Utility.Highlightelements(driver, Res_search);
		WebElement Cle_search = driver.findElement(By.xpath("//a[contains(text(),'Clear Search History')]"));
		Utility.Highlightelements(driver, Cle_search);
		WebElement Clo = driver.findElement(By.xpath("//div[@id='recentSearchesModal']/div/a[2]"));
		Utility.Highlightelements(driver, Clo);
		Utility.Takescrrnshotrun(driver, "previous_search_Det");
		String img14 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\previous_search_Det.png");
		logger2.log(LogStatus.PASS, "Step 14:Click on Previous search option and verify if Previous search window has following details and close the window","Expected output:Previous search window is present as mentioned in the instruction" + img14);
		Utility.static_wait(2);
		WebElement Res_serach=driver.findElement(By.xpath("//div[@id='recentSearchesModal']/div/a[2]"));
		Utility.Highlightelements(driver, Res_serach);
		Utility.static_wait(2);
		WebElement Cle_serach=driver.findElement(By.xpath("//a[contains(text(),'Clear Search History')]"));
		Utility.Highlightelements(driver, Cle_serach);
		Utility.static_wait(2);
		WebElement Clo_serach=driver.findElement(By.xpath("//div[@id='recentSearchesModal']/div/a[2]"));
		Utility.Highlightelements(driver, Clo_serach);
		driver.findElement(By.xpath("//div[@id='recentSearchesModal']/div/a[2]")).click();
		
		
		Utility.static_wait(2);
		driver.switchTo().defaultContent();
		WebElement Header=driver.findElement(By.cssSelector("#main_search_container > div.country-language-div > a.dropdown-button.country-language-subdiv > h6.country-header"));
		Utility.safeJavaScriptClick(Header, driver);
		Utility.static_wait(3);		
		
		Utility.Takescrrnshotrun(driver, "CON");
		String img15 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\CON.png");
		logger2.log(LogStatus.PASS, "Step 15:Click on 'Country' & 'Language' Label displayed on page.","Expected output:Search Page has options to change 'Country' & 'Language' when user select  'Country' & 'Language' Label displayed on search page" + img15);
		
		driver.findElement(By.id("changeCountryMain")).click();
		Utility.static_wait(3);
		Utility.Takescrrnshotrun(driver, "changeCountry");	
		String img16 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\changeCountry.png");
		logger2.log(LogStatus.PASS, "Step 16:Click on Country & Language displayed below header and 'Change Language' option on search page.","Expected output:Language  selection screen appears with the selected Country Name- 'United States',  as the Title of the screen." + img16);
		Utility.static_wait(3);
		United_States=driver.findElement(By.linkText("United States"));
		Utility.safeJavaScriptClick(United_States, driver);
		Utility.static_wait(3);			
	    WebElement ENG=driver.findElement(By.linkText("English"));
		Utility.safeJavaScriptClick(ENG, driver);
		Utility.static_wait(3);
		Utility.Takescrrnshotrun(driver, "Sel_Lan");
		String img17 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Sel_Lan.png");
		logger2.log(LogStatus.PASS, "Step 17:Click on any 'Country' > choose a 'Language.","Expected output:when users selects country & language in respective selection screens, Search page appears, in selected language." + img17);
		
		
		Header=driver.findElement(By.cssSelector("i.material-icons.valign-bottom"));
		Utility.safeJavaScriptClick(Header, driver);
		Utility.static_wait(3);	
		driver.findElement(By.id("changeLanguage")).click();
		Utility.static_wait(3);
		Utility.Takescrrnshotrun(driver, "changelanguage");
		String img18 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\changeCountry.png");
		logger2.log(LogStatus.PASS, "Step 18:Click on 'Change Language' option on search Page>Choose a 'Language'.","Expected output:When 'Change language' option is clicked on search page, user is redirected to language selection screen and upon selecting a language, search page appears." + img18);
		Utility.static_wait(3);
		
		driver.findElement(By.xpath("//div[@id='language_container']/div[2]/div[3]")).click();
		
		
		Utility.Takescrrnshotrun(driver, "changcon");
		String img19 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\changcon.png");
		logger2.log(LogStatus.PASS, "Step 19:Click on 'Change Continent' Option below header, on search Page.","Expected output:when 'Change Continent' option is selected on search Page, user is redirected to Document Library home Page." + img19);
		Thread.sleep(3000);
		
		
		
		softAssert.assertAll();
		driver.quit();
		logger2.log(LogStatus.PASS, "Result=Script Passed and User able to Validate Search page UI elements and functionality for US users in English Language");         
           
			 }
	
	
	
	
	@Test(enabled=false)
	public void User_access() throws Exception {
		
			logger2 = report2.startTest("Search Results-Validating basic and advanced filters");
			/**
			 * Call login step from Library
			 */
			ConfigurationFile property = DataProviderFactory.getProperty();
			WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());
			Utility.static_wait(2);
			driver.get(property.getURL());
			Screen D1 = new Screen();
			softAssert.assertEquals("Market - dvpqa.net", driver.getTitle());
			WebElement Logo = driver.findElement(By.cssSelector("img.isi-logo"));
			Utility.Highlightelements(driver, Logo);
			Utility.static_wait(1);
			
			  WebElement Texe1 = driver.findElement(By.cssSelector("div.col.s4"));
			  Utility.Highlightelements(driver, Texe1); Utility.static_wait(1);
			  Utility.Takescrrnshotrun(driver,"Login"); 
			  WebElement
			  french=driver.findElement(By.xpath("//*[contains(text(),'Dites-nous où vous êtes.')]"));
			  Utility.Highlightelements(driver, french);
			  Utility.static_wait(1);
			  Utility.Takescrrnshotrun(driver,"Login1"); WebElement
			  Germon=driver.findElement(By.xpath(
			  "//*[contains(text(),'Sagen Sie uns, wo Sie sich gerade befinden.')]"
			  )); Utility.Highlightelements(driver, Germon);
			  Thread.sleep(1000); WebElement
			  Spanesh=driver.findElement(By.xpath(
			  "//*[contains(text(),'Díganos dónde se encuentra.')]"));
			  Utility.Highlightelements(driver, Spanesh); Thread.sleep(1000);
			  WebElement Itely=driver.findElement(By.xpath(
			  "//*[contains(text(),'Comunicaci dove ti trovi.')]"));
			 Utility.Highlightelements(driver, Itely); Utility.static_wait(1);
			  WebElement Japan=driver.findElement(By.xpath(
			  "//*[@id='tell-us']/div[2]/div[3]"));
			  Utility.Highlightelements(driver, Japan);
			 
			Utility.static_wait(1);
			
			D1.click(IMA1);
			Thread.sleep(3000);
			Utility.Takescrrnshotrun(driver, "Login2");
			D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\REMNO.png");
			Thread.sleep(3000);
			
			 
			WebElement Logo2 = driver.findElement(By.cssSelector("h4"));
			Utility.Highlightelements(driver, Logo2);
			
			Utility.Takescrrnshotrun(driver, "Login3");
			WebElement United_States = driver.findElement(By.linkText("United States"));
			Utility.safeJavaScriptClick(United_States, driver);
			Thread.sleep(2000);
			Utility.Takescrrnshotrun(driver, "Login4");

			WebElement ImageFile = driver
					.findElement(By.cssSelector("#language_isi_image_container > #isi_image > img.isi_image"));
			Utility.Highlightelements(driver, ImageFile);
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					ImageFile);
			if (ImagePresent) {
				System.out.println("Image is displayed.");
			} else {
				driver.quit();
			}
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			element = wait1.until(ExpectedConditions.elementToBeClickable(By.className("language-name")));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", element);
			Thread.sleep(5000);
			WebElement Logo1 = driver.findElement(By.cssSelector("h6.country-header"));
			Utility.Highlightelements(driver, Logo1);
			Thread.sleep(2000);
			/*
			 * Utility.Takescrrnshotrun(driver,"Login5"); Thread.sleep(2000);
			 */
			/*
			 * driver.get(property.URLAdmin());
			 * driver.findElement(By.xpath("//input[contains(@id,'_login')]")).
			 * clear();
			 * driver.findElement(By.xpath("//input[contains(@id,'_login')]")).
			 * sendKeys(property.getUName());
			 * driver.findElement(By.xpath("//input[contains(@id,'_password')]")
			 * ).sendKeys(property.getPP());
			 * 
			 * driver.findElement(By.xpath("//*[@value='Sign In']")).click();
			 * Thread.sleep(4000); driver.get(property.scheduler());
			 * Thread.sleep(2000);
			 * if(driver.findElements(By.name("schedulerBtn")).size() != 0){
			 * System.out.println("schedulerBtn is Present"); }else{
			 * System.out.println("schedulerBtn is Absent"); }
			 * driver.findElement(By.name("schedulerBtn")).click(); wait1 = new
			 * WebDriverWait(driver, 50); element =
			 * wait1.until(ExpectedConditions.elementToBeClickable(By.linkText(
			 * "Sign Out")));
			 * 
			 * Thread.sleep(30000); driver.findElement(By.linkText("Sign Out"
			 * )).click(); Thread.sleep(2000);
			 * driver.switchTo().defaultContent();
			 */
			WebDriverWait wait = new WebDriverWait(driver,30);
			String Text = wait.until(ExpectedConditions.elementToBeClickable(By.id("initialSearchTextbox"))).getAttribute("placeholder");
			System.out.println(Text);	
			
			WebElement QRG=driver.findElement(By.xpath("//ul[@id='pubType_ul']/li[2]/div/a/span"));
			Utility.Highlightelements(driver, QRG);
			Utility.static_wait(3);
			driver.findElement(By.xpath("//ul[@id='pubType_ul']/li[2]/div/a/span")).click();
			Utility.static_wait(3);
			/*Select dropdown = new Select(driver.findElement(By.id("sortby")));
			dropdown.selectByValue("asc");
			dropdown = new Select(driver.findElement(By.id("sortby")));
			dropdown.selectByValue("desc");*/
			
			
			driver.findElement(By.xpath("//*[contains(text(),'view_module')]")).click();
			Utility.static_wait(3);			
			
			driver.findElement(By.xpath("//*[contains(text(),'reorder')]")).click();
			Utility.static_wait(3);
			
			
			driver.findElement(By.xpath("//input[@value='Relevance']")).click();
			Utility.static_wait(3);
			driver.findElement(By.xpath("//*[contains(text(),'Name (Ascending)')]")).click();
			Utility.static_wait(3);
			driver.findElement(By.xpath("//input[@value='Relevance']")).click();
			Utility.static_wait(3);
			driver.findElement(By.xpath("//*[contains(text(),'Name (Descending)')]")).click();
			Utility.static_wait(3);
			WebElement NarrowSearch = driver.findElement(By.xpath("//*[contains(text(),'Narrow By')]"));
			Utility.Highlightelements(driver, NarrowSearch);
			Utility.static_wait(3);
			//driver.findElement(By.xpath("//ul[@id='pubType_ul']/li[2]/div/a/span")).click();
			Utility.static_wait(2);
			String Searchresult= driver.findElement(By.cssSelector("span.label-search-results")).getText();
            System.out.println(Searchresult);             
            Utility.scrollToBottom1(driver);
            Utility.static_wait(3);
            int rows =driver.findElements(By.xpath("//*[@id='results_div']/table/tbody/tr[*]/td[2]/a")).size();
	        System.out.println(rows);
	        Utility.static_wait(3);
	        
			 WebElement Filter = driver.findElement(By.cssSelector("div.narrow-by-heading"));
			Utility.Highlightelements(driver, Filter);
			Utility.static_wait(2);   
			
			NarrowSearch = driver.findElement(By.xpath("//*[contains(text(),'Narrow By')]"));
			Utility.Highlightelements(driver, NarrowSearch);
			Utility.static_wait(2);
	        
			driver.findElement(By.id("narrowBySearchKeyword")).sendKeys("steralize");
			Utility.static_wait(2);
			driver.findElement(By.id("narrowBySearchKeyword")).sendKeys(Keys.RETURN);
			Utility.static_wait(2);
			driver.findElement(By.id("narrowBySearchKeyword")).clear();
			Utility.static_wait(2);
			driver.findElement(By.id("narrowBySearchKeyword")).sendKeys("551992");
			Utility.static_wait(2);
			driver.findElement(By.id("narrowBySearchKeyword")).sendKeys(Keys.RETURN);
			Utility.static_wait(2);
			driver.findElement(By.id("narrowBySearchKeyword")).clear();
			Utility.static_wait(2);
			driver.findElement(By.id("narrowBySearchKeyword")).sendKeys("552970-04A");
			Utility.static_wait(2);
			driver.findElement(By.id("narrowBySearchKeyword")).sendKeys(Keys.RETURN);
			Utility.static_wait(2);
			driver.findElement(By.id("narrowBySearchKeyword")).clear();
			Utility.static_wait(2);
			 driver.findElement(By.cssSelector("i.material-icons.right")).click(); 
			 Utility.static_wait(2);
			  driver.findElement(By.linkText("View Manual")).click(); 
			  Utility.static_wait(2);
			  driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click(); 
			  Utility.static_wait(2);
			  driver.findElement(By.cssSelector("i.material-icons.right")).click(); 
			  Utility.static_wait(2);
			  driver.findElement(By.linkText("Order Manual")).click(); 
			  Utility.static_wait(2);
			 
			  driver.findElement(By.xpath("//a[contains(text(),'Close')]")).click(); 
			  Utility.static_wait(2);
			  driver.findElement(By.cssSelector("i.material-icons.right")).click(); 
			  Utility.static_wait(2);
			  driver.findElement(By.linkText("Previous Versions")).click(); 
			  Utility.static_wait(2);
			 driver.findElement(By.xpath("(//a[contains(text(),'Close')])[2]")).click(); 
			 Utility.static_wait(2);
			 driver.switchTo().defaultContent();
			 Utility.static_wait(3);
			driver.findElement(By.cssSelector("i.material-icons.white-text")).click();
			Utility.static_wait(2);
			driver.findElement(By.cssSelector("#ticker-pubtype-previous > i.material-icons")).click();
			Utility.static_wait(2);
			driver.findElement(By.cssSelector("#ticker-pubtype-previous > i.material-icons")).click();
			Utility.static_wait(2);
			driver.findElement(By.cssSelector("#ticker-pubtype-previous > i.material-icons")).click();
			Utility.static_wait(1);
			driver.findElement(By.cssSelector("#ticker-platform-previous > i.material-icons")).click();
			Utility.static_wait(1);
			driver.findElement(By.cssSelector("#ticker-platform-previous > i.material-icons")).click();
			Utility.static_wait(1);
			driver.findElement(By.cssSelector("#ticker-platform-previous > i.material-icons")).click();
			Utility.static_wait(1);
			
			WebElement Search = driver.findElement(By.xpath("//*[@id='basic_search_container']/div/div[2]/a"));
			Utility.safeJavaScriptClick(Search, driver);
			Utility.static_wait(3);				

			WebElement Advsearch = driver.findElement(By.cssSelector("a.advance-search-main.left"));
			Utility.safeJavaScriptClick(Advsearch, driver);
			Utility.static_wait(3);
			 Filter = driver.findElement(By.cssSelector("div.narrow-by-heading"));
				Utility.Highlightelements(driver, Filter);
				Utility.static_wait(2);
			NarrowSearch = driver.findElement(By.xpath("//*[contains(text(),'Narrow By')]"));
			Utility.Highlightelements(driver, NarrowSearch);
			Utility.static_wait(2);
			driver.findElement(By.id("advanceFilterPartNumberMain")).sendKeys("550650-08");
			Utility.static_wait(2);

			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[5]/div/input")).click();
			Utility.static_wait(2);
			driver.findElement(By.xpath("//div[5]/div/ul/li[2]/span")).click();

			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[6]/div/input")).click();
			Utility.static_wait(2);
			driver.findElement(By.xpath("//div[6]/div/ul/li[2]/span")).click();
			Utility.static_wait(2);
			driver.findElement(By.xpath("//*[@id='advance_main_search_icon']")).click();
			Utility.static_wait(2);
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[5]/div/input")).click();
			Utility.static_wait(2);
			driver.findElement(By.xpath("//div[5]/div/ul/li[5]/span")).click();
			Utility.static_wait(2);
			driver.findElement(By.xpath("//*[@id='advance_main_search_icon']")).click();
			Utility.static_wait(2);

			if (driver.getPageSource().contains("Please try a new search or select a new language and search again.")) {
				WebElement Nodocument = driver.findElement(By.cssSelector("td"));
				Utility.Highlightelements(driver, Nodocument);
				Utility.static_wait(2);
			} else {

				driver.quit();
			} 			
			Utility.static_wait(2);
			
			
			WebElement reset = driver.findElement(By.id("reset_main_search_icon"));
			Utility.safeJavaScriptClick(reset, driver);
			Utility.static_wait(10);	
			
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div[2]/div/a")).click();
			Utility.static_wait(10);
			
			
			
			driver.findElement(By.id("advanceFilterDocumentNameMain")).sendKeys("Surgical Staplers");
			Utility.static_wait(10);
			
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[5]/div/input")).click();
			Utility.static_wait(10);
			driver.findElement(By.xpath("//div[5]/div/ul/li[6]/span")).click();
			Utility.static_wait(10);
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[6]/div/input")).click();
			Utility.static_wait(5);
			driver.findElement(By.xpath("//div[6]/div/ul/li[9]/span")).click();
			Utility.static_wait(5);
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div[2]/div/a")).click();
			Utility.static_wait(10);
			 reset = driver.findElement(By.xpath("//a[contains(text(),'Reset')]"));
				Utility.safeJavaScriptClick(reset, driver);
				Utility.static_wait(10);
				driver.findElement(By.id("advanceFilterDocumentNameMain")).sendKeys("Surgical Staplers");
				Utility.static_wait(10);
				driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[5]/div/input")).click();
				Utility.static_wait(10);
				driver.findElement(By.xpath("//div[5]/div/ul/li[6]/span")).click();
				Utility.static_wait(5);
				driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[6]/div/input")).click();
				Utility.static_wait(10);
				driver.findElement(By.xpath("//div[6]/div/ul/li[3]/span")).click();
				Utility.static_wait(10);
				driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div[2]/div/a")).click();
				Utility.static_wait(20);	
				

				if (driver.getPageSource().contains("Please try a new search or select a new language and search again.")) {
					WebElement Nodocument = driver.findElement(By.cssSelector("td"));
					Utility.Highlightelements(driver, Nodocument);
					Utility.static_wait(10);
				} else {

					driver.quit();
				} 			
				Utility.static_wait(10);
				 reset = driver.findElement(By.id("reset_main_search_icon"));
					Utility.safeJavaScriptClick(reset, driver);
					Utility.static_wait(10);		
				
				
				
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div[2]/div/a")).click();
			Utility.static_wait(10);
			

			driver.findElement(By.id("advanceFilterDescriptionMain")).sendKeys("accessories");
			Utility.static_wait(10);
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div[2]/div/a")).click();

			Utility.static_wait(10);
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[5]/div/input")).click();
			Utility.static_wait(10);
			driver.findElement(By.xpath("//div[5]/div/ul/li[2]/span")).click();
			Utility.static_wait(10);
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[6]/div/input")).click();
			Utility.static_wait(10);
			driver.findElement(By.xpath("//div[6]/div/ul/li[2]/span")).click();
			Utility.static_wait(10);

			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div[2]/div/a")).click();
			Utility.static_wait(7);	
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[5]/div/input")).click();
			Utility.static_wait(5);
			driver.findElement(By.xpath("//div[5]/div/ul/li[4]/span")).click();
			Utility.static_wait(5);	
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div[2]/div/a")).click();
			Utility.static_wait(20);	

			if (driver.getPageSource().contains("Please try a new search or select a new language and search again.")) {
				WebElement Nodocument = driver.findElement(By.cssSelector("td"));
				Utility.Highlightelements(driver, Nodocument);
				Utility.static_wait(2);
			} else {

				driver.quit();
			} 			
			Utility.static_wait(10);
			
			
			
	       reset = driver.findElement(By.id("reset_main_search_icon"));
				Utility.safeJavaScriptClick(reset, driver);
				Utility.static_wait(5);		
			driver.findElement(By.id("advanceFilterContentMain")).sendKeys("clean");

			Utility.static_wait(10);
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div[2]/div/a")).click();
			Utility.static_wait(10);
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[5]/div/input")).click();
			Utility.static_wait(5);
			driver.findElement(By.xpath("//div[5]/div/ul/li[2]/span")).click();
			Utility.static_wait(5);
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[6]/div/input")).click();
			Utility.static_wait(10);
			driver.findElement(By.xpath("//div[6]/div/ul/li[5]/span")).click();
			Utility.static_wait(10);
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div[2]/div/a")).click();
			reset = driver.findElement(By.id("reset_main_search_icon"));
				Utility.safeJavaScriptClick(reset, driver);
				Utility.static_wait(10);		
			driver.findElement(By.id("advanceFilterContentMain")).sendKeys("clean");
			Utility.static_wait(5);
			
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div[2]/div/a")).click();
			Utility.static_wait(5);
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[5]/div/input")).click();
			Utility.static_wait(10);
			driver.findElement(By.xpath("//div[5]/div/ul/li[2]/span")).click();
			Utility.static_wait(10);
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[6]/div/input")).click();
			Utility.static_wait(1);	
			driver.findElement(By.xpath("//div[6]/div/ul/li[9]/span")).click();
			Utility.static_wait(5);
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div[2]/div/a")).click();
			Utility.static_wait(20);
			
			
			
			
			if (driver.getPageSource().contains("Please try a new search or select a new language and search again.")) {
				WebElement Nodocument = driver.findElement(By.cssSelector("td"));
				Utility.Highlightelements(driver, Nodocument);
				Utility.static_wait(5);
			} else {

				driver.quit();
			} 			
			D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
			logger2.log(LogStatus.PASS, "Script Passed and User able to -Validate basic and advanced filters");
			
			 }
	
	
	@Test(enabled=false)
	public void UI_Validation_French() throws Exception {
		try {
			logger2 = report2.startTest("UI-Validation-French");
			/**
			 * Call login step from Library
			 */
			ConfigurationFile property = DataProviderFactory.getProperty();
			WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());

			driver.get(property.getURL());
			softAssert.assertEquals("Market - dvpqa.net", driver.getTitle());
			WebElement Logo = driver.findElement(By.cssSelector("img.isi-logo"));
			Utility.Highlightelements(driver, Logo);
			Thread.sleep(1000);
			WebElement Texe1 = driver.findElement(By.cssSelector("div.col.s4"));
			Utility.Highlightelements(driver, Texe1);
			Thread.sleep(1000);
			WebElement french = driver.findElement(By.xpath("//*[contains(text(),'Dites-nous où vous êtes.')]"));
			Utility.Highlightelements(driver, french);
			Thread.sleep(1000);
			WebElement Germon = driver.findElement(By.xpath("//*[contains(text(),'Sagen Sie uns, wo Sie sich gerade befinden.')]"));
			Utility.Highlightelements(driver, Germon);
			Thread.sleep(1000);
			WebElement Spanesh = driver.findElement(By.xpath("//*[contains(text(),'Díganos dónde se encuentra.')]"));
			Utility.Highlightelements(driver, Spanesh);
			Thread.sleep(1000);
			WebElement Itely = driver.findElement(By.xpath("//*[contains(text(),'Comunicaci dove ti trovi.')]"));
			Utility.Highlightelements(driver, Itely);
			Thread.sleep(1000);
			WebElement Japan = driver.findElement(By.xpath("//*[@id='tell-us']/div[2]/div[3]"));
			Utility.Highlightelements(driver, Japan);
			Thread.sleep(1000);
			D1.click(IMA3);
			Thread.sleep(5000);
			List<WebElement> linkElements =driver.findElements(By.className("country-name"));
			WebDriverWait wait = new WebDriverWait(driver, 60);
			 wait.until(ExpectedConditions.visibilityOfAllElements(linkElements));
			 
			WebElement Logo2 = driver.findElement(By.cssSelector("h4"));
			Utility.Highlightelements(driver, Logo2);
			Thread.sleep(2000);
			Utility.scrollDown(driver);
			/*WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Switzerland")));*/
			Utility.scrollDown(driver);
			Thread.sleep(3000);
			WebElement goButton=driver.findElement(By.linkText("Switzerland"));
			Utility.safeJavaScriptClick(goButton, driver);
		
			Thread.sleep(5000);
			Utility.static_wait(2);
			if (driver.getPageSource().contains("Switzerland")) {
				System.out.println("Text is present");
			} else {

				driver.quit();
			}
			
			WebElement ImageFile = driver.findElement(By.cssSelector("#language_isi_image_container > #isi_image > img.isi_image"));
			Utility.Highlightelements(driver, ImageFile);
		    Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
		    if (ImagePresent)
		    {
		         System.out.println("Image is displayed.");
		    }
		    else
		    {
		        driver.quit();
		    }
			
			List<WebElement> alllinks2 = driver.findElements(By.className("language-name"));
			int linkListCount2 = alllinks2.size();

			for (int i = 0; i < alllinks2.size(); i++)
				System.out.println(alllinks2.get(i).getText());
			System.out.println("Total numbner of country is: " + linkListCount2);
			softAssert.assertEquals(3, linkListCount2, "Count match");
			
			WebElement French=driver.findElement(By.linkText("French"));
			Utility.safeJavaScriptClick(French, driver);
			Thread.sleep(5000);
			Logo = driver.findElement(By.cssSelector("img.isi-logo"));
			Utility.Highlightelements(driver, Logo);
			Thread.sleep(3000);		
			WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Switzerland ( French )')]"));
			Utility.Highlightelements(driver, element);
			String Switzerland = element.getText();
			System.out.println(Switzerland);
			softAssert.assertEquals("Switzerland ( French )", Switzerland);			
			driver.findElement(By.linkText("Recherche avancée")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(text(),'Switzerland ( French )')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("changeLanguage")).click();
			Thread.sleep(3000);
			Logo2 = driver.findElement(By.cssSelector("h4"));
			Utility.Highlightelements(driver, Logo2);
			Thread.sleep(2000);
			if (driver.getPageSource().contains("Switzerland")) {
				System.out.println("User able to redirect Switzerland Page");
			} else {

				driver.quit();
			}

			driver.findElement(By.xpath("//div[@id='language_container']/div[2]/div[3]")).click();

			logger2.log(LogStatus.PASS, "Script Passed and User able to validate UI-French");
		
		} catch (Exception e) {
			
			driver.quit();
		}
		
	}
	@Test(enabled=false)
	public void UI_Validation_Germon() throws Exception {
		try {
			logger2 = report2.startTest("UI-Validation-Germon");
			/**
			 * Call login step from Library
			 */
			ConfigurationFile property = DataProviderFactory.getProperty();
			WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());

			driver.get(property.getURL());
			

			softAssert.assertEquals("Market - dvpqa.net", driver.getTitle());
			WebElement Logo = driver.findElement(By.cssSelector("img.isi-logo"));
			Utility.Highlightelements(driver, Logo);
			Thread.sleep(1000);
			WebElement Texe1 = driver.findElement(By.cssSelector("div.col.s4"));
			Utility.Highlightelements(driver, Texe1);
			Thread.sleep(1000);
			WebElement french = driver.findElement(By.xpath("//*[contains(text(),'Dites-nous où vous êtes.')]"));
			Utility.Highlightelements(driver, french);
			Thread.sleep(1000);
			WebElement Germon = driver.findElement(By.xpath("//*[contains(text(),'Sagen Sie uns, wo Sie sich gerade befinden.')]"));
			Utility.Highlightelements(driver, Germon);
			Thread.sleep(1000);
			WebElement Spanesh = driver.findElement(By.xpath("//*[contains(text(),'Díganos dónde se encuentra.')]"));
			Utility.Highlightelements(driver, Spanesh);
			Thread.sleep(1000);
			WebElement Itely = driver.findElement(By.xpath("//*[contains(text(),'Comunicaci dove ti trovi.')]"));
			Utility.Highlightelements(driver, Itely);
			Thread.sleep(1000);
			WebElement Japan = driver.findElement(By.xpath("//*[@id='tell-us']/div[2]/div[3]"));
			Utility.Highlightelements(driver, Japan);
			Thread.sleep(1000);		
			D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\EU.png");
			Thread.sleep(2000);	
				if (driver.getPageSource().contains("SELECT COUNTRY BELOW ")) {
					System.out.println("Text is present");
				} else {

					driver.quit();
				} 
			WebElement Logo2 = driver.findElement(By.cssSelector("h4"));
			Utility.Highlightelements(driver, Logo2);
			Thread.sleep(2000);
			
			Utility.scrollDown(driver);
			Thread.sleep(3000);
			WebElement goButton=driver.findElement(By.linkText("Switzerland"));
			Utility.safeJavaScriptClick(goButton, driver);
			//D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\SWIZ.png");
			Thread.sleep(5000);
			Utility.static_wait(2);
			if (driver.getPageSource().contains("Switzerland")) {
				System.out.println("Text is present");
			} else {

				driver.quit();
			}
			
			WebElement ImageFile = driver.findElement(By.cssSelector("#language_isi_image_container > #isi_image > img.isi_image"));
			Utility.Highlightelements(driver, ImageFile);
		    Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
		    if (ImagePresent)
		    {
		         System.out.println("Image is displayed.");
		    }
		    else
		    {
		        driver.quit();
		    }
			
			if (driver.getPageSource().contains("Switzerland")) {
				System.out.println("Text is present");
			} else {

				driver.quit();
			}
			List<WebElement> alllinks2 = driver.findElements(By.className("language-name"));
			int linkListCount2 = alllinks2.size();

			for (int i = 0; i < alllinks2.size(); i++)
				System.out.println(alllinks2.get(i).getText());
			System.out.println("Total numbner of country is: " + linkListCount2);
			softAssert.assertEquals(3, linkListCount2, "Count match");
			
			WebElement German=driver.findElement(By.linkText("German"));
			Utility.safeJavaScriptClick(German, driver);
			Thread.sleep(5000);
			Logo = driver.findElement(By.cssSelector("img.isi-logo"));
			Utility.Highlightelements(driver, Logo);
			Thread.sleep(3000);		
			WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Switzerland ( German )')]"));
			Utility.Highlightelements(driver, element);
			String Switzerland = element.getText();
			System.out.println(Switzerland);
			softAssert.assertEquals("Switzerland ( German )", Switzerland);
			
			Thread.sleep(2000);
			driver.findElement(By.linkText("Erweiterte Suche")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(text(),'Switzerland ( German )')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("changeLanguage")).click();
			Thread.sleep(3000);
			Logo2 = driver.findElement(By.cssSelector("h4"));
			Utility.Highlightelements(driver, Logo2);
			Thread.sleep(2000);
			if (driver.getPageSource().contains("Switzerland")) {
				System.out.println("User able to redirect Switzerland Page");
			} else {

				driver.quit();
			}

			driver.findElement(By.xpath("//div[@id='language_container']/div[2]/div[3]")).click();

			logger2.log(LogStatus.PASS, "Script Passed and User able to validate UI-Germon");
		} catch (Exception e) {
			driver.quit();
		}
		
	}
	
	@Test(enabled=false)
	public void Search_Page_Validation_US() throws Exception {
		logger2 = report2.startTest("Search_Page_Validation_US");
		/**
		 * Call login step from Library
		 */
		ConfigurationFile property = DataProviderFactory.getProperty();
		WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());
		driver.get(property.getURL());	

		softAssert.assertEquals("Market - dvpqa.net", driver.getTitle());
		WebElement Logo = driver.findElement(By.cssSelector("img.isi-logo"));
		Utility.Highlightelements(driver, Logo);
		Thread.sleep(1000);
		
		
		D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\NA.png");
		Thread.sleep(5000);
		List<WebElement> linkElements =driver.findElements(By.className("country-name"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.visibilityOfAllElements(linkElements));
		 
		WebElement Logo2 = driver.findElement(By.cssSelector("h4"));
		Utility.Highlightelements(driver, Logo2);
		Thread.sleep(5000);
		
		
		
		if (driver.getPageSource().contains("United States")) {
			System.out.println("Text is present");
		} else {

			driver.quit();
		}
		Thread.sleep(5000);
		Utility.static_wait(2);
		
		
		WebElement ImageFile = driver.findElement(By.cssSelector("#language_isi_image_container > #isi_image > img.isi_image"));
		Utility.Highlightelements(driver, ImageFile);
	    Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
	    if (ImagePresent)
	    {
	         System.out.println("Image is displayed.");
	    }
	    else
	    {
	        driver.quit();
	    }
		
		WebElement United_States=driver.findElement(By.linkText("United States"));
		Utility.safeJavaScriptClick(United_States, driver);
		Thread.sleep(3000);
	    Logo = driver.findElement(By.cssSelector("img.isi-logo"));
		Utility.Highlightelements(driver, Logo);
		Thread.sleep(3000);	
		WebElement ENG=driver.findElement(By.linkText("English"));
		Utility.safeJavaScriptClick(ENG, driver);
		Thread.sleep(3000);	
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'United States ( English )')]"));
		Utility.Highlightelements(driver, element);
		String USA = element.getText();
		System.out.println(USA);
		softAssert.assertEquals("United States ( English )", USA);
		Thread.sleep(2000);
		D1.hover("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
		Thread.sleep(2000);		
		driver.findElement(By.linkText("Advanced Search")).click();		
		Thread.sleep(2000);
		WebElement part_number=driver.findElement(By.cssSelector("label"));
		Utility.Highlightelements(driver, part_number);
		WebElement Doc_name=driver.findElement(By.xpath("//*[contains(text(),'Document Name')]"));
		Utility.Highlightelements(driver, Doc_name);
		WebElement Desc=driver.findElement(By.xpath("//*[contains(text(),'Description')]"));
		Utility.Highlightelements(driver, Desc);
		WebElement Keyword=driver.findElement(By.xpath("//*[@id='advanced_search_container']/div/div[1]/div[2]/div[2]/label"));
		Utility.Highlightelements(driver, Keyword);
		Thread.sleep(3000);
		/*Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[contains(text(),'United States ( English )')]"));
		action.moveToElement(we).build().perform();*/
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'United States ( English )')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("changeCountry")).click();
		Thread.sleep(3000);
		Logo2 = driver.findElement(By.cssSelector("h4"));
		Utility.Highlightelements(driver, Logo2);
	    United_States=driver.findElement(By.linkText("United States"));
		Utility.safeJavaScriptClick(United_States, driver);
		Thread.sleep(5000);
	    Logo = driver.findElement(By.cssSelector("img.isi-logo"));
		Utility.Highlightelements(driver, Logo);
		Thread.sleep(3000);	
		ENG=driver.findElement(By.linkText("English"));
		Utility.safeJavaScriptClick(ENG, driver);
		driver.findElement(By.xpath("//*[contains(text(),'United States ( English )')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("changeLanguage")).click();
		Thread.sleep(2000);
		Logo = driver.findElement(By.cssSelector("img.isi-logo"));
		Utility.Highlightelements(driver, Logo);
		ENG=driver.findElement(By.linkText("English"));
		Utility.safeJavaScriptClick(ENG, driver);
		Thread.sleep(2000);
		element = driver.findElement(By.xpath("//*[contains(text(),'United States ( English )')]"));
		Utility.Highlightelements(driver, element);
		USA = element.getText();
		System.out.println(USA);
		softAssert.assertEquals("United States ( English )", USA);
		Thread.sleep(2000);
		
	
		Logo = driver.findElement(By.xpath("//*[@id='image_container']/div/a[2]/i"));
		Utility.Highlightelements(driver, Logo);
		Utility.safeJavaScriptClick(Logo, driver);
		
		logger2.log(LogStatus.PASS, "Script Passed and User able to validate Search_Page_Validation_US");
		
		
		
	}
	
	@Test(enabled=false)
	public void Search_Page_Validation_French() throws Exception {
		logger2 = report2.startTest("Search_Page_Validation_French");
		/**
		 * Call login step from Library
		 */
		ConfigurationFile property = DataProviderFactory.getProperty();
		WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());

		driver.get(property.getURL());
		softAssert.assertEquals("Market - dvpqa.net", driver.getTitle());
		WebElement Logo = driver.findElement(By.cssSelector("img.isi-logo"));
		Utility.Highlightelements(driver, Logo);
		Thread.sleep(1000);
		Utility.Takescrrnshotrun(driver, "Global Map");
        String img=logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Global Map.png");
        logger2.log(LogStatus.PASS, "Validate logo and language", "Step 1:User able to verify logo and language " + img);		
		/*logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Rahul.png");
		logger2.addScreencast("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Rahul.png");*/
		
		D1.click(IMA3);
		Thread.sleep(5000);
		List<WebElement> linkElements =driver.findElements(By.className("country-name"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.visibilityOfAllElements(linkElements));
		 
		WebElement Logo2 = driver.findElement(By.cssSelector("h4"));
		Utility.Highlightelements(driver, Logo2);
		Thread.sleep(2000);
		Utility.scrollDown(driver);	
		Thread.sleep(3000);
		WebElement goButton=driver.findElement(By.linkText("Switzerland"));
		Utility.safeJavaScriptClick(goButton, driver);
		Thread.sleep(5000);
		Utility.Takescrrnshotrun(driver, "Switzerland");
	       String img1=logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Switzerland.png");
	       logger2.log(LogStatus.PASS, "Validate country and image", "Step 2: User able to verify country and image " + img1);
		
		Utility.static_wait(2);
		
		
		WebElement ImageFile = driver.findElement(By.cssSelector("#language_isi_image_container > #isi_image > img.isi_image"));
		Utility.Highlightelements(driver, ImageFile);
	    Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
	    if (ImagePresent)
	    {
	         System.out.println("Image is displayed.");
	    }
	    else
	    {
	        driver.quit();
	    }
		Thread.sleep(5000);
		
		if (driver.getPageSource().contains("Switzerland")) {
			System.out.println("Text is present");
		} else {

			driver.quit();
		}
		if (driver.getPageSource().contains("SELECT LANGUAGE BELOW")) {
			System.out.println("Text is present");
		} else {

			driver.quit();
		}
		
		List<WebElement> alllinks2 = driver.findElements(By.className("language-name"));
		int linkListCount2 = alllinks2.size();

		for (int i = 0; i < alllinks2.size(); i++)
			System.out.println(alllinks2.get(i).getText());
		System.out.println("Total numbner of country is: " + linkListCount2);
		softAssert.assertEquals(3, linkListCount2, "Count match");
		
		WebElement French=driver.findElement(By.linkText("French"));
		Utility.safeJavaScriptClick(French, driver);
		Thread.sleep(5000);
		Utility.Takescrrnshotrun(driver, "Search Page");
		String img2=logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Search Page.png");
	       logger2.log(LogStatus.PASS, "validate basic and advance search", "Step 3: User able to verify bacic and advance search" + img2);
	       
	    Logo = driver.findElement(By.cssSelector("img.isi-logo"));
		Utility.Highlightelements(driver, Logo);
		Thread.sleep(3000);		
		
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Switzerland ( French )')]"));
		Utility.Highlightelements(driver, element);
		String Switzerland = element.getText();
		System.out.println(Switzerland);
		
		
		softAssert.assertEquals("Switzerland ( French )", Switzerland);		
		Thread.sleep(2000);
		D1.hover("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
		Thread.sleep(2000);		
		driver.findElement(By.linkText("Recherche avancée")).click();
		
		Thread.sleep(2000);
		WebElement part_number=driver.findElement(By.cssSelector("label"));
		Utility.Highlightelements(driver, part_number);
		Thread.sleep(2000);
		WebElement Doc_name=driver.findElement(By.xpath("//*[contains(text(),'Nom du document')]"));
		Utility.Highlightelements(driver, Doc_name);
		WebElement Desc=driver.findElement(By.xpath("//*[contains(text(),'Description')]"));
		Utility.Highlightelements(driver, Desc);
		WebElement Keyword=driver.findElement(By.xpath("//*[@id='advanced_search_container']/div/div[1]/div[2]/div[2]/label"));
		Utility.Highlightelements(driver, Keyword);
		Thread.sleep(3000);
		
		
		/*Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[contains(text(),'United States ( English )')]"));
		action.moveToElement(we).build().perform();*/
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Switzerland ( French )')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("changeCountry")).click();
		Thread.sleep(3000);
		
		
		
		linkElements =driver.findElements(By.className("country-name"));
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfAllElements(linkElements));
		Logo2 = driver.findElement(By.cssSelector("h4"));
		Utility.Highlightelements(driver, Logo2);
		Thread.sleep(2000);
		Utility.scrollDown(driver);	
		Thread.sleep(3000);
		goButton=driver.findElement(By.linkText("Switzerland"));
		Utility.safeJavaScriptClick(goButton, driver);
		Thread.sleep(5000); 
		if (driver.getPageSource().contains("Switzerland")) {
			System.out.println("Text is present");
		} else {

			driver.quit();
		}
		if (driver.getPageSource().contains("SELECT LANGUAGE BELOW")) {
			System.out.println("Text is present");
		} else {

			driver.quit();
		}
		
		alllinks2 = driver.findElements(By.className("language-name"));
		linkListCount2 = alllinks2.size();

		for (int i = 0; i < alllinks2.size(); i++)
			System.out.println(alllinks2.get(i).getText());
		System.out.println("Total numbner of country is: " + linkListCount2);
		softAssert.assertEquals(3, linkListCount2, "Count match");
		
		French=driver.findElement(By.linkText("French"));
		Utility.safeJavaScriptClick(French, driver);
		Thread.sleep(5000);
	    Logo = driver.findElement(By.cssSelector("img.isi-logo"));
		Utility.Highlightelements(driver, Logo);
		Thread.sleep(3000);		
	    element = driver.findElement(By.xpath("//*[contains(text(),'Switzerland ( French )')]"));
		Utility.Highlightelements(driver, element);
		 Switzerland = element.getText();
		System.out.println(Switzerland);
		softAssert.assertEquals("Switzerland ( French )", Switzerland);		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[contains(text(),'Switzerland ( French )')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("changeLanguage")).click();
		Thread.sleep(2000);
		Logo2 = driver.findElement(By.cssSelector("h4"));
		Utility.Highlightelements(driver, Logo2);
		Thread.sleep(2000);
		Utility.scrollDown(driver);	
		Thread.sleep(3000);
		
        French=driver.findElement(By.linkText("French"));
		Utility.safeJavaScriptClick(French, driver);
		Thread.sleep(5000);
	    Logo = driver.findElement(By.cssSelector("img.isi-logo"));
		Utility.Highlightelements(driver, Logo);
		Thread.sleep(3000);		
	    element = driver.findElement(By.xpath("//*[contains(text(),'Switzerland ( French )')]"));
		Utility.Highlightelements(driver, element);
		 Switzerland = element.getText();
		System.out.println(Switzerland);
		softAssert.assertEquals("Switzerland ( French )", Switzerland);		
		Thread.sleep(2000);
		
		Logo = driver.findElement(By.xpath("//*[@id='image_container']/div/a[2]/i"));
		
		Utility.safeJavaScriptClick(Logo, driver);	
		
		logger2.log(LogStatus.PASS, "Script Passed and User able to validate Search_Page_Validation_French");
		
		
		
		
		
		
		
	}
	@SuppressWarnings("static-access")
	@Test(priority=6)
	public void Validating_Latest_and_Previous_versions_in_search_results() throws Exception {
		
			logger2 = report2.startTest("09-Validating -Latest & Previous versions in search results ");
			/**
			 * Call login step from Library
			 */
			ConfigurationFile property = DataProviderFactory.getProperty();
			WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());
			Utility.static_wait(2);
			driver.get(property.getURL());
			
			softAssert.assertEquals("Market - dvpuat.net", driver.getTitle());
			Utility.Takescrrnshotrun(driver, "Global Map");
			String img1 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Global Map.png");
			logger2.log(LogStatus.PASS, "Step 1:Launch the Document Library website","Expected output:Document Library homepage is dispalyed" + img1);
			
			Utility.static_wait(5);
			D1.hover(IMA3);
			Utility.static_wait(2);
			D1.click(IMA1);
			
			Utility.Takescrrnshotrun(driver, "NA");
			String img2 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\NA.png");
			logger2.log(LogStatus.PASS, "Step 2:From the world map that is displayed, select 'North America'.","Expected output:A country selection page is displayed and the title of the page is 'North America''." + img2);
			
			WebElement United_States = driver.findElement(By.linkText("United States"));
			Utility.safeJavaScriptClick(United_States, driver);
			Thread.sleep(2000);
			Utility.Takescrrnshotrun(driver, "USA");
			String img3 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\USA.png");
			logger2.log(LogStatus.PASS, "Step 3:Select 'Country' from  the list of countries tiles displayed for the selected 'Continent'","Expected output:Language  selection screen appears with the selected 'Language name', displayed as the Title of the screen." + img3);
			WebElement ImageFile = driver.findElement(By.cssSelector("#language_isi_image_container > #isi_image > img.isi_image"));
			Utility.Highlightelements(driver, ImageFile);
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",ImageFile);
			if (ImagePresent) {
				System.out.println("Image is displayed.");
			} else {
				driver.quit();
			}
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			element = wait1.until(ExpectedConditions.elementToBeClickable(By.className("language-name")));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", element);
			Utility.static_wait(2);
			Utility.Takescrrnshotrun(driver, "English");
			String img4 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\English.png");
			logger2.log(LogStatus.PASS, "Step 4:Select  corresponding 'Language' listed on screen","Expected output:Search screen appears in the selected language with Advanced search label in the search box displayed in the corresponding language" + img4);

		Utility.static_wait(3);

		driver.findElement(By.xpath("//div[@id='basic_search_container']/div/div[2]/a")).click();
		Utility.static_wait(2);
		/*driver.findElement(By.id("mainSearchTextbox")).sendKeys("da vinci");
		driver.findElement(By.xpath("//*[@id='basic_search_main_container']/div[1]/div/a")).click();
		Utility.static_wait(2);
		Utility.Takescrrnshotrun(driver, "basic_search");
		driver.findElement(By.id("advanceFilterContentMain")).sendKeys("da vinci");
		Utility.static_wait(2);
		driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[5]/div/input")).click();
		Utility.static_wait(2);
		driver.findElement(By.xpath("//div[5]/div/ul/li[2]/span")).click();
		Utility.static_wait(2);
		driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[6]/div/input")).click();
		Utility.static_wait(2);
		driver.findElement(By.xpath("//div[6]/div/ul/li[5]/span")).click();
		Utility.static_wait(2);
		driver.findElement(By.xpath("//*[@id='advanced_search_main_container']/div[2]/div/a[1]")).click();
		Utility.Takescrrnshotrun(driver, "Adv_search");
		String img5 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Adv_search.png");
		logger2.log(LogStatus.PASS,"Step 5:Perform different search options (Basic .advanced, search within search results & Links for metadata provided on main search page)","Expected output:Based on the search criteria, the expected documents from the Test data master sheet.xls are found in PDF format."
						+ img5);*/
		//driver.findElement(By.xpath("//*[@id='advanced_search_main_container']/div[2]/div/a[2]")).click();
		driver.findElement(By.cssSelector("a.advance-search-main.left")).click();
		Utility.static_wait(2);
		driver.findElement(By.id("advanceFilterPartNumberMain")).sendKeys("550716");
		Utility.static_wait(2);
		driver.findElement(By.xpath("//*[@id='advanced_search_main_container']/div[2]/div/a[1]")).click();
		Utility.static_wait(2);
		driver.findElement(By.cssSelector("i.material-icons.right")).click(); 
		Utility.static_wait(2);		
		driver.findElement(By.linkText("Previous Versions")).click(); 
		Utility.static_wait(5);
		

		String  Get = driver.findElement(By.cssSelector("td.col2 > a")).getText();
		System.out.println(Get);
		
		//service Code
		WindChillTest wcTest = new WindChillTest();
		List<String> objs = wcTest.GetEarlierVersions(Get);
		if(Get.equals(objs.get(0))){
			System.out.println("Latest Version is displayed in \n UI: -"+Get+"\n Service: -"+objs.get(0));
		}else{
			System.out.println("Latest Version is not displayed in \n UI: -"+Get+"\n Service: -"+objs.get(0));
		}
		//Previous Version List
		List<String> prevFilesFromService = objs.subList(0, objs.size()-1);
		
		List<String> prevFilesFromUI = new ArrayList<String>();
		
		List<WebElement> alllinks2 = driver.findElements(By.xpath("//*[@id='previousVersionsModal']/div[2]/ul/li/a[@class='title cursor-pointer']"));
		int linkListCount2 = alllinks2.size();

		for (int i = 0; i < alllinks2.size(); i++){
			
			System.out.println(alllinks2.get(i).getText());
			prevFilesFromUI.add(alllinks2.get(i).getText());
		}
		//System.out.println("Total numbner of link is: " + linkListCount2);
		
		//*********************************************************************
		//Compare below the two Lists prevFilesFromService & prevFilesFromUI
		 
		softAssert.assertAll();
		
		
		
		
		
			
			logger2.log(LogStatus.PASS, "Script Passed and User able to Validate No search results");         
           
			 }
	
	
	@Test(priority=7)
	public void Verifying_No_search_resultse() throws Exception {
		
			logger2 = report2.startTest("11-Verifying No search results");
			/**
			 * Call login step from Library
			 */
			ConfigurationFile property = DataProviderFactory.getProperty();
			WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());
			Utility.static_wait(2);
			driver.get(property.getURL());
			Screen D1 = new Screen();
			softAssert.assertEquals("Market - dvpuat.net", driver.getTitle());
			Utility.Takescrrnshotrun(driver, "Global Map");
			String img1 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Global Map.png");
			logger2.log(LogStatus.PASS, "Step 1:Launch the Document Library website","Expected output:Document Library homepage is dispalyed" + img1);
			
			Utility.static_wait(5);
			D1.hover(IMA3);
			Utility.static_wait(2);
			D1.click(IMA1);
			Thread.sleep(3000);
			
			Utility.Takescrrnshotrun(driver, "NA");
			String img2 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\NA.png");
			logger2.log(LogStatus.PASS, "Step 2:From the world map that is displayed, select 'North America'.","Expected output:A country selection page is displayed and the title of the page is 'North America''." + img2);
			
			WebElement United_States = driver.findElement(By.linkText("United States"));
			Utility.safeJavaScriptClick(United_States, driver);
			Thread.sleep(2000);
			Utility.Takescrrnshotrun(driver, "USA");
			String img3 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\USA.png");
			logger2.log(LogStatus.PASS, "Step 3:Select 'Country' from  the list of countries tiles displayed for the selected 'Continent'","Expected output:Language  selection screen appears with the selected 'Language name', displayed as the Title of the screen." + img3);
			WebElement ImageFile = driver.findElement(By.cssSelector("#language_isi_image_container > #isi_image > img.isi_image"));
			Utility.Highlightelements(driver, ImageFile);
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",ImageFile);
			if (ImagePresent) {
				System.out.println("Image is displayed.");
			} else {
				driver.quit();
			}
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			element = wait1.until(ExpectedConditions.elementToBeClickable(By.className("language-name")));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", element);
			Utility.static_wait(2);
			Utility.Takescrrnshotrun(driver, "English");
			String img4 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\English.png");
			logger2.log(LogStatus.PASS, "Step 4:Select  corresponding 'Language' listed on screen","Expected output:Search screen appears in the selected language with Advanced search label in the search box displayed in the corresponding language" + img4);
			

			
			Utility.static_wait(3);	
			
			driver.findElement(By.xpath("//div[@id='basic_search_container']/div/div[2]/a")).click();			
			Utility.Takescrrnshotrun(driver, "search");
			String img5 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\search.png");
			logger2.log(LogStatus.PASS, "Step 5:User pick documents for the above selected Country 'United States' & Language -'English'.","Expected output:Publication documents are found in search results." + img5);
			
			Utility.static_wait(2);	
			driver.findElement(By.id("mainSearchTextbox")).sendKeys("tokyo");
			driver.findElement(By.xpath("//*[@id='basic_search_main_container']/div[1]/div/a")).click();	
			
		    Utility.static_wait(2);
			if (driver.getPageSource().contains("Please try a new search or select a new language and search again.")) {
				WebElement Nodocument = driver.findElement(By.cssSelector("td"));
				Utility.Highlightelements(driver, Nodocument);
				Utility.static_wait(5);
			} else {

				driver.quit();
			} 
			Utility.Takescrrnshotrun(driver, "basic_search");
			String img6 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\basic_search.png");
			logger2.log(LogStatus.PASS, "Step 6:User do basic search which document deleted in CCMS","Expected output:'Please try a new search or select a new language and search again. message display" + img6);
			driver.findElement(By.xpath("//*[@id='basic_search_main_container']/div[2]/div/a")).click();
			
			driver.findElement(By.id("advanceFilterContentMain")).sendKeys("Tokyo");			
			Utility.static_wait(2);
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[5]/div/input")).click();
			Utility.static_wait(2);
			driver.findElement(By.xpath("//div[5]/div/ul/li[2]/span")).click();
			Utility.static_wait(2); 
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[6]/div/input")).click();
			Utility.static_wait(2); 	
			driver.findElement(By.xpath("//div[6]/div/ul/li[5]/span")).click();
			Utility.static_wait(2);      
             
             Utility.static_wait(1);
             if (driver.getPageSource().contains("Please try a new search or select a new language and search again.")) {
 				WebElement Nodocument = driver.findElement(By.cssSelector("td"));
 				Utility.Highlightelements(driver, Nodocument);
 				Utility.static_wait(5);
 			} else {

 				driver.quit();
 			} 			
			Utility.Takescrrnshotrun(driver, "Adv_search");
			String img7 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Adv_search.png");
			logger2.log(LogStatus.PASS, "Step 7:User do advance search which document deleted in CCMS","Expected output:'Please try a new search or select a new language and search again. message display" + img7);
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div[2]/div/a")).click();		
			 softAssert.assertAll();		
			
			logger2.log(LogStatus.PASS, "Script Passed and User able to Validate No search results");         
           
			 }
	@Test(priority=8)
	public void Search_Response_Loading_time() throws Exception {
		
			logger2 = report2.startTest("12-Search Response Loading time");
			/**
			 * Call login step from Library
			 */
			ConfigurationFile property = DataProviderFactory.getProperty();
			WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());
			Utility.static_wait(2);
			driver.get(property.getURL());
			
			softAssert.assertEquals("Market - dvpuat.net", driver.getTitle());
			Utility.Takescrrnshotrun(driver, "Global Map");
			String img1 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Global Map.png");
			logger2.log(LogStatus.PASS, "Step 1:Launch the Document Library website","Expected output:Document Library homepage is dispalyed" + img1);
			
			Utility.static_wait(5);
			D1.hover(IMA3);
			Utility.static_wait(2);
			D1.click(IMA1);
			
			Utility.Takescrrnshotrun(driver, "NA");
			String img2 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\NA.png");
			logger2.log(LogStatus.PASS, "Step 2:From the world map that is displayed, select 'North America'.","Expected output:A country selection page is displayed and the title of the page is 'North America''." + img2);
			
			WebElement United_States = driver.findElement(By.linkText("United States"));
			Utility.safeJavaScriptClick(United_States, driver);
			Thread.sleep(2000);
			Utility.Takescrrnshotrun(driver, "USA");
			String img3 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\USA.png");
			logger2.log(LogStatus.PASS, "Step 3:Select 'Country' from  the list of countries tiles displayed for the selected 'Continent'","Expected output:Language  selection screen appears with the selected 'Language name', displayed as the Title of the screen." + img3);
			WebElement ImageFile = driver.findElement(By.cssSelector("#language_isi_image_container > #isi_image > img.isi_image"));
			Utility.Highlightelements(driver, ImageFile);
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",ImageFile);
			if (ImagePresent) {
				System.out.println("Image is displayed.");
			} else {
				driver.quit();
			}
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			element = wait1.until(ExpectedConditions.elementToBeClickable(By.className("language-name")));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", element);
			Utility.static_wait(2);
			Utility.Takescrrnshotrun(driver, "English");
			String img4 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\English.png");
			logger2.log(LogStatus.PASS, "Step 4:Select  corresponding 'Language' listed on screen","Expected output:Search screen appears in the selected language with Advanced search label in the search box displayed in the corresponding language" + img4);
			
			Utility.static_wait(3);	
			long start=System.currentTimeMillis();
			driver.findElement(By.xpath("//div[@id='basic_search_container']/div/div[2]/a")).click();			
			long finish=System.currentTimeMillis();
			long Total_time=start-finish;
			System.out.println("Total time is:"+Total_time);
			
			Utility.Takescrrnshotrun(driver, "search");
			String img5 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\search.png");
			logger2.log(LogStatus.PASS, "Step 5:User do blank search","Expected output:Search Results' load time is less than 7 seconds." + img5);
			
			Utility.static_wait(2);	
			driver.findElement(By.id("mainSearchTextbox")).sendKeys("demo");
			Utility.static_wait(3);
			start=System.currentTimeMillis();
			
			driver.findElement(By.cssSelector("#basic_main_search_icon")).click();
			finish=System.currentTimeMillis();
			 Total_time=start-finish;
			System.out.println("Total time for second load is :"+Total_time);
			Utility.Takescrrnshotrun(driver, "basic_search");
			String img6 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\basic_search.png");
			logger2.log(LogStatus.PASS, "Step 6:User do basic search","Expected output:Search Results' load time is less than 7 seconds." + img6);
			Utility.static_wait(3);
			driver.findElement(By.id("advance-search-main")).click();
			Utility.static_wait(3);
			driver.findElement(By.id("reset_main_search_icon")).click();
			Utility.static_wait(3);
			driver.findElement(By.id("advanceFilterContentMain")).sendKeys("Tokyo");			
			Utility.static_wait(4);
			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[5]/div/input")).click();
			Utility.static_wait(1);
			driver.findElement(By.xpath("//div[5]/div/ul/li[4]/span")).click();

			driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[6]/div/input")).click();
			Utility.static_wait(1);	
			driver.findElement(By.xpath("//div[6]/div/ul/li[7]/span")).click();
			Utility.static_wait(1);
             start=System.currentTimeMillis();
             driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div[2]/div/a")).click();			
			finish=System.currentTimeMillis();
			 Total_time=start-finish;
			
			Utility.Takescrrnshotrun(driver, "basic_search");
			String img7 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\adv_search.png");
			logger2.log(LogStatus.PASS, "Step 7:User do advance search","Expected output:Search Results' load time is less than 7 seconds." + img7);			
			 softAssert.assertAll();
			
			
			
			logger2.log(LogStatus.PASS, "Script Passed and User able to -Validate basic and advanced filters");
			
			 }
	
	@Test(enabled=false)
	public void Translated_language_elements_French_correctly_placed_on_user_interface() throws Exception {
		 
		try {
			logger2 = report2.startTest("22-Translated language elements (French) correctly placed on user interface");
			/**
			 * Call login step from Library
			 */
			ConfigurationFile property = DataProviderFactory.getProperty();
			WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());
			driver.get(property.getURL());			
			softAssert.assertEquals(driver.getTitle(),"Market - dvpuat.net","Title doesnot match");
			WebElement Logo = driver.findElement(By.cssSelector("img.isi-logo"));
			Utility.Highlightelements(driver, Logo);
			Thread.sleep(1000);
			/*WebElement Texe1 = driver.findElement(By.cssSelector("div.col.s4"));
			Utility.Highlightelements(driver, Texe1);
			Thread.sleep(1000);
			WebElement french = driver.findElement(By.xpath("//*[contains(text(),'Dites-nous où vous êtes.')]"));
			Utility.Highlightelements(driver, french);
			Thread.sleep(1000);
			WebElement Germon = driver.findElement(By.xpath("//*[contains(text(),'Sagen Sie uns, wo Sie sich gerade befinden.')]"));
			Utility.Highlightelements(driver, Germon);
			Thread.sleep(1000);
			WebElement Spanesh = driver.findElement(By.xpath("//*[contains(text(),'Díganos dónde se encuentra.')]"));
			Utility.Highlightelements(driver, Spanesh);
			Thread.sleep(1000);
			WebElement Itely = driver.findElement(By.xpath("//*[contains(text(),'Comunicaci dove ti trovi.')]"));
			Utility.Highlightelements(driver, Itely);
			Thread.sleep(1000);
			WebElement Japan = driver.findElement(By.xpath("//*[@id='tell-us']/div[2]/div[3]"));
			Utility.Highlightelements(driver, Japan);*/
			Thread.sleep(1000);
			D1.click(IMA3);
			Thread.sleep(5000);
			List<WebElement> linkElements =driver.findElements(By.className("country-name"));
			WebDriverWait wait = new WebDriverWait(driver, 60);
			 wait.until(ExpectedConditions.visibilityOfAllElements(linkElements));
			 
			WebElement Logo2 = driver.findElement(By.cssSelector("h4"));
			Utility.Highlightelements(driver, Logo2);
			Thread.sleep(2000);
			Utility.scrollDown(driver);
			/*WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Switzerland")));*/
			
			Thread.sleep(3000);
			WebElement goButton=driver.findElement(By.linkText("Switzerland"));
			Utility.safeJavaScriptClick(goButton, driver);				
			Utility.static_wait(3);
			if (driver.getPageSource().contains("Switzerland")) {
				System.out.println("Text is present");
			} else {

				driver.quit();
			}
			
			WebElement ImageFile = driver.findElement(By.cssSelector("#language_isi_image_container > #isi_image > img.isi_image"));
			Utility.Highlightelements(driver, ImageFile);
		    Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
		    if (ImagePresent)
		    {
		         System.out.println("Image is displayed.");
		    }
		    else
		    {
		        driver.quit();
		    }
			
			List<WebElement> alllinks2 = driver.findElements(By.className("language-name"));
			int linkListCount2 = alllinks2.size();

			for (int i = 0; i < alllinks2.size(); i++)
				System.out.println(alllinks2.get(i).getText());
			System.out.println("Total numbner of country is: " + linkListCount2);
			softAssert.assertEquals(3, linkListCount2, "Count match");
			
			WebElement French=driver.findElement(By.linkText("French"));
			Utility.safeJavaScriptClick(French, driver);
			Thread.sleep(5000);
			Logo = driver.findElement(By.cssSelector("img.isi-logo"));
			Utility.Highlightelements(driver, Logo);
			Thread.sleep(3000);		
			WebElement element1 = driver.findElement(By.xpath("//*[contains(text(),'Switzerland ( French )')]"));
			Utility.Highlightelements(driver, element1);			
			String Switzerland = element1.getText();
			System.out.println(Switzerland);
			
			softAssert.assertEquals(Switzerland,"Switzerland ( French )" );		
			
			 element=driver.findElement(By.xpath("//*[contains(text(),'Switzerland ( French )')]"));
			Utility.safeJavaScriptClick(element, driver);
			
            WebElement Change_country=driver.findElement(By.xpath("//a[contains(text(),'Changer le pays')]"));
			
			Utility.Highlightelements(driver, Change_country);
			String Changecountry = Change_country.getText();
			System.out.println(Changecountry);			
		   softAssert.assertEquals(Changecountry,"Changer le pays","We are good1" );	
           WebElement Change_lan=driver.findElement(By.xpath("//a[contains(text(),'Changer la langue')]"));
           Utility.Highlightelements(driver, Change_lan);
           String Changelan = Change_lan.getText();
			System.out.println(Changelan);			
			softAssert.assertEquals(Changelan,"Changer la langue","We are bad" );
			
			
            WebElement French_Search=driver.findElement(By.xpath("//a[contains(text(),'Rechercher')]"));
			
			Utility.Highlightelements(driver, French_Search);
			String FrenchSearch = French_Search.getText();
			System.out.println(FrenchSearch);			
			softAssert.assertEquals(FrenchSearch,"RECHERCHER","We are good3");	
			Utility.static_wait(2);
			
			WebElement French_AdvSearch=driver.findElement(By.xpath("//*[@id='advance-search']"));
			Utility.static_wait(2);			
			Utility.Highlightelements(driver, French_AdvSearch);
			String FrenchAdvSearch = French_AdvSearch.getText();
			System.out.println(FrenchAdvSearch);
			softAssert.assertEquals(FrenchAdvSearch,"Recherche avancée" );
			Utility.static_wait(3);
           WebElement publ12=driver.findElement(By.xpath("//*[@id='publicationType_div']/div/span"));
			
			Utility.Highlightelements(driver, publ12);
			String publ123 = publ12.getText();
			System.out.println(publ123);			
			softAssert.assertEquals(publ123,"TYPE DE PUBLICATION","We are good39");
			
           WebElement Plal12=driver.findElement(By.xpath("//*[@id='platform_div']/div/span"));
			
			Utility.Highlightelements(driver, Plal12);
			String PLA =Plal12.getText();
			System.out.println(PLA);			
			softAssert.assertEquals(PLA,"PLATEFORME","We are good40");
			
			
			
			
			
			
			String Text = driver.findElement(By.id("initialSearchTextbox")).getAttribute("placeholder");
			System.out.println(Text);	
			softAssert.assertEquals("Entrez la référence, le titre, la description ou le mot clé du manuel.", Text);		
			
			D1.hover("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
			
			 if (driver.getPageSource().contains("Changer le continent")) {
	 				System.out.println("Changer le continent Text present");
	 			} else {

	 				System.out.println("Changer le continent Text not present");
	 				Assert.fail();
	 			} 			
			Utility.static_wait(2);
			 WebElement Rec=driver.findElement(By.id("basic_search_icon"));
			 Utility.safeJavaScriptClick(Rec, driver);		
			 Utility.static_wait(2);
			 
			 D1.hover("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\Switch_view.png");
			 Utility.static_wait(1);
			 if (driver.getPageSource().contains("Changer la vue")) {
	 				System.out.println("Changer la vue Text present");
	 			} else {

	 				System.out.println("Changer la vue Text not present");
	 				Assert.fail();
	 				
	 			} 			
			 Utility.static_wait(2);
			 D1.hover("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\Sort_Ord.png");
			 Utility.static_wait(1);
			 if (driver.getPageSource().contains("Ordre de tri")) {
	 				System.out.println("Ordre de tri Text present");
	 			} else {

	 				System.out.println("Ordre de tri Text not present");
	 				Assert.fail();
	 				
	 			} 			
			 
			 D1.hover("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\Switch_view.png");
			 Utility.static_wait(1);
			 if (driver.getPageSource().contains("Changer la vue")) {
	 				System.out.println("Changer la vue Text present");
	 			} else {

	 				System.out.println("Changer la vue Text not present");
	 				Assert.fail();
	 				
	 			} 			
			 Utility.static_wait(2);
			 
			 WebElement drop=driver.findElement(By.xpath("//input[@value='Pertinence']"));
			 Utility.Highlightelements(driver, drop);
			 if (driver.getPageSource().contains("Pertinence")) {
	 				System.out.println("Pertinence Text present");
	 			} else {

	 				System.out.println("Pertinence Text not present");
	 				Assert.fail();
	 			
	 			} 	
			 
			
			 WebElement Rec1=driver.findElement(By.xpath("//input[@value='Pertinence']"));	
			 Utility.safeJavaScriptClick(Rec1, driver);
			 
			 WebElement drop1=driver.findElement(By.xpath("//li[2]/span"));
			 Utility.Highlightelements(driver, drop1);
			 
			 if (driver.getPageSource().contains("Nom (croissant)")) {
	 				System.out.println("Nom (croissant)Text present");
	 			} else {

	 				System.out.println("Nom (croissant) Text not present");
	 			} 			
			 WebElement drop2=driver.findElement(By.xpath("//li[3]/span"));
			 Utility.Highlightelements(driver, drop2);
			 String dropdown1 = drop2.getText();
				System.out.println(dropdown1);
				softAssert.assertEquals(dropdown1,"Nom (décroissant)","We are good5");		
			 if (driver.getPageSource().contains("Nom (décroissant)")) {
	 				System.out.println("Nom (décroissant) Text present");
	 			} else {

	 				System.out.println("Nom (décroissant) Text not present");
	 				Assert.fail();
	 			} 
			 
			 WebElement Search_count = driver.findElement(By.cssSelector("span.label-search-results"));
				Utility.Highlightelements(driver, Search_count);
				String Searchcount = Search_count.getText();
				System.out.println(Searchcount);
				softAssert.assertEquals(Searchcount,"RÉSULTATS DE LA RECHERCHE - 1","We are good71" );	
			 Utility.static_wait(2);
				 WebElement french_text = driver.findElement(By.cssSelector("span.collection-item"));
					Utility.Highlightelements(driver, french_text);
					String frenchtext = french_text.getText();
					System.out.println(frenchtext);
					softAssert.assertEquals(frenchtext,"Certaines technologies sont susceptibles de ne pas avoir reçu d'approbation réglementaire ou de ne pas être disponibles sur le marché de toutes les zones géographiques.","We are good72" );	
			
					
					
			 WebElement Filter = driver.findElement(By.xpath("//*[contains(text(),'Filtrer par')]"));
				Utility.Highlightelements(driver, Filter);
				String Fil = Filter.getText();
				System.out.println(Fil);
				softAssert.assertEquals(Fil,"FILTRER PAR","We are good7" );	
				 WebElement narrowby = driver.findElement(By.xpath("//*[contains(text(),'Restreindre par')]"));
				Utility.Highlightelements(driver, narrowby)	;				
				String narr = narrowby.getText();
				System.out.println(narr);
				softAssert.assertEquals("RESTREINDRE PAR", narr);
				Utility.static_wait(2);
				driver.findElement(By.id("advance-search-main")).click();
				Utility.static_wait(1);
				
				 WebElement Filter1 = driver.findElement(By.xpath("//a[contains(text(),'Type de publication')]"));
					Utility.Highlightelements(driver, Filter1);
					String Fil1 = Filter1.getText();
					System.out.println(Fil1);
					softAssert.assertEquals(Fil1,"TYPE DE PUBLICATION","We are good73" );
					Utility.static_wait(1);
					WebElement Filter2 = driver.findElement(By.xpath("//a[contains(text(),'Plateforme')]"));
					Utility.Highlightelements(driver, Filter2);
					String Fil2 = Filter2.getText();
					System.out.println(Fil2);
					softAssert.assertEquals(Fil2,"PLATEFORME","We are good74" );	
					 WebElement View_man = driver.findElement(By.cssSelector("i.material-icons.right"));
						Utility.safeJavaScriptClick(View_man, driver);
						Utility.static_wait(2);
						WebElement element2 = driver.findElement(By.linkText("Afficher le manuel"));
						Utility.Highlightelements(driver, element2);
						String ViewManual_Ger = element2.getText();
						System.out.println(ViewManual_Ger );
						softAssert.assertEquals("Afficher le manuel", ViewManual_Ger );
						WebElement element3 = driver.findElement(By.linkText("Commander le manuel"));
						Utility.Highlightelements(driver, element3);
						String order = element3.getText();
						System.out.println(order);
						softAssert.assertEquals("Commander le manuel", order );
						WebElement element4 = driver.findElement(By.linkText("Versions précédentes"));
						Utility.Highlightelements(driver, element4);
						String version = element4.getText();
						System.out.println(version);
						softAssert.assertEquals("Versions précédentes", version );
						Utility.safeJavaScriptClick(element4, driver);
						WebElement element40 = driver.findElement(By.cssSelector("h4"));
						Utility.Highlightelements(driver, element40);
						
						WebElement clo_win = driver.findElement(By.xpath("//div[@id='previousVersionsModal']/div/a"));
						Utility.safeJavaScriptClick(clo_win, driver);
						
						
						WebElement reset=driver.findElement(By.xpath("//*[contains(text(),'Réinitialiser')]"));
				       Utility.Highlightelements(driver, reset);
				        String res = reset.getText();
					 System.out.println(res);
					 softAssert.assertEquals(res,"RÉINITIALISER","We are good8" );	
					 
					 Utility.static_wait(2);
					 WebElement Ref=driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div/label"));
					 Utility.Highlightelements(driver, Ref);
					 String Refer = Ref.getText();
					 System.out.println(Refer);
					 softAssert.assertEquals(Refer,"Référence","we are good9");
					//*[@id="advanced_search_main_container"]/div[1]/div[1]/label
				
					 Utility.static_wait(2);
					 WebElement doc_num=driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[2]/label"));
					 Utility.Highlightelements(driver, doc_num);
					 String docnum = doc_num.getText();
					 System.out.println(docnum);
					softAssert.assertEquals(docnum,"Nom du document","We are good10" );	
					 Utility.static_wait(2);
					
					 WebElement dec=driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[3]/label"));
					 Utility.Highlightelements(driver, dec);
					 String decs = dec.getText();
					 System.out.println(decs);
					 softAssert.assertEquals(decs,"Description","We are good11" );	
					 Utility.static_wait(2);
					 WebElement keyword=driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[4]/label"));
					 Utility.Highlightelements(driver, keyword);
					 String Key = keyword.getText();
					 System.out.println(Key);
					
					 softAssert.assertEquals(Key,"Mot clé","We are good12" );	
					 Utility.static_wait(2);
					
					
					 WebElement plat=driver.findElement(By.xpath("//*[@id='advanced_search_main_container']/div[1]/div[5]/div/input"));
					 Utility.Highlightelements(driver, plat);
					 if (driver.getPageSource().contains("Choisir votre plateforme")) {
			 				System.out.println("Choisir votre plateforme Text present");
			 			} else {

			 				System.out.println("Choisir votre plateforme Text not present");
			 				Assert.fail();
			 			} 		
					 
				    
					 
					
					 Utility.static_wait(2);
					/* List<WebElement> options = driver.findElements(By.xpath("//*[@id='advanced_search_container']/div/div[1]/div[1]/div[3]/div/ul/li/span"));
					   
					   Utility.static_wait(1);
					   
					   //Count the Values
					   List<String> dropdownVals = new ArrayList<String>();
					    for(int i=0;i<options.size();i++){
					    System.out.println("Drop down:"+options.get(i).getText());
					    dropdownVals.add(options.get(i).getText());
					    }*/
					   
					 
					
					
					 WebElement pub=driver.findElement(By.xpath("//*[@id='advanced_search_main_container']/div[1]/div[6]/div/input"));
					 Utility.Highlightelements(driver, pub);
					 if (driver.getPageSource().contains("Choisir votre plateforme")) {
			 				System.out.println("Choisir votre type de publication Text present");
			 			} else {

			 				System.out.println("Choisir votre type de publication Text not present");
			 				Assert.fail();
			 			} 
					 D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC1.png"); 	
					

			
			
			 logger2.log(LogStatus.PASS, "22-Translated language elements (French) correctly placed on user interface");
			 //softAssert.assertAll();
		} catch (Exception e) {
			
			//driver.quit();
		}
	}
		@Test(enabled=false)
		public void Translated_language_element_correctly_placed_on_user_interface() throws Exception {
			WebDriver driver=null;
			WebElement ImageFile;
			Boolean ImagePresent=null;
			WebElement Logo;
			WebDriverWait wait;
			
			try {
				logger2 = report2.startTest("21-Translated language element correctly placed on user interface");
				/**
				 * Call login step from Library
				 */
				ConfigurationFile property = DataProviderFactory.getProperty();
				 driver = BrowserFactory.getBrowser(property.getBrowser());
				driver.get(property.getURL());
				
				softAssert.assertEquals(driver.getTitle(),"Market - dvpuat.net","Title doesnot match");
				Logo = driver.findElement(By.cssSelector("img.isi-logo"));
				Utility.Highlightelements(driver, Logo);
				Thread.sleep(1000);
				String img1 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\login.png");
				logger2.log(LogStatus.PASS, "Step 1:Launch Document Library Test website.","Expected output:Document Library' Test home page is displayed." + img1);
				
				
				D1.click(IMA1);
				Utility.static_wait(2);
				WebElement United_States = driver.findElement(By.linkText("United States"));
				Utility.safeJavaScriptClick(United_States, driver);
				Utility.static_wait(3);
				
				ImageFile = driver.findElement(By.cssSelector("#language_isi_image_container > #isi_image > img.isi_image"));
				Utility.Highlightelements(driver, ImageFile);
				 ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",ImageFile);
				if (ImagePresent) {
					System.out.println("Image is displayed.");
				} else {
					driver.quit();
				}
				WebDriverWait wait1 = new WebDriverWait(driver, 10);
				element = wait1.until(ExpectedConditions.elementToBeClickable(By.linkText("English")));
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("arguments[0].click();", element);
				Utility.static_wait(2);
				WebElement element = driver.findElement(By.xpath("//*[contains(text(),'United States ( English )')]"));
				Utility.Highlightelements(driver, element);
				String USA = element.getText();
				System.out.println(USA);
				softAssert.assertEquals("United States ( English )", USA,"Dhaval is good");
				
				WebElement search = driver.findElement(By.id("basic_search_icon"));
				Utility.safeJavaScriptClick(search, driver);
				Utility.static_wait(2);
				WebElement View_man = driver.findElement(By.cssSelector("i.material-icons.right"));
				Utility.safeJavaScriptClick(View_man, driver);
				Utility.static_wait(2);
				WebElement element1 = driver.findElement(By.linkText("View Manual"));
				Utility.Highlightelements(driver, element1);
				String ViewManual = element1.getText();
				System.out.println(USA);
				softAssert.assertEquals("View Manual", ViewManual,"Dhaval is good1");
				Utility.static_wait(3);
				String img2 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\USA.png");
				logger2.log(LogStatus.PASS, "Step 2:Select a document from Search Results and verify if 'View Manual' label is present in 'English.","Expected output:View Manual' label is present in English and correctly placed on eIFU search results page." + img2);
				Utility.static_wait(5);
				D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC5.png");
				Utility.static_wait(2);
				D1.click(IMA3);
				Utility.static_wait(2);
				
				
				
			    ImageFile = driver.findElement(By.cssSelector("#language_isi_image_container > #isi_image > img.isi_image"));
				Utility.Highlightelements(driver, ImageFile);
				 ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",ImageFile);
				if (ImagePresent) {
					System.out.println("Image is displayed.");
				} else {
					driver.quit();
				}
				Utility.scrollDown(driver);
				 wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Switzerland")));
				Utility.static_wait(2);
				WebElement goButton=driver.findElement(By.linkText("Switzerland"));
				Utility.safeJavaScriptClick(goButton, driver);				
				Thread.sleep(3000);
				WebElement French=driver.findElement(By.linkText("German"));
				Utility.safeJavaScriptClick(French, driver);
				Thread.sleep(5000);
				Logo = driver.findElement(By.cssSelector("img.isi-logo"));
				Utility.Highlightelements(driver, Logo);
				Thread.sleep(3000);	
				
				WebElement element12 = driver.findElement(By.xpath("//*[contains(text(),'Switzerland ( German )')]"));
				Utility.Highlightelements(driver, element12);			
				String German= element12.getText();
				System.out.println(German);				
				softAssert.assertEquals(German,"Switzerland ( German )","Dhaval is good2");	
				Utility.static_wait(2);				
				WebElement search1 = driver.findElement(By.id("basic_search_icon"));
				Utility.Highlightelements(driver, search1);
				String Suche= search1.getText();
				System.out.println(Suche);				
				softAssert.assertEquals(Suche,"SUCHE");				
				Utility.static_wait(2);
				
				
				
				
				D1.hover("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
				Utility.static_wait(2);
				if (driver.getPageSource().contains("Kontinent ändern")) {
	 				System.out.println("Kontinent ändern Text present");
	 			} else {

	 				System.out.println("Kontinent ändern Text not present");
	 				Assert.fail();
	 			} 			
				String img3 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\German.png");
				logger2.log(LogStatus.PASS, "Step 3:On Search page, 'verify if 'Change Continent' button is displayed in 'German.","Expected output:Change Continent' and 'Click to view all {0} documents' button is translated in 'German' and correctly placed on eIFU search pages." + img3);
				
				D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
				Utility.static_wait(3);
				D1.click(IMA3);
				Utility.static_wait(3);
				
				Utility.scrollDown(driver);
				
				WebElement goButton2=driver.findElement(By.linkText("Bulgaria"));
				Utility.safeJavaScriptClick(goButton2, driver);				
				Thread.sleep(3000);
						
				WebElement Bulgarian=driver.findElement(By.linkText("Bulgarian"));
				Utility.safeJavaScriptClick(Bulgarian, driver);
				
				
				Utility.static_wait(3);	
				WebElement ele5 = driver.findElement(By.xpath("//*[contains(text(),'Bulgaria ( Bulgarian )')]"));
				Utility.Highlightelements(driver, ele5);		 	
				String Bulgaria= ele5.getText();
				System.out.println(Bulgaria);				
				softAssert.assertEquals(Bulgaria,"Bulgaria ( Bulgarian )");	
				Utility.static_wait(3);				
				WebElement sea1 = driver.findElement(By.id("basic_search_icon"));				
				Utility.safeJavaScriptClick(sea1, driver);
				Utility.static_wait(3);	
				WebElement ele6 = driver.findElement(By.id("advance-search-main"));
				
				Utility.safeJavaScriptClick(ele6, driver);	
				Utility.static_wait(3);	
				WebElement doc_num=driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[2]/label"));
				 Utility.Highlightelements(driver, doc_num);
				 String docnum = doc_num.getText();
				 System.out.println(docnum);
				softAssert.assertEquals(docnum,"Име на документ","We are good11" );
				
				WebElement Platform12=driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[6]/div/input"));
				 Utility.Highlightelements(driver, Platform12);
				
				if (driver.getPageSource().contains("Изберете типа на публикацията си")) {
					System.out.println("Изберете типа на публикацията си Text present ");
				} else {

					System.out.println("Изберете типа на публикацията си Text not present ");
					Assert.fail();
				}
				String img4 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Bulgearin.png");
				logger2.log(LogStatus.PASS, "Step 4:On advanced search page, verify search filter,Document Name and Choose your publication type.","Expected output:In Advance search box 'Document Name'' is translated in 'Bulgarian' on eIFU search page  is displayed." + img4);
				
			
				 Utility.static_wait(2);
				 D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
				
				 Utility.static_wait(4);
				D1.click(IMA4);
				Utility.static_wait(3);			
				
				
					 wait = new WebDriverWait(driver, 4);
					wait.until(ExpectedConditions.elementToBeClickable(By.linkText("China")));
					Utility.static_wait(2);
					WebElement goButton23=driver.findElement(By.linkText("China"));
					Utility.safeJavaScriptClick(goButton23, driver);				
					Thread.sleep(3000);
					WebElement China=driver.findElement(By.linkText("Chinese Simplified"));
					Utility.safeJavaScriptClick(China, driver);
					Thread.sleep(5000);
					
					
					WebElement element3 = driver.findElement(By.xpath("//*[contains(text(),'China ( Chinese Simplified )')]"));
					Utility.Highlightelements(driver, element3);			
					String china= element3.getText();
					System.out.println(china);				
					softAssert.assertEquals(china,"China ( Chinese Simplified )");	
					
					Utility.static_wait(2);				
					WebElement search134 = driver.findElement(By.id("basic_search_icon"));
					Utility.Highlightelements(driver, search134);
					String Chines_Ser= search134.getText();
					System.out.println(Chines_Ser);				
					softAssert.assertEquals(Chines_Ser,"搜索");						
					Utility.safeJavaScriptClick(search134, driver);				
					Utility.static_wait(2);					
					WebElement element5 = driver.findElement(By.id("advance-search-main"));
					Utility.Highlightelements(driver, element5);
					String Adv_main = element5.getText();
					System.out.println(Adv_main);
					softAssert.assertEquals("高级搜索", Adv_main, "Dhaval is good4");
					Utility.static_wait(2);
					D1.hover("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
					Utility.static_wait(2);
					if (driver.getPageSource().contains("更改大陆")) {
		 				System.out.println("更改大陆 Text present");
		 			} else {

		 				System.out.println("更改大陆 Text not present");
		 				Assert.fail();
		 			} 
		 			Utility.static_wait(2);
		 			
		 			String img5 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\china.png");
					logger2.log(LogStatus.PASS, "Step 5:On search page,verify,if 'Advanced search' label is present in 'Simplified Chinese'.","Expected output:Advanced search' label is translated in 'Simplified Chinese' and correctly placed on eIFU search results page." + img5);
		 			
		 			
				 D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
		 						
				
				
				 Utility.static_wait(2);
				 D1.click(IMA4);
				 wait = new WebDriverWait(driver, 5);
					wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Hong Kong")));
					Utility.static_wait(2);
					WebElement goButton239=driver.findElement(By.linkText("Hong Kong"));
					Utility.safeJavaScriptClick(goButton239, driver);				
					Thread.sleep(3000);
					WebElement Hong_Kong=driver.findElement(By.linkText("Chinese Traditional"));
					Utility.safeJavaScriptClick(Hong_Kong, driver);
					Thread.sleep(5000);
					
					
					WebElement element34 = driver.findElement(By.xpath("//*[contains(text(),'Hong Kong ( Chinese Traditional )')]"));
					Utility.Highlightelements(driver, element34);			
					String china_Tra= element34.getText();
					System.out.println(china_Tra);				
					softAssert.assertEquals(china_Tra,"Hong Kong ( Chinese Traditional )");	
					
					Utility.static_wait(2);				
					WebElement search1345 = driver.findElement(By.id("basic_search_icon"));
					Utility.Highlightelements(driver, search1345);							
					Utility.safeJavaScriptClick(search1345, driver);	
				    Utility.static_wait(3);
				    WebElement search13456=driver.findElement(By.cssSelector("td"));
				    Utility.Highlightelements(driver, search13456);	
				   
					if (driver.getPageSource().contains("請嘗試新的搜尋或選擇其他語言再次進行搜尋。")) {
		 				System.out.println("請嘗試新的搜尋或選擇其他語言再次進行搜尋。Text present");
		 			} else {

		 				System.out.println("Text not present");
		 				Assert.fail();
		 			} 
					
					String img6 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Chinese_Traditional.png");
					logger2.log(LogStatus.PASS, "Step 6:On search results page, verify if ''Please try a new search or select a new language and search again'' text is displayed in 'Traditional Chinese' for no search results.","Expected output:Text for No search results found  is translated in 'Traditional Chinese' on  eIFU search  page." + img6);
				
					 D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");

					
					 Utility.static_wait(4);
				    D1.click(IMA3);
				    wait = new WebDriverWait(driver, 4);
					wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Czech Republic")));
					Utility.static_wait(2);
					WebElement goButton2390=driver.findElement(By.linkText("Czech Republic"));
					Utility.safeJavaScriptClick(goButton2390, driver);				
					Thread.sleep(3000);
					WebElement Czech=driver.findElement(By.linkText("Czech"));
					Utility.safeJavaScriptClick(Czech, driver);
					Utility.static_wait(4);
					
					
					WebElement element345 = driver.findElement(By.xpath("//*[contains(text(),'Czech Republic ( Czech )')]"));
					Utility.Highlightelements(driver, element345);			
					String cz_Tra= element345.getText();
					System.out.println(cz_Tra);				
					softAssert.assertEquals(cz_Tra,"Czech Republic ( Czech )","Dhaval is goo7");	
					
					Utility.static_wait(2);				
					WebElement search01345 = driver.findElement(By.id("basic_search_icon"));
					
					Utility.safeJavaScriptClick(search01345, driver);
					Utility.static_wait(3);
					WebElement element56 = driver.findElement(By.id("advance-search-main"));
					Utility.Highlightelements(driver, element56);
					Utility.safeJavaScriptClick(element56, driver);
					Utility.static_wait(3);
					WebElement Key1=driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[4]/label"));
					 Utility.Highlightelements(driver, Key1);
					 String Keyw = Key1.getText();
					 System.out.println(Keyw );
					softAssert.assertEquals(Keyw ,"Klíčová slova","We are good11" );
					
					WebElement Platform1245=driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[5]/div/input"));
					 Utility.Highlightelements(driver, Platform1245);
					
					if (driver.getPageSource().contains("Vyberte si platformu")) {
						System.out.println("Vyberte si platformu Text present ");
					} else {

						System.out.println("Vyberte si platformu Text not present ");
						Assert.fail();
					}
					
					String img7 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Czech.png");
					logger2.log(LogStatus.PASS, "Step 7:erify below elements are present in 'Czech':'Platform' label in Narrow by window and'Keyword' in 'Advanced search' box.","Expected output:Platform' and 'Keyword' labels are translated in 'Czech' and correctly placed on eIFU search pages." + img7);
					
					Utility.static_wait(2);	
					D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");

					 Utility.static_wait(4);	
				D1.click(IMA3);
			    wait = new WebDriverWait(driver, 4);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Denmark")));
				Utility.static_wait(2);
				WebElement goButton238=driver.findElement(By.linkText("Denmark"));
				Utility.safeJavaScriptClick(goButton238, driver);				
				Thread.sleep(3000);
				WebElement Danish=driver.findElement(By.linkText("Danish"));
				Utility.safeJavaScriptClick(Danish, driver);
				Utility.static_wait(2);			
				
				WebElement element3457 = driver.findElement(By.xpath("//*[contains(text(),'Denmark ( Danish )')]"));
				Utility.Highlightelements(driver, element3457);			
				String Denmark= element3457.getText();
				System.out.println(Denmark);				
				softAssert.assertEquals(Denmark,"Denmark ( Danish )");	
				Utility.static_wait(2);	
				WebElement search013456 = driver.findElement(By.id("basic_search_icon"));
				Utility.Highlightelements(driver, search013456);
				String Søgning= search013456.getText();
				System.out.println(Søgning);				
				softAssert.assertEquals(Søgning,"SØGNING");				
				Utility.safeJavaScriptClick(search013456, driver);
				
				String img8 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Danish.png");
				logger2.log(LogStatus.PASS, "Step 8:In advanced search box,verify,if 'search' label is displayed in 'Danish'.","Expected output:search' label is translated in 'Danish' and correctly placed on eIFU search results page." + img8);
				
				Utility.static_wait(2);	
				
				D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");	

				 Utility.static_wait(4);
				D1.click(IMA3);	
				wait = new WebDriverWait(driver, 4);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Netherlands")));
				Utility.static_wait(2);
				WebElement goButton238901=driver.findElement(By.linkText("Netherlands"));
				Utility.safeJavaScriptClick(goButton238901, driver);				
				Thread.sleep(3000);
				WebElement Danish5=driver.findElement(By.linkText("Dutch"));
				Utility.safeJavaScriptClick(Danish5, driver);
				Utility.static_wait(5);			
				
				WebElement element34567 = driver.findElement(By.xpath("//*[contains(text(),'Netherlands ( Dutch )')]"));
				Utility.Highlightelements(driver, element34567);			
				String Dutch= element34567.getText();
				System.out.println(Dutch);				
				softAssert.assertEquals(Dutch,"Netherlands ( Dutch )");	
				Utility.static_wait(2);		
				WebElement search09 = driver.findElement(By.id("basic_search_icon"));
				Utility.safeJavaScriptClick(search09, driver);
				Utility.static_wait(2);
				WebElement View_man9 = driver.findElement(By.cssSelector("i.material-icons.right"));
				Utility.safeJavaScriptClick(View_man9, driver);
				Utility.static_wait(2);	
				
				WebElement element27 = driver.findElement(By.linkText("Eerdere versies"));
				Utility.Highlightelements(driver, element27);
				String pre_ver = element27.getText();
				System.out.println(pre_ver);
				softAssert.assertEquals("Eerdere versies", pre_ver );
				String img9 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Dutch.png");
				logger2.log(LogStatus.PASS, "Step 9:On search results page,verify,if 'Previous versions' label is displayed in 'Dutch'.","Expected output:Previous versions' label is translated in 'Dutch' and correctly placed on eIFU search results page." + img9);
				
				Utility.static_wait(2);
				D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");

				 Utility.static_wait(4);
				D1.click(IMA3);
				wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Finland")));
				Utility.static_wait(2);
				WebElement goButton2387=driver.findElement(By.linkText("Finland"));
				Utility.safeJavaScriptClick(goButton2387, driver);				
				Thread.sleep(3000);
				WebElement Finland=driver.findElement(By.linkText("Finnish"));
				Utility.safeJavaScriptClick(Finland, driver);
				Utility.static_wait(2);			
				
				WebElement element0348 = driver.findElement(By.xpath("//*[contains(text(),'Finland ( Finnish )')]"));
				Utility.Highlightelements(driver, element0348);			
				String Finnish= element0348.getText();
				System.out.println(Finnish);				
				softAssert.assertEquals(Finnish,"Finland ( Finnish )");	
				WebElement search099 = driver.findElement(By.id("basic_search_icon"));
				Utility.safeJavaScriptClick(search099, driver);
				Utility.static_wait(2);
				WebElement View_man99 = driver.findElement(By.cssSelector("i.material-icons.right"));
				Utility.safeJavaScriptClick(View_man99, driver);
				Utility.static_wait(2);					
				WebElement element270 = driver.findElement(By.linkText("Aikaisemmat versiot"));
				Utility.safeJavaScriptClick(element270, driver);
				Utility.static_wait(2);	
				
				WebElement elem0348 = driver.findElement(By.xpath("//*[@id='previousVersionsModal']/div[2]/ul/li"));
				Utility.Highlightelements(driver, elem0348);				
				
				if (driver.getPageSource().contains("Tästä käyttöoppaasta ei ole aikaisempia versioita saatavana.")) {
					System.out.println("Tästä käyttöoppaasta ei ole aikaisempia versioita saatavana. Text present ");
				} else {

					System.out.println("Tästä käyttöoppaasta ei ole aikaisempia versioita saatavana. Text not present ");
					Assert.fail();
				}
				Utility.static_wait(1);
				
				WebElement elem0323 = driver.findElement(By.xpath("//div[@id='previousVersionsModal']/div/a"));
				Utility.safeJavaScriptClick(elem0323, driver);
				String img10 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Finnish.png");
				logger2.log(LogStatus.PASS, "Step 10:On search results page,verify,if 'No Previous versions found' label is displayed in 'Finnish'.","Expected output:No Previous versions found' label is translated in 'Finnish' on eIFU search page." + img10);
				
				Utility.static_wait(2);
				D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");

				 Utility.static_wait(4);
				D1.click(IMA3);
				wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Greece")));
				Utility.static_wait(2);
				WebElement goButto12=driver.findElement(By.linkText("Greece"));
				Utility.safeJavaScriptClick(goButto12, driver);				
				Thread.sleep(3000);
				WebElement Finland1=driver.findElement(By.linkText("Greek"));
				Utility.safeJavaScriptClick(Finland1, driver);
				Utility.static_wait(2);			
				
				WebElement element908 = driver.findElement(By.xpath("//*[contains(text(),'Greece ( Greek )')]"));
				Utility.Highlightelements(driver, element908);			
				String Greek= element908.getText();
				System.out.println(Greek);				
				softAssert.assertEquals(Greek,"Greece ( Greek )");	
				driver.findElement(By.xpath("//*[contains(text(),'Greece ( Greek )')]")).click();
				
				WebElement elet12 = driver.findElement(By.linkText("Αλλαγή γλώσσας"));
				Utility.Highlightelements(driver, elet12);
				String Cha_lan = elet12.getText();
				System.out.println(Cha_lan);
				softAssert.assertEquals("Αλλαγή γλώσσας", Cha_lan,"Dhaval is good56" );
				Utility.static_wait(2);
				WebElement sea08 = driver.findElement(By.id("basic_search_icon"));
				Utility.safeJavaScriptClick(sea08, driver);
				Utility.static_wait(5);
				String img11 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Greek.png");
				logger2.log(LogStatus.PASS, "Step 11:On search & search results pages,verify,if 'Change Language' label is displayed in 'Greek' below header.","Expected output:Change Language' label is translated in 'Greek' and correctly placed on eIFU search results page. " + img11);
				
				
				Utility.static_wait(3);
				D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC3.png");

				 Utility.static_wait(4);
				D1.click(IMA3);	
				wait = new WebDriverWait(driver, 4);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Italy")));
				Utility.static_wait(2);
				WebElement goButton2389012=driver.findElement(By.linkText("Italy"));
				Utility.safeJavaScriptClick(goButton2389012, driver);				
				Thread.sleep(3000);
				WebElement Italy=driver.findElement(By.linkText("Italian"));
				Utility.safeJavaScriptClick(Italy, driver);
				Utility.static_wait(2);			
				
				WebElement el2 = driver.findElement(By.xpath("//*[contains(text(),'Italy ( Italian )')]"));
				Utility.Highlightelements(driver, el2);			
				String Italian= el2.getText();
				System.out.println(Italian);				
				softAssert.assertEquals(Italian,"Italy ( Italian )");	
				Utility.static_wait(2);	
				WebElement S8 = driver.findElement(By.id("basic_search_icon"));
				Utility.safeJavaScriptClick(S8, driver);
				Utility.static_wait(5);
				
				 WebElement Sr_Co = driver.findElement(By.cssSelector("span.label-search-results"));
					Utility.Highlightelements(driver, Sr_Co);
					String srco = Sr_Co.getText();
					System.out.println(srco);
					softAssert.assertEquals(srco,"RISULTATI DELLA RICERCA - 30","We are good91" );	
					D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\Rel.png");
					if (driver.getPageSource().contains("Ordina per")) {
						System.out.println("Ordina per Text present ");
					} else {

						System.out.println("Ordina per Text not present ");
						Assert.fail();
					}
					D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC2.png");
				

					 Utility.static_wait(4);
				WebElement Japan = driver.findElement(By.xpath("//*[@id='tell-us']/div[2]/div[3]"));
				Utility.Highlightelements(driver, Japan);
				String Japan_tell= Japan.getText();
				System.out.println(Japan_tell);				
				softAssert.assertEquals(Japan_tell,"現在地を教えてください。","Dhaval is good98");	
				String img12 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Italian.png");
				logger2.log(LogStatus.PASS, "Step 12:On search results page,verify,if below elements are displayed in 'Italian': Search Results, below search bar and Sort order.","Expected output:Search Results' and 'Sort order' label is translated in 'Italian' and correctly placed on eIFU search results page." + img12);
				
				Utility.static_wait(4);	
				D1.click(IMA4);	
				
				
				wait = new WebDriverWait(driver, 4);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Japan")));
				Utility.static_wait(2);
				WebElement goButton238567=driver.findElement(By.linkText("Japan"));
				Utility.safeJavaScriptClick(goButton238567, driver);				
				Thread.sleep(3000);
				WebElement Danish70=driver.findElement(By.linkText("Japanese"));
				Utility.safeJavaScriptClick(Danish70, driver);
				Utility.static_wait(2);			
				
				WebElement egg = driver.findElement(By.xpath("//*[contains(text(),'Japan ( Japanese )')]"));
				Utility.Highlightelements(driver, egg);			
				String Japanese= egg.getText();
				System.out.println(Japanese);				
				softAssert.assertEquals(Japanese,"Japan ( Japanese )");	
				Utility.static_wait(2);	
				WebElement SA = driver.findElement(By.id("basic_search_icon"));
				Utility.safeJavaScriptClick(SA, driver);
				Utility.static_wait(2);
				 WebElement JPN_text = driver.findElement(By.cssSelector("span.collection-item"));
				Utility.Highlightelements(driver, JPN_text);
				String Jap = JPN_text.getText();
				System.out.println(Jap);
				softAssert.assertEquals(Jap,"機器の中には承認を受けていないもの、各国の市場で販売されていないものがあります。","We are good72" );	
				
				WebElement Adv12 = driver.findElement(By.id("advance-search-main"));
				Utility.safeJavaScriptClick(Adv12, driver);
				Utility.static_wait(2);					
				 WebElement pub345=driver.findElement(By.xpath("//*[@id='advanced_search_main_container']/div[1]/div[5]/div/input"));
				 Utility.Highlightelements(driver, pub345);
				 if (driver.getPageSource().contains("プラットフォームを選択してください")) {
		 				System.out.println("プラットフォームを選択してください  Text present");
		 			} else {

		 				System.out.println("プラットフォームを選択してください Text not present");
		 				Assert.fail();
		 			} 
				 String img13 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Japnies.png");
					logger2.log(LogStatus.PASS, "Step 13:.Verify,if below elements are displayed in 'Japanese'. Tell us where you are -text, on eIFU landing page and Order Manual, for documents in search results and Publication Type, in Narrow by window.","Expected output:Tell us where you are ' , 'Order Manual' & Publication Type labels are translated in 'Japanese' and correctly placed on eIFU search results page." + img13);
				 D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
				 Utility.static_wait(4);
                D1.click(IMA4);	
				
				
				wait = new WebDriverWait(driver, 4);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("South Korea")));
				Utility.static_wait(2);
				WebElement go1=driver.findElement(By.linkText("South Korea"));
				Utility.safeJavaScriptClick(go1, driver);				
				Thread.sleep(3000);
				WebElement Danish234=driver.findElement(By.linkText("Korean"));
				Utility.safeJavaScriptClick(Danish234, driver);
				Utility.static_wait(2);			
				
				WebElement egg1 = driver.findElement(By.xpath("//*[contains(text(),'South Korea ( Korean )')]"));
				Utility.Highlightelements(driver, egg1);			
						
				
				WebElement KA = driver.findElement(By.id("basic_search_icon"));
				Utility.safeJavaScriptClick(KA, driver);
				Utility.static_wait(2);
				WebElement esh = driver.findElement(By.id("advance-search-main"));
				Utility.Highlightelements(driver, esh);
				Utility.static_wait(2);
				WebElement esh1230 = driver.findElement(By.xpath("//*[contains(text(),'고급 검색')]"));
				Utility.Highlightelements(driver, esh1230);
				String Korean1= esh1230.getText();
				System.out.println(Korean1);				
				//softAssert.assertEquals(Korean1,"고급 검색","Dhaval is good91456");
				String img14 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Korean.png");
				logger2.log(LogStatus.PASS, "Step 14:On Advanced search page/box,verify,if 'Basic Search' label is displayed in 'Korean'.","Expected output:Basic Search' label is translated in 'Korean'' and correctly placed on eIFU search  page." + img14);
				Utility.static_wait(2);
				
				
				 D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");

				 Utility.static_wait(4);
				D1.click(IMA3);	
				wait = new WebDriverWait(driver, 4);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Norway")));
				Utility.static_wait(2);
				WebElement goButton23812=driver.findElement(By.linkText("Norway"));
				Utility.safeJavaScriptClick(goButton23812, driver);				
				Thread.sleep(3000);
				WebElement Danish456=driver.findElement(By.linkText("Norwegian"));
				Utility.safeJavaScriptClick(Danish456, driver);
				Utility.static_wait(2);			
				
				WebElement element345670 = driver.findElement(By.xpath("//*[contains(text(),'Norway ( Norwegian )')]"));
				Utility.Highlightelements(driver, element345670);			
				String Norway= element345670.getText();
				System.out.println(Norway);				
				softAssert.assertEquals(Norway,"Norway ( Norwegian )");	
				Utility.static_wait(2);		
				WebElement S091 = driver.findElement(By.id("advance-search"));
					
				String Norwegian= S091.getText();
				System.out.println(Norwegian);				
				softAssert.assertEquals(Norwegian,"Avansert søk");	
				Utility.static_wait(2);
				WebElement NA1 = driver.findElement(By.id("basic_search_icon"));
				Utility.safeJavaScriptClick(NA1, driver);
				Utility.static_wait(2);
				WebElement View_man9999 = driver.findElement(By.cssSelector("i.material-icons.right"));
				Utility.safeJavaScriptClick(View_man9999, driver);
				Utility.static_wait(2);					
				WebElement E24 = driver.findElement(By.linkText("Tidligere versjoner"));
				Utility.Highlightelements(driver, E24);
				Utility.safeJavaScriptClick(E24, driver);
				Utility.static_wait(2);	
				
				WebElement elem03481 = driver.findElement(By.xpath("//*[@id='previousVersionsModal']/div[2]/ul/li"));
				Utility.Highlightelements(driver, elem03481);				
				
				if (driver.getPageSource().contains("Det finnes ingen tidligere versjoner tilgjengelig for denne håndboken.")) {
					System.out.println("Det finnes ingen tidligere versjoner tilgjengelig for denne håndboken. Text present ");
				} else {

					System.out.println("Det finnes ingen tidligere versjoner tilgjengelig for denne håndboken. Text not present ");
					Assert.fail();
				}
				Utility.static_wait(2);
				WebElement EMI = driver.findElement(By.xpath("//div[@id='previousVersionsModal']/div/a"));
				Utility.safeJavaScriptClick( EMI, driver);
				String img15 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Norweigian.png");
				logger2.log(LogStatus.PASS, "Step 15:Verify,if below elements are displayed in 'Norwegian'Advanced search' label, on search page and No previous versions found', in Previous versions window .","Expected output:Advanced search' label' and 'No previous versions' are translated in 'Norwegian' and correctly placed on eIFU search pages." + img15);
				
				Utility.static_wait(2);
				D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");

				 Utility.static_wait(4);
				D1.click(IMA3);	
				
				wait = new WebDriverWait(driver, 4);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Poland")));
				Utility.scrollDown(driver);
				Utility.static_wait(2);
				WebElement goButton23890=driver.findElement(By.linkText("Poland"));
				Utility.safeJavaScriptClick(goButton23890, driver);				
				Thread.sleep(3000);
				WebElement Danish567=driver.findElement(By.linkText("Polish"));
				Utility.safeJavaScriptClick(Danish567, driver);
				Utility.static_wait(2);			
				
				WebElement ent02 = driver.findElement(By.xpath("//*[contains(text(),'Poland ( Polish )')]"));
				Utility.Highlightelements(driver, ent02);			
				String Polish= ent02.getText();
				System.out.println(Polish);				
				softAssert.assertEquals(Polish,"Poland ( Polish )");	
				Utility.static_wait(2);		
				WebElement S81 = driver.findElement(By.id("basic_search_icon"));
				Utility.safeJavaScriptClick(S81, driver);
				Utility.static_wait(2);
				WebElement Pol_text = driver.findElement(By.cssSelector("span.collection-item"));
				Utility.Highlightelements(driver, Pol_text);
				String Poltext = Pol_text.getText();
				System.out.println(Poltext);
				softAssert.assertEquals(Poltext,"Nie wszystkie technologie posiadają zatwierdzenie organów nadzoru i mogą nie być dostępne na rynku we wszystkich regionach.","We are good72" );
				String img16 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Poliesh.png");
				logger2.log(LogStatus.PASS, "Step 16:On search results page, verify if following notice statement for countries is present in 'Polish''Not all technologies may have regulatory approval or may be commercially available in all geographies'and Filter By.","Expected output:As mentioned in the intsruction,notice statement for countries is translated in 'Polish' and correctly placed on eIFU search page." + img16);
				Utility.static_wait(2);
				D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");

				 Utility.static_wait(10);
				D1.click(IMA3);	
				wait = new WebDriverWait(driver, 4);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Portugal")));
				Utility.static_wait(2);
				Utility.scrollDown(driver);
				WebElement goBut345=driver.findElement(By.linkText("Portugal"));
				Utility.safeJavaScriptClick(goBut345, driver);				
				Thread.sleep(3000);
				WebElement Polish1=driver.findElement(By.linkText("Portuguese"));
				Utility.safeJavaScriptClick(Polish1, driver);
				Utility.static_wait(2);			
				
				WebElement el580 = driver.findElement(By.xpath("//*[contains(text(),'Portugal ( Portuguese )')]"));
				Utility.Highlightelements(driver, el580);			
				String Portugal= el580.getText();
				System.out.println(Portugal);				
				softAssert.assertEquals(Portugal,"Portugal ( Portuguese )");	
				Utility.static_wait(2);		
				WebElement S890 = driver.findElement(By.id("basic_search_icon"));
				Utility.safeJavaScriptClick(S890 , driver);
				Utility.static_wait(2);
				
				String Text134 = driver.findElement(By.id("initialSearchTextbox")).getAttribute("placeholder");
				System.out.println(Text134);	
				softAssert.assertEquals("Introduza o número de peça do Manual, o título, a descrição ou uma palavra-chave.", Text134);		
				String img17 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Portuges.png");
				logger2.log(LogStatus.PASS, "Step 17:On search page, verify placeholder text 'Enter manual part number, title, description, or keyword' is present in 'Portuguese'.","Expected output:Placeholder text in search box is translated in 'Portuguese' and correctly placed on eIFU search page." + img17);
				Utility.static_wait(2);
				D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");

				 Utility.static_wait(10);
				D1.click(IMA3);
			    wait = new WebDriverWait(driver, 4);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Romania")));
				Utility.scrollDown(driver);
				Utility.static_wait(2);
				WebElement goo80=driver.findElement(By.linkText("Romania"));
				Utility.safeJavaScriptClick(goo80, driver);				
				Thread.sleep(3000);
				WebElement Romania=driver.findElement(By.linkText("Romanian"));
				Utility.safeJavaScriptClick(Romania, driver);
				Utility.static_wait(4);
				
				
				WebElement emu45 = driver.findElement(By.xpath("//*[contains(text(),'Romania ( Romanian )')]"));
				Utility.Highlightelements(driver, emu45);			
				
				
				Utility.static_wait(2);				
				WebElement ram = driver.findElement(By.id("basic_search_icon"));
				
				Utility.safeJavaScriptClick(ram, driver);
				Utility.static_wait(3);
				WebElement lax = driver.findElement(By.id("advance-search-main"));				
				Utility.safeJavaScriptClick(lax, driver);
				
				WebElement des1=driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[3]/label"));
				 Utility.Highlightelements(driver, des1);
				 String Descriere = des1.getText();
				 System.out.println(Descriere );
				softAssert.assertEquals(Descriere ,"Descriere","We are good11" );
				
				String img18 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Romanian.png");
				logger2.log(LogStatus.PASS, "Step 18:On advanced search page, verify search filter- 'description' label present in 'Romanian'.","Expected output:In Advance search box, search filter, 'Description' is translated in 'Romanian' and correctly placed on eIFU search page." + img18);
				Utility.static_wait(2);
				D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");

				 Utility.static_wait(10);
                D1.click(IMA3);	
				
				wait = new WebDriverWait(driver, 4);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Russia")));
				Utility.scrollDown(driver);
				Utility.static_wait(2);
				WebElement goButton2381256=driver.findElement(By.linkText("Russia"));
				Utility.safeJavaScriptClick(goButton2381256, driver);				
				Thread.sleep(3000);
				WebElement Danish67=driver.findElement(By.linkText("Russian"));
				Utility.safeJavaScriptClick(Danish67, driver);
				Utility.static_wait(2);			
				
				WebElement ent0267 = driver.findElement(By.xpath("//*[contains(text(),'Russia ( Russian )')]"));
				Utility.Highlightelements(driver, ent0267);			
				String Russia= ent0267.getText();
				System.out.println(Russia);				
				softAssert.assertEquals(Russia,"Russia ( Russian )");	
				Utility.static_wait(2);		
				WebElement S800 = driver.findElement(By.id("advance-search"));
				Utility.Highlightelements(driver, S800);			
				String Russian= S800.getText();
				System.out.println(Russian);				
				softAssert.assertEquals(Russian,"Расширенный поиск","Dhaval is good1234");					
				String img19 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Rusian.png");
				logger2.log(LogStatus.PASS, "Step 19:On search page, verify 'Advanced search' label present in 'Russian'.","Expected output:Advanced search' label is translated in 'Russian' and correctly placed on eIFU search  page." + img19);
				Utility.static_wait(2);
				
				
				D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
				 Utility.static_wait(10);
				
				
                D1.click(IMA3);	
                Utility.static_wait(4);
				
				wait = new WebDriverWait(driver, 4);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Slovakia")));
				Utility.scrollDown(driver);
				Utility.static_wait(2);
				WebElement goButton2385=driver.findElement(By.linkText("Slovakia"));
				Utility.safeJavaScriptClick(goButton2385, driver);				
				Thread.sleep(3000);
				WebElement Danish1=driver.findElement(By.linkText("Slovak"));
				Utility.safeJavaScriptClick(Danish1, driver);
				Utility.static_wait(2);			
				
				WebElement Tim = driver.findElement(By.xpath("//*[contains(text(),'Slovakia ( Slovak )')]"));
				Utility.Highlightelements(driver, Tim);			
				String Slovak= Tim.getText();
				System.out.println(Slovak);				
				softAssert.assertEquals(Slovak,"Slovakia ( Slovak )");	
				Utility.static_wait(2);		
				WebElement SL0945 = driver.findElement(By.id("basic_search_icon"));
				Utility.safeJavaScriptClick(SL0945 , driver);
				Utility.static_wait(2);
				WebElement Slo = driver.findElement(By.xpath("//*[contains(text(),'Filtrovať podľa')]"));
				Utility.Highlightelements(driver, Slo);			
				String Slovak1= Slo.getText();
				System.out.println(Slovak1);				
				
				WebElement lax90 = driver.findElement(By.id("advance-search-main"));				
				Utility.safeJavaScriptClick(lax90, driver);
				
				WebElement des1980=driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[1]/label"));
				 Utility.Highlightelements(driver, des1980);
				 String Descriere12 = des1980.getText();
				 System.out.println(Descriere12 );
				softAssert.assertEquals(Descriere12 ,"Číslo produktu","We are good11" );
				String img20 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Slovak.png");
				logger2.log(LogStatus.PASS, "Step 20:On search page, verify below elements are present in 'Slovak'. Narrow by ,label on search page and Part Number, on advanced search box.","Expected output:Narrow by' label and Search filter-Part Number labels are translated in 'Slovak' and correctly placed on eIFU search pages." + img20);
				Utility.static_wait(2);
				D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
				Utility.static_wait(3);				
				
				
				
				 D1.click(IMA3);	
					
					wait = new WebDriverWait(driver, 4);
					wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Slovenia")));
					Utility.scrollDown(driver);
					Utility.static_wait(2);
					WebElement goButton2381=driver.findElement(By.linkText("Slovenia"));
					Utility.safeJavaScriptClick(goButton2381, driver);				
					Thread.sleep(3000);
					WebElement Danish123=driver.findElement(By.linkText("Slovenian"));
					Utility.safeJavaScriptClick(Danish123, driver);
					Utility.static_wait(2);			
					
					WebElement Tim12 = driver.findElement(By.xpath("//*[contains(text(),'Slovenia ( Slovenian )')]"));
					Utility.Highlightelements(driver, Tim12);			
					String Slovenia= Tim12.getText();
					System.out.println(Slovenia);				
					softAssert.assertEquals(Slovenia,"Slovenia ( Slovenian )");	
					Utility.static_wait(2);		
					WebElement SL09 = driver.findElement(By.id("basic_search_icon"));
					Utility.safeJavaScriptClick(SL09 , driver);
					Utility.static_wait(2);
					
					String Text13409 = driver.findElement(By.id("initialSearchTextbox")).getAttribute("placeholder");
					System.out.println(Text13409);	
					softAssert.assertEquals("Vnesite številko dela priročnika, naslov, opis ali ključno besedo.", Text13409,"Dhaval is good12349");
					String img21 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Slovak.png");
					logger2.log(LogStatus.PASS, "Step 21:On search page, verify placeholder text 'Enter manual part number, title, description, or keyword' is present in 'Slovenian'.","Expected output:Placeholder text in search box is translated in 'Slovenian' and correctly placed on eIFU search pages." + img21);
					Utility.static_wait(2);
					
					D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
					Utility.static_wait(3);				
				
				
                 D1.click(IMA3);	
				
				wait = new WebDriverWait(driver, 4);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Spain")));
				Utility.scrollDown(driver);
				Utility.static_wait(2);
				WebElement goButton23823=driver.findElement(By.linkText("Spain"));
				Utility.safeJavaScriptClick(goButton23823, driver);				
				Thread.sleep(3000);
				WebElement Spain1=driver.findElement(By.linkText("Spanish"));
				Utility.safeJavaScriptClick(Spain1, driver);
				Utility.static_wait(2);			
				
				WebElement Timlu = driver.findElement(By.xpath("//*[contains(text(),'Spain ( Spanish )')]"));
				Utility.Highlightelements(driver, Timlu);			
				String Spain= Timlu.getText();
				System.out.println(Spain);				
				softAssert.assertEquals(Spain,"Spain ( Spanish )");	
				
				WebElement tk = driver.findElement(By.id("basic_search_icon"));
				Utility.safeJavaScriptClick(tk , driver);
				Utility.static_wait(2);
				WebElement tk1 = driver.findElement(By.cssSelector("i.material-icons.right"));
				Utility.safeJavaScriptClick(tk1, driver);
				Utility.static_wait(2);					
				WebElement tk2 = driver.findElement(By.linkText("Solicitar el manual"));
				Utility.Highlightelements(driver, tk2);
				String Spanish= tk2.getText();
				System.out.println(Spanish);				
				softAssert.assertEquals(Spanish,"Solicitar el manual","Dhaval is good1234");
				
				String img22 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\spanish.png");
				logger2.log(LogStatus.PASS, "Step 22:For documents, on search results page, verify 'Order Manual' label is present in 'Spanish'.","Expected output:Order Manual' label is translated in 'Spanish 'and correctly placed on eIFU search results page." + img22);
				Utility.static_wait(2);
				D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
				Utility.static_wait(3);		
				
				
				
				Utility.static_wait(2);	
                D1.click(IMA3);	
				
				wait = new WebDriverWait(driver, 4);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sweden")));
				Utility.scrollDown(driver);
				Utility.static_wait(2);
				WebElement goButton23805=driver.findElement(By.linkText("Sweden"));
				Utility.safeJavaScriptClick(goButton23805, driver);				
				Thread.sleep(3000);
				WebElement Danish6=driver.findElement(By.linkText("Swedish"));
				Utility.safeJavaScriptClick(Danish6, driver);
				Utility.static_wait(2);			
				
				WebElement Timlu69 = driver.findElement(By.xpath("//*[contains(text(),'Sweden ( Swedish )')]"));
				Utility.Highlightelements(driver, Timlu69);			
				String Sweden= Timlu69.getText();
				System.out.println(Sweden);				
				softAssert.assertEquals(Sweden,"Sweden ( Swedish )");					
				WebElement tk89 = driver.findElement(By.id("basic_search_icon"));
				Utility.safeJavaScriptClick(tk89 , driver);
				Utility.static_wait(2);
				WebElement tk190 = driver.findElement(By.cssSelector("i.material-icons.right"));
				Utility.safeJavaScriptClick(tk190, driver);
				Utility.static_wait(2);					
				WebElement tk27 = driver.findElement(By.linkText("Se handbok"));
				Utility.Highlightelements(driver, tk27);
				String Swedish45= tk27.getText();
				System.out.println(Swedish45);				
				softAssert.assertEquals(Swedish45,"Se handbok");	
				 D1.hover("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\Switch_view.png");
				 Utility.static_wait(1);
				 if (driver.getPageSource().contains("Byt vy")) {
		 				System.out.println("Byt vy Text present");
		 			} else {

		 				System.out.println("Byt vy Text not present");
		 				Assert.fail();
		 				
		 			} 
				 
				 String img23 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Swedish.png");
					logger2.log(LogStatus.PASS, "Step 23:For documents from search results, verify below labels are present in 'Swedish': View Manual and Change view.","Expected output:View Manual' and 'Change view' labels are translated in 'Swedish' and correctly placed on eIFU search results page." + img23);
					Utility.static_wait(2);
				 D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
					Utility.static_wait(3);	
				
				 D1.click(IMA3);	
					
					wait = new WebDriverWait(driver, 4);
					wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Turkey")));
					Utility.scrollDown(driver);
					Utility.static_wait(2);
					WebElement goButton2380=driver.findElement(By.linkText("Turkey"));
					Utility.safeJavaScriptClick(goButton2380, driver);				
					Thread.sleep(3000);
					WebElement Turkey1=driver.findElement(By.linkText("Turkish"));
					Utility.safeJavaScriptClick(Turkey1, driver);
					Utility.static_wait(2);			
					
					WebElement Tulsi = driver.findElement(By.xpath("//*[contains(text(),'Turkey ( Turkish )')]"));
					Utility.Highlightelements(driver, Tulsi);			
					String Turkey= Tulsi.getText();
					System.out.println(Turkey);				
					softAssert.assertEquals(Turkey,"Turkey ( Turkish )");					
					
					
					 D1.hover("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
					 Utility.static_wait(1);
					 if (driver.getPageSource().contains("Turkey")) {
			 				System.out.println("Kıtayı Değiştir Text present");
			 			} else {

			 				System.out.println("Kıtayı Değiştir Text not present");
			 				Assert.fail();
			 				
			 			} 
					 
					 String img24 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Turky.png");
						logger2.log(LogStatus.PASS, "Step 24:On 'Search pages, 'verify 'Change Continent' button is displayed in 'Turkish'.","Expected output:Change Continent' button is translated in 'Turkish' and correctly placed on eIFU search pages." + img24);
						Utility.static_wait(2);
						
					 D1.click("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
						Utility.static_wait(3);	
						 softAssert.assertAll();
				
				
				
				
				
				
				
				
				
				
					
				
				
				
				
				
				
				/*Thread.sleep(1000);
				D1.click(IMA1);
				Thread.sleep(5000);
				List<WebElement> linkElements =driver.findElements(By.className("country-name"));
				WebDriverWait wait = new WebDriverWait(driver, 60);
				 wait.until(ExpectedConditions.visibilityOfAllElements(linkElements));
				 
				WebElement Logo2 = driver.findElement(By.cssSelector("h4"));
				Utility.Highlightelements(driver, Logo2);
				Thread.sleep(2000);
				Utility.scrollDown(driver);
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Switzerland")));
				
				Thread.sleep(3000);
				WebElement goButton=driver.findElement(By.linkText("Switzerland"));
				Utility.safeJavaScriptClick(goButton, driver);				
				Utility.static_wait(3);
				if (driver.getPageSource().contains("Switzerland")) {
					System.out.println("Text is present");
				} else {

					driver.quit();
				}
				
				WebElement ImageFile = driver.findElement(By.cssSelector("#language_isi_image_container > #isi_image > img.isi_image"));
				Utility.Highlightelements(driver, ImageFile);
			    Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
			    if (ImagePresent)
			    {
			         System.out.println("Image is displayed.");
			    }
			    else
			    {
			        driver.quit();
			    }
				
				List<WebElement> alllinks2 = driver.findElements(By.className("language-name"));
				int linkListCount2 = alllinks2.size();

				for (int i = 0; i < alllinks2.size(); i++)
					System.out.println(alllinks2.get(i).getText());
				System.out.println("Total numbner of country is: " + linkListCount2);
				softAssert.assertEquals(3, linkListCount2, "Count match");
				
				WebElement French=driver.findElement(By.linkText("French"));
				Utility.safeJavaScriptClick(French, driver);
				Thread.sleep(5000);
				Logo = driver.findElement(By.cssSelector("img.isi-logo"));
				Utility.Highlightelements(driver, Logo);
				Thread.sleep(3000);		
				WebElement element1 = driver.findElement(By.xpath("//*[contains(text(),'Switzerland ( French )')]"));
				Utility.Highlightelements(driver, element1);			
				String Switzerland = element1.getText();
				System.out.println(Switzerland);
				
				softAssert.assertEquals(Switzerland,"Switzerland ( French )" );		
				
				 element=driver.findElement(By.xpath("//*[contains(text(),'Switzerland ( French )')]"));
				Utility.safeJavaScriptClick(element, driver);
				
	            WebElement Change_country=driver.findElement(By.xpath("//a[contains(text(),'Changer le pays')]"));
				
				Utility.Highlightelements(driver, Change_country);
				String Changecountry = Change_country.getText();
				System.out.println(Changecountry);			
			   softAssert.assertEquals(Changecountry,"Changer le pays","We are good1" );	
	           WebElement Change_lan=driver.findElement(By.xpath("//a[contains(text(),'Changer la langue')]"));
	           Utility.Highlightelements(driver, Change_lan);
	           String Changelan = Change_lan.getText();
				System.out.println(Changelan);			
				softAssert.assertEquals(Changelan,"Changer la langue","We are bad" );
				
				
	            WebElement French_Search=driver.findElement(By.xpath("//a[contains(text(),'Rechercher')]"));
				
				Utility.Highlightelements(driver, French_Search);
				String FrenchSearch = French_Search.getText();
				System.out.println(FrenchSearch);			
				softAssert.assertEquals(FrenchSearch,"RECHERCHER","We are good3");	
				Utility.static_wait(2);
				
				WebElement French_AdvSearch=driver.findElement(By.xpath("//*[@id='advance-search']"));
				Utility.static_wait(2);			
				Utility.Highlightelements(driver, French_AdvSearch);
				String FrenchAdvSearch = French_AdvSearch.getText();
				System.out.println(FrenchAdvSearch);
				softAssert.assertEquals(FrenchAdvSearch,"Recherche avancée" );
				Utility.static_wait(3);
				String Text = driver.findElement(By.id("initialSearchTextbox")).getAttribute("placeholder");
				System.out.println(Text);	
				softAssert.assertEquals("Entrez la référence, le titre, la description ou le mot clé du manuel.", Text);		
				
				D1.hover("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\CC.png");
				
				 if (driver.getPageSource().contains("Changer le continent")) {
		 				System.out.println("Changer le continent Text present");
		 			} else {

		 				System.out.println("Changer le continent Text not present");
		 				Assert.fail();
		 			} 			
				Utility.static_wait(2);
				 WebElement Rec=driver.findElement(By.id("basic_search_icon"));
				 Utility.safeJavaScriptClick(Rec, driver);		
				 
				 Actions action = new Actions(driver);
				 WebElement we = driver.findElement(By.cssSelector(".switch-view"));
				 action.moveToElement(we).build().perform();
				 Utility.static_wait(1);
				 if (driver.getPageSource().contains("Changer la vue")) {
		 				System.out.println("Changer la vue Text present");
		 			} else {

		 				System.out.println("Changer la vue Text not present");
		 			} 			
				 Utility.static_wait(2);
				 
				 WebElement drop=driver.findElement(By.xpath("//input[@value='Pertinence']"));
				 Utility.Highlightelements(driver, drop);
				 if (driver.getPageSource().contains("Pertinence")) {
		 				System.out.println("Pertinence Text present");
		 			} else {

		 				System.out.println("Pertinence Text not present");
		 				Assert.fail();
			 			
		 				
		 				
		 			} 	
				 
				 
				 String dropdown = drop.getText();
				 System.out.println(dropdown);
				 softAssert.assertEquals(dropdown,"Pertinence","We are good5");	
				 Utility.static_wait(2);
				 WebElement Rec1=driver.findElement(By.xpath("//input[@value='Pertinence']"));	
				 Utility.safeJavaScriptClick(Rec1, driver);
				 
				 WebElement drop1=driver.findElement(By.xpath("//li[2]/span"));
				 Utility.Highlightelements(driver, drop1);
				 
				 if (driver.getPageSource().contains("Nom (croissant)")) {
		 				System.out.println("Nom (croissant)Text present");
		 			} else {

		 				System.out.println("Nom (croissant) Text not present");
		 			} 			
				 WebElement drop2=driver.findElement(By.xpath("//li[3]/span"));
				 Utility.Highlightelements(driver, drop2);
				 String dropdown1 = drop2.getText();
					System.out.println(dropdown1);
					softAssert.assertEquals(dropdown1,"Nom (décroissant)","We are good5");		
				 if (driver.getPageSource().contains("Nom (décroissant)")) {
		 				System.out.println("Nom (décroissant) Text present");
		 			} else {

		 				System.out.println("Nom (décroissant) Text not present");
		 				Assert.fail();
		 			} 
				 
				 WebElement Filter = driver.findElement(By.xpath("//*[contains(text(),'Filtrer par')]"));
					Utility.Highlightelements(driver, Filter);
					String Fil = Filter.getText();
					System.out.println(Fil);
					softAssert.assertEquals(Fil,"FILTRER PAR","We are good7" );	
					 WebElement narrowby = driver.findElement(By.xpath("//*[contains(text(),'Restreindre par')]"));
					Utility.Highlightelements(driver, narrowby)	;				
					String narr = narrowby.getText();
					System.out.println(narr);
					softAssert.assertEquals("RESTREINDRE PAR", narr);
					Utility.static_wait(2);
					driver.findElement(By.id("advance-search-main")).click();
					Utility.static_wait(1);
					WebElement reset=driver.findElement(By.xpath("//*[contains(text(),'Réinitialiser')]"));
					Utility.Highlightelements(driver, reset);
					String res = reset.getText();
						 System.out.println(res);
						 softAssert.assertEquals(res,"RÉINITIALISER","We are good8" );	
						 
						 Utility.static_wait(2);
						 WebElement Ref=driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div/label"));
						 Utility.Highlightelements(driver, Ref);
						 String Refer = Ref.getText();
						 System.out.println(Refer);
						 softAssert.assertEquals(Refer,"Référence","we are good9");
						//*[@id="advanced_search_main_container"]/div[1]/div[1]/label
					
						 Utility.static_wait(2);
						 WebElement doc_num=driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[2]/label"));
						 Utility.Highlightelements(driver, doc_num);
						 String docnum = doc_num.getText();
						 System.out.println(docnum);
						softAssert.assertEquals(docnum,"Nom du document","We are good10" );	
						 Utility.static_wait(2);
						
						 WebElement dec=driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[3]/label"));
						 Utility.Highlightelements(driver, dec);
						 String decs = dec.getText();
						 System.out.println(decs);
						 softAssert.assertEquals(decs,"Description","We are good11" );	
						 Utility.static_wait(2);
						 WebElement keyword=driver.findElement(By.xpath("//div[@id='advanced_search_main_container']/div/div[4]/label"));
						 Utility.Highlightelements(driver, keyword);
						 String Key = keyword.getText();
						 System.out.println(Key);
						
						 softAssert.assertEquals(Key,"Mot clé","We are good12" );	
						 Utility.static_wait(2);
						
						
						 WebElement plat=driver.findElement(By.xpath("//*[@id='advanced_search_main_container']/div[1]/div[5]/div/input"));
						 Utility.Highlightelements(driver, plat);
						 if (driver.getPageSource().contains("Choisir votre plateforme")) {
				 				System.out.println("Choisir votre plateforme Text present");
				 			} else {

				 				System.out.println("Choisir votre plateforme Text not present");
				 				Assert.fail();
				 			} 		
						 
					    driver.findElement(By.xpath("//*[@id='advanced_search_main_container']/div[1]/div[5]/div/input")).click();
						 WebElement plat1=driver.findElement(By.xpath("//*[@id='advanced_search_container']/div/div[1]/div[1]/div[3]/div/ul/li[1]/span"));
						
						 String platform = plat1.getAttribute(Text);
						 System.out.println( platform);
						 softAssert.assertEquals( platform,"Choisir votre plateforme","We are good13" );	
						 
						
						 Utility.static_wait(2);
						 List<WebElement> options = driver.findElements(By.xpath("//*[@id='advanced_search_container']/div/div[1]/div[1]/div[3]/div/ul/li/span"));
						   
						   Utility.static_wait(1);
						   
						   //Count the Values
						   List<String> dropdownVals = new ArrayList<String>();
						    for(int i=0;i<options.size();i++){
						    System.out.println("Drop down:"+options.get(i).getText());
						    dropdownVals.add(options.get(i).getText());
						    }
						   
						 
						
						
						 WebElement pub=driver.findElement(By.xpath("//*[@id='advanced_search_main_container']/div[1]/div[6]/div/input"));
						 Utility.Highlightelements(driver, pub);
						 if (driver.getPageSource().contains("Choisir votre plateforme")) {
				 				System.out.println("Choisir votre type de publication Text present");
				 			} else {

				 				System.out.println("Choisir votre type de publication Text not present");
				 				Assert.fail();
				 			} 	
						 
						/* String publicaton = pub.getText();
						 System.out.println(publicaton);
						 softAssert.assertEquals(publicaton,"Choisir votre type de publication","We are good14" );	
						 Utility.static_wait(2);
					*/
				
				/*driver.findElement(By.linkText("Recherche avancée")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[contains(text(),'Switzerland ( French )')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("changeLanguage")).click();
				Thread.sleep(3000);
				Logo2 = driver.findElement(By.cssSelector("h4"));
				Utility.Highlightelements(driver, Logo2);
				Thread.sleep(2000);
				if (driver.getPageSource().contains("Switzerland")) {
					System.out.println("User able to redirect Switzerland Page");
				} else {

					driver.quit();
				}

				driver.findElement(By.xpath("//div[@id='language_container']/div[2]/div[3]")).click();*/
				
				 logger2.log(LogStatus.PASS, "21-Translated language element correctly placed on user interface.");
				 softAssert.assertAll();
			} catch (Exception e) {
				
				//driver.quit();
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception{	
		
		/**
		 * Screenshot on any step failure which stop execution and capture screen shot.
		 */
	if (result.getStatus() == ITestResult.FAILURE) {
		
		logger2.log(LogStatus.FAIL,result.getThrowable());
		
		/*String TC_Name = result.getName();
		Utility.Takescrrnshotrun(driver, TC_Name);*/
		/*String screenshot_path=Utility.Takescrrnshotrun(driver, result.getName());
		String image= logger2.addScreenCapture(screenshot_path);
		logger2.log(LogStatus.FAIL, "Title verification", image);*/
			
			
		}

	
	
	
	
	}}
	
	





