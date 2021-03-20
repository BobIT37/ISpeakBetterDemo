package util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class ElementUtil extends BasePage {

    WebDriver driver;

    //Constructor
    public ElementUtil (WebDriver driver){
        this.driver = driver;
    }

    public WebElement getElement(By locator){
        waitForElementPresentBy(locator);

        WebElement element = null;
        try{
            element = driver.findElement(locator);
            if(flash.equalsIgnoreCase("yes")){
                JavaScriptUtil.flash(element, driver);
            }
        } catch (Exception e) {
            System.out.println("some exception occured while creating webelement "+ locator);
        }
        return element;
    }

    public void waitForElementPresentBy(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void doClick(By locator){
        try{
            getElement(locator).click();
        }
        catch(Exception e){
            System.out.println("Some exception occured while click on  webelement " +locator);
        }
    }

    public void doSendKeys(By locator, String value){
        try{
            getElement(locator).clear();
            getElement(locator).sendKeys(value);
        }
        catch(Exception e){
            System.out.println("Some exception occured while sending to  webelement " + locator);
        }
    }

    public String doGetText(By locator){
        String text = null;
        try {
            text = getElement(locator).getText();
        } catch (Exception e) {
            System.out.println("some exception occured while get text to webelement "+ locator);
        }
        return text;
    }

    public String waitForGetPageTitle(String title){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleContains(title));
        return driver.getTitle();
    }

    public boolean isElementDisplayed(By locator){
        try{
            return getElement(locator).isDisplayed();
        }catch (Exception e) {
            System.out.println("some exception occured while checking webelement displayed "+ locator);
            return false;
        }
    }

    public boolean isElementEnabled(By locator){
        try{
            return getElement(locator).isDisplayed();
        }catch (Exception e) {
            System.out.println("some exception occured while checking webelement displayed "+ locator);
            return false;
        }
    }
   
   public String selectSingleValue(WebDriver driver, By locator, String value) {
		
		List<WebElement> dropList = driver.findElements(locator);
		//System.out.println(dropList.size());
		
		for(int i= 0; i<dropList.size(); i++) {
			String text = dropList.get(i).getText();
			//System.out.println(text);
			
			try {
				if(!text.isEmpty()) {  //use not equal to select any value
					if(text.equals(value)) {
						//System.out.println(text);
						dropList.get(i).click();
						break;
					}
				}
			} catch (Exception e) {
				

			}
		}
		return value;
	}
}

