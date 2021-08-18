package Pages.eBooking;

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

public class BookingShipmentPage {
	public WebDriver driver;
	public WebdriverMethods wm;
	public CommonMethods cm;
	boolean verify = false;
	
	public BookingShipmentPage(WebDriver driver, WebdriverMethods wm, CommonMethods cm) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.cm = cm;
		this.wm = wm;
	}
	
	//screen
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Booking Shipment')]")
	 public WebElement BookingShipmentScreen;
	
	//Shipment type popup
	@FindBy(how = How.XPATH, using = "//*[text()='Shipment Type']")
	 public WebElement ShipmentTypePopup;
	
	@FindBy(how = How.XPATH, using = "//*[@for='Yes']")
	 public WebElement ConsolYes_RB;
	
	@FindBy(how = How.XPATH, using = "//*[@for='No']")
	 public WebElement ConsolNo_RB;
	
	@FindBy(how = How.ID, using = "btnSphCanccel")
	 public WebElement ShipmentTypeSubmitBtn;
	
	//Job details grid   
	@FindBy(how = How.XPATH, using = "//*[@id='FwbRFQDetailNo1']/table/thead/tr")
	 public List<WebElement> JobDetailsGridHeadRowList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='FwbRFQDetailNo1']/table/tbody/tr")
	 public List<WebElement> JobDetailsGridRowList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='FwbRFQDetailNo1']/table/thead/tr/td/strong")
	 public List<WebElement> JobDetailsGridColHeaderList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='FwbRFQDetailNo1']/table/tbody/tr/td")
	 public List<WebElement> JobDetailsGridColValueList;
	
	//origin
	@FindBy(how = How.ID, using = "ctl00_hldPage_lvGroupedCargos_ctrl0_AirlineOriginPort_txtCode")
	 public WebElement OriginCode_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lvGroupedCargos_ctrl0_AirlineOriginPort_txtName")
	 public WebElement OriginName_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lvGroupedCargos_ctrl0_AirlineDestinationPort_txtCode")
	 public WebElement DestinationCode_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lvGroupedCargos_ctrl0_AirlineDestinationPort_txtName")
	 public WebElement DestinationName_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lvGroupedCargos_ctrl0_GenericAutoFillRoute1_txtCode")
	 public WebElement Via1Code_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lvGroupedCargos_ctrl0_GenericAutoFillRoute1_txtName")
	 public WebElement Via1Name_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lvGroupedCargos_ctrl0_GenericAutoFillRoute2_txtCode")
	 public WebElement Via2Code_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lvGroupedCargos_ctrl0_GenericAutoFillRoute2_txtName")
	 public WebElement Via2Name_TB;
	
	//schedule for 
	@FindBy(how = How.ID, using = "ctl00_hldPage_lvGroupedCargos_ctrl0_TxtAirlineScheduleTime")
	 public WebElement ScheduleForDate_TB; 
	
	//booking shipment buttons
	@FindBy(how = How.ID, using = "ctl00_hldPage_lvGroupedCargos_ctrl0_btnGetSchedule")
	 public WebElement GetScheduleBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@title='Go to Sent Job']")
	 public WebElement GoToSentJobBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@title='Go to Received Job']")
	 public WebElement GoToReceivedJobBtn;
	 
	 //airline schedule 
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Airline Schedule')]")
	 public WebElement AirlineScheduleTab;
	 
	@FindBy(how = How.XPATH, using = "//*[@id='tblAirline']/tbody/tr")
	 public List<WebElement> AirlineScheduleGridRowList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblAirline']/tbody/tr/td/input[@type='checkbox']")
	 public List<WebElement> AirlineScheduleGridCheckboxList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblAirline']/tbody/tr/td/input[@type='text']")
	 public List<WebElement> AirlineScheduleGridTextboxList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblAirline']/tbody/tr/td/img")
	 public List<WebElement> AirlineScheduleGridIconList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblAirline']/tbody/tr/td/table/tbody/tr/td/input")
	 public List<WebElement> AirlineScheduleGridAwbTextboxList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblAirline']/tbody/tr/td/a")
	 public List<WebElement> AirlineScheduleGridRateList;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_BtnForward")
	 public WebElement SubmitFlightDetailsBtn;
	
	//message popup
	@FindBy(how = How.XPATH, using = "//*[text()='Message' and @class='modal-title']")
	 public WebElement MessagePopup;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblright")
	 public WebElement MessagePopupText;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnNo")
	 public WebElement MessagePopupNoBtn;
	 
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnYes")
	 public WebElement MessagePopupYesBtn;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblMessage")
	 public WebElement MessagePopupMsgText;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_Button1")
	 public WebElement MessagePopupOkBtn; 
	 
	//Booking status 
	@FindBy(how = How.XPATH, using = "//*[@id='dialogCheckMAWB']//*[text()='Booking Status']")
	 public WebElement BookingStatusPopup;
	
	@FindBy(how = How.XPATH, using = "//*[@id='divMsgBox']//*[text()='Booking Status']")
	 public WebElement BookingStatusPopup2;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblMAWBMsg")
	 public WebElement BookingStatusText;//ctl00_hldPage_lblCreateBookingStatusMsg
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnViewMAWB")
	 public WebElement BookingStatusPopupNoBtn; //ctl00_hldPage_btnCloseDialog
	 
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnCreateMAWB")
	 public WebElement BookingStatusPopupYesBtn;//ctl00_hldPage_Button2
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblCreateBookingStatusMsg")
	 public WebElement BookingStatus2Text;//
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnCloseDialog")
	 public WebElement BookingStatusPopup2NoBtn; //
	 
	@FindBy(how = How.ID, using = "ctl00_hldPage_Button2")
	 public WebElement BookingStatusPopup2YesBtn;//
	
	public void EnterValue(String fieldName, String value)
	{
		if (fieldName.equalsIgnoreCase("Schedule For"))
			ScheduleForDate_TB.sendKeys(value);

		wm.ImplicitlyWait(driver, 5);
	}
	
	public void ClickOnButton(String buttonName) throws Throwable
	{ Thread.sleep(5000);
		if (buttonName.equalsIgnoreCase("Get Schedule"))
			GetScheduleBtn.click();
		if (buttonName.equalsIgnoreCase("Go to Received Job"))
			GoToReceivedJobBtn.click();
		if (buttonName.equalsIgnoreCase("Go to Sent Job"))
			GoToSentJobBtn.click();
		if (buttonName.equalsIgnoreCase("Submit filght details"))
			SubmitFlightDetailsBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnShipmentTypePopupButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Submit"))
			ShipmentTypeSubmitBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void SelectShipmentType(String consolYesOrNo)
	{
		if (consolYesOrNo.equalsIgnoreCase("Yes"))
		{
			ConsolYes_RB.click();
		}
		if (consolYesOrNo.equalsIgnoreCase("No"))
		{
			ConsolNo_RB.click();
		}
		
		wm.ImplicitlyWait(driver, 5);
	}
	
	public String AddAirlineScheduleDetails(String prefix, String flightNo, int rowNo) throws Throwable
	{ Thread.sleep(3000);
		String awbNo = null;
		
		AirlineScheduleGridCheckboxList.get(rowNo-1).click();
		Thread.sleep(1000);
		AirlineScheduleGridAwbTextboxList.get((rowNo-1)*2).sendKeys(prefix, Keys.TAB);
		Thread.sleep(1000);
		wm.ElementAttributeContainsExplicityWait(driver, AirlineScheduleGridTextboxList.get(((rowNo-1)*2)), "value", "ZZ", 5);
		System.out.println(wm.ElementAttributeValue(driver, AirlineScheduleGridTextboxList.get(((rowNo-1)*2)), "value"));
		
		String awbNoFieldValue = wm.ElementAttributeValue(driver, AirlineScheduleGridAwbTextboxList.get(((rowNo-1)*2)+1), "value");
		System.out.println(awbNoFieldValue);
		if (awbNoFieldValue.isEmpty() || awbNoFieldValue.equals("")  || awbNoFieldValue.equals("11116630"))
		{
			awbNo = cm.Random_awbNo();Thread.sleep(500);
			AirlineScheduleGridAwbTextboxList.get(((rowNo-1)*2)+1).clear();
			AirlineScheduleGridAwbTextboxList.get(((rowNo-1)*2)+1).sendKeys(awbNo,Keys.TAB);
			Thread.sleep(500);
		}
		else
		{
			awbNo = wm.ElementAttributeValue(driver, AirlineScheduleGridAwbTextboxList.get(((rowNo-1)*2)+1), "value");
		}
		System.out.println("AWB no.: "+awbNo);
		WebElement MAWB = AirlineScheduleGridTextboxList.get(((rowNo-1)*12)+3); 
		wm.VisibilityOfElementExplicityWait(driver, MAWB, 10); wm.ImplicitlyWait(driver, 10);
		MAWB.clear();
		MAWB.sendKeys(flightNo);
		
		wm.ImplicitlyWait(driver, 5); Thread.sleep(500);
		
		return awbNo;
	}
	
	public void AddAirlineScheduleDetails(String prefix, String awbNo, String flightNo, int rowNo) throws Throwable
	{
		AirlineScheduleGridCheckboxList.get(rowNo-1).click();
		Thread.sleep(1000);
		AirlineScheduleGridAwbTextboxList.get((rowNo-1)*2).sendKeys(prefix, Keys.TAB);
		Thread.sleep(1000);
		wm.ElementAttributeContainsExplicityWait(driver, AirlineScheduleGridTextboxList.get(((rowNo-1)*2)), "value", "ZZ", 5);
		System.out.println(wm.ElementAttributeValue(driver, AirlineScheduleGridTextboxList.get(((rowNo-1)*2)), "value"));
		
		String awbNoFieldValue = wm.ElementAttributeValue(driver, AirlineScheduleGridAwbTextboxList.get(((rowNo-1)*2)+1), "value");
		System.out.println(awbNoFieldValue);
		if (awbNoFieldValue.isEmpty() || awbNoFieldValue.equals(""))
		{
			AirlineScheduleGridAwbTextboxList.get(((rowNo-1)*2)+1).sendKeys(awbNo,Keys.TAB);
			Thread.sleep(500);
		}
		else
		{
			AirlineScheduleGridAwbTextboxList.get(((rowNo-1)*2)+1).clear();
			AirlineScheduleGridAwbTextboxList.get(((rowNo-1)*2)+1).sendKeys(awbNo,Keys.TAB);
			Thread.sleep(500);
		}
		System.out.println("AWB no.: "+awbNo);
		
		AirlineScheduleGridTextboxList.get(((rowNo-1)*12)+3).sendKeys(flightNo);
		
		wm.ImplicitlyWait(driver, 5);
		Thread.sleep(500);
	}
	
	public void ClickOnMessagePopupButton(String buttonName) throws Throwable
	{ Thread.sleep(5000);
		if (buttonName.equalsIgnoreCase("No"))
			MessagePopupNoBtn.click();
		if (buttonName.equalsIgnoreCase("Yes"))
			MessagePopupYesBtn.click();
		if (buttonName.equalsIgnoreCase("Ok"))
			MessagePopupOkBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnBookingStatusPopupButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("No"))
			BookingStatusPopupNoBtn.click();
		if (buttonName.equalsIgnoreCase("Yes"))
			BookingStatusPopupYesBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnBookingStatusPopup2Button(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("No"))
			BookingStatusPopup2NoBtn.click();
		if (buttonName.equalsIgnoreCase("Yes"))
			BookingStatusPopup2YesBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public boolean isJobDetailsGridDisplayed(int noOfJobs)
	{
		if (JobDetailsGridHeadRowList.size() >= noOfJobs && JobDetailsGridRowList.size() >= noOfJobs)
		{
			verify = true;
		}
		else
		{
			verify = false;
		}
		
		return verify;
	}
	
	
	
	
	
}
