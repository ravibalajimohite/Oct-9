package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage 
{
	
	WebDriver driver;
	@FindBy(xpath="//span[text()='Dashboard']")
	private WebElement dashboard; 
	@FindBy(xpath="//span[text()='Orders']")
	private WebElement orders; 

	@FindBy(xpath="//span[text()='Holdings']")
	private WebElement holdings; 

	@FindBy(xpath="//span[text()='Positions']")
	private WebElement positions; 

	@FindBy(xpath="//span[text()='Funds']")
	private WebElement funds; 

	@FindBy(xpath="//span[text()='Apps']")
	private WebElement apps; 
	@FindBy(xpath="//input[@icon='search']")
	private WebElement search; 
	@FindBy(xpath="//li[@class='search-result-item selected isadded']")
	private WebElement devhari; 
	@FindBy(xpath="//input[@label='Qty.']")
	private WebElement qty; 
	@FindBy(xpath="(//span[text()='Buy'])[2]")
	private WebElement buy; 
	
	@FindBy(xpath="(//label[@class='su-switch-control']")
	private WebElement switchbutton; 
	
	
	
	
	
	

	public MainPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		driver=driver;
	}
	public void clickOnBuyButton() 
	{
		buy.click();
	}
	public void sendQty() 
	{
		qty.sendKeys("15");
	}
	public void clickOnDevhariShare() 
	{
		devhari.click();
	}
	public void  toClickOnSearch() 
	{
//		Actions actions=new Actions(driver);
//		actions.moveToElement(search).
		search.sendKeys("DEVHARI");
	}
	public void clickOnDashboardTab() 
	{
		dashboard.click();
	}
	public void clickOnOrdersTab() 
	{
		orders.click();
	}
	public void clickOnHoldingsTab() 
	{
		holdings.click();
	}
	public void clickOnPositionsTab() 
	{
		positions.click();
	}
	public void clickOnFundsTab() 
	{
		funds.click();
	}

	public void clickOnAppsTab() 
	{
		orders.click();
	}



}
