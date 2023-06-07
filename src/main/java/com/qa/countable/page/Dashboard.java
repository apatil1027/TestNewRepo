package com.qa.countable.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.countable.base.Basepage;

public class Dashboard extends Basepage {

	WebDriver driver;
	//JavascriptExecutor js=(JavascriptExecutor) driver;

	By header = By.xpath("//h4[contains(text(),'Dashboard')]");
	By search = By.xpath("//input[@id='mat-input-2']");
	By notifications = By.xpath("//mat-icon[contains(text(),'notifications')]");
	By viewteam= By.xpath("//span[contains(text(),'View Team')]");
	By viewclient=By.xpath("//span[contains(text(),'View Clients')]");
	//By teamdashboard=By.xpath("//div[@class='team-dashboard-header']");
	//By dashboardredirect=By.xpath("//i[normalize-space()='dashboard']");
	//By Menu=By.xpath("//i[@class='material-icons icon ng-star-inserted']");
	By SearchResults=By.className("mat-content");
	

	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}
	
	public String dashboardtitle() {
		return driver.getTitle();
	}

	public String getHomepageheader() {
		return driver.findElement(header).getText();
	}

	public void searchonDashboard() throws InterruptedException {
		driver.findElement(search).sendKeys("v15");
		Thread.sleep(5000);
	}

	/*public void clickonNotification() throws InterruptedException {
		driver.findElement(notifications).click();
		Thread.sleep(5000);
		driver.switchTo().activeElement().findElement(search);
	}*/
	
	public void ViewTeamClick() throws InterruptedException
	{
		driver.findElement(viewteam).click();
		Thread.sleep(3000);
	}
	
	public void BackOnDashboard() throws InterruptedException
	{
		
		driver.navigate().back();
		Thread.sleep(5000);
	}
	
	
	/*public void ViewClientClick() throws InterruptedException
	{
		driver.findElement(viewclient).click();
		Thread.sleep(2000);
	}*/
	


}
