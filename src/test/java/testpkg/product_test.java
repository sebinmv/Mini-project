package testpkg;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.base_class;
import basepkg.reporter_class;
import pagepkg.login_page;
import pagepkg.product_page;

public class product_test extends base_class{

	
	login_page log;
	product_page prod;
	
	
	@Test(priority=1)
	public void logoverification() throws IOException
	{
//		log=new login_page(driver);
//		log.loginvalues("standard_user","secret_sauce");
		test=extent.createTest("Product Page Logo Validation Test");
		prod=new product_page(driver);
		WebElement x=prod.logoverification();
		if(x.isDisplayed())
		{
			System.out.println("Product Page Logo displayed");
			test.pass("Product Page Logo displayed");
		}
		else
		{
			String screenshotname="Product Page Logo validation";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Product Page Logo not displayed");
			Assert.fail("Product Page Logo not displayed");
		}	

	}
	
	
	
	
	@Test(priority=2)
	public void dropdownverification() throws IOException
	{
		test=extent.createTest("DropDown Validation Test");
		prod=new product_page(driver);
		prod.dropdownverification();
		String s=prod.dpdn.getAttribute("value");
		if(s.equals("lohi"))
		{
			test.pass("Dropdown verified");
		}
		else
		{
			String screenshotname="Dropdown Handle";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Dropdown not verified");
			Assert.fail("Dropdown not verified");
		}
	}
	
	
	
	
	@Test(priority=3)
	public void addtocart() throws IOException, InterruptedException
	{
//		driver.get("https://www.saucedemo.com/inventory.html");
		test=extent.createTest("Add To Cart Validation Test");
		prod=new product_page(driver);
//		prod.handlepopup();
		prod.additemstocart();
		String count=prod.getcartcount();
		if(count.equals("6"))
		{
			test.pass("Items added to cart successfully");
			System.out.println("The no of items added to cart: "+count);
		}
		else
		{
			String screenshotname="Add To Cart";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Add to cart failed ");
			Assert.fail("Add to cart failed");
		}
	}
	
	
	
	@Test(priority=4)
	public void getproductdetails() throws IOException
	{
		test=extent.createTest("Product Details Validation Test");
		prod=new product_page(driver);
		
		List<WebElement> title = prod.producttitle();
		List<WebElement> cont = prod.productcontent();
		List<WebElement> price = prod.productprice();
		
		System.out.println("Total no of products:" +title.size());
		
		for(int i=0;i<title.size();i++)
		{
			System.out.println("Product-"+(i+1));
			System.out.println("Title- "+title.get(i).getText());
			System.out.println("Description- "+cont.get(i).getText());
			System.out.println("Price- "+price.get(i).getText());
			System.out.println("--_-_-_-_-_-_-_-_-_-_--");
		}
		if(title.size()==6 && cont.size()==6 && price.size()==6)
		{
			test.pass("All products fetched successfully");
		}
		else
		{
			String screenshotname="Product Details";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Failed in fetching product details");
			Assert.fail("Failed in fetching product details");
		}
	}
	
	
	
	
	@Test(priority=5)
	public void resetappstate() throws IOException, InterruptedException
	{
		test=extent.createTest("Reset App Validation Test");
		prod=new product_page(driver);
		prod.resetappstate();
		if(prod.removebtn.size()==0)
		{
			test.pass("Reset app successfully");
		}
		else
		{
			String screenshotname="Reset App";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Failed to reset app");
			Assert.fail("Failed to reset app");
		}
	
	}
	

}
