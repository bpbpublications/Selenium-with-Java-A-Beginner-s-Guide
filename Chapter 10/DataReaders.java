package chapter10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class DataReaders { 

	public static String[][] getExcelDataUsingPoi(String fileName, String sheetName) throws IOException {
		
		String[][] arrayExcelData = null;
		org.apache.poi.ss.usermodel.Workbook wb = null;
		
		try {
			File file = new File(fileName);
			FileInputStream fs = new FileInputStream(file);
			if(fileName.substring(fileName.indexOf(".")).equals(".xlsx"))
			{
				wb = new org.apache.poi.xssf.usermodel.XSSFWorkbook(fs);
			}
			else if(fileName.substring(fileName.indexOf(".")).equals(".xls"))
			{
				wb = new org.apache.poi.hssf.usermodel.HSSFWorkbook(fs);
			}

			if (wb==null)
			{
				//Error Sheet name not found
				Exception exp = new Exception("WORKBOOK CREATION ERROR - May be File **NOT** found " + sheetName );
				throw exp;
			}		

			org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(sheetName);

			if (sh==null)
			{
				//Error Sheet name not found
				Exception exp = new Exception("Sheet Name **NOT** found " + sheetName );
				throw exp;
			}

			int totalNoOfRows = sh.getPhysicalNumberOfRows();
			int totalNoOfCols = 
					sh.getRow(0).getPhysicalNumberOfCells();
			

			System.out.println("totalNoOfRows="+totalNoOfRows+","
					+ " totalNoOfCols="+totalNoOfCols);
			
			arrayExcelData = 
					new String[totalNoOfRows-1][totalNoOfCols];
			
			System.out.println("Reading excel file now");
			// End reading the excel file if the column value is -1
			boolean continueReading = true;
			for (int i= 1 ; i <= totalNoOfRows-1; i++) {
				for (int j=0; j <= totalNoOfCols-1; j++) {
					String rawCellVal = null;
					try {

						DataFormatter formatter = new DataFormatter();
						rawCellVal = formatter.formatCellValue(sh.getRow(i).getCell(j));
					}
					catch(Exception e) {
						// error reading cell value or row value
						// looks like it may be null
						System.out.println("error reading value from the row and cell - null may be");
					}
					if (rawCellVal == null || rawCellVal.toString().contains("-1"))
					{
						continueReading= false;
						break;
					}
					String cellStringVal = rawCellVal.toString();
					arrayExcelData[i-1][j] = cellStringVal;
					System.out.print(arrayExcelData[i-1][j]+":");
					
				} // inner for loop - j
				if (continueReading == false) {
					System.out.println("Completed reading -1 or null found: breaking now.");
					break;
				}
				System.out.println();
			} // outer for loop i
		} catch (Exception e) {
			System.out.println("EXCEPTION error in getExcelData()");
			System.out.println(e.getMessage());
			if (arrayExcelData==null)
			{
				IOException exp = new IOException(e.getMessage());
				throw exp;
			}
		}
		return arrayExcelData;
	}

	public static List<String[]> getCSVData(String filename, int skipLines) throws IOException{
		
		List<String[]> allData=null;
		try {
	         FileReader filereader = new FileReader(filename);
	         // create csvReader object and skip first Line
	        CSVReader csvReader = new CSVReaderBuilder(filereader)
	                                  .withSkipLines(skipLines)
	                                  .build();
	        allData = csvReader.readAll();
	  	}
	    catch (Exception e) {
	        e.printStackTrace();
	    }
		return allData;
	}
}
