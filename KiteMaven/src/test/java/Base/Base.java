package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base
{
	public static WebDriver openChromeBrowser()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments(" disable-infobars");

		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}
	public static WebDriver openMSEdgeBrowser()
	{
		System.setProperty("webdriver.edge.driver", "F:\\selenium\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
	}
	public static WebDriver openOperaBrowser()
	{
		System.setProperty("webdriver.opera.driver", "F:\\selenium\\operadriver.exe");
		WebDriver driver = new OperaDriver();
		return driver;
	}

}
