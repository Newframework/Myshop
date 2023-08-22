package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellUtility {

	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public ExcellUtility(String path)
	{
		this.path=path;
	}
	
	
	public int getRowCount(String sheetName) throws IOException
	{
		fis=new FileInputStream(path);
		wb= new XSSFWorkbook(fis);
		sheet=wb.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		return rowcount;
	}
	
	
	public int getCellCount(String sheetName) throws IOException
	{
		fis=new FileInputStream(path);
		wb= new XSSFWorkbook(fis);
		sheet=wb.getSheet(sheetName);
		int cellcount=sheet.getRow(1).getLastCellNum();
		return cellcount;
	}
	
	
	public String getCellData(String sheetName, int rownum, int colnum) throws IOException
	{
		fis=new FileInputStream(path);
		wb= new XSSFWorkbook(fis);
		sheet=wb.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		
		String data;
		try {
			data= formatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data="";
		}
		
		wb.close();
		fis.close();
		return data;
	}
	
	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())
		{
			wb=new XSSFWorkbook();
			fos= new FileOutputStream(path);
			wb.write(fos);
		}
		
		fis= new FileInputStream(path);
		wb= new XSSFWorkbook(fis);
		
		if(wb.getSheetIndex(sheetName)==-1)
		wb.createSheet(sheetName);
		sheet=wb.getSheet(sheetName);
		
		if(sheet.getRow(rownum)==null)
			sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fos=new FileOutputStream(path);
		wb.write(fos);
		fis.close();
		fos.close();
		
		
	}
	
	
}
