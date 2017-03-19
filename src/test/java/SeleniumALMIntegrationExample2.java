

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jacob.com.LibraryLoader;
import com.relevantcodes.extentreports.LogStatus;

import atu.alm.wrapper.ALMServiceWrapper;
import atu.alm.wrapper.ITestCase;
import atu.alm.wrapper.ITestCaseRun;
import atu.alm.wrapper.enums.StatusAs;
import atu.alm.wrapper.exceptions.ALMServiceException;

/**
 * 
 * @author Automation Tester http://automationtestingutilities.blogspot.in/
 */
public class SeleniumALMIntegrationExample2 {
	
	
	WebDriver driver;
	//"C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\hq-qcapp-prd\OTAClient.dll"
	
	
	//regsvr32.exe "C:\Program Files (x86)\HP\OTAClient.dll
	
	//regsvr32.exe C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\hq-qcapp-prd\OTAClient.dll
	//regsvr32.exe C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\12.50.1.0_952\OTAClient.dll
	//regsvr32.exe "C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\hq-qcapp-prd\OTAClient.dll"
	//regsvr32.exe C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\hq-qcapp-prd\OTAClient.dll
	//regsvr32.exe C:\Windows\SysWOW64\OTAClient.dll
	//"C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\hq-qcapp-prd\OTAClient.dll"
	//"C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\12.50.1.0_952\OTAClient.dll"
	//"C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\isitesting\OTAClient.dll"
	//regsvr32.exe C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\isitesting\OTAClient.dll
	//"C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\isrgalmd\OTAClient.dll"
	//regsvr32.exe C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\isrgalmd\OTAClient.dll
	//"C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\12.50.1.0_952\OTAClient.dll"
	//"C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\hq-qcapp-prd\OTAClient.Core.dll"
	//regsvr32.exe C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\hq-qcapp-prd\OTAClient.Core.dll
	
	//regsvr32.exe C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\hq-qcapp-prd\OTAClient.Core.dll
	//C:\Users\dhavalsh\AppData\Local\HP\ALM-Client\hq-qcapp-prd\OTAClient.dll
	
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
	}

	@Test
	public void login12() throws InterruptedException, ALMServiceException {
		// Open Wordpress App
		boolean status = false;
		try {
			driver.get("http://demo.opensourcecms.com/wordpress/wp-login.php");
			// Enter UserName
			Thread.sleep(3000);
			driver.findElement(By.id("user_login")).clear();
			driver.findElement(By.id("user_login")).sendKeys("admin");
			// Enter Password
			driver.findElement(By.id("user_pass")).clear();
			driver.findElement(By.id("user_pass")).sendKeys("demo123");
			// Click on Submit button
			driver.findElement(By.id("wp-submit")).submit();
			status = true;
		}finally{
			createTestCaseRunAndTestCaseExecutionSteps(status);
		}
		System.out.println("Done Updating Results");
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
			wrapper.addStep(loginRun, "Enter username", result,
	                "Enters username", "enter", "enter");
		}
		
		
		
		
		
		/*ITestCaseRun Login = wrapper.createNewRun(, "Run 1",
                StatusAs.PASSED);*/
		
   /*ITestCaseRun Login = wrapper.createNewRun(loginTest, "Run 1",
                StatusAs.PASSED);
		wrapper.addStep(, "Enter username", StatusAs.PASSED,
                "Enters username", "enter", "enter");
		wrapper.addStep(, "Enter password", StatusAs.PASSED,
                "Enters password", "enter", "enter");
		wrapper.addStep(, "Click Login", StatusAs.PASSED,
                "Enters username", "", "");       */
   
	 wrapper.close();
	
	}
	

	@AfterClass
	public void close() {
		driver.quit();
	}
}
