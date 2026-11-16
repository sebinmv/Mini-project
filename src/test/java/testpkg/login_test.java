package testpkg;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepkg.base_class;
import basepkg.reporter_class;
import pagepkg.login_page;
import utilitiespkg.excelutility;

public class login_test extends base_class {

	login_page log;
	
	
	
	@Test(priority=1)
	public void logoverification() throws IOException
	{
		test=extent.createTest("Logo Validation Test");
		log = new login_page(driver);
		WebElement i  = log.logoverification();
		if(i.isDisplayed())
		{
			System.out.println("Logo displayed");
			test.pass("Logo displayed");
		}
		else
		{
			String screenshotname="Logo validation";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Logo not displayed");
			Assert.fail("Logo not displayed");
		}
	}
	
	
	
	
	@Test(priority=2)
	public void titleverification() throws IOException
	{
		test=extent.createTest("Title Validation Test");
		String expected="Swag Labs";
		String actual=driver.getTitle();
		System.out.println(actual);
		if(expected.equals(actual))
		{
			test.pass("Title verified");
		}
		else
		{
			String screenshotname="Title validation";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Title verification failed");
			Assert.fail("Title incorrect");
		}
	}
	
	
	
	
	@DataProvider(name="loginData")
	public Object[][] getData() throws IOException
	{
		String path="C:\\Users\\SEBIN V\\OneDrive\\Documents\\swaglabs.xlsx";
		return excelutility.getTestData(path, "Sheet1");
	}
	
	
	@Test(dataProvider = "loginData",priority=6)
	public void loginverification(String username, String password) throws IOException
	{
		driver.get(url);
		test=extent.createTest("Login Test-"+username);
		log=new login_page(driver);
		log.loginvalues(username,password);
		System.out.println("executed for:" +username);
		String currentUrl=driver.getCurrentUrl();
		if(currentUrl.equals("https://www.saucedemo.com/inventory.html"))
		{
			test.pass("Login successful for:" +username);
		}
		else
		{
			String screenshotname="Login failed" +username;
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Login failed for" +username);
			Assert.fail("Login failed for" +username);
		}
	}
	
	
	
	
	@Test(priority=3)
	public void buttontextverification() throws IOException
	{
		test=extent.createTest("Button Text Validation Test");
		log=new login_page(driver);
		String text=log.login.getDomAttribute("value");
		if(text.equals("Login"))
		{
			test.pass("Button text is Login");
		}
		else
		{
			String screenshotname="Button text validation";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Button text is not Login");
			Assert.fail("Button text is not Login");
		}
	}
	
	
	
	
	@Test(priority=4)
	public void placeholderverification() throws IOException
	{
		test=extent.createTest("Place Holder Validation Test");
		log=new login_page(driver);
		String username=log.user.getDomAttribute("placeholder");
		String password=log.pass.getDomAttribute("placeholder");
		if(username.equals("Username")&&password.equals("Password"))
		{
			test.pass("Placeholder validation passed");
		}
		else
		{
			String screenshotname="Placeholder validation";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Placeholder validation failed");
			Assert.fail("Placeholder validation failed");
		}
	}
	
	
	
	
	
	@Test(priority=5)
	public void copypasteinpassword() throws IOException
	{
		test=extent.createTest("Copy Paste Validation Test");
		log=new login_page(driver);
		log.passwordcopypaste();
		String passwordpresent = log.pass.getAttribute("value");
		if(passwordpresent.equals("standard_user"))
		{
			String screenshotname="Password CopyPaste";
			reporter_class.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath("C:\\Users\\SEBIN V\\eclipse-workspace\\swaglabsminimvn\\reports\\" + screenshotname + ".png");
			test.fail("Password coppied");
			Assert.fail("Password coppied");
		}
		else
		{
			test.pass("Copy Paste Failed");
		}
	}

	
	
}
