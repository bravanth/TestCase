package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UpdateProfilePOM {
	private WebDriver driver; 
	
	public UpdateProfilePOM(WebDriver driver) {
		//constructor - without this we cant run the program
		this.driver = driver; 
		//initialization of factory - the driver factories.
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='current']")
	private WebElement myProfile;
	
	@FindBy(id="agent_title")
	private WebElement agentTtile; 
	
	@FindBy(id="phone")
	private WebElement phoneNumber;
	
	@FindBy(xpath = "//*[@type='submit' and @value='Submit']")
	private WebElement submitBtn; 
	@FindBy(xpath = "//p[contains(text(),'Your profile has been updated.')]")
	private WebElement profileHasBeenUpdated; 
	
	public void agentTitle(String agentTitleName) 
	{
		this.agentTtile.clear();
		this.agentTtile.sendKeys(agentTitleName);
	}
	
	public void phoneNumber(String number) 
	{
		this.phoneNumber.clear();
		this.phoneNumber.sendKeys(number);
	}
	
	public void clickMyProfileLink() {
		this.myProfile.click();
	}
	public void clickSaveChangesButton() {
		this.submitBtn.click();
	}
	public void profileUpdateConfirmation(String updateConfmsgexp) 
	{
		String updateConfact =  this.profileHasBeenUpdated.getText();
		Assert.assertEquals(updateConfmsgexp, updateConfact);
		
		
	}
	
}
