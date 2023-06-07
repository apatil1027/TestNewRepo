package com.qa.countable.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.countable.base.Basepage;
import com.qa.countable.page.Dashboard;
import com.qa.countable.page.LoginPage;

public class DashboardTest {

	WebDriver driver;
	Basepage basepage;
	Properties prop;
	LoginPage lp;
	Dashboard dashboard;

	@BeforeTest
	public void setup() throws InterruptedException {
		basepage = new Basepage();
		prop = basepage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basepage.init_driver(browserName);
		driver.get(prop.getProperty("url"));

		lp = new LoginPage(driver);
		dashboard = lp.dologin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);

	}

	@Test(priority = 1)
	public void verifyHomeTitle() {
		String hptitle = dashboard.dashboardtitle();
		System.out.println("Homepage title is " + hptitle);
		Assert.assertEquals(hptitle, "Countable");

	}

	@Test(priority = 2)
	public void HomepageHeader() {
		String hpheader = dashboard.getHomepageheader();
		System.out.println("Header on homepage is " + hpheader);
		Assert.assertEquals(hpheader, "Dashboard");

	}

	@Test(priority = 3)
	public void DashboardSearch() throws InterruptedException {

		dashboard.searchonDashboard();
		System.out.println("Search functionality is working fine ");
	}
	/*
	 * @Test(priority=4) public void Notifications() throws InterruptedException {
	 * dashboard.clickonNotification(); }
	 */

	@Test(priority = 4)
	public void ViewTeam() throws InterruptedException {
		dashboard.ViewTeamClick();

	}

	@Test(priority = 5)
	public void BackDashboard() throws InterruptedException {
		dashboard.BackOnDashboard();
	}

	/*@Test(priority = 6)
	public void ViewClient() throws InterruptedException {
		dashboard.ViewClientClick();
		
		
	}*/

	@AfterTest
	public void teardown() {
		System.out.println("Chrome is launch successfully");
	}

}
