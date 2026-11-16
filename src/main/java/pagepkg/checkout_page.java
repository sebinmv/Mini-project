package pagepkg;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkout_page {

	
	WebDriver driver;
	
	
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a")
	public WebElement cart;
	
	@FindBy(xpath="/html/body/div/div/div/div/div/div/div/div/div/button")
	public List<WebElement> removebtn;
	
	@FindBy(xpath="//*[@id=\"checkout\"]")
	public WebElement chkoutbtn;
	
	@FindBy(xpath="//*[@id=\"cancel\"]")
	public WebElement cancelbtn;
	
	@FindBy(xpath="//*[@id=\"continue-shopping\"]")
	public WebElement conshopbtn;
	
	@FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
	public WebElement bagaddcart;
	
	@FindBy(xpath="//*[@id=\"first-name\"]")
	public WebElement firstname;
	
	@FindBy(xpath="//*[@id=\"last-name\"]")
	public WebElement lastname;
	
	@FindBy(xpath="//*[@id=\"postal-code\"]")
	public WebElement postalcode;
	
	@FindBy(xpath="//*[@id=\"continue\"]")
	public WebElement continuebtn;
	
	@FindBy(xpath="//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3")
	public WebElement errormsg;
	
	@FindBy(xpath="//*[@id=\"finish\"]")
	public WebElement finishbtn;
	
	@FindBy(xpath="//*[@id=\"logout_sidebar_link\"]")
	public WebElement logout;
	
	@FindBy(xpath="//*[@id=\"react-burger-menu-btn\"]")
	public WebElement hbr;
	
	@FindBy(xpath="//*[@id=\"page_wrapper\"]/footer/div")
	public WebElement footer;
	
	
	
	
	public checkout_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}




	

	public void carticonclick() throws InterruptedException
	{
		cart.click();
	}
	
	public void cartremovebtn()
	{
		for(WebElement remove:removebtn)
		{
			remove.click();
		}
	}
	
	public void checkoutwithnull()
	{
		chkoutbtn.click();
	}
	
	public void cancelbtnverify()
	{
		cancelbtn.click();
	}
	
	public void continueshopbtn()
	{
		conshopbtn.click();
	}
	
	public void addtocrtagn()
	{
		bagaddcart.click();
	}
	
	public void entfirstname(String name)
	{
		firstname.sendKeys(name);
	}
	
	public void entlastname(String name)
	{
		lastname.sendKeys(name);
	}
	
	public void entpostalcode(String code)
	{
		postalcode.sendKeys(code);
	}
	
	public void continueclick()
	{
		continuebtn.click();
	}
	
	public void pressenter()
	{
		postalcode.sendKeys(Keys.ENTER);
	}
	
	public void finishbutton()
	{
		finishbtn.click();
	}
	
	public void signout() throws InterruptedException
	{
		hbr.click();
		Thread.sleep(2000);
		logout.click();
	}
	
	public void footerlinkvalidation()
	{
		footer.click();
	}
}
