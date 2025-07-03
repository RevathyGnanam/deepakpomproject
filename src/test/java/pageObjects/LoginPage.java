package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="Email")
	WebElement emailtextBox;

	@FindBy(id="Password")
	WebElement PasswordtextBox;

	@FindBy(xpath="//*[@class='button-1 login-button']")
	WebElement loginButton;
	
	public void enterEmailID(String emailId) {
		emailtextBox.sendKeys(emailId);
	}
	
	public void enterPassword(String password) {
		PasswordtextBox.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}

}
