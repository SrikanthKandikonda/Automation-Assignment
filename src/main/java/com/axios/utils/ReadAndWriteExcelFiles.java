package com.axios.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWriteExcelFiles {
	public static String file = "/Users/srikanthkandikonda/Desktop/Automation Assignment/Test-Data/currencydata.xlsx";

	public String readFile(int row, int cell) {
		String value = null;
		File filePath = new File(file);
		try {
			FileInputStream readFile = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(readFile);
			XSSFSheet sheet1 = workbook.getSheetAt(0);
			value = sheet1.getRow(row).getCell(cell).getStringCellValue();
			readFile.close();
		} catch (Exception readindFiled) {
			System.out.println(readindFiled.getMessage());
		}
		return value;
	}
	
	public void WriteFile(int row, int cell, String cellValue) {
		File filePath = new File(file);
		try {
			FileInputStream readFile = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(readFile);
			XSSFSheet sheet1 = workbook.getSheetAt(0);
			sheet1.getRow(row).createCell(cell).setCellValue(cellValue);
			FileOutputStream writeFile = new FileOutputStream(new File(file));
			workbook.write(writeFile);
			writeFile.close();
			
		} catch (Exception readindFiled) {
			System.out.println(readindFiled.getMessage());
		}
	}

}
