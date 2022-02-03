package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.Base;
import UtilityPackage.UtilityScreenshot;
import pom.KiteLogIn;
import pom.KiteLogOut;
import pom.KitePinPage;
import pom.MainPage;


public class TestNGKite extends Base 
{
	private KiteLogIn kiteLogIn;
	private KitePinPage kitePinPage;
	private MainPage mainPage;
	private WebDriver driver;
	private  int TestID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchTheBrowser(String browser)
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		System.out.println("launchBrowser");

		if(browser.equals("chrome"))
		{
			driver=Base.openChromeBrowser();
		}
		if(browser.equals("edge"))
		{
			driver=Base.openMSEdgeBrowser();
		}
		if(browser.equals("opera"))
		{
			driver=Base.openOperaBrowser();
		}		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@BeforeClass()
	public void initilizePOMClass()
	{
		kiteLogIn =new KiteLogIn(driver);
		kitePinPage=new KitePinPage(driver);
	}
	@BeforeMethod
	public void openTheUrl() throws InterruptedException, IOException
	{
		System.out.println("openTheUrl");
		driver.get("https://kite.zerodha.com");


		kiteLogIn.sendUsername();
		kiteLogIn.sendPassword();
		kiteLogIn.clickLogInButton();
		Thread.sleep(3000);
		kitePinPage.sendPin();
		kitePinPage.clickOnContinueButton();
	}

	@Test
	public void verifyTheHeader()
	{
		TestID=102;
		mainPage=new MainPage(driver);
		mainPage.clickOnDashboardTab();
		mainPage.clickOnHoldingsTab();
		mainPage.clickOnPositionsTab();
		mainPage.clickOnAppsTab();
		mainPage.clickOnFundsTab();
		mainPage.clickOnOrdersTab();
		//buy share
		mainPage.toClickOnSearch();
		mainPage.clickOnDevhariShare();
		mainPage.sendQty();   
		mainPage.clickOnBuyButton();
		
	}
	


	@AfterMethod
	public void logout(ITestResult result) throws IOException
	{

		if(ITestResult.FAILURE==result.getStatus())
		{
			UtilityScreenshot.getScreenshot(driver, TestID);
		}
		KiteLogOut kiteLogOut=new KiteLogOut(driver);
		kiteLogOut.clickOnUq();
		kiteLogOut.clickOnLogout();
	}
	@AfterClass
	public void clearfybjects()
	{
		kiteLogIn =null ;
		kitePinPage=null ;
	}

	@AfterTest
	public void closeTheBrowser()
	{
		System.out.println("closedBrowser");
		driver.quit();
		driver =null;
	

	}
}
