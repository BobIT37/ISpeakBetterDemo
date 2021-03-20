package tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BasePage;
import pages.LoginPage;
import util.ExcelUtil;

public class LoginParallelTest {
	
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

	@DataProvider
	public Object[][] getCredentialsTestData(){
		Object [][] data = ExcelUtil.getTestData("contacts");
		return data;
	}
	@Test(priority=2, dataProvider= "getCredentialsTestData")
	public void createContactsTest(String email, String password) {
		loginPage.doLogin(email, password);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}