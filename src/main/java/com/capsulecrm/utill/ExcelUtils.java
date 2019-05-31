package com.capsulecrm.utill;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


//Automating  Excel Operations
public class ExcelUtils {
	
	private static String excelPath = System.getProperty("user.dir")+"//src//main//java//com//capsulecrm//testdata//TestData.xlsx";
	private Workbook wb;
	private FileInputStream fis;
	public ExcelUtils() throws InvalidFormatException, IOException
	{
		fis = new FileInputStream(excelPath);
		wb = WorkbookFactory.create(fis);
	}
	public int getRowCount(String sheetName)
	{
		return wb.getSheet(sheetName).getLastRowNum();
	}
	public int getColCount(String sheetName,int rowNumber)
	{
		return wb.getSheet(sheetName).getRow(rowNumber).getLastCellNum();
	}
	public String getCelldata(String SheetName,int row,int cell) throws Exception
	{
		CellValue value;
		String data;
		if (wb.getSheet(SheetName).getRow(row).getCell(cell).getCellType()==Cell.CELL_TYPE_NUMERIC) {
			
			double dataInInt =  wb.getSheet(SheetName).getRow(row).getCell(cell).getNumericCellValue();
			data =String.valueOf(dataInInt);
		}
		else if (wb.getSheet(SheetName).getRow(row).getCell(cell).getCellType()==Cell.CELL_TYPE_STRING) {
			data = wb.getSheet(SheetName).getRow(row).getCell(cell).getStringCellValue();
		}
		else if(wb.getSheet(SheetName).getRow(row).getCell(cell).getCellType()==Cell.CELL_TYPE_FORMULA)
		{
			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
			value = evaluator.evaluate(wb.getSheet(SheetName).getRow(row).getCell(cell));
			System.out.println((int)value.getNumberValue());
			data = String.valueOf((int)value.getNumberValue());
		}
		else{
			throw new Exception("no data found");
		}
		return data;
	}

}
