package Factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BrowserFactory 
{
	
	public static WebDriver getBrowser(String browserName)
	{
		WebDriver driver=null;
		
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();

			options.addArguments("--disable-extensions");

			driver = new ChromeDriver(options);

		}
		if (browserName.equalsIgnoreCase("Firefox"))

		{

			System.setProperty("webdriver.Gecko.marionette",
					"C://Users//dhavalsh//Desktop//geckodriver-v0.9.0-win64 (1)");

			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);

			driver = new FirefoxDriver();

		}
		if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C://IEDriverServer_Win32_2.52.1//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 //driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		// driver.manage().window().setPosition(new Point(0,0));
		

		/*
		 * String browserName1 = ((Capabilities)driver).getBrowserName();
		 * System.out.println(browserName1);
		 */
		return driver;
	}
	
	public static void quitApplication(WebDriver driver)
	{
		driver.quit();
	}
	
}
