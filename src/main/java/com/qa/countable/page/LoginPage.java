package com.qa.countable.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.countable.base.Basepage;

public class LoginPage extends Basepage {
	WebDriver driver;

	// 1.create locators using by
	By emailid = By.id("mat-input-0");
	By password = By.id("mat-input-1");
	By Loginbtn = By.className("full-btn");
	By singup = By.xpath("//span[normalize-space()='Sign up']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page Actions
	public String getPagetitle() {
		return driver.getTitle();
	}

	public boolean checksignuplink() {
		return driver.findElement(singup).isDisplayed();
	}

	public Dashboard dologin(String username, String pwd) {
		driver.findElement(emailid).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(Loginbtn).click();
		return new Dashboard(driver);

	}

	{

	}
}
