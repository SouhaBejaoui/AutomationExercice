package com.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login extends Automation {
	
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
	
	@Parameters({"email","password", "username", "correctIdentifiers"})
	@Test(priority = 2)
	public void login(String email, String password, String username, Boolean correctIdentifiers) {
		WebElement emailInput = driver.findElement(By.name("email"));
		WebElement passwordInput = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa = 'login-button']"));
	    emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
	    loginButton.click();
	    if (correctIdentifiers) {
			WebElement loggedAs = driver.findElement(By.xpath("//a[contains(text(), 'Logged in as')]"));
			assertEquals(loggedAs.getText(), "Logged in as " + username, "It's not displayed");
	    } else {
	    	WebElement loginError = driver.findElement(By.xpath("//p[contains(text(), 'Your email or password is incorrect!')]"));
	    	assertEquals(loginError.isDisplayed(), true, "It's not displayed");
	    }	
	}
}
