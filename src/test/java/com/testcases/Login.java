package com.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login extends Automation {
	
	private String username = "admin";
	private String email = "admin@localhost.dev";
	private String password = "password";
	
	
	@Test(priority = 0)
	public void openHome() {
		driver.get("https://automationexercise.com/");
		assertEquals(driver.getTitle(), "Automation Exercise", "It's not the home page");
	}
	
	@Test(priority = 1)
	public void signUpMenu() {
		WebElement signUpLink = driver.findElement(By.linkText("Signup / Login"));
		signUpLink.click();
		WebElement loginHeader = driver.findElement(By.xpath("//h2[contains(text(), 'Login to your account')]"));
		assertEquals(loginHeader.isDisplayed(), true, "It's not displayed");
	}
	
	@Test(priority = 2)
	public void login() {
		WebElement emailInput = driver.findElement(By.name("email"));
		WebElement passwordInput = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa = 'login-button']"));
	    emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
	    loginButton.click();
		WebElement loggedAs = driver.findElement(By.xpath("//a[contains(text(), 'Logged in as')]"));
		assertEquals(loggedAs.getText(), "Logged in as " + username, "It's not displayed");	
	}

}
