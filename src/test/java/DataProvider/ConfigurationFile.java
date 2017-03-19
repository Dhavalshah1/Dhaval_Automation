package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationFile 
{
	
	Properties pro;
	
	public ConfigurationFile(String path)
	{
		
		
		try {
			pro=new Properties();
			pro.load(new FileInputStream(new File(path)));
			
		} catch (Exception e) 
		{
			System.out.println("Unable to locate file "+e.getMessage());
		} 
		
	}
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}

	
	public String getTimeOut()
	{
		return pro.getProperty("TimeOut");
	}
	
	public String getURL()
	{
		return pro.getProperty("URL");
	}
	public String getUName()
	{
		return pro.getProperty("UName");
	}
	
	public String getPP()
	{
		return pro.getProperty("PP");
	}
	public String URLAdmin()
	{
		return pro.getProperty("URLAdmin");
	}
	public String scheduler()
		{
			return pro.getProperty("scheduler");
	}
	public String getProperty(String property){
	
		return pro.getProperty(property);
	}
	public String getgoogle()
	{
		return pro.getProperty("Google");
	}
}
