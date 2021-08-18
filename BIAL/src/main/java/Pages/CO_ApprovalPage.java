package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.WebdriverMethods;

public class CO_ApprovalPage {
	public WebDriver driver;
	public WebdriverMethods wm;
	boolean verify = false;
	
	public CO_ApprovalPage(WebDriver driver, WebdriverMethods wm) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wm = wm;
	}
	
	
	//co approval screen
	@FindBy(how = How.XPATH, using = "//h5[text()='Carting Order Shipments']")
	 public WebElement coApprovalScreen;
	
	//mawb no
	@FindBy(how = How.ID, using = "ctl00_hldPage_txtAWBNo")
	 public WebElement MawbNo_TB;
	
	//buttons
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnSearch")
	 public WebElement SearchBtn;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnViewCoDetails")
	 public WebElement ViewCoDetailsBtn;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnShowPendingCo")
	 public WebElement RefreshBtn;
	
	//CO Approval Grid
	//mawb no col
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_AirLineHome']/tbody/tr/td[1]/a")
	 public List<WebElement> MawbNoLinkList;
	
	//approve icon
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_AirLineHome']/tbody/tr/td[11]/a/img")
	 public List<WebElement> ActionIconList;
	
	//carting orfer approval screen
	@FindBy(how = How.XPATH, using = "//h5[text()='Carting Order Approval']")
	 public WebElement CartingOrderApprovalScreen;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_txtAirlineCode")
	 public WebElement Prefix_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_txtAWBNo")
	 public WebElement AwbNo_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_txtFlight")
	 public WebElement FlightCode_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_txtFlightNo")
	 public WebElement FlightNo_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_txtDate")
	 public WebElement FlightDate_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnBack")
	 public WebElement BackBtn;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnReject")
	 public WebElement RejectBtn;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnSubmit")
	 public WebElement ApproveBtn;
	
	
	//message popup   
	@FindBy(how = How.XPATH, using = "//*[@id='pnlmessage4']//*[contains(text(),'Success')]")
	 public WebElement SuccessPopup;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblError")
	 public WebElement SuccessPopupMsg;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_Button1")
	 public WebElement SuccessPopupOkBtn;
	
	
	
	
	public void SearchMawb(String mawbNo) throws Throwable
	{
		MawbNo_TB.sendKeys(mawbNo);
		
		SearchBtn.click();
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(3000);
	}
	
	public void ClickOnGridIcon(String iconName, int rowNo) throws Throwable
	{
		if (iconName.equalsIgnoreCase("Action"))
			ActionIconList.get(rowNo-1).click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnCartingOrderApprovalButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Approve"))
			ApproveBtn.click();
		if (buttonName.equalsIgnoreCase("Reject"))
			RejectBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnSuccessPopupButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Ok"))
			SuccessPopupOkBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	
}
