package UtilityPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility
{
	public static String getDetaFromExcel(int row,int cell) throws IOException, IllegalStateException
	{
		String data = null;
		String path="C:\\Users\\HP\\Desktop\\New folder\\kiteExcelSheet.xlsx";
		FileInputStream file=new FileInputStream(path);
		try
		{
			data=WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
			return data;
		}
		catch(IllegalStateException pa)
		{
			double m=WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell).getNumericCellValue();
			data=String.valueOf(m);
			return data;
		}
		
		
		catch(NullPointerException a)
		
		{
			System.out.println("cell is blank");
		}
		catch(Exception c)
		{
			c.getStackTrace();
		}
		return data;

	}

}
