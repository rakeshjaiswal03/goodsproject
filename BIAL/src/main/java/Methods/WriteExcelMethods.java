package Methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelMethods 
{
	FileOutputStream fos;
	public HSSFWorkbook excelbook;  
	public HSSFSheet excelsheet;
	public HSSFRow row;          	
    public HSSFCell cell;
    public CellStyle style9;
    
    public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow xrow;
	public XSSFCell xcell;
	
    Path ExcelSavePath; 
    int cellNo;
    String wExcel;
    String returnExcelPath;
    
    public String CreateFolder(String FolderPath,String FolderName) throws IOException 
	{
		String CreatedFolderPath = null;
		try 
		{
			CreatedFolderPath = FolderPath+FolderName+"\\";
			File tmpDir = new File(CreatedFolderPath);
			boolean exists = tmpDir.exists();
			if (exists != true) 
			{
				File f2 = new File(CreatedFolderPath);
				f2.mkdir();
				if(tmpDir.exists()==true)
				{
					System.out.println("Folder is sucessfully created.");
				}
				else
				{
					System.out.println("Folder is not created.");
				}
			} 
			else if (exists == true) 
			{
				System.out.println("Folder is already is exists.");
			}
			File f1 = new File(CreatedFolderPath);
			f1.listFiles();
		}
		catch (Exception e) 
		{
			System.err.println("Unable to create folder!!!!!!!!!!!!!");
			System.err.println("Got Exception!!!!!!!!!!!");
			e.printStackTrace();
		}
		
		return CreatedFolderPath;
	}

	public Path CreateExcel(String ExcelFolderPath,String excelName,String sheetName, int rowNo, String headers[]) throws IOException
	{
		excelbook=new HSSFWorkbook();
        ExcelSavePath=java.nio.file.Paths.get(ExcelFolderPath, excelName+".xls");
        excelsheet= excelbook.createSheet(sheetName);
        
        row=excelsheet.createRow(rowNo);          	
        style9=excelbook.createCellStyle();
        
        for (int i = 0; i < headers.length; i++) 
        {
        	style9.setBorderBottom(BorderStyle.THIN);
            style9.setBorderLeft(BorderStyle.THIN);
            style9.setBorderRight(BorderStyle.THIN);
            style9.setBorderTop(BorderStyle.THIN);
            cell = row.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(style9);
		}
        
        wExcel=(ExcelSavePath).toString();
        fos=new FileOutputStream(wExcel);
        excelbook.write(fos);
        fos.close();

        return ExcelSavePath;
	}
	
	public Path CreateExcelX(String ExcelFolderPath,String excelName,String sheetName, int rowNo, String headers[]) throws IOException
	{
		workbook=new XSSFWorkbook();
        ExcelSavePath=java.nio.file.Paths.get(ExcelFolderPath, excelName+".xlsx");
        sheet=workbook.createSheet(sheetName);
        
        xrow=sheet.createRow(rowNo);          	
        style9=workbook.createCellStyle();
        
        for (int i = 0; i < headers.length; i++) 
        {
        	style9.setBorderBottom(BorderStyle.THIN);
            style9.setBorderLeft(BorderStyle.THIN);
            style9.setBorderRight(BorderStyle.THIN);
            style9.setBorderTop(BorderStyle.THIN);
            xcell = xrow.createCell(i);
            xcell.setCellValue(headers[i]);
            xcell.setCellStyle(style9);
		}
        
        wExcel=(ExcelSavePath).toString();
        fos=new FileOutputStream(wExcel);
        workbook.write(fos);
        fos.close();

        return ExcelSavePath;
	}
	
	public String WriteExcel(Path ExcelSavePath, int rowNo,
			String... variableSet) throws IOException
	{
		cellNo=0;
		row = excelsheet.createRow(rowNo);          	
        style9 = excelbook.createCellStyle();
        
        for (String variable : variableSet) 
        {
        	
            HSSFCell c;
            CellStyle style2 = excelbook.createCellStyle();
            HSSFFont font1 = excelbook.createFont();
            if(variable=="Pass")
            {  
            	style2.setBorderBottom(BorderStyle.THIN);
             	style2.setBorderLeft(BorderStyle.THIN);
             	style2.setBorderRight(BorderStyle.THIN);
             	style2.setBorderTop(BorderStyle.THIN);
             	style2.setFillForegroundColor(IndexedColors.LIME.index);      
                style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            	c = excelsheet.getRow(rowNo).createCell(cellNo++);
             	c.setCellValue(variable);
                c.setCellStyle(style2);       	          
                font1.setFontName(HSSFFont.FONT_ARIAL);
                font1.setFontHeightInPoints((short)10);
                font1.setColor(IndexedColors.BLACK.getIndex());
                style2.setFont(font1);
            }
            else if(variable=="Fail") 
            {
            	HSSFFont font = excelbook.createFont();
            	style2.setBorderBottom(BorderStyle.THIN);
              	style2.setBorderLeft(BorderStyle.THIN);
              	style2.setBorderRight(BorderStyle.THIN);
              	style2.setBorderTop(BorderStyle.THIN);
              	style2.setFillForegroundColor(IndexedColors.RED.index);      
                style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
              	c = excelsheet.getRow(rowNo).createCell(cellNo++);
              	c.setCellValue(variable);
                c.setCellStyle(style2);   
                font.setFontName(HSSFFont.FONT_ARIAL);
                font.setFontHeightInPoints((short)10);
                font.setColor(IndexedColors.BLACK.getIndex());
                style2.setFont(font);
            }
            else
            {
            	style9.setBorderBottom(BorderStyle.THIN);
                style9.setBorderLeft(BorderStyle.THIN);
                style9.setBorderRight(BorderStyle.THIN);
                style9.setBorderTop(BorderStyle.THIN);
                cell = row.createCell(cellNo++);
                cell.setCellValue(variable);
                cell.setCellStyle(style9);
                
            }
		}
        
        wExcel=(ExcelSavePath).toString();
        fos = new FileOutputStream(wExcel);
        excelbook.write(fos);
        fos.close();
       	
        returnExcelPath=(ExcelSavePath).toString();
        return returnExcelPath;
	}
	
	public String WriteExcelX(Path ExcelSavePath, int rowNo,
			String... variableSet) throws IOException
	{
		cellNo=0;
		xrow = sheet.createRow(rowNo);          	
        style9 = workbook.createCellStyle();
        
        for (String variable : variableSet) 
        {
        	XSSFCell c;
            CellStyle style2 = workbook.createCellStyle();
            XSSFFont font1 = workbook.createFont();
            if(variable=="Pass")
            {  
            	style2.setBorderBottom(BorderStyle.THIN);
             	style2.setBorderLeft(BorderStyle.THIN);
             	style2.setBorderRight(BorderStyle.THIN);
             	style2.setBorderTop(BorderStyle.THIN);
             	style2.setFillForegroundColor(IndexedColors.LIME.index);      
                style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            	c = sheet.getRow(rowNo).createCell(cellNo++);
             	c.setCellValue(variable);
                c.setCellStyle(style2);       	          
                font1.setFontName(HSSFFont.FONT_ARIAL);
                font1.setFontHeightInPoints((short)10);
                font1.setColor(IndexedColors.BLACK.getIndex());
                style2.setFont(font1);
            }
            else if(variable=="Fail") 
            {
            	XSSFFont font = workbook.createFont();
            	style2.setBorderBottom(BorderStyle.THIN);
              	style2.setBorderLeft(BorderStyle.THIN);
              	style2.setBorderRight(BorderStyle.THIN);
              	style2.setBorderTop(BorderStyle.THIN);
              	style2.setFillForegroundColor(IndexedColors.RED.index);      
                style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
              	c = sheet.getRow(rowNo).createCell(cellNo++);
              	c.setCellValue(variable);
                c.setCellStyle(style2);   
                font.setFontName(HSSFFont.FONT_ARIAL);
                font.setFontHeightInPoints((short)10);
                font.setColor(IndexedColors.BLACK.getIndex());
                style2.setFont(font);
            }
            else
            {
            	style9.setBorderBottom(BorderStyle.THIN);
                style9.setBorderLeft(BorderStyle.THIN);
                style9.setBorderRight(BorderStyle.THIN);
                style9.setBorderTop(BorderStyle.THIN);
                xcell = xrow.createCell(cellNo++);
                xcell.setCellValue(variable);
                xcell.setCellStyle(style9);
            }
		}
        
        wExcel=(ExcelSavePath).toString();
        fos = new FileOutputStream(wExcel);
        workbook.write(fos);
        fos.close();
       	
        returnExcelPath=(ExcelSavePath).toString();
        return returnExcelPath;
	}
	
	public String WriteExcelA(String WriteExcelPath, String... variableSet) throws Exception
	{
		InputStream is = new FileInputStream(WriteExcelPath); 
	    Workbook wb = WorkbookFactory.create(is);
	    Sheet sheet = wb.getSheetAt(0); 
		int cellNo = 0;
		int num = sheet.getLastRowNum(); 
	    Row row = sheet.createRow(++num);        	
	    CellStyle style9 = wb.createCellStyle();
        Cell cell= null;
	    
        for (String variable : variableSet) 
        {
        	Cell c;
            CellStyle style2 = wb.createCellStyle();
            Font font1 = wb.createFont();
            if(variable == "Pass")
            {  
            	style2.setBorderBottom(BorderStyle.THIN);
             	style2.setBorderLeft(BorderStyle.THIN);
             	style2.setBorderRight(BorderStyle.THIN);
             	style2.setBorderTop(BorderStyle.THIN);
             	style2.setFillForegroundColor(IndexedColors.LIME.index);      
                style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            	c = sheet.getRow(num).createCell(cellNo++);
             	c.setCellValue(variable);
                c.setCellStyle(style2);       	          
                font1.setFontName(HSSFFont.FONT_ARIAL);
                font1.setFontHeightInPoints((short)10);
                font1.setColor(IndexedColors.BLACK.getIndex());
                style2.setFont(font1);
            }
            else if(variable == "Fail") 
            {
            	Font font = wb.createFont();
            	style2.setBorderBottom(BorderStyle.THIN);
              	style2.setBorderLeft(BorderStyle.THIN);
              	style2.setBorderRight(BorderStyle.THIN);
              	style2.setBorderTop(BorderStyle.THIN);
              	style2.setFillForegroundColor(IndexedColors.RED.index);      
                style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
              	c = sheet.getRow(num).createCell(cellNo++);
              	c.setCellValue(variable);
                c.setCellStyle(style2);   
                font.setFontName(HSSFFont.FONT_ARIAL);
                font.setFontHeightInPoints((short)10);
                font.setColor(IndexedColors.BLACK.getIndex());
                style2.setFont(font);
            }
            else
            {
            	style9.setBorderBottom(BorderStyle.THIN);
                style9.setBorderLeft(BorderStyle.THIN);
                style9.setBorderRight(BorderStyle.THIN);
                style9.setBorderTop(BorderStyle.THIN);
                cell = row.createCell(cellNo++);
                cell.setCellValue(variable);
                cell.setCellStyle(style9);
            }
		}
        
        FileOutputStream fos = new FileOutputStream(WriteExcelPath);
        wb.write(fos);
        fos.close();
        
        return WriteExcelPath;
	}
}
