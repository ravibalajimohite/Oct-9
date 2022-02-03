package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLogOut

{
	@FindBy(xpath="//span[text()='UQ2805']")
	private WebElement uq;
	@FindBy(xpath="//a[text()=' Logout']")
	private WebElement logout;
	
	
	
	public KiteLogOut(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnUq() 
	{
		uq.click();
	}
	public void clickOnLogout() 
	{
		logout.click();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
