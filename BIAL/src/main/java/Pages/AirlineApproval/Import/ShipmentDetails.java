package Pages.AirlineApproval.Import;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.CommonMethods;
import Methods.WebdriverMethods;

public class ShipmentDetails {
	
	public WebDriver driver;
	public WebdriverMethods wm;
	public CommonMethods cm; 
	
	public ShipmentDetails(WebDriver driver, WebdriverMethods wm, CommonMethods cm) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wm = wm;
		this.cm = cm;
	}
	
	@FindBy(how= How.XPATH,using= "//input[@id='ctl00_hldPage_txtIGM']") 
	public WebElement IGM_No_TB;
	
	@FindBy(how= How.XPATH,using= "//input[@id='ctl00_hldPage_btnSearch']") 
	public WebElement SearchBtn;
	@FindBy(how= How.XPATH,using= "//input[@id='ctl00_hldPage_grdADO_ctl02_btnConsolDO']") 
	public WebElement ActionBtn_pendingADO;
	
	//// Approve DO popup window
	@FindBy(how= How.XPATH,using= "//h5[@id='hdrASISbn']") 
	public WebElement ApproveDO_popupTitle;
	@FindBy(how= How.XPATH,using= "//input[@id='ctl00_hldPage_btnDOSubmit']") 
	public WebElement ApproveDO_popup_SubmitBtn;
	
	// Message popup
	@FindBy(how= How.XPATH, using="//span[@id='ctl00_hldPage_lblADOSuccess']")
	public WebElement MessagePopup_txt;
	@FindBy(how= How.XPATH, using="//input[@id='ctl00_hldPage_btnsuccess']")
	public WebElement MessagePopup_OKbtn;
	
	///// Filter search 
	@FindBy(how= How.XPATH, using="//input[@id='ctl00_hldPage_grdMAWB_ctl01_txtFilter3']")
	public WebElement IGMNo_TB;
	@FindBy(how= How.XPATH, using="//input[@id='ctl00_hldPage_grdMAWB_ctl01_imgFilterOperator3']")
	public WebElement MawbNoOperatorIconDD;
	@FindBy(how = How.XPATH, using = "//*[@id='filterMenuDiv']/a")
	 public List<WebElement> FilterOperatorMenuList;
	////// Expand filtered Row
	@FindBy(how = How.XPATH, using = "//table[@id='ctl00_hldPage_grdMAWB']/tbody/tr[2]/td/img")
	 public WebElement gridExpandBtn;
		///// Grid Row Elements 
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_grdMAWB_ctl02_HyperLinkSB']")
	 public WebElement BOE_btn;
	
	
	public void Filter(String colName, String filterValue, String opeator) throws Throwable
	{ 	wm.VisibilityOfElementExplicityWait(driver, IGMNo_TB, 40);
		if(colName.equalsIgnoreCase("IGM No"))
		{	Thread.sleep(1000);
			IGMNo_TB.clear();
			IGMNo_TB.sendKeys(filterValue);
			Thread.sleep(300);
			MawbNoOperatorIconDD.click();
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
		Thread.sleep(3000);
	}
	

}
