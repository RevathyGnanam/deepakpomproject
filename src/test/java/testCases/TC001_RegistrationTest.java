package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.AccountRegPage;
import pageObjects.BasePage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_RegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	public void AccountRegistration() {
		HomePage homepage = new HomePage(driver);
		homepage.clickRegister();
		
		AccountRegPage regpage = new AccountRegPage(driver);
		regpage.selectGender();
		regpage.enterFirstName(randomString());
		regpage.enterLastName(randomString());
		regpage.enterEmailId(randomAlphaNumeric()+"@gmail.com");
		String password = randomAlphaNumericForPasswords();
		regpage.enterPassword(password);
		regpage.enterConfirmPassword(password);
		regpage.clickRegister();
		String actualTitle = regpage.getTitle();
		String expectedTitle = regpage.getTitleTextBox();
		Assert.assertEquals(actualTitle, expectedTitle);
		String confirmmsg = regpage.getConfirmationText();
		Assert.assertEquals(confirmmsg, "Your registration completed");
		regpage.clickContinue();
		
	}
	
	

	
	

}
