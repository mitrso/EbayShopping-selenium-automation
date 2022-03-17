package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import FrameworkPackages.BrowserFactory;
import FrameworkPackages.configPropReader;
import junit.framework.Assert;

public class Cart extends BrowserFactory{
	WebDriver driver;
	configPropReader properties = new configPropReader();
	SearchNselect SSDetails = new SearchNselect();
	
	public void CartConfirm(){
		driver = BrowserFactory.driver;
		WebElement ShoppingCartTitle = driver.findElement(By.xpath("//h1[@class='main-title']"));
		Assert.assertEquals(ShoppingCartTitle.getText(), "Shopping cart (1 item)");
		
		
	}

}
