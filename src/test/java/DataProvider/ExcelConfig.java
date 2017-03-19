package DataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelConfig 
{
	
	
	HSSFWorkbook wb;
	
	public ExcelConfig(String path)
	{
		
		try 
		{
			
			wb=new HSSFWorkbook(new FileInputStream(new File(path)));
		} catch (Exception e)
		{
			
			System.out.println("Unale to load file "+e.getMessage());
		}
	}

	
	public String getData(int sheetnumber,int row,int column)
	{
	 return	wb.getSheetAt(sheetnumber).getRow(row).getCell(column).getStringCellValue();
	}
	
	
	public int getRowCount(int sheetIndex)
	{
		int rows=wb.getSheetAt(0).getLastRowNum()+1;
	   	return rows;
	}
}
