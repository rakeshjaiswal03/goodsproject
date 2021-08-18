package screenshotMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.cucumber.listener.Reporter;

import Methods.WebdriverMethods;
import cucumber.api.Scenario;

public class ScreenShotMethod 
{
	String ScreenShotFolderPath = null, ScreenShotPath = null, TimeStamp = null;
	String ScreenShotFolder = null, ScreenShotPassedFolder = null, ScreenShotFailedFolder = null;
	String ConfigKeysFile = "Config_Keys.properties";
	
	WebDriver driver;
	public Methods.CommonMethods mcm; 
	public CommonMethods cm;
	public WebdriverMethods wm;
	
	public ScreenShotMethod() throws Throwable 
	{
		File file = new File(ConfigKeysFile);
		InputStream fis = new FileInputStream(file);
		Properties pf = new Properties();
		pf.load(fis);
		
		ScreenShotFolderPath = pf.getProperty("ScreenShotPath");
		
		cm = new CommonMethods();
		wm = new WebdriverMethods(driver);
		mcm = new Methods.CommonMethods();
		
		ScreenShotFolder = cm.CreateFolder(ScreenShotFolderPath, mcm.CurrentDate("dd-MMM-yyyy"));
		ScreenShotPassedFolder = cm.CreateFolder(ScreenShotFolder, "ScreenShot_Passed");
		ScreenShotFailedFolder = cm.CreateFolder(ScreenShotFolder, "ScreenShot_Failed");
	}
	
	public String ScreenShot(WebDriver driver) throws IOException
	{
		try
        {
	  		TimeStamp = new SimpleDateFormat("ddMMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
	  	    ScreenShotPath = ScreenShotFolderPath+"OMS_"+TimeStamp+".png";
	  	    File screenshots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);       		 
		    FileUtils.copyFile(screenshots, new File(ScreenShotPath));
        }
	  	catch(Exception Ex)
	  	{
	  		System.out.println(Ex.getMessage());       	
	  	}
	  	return ScreenShotPath;
	}
	
	public String ScreenShot(WebDriver driver, String screenshotName) throws IOException
	{
		try
        {
	  		TimeStamp = new SimpleDateFormat("ddMMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
	  	    ScreenShotPath = ScreenShotFolderPath+"OMS_"+screenshotName+"_"+TimeStamp+".png";
	  	    File screenshots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);       		 
		    FileUtils.copyFile(screenshots, new File(ScreenShotPath));
        }
	  	catch(Exception Ex)
	  	{
	  		System.out.println(Ex.getMessage());       	
	  	}
	  	return ScreenShotPath;
	}
	
	
	public void ReportScreenshot(WebDriver driver, Scenario scenario)
	{
		try
		{
			String screenshotName = scenario.getName().replaceAll(" ", "_"); 
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            File screenshot_with_scenario_name = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
            
            System.out.println("Screenshot Name: " + screenshotName);
            
            TimeStamp = new SimpleDateFormat("ddMMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
            if (scenario.isFailed() == true)
            {
            	ScreenShotPath = ScreenShotFailedFolder+"BIAL_"+screenshotName+"_"+TimeStamp+".png";
            }
            else
            {
            	ScreenShotPath = ScreenShotPassedFolder+"BIAL_"+screenshotName+"_"+TimeStamp+".png";
            }
	  	    
            File destinationPath = new File(ScreenShotPath);
            Files.copy(screenshot_with_scenario_name.toPath(), destinationPath.toPath());
            
			Reporter.addScreenCaptureFromPath(destinationPath.toString());
	        Reporter.addScenarioLog(screenshotName);
	        
	        scenario.embed(screenshot, "image/png");
		} 
		catch (IOException somePlatformsDontSupportScreenshots) 
		{
			System.err.println(somePlatformsDontSupportScreenshots.getMessage());
		} 
	}
	
	
	
	
	
	
	
	
	
	
	
}
