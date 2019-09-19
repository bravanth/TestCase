package com.training.sanity.tests;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CommercialtabPOM;
import com.training.pom.LoginPOM;
import com.training.pom.VillastabPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RETC_036_VillasTab {
	
	public String baseUrl;
	public Properties properties;
	public LoginPOM loginPOM;
	public CommercialtabPOM commercialtabPOM;
	public VillastabPOM villastabPOM;
	public WebDriver driver;
	public ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
	
	
	@Test
	public void VillasTab() throws InterruptedException 
	{
		commercialtabPOM = new CommercialtabPOM(driver);
		villastabPOM = new VillastabPOM(driver);
		
		//commercialtabPOM.clickCommercialTab();
		villastabPOM.clickVillasTab();
		
		commercialtabPOM.sendAddress("Nullamanna NSW, Australia");
		//Selecting the option from auto fill dropdown
		WebElement webElement = driver.findElement(By.id("keyword_search"));
		webElement.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		commercialtabPOM.clickSearchButton();
		Thread.sleep(3000);
		commercialtabPOM.clickDropUsALine();
		Thread.sleep(3000);
		commercialtabPOM.enter_yourName("Selenium");
		Thread.sleep(3000);
		commercialtabPOM.enter_emailAddress("selenium@gmail.com");
		Thread.sleep(3000);
		commercialtabPOM.enter_Subject("apartment");
		Thread.sleep(3000);
		commercialtabPOM.enter_Message("Looking for appartment");
		Thread.sleep(3000);
		commercialtabPOM.clickSendButton();
		Thread.sleep(3000);
		commercialtabPOM.errorMessageConfirmation("There was an error trying to send your message. Please try again later.");
		
		
		//screenShot.captureScreenShot("");
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
