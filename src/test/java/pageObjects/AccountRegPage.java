package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegPage extends BasePage {

	public AccountRegPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id="gender-female")
	WebElement genderBulletButton;

	@FindBy(id="FirstName")
	WebElement firstNameTextBox;

	@FindBy(id="LastName")
	WebElement lastNameTextBox;

	@FindBy(id="Email")
	WebElement emailTextBox;

	@FindBy(id="Password")
	WebElement passwordTextBox;

	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTextBox;

	@FindBy(id="register-button")
	WebElement registerButton;

	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div/div[1]/h1")
	WebElement titleTextBox;

	@FindBy(xpath="//*[@class='result']")
	WebElement RegText;

	@FindBy(xpath="//*[@class='button-1 register-continue-button']")
	WebElement continuebutton;


	public void selectGender() {
		genderBulletButton.click();
	}

	public void enterFirstName(String fname) {
		firstNameTextBox.sendKeys(fname);
	}

	public void enterLastName(String fname) {
		lastNameTextBox.sendKeys(fname);
	}

	public void enterEmailId(String email) {
		emailTextBox.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}

	public void enterConfirmPassword(String Confirmpassword) {
		confirmPasswordTextBox.sendKeys(Confirmpassword);
	}

	public void clickRegister() {
		registerButton.click();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getTitleTextBox() {
		try {
			return "Demo Web Shop. Register";
					}
		catch(Exception e) {
			return (e.getMessage());
		}

	}

	public String getConfirmationText() {
		try {
			return RegText.getText();
		}
		catch(Exception e) {
			return (e.getMessage());
		}

	}

	public void clickContinue() {
		//sol1
		continuebutton.click();

		//sol2
		//	Actions act = new Actions(driver);
		//	act.moveToElement(continuebutton).click().perform();

		//sol3
		//continuebutton.submit();

		//sol4
		//	JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("argument[0].click();", continuebutton);

		//sol5
		//continuebutton.sendKeys(Keys.RETURN);

		//sol6
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(continuebutton)).click();





	}






}
