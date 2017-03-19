package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility 
{

	public static void Highlightelements (WebDriver driver, WebElement element)
	{
	JavascriptExecutor js=(JavascriptExecutor)driver; 
	 
	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	 
	try 
	{
	Thread.sleep(500);
	} 
	catch (InterruptedException e) {
	 
	System.out.println(e.getMessage());
	} 
	 
	js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element); 
	 
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
	
	
	public static void static_wait(int seconds)
	{
		
		try
		{
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			
		}
	}

}
