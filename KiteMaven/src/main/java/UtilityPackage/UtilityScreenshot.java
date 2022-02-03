package UtilityPackage;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityScreenshot
{
	

	public static void getScreenshot( WebDriver driver , int TestID) throws IOException
	{

		Date date=new Date();
		String s=date.toString().replace(":", "-").replace(":","-").replace("IST","-");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("F:\\selenium\\seliniun screenshot\\"+TestID+s+".jpg");
		FileHandler.copy(src, dest);

	}
}
