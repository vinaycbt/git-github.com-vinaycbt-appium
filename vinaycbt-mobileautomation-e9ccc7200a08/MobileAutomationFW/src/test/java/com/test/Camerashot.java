package com.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.libraries.BaseLib;
import com.po.CameraPO;

import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;



public class Camerashot extends BaseLib{

	//public Logger logger=Logger.getLogger(this.getClass());
	
	 static Logger log = Logger.getLogger(Camerashot.class.getName());

	
	@Test(priority=1,enabled=true)
	public void cameraApp1()
	{
		CameraPO campo = new CameraPO(driver);
		Assert.assertTrue(campo.simpleCam().isDisplayed(),"simple cam button is not displayed");
		log.info("simple cam button is displayed ");
		campo.simpleCam().click();
		Assert.assertTrue(campo.CamShutterButton().isDisplayed(),"cam shutter button is not displayed");
		log.info("cam shutter button is displayed");
		campo.CamShutterButton().click();
		campo.simpleAndroidCam().click();
	
	}
	
	@Test(priority=2,enabled=false)
	public void cameraApp2()
	{
		CameraPO campo = new CameraPO(driver);
		log.info("Hi");
		Assert.assertTrue(campo.simpleCam1().isDisplayed(),"simple cam button is not displayed");
		log.info("simple cam button is displayed ");
		campo.simpleCam1().click();
		Assert.assertTrue(campo.CamShutterButton().isDisplayed(),"cam shutter button is not displayed");
		log.info("cam shutter button is displayed");
		campo.CamShutterButton().click();
		campo.simpleAndroidCam().click();
	
	}
	
}
