package com.training.sanity.tests;


import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.training.pom.UpdateProfilePOM;


public class Update_Profile {
	

	public UpdateProfilePOM updateprofilePOM;

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void updateProfile() throws InterruptedException 
	{
		updateprofilePOM = new UpdateProfilePOM(driver);
		Thread.sleep(3000);
		updateprofilePOM.clickMyProfileLink();
		Thread.sleep(3000);
		updateprofilePOM.agentTitle("Sunil123");
		Thread.sleep(3000);
		updateprofilePOM.phoneNumber("111111111");
		Thread.sleep(3000);
		updateprofilePOM.clickSaveChangesButton();
		updateprofilePOM.profileUpdateConfirmation("Your profile has been updated.");
		screenShot.captureScreenShot("Update_profile");
	}
}
