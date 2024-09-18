package dataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class data_Driven_Practice {
	
	@Test
	private void data_Driven() throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\Home\\Desktop\\Data Driven.xlsx");
		
		XSSFWorkbook workBook = new XSSFWorkbook(fis); //To get control on excel sheet
		
		int sheets = workBook.getNumberOfSheets(); //Counting num of sheets available in the ecxel sheet
		
		for(int i=0; i<sheets; i++) {
			if (workBook.getSheetName(i).equalsIgnoreCase("Credentials")) {
				XSSFSheet sheet = workBook.getSheetAt(i); //Get Access to the sheet
				System.out.println(workBook.getSheetName(i));
			}
		}

	}
	
}
