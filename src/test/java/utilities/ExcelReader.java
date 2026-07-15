package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static String getData(int row, int cell) throws IOException {

 
    	
    	FileInputStream fis = new FileInputStream(
    		    System.getProperty("user.dir") +
    		    "\\testdata\\FlightData.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        String data = sheet.getRow(row).getCell(cell).getStringCellValue();

        workbook.close();
        fis.close();

        return data;
    }
}
