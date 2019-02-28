package facebook;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Resources.Base;


public class DataDriven extends Base{
	 @BeforeTest
	    public void setup() {
	    	String browser = "chrome";
	    	browserSetup(browser);
	   }
	    
		@Test(dataProvider="mydata")
	    public void loginPageTest(String url,String email, String pass, String expected)
	    {
		   LogInPage lp = new LogInPage(driver);
	       lp.navigateTo(url);
	       lp.getEmail().sendKeys(email);
	       lp.getPass().sendKeys(pass);
	       lp.getLogin().click();
	       	HomePage hp = new HomePage(driver);
			String actual = hp.getName().getText();
			Assert.assertEquals(expected, actual);
			hp.getNavigateMenu().click();
			hp.getLogout().click();
	    }
		
		@AfterTest
		public void finalize() {
			driver.quit();
		}
		
		@DataProvider
		public String[][] mydata() {
			String[][] data = new String[1][4];
			data[0][0] = "https://www.facebook.com/"; 
			data[0][1] = "be75ega@gmail.com";
			data[0][2] = "kaku23";
			data[0][3] = "Mekdes Tadesse";
			return data;
		}
}
