package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPOM {
	private WebDriver driver; 
	
	public LogoutPOM(WebDriver driver) {
		//constructor - without this we cant run the program
		this.driver = driver; 
		//initialization of factory - the driver factories.
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class='my-account-nav-container']//ul[2]//li[2]//a[1]")
	private WebElement logout;
	
	
	
	
	public void clickLogout() 
	{
		this.logout.click();
	}
	
	
}
