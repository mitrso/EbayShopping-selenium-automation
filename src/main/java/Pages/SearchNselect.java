package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import FrameworkPackages.BrowserFactory;
import FrameworkPackages.configPropReader;
import Test.AddTocart;



public class SearchNselect extends BrowserFactory{
	WebDriver driver;
	configPropReader properties = new configPropReader();
	
	
		
	public void SearchFunc() {
		driver = BrowserFactory.driver;
		try {
				String Item = properties.getItem();
				WebElement SearchTextBox = BrowserFactory.driver.findElement(By.id("gh-ac"));
				System.out.println("in searchfunc&getitem"+properties.getItem());
				SearchTextBox.sendKeys(Item);
				Thread.sleep(5000);
				WebElement SearchButton = BrowserFactory.driver.findElement(By.id("gh-btn"));
				SearchButton.click();
				Thread.sleep(5000);
				WebElement SearchResult = BrowserFactory.driver.findElement(By.xpath("//b[contains(text(),"+"'"+properties.getItem()+"'"+")]"));
				Assert.assertTrue(SearchResult.isDisplayed());
			}
			
		catch(Exception e) {
			System.out.println("in searchfunc exception" + e);
			
		}
	}
		
	 public List<String> selectItem() {
		 driver = BrowserFactory.driver;
		 List<String> ItemDetails = new ArrayList<String>();
		try {
			System.out.println("Selecting item");
			System.out.println("'"+properties.getItem()+"'");
			List<WebElement> ResultLink = BrowserFactory.driver.findElements(By.xpath("//a[contains(text(),"+"'"+properties.getItem()+"'"+")]"));
			System.out.println(ResultLink);
			String ItemtobeAdded = ResultLink.get(2).getText();
			ResultLink.get(2).click();
			Thread.sleep(4000);
			ItemDetails.add(0,ItemtobeAdded);
			ItemDetails.add(1,PriceInfo());
			ItemDetails.add(2,SellerInfo());
			WebElement AddCartBtn = BrowserFactory.driver.findElement(By.id("isCartBtn_btn"));
			AddCartBtn.click();
			Thread.sleep(3000);
			WebElement CartIcon = BrowserFactory.driver.findElement((By.xpath("//*[@class='gh-cart-icon']")));
			CartIcon.click();
		}catch(Exception e) {
				System.out.println("in Selectitem exception" + e);
			}
		return ItemDetails;
		}
	 
	 public String PriceInfo(){
		String Price = null;
		WebElement ItemPrice = BrowserFactory.driver.findElement(By.xpath("//span[@id='prcIsum']"));
		System.out.println(ItemPrice.getText());
		Price = ItemPrice.getText();
		return Price;
		 
	 }
	 
	 public String SellerInfo(){
			String Seller = null;
			WebElement ItemsSeller = BrowserFactory.driver.findElement(By.xpath("//span[@class='mbg-nw']"));
			System.out.println(ItemsSeller.getText());		 
			Seller = ItemsSeller.getText().trim();
			return Seller;
			 
		 }
	 
	 
		
	
}
