package com.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class ToastPO {

	
	AndroidDriver driver= null;
	
	public ToastPO(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="com.example.sumof2numbers:id/toggleButton1")
	private WebElement toggleButton1;
	public WebElement togglebutton1()
	{
		return toggleButton1;
	}
	
	
	@FindBy(id="com.example.sumof2numbers:id/button2")
	private WebElement submitButton;
	public WebElement submitButton()
	{
		return submitButton;
	}
}
