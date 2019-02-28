package facebook;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Keys;

import Resources.Base;
import junit.framework.Assert;


public class AppTest extends Base{

    @Before
    public void setup() {
    	String browser = "chrome";
    	browserSetup(browser);
   }
    
	@Test
    public void loginPageTest()
    {
	   String url = "https://www.facebook.com/";
	   String email = "be75ega@gmail.com";
	   String pass = "kaku23";
	   LogInPage lp = new LogInPage(driver);
       lp.navigateTo(url);
       lp.getEmail().sendKeys(email);
       lp.getPass().sendKeys(pass);
       lp.getLogin().click();
       	HomePage hp = new HomePage(driver);
		String actual = hp.getName().getText();
		String expected = "Mekdes Tadesse";
		Assert.assertEquals(expected, actual);
		hp.getNavigateMenu().click();
		hp.getLogout().click();
    }
	
	@After
	public void finalize() {
		driver.quit();
	}
}
