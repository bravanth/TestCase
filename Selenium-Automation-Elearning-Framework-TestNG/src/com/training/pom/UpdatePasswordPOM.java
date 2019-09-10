package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UpdatePasswordPOM {
	private WebDriver driver; 
	
	public UpdatePasswordPOM(WebDriver driver) {
		//constructor - without this we cant run the program
		this.driver = driver; 
		//initialization of factory - the driver factories.
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='http://realestate.upskills.in/change-password/']")
	private WebElement changePasswordLink;
	
	@FindBy(xpath = "//*[@type='password' and @name='current_pass']")
	private WebElement currentPassword; 
	
	@FindBy(xpath = "//*[@name='pass1' and @type='password']")
	private WebElement newPassword;
	
	@FindBy(xpath = "//*[@name='pass2' and @type='password']")
	private WebElement confirmNewPassword;
	
	@FindBy(id = "wp-submit")
	private WebElement saveChangesBtn; 
	
	@FindBy(xpath = "//p[contains(text(),'Your password has been updated.')]")
	private WebElement passwordUpdated; 
	
	public void EnterCurrentPassword(String currentPassowrd) {
		
		this.currentPassword.sendKeys(currentPassowrd);
	}
	
	public void EnterNewPassword(String newPassword) {
		
		this.newPassword.sendKeys(newPassword);
	}
	
	public void EnterConfirmNewPassword(String confirmnewPassword) {
		this.confirmNewPassword.sendKeys(confirmnewPassword);
	}
	public void clickSaveChangesButton() {
		this.saveChangesBtn.click();
	}
	public void clickChangePasswordLink() {
		this.changePasswordLink.click();
	}
	public void passwordUpdateConfirmation(String passwordUpdatedexp ) 
	{
		String pwdupdateact = this.passwordUpdated.getText();
		Assert.assertEquals(pwdupdateact, passwordUpdatedexp); 
	}
}
