package lambdaTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class LambdaBassClass{
	static WebDriver driver;

	@Parameters("browser")
	@BeforeTest()
	public void browerSetUp(String browser) throws MalformedURLException
	{
		/*
		 * WebDriverManager.chromedriver().setup();
		 * WebDriverManager.edgedriver().setup();
		 * WebDriverManager.firefoxdriver().setup();
		 * WebDriverManager.iedriver().setup();
		 * 
		 * driver = new ChromeDriver();
		 */
		/*
		 * ChromeOptions browserOptions = new ChromeOptions();
		 * browserOptions.setPlatformName("Windows 10");
		 * browserOptions.setBrowserVersion("104.0"); HashMap<String, Object> ltOptions
		 * = new HashMap<String, Object>(); ltOptions.put("username",
		 * "Your LambdaTest Username"); ltOptions.put("accessKey",
		 * "Your LambdaTest Access Key"); ltOptions.put("project", "Untitled");
		 * ltOptions.put("selenium_version", "4.0.0"); ltOptions.put("w3c", true);
		 * browserOptions.setCapability("LT:Options", ltOptions);
		 */
		if(browser.equalsIgnoreCase("chrome"))
		{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		caps.setCapability("platform", "Windows 10");
		driver = new RemoteWebDriver(new URL(" http://192.168.1.7:4444"),caps);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			DesiredCapabilities caps1 = new DesiredCapabilities();
			caps1.setCapability(CapabilityType.BROWSER_NAME, "firefox");
			caps1.setCapability("platform", "Windows 10");
			driver = new RemoteWebDriver(new URL(" http://192.168.1.7:4444"),caps1);
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			DesiredCapabilities caps2 = new DesiredCapabilities();
			caps2.setCapability(CapabilityType.BROWSER_NAME, "MicrosoftEdge");
			caps2.setCapability("platform", "Windows 10");
			driver = new RemoteWebDriver(new URL(" http://192.168.1.7:4444"),caps2);
		}
	}
	
	@BeforeMethod()
	public void preCondition() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/");
	}

	@AfterTest()
	public void postCondition() {
		driver.close();
	}
}
