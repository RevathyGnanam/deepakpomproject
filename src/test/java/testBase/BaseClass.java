package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	 static public WebDriver driver;
	 public Properties prp;

	@BeforeClass(groups= {"Regression","Master","Sanity"})
	@Parameters({"browser"})
	public void setUp(String br) throws IOException  {
		
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		  prp = new Properties();
		prp.load(file);

		switch(br.toLowerCase()) {
		case "chrome":	driver = new ChromeDriver(); break;
	//	case "edge": driver = new EdgeDriver(); break;
		
		default: System.err.println("No browser launched"); return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prp.getProperty("appUrl"));
		driver.manage().window().maximize();
	}

	@AfterClass(groups= {"Regression","Master","Sanity"})
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomAlphaNumeric() {
		String generatedEmailString = RandomStringUtils.randomAlphabetic(3)+RandomStringUtils.randomNumeric(3);
		return generatedEmailString;
	}
	public String randomAlphaNumericForPasswords() {
		String generatedpasswordString = RandomStringUtils.randomAlphabetic(3)+RandomStringUtils.randomNumeric(3)+"@";
		return generatedpasswordString;
	}
	
	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File srcFile = screenShot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" + tname +"_" + timeStamp;
		File targetFile = new File(targetFilePath);

		srcFile.renameTo(targetFile);

		return targetFilePath;



		}



}
