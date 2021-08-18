package Pages.eAWB;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Methods.CommonMethods;
import Methods.WebdriverMethods;

public class HouseManifestPage {
	
	public WebDriver driver;
	public WebdriverMethods wm;
	public CommonMethods cm;
	public boolean verify;
	
	
	public HouseManifestPage(WebDriver driver, WebdriverMethods wm, CommonMethods cm) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wm = wm;
		this.cm = cm;
	}
	
//House Mainfest iFrame elements	
	@FindBy(how = How.XPATH , using = "//*[@id='IframHAWB']" )
	public WebElement HAWB_IFrame;
	
	@FindBy(how = How.XPATH , using = "//*[text()='House Manifest']/parent::div" )
	public WebElement HouseManifestWindow;
	
	@FindBy(how = How.XPATH , using = "//*[@id='tblHawbs']/tbody/tr[2]/td/input[1]" )
	public List <WebElement> HouseManifestDataFields;
	
	@FindBy(how = How.XPATH , using = "//*[@id='tblHawbs']/tbody/tr[2]/td[9]/select" )
	public WebElement DdChargeCode;
	
	@FindBy(how = How.XPATH , using = "//*[@id='ctl00_hldPageHeader_btnSave']" )
	public WebElement BtnSaveHAWB;
	
	@FindBy(how = How.XPATH , using = "//*[@id='ctl00_hldPageHeader_lblSuccess']" )
	public WebElement SaveSucessMsgHAWB_iFrame;
	
	@FindBy(how = How.XPATH , using = "//*[@id='houseManifest']/following-sibling::div[9]/button" )
	public WebElement BtnCloseHAWB_iFrame;
	@FindBy(how = How.XPATH , using = "//*[text()='House Manifest']/parent::div/a/span" )
	public WebElement BtnCloseHAWB_window;
	
	
	@FindBy(how = How.XPATH , using = "//a[@class='ui-dialog-titlebar-close ui-corner-all ui-state-hover']//span[@unselectable='on'][contains(text(),'Close X')]" )
	public WebElement popupclose;
	
	
	public void enterHouseManifestData(String Shipper, String Consignee, String Origin, String Destination, String NOP, String GrossWeight, String CargoDesc, int rowno) throws InterruptedException {
		HouseManifestDataFields.get(((rowno-1)*1)+1).sendKeys(cm.RandomNo(4));
		
		HouseManifestDataFields.get(((rowno-1)*1)+2).sendKeys(Shipper);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.SPACE).keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(3000);
		HouseManifestDataFields.get(((rowno-1)*1)+2).sendKeys("" + Keys.DOWN + Keys.ENTER);
		Thread.sleep(1000);
		
		HouseManifestDataFields.get(((rowno-1)*1)+3).sendKeys(Consignee);
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.SPACE).keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(3000);
		HouseManifestDataFields.get(((rowno-1)*1)+3).sendKeys("" + Keys.DOWN + Keys.ENTER);
		Thread.sleep(1000);
		
		HouseManifestDataFields.get(((rowno-1)*1)+4).sendKeys(Origin);
		HouseManifestDataFields.get(((rowno-1)*1)+5).sendKeys(Destination);
		HouseManifestDataFields.get(((rowno-1)*1)+6).sendKeys(NOP);
		HouseManifestDataFields.get(((rowno-1)*1)+7).sendKeys(GrossWeight);
		HouseManifestDataFields.get(((rowno-1)*1)+10).sendKeys(CargoDesc);
		
		Select selectChargeCode = new Select(DdChargeCode);
		selectChargeCode.selectByIndex(1);
	}
	
public void clickOnBtn(String elementname) {
		
 		if(elementname.equalsIgnoreCase("Hawb Save")) {
			BtnSaveHAWB.click();
		}
 		if(elementname.equalsIgnoreCase("Close iFrame")) {
			BtnCloseHAWB_iFrame.click();
		}
 		if(elementname.equalsIgnoreCase("Save")) {
			BtnSaveHAWB.click();
		}
 		if(elementname.equalsIgnoreCase("Close")) {
			BtnCloseHAWB_iFrame.click();
		}
 		
 		wm.ImplicitlyWait(driver, 5);
	}



	
	public void switchTo(String contextname) {
		if(contextname.equalsIgnoreCase("iFrame")) {
			driver.switchTo().frame(HAWB_IFrame);
		}
		if(contextname.equalsIgnoreCase("default")) {
			driver.switchTo().defaultContent(); System.out.println();
		}
		if(contextname.equalsIgnoreCase("parent")) {
			driver.switchTo().parentFrame(); System.out.println();
		}
			
	}
	
	
	

	//added by sandesh
	//house maiefest screen
	@FindBy(how = How.XPATH , using = "//b[text()='Create HAWB']" )
	 public WebElement HouseManifestScreen;
	
	//status popup
	@FindBy(how = How.XPATH , using = "//*[text()='Status']" )
	 public WebElement StatusPopup;
	
	@FindBy(how = How.ID , using = "ctl00_hldPageHeader_Label3" )
	 public WebElement StatusPopupMsg;
	
	@FindBy(how = How.ID , using = "ctl00_hldPageHeader_Button9" )
	 public WebElement StatusPopupOkBtn;
	
	
	//added by sandesh
	public void AddHawbDetails(String hawbNo, String Shipper, String Consignee, 
			String Origin, String Destination, String NOP, String GrossWeight, 
			String CargoDesc, String chargeCode, int rowno) throws Throwable {
		HouseManifestDataFields.get(((rowno-1)*11)).sendKeys(hawbNo);
		HouseManifestDataFields.get(((rowno-1)*11)+3).sendKeys(Origin, Keys.TAB);
		HouseManifestDataFields.get(((rowno-1)*11)+4).sendKeys(Destination, Keys.TAB);
		HouseManifestDataFields.get(((rowno-1)*11)+5).sendKeys(NOP);
		HouseManifestDataFields.get(((rowno-1)*11)+6).sendKeys(GrossWeight);
		HouseManifestDataFields.get(((rowno-1)*11)+7).sendKeys(CargoDesc);
		wm.selectDropDownElementByVisibleText(driver, DdChargeCode, chargeCode);
		
		HouseManifestDataFields.get(((rowno-1)*11)+1).sendKeys(Shipper); 	Thread.sleep(1500);
		wm.Action_SelectElement(driver);	Thread.sleep(1000);
		HouseManifestDataFields.get(((rowno-1)*11)+1).sendKeys(Keys.TAB);
		
		wm.VisibilityOfElementExplicityWait(driver, HouseManifestDataFields.get(((rowno-1)*11)+2), 10); wm.ImplicitlyWait(driver, 10);
		HouseManifestDataFields.get(((rowno-1)*11)+2).sendKeys(Consignee); Thread.sleep(1500);
		wm.Action_SelectElement(driver);	Thread.sleep(1000);
		HouseManifestDataFields.get(((rowno-1)*11)+2).sendKeys(Keys.TAB);
	
		wm.ImplicitlyWait(driver, 5);
	}
	
	public void AddHawbDetails1(String hawbNo, String Shipper, String Consignee, 
			String Origin, String Destination, String NOP, String GrossWeight, 
			String CargoDesc, String chargeCode, int rowno) throws Throwable {
		HouseManifestDataFields.get(((rowno-1)*11)).sendKeys(hawbNo);

		
		
   		HouseManifestDataFields.get(((rowno-1)*11)+1).sendKeys(Shipper); 	
		Thread.sleep(500); 
		HouseManifestDataFields.get(((rowno-1)*11)+1).sendKeys(Keys.ARROW_DOWN); 
		 Thread.sleep(500);
		HouseManifestDataFields.get(((rowno-1)*11)+1).sendKeys(Keys.ARROW_DOWN,Keys.ENTER, Keys.TAB);
		Thread.sleep(1000);

		
//		wm.VisibilityOfElementExplicityWait(driver, HouseManifestDataFields.get(((rowno-1)*11)+2), 10);
		
		HouseManifestDataFields.get(((rowno-1)*11)+2).sendKeys(Consignee);
		Thread.sleep(500);
		HouseManifestDataFields.get(((rowno-1)*11)+2).sendKeys(Keys.ARROW_DOWN); 
		Thread.sleep(500); 
		HouseManifestDataFields.get(((rowno-1)*11)+2).sendKeys(Keys.ARROW_DOWN,Keys.ENTER, Keys.TAB); 
		Thread.sleep(1500);
//		Actions select = new Actions(driver);
//		 select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
//         Thread.sleep(2000);
//         HouseManifestDataFields.get(((rowno-1)*11)+2).sendKeys(Keys.TAB);
		
		HouseManifestDataFields.get(((rowno-1)*11)+3).sendKeys(Origin, Keys.TAB);
		HouseManifestDataFields.get(((rowno-1)*11)+4).sendKeys(Destination, Keys.TAB);
		HouseManifestDataFields.get(((rowno-1)*11)+5).sendKeys(NOP);
		HouseManifestDataFields.get(((rowno-1)*11)+6).sendKeys(GrossWeight);
		HouseManifestDataFields.get(((rowno-1)*11)+7).sendKeys(CargoDesc);
		wm.selectDropDownElementByVisibleText(driver, DdChargeCode, chargeCode);

         
		wm.ImplicitlyWait(driver, 5);
	}
	
	public String AddHawbDetails(String Shipper, String Consignee, 
			String Origin, String Destination, String NOP, String GrossWeight, 
			String CargoDesc, String chargeCode, int rowno) throws Throwable {
		String hawbNo = null;
		
		hawbNo = cm.Random_hawbNo();
		HouseManifestDataFields.get(((rowno-1)*11)).sendKeys(hawbNo);
		
		HouseManifestDataFields.get(((rowno-1)*11)+1).sendKeys(Shipper);
		Thread.sleep(1500);
		wm.Action_SelectElement(driver);
		Thread.sleep(500);
		HouseManifestDataFields.get(((rowno-1)*11)+1).sendKeys(Keys.TAB);
		
		HouseManifestDataFields.get(((rowno-1)*11)+2).sendKeys(Consignee);
		Thread.sleep(1500);
		wm.Action_SelectElement(driver);
		Thread.sleep(500);
		HouseManifestDataFields.get(((rowno-1)*11)+2).sendKeys(Keys.TAB);
		
		HouseManifestDataFields.get(((rowno-1)*11)+3).sendKeys(Origin, Keys.TAB);
		HouseManifestDataFields.get(((rowno-1)*11)+4).sendKeys(Destination, Keys.TAB);
		HouseManifestDataFields.get(((rowno-1)*11)+5).sendKeys(NOP);
		HouseManifestDataFields.get(((rowno-1)*11)+6).sendKeys(GrossWeight);
		HouseManifestDataFields.get(((rowno-1)*11)+7).sendKeys(CargoDesc);
		
		wm.selectDropDownElementByVisibleText(driver, DdChargeCode, chargeCode);
		
		wm.ImplicitlyWait(driver, 5);
		
		return hawbNo;
	}
	
	public void ClickOnStatuPopupButton(String buttonName) throws Throwable{
		if (buttonName.equalsIgnoreCase("Ok"))
		{
			StatusPopupOkBtn.click();
		}
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}


	


	

}