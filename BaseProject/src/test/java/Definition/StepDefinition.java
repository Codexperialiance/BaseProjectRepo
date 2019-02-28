package Definition;
import org.openqa.selenium.By;
import org.testng.Assert;

import Resources.Base;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import facebook.HomePage;
import facebook.LogInPage;

public class StepDefinition extends Base{
	@Given("^User is on facebook login page using \"([^\"]*)\" browser$")
	public void user_is_on_facebook_login_page_using_browser(String arg1) throws Throwable {
		browserSetup(arg1);
		LogInPage lp = new LogInPage(driver);
		String url = "https://www.facebook.com/";
	    lp.navigateTo(url);
	}

	@When("^User inputs email \"([^\"]*)\" and password \"([^\"]*)\" and click login button$")
	public void user_inputs_email_and_password_and_click_login_button(String arg1, String arg2) throws Throwable {
			LogInPage lp = new LogInPage(driver);
		   lp.getEmail().sendKeys(arg1);
	       lp.getPass().sendKeys(arg2);
	       lp.getLogin().click();	
	}

	@Then("^User lands on home page where users name \"([^\"]*)\" is displayed$")
	public void user_lands_on_home_page_where_users_name_is_displayed(String arg1) throws Throwable {
		 	HomePage hp = new HomePage(driver); 
			String actual = hp.getName().getText();
			 String expected = arg1;
			 Assert.assertEquals(expected, actual);
	}

	@Then("^then User navigates to menu and clicks menu button$")
	public void then_User_navigates_to_menu_and_clicks_menu_button() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getNavigateMenu().click();
	}

	@Then("^then click logout button and User successfuly logout from facebook$")
	public void then_click_logout_button_and_User_successfuly_logout_from_facebook() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getLogout().click();
		
		String actual = driver.getTitle();
		String expected = "Facebook - Log In or Sign Up";
		Assert.assertEquals(actual, expected);
		driver.quit();
	}
}
