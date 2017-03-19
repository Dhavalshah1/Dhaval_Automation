package Utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility 
{

	public static void Highlightelements (WebDriver driver, WebElement element)
	{
	JavascriptExecutor js=(JavascriptExecutor)driver; 
	 
	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	 
	try 
	{
	Thread.sleep(1000);
	} 
	catch (InterruptedException e) {
	 
	System.out.println(e.getMessage());
	} 
	 
	js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element); 
	 
	}
	public static void scrollDown (WebDriver driver)
	{
	JavascriptExecutor js=(JavascriptExecutor)driver; 
	 
	js.executeScript("window.scrollBy(0,1000)", "");
	//js.executeScript("arguments[0].scrollIntoView(true);");
	try 
	{
	Thread.sleep(1000);
	} 
	catch (InterruptedException e) {
	 
	System.out.println(e.getMessage());
	} 
	 
	
	 
	}
	
	public static String Takescrrnshor (WebDriver ldriver,String TC_Name)
	{
	TakesScreenshot Ts=(TakesScreenshot)ldriver;
	
	File Screen_Src=Ts.getScreenshotAs(OutputType.FILE);
	
	String path ="C:\\Users\\dhavalsh\\Desktop\\eclipse\\eclipse\\workspace\\com.okta\\Screenshot1\\"+ TC_Name+System.currentTimeMillis()+".png";
	
	File detination =new File(path);
	
	try
	{
	FileUtils.copyFile(Screen_Src,detination);
	
	return path;
	
	}catch (IOException e){
		return e.getMessage();
	}
	
	
	
	}
	public static String Takescrrnshotrun (WebDriver ldriver,String screnshotname){
	
	
	
    TakesScreenshot Ts=(TakesScreenshot)ldriver;
	
	File Screen_Src=Ts.getScreenshotAs(OutputType.FILE);
	
	String path1 ="C:\\Users\\dhavalsh\\Desktop\\Dhaval\\"+screnshotname+".png";
	
	File detination =new File(path1);
	
	try
	{
	FileUtils.copyFile(Screen_Src,detination);
	return path1;
	
	}catch (IOException e){
		return e.getMessage();
	}
			 
			}
	
	public static void static_wait(int seconds)
	{
		
		try
		{
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			
		}
	}
	public  static void safeJavaScriptClick(Object element, WebDriver driver) throws Exception {
		try {
			if (((WebElement) element).isEnabled() && ((WebElement) element).isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}
	public static void scrollToBottom(WebDriver driver) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for (int second = 0;; second++) {
		        if(second >=60){
		            break;
		        }
		            jse.executeScript("window.scrollBy(0,50000)", ""); //y value '800' can be altered
		            Thread.sleep(5000);
		}
    }
	public static void scrollToBottom1(WebDriver driver) throws InterruptedException {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		  javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");  
    }
	public static void Highlightelements1 (WebDriver driver, WebElement element)
	{
	JavascriptExecutor js=(JavascriptExecutor)driver; 
	 
	
	 js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
             element, "color: yellow; border: 2px solid yellow;");
     js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
             element, "");
	
	
	}
}
