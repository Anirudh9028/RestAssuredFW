package api.utilities;

import java.io.IOException;

import org.testng.annotations.*;

public class DataProviderUtility {

	@DataProvider(name ="data")
	public String [][] data() throws IOException{
		
		//System.getProperty("user.dir");  .....return C:\eclipse workplace\RestAssuredFrameWork
		
		String filePath = System.getProperty("user.dir") +"\\testData\\RwData.xlsx";
		
		xlsxUtilities csvData = new xlsxUtilities(filePath);
		
		int rwCount = csvData.getRowCount("RwData");
		
		int clCount = csvData.getCellCount("RwData", 1);
		
		String testData [][] = new String[rwCount][clCount];
		
		for(int r=1;r<=rwCount;r++)
		{
			for(int c=0;c<clCount;c++){
				
				testData[r-1][c] = csvData.getCellData("RwData", r, c);
				
			}
		}
		
		return testData;
		
	}
	@Test
	public void userName() {
		
		//System.out.println(
		//C:\eclipse workplace\RestAssuredFrameWork\testData\RwData.xlsx
		
	}
	
	
	
}
