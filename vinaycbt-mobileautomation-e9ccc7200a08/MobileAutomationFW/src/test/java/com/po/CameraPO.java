package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class CameraPO {

	AndroidDriver driver= null;
	
	public CameraPO(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="com.example.simplecamera:id/button1")
	private WebElement simpleCamButton;
	public WebElement simpleCam()
	{
		return simpleCamButton;
	}
	
	@FindBy(id="com.android.camera:id/v6_shutter_button_internal")
	private WebElement simpleCamShutterButton;
	public WebElement CamShutterButton()
	{
		return simpleCamShutterButton;
	}
	
	@FindBy(id="com.android.camera:id/v6_btn_done")
	private WebElement simpleAndroidCamBtn;
	public WebElement simpleAndroidCam()
	{
		return simpleAndroidCamBtn;
	}
	
	@FindBy(id="com.example.simplecamera:id/button1")
	private WebElement simpleCamButton1;
	public WebElement simpleCam1()
	{
		return simpleCamButton1;
	}
	
	
	
}
