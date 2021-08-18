package Pages.eBooking;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.WebdriverMethods;

public class DraftsPage {
	public WebDriver driver;
	public WebdriverMethods wm;
	boolean verify = false;
	
	public DraftsPage(WebDriver driver, WebdriverMethods wm) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wm = wm;
	}
	
	//draft screen  
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Booking Drafts')]")
	 public WebElement DraftScreen;
	
	//draft no
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_GrdBookingDraft']/tbody/tr/td[1]/a")
	 public List<WebElement> DraftNoColLinkList;
	
	//draft name
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_GrdBookingDraft']/tbody/tr/td[3]")
	 public List<WebElement> DraftNameColList;
	
	//draft date
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_GrdBookingDraft']/tbody/tr/td[4]")
	 public List<WebElement> DraftDateColList;
	
	//delete icon
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_GrdBookingDraft']/tbody/tr/td[5]/a/img")
	 public List<WebElement> DraftDeleteIconColList;
	
	//booking status popup
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblststus")
	 public WebElement BookingStatusPopup;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblStatusMsg")
	 public WebElement BookingStatusPopupMsg;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnCloseDialog")
	 public WebElement BookingStatusPopupOkBtn;
	
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
		if (iconName.equalsIgnoreCase("Draft no"))
			DraftNoColLinkList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("Delete"))
			DraftDeleteIconColList.get(rowNo-1).click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(500);
	}
	
	public void ClickOnBookingStatusPopupButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Ok"))
			BookingStatusPopupOkBtn.click();
		
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
