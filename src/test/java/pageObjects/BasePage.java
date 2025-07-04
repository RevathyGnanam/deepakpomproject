package pageObjects;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasePage {
	
	public WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	

}
