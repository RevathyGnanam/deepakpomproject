package testCases;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.DemoHomePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginTestFromDataDriven extends BaseClass{
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups= "dataDriven")
	public void verify_Login(String email,String pass) {
		HomePage homepage = new HomePage(driver);
		homepage.clickLogin();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailID(email);
		loginPage.enterPassword(pass);
		loginPage.clickLoginButton();
		
		DemoHomePage demopage = new DemoHomePage(driver);
		Assert.assertTrue(demopage.verifylogoutButton());
		
		demopage.clickLogoutButton();
		
		
	}

}
