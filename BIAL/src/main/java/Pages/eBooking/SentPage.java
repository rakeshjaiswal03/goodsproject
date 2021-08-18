package Pages.eBooking;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.WebdriverMethods;

public class SentPage { 
	public WebDriver driver;
	public WebdriverMethods wm;
	boolean verify = false;
	
	public SentPage(WebDriver driver, WebdriverMethods wm) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wm = wm;
	}
	
	//sent screen
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Sent Jobs') and @class='PageHeader']")
	 public WebElement SentScreen;
	
	//sent job grid
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingSent']/tbody/tr/td[1]/a")
	 public List <WebElement> SentJobGirdFwdUrnList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingSent']/tbody/tr/td[2]")
	 public List <WebElement> SentJobGirdUrnList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingSent']/tbody/tr/td[3]")
	 public List <WebElement> SentJobGirdDateList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingSent']/tbody/tr/td[4]")
	 public List <WebElement> SentJobGirdServiceProviderList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingSent']/tbody/tr/td[5]")
	 public List <WebElement> SentJobGirdAwbNoList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingSent']/tbody/tr/td[6]")
	 public List <WebElement> SentJobGirdFlightNoList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingSent']/tbody/tr/td[7]")
	 public List <WebElement> SentJobGirdFlightDateList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingSent']/tbody/tr/td[8]")
	 public List <WebElement> SentJobGirdCarrierList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingSent']/tbody/tr/td[9]")
	 public List <WebElement> SentJobGirdOriginList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingSent']/tbody/tr/td[10]")
	 public List <WebElement> SentJobGirdDestinationList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingSent']/tbody/tr/td[11]")
	 public List <WebElement> SentJobGirdGrossWtList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingSent']/tbody/tr/td[13]")
	 public List <WebElement> SentJobGirdStatusList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingSent']/tbody/tr/td[14]/select")
	 public List <WebElement> SentJobGirdActionDropdownList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingSent']/tbody/tr/td[15]/a")
	 public List <WebElement> SentJobGirdReSendFfrLinkBtnList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdBookingSent']/tbody/tr/td[16]/a")
	 public List <WebElement> SentJobGirdCancelBookingLinkBtnList;
	
	
	
	public void SelectAction(String actionName, int rowNo) throws Throwable
	{
		wm.selectDropDownElementByVisibleText(driver, SentJobGirdActionDropdownList.get(rowNo-1), actionName);
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	
	
	
	
}
