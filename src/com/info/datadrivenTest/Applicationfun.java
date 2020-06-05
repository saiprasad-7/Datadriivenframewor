package com.info.datadrivenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Applicationfun 
{
String path;
XSSFWorkbook wb;
public Applicationfun(String path) throws IOException
{
	this.path=path;
	FileInputStream fileInputStream=new FileInputStream(path);
	wb=new XSSFWorkbook(fileInputStream);
	
}
public int getrowcount(String Sheetname)
{
	return wb.getSheet(Sheetname).getLastRowNum()+1;
}
public  String getcelldata(String Sheetname,int rownum,int cellnum)
{
	return wb.getSheet(Sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
}

public void getcelldata(String Sheetname,int rownum,int cellnum,String cellvalue) throws FileNotFoundException, IOException
{
	 wb.getSheet(Sheetname).getRow(rownum).createCell(cellnum).setCellValue(cellvalue);

wb.write(new FileOutputStream(path));

}







}
