package com.training.sanity.tests;


import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.training.pom.UpdatePasswordPOM;
import com.training.pom.UpdateProfilePOM;


public class Update_Password extends LoginTests{
	

	public UpdatePasswordPOM updatepwdPOM;

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void updatePassword() throws InterruptedException 
	{
		updatepwdPOM = new UpdatePasswordPOM(driver);
		updatepwdPOM.clickChangePasswordLink();
		updatepwdPOM.EnterCurrentPassword("Password@12345");
		Thread.sleep(3000);
		updatepwdPOM.EnterNewPassword("Password@12345");
		Thread.sleep(3000);
		updatepwdPOM.EnterConfirmNewPassword("Password@12345");
		updatepwdPOM.clickSaveChangesButton();
		updatepwdPOM.passwordUpdateConfirmation("Your password has been updated.");
		screenShot.captureScreenShot("Third");
	}
}
