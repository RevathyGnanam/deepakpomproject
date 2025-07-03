package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoHomePage extends BasePage {

	public DemoHomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@class='ico-logout']")
	WebElement logoutButton;
	
	public boolean verifylogoutButton() {
		try {
		return logoutButton.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
				
	}
	
	public void clickLogoutButton() {
		logoutButton.click();
	}

}
