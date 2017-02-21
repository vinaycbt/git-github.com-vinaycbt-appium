package com.libraries;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult test) {
		// TODO Auto-generated method stub
		
		  SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");//dd/MM/yyyy
		  Date now = new Date();
		  String strDate = sdfDate.format(now);
		  
		  Object obj=test.getInstance();
		  BaseLib baseLib = (BaseLib)obj;
		  
		    try
		    {
		    		File f1 = ((TakesScreenshot) baseLib.driver).getScreenshotAs(OutputType.FILE);
		    		String sImageFileName = test.getName().toString().replace("test", "");
		    		FileUtils.copyFile(f1,new File(BaseLib.sScreenShotDir+"\\"+sImageFileName+strDate+".png"));
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
