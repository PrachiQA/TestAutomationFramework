package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSData {
//
//	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//
//		ReadXLSData read = new ReadXLSData();
//		read.GetData("Sheet2");
//	}

	@DataProvider(name= "testDataProvider")
	public String[][] GetData(Method testcase) throws EncryptedDocumentException, IOException {

		String excelsheetName = testcase.getName();
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(inputStream);
		Sheet sheet = workbook.getSheet(excelsheetName);

		int totalRows = sheet.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells = sheet.getRow(0);
		int totalColumns = rowCells.getLastCellNum();
		System.out.println(totalColumns);

		DataFormatter formatter = new DataFormatter();
		String testData[][] = new String[totalRows][totalColumns];
		for (int row = 1; row <= totalRows; row++) {
			for (int column = 0; column < totalColumns; column++) {
				testData[row - 1][column] = formatter.formatCellValue(sheet.getRow(row).getCell(column));
				System.out.println(testData[row - 1][column]);
			}
		}
		return testData;
	}

}
