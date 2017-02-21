package com.libraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericLib {

	
	public static String readConfigPropFile(String sPropFileName,String sKey) throws IOException
	{
		
		String sValue = null;
		try
		{
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream(sPropFileName);
		prop.load(fi);
		sValue = prop.getProperty(sKey);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return sValue;	
	}
	
	
	public static String[] readDataFromExcel(String sheetName, String Tc_Id) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		String testdata[] = null;
		
		FileInputStream fis = new FileInputStream(BaseLib.sExcelFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1 = wb.getSheet(sheetName);
		int rowCount = s1.getLastRowNum();
		int k=0;
		for(int i =1; i<=rowCount; i++)
		{
			if(s1.getRow(i).getCell(k).getStringCellValue().equals(Tc_Id))
			{
				int CellCount = s1.getRow(i).getLastCellNum();
				testdata = new String[CellCount];
				for(int j=0; j<=CellCount;j++)
				{
					testdata[j] = s1.getRow(i).getCell(j).getStringCellValue();
					
				}	
			}		
			
		}
		return testdata;
	}
	
}
