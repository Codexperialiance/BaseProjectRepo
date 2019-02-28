package facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

	WebDriver driver;
	By userName = By.id("email");
	By pass = By.id("pass");
	By login = By.xpath("//*[@id='loginbutton']//input");
	
	public LogInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEmail() {
		return driver.findElement(userName);
	}
	
	public WebElement getPass() {
		return driver.findElement(pass);
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public void navigateTo(String url) {
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
}
