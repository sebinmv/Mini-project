package pagepkg;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_page {

	WebDriver driver;
	
	
	@FindBy(xpath="//*[@id=\"user-name\"]")
	public WebElement user;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	public WebElement pass;
	
	@FindBy(xpath="//*[@id=\"login-button\"]")
	public WebElement login;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[1]")
	public WebElement logo; 
	
	
	
	public login_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}



	public WebElement logoverification()
	{
		return logo;
	}
	
	public WebElement buttontextverification()
	{
		return login;
	}
	
	public void loginvalues(String username, String password)
	{
		user.sendKeys(username);
		pass.sendKeys(password);
		login.click();
	}
	
	public void passwordcopypaste()
	{
		user.sendKeys("standard_user");
		Actions ob = new Actions(driver);
		ob.keyDown(user,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
		ob.keyDown(user,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
		ob.keyDown(pass,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
		ob.perform();
	}
	
	
	
	
}
