package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementUtil;

public class LoginParallel {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//Constructor
	public LoginParallel(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//Locators 
	//non-page factory == By email = By.id(locator);
	//page factory = findBy , findBys == element =  id(locator)
	
	By clickLogin = By.id("cmdSiginLink");
	By email = By.xpath("//input[@id='_email']");
	By password  = By.id("_password");
	By login = By.id("cmdSignin");
	By clickSignin = By.id("signin");

	
	//Page Actions (Methods)
	
	public void doLogin(String username, String pwd) {
		//driver.findElement(clickLogin).click();
		elementUtil.doClick(clickLogin);
		elementUtil.waitForElementPresentBy(clickSignin);
		elementUtil.doClick(clickSignin);
		elementUtil.isElementEnabled(email);
		elementUtil.doSendKeys(email, username);
		elementUtil.waitForElementPresentBy(password);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.waitForElementPresentBy(login);
		elementUtil.doClick(login);
		
	}
	

}
