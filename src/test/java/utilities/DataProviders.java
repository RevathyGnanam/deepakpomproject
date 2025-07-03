package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws Exception{
		String path = System.getProperty("user.dir")+ "\\testData\\LoginData.xlsx";
		System.out.println("path--------------"+path);
		ExcelUtility utility =  new ExcelUtility(path);
		int totalRows = utility.getRowCount("Sheet1");
		int totalColumn = utility.getCellCount("Sheet1", 1);
		
		String loginData[][] =new String[totalRows][totalColumn];
		
		for (int i = 1; i <=totalRows; i++) {
			for (int j = 0; j < totalColumn; j++) {
				loginData[i-1][j] = utility.getCellData("Sheet1", i, j);
				
			}
			
		}
		
		return loginData;
		
	}
	
	//Dataprovider2
	//Dataprovider3
	//Dataprovider4

}
