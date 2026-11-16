package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class base_class {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	
	public String url = "https://www.saucedemo.com/";
	
	@BeforeSuite
	public void browser_launch()
	{
		
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		extent = reporter_class.sevi();
	}
	
	@AfterSuite
	public void end()
	{
		driver.quit();
		extent.flush();
	}
}
