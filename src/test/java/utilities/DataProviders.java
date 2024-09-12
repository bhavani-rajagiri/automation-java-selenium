package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = "C:\\Workspace\\Java Selenium\\seleniumpageObjectModel\\OpenCart\\testData\\logintestdata.xlsx";
		ExcelUtils xlUtils = new ExcelUtils(path);
		int totalRowCount=xlUtils.getRowCount("Sheet1");
		int totalColumCount = xlUtils.getCellCount("Sheet1", 1);
		String logindata[][]=new String[totalRowCount][totalColumCount];
		
		for(int i=1;i<=totalRowCount;i++)
		{
			for(int j=0;j<totalColumCount;j++)
			{
				logindata[i-1][j]=xlUtils.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}
} 

