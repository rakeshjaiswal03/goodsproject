package Methods;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import junit.framework.Assert;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CommonMethods 
{
	
	SimpleDateFormat dtFormat;
    Calendar dtCalender;
    Random random;
    
    boolean verify = false;
    int number;
    String strNo;
    String dtReturn;
 
    

    
	public String RandomNo(int howManyDigit)
	{
		random = new Random();
		if(howManyDigit==1)
		{
			number = 1 + (int)(random.nextFloat() * 8);
			strNo = Integer.toString(number);
		}
		else if(howManyDigit==2)
		{
			number = 10 + (int)(random.nextFloat() * 89);
			strNo = Integer.toString(number);
		}
		else if(howManyDigit==3)
		{
			number = 100 + (int)(random.nextFloat() * 899);
			strNo = Integer.toString(number);
		}
		else if(howManyDigit==4)
		{
			number = 1000 + (int)(random.nextFloat() * 8999);
			strNo = Integer.toString(number);
		}
		else if(howManyDigit==5)
		{
			number = 10000 + (int)(random.nextFloat() * 89990);
			strNo = Integer.toString(number);
		}
		else if(howManyDigit==6)
		{
			number = 100000 + (int)(random.nextFloat() * 899900);
			strNo = Integer.toString(number);
		}
		else if(howManyDigit==7)
		{
			number = 1000000 + (int)(random.nextFloat() * 8999000);
			strNo = Integer.toString(number);
		}
		else if(howManyDigit==8)
		{
			number = 10000000 + (int)(random.nextFloat() * 89990000);
			strNo = Integer.toString(number);
		}
		else if(howManyDigit==9)
		{
			number = 100000000 + (int)(random.nextFloat() * 899900000);
			strNo = Integer.toString(number);
		}
		else if(howManyDigit==10)
		{
			number = 1000000000 + (int)(random.nextFloat() * 1147483600);
			strNo = Integer.toString(number);
		}
		else
		{
			number = 1 + (int)(random.nextFloat() * 1147483600);
			strNo = Integer.toString(number);
		}
		return strNo;
	}
	
	public String Random_awbNo()
	{
		random = new Random();
		number = 1000000 + (int)(random.nextFloat() * 8999000);
        String awbNo =(Integer.toString(number))+(Integer.toString(number%7)); 
        System.out.println("Air Waybill no.: "+awbNo);
        return awbNo; 
	}
	
	public String Random_hawbNo()
	{
		random = new Random();
	    number = 1000 + (int)(random.nextFloat() * 8999);
		strNo=Integer.toString(number);
		String hawbNo="AH"+strNo;
		System.out.println("House Air Waybill no.: "+hawbNo);
		return hawbNo;
	}
	
	public String Random_groupId()
	{
		random = new Random();
	    number = 1000 + (int)(random.nextFloat() * 8999);
		strNo=Integer.toString(number);
		String groupId="GI"+strNo;
		System.out.println("Group ID: "+groupId);
		return groupId;
	}
	
	public int RandomRow(int rowCount)
	{
		random = new Random();
		number=random.nextInt(rowCount);
		return number;
	}
	
	public String CurrentDate()
	{
		 dtFormat=new SimpleDateFormat("dd/MM/yyyy");  
		 dtCalender=Calendar.getInstance();
		 dtReturn=dtFormat.format(dtCalender.getTime());
		 return dtReturn;
	}
	
	public String CurrentDate(String Format)
	{
		 dtFormat=new SimpleDateFormat(Format);  
		 dtCalender=Calendar.getInstance();
		 dtReturn=dtFormat.format(dtCalender.getTime());
		 
		 return dtReturn;
	}
	
	public String SpecificDate(String format, String date,int days) throws Exception
	{
		dtFormat=new SimpleDateFormat(format);
		dtCalender=Calendar.getInstance();
		dtCalender.setTime(dtFormat.parse(date));
	    dtCalender.add(Calendar.DAY_OF_MONTH,days);
		dtReturn=dtFormat.format(dtCalender.getTime());
        return dtReturn;
	}
	
	public String SpecificDate(String date,int days) throws Exception
	{
		dtFormat=new SimpleDateFormat("dd/MM/yyyy");
		dtCalender=Calendar.getInstance();
		dtCalender.setTime(dtFormat.parse(date));
	    dtCalender.add(Calendar.DAY_OF_MONTH,days);
		dtReturn=dtFormat.format(dtCalender.getTime());
        return dtReturn;
	}
	public String CurrentTime()
	{
		dtFormat=new SimpleDateFormat("HH:mm");
		dtCalender=Calendar.getInstance();
		dtReturn=dtFormat.format(dtCalender.getTime());
		return dtReturn;
	}
	
	public String SpecificTime(String time, int mintues) throws Exception
	{
		dtFormat=new SimpleDateFormat("HH:mm");
		dtCalender=Calendar.getInstance();
		dtCalender.setTime(dtFormat.parse(time));
	    dtCalender.add(Calendar.DAY_OF_MONTH,mintues);
		dtReturn=dtFormat.format(dtCalender.getTime());
        return dtReturn;
	}
	
	public String CurrentDateTime()
	{
		 dtFormat=new SimpleDateFormat("dd-MM-yyyy_HH.mm");  
		 dtCalender=Calendar.getInstance();
		 dtReturn=dtFormat.format(dtCalender.getTime());
		 return dtReturn;
	}
	
	public String DateFormat(int days)
	{
		 dtFormat=new SimpleDateFormat("dd-MMM-yyyy");  
		 dtCalender=Calendar.getInstance();
		 dtCalender.add(Calendar.DAY_OF_MONTH,days);
		 dtReturn=dtFormat.format(dtCalender.getTime());
	     return dtReturn;
	}
	
	public String DateFormat(String date) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(date));
		String dateMax = sdf.format(cal.getTime());
		
		return dateMax;
	}
	
	public String DateTimeFromat(String format,String dateTime,int minutes) throws Exception
	{
		dtFormat=new SimpleDateFormat(format);
		dtCalender=Calendar.getInstance();
		dtCalender.setTime(dtFormat.parse(dateTime));
		dtCalender.add(Calendar.MINUTE, minutes);
	    String time2=dtFormat.format(dtCalender.getTime());
	    return time2;
	}
	
	public String TimeStamp()
	{
		dtFormat=new SimpleDateFormat("HH:mm:ss");
		dtCalender=Calendar.getInstance();
		dtReturn=dtFormat.format(dtCalender.getTime());
		return dtReturn;
	}
	
	public String TimeDiff(String StartTime,String EndTime) throws Exception
	{
		dtFormat=new SimpleDateFormat("HH:mm:ss");
		Date d1=dtFormat.parse(StartTime);
		Date d2=dtFormat.parse(EndTime);
		long diff=d2.getTime()-d1.getTime();
		dtReturn= String.format("%02d:%02d:%02d",(diff/(60 * 60 * 1000) % 24),(diff/(60 * 1000) % 60),(diff/1000 % 60));
		return dtReturn;
	}
	
	public String isPass(boolean result)
	{
		String Status;
		
		if (result==true) {Status="Pass";}
		else {Status="Fail";}
		
		return Status;
	}
	
	public String isActualResult(String Status,String ActualResultPass,String ActualResultFail)
	{
		String ActualResult;
		
		if(Status.equals("Pass"))
		{ActualResult=ActualResultPass;}
		else
		{ActualResult=ActualResultFail;}
		
		return ActualResult;
	}
	
	public String MoveFile(String fromFilePath,String toFilePath)
	{
		String movePath=null;
		try 
		{
			Path temp1 = Files.move(
					Paths.get(fromFilePath)
					,Paths.get(toFilePath)
					                );
			
			movePath=temp1.toString();
			System.out.println("File Sucessfully moved!!!!!!");
		} 
		catch (Exception e) 
		{
			movePath=fromFilePath;
			System.out.println("Failed to move the file!!!!!!");
			e.printStackTrace();
		}
		
		return movePath;
	}
	
	public void KillCMD()
    {
        try
        {
            Runtime.getRuntime().exec("taskkill /f /im cmd.exe") ;
           
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
	
	public void Verify(boolean verify, String YesOrNo)
	{
		if (YesOrNo.equalsIgnoreCase("Yes"))
		{
			System.out.println(verify);
			Assert.assertTrue(verify);
		}
		else if (YesOrNo.equalsIgnoreCase("No"))
		{
			System.out.println(verify);
			Assert.assertFalse(verify);
		}
	}
	
	public void Verify(boolean verify, boolean TrueOrFalse)
	{
		if (TrueOrFalse == true)
		{
			System.out.println(verify);
			Assert.assertTrue(verify);
		}
		else if (TrueOrFalse == false)
		{
			System.out.println(verify);
			Assert.assertFalse(verify);
		}
	}
	
	public void Verify(String value1, String value2, boolean TrueOrFalse)
	{
		if (value1.equalsIgnoreCase(value2))
		{
			verify = true;
		}
		else
		{
			verify = false;
		}
		
		if (TrueOrFalse == true)
		{
			System.out.println(verify);
			Assert.assertTrue(verify);
		}
		else if (TrueOrFalse == false)
		{
			System.out.println(verify);
			Assert.assertFalse(verify);
		}
	}
	
	public boolean isFileDownloaded(String downloadPath)
	{
		File tmpDir = new File(downloadPath);
	    boolean isDownloded = tmpDir.exists();
	     
	    return isDownloded;
	}

//Added by Rakesh jaiswal
	public String  GSTIN()
    {   ////example valid GSTIN: 06ABIFS3908K1Z3
		String part1 =RandomNo(2);     // "06"; 
		String part2 = randomAlphabetic(5);   //ABIFS; 
		String part3 = RandomNo(4);   //3106; 
		String part4 = "K1Z3"; 
		String gst = part1+part2+part3+part4 ; System.out.println("GSTIN :"+gst);
		return gst ;
    }
	
	public String  randomAlphanumeric(int stringLength )
    {
		String v = RandomStringUtils.randomAlphanumeric(stringLength);
		return v; 
    }
	
	
	public String randomAlphabetic(int stringLength )
    {
		String v = RandomStringUtils.randomAlphabetic(stringLength);
		return v; 
	}

	
	public String SpecificDate(int days) throws Exception
	{
	SimpleDateFormat dtFormat = new SimpleDateFormat("dd MMMMM yyyy");
	Calendar dtCalender = Calendar.getInstance();
	    dtCalender.add(Calendar.DAY_OF_MONTH,days);
	    String dtReturn = dtFormat.format(dtCalender.getTime());
	    
        return dtReturn;
	}
	public String SpecificDate1(String format,  int days) throws Exception
	{
	SimpleDateFormat dtFormat = new SimpleDateFormat(format);
	Calendar dtCalender = Calendar.getInstance();
	    dtCalender.add(Calendar.DAY_OF_MONTH,days);
	    String dtReturn = dtFormat.format(dtCalender.getTime());
	    
        return dtReturn;
	}
	
	
	

	
	
}