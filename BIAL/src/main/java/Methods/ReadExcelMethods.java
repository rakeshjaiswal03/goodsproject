package Methods;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelMethods
{
	public FileInputStream fis=null;
	
	public XSSFWorkbook workbook=null;
	public XSSFSheet sheet=null;
	public XSSFRow row=null;
	public XSSFCell cell=null;
	
	public HSSFWorkbook excelbook=null;  
	public HSSFSheet excelsheet=null;
	public HSSFRow hrow=null;          	
    public HSSFCell hcell=null;
    
    int rowCount;
    int colNum;
    String FileExtension;
    String ReadExcelPath;
    String cellValue;
	
    public ReadExcelMethods(String ReadExcelPath) throws Exception
	{
		this.ReadExcelPath=ReadExcelPath;
		fis=new FileInputStream(ReadExcelPath);
		FileExtension=FilenameUtils.getExtension(ReadExcelPath); 
		if(FileExtension.equalsIgnoreCase("xlsx"))
		{
			workbook=new XSSFWorkbook(fis);
		}
		else if(FileExtension.equalsIgnoreCase("xls"))
		{
			excelbook=new HSSFWorkbook(fis);
		}
		else
		{
			System.out.println("Invalid Excel File Extension!!!!!!");
		}
		fis.close();
	}
	
	public int GetNoOfRow(String sheetName) throws Exception
	{
		if(FileExtension.equalsIgnoreCase("xlsx"))
		{
			sheet=workbook.getSheet(sheetName);
			rowCount = sheet.getLastRowNum()+1;
		}
		else if(FileExtension.equalsIgnoreCase("xls"))
		{
			excelsheet=excelbook.getSheet(sheetName);
			rowCount = excelsheet.getLastRowNum()+1;
		}
		else
		{
			System.out.println("Invalid Excel File Extension!!!!!!");
		}
		return rowCount;
	}
	
	@SuppressWarnings("deprecation")
	public String GetCellDataX(String sheetName, String colName, int rowNum) 
	{
		try
		{
			if(FileExtension.equalsIgnoreCase("xlsx"))
			{
				colNum=-1;
				sheet=workbook.getSheet(sheetName);
				row=sheet.getRow(0);
				for(int i=0;i<row.getLastCellNum();i++)
				{
					if(row.getCell(i).getStringCellValue().trim().equals(colName))
					{
						colNum=i;
					}
				}
				
				row=sheet.getRow(rowNum);
				cell=row.getCell(colNum);
				
				if(cell.getCellTypeEnum()==CellType.STRING)
				{
					cellValue=cell.getStringCellValue();
				}
				else if(cell.getCellTypeEnum()==CellType.NUMERIC || cell.getCellTypeEnum()==CellType.FORMULA) 
				{
					cellValue=String.valueOf(cell.getNumericCellValue());
					if(HSSFDateUtil.isCellDateFormatted(cell))
					{
						DateFormat dt=new SimpleDateFormat("dd/mm/yy");
						java.util.Date date=cell.getDateCellValue();
						cellValue=dt.format(date);
					}
				}
				else if(cell.getCellTypeEnum()== CellType.BLANK)
				{
					cellValue="";
				}
				else
				{
					cellValue=String.valueOf(cell.getBooleanCellValue());
				}
			}
			else if(FileExtension.equalsIgnoreCase("xls"))
			{
				colNum=-1;
				excelsheet=excelbook.getSheet(sheetName);
				hrow=excelsheet.getRow(0);
				for(int i=0;i<hrow.getLastCellNum();i++)
				{
					if(hrow.getCell(i).getStringCellValue().trim().equals(colName))
					{
						colNum=i;
					}
				}
				
				hrow=excelsheet.getRow(rowNum);
				hcell=hrow.getCell(colNum);
				
				if(hcell.getCellTypeEnum()==CellType.STRING)
				{
					cellValue=hcell.getStringCellValue();
				}
				else if(hcell.getCellTypeEnum()==CellType.NUMERIC || hcell.getCellTypeEnum()==CellType.FORMULA) 
				{
					cellValue=String.valueOf(hcell.getNumericCellValue());
					if(HSSFDateUtil.isCellDateFormatted(hcell))
					{
						DateFormat dt=new SimpleDateFormat("dd/mm/yy");
						java.util.Date date=cell.getDateCellValue();
						cellValue=dt.format(date);
					}
				}
				else if(hcell.getCellTypeEnum()== CellType.BLANK)
				{
					cellValue="";
				}
				else
				{
					cellValue=String.valueOf(hcell.getBooleanCellValue());		
				}
			}
			else
			{
				System.out.println("Invalid Excel File Extension!!!!!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			cellValue="data not found";
		}
		
		return cellValue;
	}
	
//	public String GetCellData(String sheetName, String colName, int rowNum) 
//	{
//		try
//		{
//			int colNum=-1;
//			excelsheet=excelbook.getSheet(sheetName);
//			hrow=excelsheet.getRow(0);
//			for(int i=0;i<hrow.getLastCellNum();i++)
//			{
//				if(hrow.getCell(i).getStringCellValue().trim().equals(colName))
//				{
//					colNum=i;
//				}
//			}
//			
//			hrow=excelsheet.getRow(rowNum);
//			hcell=hrow.getCell(colNum);
//			
//			if(hcell.getCellTypeEnum()==CellType.STRING)
//			{	
//				return hcell.getStringCellValue();
//			}
//			else if(hcell.getCellTypeEnum()==CellType.NUMERIC || hcell.getCellTypeEnum()==CellType.FORMULA) 
//			{
//				String cellValue=String.valueOf(hcell.getNumericCellValue());
//				if(HSSFDateUtil.isCellDateFormatted(hcell))
//				{
//					DateFormat dt=new SimpleDateFormat("dd/mm/yy");
//					java.util.Date date=cell.getDateCellValue();
//					cellValue=dt.format(date);
//				}
//				return cellValue;
//			}
//			else if(hcell.getCellTypeEnum()== CellType.BLANK)
//			{	
//				return"";
//			}
//			else
//			{	
//				return String.valueOf(hcell.getBooleanCellValue());				
//			}
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			return"data not found";
//		}
//	}
//	
	
	
	
}