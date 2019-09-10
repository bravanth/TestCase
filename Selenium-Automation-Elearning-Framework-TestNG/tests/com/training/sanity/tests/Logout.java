package com.training.sanity.tests;


import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.training.pom.LogoutPOM;
import com.training.pom.UpdateProfilePOM;


public class Logout extends LoginTests{
	

	public LogoutPOM logoutPOM;

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void updateProfile() throws InterruptedException 
	
	{
		logoutPOM = new LogoutPOM(driver);
		Thread.sleep(3000);
		logoutPOM.clickLogout();
		screenShot.captureScreenShot("First");
	}
}
