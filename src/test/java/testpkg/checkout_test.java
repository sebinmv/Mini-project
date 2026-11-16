package testpkg;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import basepkg.base_class;
import basepkg.reporter_class;
import pagepkg.checkout_page;
import pagepkg.login_page;
import pagepkg.product_page;

public class checkout_test extends base_class {

	
	login_page log;
	product_page prod;
	checkout_page check;
	
	
	
	@Test(priority=1)
	public void carticonclick() throws IOException, InterruptedException
	{
//		log=new login_page(driver);
//		log.loginvalues("standard_user","secret_sauce");
		test=extent.createTest("Cart Icon Validation Test");
		prod= new product_page(driver);
		prod.additemstocart();
		check = new checkout_page(driver);
		check.carticonclick();
		Thread.sleep(2000);
		String crturl= driver.getCurrentUrl();
		if(crturl.equals("https://www.saucedemo.com/cart.html"))
		{
			test.pass("Cart icon clicked successfully");
		}
		else
		{
			String screenshotname="Cart Icon";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Failed in clicking cart icon");
			Assert.fail("");
		}
	}
	
	
	
	
	@Test(priority=2)
	public void cartremovebtn() throws IOException
	{
		test=extent.createTest("Remove Button Validation Test");
		check = new checkout_page(driver);
		check.cartremovebtn();
		if(check.removebtn.size()==0)
		{
			test.pass("Products Removed successfully");
		}
		else
		{
			String screenshotname="Remove Button";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Failed to remove products");
			Assert.fail("");
		}
		
	}
	
	
	
	
	@Test(priority=3)
	public void checkoutwithnull() throws IOException
	{
		test=extent.createTest("Checkout With Null Validation Test");
		check = new checkout_page(driver);
		check.checkoutwithnull();
		String actual= driver.getCurrentUrl();
		String expected="https://www.saucedemo.com/cart.html";
		if(actual.equals(expected))
		{
			test.pass("checkout with null data is passed");
		}
		else
		{
			String screenshotname="Checkout with null Button";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("checkout with null data is failed");
			Assert.assertEquals(actual,expected);
		}
					
	}
	
	
	
	
	@Test(priority=4)
	public void cancelbtnverification() throws IOException
	{
		test=extent.createTest("Cancel button Validation Test");
		check = new checkout_page(driver);
		check.cancelbtnverify();
		String actual= driver.getCurrentUrl();
		String expected="https://www.saucedemo.com/cart.html";
		if(actual.equals(expected))
		{
			test.pass("Cancel button verified");
		}
		else
		{
			String screenshotname="Cancel Button";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Cancel button verification failed");
			Assert.assertEquals(actual,expected);
		}
	}
	
	
	
	
	@Test(priority=5)
	public void continueshopbutton() throws IOException
	{
		test=extent.createTest("Continue Shopping button Validation Test");
		check = new checkout_page(driver);
		check.continueshopbtn();
		String actual= driver.getCurrentUrl();
		String expected="https://www.saucedemo.com/inventory.html";
		if(actual.equals(expected))
		{
			test.pass("Continue Shopping button verified");
		}
		else
		{
			String screenshotname="Continue Shopping Button";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Continue Shopping button verification failed");
			Assert.assertEquals(actual,expected);
		}
	}
	
	
	
	
	@Test(priority=6)
	public void checkoutnavigation() throws InterruptedException, IOException
	{
		test=extent.createTest(" Checkout Button Navigation Test");
		check = new checkout_page(driver);
		check.addtocrtagn();
		check.carticonclick();
		check.checkoutwithnull();
		String actual= driver.getCurrentUrl();
		String expected="https://www.saucedemo.com/checkout-step-one.html";
		if(actual.equals(expected))
		{
			test.pass("Checkout Navigation Passed");
		}
		else
		{
			String screenshotname="Checkout Navigation";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Checkout Navigation Failed");
			Assert.assertEquals(actual,expected);
		}	
		
	}
	
	
	
	
	@Test(priority=7)
	public void numericinfirstname() throws IOException
	{
		driver.get("https://www.saucedemo.com/checkout-step-one.html");
		test=extent.createTest(" Numeric In FirstName Test");
		check = new checkout_page(driver);
		check.entfirstname("12345");
		check.entlastname("v");
		check.entpostalcode("678876");
		check.continueclick();
		if(driver.getCurrentUrl().contains("checkout-step-one"))
		{
			test.pass("FirstName validation successful");
		}
		else
		{
			String screenshotname="FirstName Validation";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("FirstName accepts numerics");
			Assert.fail("FirstName accepts numerics");
		}
	}
	
	
	
	
	@Test(priority=8)
	public void numericinlastname() throws IOException
	{
		driver.get("https://www.saucedemo.com/checkout-step-one.html");
		test=extent.createTest(" Numeric In LastName Test");
		check = new checkout_page(driver);
		check.entfirstname("sevio");
		check.entlastname("11");
		check.entpostalcode("678876");
		check.continueclick();
		if(driver.getCurrentUrl().contains("checkout-step-one"))
		{
			test.pass("LastName validation successful");
		}
		else
		{
			String screenshotname="LastName Validation";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("LastName accepts numerics");
			Assert.fail("LastName accepts numerics");
		}
	}
	
	
	
	
	@Test(priority=9)
	public void specialcharinfirstname() throws IOException
	{
		driver.get("https://www.saucedemo.com/checkout-step-one.html");
		test=extent.createTest("Special Character In FirstName Test");
		check = new checkout_page(driver);
		check.entfirstname("@!$&^");
		check.entlastname("v");
		check.entpostalcode("678876");
		check.continueclick();
		if(driver.getCurrentUrl().contains("checkout-step-one"))
		{
			test.pass("Special Character In FirstName validation successful");
		}
		else
		{
			String screenshotname="Special Character In FirstName Validation";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("FirstName accepts Special Character");
			Assert.fail("FirstName accepts Special Character");
		}
	}
	
	
	
	
	@Test(priority=10)
	public void specialcharinlastname() throws IOException
	{
		driver.get("https://www.saucedemo.com/checkout-step-one.html");
		test=extent.createTest("Special Character In lastName Test");
		check = new checkout_page(driver);
		check.entfirstname("sevio");
		check.entlastname("@!$&^");
		check.entpostalcode("678876");
		check.continueclick();
		if(driver.getCurrentUrl().contains("checkout-step-one"))
		{
			test.pass("Special Character In lastName validation successful");
		}
		else
		{
			String screenshotname="Special Character In lastName Validation";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("LastName accepts Special Character");
			Assert.fail("LastName accepts Special Character");
		}
	}
	
	
	
	
	@Test(priority=11)
	public void alphabetsinpostalcode() throws IOException
	{
		driver.get("https://www.saucedemo.com/checkout-step-one.html");
		test=extent.createTest("Alphabet In Postal Code Test");
		check = new checkout_page(driver);
		check.entfirstname("sevio");
		check.entlastname("v");
		check.entpostalcode("hello");
		check.continueclick();
		if(driver.getCurrentUrl().contains("checkout-step-one"))
		{
			test.pass("Alphabet in postal code validation successful");
		}
		else
		{
			String screenshotname="Alphabet In Postal Code Validation";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Postal Code Accepts Alphabets");
			Assert.fail("Postal Code Accepts Alphabets");
		}
	}
	
	
	
	@Test(priority=13)
	public void whitespaceinwebelements() throws IOException
	{
		driver.get("https://www.saucedemo.com/checkout-step-one.html");
		test=extent.createTest("White Space In Webelements Test");
		check = new checkout_page(driver);
		check.entfirstname(" ");
		check.entlastname(" ");
		check.entpostalcode(" ");
		check.continueclick();
		if(driver.getCurrentUrl().contains("checkout-step-one"))
		{
			test.pass("White space validation successful");
		}
		else
		{
			String screenshotname="White Space In Webelements Validation";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("White space alone is accepting");
			Assert.fail("White space alone is accepting");
		}
	}
	
	
	
	
	@Test(priority=15)
	public void validcredcheckout() throws IOException
	{
		driver.get("https://www.saucedemo.com/checkout-step-one.html");
		test=extent.createTest("Valid Checkout information Test");
		check = new checkout_page(driver);
		check.entfirstname("sevio");
		check.entlastname("v");
		check.entpostalcode("678998");
		check.continueclick();
		if(driver.getCurrentUrl().contains("checkout-step-two"))
		{
			test.pass("Checkout information successfully validated");
			System.out.println("Checkout Information submitted successfully ");
		}
		else
		{
			String screenshotname="Checkout information";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Checkout information validation failed");
			Assert.fail("Checkout information validation failed");
		}
	}
	
	
	
	
	@Test(priority=14)
	public void enterkeyvalidation() throws IOException
	{
		driver.get("https://www.saucedemo.com/checkout-step-one.html");
		test=extent.createTest("Enter Key Validation Test");
		check = new checkout_page(driver);
		check.entfirstname("sevio");
		check.entlastname("v");
		check.entpostalcode("678998");
		check.pressenter();
		if(driver.getCurrentUrl().contains("checkout-step-two"))
		{
			test.pass("User can proceed using enter key");
		}
		else
		{
			String screenshotname="Enter Key Submission";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("User cannot proceed using enter key");
			Assert.fail("Enter key functionality failed");
		}
	}
	
	
	
	
	@Test(priority=17)
	public void orderplacement() throws IOException
	{
		test=extent.createTest("Order Placement Validation Test");
		check = new checkout_page(driver);
		check.finishbutton();
		if(driver.getCurrentUrl().contains("checkout-complete"))
		{
			test.pass("Order placed successfully");
			System.out.println("Order placed successfully! Thankyou for your order!");
		}
		else
		{
			String screenshotname="Order Placement";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Order placement failed");
			Assert.fail("Order placement failed");
		}
	}
	
	
	
	
	@Test(priority=18)
	public void loggingout() throws InterruptedException, IOException
	{
		test=extent.createTest("Logging Out Validation Test");
		check = new checkout_page(driver);
		check.signout();
		if(driver.getCurrentUrl().contains("saucedemo"))
		{
			test.pass("Logged Out Successfully");
			System.out.println("User logged out successfully!");
		}
		else
		{
			String screenshotname="Logout";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Logout failed");
			Assert.fail("Logout failed");
		}
	}
	
	
	
	
	@Test(priority=12)
	public void specialcharinpostalcode() throws IOException
	{
		driver.get("https://www.saucedemo.com/checkout-step-one.html");
		test=extent.createTest("Special Character In Postal Code Test");
		check = new checkout_page(driver);
		check.entfirstname("sevio");
		check.entlastname("v");
		check.entpostalcode("#@$^!");
		check.continueclick();
		if(driver.getCurrentUrl().contains("checkout-step-one"))
		{
			test.pass("Special Character in postal code validation successful");
		}
		else
		{
			String screenshotname="Special Character In Postal Code Validation";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Postal Code Accepts Special Character");
			Assert.fail("Postal Code Accepts Special Character");
		}
	}
	
	
	
	
	@Test(priority=16)
	public void footerlinknavigationverification() throws IOException
	{
		test=extent.createTest("Footer Link Validation Test");
		check = new checkout_page(driver);
		String oldurl = driver.getCurrentUrl();
		check.footerlinkvalidation();
		if(!driver.getCurrentUrl().equals(oldurl))
		{
			test.pass("Footer navigation is passed");
		}
		else
		{
			String screenshotname="Footer Link Validation";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Footer navigation is failed");
			Assert.fail("Footer navigation is failed");
		}
	}
	
	
	
	
	

	
}
