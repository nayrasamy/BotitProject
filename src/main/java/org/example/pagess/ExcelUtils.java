package org.example.pagess;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils{
    private static final String EXCEL_FILE_PATH = "src//test//resources//LoginData.xlsx";

    public static Object[][] getProductData() throws IOException {
        FileInputStream fis = new FileInputStream(EXCEL_FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        int numberOfRows = sheet.getLastRowNum() + 1;
        int numberOfColumns = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < numberOfColumns; j++) {
                Cell cell = row.getCell(j);
                data[i][j] = getCellValue(cell);
            }
        }

        workbook.close();
        fis.close();

        return data;
    }

    private static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return cell.getNumericCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            default:
                return null;
        }
    }
}
