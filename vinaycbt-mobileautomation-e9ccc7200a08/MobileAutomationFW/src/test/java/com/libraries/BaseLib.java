package com.libraries;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.log4testng.Logger;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseLib {

	DesiredCapabilities desc= null;
	public AndroidDriver driver = null;
	
	static public String sDirPath = System.getProperty("user.dir");	
	static public String sCameraAppDir = sDirPath+"\\resources\\cameraShot_com.example.simplecamera.apk";
	static public String sToastAppDir = sDirPath+"\\resources\\Toast_com.example.sumof2numbers.apk";
	static public String sPropFileName = sDirPath+"\\configProperties.properties";
	static public String sExcelFileName = sDirPath+"\\TestData.xlsx";
	static public String sScreenShotDir = sDirPath+"\\screenshots";
	AppiumDriverLocalService appiumService = null;
	
	@BeforeMethod
	public void appLaunch() throws IOException
	{
	
		String Appium_Node_Path="C:/Program Files (x86)/Appium/node.exe"; 
		String Appium_JS_Path="C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js"; 
		appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(4723).usingDriverExecutable(new File(Appium_Node_Path)).withAppiumJS(new File(Appium_JS_Path))); 
		appiumService.start();

		
		File f1 = new File(sToastAppDir);
		
		desc = new DesiredCapabilities();
		desc.setCapability("automationName", GenericLib.readConfigPropFile(sPropFileName, "AUTOMATIONNAME"));
		desc.setCapability("platformName", GenericLib.readConfigPropFile(sPropFileName, "PLATFORMNAME"));
		desc.setCapability("platformVersion", GenericLib.readConfigPropFile(sPropFileName, "PLATFORMVERSION"));
		desc.setCapability("deviceName", GenericLib.readConfigPropFile(sPropFileName, "DEVICENAME"));
		
		desc.setCapability("app",f1.getAbsolutePath());
		
		//desc.setCapability("appPackage", "com.example.simplecamera");
		//desc.setCapability("appActivity", "com.example.simplecamera.MainActivity");
		desc.setCapability("fullReset", "false");
		
		
	   driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desc); 
	
	   driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void appClose()
	{
		driver.closeApp();
		//driver.quit();
		appiumService.stop();
	}
}
