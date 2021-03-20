package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import util.Constants;
import util.ElementUtil;
import util.JavaScriptUtil;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//Locators 
	//non-page factory == By email = By.id(locator);
	//page factory = findBy , findBys == element =  id(locator)
	
	By clickLogin = By.id("cmdSiginLink");
	By email = By.xpath("//input[@id='_email']");
	By password  = By.id("_");
	By login = By.id("cmdSignin");
	By clickSignin = By.id("signin");
	By duration = By.xpath("//span[@id='select2-class_duration-container']");
	By list = By.className("select2-results__option");
	By subscribed = By.xpath("//span[@id='select2-package_length-container']");
	By weeklyClass = By.xpath("//span[@id='select2-per_week_class_number-container']");
	By program = By.xpath("//span[@id='select2-course_program-container']");
	
	//Page Actions (Methods)
	
	public String getPageTitle() {
		return elementUtil.waitForGetPageTitle(Constants.LOGIN_PAGE_TITLE_STRING);
	}
	
	public String duration() {
		JavaScriptUtil.scrollDownSpecific(driver);
		elementUtil.waitForElementPresentBy(duration);
		elementUtil.doClick(duration);
		return elementUtil.selectSingleValue(driver, list, "60");
	}
	public String subscribed() {
		elementUtil.waitForElementPresentBy(subscribed);
		elementUtil.doClick(subscribed);
		return elementUtil.selectSingleValue(driver, list, "2 weeks");
	}
	public String weeklyClass() {
		elementUtil.waitForElementPresentBy(weeklyClass);
		elementUtil.doClick(weeklyClass);
		return elementUtil.selectSingleValue(driver, list, "2 Classes");
	}
	public String program() {
		elementUtil.waitForElementPresentBy(program);
		elementUtil.doClick(program);
		return elementUtil.selectSingleValue(driver, list, "Conversational English");
	}
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
