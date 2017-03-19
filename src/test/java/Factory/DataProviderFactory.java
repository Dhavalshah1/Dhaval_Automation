package Factory;

import DataProvider.ConfigurationFile;
import DataProvider.ExcelConfig;

public class DataProviderFactory 
{
	
	
	public static ExcelConfig getConfig()
	{
		
		ExcelConfig config=new ExcelConfig("./TestData/SFQ1.xls");
		return config;
	}

	
	
	public static ConfigurationFile getProperty()
	{
		
		ConfigurationFile config=new ConfigurationFile("./Configuration/project.properties");
		return config;
	}
}
