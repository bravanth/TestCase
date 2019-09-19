package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CommercialtabPOM {
	private WebDriver driver; 
	
	public CommercialtabPOM(WebDriver driver) {
		//constructor - without this we cant run the program
		this.driver = driver; 
		//initialization of factory - the driver factories.
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[contains(text(),'Commercial')]")
	private WebElement commercial_Tab;
	
	@FindBy(id="keyword_search")
	private WebElement enterAddress; 
	
	@FindBy(xpath = "//button[@class='button fullwidth']")
	private WebElement search_button;
	@FindBy(xpath = "//a[@class='button fullwidth margin-top-20']")
	private WebElement drop_us_a_line_button;
	
	@FindBy(xpath = "//input[@placeholder='Your Name']")
	private WebElement yourName_textbox; 
	@FindBy(xpath = "//input[@placeholder='Email Address']")
	private WebElement emailAddress_textbox; 
	@FindBy(xpath = "//input[@placeholder='Subject']")
	private WebElement subject_textbox; 
	@FindBy(xpath = "//textarea[@placeholder='Message']")
	private WebElement message_textbox; 
	@FindBy(xpath = "//input[@value='Send']")
	private WebElement send_button; 
	@FindBy(xpath = "//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	private WebElement error_message; 
	
	public void sendAddress(String sendAddress) 
	{
		
		this.enterAddress.sendKeys(sendAddress);
	}
	
	public void enter_yourName(String name) 
	{
		
		this.yourName_textbox.sendKeys(name);
	}
	public void enter_emailAddress(String emailAddress) 
	{
		
		this.emailAddress_textbox.sendKeys(emailAddress);
	}
	public void enter_Subject(String subject) 
	{
		
		this.subject_textbox.sendKeys(subject);
	}
	public void enter_Message(String message) 
	{
		
		this.message_textbox.sendKeys(message);
	}
	public void clickSendButton()
	{
		this.send_button.click();
	}
	public void clickCommercialTab() {
		this.commercial_Tab.click();
	}
	public void clickSearchButton() {
		this.search_button.click();
	}
	public void clickDropUsALine() {
		this.drop_us_a_line_button.click();
	}
	public void errorMessageConfirmation(String errorMessageexp) 
	{
		String errorMessageact =  this.error_message.getText();
		Assert.assertEquals(errorMessageexp, errorMessageact);
		
		
	}
	
}
