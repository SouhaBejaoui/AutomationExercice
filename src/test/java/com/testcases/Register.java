package com.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register {

	private WebDriver driver;
	
	@BeforeSuite	
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority = 0)
	public void openHome() {
		driver.get("https://automationexercise.com/");
		assertEquals(driver.getTitle(), "Automation Exercise", "It's not the home page");
	}
	
	@Test(priority = 1)
	public void signUpMenu() {
		WebElement signUpLink = driver.findElement(By.linkText("Signup / Login"));
		signUpLink.click();
		WebElement signUpHeader = driver.findElement(By.xpath("//h2[contains(text(), 'New User Signup!')]"));
		assertEquals(signUpHeader.isDisplayed(), true, "It's not displayed");
	}
	
	@Test(priority = 2)
	public void signUp() {
		WebElement nameInput = driver.findElement(By.xpath("//input[@data-qa = 'signup-name']"));
		WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa = 'signup-email']"));
		WebElement signUpButton = driver.findElement(By.xpath("//button[@data-qa = 'signup-button']"));
        String email = "admin@localhost.dev";
        String name = "admin";
        nameInput.sendKeys(name);
	    emailInput.sendKeys(email);
	    signUpButton.click();
	}
	
	@Test(priority = 3)
	public void accountInformation() {
		WebElement enterInfoHeader = driver.findElement(By.xpath("//*[contains(text(), 'Enter Account Information')]"));
	    assertEquals(enterInfoHeader.isDisplayed(), true, "It's not displayed");
	    WebElement titleRadio = driver.findElement(By.id("id_gender1"));
	    WebElement password = driver.findElement(By.id("password"));
        Select selectDay = new Select(driver.findElement(By.id("days")));
        Select selectMonth =new Select(driver.findElement(By.id("months")));
        Select selectYear =new Select(driver.findElement(By.id("years")));
	    titleRadio.click();
	    password.sendKeys("password");
        selectDay.selectByValue("5");
        selectMonth.selectByValue("10");
        selectYear.selectByValue("1989");
	}
	
	@Test(priority = 4)
	public void selectCheckboxes() {
		WebElement newsletter = driver.findElement(By.id("newsletter"));
		WebElement offer = driver.findElement(By.id("optin"));
		newsletter.click();
		offer.click();
	}
	
	@Test(priority = 5)
	public void addressInformation() {
		WebElement firstName = driver.findElement(By.id("first_name"));
		WebElement lastName = driver.findElement(By.id("last_name"));
		WebElement company = driver.findElement(By.id("company"));
		WebElement address = driver.findElement(By.id("address1"));
		WebElement address2 = driver.findElement(By.id("address2"));
		Select country = new Select(driver.findElement(By.id("country")));
		WebElement state = driver.findElement(By.id("state"));
		WebElement city = driver.findElement(By.id("city"));
		WebElement zipcode = driver.findElement(By.id("zipcode"));
		WebElement mobile = driver.findElement(By.id("mobile_number"));
		firstName.sendKeys("admin");
		lastName.sendKeys("test");
		company.sendKeys("Automation");
		address.sendKeys("1 Street Test");
		address2.sendKeys("2 Street Test");
		country.selectByValue("Singapore");
		state.sendKeys("State");
		city.sendKeys("City");
		zipcode.sendKeys("1234");
		mobile.sendKeys("8763486346");
		}
	
	@Test(priority = 6)
	public void createAccount() {
		WebElement createButton = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
		createButton.click();
		WebElement creationHeader = driver.findElement(By.xpath("//*[contains(text(), 'Account Created!')]"));
		assertEquals(creationHeader.isDisplayed(), true, "It's not displayed");
		WebElement continueButton = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
		continueButton.click();
		WebElement loggedAs = driver.findElement(By.xpath("//a[contains(text(), 'Logged in as')]"));
		System.out.println(loggedAs.getText());
		
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.quit();
	}

}
