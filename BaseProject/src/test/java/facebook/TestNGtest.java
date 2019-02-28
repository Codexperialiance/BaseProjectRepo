package facebook;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Resources.Base;


public class TestNGtest extends Base{

	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		browserSetup(browser);
	}
	
	@Parameters({"url","email","pass"})
	@Test(priority=1)
	public void testCase1(String url, String email, String pass) {
	
		   LogInPage lp = new LogInPage(driver);
	       lp.navigateTo(url);
	       lp.getEmail().sendKeys(email);
	       lp.getPass().sendKeys(pass);
	       lp.getLogin().click();
	}
	
	@Parameters("expected")
	@Test(priority=2)
	public void testCase2(String expected) {
		HomePage hp = new HomePage(driver);
		String actual = hp.getName().getText();
		
		Assert.assertEquals(expected, actual);
		hp.getNavigateMenu().click();
		hp.getLogout().click();
	}
	
	@AfterTest
	public void finalizing() {
		driver.quit();
	}
}
