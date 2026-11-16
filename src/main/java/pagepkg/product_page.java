package pagepkg;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class product_page {

	
	WebDriver driver;
	
	
	@FindBy(xpath="//*[@id=\"header_container\"]/div[1]/div[2]/div")
	public WebElement logo;
	
	@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/div/span/select")
	public WebElement dpdn;
	
	@FindBy(xpath="//button[text()='Add to cart']")
	public List<WebElement> cartbtn;
	
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a")
	public WebElement cartcount;
	
	@FindBy(xpath="/html/body/div/div/div/div/div/div/div/div/div/div/a/div")
	public List<WebElement> title;
	
	@FindBy(xpath="/html/body/div/div/div/div/div/div/div/div/div/div[1]")
	public List<WebElement> cont;
	
	@FindBy(xpath="/html/body/div/div/div/div/div/div/div/div/div/div[2]/div")
	public List<WebElement> price;
	
	@FindBy(xpath="//*[@id=\"reset_sidebar_link\"]")
	public WebElement resetapp;
	
	@FindBy(xpath="//*[@id=\"react-burger-menu-btn\"]")
	public WebElement hbr;
	
	@FindBy(xpath="//*[text()='Remove']")
	public List<WebElement> removebtn;
	
	
	public product_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	

	public WebElement logoverification()
	{
		return logo;
	}
	
	public void dropdownverification()
	{
		Select ob = new Select(dpdn);
		ob.selectByVisibleText("Price (low to high)");
	}
	
	
	public void additemstocart() throws InterruptedException
	{
		for(WebElement cart:cartbtn)
		{
			Thread.sleep(2000);
			cart.click();
			
		}
		
	}
	
	public String getcartcount()
	{
		return cartcount.getText();
	}
	
//	public void handlepopup()
//	{
//		driver.switchTo().alert().accept();
//	}
	
	public List<WebElement> producttitle()
	{
		return title;
	}
	
	public List<WebElement> productcontent()
	{
		return cont;
	}
	
	public List<WebElement> productprice()
	{
		return price;
	}
	
	public void resetappstate() throws InterruptedException
	{
		hbr.click();
		Thread.sleep(2000);
		resetapp.click();
	}
	
	
	
}
