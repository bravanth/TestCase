package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddUsersPOM {
	private WebDriver driver; 
	
	public AddUsersPOM(WebDriver driver) {
		//constructor - without this we cant run the program
		this.driver = driver; 
		//initialization of factory - the driver factories.
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[contains(text(),'Users')]")
	private WebElement UsersLink;
	
	@FindBy(xpath="//a[@href='user-new.php']")
	private WebElement AddNewLink; 
	
	@FindBy(id="user_login")
	private WebElement userName;
	
	@FindBy(id="email")
	private WebElement Email;
	
	@FindBy(id="first_name")
	private WebElement FirstName;
	
	@FindBy(id="last_name")
	private WebElement LastName;
	
	@FindBy(id="url")
	private WebElement Website;
	
	@FindBy(xpath = "//button[contains(text(),'Show password')]")
	private WebElement show_password_button;
	
	@FindBy(id="pass1-text")
	private WebElement Password;
	
	@FindBy(id="role")
	private WebElement Role_List_Box;
	
	@FindBy(id="createusersub")
	private WebElement Add_new_User_Button;
	
	@FindBy(xpath ="//a[@class='wp-first-item current']")
	private WebElement All_Users_Link;
	
	@FindBy(xpath ="//a[contains(text(),'bravanth')]")
	private WebElement createdUser;
	
	
	
	public void clickUsersLink()
	{
		
		this.UsersLink.click();
	}
	
	public void clickAddNewLink()
	{
		
		this.AddNewLink.click();
	}
	public void enter_Username(String userName) 
	{
		
		this.userName.sendKeys(userName);
	}
	public void enter_Email(String email) 
	{
		
		this.Email.sendKeys(email);
	}
	public void enter_firstName(String firstName) 
	{
		
		this.FirstName.sendKeys(firstName);
	}
	public void enter_lastName(String lastName) 
	{
		
		this.LastName.sendKeys(lastName);
	}
	public void enter_website(String WebSite) 
	{
		
		this.Website.sendKeys(WebSite);
	}
	public void clickShowPasswordButton()
	{
		this.show_password_button.click();
	}
	public void enter_Password(String Password)
	{
		this.Password.clear();
		this.Password.sendKeys(Password);
	}
	public void clickRoleListBox() {
		this.Role_List_Box.click();
		/*WebElement dropdown = driver.findElement(By.id("role"));
		Select sel = new Select(dropdown);
		sel.selectByValue("Agent");*/
	}
	public void clickAddNewUserButton() {
		this.Add_new_User_Button.click();
	}
	
	public void clickAllUsersLink() {
		this.All_Users_Link.click();
	}
	
	/*public void clickDropUsALine() {
		this.drop_us_a_line_button.click();
	}
	public void errorMessageConfirmation(String errorMessageexp) 
	{
		String errorMessageact =  this.error_message.getText();
		Assert.assertEquals(errorMessageexp, errorMessageact);
		
		
	}*/
	
}
