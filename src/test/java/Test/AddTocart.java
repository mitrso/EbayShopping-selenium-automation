package Test;

import org.testng.annotations.Test;

import FrameworkPackages.BrowserFactory;
import FrameworkPackages.configPropReader;
import Pages.Cart;
import Pages.SearchNselect;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AddTocart extends BrowserFactory{
	WebDriver driver;
	String baseUrl;
	SearchNselect SSObj = new SearchNselect();
	configPropReader properties = new configPropReader();
	Cart cart = new Cart();
	
//	SearchNselect SSObj;
	
	
  @Test
  public void TestAdd() throws Exception{
	  try {
			Thread.sleep(2000);
			SSObj.SearchFunc();
			Thread.sleep(5000);
			SSObj.selectItem();
			cart.CartConfirm();
			
			
		} catch(Exception e){
			System.out.println("in exception"+ e);
			
		}
	  
  }
  
  @BeforeTest
  public void Beforetest() {
	  DriverInit();
	  getURL();
  }
  
  @AfterTest
  public void Aftertest() {
	  driverQuit();
  }
  

}
