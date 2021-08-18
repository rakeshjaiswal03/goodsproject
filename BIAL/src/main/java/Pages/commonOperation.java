package Pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.CommonMethods;
import Methods.WebdriverMethods;


public class commonOperation {
	
	
	WebdriverMethods wm;
	WebDriver driver;
	CommonMethods cm; 
	RegistrationPage rp = new RegistrationPage(driver,  wm,  cm); 
	
	
	public commonOperation(WebDriver driver, Methods.WebdriverMethods wm, CommonMethods cm) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wm = wm;
		this.cm = cm; 
	}


	
//	added by Rakesh Jaiswal
	
	public String randomGSTIN() {
		String regex = "^[0-9]{2}[A-Z]{5}[0-9]{4}"
                + "[A-Z]{1}[1-9A-Z]{1}"
                + "Z[0-9A-Z]{1}$";
		return regex;
	}
	


	public  Boolean isElementTextContain(WebDriver driver, WebElement Element, String ElementText)
    {
		boolean isMatch = false;
        try
        {
            isMatch = Element.getText().contains(ElementText);
        }
        catch (Exception ex)
        {
        	isMatch = false;
        	System.out.println(ex.toString());
        }
        
        return isMatch;
    }
	
	
//	colFilter
	@FindBy (how = How.XPATH, using = "//tr[@class='gridHeader-yellow']//table/tbody/tr[1]/td[1]/input[1] ")
	public List <WebElement> ColFilterIconList;
	@FindBy (how = How.XPATH, using = "//table[@id='ctl00_hldPage_grdReceivedRequest']/tbody/tr/th/a ")
	public List <WebElement> ColHeaderNameList;
	@FindBy (how = How.XPATH, using = " //a[@id='filterMenustartswith']")
	public WebElement startsWithFliter_TB;
	
	@FindBy (how = How.XPATH, using = " //input[@id='ctl00_hldPage_grdReceivedRequest_ctl01_txtFilter0']")
	public WebElement searchbar;
	


	public void ColheaderFilter(WebDriver driver, List <WebElement> ColFilterIconList, List <WebElement> ColHeaderNameList, 
			WebElement searchbar,  String colName, String fliterValue) throws Throwable
	{
		 for (int i = 0; i <= ColFilterIconList.size(); i++) 
		 {
			 if(isElementTextContain(driver, ColHeaderNameList.get(i), colName) == true)
			 {
				 System.out.println();
				 Thread.sleep(2000);
				 ColFilterIconList.get(i+1).click();
				 break;
			 }
		 }
		 wm.ImplicitlyWait(driver, 6);
//		 Thread.sleep(3000);
		 
		 startsWithFliter_TB.click(); 
		 
		 searchbar.sendKeys(fliterValue, Keys.ENTER);


  	}
	
	

	

	
	
		
	
	
	
	
	
	

}
