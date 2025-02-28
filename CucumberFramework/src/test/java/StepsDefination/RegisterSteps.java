package StepsDefination;

import java.util.Map;

import org.testng.Assert;

import factory.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class RegisterSteps {

	RegisterPage regPage;

	@Given("the user navigate to register page")
	public void the_user_navigate_to_register_page() {
		HomePage home = new HomePage(BaseTest.getDriver());
		home.clickMyAccount();
		regPage = home.clickRegister();
	}

	@When("the user enter details into below fields")
	public void the_user_enter_details_into_below_fields(DataTable dataTable) {

		Map<String, String> data = dataTable.asMap(String.class, String.class);
		regPage.setFirstName(data.get("firstName"));
		regPage.setLastName(data.get("lastName"));
		regPage.setEmail(BaseTest.randomAlphaNumeric() + "@gmail.com");
		regPage.setTelephone(data.get("telephone"));
		regPage.setPassword(data.get("password"));
		regPage.setConfirmPassword(data.get("password"));

	}

	@And("the user select private policy")
	public void the_user_select_private_policy() {
		regPage.setPrivacyPolicy();
	}

	@And("the user click on Continue")
	public void the_user_click_on_continue() {
		regPage.clickContinue();
	}

	@Then("the user account should get successfully")
	public void the_user_account_should_get_successfully() {
		String actualData = regPage.getConfirmationMsg();
		Assert.assertEquals(actualData, "Your Account Has Been Created!");
	}

}
