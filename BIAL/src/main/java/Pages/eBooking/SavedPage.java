package Pages.eBooking;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.WebdriverMethods;

public class SavedPage {
	public WebDriver driver;
	public WebdriverMethods wm;
	boolean verify = false;
	
	public SavedPage(WebDriver driver, WebdriverMethods wm) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wm = wm;
	}
	
	//saved screen
	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'Saved')]")
	 public WebElement SavedScreen;
	
	//Fliter operator menu 
	@FindBy(how = How.XPATH, using = "//*[@id='filterMenuDiv']/a")
	 public List<WebElement> FilterOperatorMenuList;
	
	//created job grid     
	@FindBy(how = How.ID, using = "ctl00_hldPage_grdBookingRecieved_ctl01_chkSelectAllJobs")
	 public WebElement SelectAllJob_CB;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingRecieved']/tbody/tr[@class='NormalRowBlur']/td[1]/input")
	 public List<WebElement> SavedJobCheckboxColList;
	
	//URN
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingRecieved']/tbody/tr[@class='NormalRowBlur']/td[2]/a")
	 public List<WebElement> SavedJobUrnColList;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_grdBookingRecieved_ctl01_txtFilter1")
	 public WebElement UrnFilter_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_grdBookingRecieved_ctl01_imgFilterOperator1")
	 public WebElement UrnFilterOperator;
	
	//date
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingRecieved']/tbody/tr[@class='NormalRowBlur']/td[4]")
	 public List<WebElement> SavedJobDateColList;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_grdBookingRecieved_ctl01_txtFilter2")
	 public WebElement DateFilter_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_grdBookingRecieved_ctl01_imgFilterOperator2")
	 public WebElement DateFilterOperator;
	
	//shipper name  
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingRecieved']/tbody/tr[@class='NormalRowBlur']/td[5]")
	 public List<WebElement> SavedJobShipperColList;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_grdBookingRecieved_ctl01_txtFilter4")
	 public WebElement ShipperFilter_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_grdBookingRecieved_ctl01_imgFilterOperator4")
	 public WebElement ShipperFilterOperator;
	
	//origin
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingRecieved']/tbody/tr[@class='NormalRowBlur']/td[6]")
	 public List<WebElement> SavedJobOriginColList;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_grdBookingRecieved_ctl01_txtFilter6")
	 public WebElement OriginFilter_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_grdBookingRecieved_ctl01_imgFilterOperator6")
	 public WebElement OriginFilterOperator;
	
	//destination
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingRecieved']/tbody/tr[@class='NormalRowBlur']/td[7]")
	 public List<WebElement> SavedJobDestinationColList;
	
	//gross weight
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingRecieved']/tbody/tr[@class='NormalRowBlur']/td[8]")
	 public List<WebElement> SavedJobGrossWtColList;
	
	//job status
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingRecieved']/tbody/tr[@class='NormalRowBlur']/td[10]")
	 public List<WebElement> SavedJobStatusColList;
	
	//Action - copy booking icon
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingRecieved']/tbody/tr[@class='NormalRowBlur']/td[11]/a[2]")
	 public List<WebElement> JobCopyBookingIconList;
	
	// hwab view icon
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingRecieved']/tbody/tr[@class='NormalRowBlur']/td[12]/a")
	 public List<WebElement> JobHawbViewIconList;
	
	//mawb view icon
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingRecieved']/tbody/tr[@class='NormalRowBlur']/td[13]/a")
	 public List<WebElement> JobMawbViewIconList;
	
	//e-Docket icon
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingRecieved']/tbody/tr[@class='NormalRowBlur']/td[14]/input[@title='e-Docket']")
	 public List<WebElement> Job_eDocketIconList;
	
	//e-Docket popup  
	@FindBy(how = How.ID, using = "ui-dialog-title-EDocket")
	 public WebElement eDocketPopup;
	
	 @FindBy(how = How.ID, using = "IframEdocket")
	 public WebElement eDocketPopupFrame;
	 
	@FindBy(how = How.XPATH, using = "//*[@id='divDocsForBooking']/table[1]/tbody/tr/td/table/tbody/tr/td/select")
	 public List<WebElement> DocumentTypeDropdownList; 
	
	@FindBy(how = How.XPATH, using = "//*[@id='divDocsForBooking']/table[1]/tbody/tr/td/table/tbody/tr/td/select")
	 public List<WebElement> ChooseFileBtnList;
	
	@FindBy(how = How.ID, using = "DialogUploadedDocs1")
	 public WebElement DocumentUploadedGrid;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnClear")
	 public WebElement eDocketClearBtn;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnUploadSave")
	 public WebElement eDocketUploadBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='aspnetForm]/div[10]/div[11]/button")
	 public WebElement eDocketCloseBtn;
	
	//buttons   
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnClearFilter")
	 public WebElement ClearFilterBtn;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnForward")
	 public WebElement ForwardToAirlineBtn;
	
	//hawb view    
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdHAWBview']")
	 public WebElement HawbViewGrid;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdHAWBview']/tbody/tr/td[1]/a")
	 public List<WebElement> HawbViewMawbNoLinkColList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdHAWBview']/tbody/tr/td[2]/a")
	 public List<WebElement> HawbViewHawbNoLinkColList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdHAWBview']/tbody/tr/td[3]")
	 public List<WebElement> HawbViewHawbDateColList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdHAWBview']/tbody/tr/td[4]/a")
	 public List<WebElement> HawbViewOriginColList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdHAWBview']/tbody/tr/td[5]/a")
	 public List<WebElement> HawbViewDestinationColList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdHAWBview']/tbody/tr/td[6]/a")
	 public List<WebElement> HawbViewShipperColList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdHAWBview']/tbody/tr/td[5]/a")
	 public List<WebElement> HawbViewGrossWtColList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdHAWBview']/tbody/tr/td[5]/a")
	 public List<WebElement> HawbViewVolumeColList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdHAWBview']/tbody/tr/td[5]/a")
	 public List<WebElement> HawbViewChargebleWtColList;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnBack")
	 public WebElement HawbViewBackBtn;
	
	
	
	
	
	
	public void ClickOnButton(String buttonName) throws Exception
	{
		if(buttonName.equalsIgnoreCase("Clear Filter"))
		{
			ClearFilterBtn.click();
		}
		if(buttonName.equalsIgnoreCase("Forward To Airline"))
		{
			wm.JavascriptExecutor_ElementScroll(driver, ForwardToAirlineBtn);
			ForwardToAirlineBtn.click();
		}
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnIcon(String iconName, int rowNo) throws Exception
	{
		if(iconName.equalsIgnoreCase("URN"))
		{
			SavedJobUrnColList.get(rowNo-1).click();
		}
		if(iconName.equalsIgnoreCase("Copy Booking"))
		{
			JobCopyBookingIconList.get(rowNo-1).click();
		}
		if(iconName.equalsIgnoreCase("HAWB View"))
		{
			JobHawbViewIconList.get(rowNo-1).click();
		}
		if(iconName.equalsIgnoreCase("MAWB View"))
		{
			JobMawbViewIconList.get(rowNo-1).click();
		}
		if(iconName.equalsIgnoreCase("e-Docket"))
		{
			Job_eDocketIconList.get(rowNo-1).click();
		}
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void SelectJob(int rowNo) throws Throwable
	{
		SavedJobCheckboxColList.get(rowNo-1).click();
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(4000);
	}
	
	public void Filter(String fieldName, String filterValue, String opeator) throws Throwable
	{
		if(fieldName.equalsIgnoreCase("URN"))
		{
			UrnFilter_TB.sendKeys(filterValue);
			Thread.sleep(300);
			UrnFilterOperator.click();
		}
		if(fieldName.equalsIgnoreCase("Date"))
		{
			DateFilter_TB.sendKeys(filterValue);
			Thread.sleep(300);
			DateFilterOperator.click();
		}
		if(fieldName.equalsIgnoreCase("Shipper"))
		{
			ShipperFilter_TB.sendKeys(filterValue);
			Thread.sleep(300);
			ShipperFilterOperator.click();
		}
		if(fieldName.equalsIgnoreCase("Origin"))
		{
			OriginFilter_TB.sendKeys(filterValue);
			Thread.sleep(300);
			OriginFilterOperator.click();
		}
		
		Thread.sleep(1000);
		for (int i = 0; i < FilterOperatorMenuList.size(); i++) 
		{
			if (wm.isElementTextContain(driver, FilterOperatorMenuList.get(i), opeator) == true)
			{
				FilterOperatorMenuList.get(i).click();
			}
		}
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void eDocketDocumentUpload(String documentType, String chooseFilePath, int rowNo) throws Throwable
	{
		wm.selectDropDownElementByVisibleText(driver, DocumentTypeDropdownList.get(rowNo), documentType);
		Thread.sleep(500);
		
		ChooseFileBtnList.get(rowNo).sendKeys(chooseFilePath);
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(500);	
	}
	
	public void ClickOn_eDocketButtons(String buttonName)
	{
		if(buttonName.equalsIgnoreCase("Clear"))
		{
			eDocketClearBtn.click();
		}
		if(buttonName.equalsIgnoreCase("Upload"))
		{
			eDocketUploadBtn.click();
		}
		if(buttonName.equalsIgnoreCase("Close"))
		{
			eDocketCloseBtn.click();
		}
	}
	
	
	
}
