package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement setEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement setPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement login;

	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myAccount;
	
	public void enterEmail(String email) {
		setEmail.sendKeys(email);
	}

	public void enterPassword(String password) {
		setPassword.sendKeys(password);
	}

	public void clickLogin() {
		login.click();
	}

	public boolean isMyAccountExist() {
		return myAccount.isDisplayed();
	}
	
}
