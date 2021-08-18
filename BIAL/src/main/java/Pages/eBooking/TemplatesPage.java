package Pages.eBooking;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.WebdriverMethods;

public class TemplatesPage {
	public WebDriver driver;
	public WebdriverMethods wm;
	boolean verify = false;
	
	public TemplatesPage(WebDriver driver, WebdriverMethods wm) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wm = wm;
	}
	
	//template screen  
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Booking Template List')]")
	 public WebElement TemplateSceen;
	
	//template grid
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_GrdBookingSent']/tbody/tr[@class='NormalRowBlur']")
	 public List<WebElement> TemplateGridRowList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_GrdBookingSent']/tbody/tr[@class='NormalRowBlur']/td/a")
	 public List<WebElement> TemplateNameColList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_GrdBookingSent']/tbody/tr[@class='NormalRowBlur']/td[2]")
	 public List<WebElement> TemplateDateColList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_GrdBookingSent']/tbody/tr[@class='NormalRowBlur']/td[3]/input[1]")
	 public List<WebElement> TemplateEditColList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_GrdBookingSent']/tbody/tr[@class='NormalRowBlur']/td[3]/input[2]")
	 public List<WebElement> TemplateDeleteColList;
	
	//booking status popup  
	@FindBy(how = How.XPATH, using = "//*[text()='Booking Status']")
	 public WebElement BookingStatusPopup;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblStatusMsg")
	 public WebElement BookingStatusMsg;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnCloseDialog")
	 public WebElement OkBookingStatusBTN; 
	
	//confirm popup
	@FindBy(how = How.XPATH, using = "//*[text()='Confirm']")
	 public WebElement ConfirmPopup;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblMstAlert")
	 public WebElement ConfirmPopupMsg;
	
	@FindBy(how = How.XPATH, using = "//*[text()='Delete']")
	 public WebElement ConfirmPopupDeleteBtn;
	
	@FindBy(how = How.XPATH, using = "//*[text()='Cancel']")
	 public WebElement ConfirmPopupCancelBtn;
	
	//message popup
	@FindBy(how = How.XPATH, using = "//*[text()='Message' and @class='modal-title']")
	 public WebElement MessagePopup;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblMstSuccess")
	 public WebElement MessagePopupMsg;
	
	@FindBy(how = How.XPATH, using = "//*[@value='Ok' and @type='button']")
	 public WebElement MessagePopupOkBtn;
	
	
	
	
	
	public void ClickOnGridIcon(String iconName, int rowNo) throws Throwable
	{
		if (iconName.equalsIgnoreCase("Template Name"))
			TemplateNameColList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("Edit"))
			TemplateEditColList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("Delete"))
			TemplateDeleteColList.get(rowNo-1).click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(500);
	}
	
	public void ClickOnBookingStatusPopupButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Ok"))
			OkBookingStatusBTN.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(500);
	}
	
	public void ClickOnConfirmPopupButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Delete"))
			ConfirmPopupDeleteBtn.click();
		if (buttonName.equalsIgnoreCase("Cancel"))
			ConfirmPopupCancelBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(500);
	}
	
	public void ClickOnMessagePopupButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Ok"))
			MessagePopupOkBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(500);
	}
	
	
}
