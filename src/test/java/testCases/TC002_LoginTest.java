package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.DemoHomePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void verify_Login() {
		HomePage homepage = new HomePage(driver);
		homepage.clickLogin();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailID(prp.getProperty("userName"));
		loginPage.enterPassword(prp.getProperty("password"));
		loginPage.clickLoginButton();
		
		DemoHomePage demopage = new DemoHomePage(driver);
		Assert.assertTrue(demopage.verifylogoutButton());
		
		demopage.clickLogoutButton();
		
		
	}

}
