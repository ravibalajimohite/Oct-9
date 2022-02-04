package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityPackage.Utility;

public class KiteLogIn extends Utility
{
	//login
	@FindBy(xpath="//input[@type='text']")
	private WebElement username;
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	@FindBy(xpath="//button[text()='Login ']")
	private WebElement login;


	public KiteLogIn(WebDriver driver)
	{  
		PageFactory.initElements(driver, this);
	}
	public String sendUsername() throws EncryptedDocumentException ,IOException 
	{
		String name =getDetaFromExcel(1,0);
		username.sendKeys(name);
		return name;

	}
	public String sendPassword() throws EncryptedDocumentException, IOException 
	{
		String pass=getDetaFromExcel(1,1);
		password.sendKeys(pass);
		return pass;
	}
	public void clickLogInButton() 
	{
		login.click();
	}



}
