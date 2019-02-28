package facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;
	By name = By.xpath("//*[@id='navItem_100009870483783']//div[@dir='ltr']");
	By navigateMenu = By.id("userNavigationLabel");
	By logout = By.xpath("//*[text()='Log Out']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getName() {
		return driver.findElement(name);
	}
	
	public WebElement getNavigateMenu() {
		return driver.findElement(navigateMenu);
	}
	
	public WebElement getLogout() {
		return driver.findElement(logout);
	}
}
