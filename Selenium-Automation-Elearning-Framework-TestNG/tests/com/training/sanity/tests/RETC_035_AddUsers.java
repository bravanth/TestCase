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
import com.training.pom.AddUsersPOM;
import com.training.pom.CommercialtabPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RETC_035_AddUsers {
	
	public String baseUrl;
	public Properties properties;
	public LoginPOM loginPOM;
	public AddUsersPOM addusersPOM;
	public WebDriver driver;
	public ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		addusersPOM = new AddUsersPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
	
	
	@Test
	public void AddUsers() throws InterruptedException 
	{
		
		loginPOM.clickLoginRegister();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(3000);
		addusersPOM.clickUsersLink();
		Thread.sleep(3000);
		addusersPOM.clickAddNewLink();
		Thread.sleep(3000);
		addusersPOM.enter_Username("manzoor");
		Thread.sleep(3000);
		addusersPOM.enter_Email("manzoor@gmail.com");
		Thread.sleep(3000);
		addusersPOM.enter_firstName("manzoor");
		Thread.sleep(3000);
		addusersPOM.enter_lastName("mehadi");
		Thread.sleep(3000);
		addusersPOM.enter_website("www.google.com");
		Thread.sleep(3000);
		addusersPOM.clickShowPasswordButton();
		Thread.sleep(3000);
		addusersPOM.enter_Password("Manzoor@Mehadi123");
		Thread.sleep(3000);
		
		addusersPOM.clickRoleListBox();
		
		WebElement dropdown = driver.findElement(By.id("role"));
		Select sel = new Select(dropdown);
		sel.selectByVisibleText("Agent");
		
		Thread.sleep(5000);
		
		addusersPOM.clickAddNewUserButton();
		Thread.sleep(3000);
		addusersPOM.clickAllUsersLink();
		
		WebElement text = driver.findElement(By.xpath("//a[contains(text(),'Manzoor')]"));
		
		if(text.isDisplayed())
		{
			System.out.println("User is added successfully");
		}
		else
		{
			System.out.println("User not found");
		}
		
		
		
		
		
		//screenShot.captureScreenShot("");
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
