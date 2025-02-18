package experiment;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoOne {

	public static void main(String[] args) {
		FileInputStream fis;
		Workbook workbook = null;
		try {

			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\experiment\\SampleData.xlsx");
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet("Employees");
		int rows = sheet.getLastRowNum() + 1;
		System.out.println(rows);

		int col = sheet.getRow(0).getLastCellNum();
		System.out.println(col);

		for (int r = 0; r < rows; r++) {
			Row row = sheet.getRow(r);

			for (int c = 0; c < col; c++) {

				Cell cell = row.getCell(c);

				switch (cell.getCellType()) {

				case STRING:
					System.out.print(cell.getStringCellValue() + "----------");
					break;
				case NUMERIC:
					System.out.print((int) cell.getNumericCellValue() + "--------");
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue() + "-----------------");
					break;

				default:
					System.out.print("Can't retrieve this sort of data from Excel File");
				}

			}
			System.out.println();

		}
	}

}
