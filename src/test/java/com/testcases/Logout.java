package com.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Logout extends Automation {
	
	@Test
	public void logout() {
		WebElement logoutLink = driver.findElement(By.xpath("//a[contains(text(), 'Logout')]"));
		logoutLink.click();
		//System.out.println(driver.getCurrentUrl());
		assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login", "The user is not navigated to login page");
	}
}
