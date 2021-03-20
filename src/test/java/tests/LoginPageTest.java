package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import pages.LoginPage;
import util.Constants;

public class LoginPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
	}
	@Test(priority = 1, enabled = true, description = "I Speak Better Main Page title")
	public void testPageTitle() {
		String title = loginPage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE_STRING);
	}
	@Test(priority = 2, enabled = true, description = "flexible package")
	public void filexiblePackage() {
		Assert.assertEquals(loginPage.duration(), "60");
		Assert.assertEquals(loginPage.subscribed(), "2 weeks");
		Assert.assertEquals(loginPage.weeklyClass(), "2 Classes");
		Assert.assertEquals(loginPage.program(), "Conversational English");
	}
	
	@Test(priority = 3, enabled = true, description = "login system in I Speak Better")
	public void testLogin() throws InterruptedException {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
	}
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
	

}

