package StepsDefination;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import factory.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;


public class LoginSteps {
	HomePage home  = new HomePage(BaseTest.getDriver());;
	LoginPage login;
	MyAccountPage mac=new MyAccountPage(BaseTest.getDriver());;
	 List<HashMap<String, String>> datamap;

	@Given("the user navigate to login page")
	public void the_user_navigate_to_login_page() {
		BaseTest.getLogger().info("Go to My account-> click on login button");
		
		home.clickMyAccount();
		login = home.clickLogin();

	}

	@When("the use enters email as {string} and password as {string}")
	public void the_use_enters_email_as_and_password_as_test(String email, String password) {
		BaseTest.getLogger().info("Enters email and password");
		login.enterEmail(email);
		login.enterPassword(password);
	}

	@And("the user click on lofin button")
	public void the_user_click_on_lofin_button() {
		BaseTest.getLogger().info("The user click on lofin button");
		login.clickLogin();
	}

	@Then("the user should be redirect to the my account page")
	public void the_user_should_be_redirect_to_the_my_account_page() {
		BaseTest.getLogger().info("The user should be redirect to the my account page");
		boolean status = login.isMyAccountExist();
		Assert.assertEquals(status, true);
	}
	@And("the user get the title of the myaccount page")
	public void the_user_get_the_title_of_the_myaccount_page() {
		BaseTest.getLogger().info("Verify title of the Page");
		String actualtitle=BaseTest.getDriver().getTitle();
		System.out.println(actualtitle);
		Assert.assertEquals(actualtitle, "My Account");
	}
	
	@When("the user navigates to my account page by passing email and passwordwith excel row {string}")
	public void the_user_navigates_to_my_account_page_by_passing_email_and_passwordwith_excel_row(String row) {
	    try {
	    	datamap=DataReader.data(System.getProperty("user.dir")+"\\excel\\Testdata.xlsx", "Login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    int index=Integer.parseInt(row)-1;
        String email= datamap.get(index).get("username");
        String pwd= datamap.get(index).get("password");
        String exp_res= datamap.get(index).get("res");
		login.enterEmail(email);
		login.enterPassword(pwd);
		login.clickLogin();
		boolean status = login.isMyAccountExist();
		System.out.println(status);
		if(exp_res.equalsIgnoreCase("valid")) {
			if(status==true) {
				
				mac.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		else if(exp_res.equalsIgnoreCase("invalid")) {
			if(status==true) {
				mac.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
	}


}
