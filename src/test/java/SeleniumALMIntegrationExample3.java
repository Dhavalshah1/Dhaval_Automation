

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.jacob.com.LibraryLoader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import DataProvider.ConfigurationFile;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import MailDemo.SendMail;
import Utility.Utility;
import atu.alm.wrapper.ALMServiceWrapper;
import atu.alm.wrapper.ITestCase;
import atu.alm.wrapper.ITestCaseRun;
import atu.alm.wrapper.enums.StatusAs;
import atu.alm.wrapper.exceptions.ALMServiceException;

/**
 * 
 * @author Automation Tester http://automationtestingutilities.blogspot.in/
 */
public class SeleniumALMIntegrationExample3 {
	
	
	WebDriver driver;	
	 private SoftAssert softAssert = new SoftAssert();
	 
		ExtentReports report2;
		ExtentTest logger2;
		public static String TxtBoxContent = "";
		
		private Object element;
		public Screen D1=new Screen();
		Pattern IMA1= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\NA.png");
		Pattern IMA2= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\SA.png");
		Pattern IMA3= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\EU.png");
		Pattern IMA4= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\ASIA.png");
		Pattern IMA5= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\AF.png");
		Pattern IMA6= new Pattern("C:\\Users\\dhavalsh\\Desktop\\Skuli folder\\OC.png");
	
	//regsvr32.exe C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\hq-qcapp-prd\OTAClient.dll
	//regsvr32.exe C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\12.50.1.0_952\OTAClient.dll
	
	
	@BeforeClass
	public void init() {
		//System.setProperty("jacob.dll.path", "C:\\Users\\dhavalsh\\Desktop\\jacob-1.18\\jacob-1.18-x64.dll");
		System.setProperty("jacob.dll.path", "C:\\jacob-1.18\\jacob-1.18-x86.dll");
		
		System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-extensions");

		driver = new ChromeDriver(options);
		System.setProperty("jacob.dll.path", "C:\\Users\\dhavalsh\\Desktop\\jacob-1.18\\jacob-1.18-x86.dll");
		
		LibraryLoader.loadJacobLibrary();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		report2 = new ExtentReports("./Reports/ElfuScripts.html");
	}

	@Test(priority=1)
	public void login12() throws InterruptedException, ALMServiceException, Throwable {
		// Open Wordpress App
		boolean status = false;
		try {
			logger2 = report2.startTest("04-Validating-Language selection screen ");
			/**
			 * Call login step from Library
			 */
			ConfigurationFile property = DataProviderFactory.getProperty();
			WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());

			driver.get(property.getURL());
			Utility.static_wait(3);
			Utility.Takescrrnshotrun(driver, "Global");
			String img1 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Global.png");
			logger2.log(LogStatus.PASS, "Step 1:Launch the Document Library website","Expected output:Document Library homepage is dispalyed" + img1);
			softAssert.assertEquals("Market - dvpuat.net", driver.getTitle());			
			Utility.static_wait(5);
			D1.hover(IMA3);
			Utility.static_wait(2);
			D1.click(IMA1);
			Utility.Takescrrnshotrun(driver, "North_America");	
			String img2 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\North_America.png");
			logger2.log(LogStatus.PASS, "Step 2:From the world map that is displayed, select North America.","Expected output:A country selection page is displayed. The title of the page is North America." + img2);
			
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
			Utility.static_wait(2);			
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
			status = true;
			
			BrowserFactory.quitApplication(driver);			
			logger2.log(LogStatus.PASS, "Resutl:Script Passed and Validating- Country & language relation");
		}finally{
			createTestCaseRunAndTestCaseExecutionSteps(status);
			System.out.println("Done Updating Results");
		}
		
	
	}
	
	

	public   void createTestCaseRunAndTestCaseExecutionSteps(boolean status)
            throws ALMServiceException {
		ALMServiceWrapper wrapper = new ALMServiceWrapper(
                "http://hq-qcapp-prd:8080/qcbin");
    wrapper.connect("dhavalsh", "Dhaval@1976", "ISI", "eIFU_2016"); 
    
          StatusAs result = status ? StatusAs.PASSED : StatusAs.FAILED;
          
		ITestCase loginTest = wrapper.updateResult("", "Raja12", 205, "Login", result);
		
		if(status){
			ITestCaseRun loginRun = wrapper.createNewRun(loginTest, "Login", result);
			wrapper.addStep(loginRun, "Step-1", result,
	                "Document Library test website is opened.", "Document Library test website is opened.", "Results match expected.");
			wrapper.newAttachment("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\NA.png", "C:\\Users\\dhavalsh\\Desktop\\Dhaval\\NA.png",loginTest );
			wrapper.addStep(loginRun, "Step-2", result,
	                "From the world map that is displayed, select North America.","A country selection page is displayed. The title of the page is North America.", "Results match expected.");
			wrapper.newAttachment("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\North_America.png", "C:\\Users\\dhavalsh\\Desktop\\Dhaval\\North_America.png",loginTest );
			wrapper.addStep(loginRun, "Step-3", result,
	                "From the list of countries, select the United States.","A language selection page is displayed. The title of the page is United States.", "Results match expected.");
			wrapper.addStep(loginRun, "Step-4", result,
	                "Check for header & Footer as below 1.'Intituive Surgical' logo at the middle of header.2.Footer is in grey & Blank (no text).", "Intuitive Surgical' logo is present at the middle of the header and Footer is in 'Grey' with 'no text'.", "Results match expected.");
			wrapper.addStep(loginRun, "Step-5", result,
	                "Check if 'Country Name' is present below the header on left side of the screen.", "Selected 'Country name'-'United states' is displayed as the 'Title' of the screen.", "Results match expected.");
			wrapper.addStep(loginRun, "Step-6", result,
	                "Check for  'SELECT LANGUAGE BELOW' text is displayed below the 'Country Name'.", "'SELECT LANGUAGE BELOW'- text is present below the 'Country Name' on left side of the page.", "Results match expected.");
		}
		
	

}
		
		@Test(priority=2)
		public void login123() throws InterruptedException, ALMServiceException, Throwable {
			// Open Wordpress App
			boolean status = false;
			try {
				logger2 = report2.startTest("05-Validating-Language selection screen1 ");
				/**
				 * Call login step from Library
				 */
				ConfigurationFile property = DataProviderFactory.getProperty();
				WebDriver driver = BrowserFactory.getBrowser(property.getBrowser());

				driver.get(property.getURL());
				Utility.static_wait(3);
				Utility.Takescrrnshotrun(driver, "Global");
				String img1 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\Global.png");
				logger2.log(LogStatus.PASS, "Step 1:Launch the Document Library website","Expected output:Document Library homepage is dispalyed" + img1);
				softAssert.assertEquals("Market - dvpuat.net", driver.getTitle());			
				Utility.static_wait(2);
				D1.hover(IMA3);
				Utility.static_wait(2);
				D1.click(IMA1);
				Utility.Takescrrnshotrun(driver, "North_America");	
				String img2 = logger2.addScreenCapture("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\North_America.png");
				logger2.log(LogStatus.PASS, "Step 2:From the world map that is displayed, select North America.","Expected output:A country selection page is displayed. The title of the page is North America." + img2);
				
				boolean enabled = driver.findElement(By.cssSelector("label.remember-selection")).isSelected();
				if (!enabled) {

					System.out.println("Already checked");

					Utility.static_wait(1);	

				} else

				{

					System.out.println("not checked");

				}
				
				Utility.static_wait(2);			
				WebElement United_States=driver.findElement(By.linkText("United States12"));
				Utility.safeJavaScriptClick(United_States, driver);
				Utility.static_wait(2);			
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
				status = true;
				
			}finally{
				createTestCaseRunAndTestCaseExecutionSteps2(status);
				System.out.println("Done Updating Results");
				 BrowserFactory.quitApplication(driver);
					
					logger2.log(LogStatus.FAIL, "Resutl:Script Passed and Validating- Country & language relation");
			}
			
		
		}
		
		

		public   void createTestCaseRunAndTestCaseExecutionSteps2(boolean status)
	            throws ALMServiceException {
			ALMServiceWrapper wrapper = new ALMServiceWrapper(
	                "http://hq-qcapp-prd:8080/qcbin");
	    wrapper.connect("dhavalsh", "Dhaval@1976", "ISI", "eIFU_2016"); 
	    
	          StatusAs result1 = status ? StatusAs.PASSED : StatusAs.FAILED;
	          
			ITestCase loginTest1 = wrapper.updateResult("", "Raja12", 205, "Login1", result1);
			
			if(status){
				ITestCaseRun loginRun = wrapper.createNewRun(loginTest1, "Login1", result1);
				wrapper.addStep(loginRun, "Step-1", result1,
		                "Document Library test website is opened.", "Document Library test website is opened.", "Results match expected.");
				wrapper.newAttachment("C:\\Users\\dhavalsh\\Desktop\\Dhaval\\NA.png", "Global map",loginTest1 );
				wrapper.addStep(loginRun, "Step-2", result1,
		                "From the world map that is displayed, select North America.","A country selection page is displayed. The title of the page is North America.", "Results match expected.");
				
				wrapper.addStep(loginRun, "Step-3", result1,
		                "From the list of countries, select the United States.","A language selection page is displayed. The title of the page is United States.", "Results match expected.");
				wrapper.addStep(loginRun, "Step-4", result1,
		                "Check for header & Footer as below 1.'Intituive Surgical' logo at the middle of header.2.Footer is in grey & Blank (no text).", "Intuitive Surgical' logo is present at the middle of the header and Footer is in 'Grey' with 'no text'.", "Results match expected.");
				wrapper.addStep(loginRun, "Step-5", result1,
		                "Check if 'Country Name' is present below the header on left side of the screen.", "Selected 'Country name'-'United states' is displayed as the 'Title' of the screen.", "Results match expected.");
				wrapper.addStep(loginRun, "Step-6", result1,
		                "Check for  'SELECT LANGUAGE BELOW' text is displayed below the 'Country Name'.", "'SELECT LANGUAGE BELOW'- text is present below the 'Country Name' on left side of the page.", "Results match expected.");
			}
			
		
	
	}
	

	@AfterClass
	public void tearDown() throws Exception {
		report2.endTest(logger2);
		report2.flush();
		SendMail.execute();
		
	}
}
