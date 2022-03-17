package FrameworkPackages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class BrowserFactory {
	
	public static WebDriver driver;
	configPropReader properties = new configPropReader();
	String baseUrl;
	
	public BrowserFactory() {
		
	}

	public static WebDriver getDriver() {
		if(driver == null) {
			//ChromeOptions options = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers-Automation\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	public static WebDriver getDriver(String browserName) {
		if(driver == null) {
			if(browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Drivers-Automation\\Gecko\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
			}else if(browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Drivers-Automation\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
			}
			
		}
		return driver;
	}
	
	
	public void DriverInit() {
		System.out.println("driver init isnull");
		 driver = this.getDriver("chrome");
		  baseUrl = properties.getApplicationUrl();
		  System.out.println("baseUrl");
		  
		
	}
	
	public void getURL() {
		driver.get(baseUrl);
	}
	
	
	public void driverQuit() {
		driver.quit();
	}
	
	
}
