package facebook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Keyword {

	WebDriver driver;
	
	public Keyword(WebDriver driver) {
		this.driver = driver;
	}
	
	public void NavigateTo(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void provideText(String locatorType, String locatorValue, String parameter) {
		if(locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).sendKeys(parameter);
		}
		else if(locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).sendKeys(parameter);
		}
	}
	
	public void clickElement(String locatorType, String locatorValue) {
		if(locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).click();;
		}
		else if(locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).click();;
		}
	}
}
