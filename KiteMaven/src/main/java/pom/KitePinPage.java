package pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityPackage.UtilityPin;

public class KitePinPage extends UtilityPin
{
	@FindBy(xpath="//input[@type='password']")
	private WebElement pin;
	@FindBy(xpath="//button[text()='Continue ']")
	private WebElement continiue;

	public KitePinPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void sendPin() throws IllegalStateException, IOException 
	{
	String pi=	getPinFromExcel(1,2);
		pin.sendKeys(pi);

	}
	public void clickOnContinueButton() 
	{
		continiue.click();
	}


}
