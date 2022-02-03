package UtilityPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilityPin {
	public static String getPinFromExcel(int row,int cell) throws IOException, IllegalStateException
	{
		String data = null;
		String path="C:\\Users\\HP\\Desktop\\New folder\\kiteExcelSheet.xlsx";
		FileInputStream file=new FileInputStream(path);
		try
		{
		double	num=WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell).getNumericCellValue();
		data=String.valueOf(num);
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
