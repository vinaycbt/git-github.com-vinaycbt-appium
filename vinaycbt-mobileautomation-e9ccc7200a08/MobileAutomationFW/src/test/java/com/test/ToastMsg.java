package com.test;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.testng.annotations.Test;

import com.libraries.BaseLib;
import com.po.ToastPO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ToastMsg extends BaseLib{
	ToastPO toastPO = null;
	
	@Test
	public void toast() throws TesseractException
	{
		toastPO = new ToastPO(driver);
		
		toastPO.togglebutton1().click();
		toastPO.submitButton().click();
		
		//Code for taking sc and getting the string for toast message
		
		File sc = driver.getScreenshotAs(OutputType.FILE);
		ITesseract its = new Tesseract();
		String str = its.doOCR(sc);
		System.out.println(str.toString());

/*		String stdms1 = "ToggleEutton1 :On";
		String stdms2 = "ToggleEuttonZ : Off";
		String stdms4 = "ToggleEutton1 :On";
		String stdms5 = "ToggleEuttonZ : Off";
		
		
		
		
		String s1 = str.toString();
	
		if(s1.contentEquals(stdms1)==true && s1.contentEquals(stdms2)==true)
		{
		
		System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
	*/}
	

}
