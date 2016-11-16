package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelDataProvider
{
  XSSFWorkbook wb;
  XSSFSheet sheet1;
  //Properties pro1;
	public ExcelDataProvider()
	{
		
		
		
		File src=new File("./ApplicationTestData/RegisterInsurance.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is "+ e.getMessage());
			
		}
		
		
	}
	
	public void getRowCount(int sheetIndex)
	{
	//	Row row = null;
		int iRow=wb.getSheetAt(sheetIndex).getLastRowNum();
		iRow=iRow+1;
                
	}
	
	
	
	public String getData(int sheetindex,int row,int column)
	{
	String data=wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
	return data;
	}
	
	public String getData(String sheetnumber,int row,int column)
	{
	String data1=wb.getSheet(sheetnumber).getRow(row).getCell(column).getStringCellValue();
	return data1;
	}
	
	
	}
	

