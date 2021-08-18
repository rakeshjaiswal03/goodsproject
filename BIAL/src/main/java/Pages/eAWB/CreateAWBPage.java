package Pages.eAWB;

import java.awt.RenderingHints.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Methods.CommonMethods;
import Methods.WebdriverMethods;

public class CreateAWBPage {
	
	public WebDriver driver;
	public WebdriverMethods wm;
	public CommonMethods cm; 
	boolean verify = false;
	
	public CreateAWBPage(WebDriver driver, WebdriverMethods wm, CommonMethods cm) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wm = wm;
		this.cm = cm;
	}
	
	//Create MAWB screen
	@FindBy(how = How.XPATH, using = "//*[@class='lblheadingh5' and text()='Create AWB']")
	 public WebElement CreateAwbScreen;
	
//e-AWB 
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_rdoDirect']")
	public WebElement RbDirect;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_rdoConsol']")
	public WebElement RbConsol;
	
//House Manifest elements
	@FindBy(how = How.XPATH, using = "//*[@id='pnlAddHouse']")
	public WebElement HouseMessagePopup;
	
	@FindBy(how = How.XPATH, using = "//*[@id='pnlAddHouse']/table/tbody/tr/td/span")
	public WebElement HouseMessage;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_btnYes']")
	public WebElement BtnYesHouseMessage;
	
//Create e-Awb meassage popup
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_UpdatePanel19']")
	public WebElement CurrentBal_MsgBox;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_Button4']")
	public WebElement CurrentBal_BtnOk;
	
								
//	@FindBy(how = How.XPATH, using = "//span[@id='ctl00_hldPage_lblPDAMsg']") //span[@id='ctl00_hldPage_lblMAWBASIMsg']   //Added by Rakesh Jaiswal
//	public WebElement CurrentBal_MsgContent;
	@FindBy(how = How.XPATH, using = "//span[@id='ctl00_hldPage_lblMAWBASIMsg']")   //Added by Rakesh Jaiswal
	public WebElement CurrentBal_MsgContent;
	
//	@FindAll ({ 
//		@FindBy (xpath = "//span[@id='ctl00_hldPage_lblPDAMsg']"), 
//		@FindBy (xpath = "//span[@id='ctl00_hldPage_lblMAWBASIMsg']") 
//		}) public WebElement CurrentBal_MsgContent;
	
	@FindBy(how = How.XPATH, using = "//span[@id='ctl00_hldPage_lblPDAMsg']")  //Added by Rakesh Jaiswal
	public WebElement templatepopupMsgContent;
	
	@FindBy(how = How.XPATH, using = "//button[@id='btnPDOk']")  //Added by Rakesh Jaiswal
	public WebElement templatepopOKBtn;

//Create e-Awb page elements	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_txtAWBPrefix']")
	public WebElement TxtAwbPrefix;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_txtAWBNo']")
	public WebElement TxtAwbNo;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_txtOrgName1']")
	public WebElement TxtShipperName;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_txtSearchConsigneeName1']")
	public WebElement TxtConsigneeName;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_txtAgentSelect']")
	public WebElement TxtissuingAgentNameCity;
	
	//Routing Information/Departure Airport
	
	
	@FindAll ({ 
		@FindBy (xpath = "//img[@title='Routing Information']"), 
		@FindBy (id = "//a[@id='a2']//img[@id='imgairport']") 
		}) public WebElement BtnRoutingInfo;

	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_GenericAutoFillDestAirport_txtCode']")
	public WebElement TxtRoutingDetailsDestnPort;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_ViaRoute1_txtCode']")
	public WebElement TxtRoutingDetailsVia_1;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_ViaRoute2_txtCode']")
	public WebElement TxtRoutingDetailsVia_2;
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Routing Details')]")
	public WebElement RoutingDetailsWindow;
	
	@FindBy(how = How.XPATH, using = "//*[@id='divRouting']/parent::div/div[11]/button[1]")
	public WebElement BtnOkRoutingDetail;
	
//	@FindBy(how = How.XPATH, using = "//body[@style='background-color: #FFFFFF']/form[@id='aspnetForm']/div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-resizable']/div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/button[1]")
//	public WebElement BtnOkRoutingDetail;

	
	@FindBy(how = How.XPATH, using = "//iframe[@class='bgTransparantFrm']")
	public WebElement iframeBg;
	
	@FindBy(how = How.XPATH, using = "//*[@id='divRouting']/parent::div/div[11]/button[2]")
	public WebElement BtnCloseRoutingDetail;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_ddlChargeCode']")
	public WebElement DdChargeCode;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_txtflightno1']")
	public WebElement TxtFlightNo;
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_txtflightno2']")
	public WebElement TxtFlightNo2;
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_txtflightno3']")
	public WebElement TxtFlightNo3;
	
	//Select Custom Broker DD	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_divCB']")
	public WebElement DdCustomsBroker;
	
	//To select "ATL Bial" custom broker
	
	@FindBy(how = How.XPATH, using = "//div[@class='dropdown-button noselect']")
	public WebElement CustomsBroker;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_mltSlctCHA_1']")
	public WebElement CbCustomsBroker_01;

	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_mltSlctCHA_0']")
	public WebElement CbCustomsBroker_00;
	//Dimensions
	@FindBy(how = How.XPATH, using = "//*[@id='addDimensions_1']") 
	public WebElement BtnAddDimensions;
	@FindBy(how = How.XPATH, using = "//img[@id='addDimensions_2']") 
	public WebElement BtnAddDimensions2;
	
		
	@FindBy(how = How.XPATH, using = "//*[text()='Dimensions']")
	 public WebElement DimesionsWindow;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblDimensions']/tbody/tr/td/input[@type='text']")
	 public List <WebElement> DimensionTextboxList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblDimensions']/following::*[text()='Ok']")
	 public WebElement BtnOkDimensionWindow;

	@FindBy(how = How.XPATH, using = "//*[@id='tblDimensions']/parent::div/parent::div/div[11]/button[2]")
	 public WebElement BtnCancelDimensionWindow; 
	
	@FindAll ({ @FindBy (xpath = "//*[@id='txtCgGrWt_1']"), 
		@FindBy (xpath = "//input[@id='txtGrossWt']") }) 
	public WebElement TxtGrossWeight;

	
	@FindBy(how = How.XPATH, using = "//*[@id='txtCgGrWt_2']")
	 public WebElement TxtGrossWeight2; 
	
	@FindBy(how = How.XPATH, using = "//*[@id='selRateClass_1']")
	 public WebElement DdRateClass;
	
	@FindBy(how = How.XPATH, using = "//*[@id='selRateClass_2']")
	 public WebElement DdRateClass2;
	
	@FindBy(how = How.XPATH, using = "//*[@id='txtCgDesc_1']")
	 public WebElement TxtNatureOfGoods;
	
	@FindBy(how = How.XPATH, using = "//*[@id='txtCgDesc_2']")
	 public WebElement TxtNatureOfGoods2;

	@FindBy(how = How.ID, using = "ctl00_hldPage_btnSaveAwb")
	 public WebElement BtnSaveAwb;
	

	@FindBy(how = How.XPATH, using = "//img[@id='addrow_1']")
	 public WebElement dimensionPOPup_Action;
	
	
	
	@FindBy(how = How.XPATH, using = "//img[@id='addCargo_1']")
	 public WebElement dimension_Action;
//Save Message Box
	@FindBy(how = How.XPATH, using = "//*[@id='pnlmessage3']")
	public WebElement AWBSaveWindow;
		
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_UpdatePanel8']")
	public WebElement AWBSaveMessage;
		
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_btnCHANo']")
	public WebElement BtnOkAWBSaveWindow;
	
//Table in eAWB screen after added House Manifest 
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdHAWB']")
	public WebElement HAWBTable;
	
	
//	Due Carrier
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_dlsDueCarrier_ctl00_txtDueCarrierchargelist']")
	public WebElement DueCarrierBox1;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_dlsDueCarrier_ctl00_txtDueCarrierchargeAmount']")
	public WebElement DueCarrierBox2;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_dlsDueCarrier_ctl01_txtDueCarrierchargelist'] ")
	public WebElement DueCarrierBox3;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_dlsDueCarrier_ctl01_txtDueCarrierchargeAmount']")
	public WebElement DueCarrierBox4;
	
//	Rate/Charges 

	@FindBy(how = How.XPATH, using = "//input[@id='txtCgRate_1']")
	public WebElement Rate_Charges ;
	
	@FindBy(how = How.XPATH, using = "//input[@id='txtCgRate_2']")
	public WebElement Rate_Charges2 ;
	
	@FindBy(how = How.XPATH, using = "//input[@id='txtCgChargWt_1']")
	public WebElement chargebleWt ;
	
//  for console/HAWB:: popUp message:  Do you want to create House Air Waybill first? 
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnHouseNo']")
	public WebElement NoBtn ;
	
	@FindBy(how = How.XPATH, using = "//span[@id='ctl00_hldPage_Label33']")
	public WebElement popUpMs ;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnYes']")
	public WebElement YesBtn ;
	
	
	
	
	public void clickOnBtn(String elementname) throws Throwable {
		
 		if(elementname.equalsIgnoreCase("CurrentBal_OK")) {
			CurrentBal_BtnOk.click();
		}
		if(elementname.equalsIgnoreCase("Routing Info")) {
			 wm.ClickUsingJSExecutor(driver, BtnRoutingInfo);
		}
		if(elementname.equalsIgnoreCase("Routing Window Ok")) {
			BtnOkRoutingDetail.click();
		}
		if(elementname.equalsIgnoreCase("Routing Window Close")) {
			BtnRoutingInfo.click();
		}
		if(elementname.equalsIgnoreCase("Routing Window Close")) {
			BtnRoutingInfo.click();
		}
		if(elementname.equalsIgnoreCase("AWB Save Ok")) {
			BtnOkAWBSaveWindow.click();
		}
		if(elementname.equalsIgnoreCase("Add Dimensions")) {
			BtnAddDimensions.click();
		}
		if(elementname.equalsIgnoreCase("Add Dimensions2")) {
			BtnAddDimensions2.click();
		}
		
		if(elementname.equalsIgnoreCase("Dimensions Ok")) {
			BtnOkDimensionWindow.click();
		}
		if(elementname.equalsIgnoreCase("Save Awb")) {
			BtnSaveAwb.click();
		}
		if(elementname.equalsIgnoreCase("Rb Direct")) {
			RbDirect.click();
		}
		if(elementname.equalsIgnoreCase("Rb Consol")) {
			RbConsol.click();
		}
		if(elementname.equalsIgnoreCase("Yes House Message")) {
			BtnYesHouseMessage.click();
		}
		//added by sandesh
		if(elementname.equalsIgnoreCase("Save")) {
			wm.JavascriptExecutor_ElementScroll(driver, BtnSaveAwb);
			Thread.sleep(200);
			BtnSaveAwb.click();
		}
		if(elementname.equalsIgnoreCase("Consol")) {
			RbConsol.click();
		}
		
		wm.ImplicitlyWait(driver, 5);
		Thread.sleep(1000);
	}
	
	
	public void enter_eAWBData(String elementname, String value) throws Throwable {
		Thread.sleep(4000);
		if(elementname.equalsIgnoreCase("Awb Prefix")) {
			TxtAwbPrefix.clear();
			TxtAwbPrefix .sendKeys(value + Keys.TAB);
			Thread.sleep(2000);
		}
		if(elementname.equalsIgnoreCase("Awb No")) {
			TxtAwbNo.clear();
			TxtAwbNo.sendKeys(value);
		}
 		if(elementname.equalsIgnoreCase("Shipper Name")) {
			TxtShipperName.sendKeys(value);
			Thread.sleep(8000);
			Actions action = new Actions(driver);
			action.keyDown(Keys.CONTROL).sendKeys(Keys.SPACE).keyUp(Keys.CONTROL).build().perform();
			Thread.sleep(8000);
			TxtShipperName.sendKeys("" + Keys.DOWN + Keys.ENTER);
			Thread.sleep(1000);
		}
		if(elementname.equalsIgnoreCase("Consignee Name")) {
			TxtConsigneeName.sendKeys(value);
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			action.keyDown(Keys.CONTROL).sendKeys(Keys.SPACE).keyUp(Keys.CONTROL).build().perform();
			Thread.sleep(3000);
			TxtConsigneeName.sendKeys("" + Keys.DOWN + Keys.ENTER);
			Thread.sleep(1000);
		}
		if(elementname.equalsIgnoreCase("Issuing Agent")) {
			TxtissuingAgentNameCity.sendKeys(value);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.keyDown(Keys.CONTROL).sendKeys(Keys.SPACE).keyUp(Keys.CONTROL).build().perform();
			Thread.sleep(3000);
			TxtissuingAgentNameCity.sendKeys("" + Keys.DOWN + Keys.ENTER);
			Thread.sleep(1000);
		}
		if(elementname.equalsIgnoreCase("Destn Port")) {
			TxtRoutingDetailsDestnPort.sendKeys(value, Keys.TAB);
		}
		if(elementname.equalsIgnoreCase("Via_1")) {
			TxtRoutingDetailsVia_1.sendKeys(value+ Keys.TAB);
		}
		if(elementname.equalsIgnoreCase("Via_2")) {
			TxtRoutingDetailsVia_2.sendKeys(value  + Keys.TAB);
		}
		if(elementname.equalsIgnoreCase("carrierCode1")) {
			carrierCode1.sendKeys(value);
		}
		if(elementname.equalsIgnoreCase("Flight No")) {
			TxtFlightNo.sendKeys(value);
		}
		if(elementname.equalsIgnoreCase("Flight No2")) {
			TxtFlightNo2.sendKeys(value);
		}
		if(elementname.equalsIgnoreCase("Flight No3")) {
			TxtFlightNo3.sendKeys(value);
		}
		if(elementname.equalsIgnoreCase("Gross Weight")) {
			TxtGrossWeight.sendKeys(value);
		}
		if(elementname.equalsIgnoreCase("Gross Weight2")) {
			TxtGrossWeight2.sendKeys(value);
		}
		if(elementname.equalsIgnoreCase("Nature Of Goods")) {
			TxtNatureOfGoods.sendKeys(value);
		}
		if(elementname.equalsIgnoreCase("Nature Of Goods2")) {
			TxtNatureOfGoods2.sendKeys(value);
		}
		if(elementname.equalsIgnoreCase("Due Carrier box1")) {
			wm.VisibilityOfElementExplicityWait(driver, DueCarrierBox1, 10);
			DueCarrierBox1.sendKeys(value+ Keys.DOWN + Keys.ENTER);
		}
		if(elementname.equalsIgnoreCase("Due Carrier")) {
			wm.VisibilityOfElementExplicityWait(driver, DueCarrierBox1, 10);
			DueCarrierBox1.sendKeys(value+ Keys.TAB);
		}
		if(elementname.equalsIgnoreCase("Due Carrier box 2")) {
			wm.VisibilityOfElementExplicityWait(driver, DueCarrierBox2, 10); Thread.sleep(500);
			DueCarrierBox2.sendKeys(value + Keys.TAB);
		}
		if(elementname.equalsIgnoreCase("Rate charge")) {
			wm.VisibilityOfElementExplicityWait(driver, Rate_Charges, 10);
			Rate_Charges.sendKeys(value);
		}
		if(elementname.equalsIgnoreCase("Rate charge2")) {
			wm.VisibilityOfElementExplicityWait(driver, Rate_Charges2, 10);
			Rate_Charges2.sendKeys(value);
		}
		if(elementname.equalsIgnoreCase("Chargeable Wt")) 
			chargebleWt.sendKeys(value);
		if(elementname.equalsIgnoreCase("Charge Code")) 
		{
			wm.JavascriptExecutor_ElementScroll(driver, DdChargeCode);
			Thread.sleep(500);
			wm.selectDropDownElementByVisibleText(driver, DdChargeCode, value);
		}
		if(elementname.equalsIgnoreCase("Custom Broker")) 
		{
			wm.JavascriptExecutor_ElementScroll(driver, DdCustomsBroker);
			Thread.sleep(1000);
			wm.SelectFromCheckDropdownList(driver, DdCustomsBroker, CustomBrokerDropdownNameList, CustomBrokerDropdownCheckboxList, value);
		}
		if(elementname.equalsIgnoreCase("Destination Code")) {
			TxtRoutingDetailsDestnPort.sendKeys(value, Keys.TAB);
		}
	
		wm.ImplicitlyWait(driver, 5);
	}
	
	public void AddDimensions(String noOfPcs, String length, String width, String height, int rowNo) throws InterruptedException{
		DimensionTextboxList.get((rowNo-1)*9).sendKeys(noOfPcs);
		Thread.sleep(200);
		DimensionTextboxList.get(((rowNo-1)*9)+1).sendKeys(length);
		Thread.sleep(200);
		DimensionTextboxList.get(((rowNo-1)*9)+2).sendKeys(width);
		Thread.sleep(200);
		DimensionTextboxList.get(((rowNo-1)*9)+3).sendKeys(height);
		Thread.sleep(200);
		DimensionTextboxList.get(((rowNo-1)*9)+3).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		wm.ImplicitlyWait(driver, 10);
	}
	
	public void anAddDimensions(String noOfPcs, String length, String width, String height, int rowNo)
	{
		DimensionTextboxList.get((rowNo-1)*9).clear();
		DimensionTextboxList.get(((rowNo-1)*9)+1).clear();
		DimensionTextboxList.get(((rowNo-1)*9)+2).clear();
		DimensionTextboxList.get(((rowNo-1)*9)+3).clear();
		
		DimensionTextboxList.get((rowNo-1)*9).sendKeys(noOfPcs);
		DimensionTextboxList.get(((rowNo-1)*9)+1).sendKeys(length);
		DimensionTextboxList.get(((rowNo-1)*9)+2).sendKeys(width);
		DimensionTextboxList.get(((rowNo-1)*9)+3).sendKeys(height,Keys.TAB);
		
		wm.ImplicitlyWait(driver, 10);
	}
	
	public String EnterAwbNo() throws Throwable{
				String awbNo = null;
			  TxtAwbNo.clear();  Thread.sleep(300);
			  awbNo =  cm.Random_awbNo();
			  TxtAwbNo.sendKeys(awbNo, Keys.TAB); Thread.sleep(500);
		  System.out.println("entered AWB no:"+awbNo);
		  return awbNo;
	}
	
	public String EnterAwbno() throws Throwable
	{
		String awbNo = null, textFieldAwbNo = null;
		textFieldAwbNo = TxtAwbNo.getAttribute("value");
		if (textFieldAwbNo.equals("") || textFieldAwbNo.isEmpty())
		{
			awbNo = cm.Random_awbNo();
			TxtAwbNo.sendKeys(awbNo, Keys.TAB);
		}
		else
		{
			verify =  wm.isElementPresent(driver, captureErrorMsg);
			if (verify == true)
			{
				TxtAwbNo.clear();
				awbNo = cm.Random_awbNo();
				TxtAwbNo.sendKeys(awbNo, Keys.TAB);
			}
			else
			{
				awbNo = textFieldAwbNo;
			}
			
		}
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
		
		return awbNo;
	}
	
//	added by Rakesh Jaiswal

	public double currentBal_inCargobyBLR_Account() {
		String content = CurrentBal_MsgContent.getText(); System.out.println("content:"+content);
	      String[] msg =  content.split(" "); System.out.println("msg:"+msg);
	       String balAmt =  msg[msg.length-1].toString().replaceAll(",", ""); 
	       System.out.println("Amount bal in string format"+balAmt);
//	      int  i=Integer.parseInt(balAmt);  
	      double d=Double.parseDouble(balAmt);  
	      System.out.println("Current Balance in your CargobyBLR portal Account is "+d);
		return d;
	}
	

	@FindBy(how = How.XPATH, using = "//select[@id='ctl00_hldPage_drpCopyFrom']")
	public WebElement 	CreateAWB_asfrom;
	
	
	@FindBy(how = How.XPATH, using = "//table[@id='ctl00_hldPage_grdMAWB']/tbody[1]/tr/td[2]/span")
	public List<WebElement> MAWBNoList;
	
	
	@FindBy(how = How.XPATH, using = "//table[@id='ctl00_hldPage_grdMAWB']/tbody[1]/tr/td[1]/input")
	public List<WebElement> selectListBtn;
	
	@FindBy(how = How.XPATH, using =
			"//body[@style='background-color: #FFFFFF']/form[@id='aspnetForm']/div[13]/div[11]/button[1]")
	public WebElement OKBtn;
	
	
	@FindAll ({ 
		@FindBy (xpath = "//*[@id='aspnetForm']/div[13]/div[11]/button"),
		@FindBy (xpath = "//button[@id='btnPDOk']")
	}) public WebElement OKBtn1;

	
	@FindBy(how = How.XPATH, using = "//*[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']//*[contains(text(),'Template')]")
	public WebElement template_header;
	
	@FindBy(how = How.XPATH, using = "//*[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']//*[contains(text(),'Template')]//parent::div//a")
	public WebElement templateCloseBtn;
	
	@FindBy(how = How.XPATH, using = "//span[@id='ui-dialog-title-divAWBList']")
	public WebElement AWBBilList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='IframAWBList']")
	public WebElement AwbListiframe;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='IframTemplate']")
	public WebElement IframTemplate;
	
	//input[@id='ctl00_hldPage_grdMAWB_ctl02_rdbSelect']
	@FindBy(how = How.XPATH, using ="//input[@id='ctl00_hldPage_grdMAWB_ctl02_rdbSelect']")
	public WebElement selectRadio1;
	
	@FindBy(how = How.XPATH, using = "	//a[@id='ctl00_hldPage_grdMAWB_ctl13_BtnNext']")
	public WebElement nextPageBtn;
	
	
	public void selectMAWBNo(String MAWBNo) {
		
		for (int i=0;i<MAWBNoList.size(); i++) {
			System.out.println("text: "+MAWBNoList.get(i).getAttribute("text"));
			System.out.println("value: "+MAWBNoList.get(i).getAttribute("value"));
			 
			if(wm.isElementAttributeValueContain(driver, MAWBNoList.get(i), "text" , MAWBNo)==true ||
		    	wm.isElementAttributeValueContain(driver, MAWBNoList.get(i), "value" , MAWBNo)==true) {
				wm.ClickUsingJSExecutor(driver, selectListBtn.get(i));
			}
		}
	}
	
	
//	Template Popupbox Radiobutton
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_GrdAWBDraft_ctl02_rdbSelect']")
	
	public WebElement selectRadioBtn;
	
	

	@FindBy(how = How.XPATH, using = "//span[@id='ctl00_hldPage_lblnotify']")
	public WebElement captureErrorMsg;
	
	
//	fields for Message:  Shipper and consignee should be from different country 
	
	@FindBy(how = How.XPATH, using = "//div[@id='divMstAlert']//div[@class='modal-dialog popup-center']")
	public WebElement popUpMsg;
	
	@FindBy(how = How.XPATH, using = "//span[@id='ctl00_lblMstAlert']")
	public WebElement sameCountryPopUpMsg;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Ok')]")
	public WebElement popUpOKBtn;
	
	
//	added by Rakesh Jaiswal
	
//	 Issuing Carrier's Agent Name and City 
	//added by sandesh
	public void SelectValue(String fieldName, String selectValue) throws Throwable
	{ Thread.sleep(5000);
		if(fieldName.equalsIgnoreCase("Charge Code")) 
		{
			wm.JavascriptExecutor_ElementScroll(driver, DdChargeCode);
			Thread.sleep(500);
			wm.selectDropDownElementByVisibleText(driver, DdChargeCode, selectValue);
		}
		
		if(fieldName.equalsIgnoreCase("Custom Broker")) 
		{
			wm.JavascriptExecutor_ElementScroll(driver, DdCustomsBroker);
			Thread.sleep(1000);
			wm.SelectFromCheckDropdownList(driver, DdCustomsBroker, CustomBrokerDropdownNameList, CustomBrokerDropdownCheckboxList, selectValue);
		}
		
		wm.ImplicitlyWait(driver, 5);
	}
	
	//added by sandesh
	//rate line fields
	@FindBy(how = How.XPATH, using = "//*[@id='tblCargo']/tbody/tr")
	 public List<WebElement> CargoDetailsRowList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblCargo']/tbody/tr/td[@align='center']/img")
	 public List<WebElement> CargoDetailsIconList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblCargo']/tbody/tr/td[@align='center' or @align='left' or @class='table_mid' ]/input[@type='text']")
	 public List<WebElement> CargoDetailsTextboxList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblCargo']/tbody/tr/td[@align='center' or @align='left' or @class='table_mid' ]/select")
	 public List<WebElement> CargoDetailsDropdownList;
	
	//custome broker checkbox dropdown 
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_divCB']/div[2]/input")
	public WebElement CustomBrokerDropdownFilterField_TB;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_mltSlctCHA']/tbody/tr/td/input[@type='checkbox']")
	 public List<WebElement> CustomBrokerDropdownCheckboxList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_mltSlctCHA']/tbody/tr/td/label")
	 public List<WebElement> CustomBrokerDropdownNameList;
	
//	//routing info popup fields
//	@FindBy(how = How.ID, using = "ctl00_hldPage_GenericAutoFillOriginAirport_txtCode")
//	 public WebElement OriginCode_DD;
//	
//	@FindBy(how = How.ID, using = "ctl00_hldPage_GenericAutoFillOriginAirport_txtCode")
//	 public WebElement OriginName_DD;
//	
//	@FindBy(how = How.ID, using = "ctl00_hldPage_GenericAutoFillOriginAirport_txtCode")
//	 public WebElement DestinationCode_DD;
//	
//	@FindBy(how = How.ID, using = "ctl00_hldPage_GenericAutoFillOriginAirport_txtCode")
//	 public WebElement DestinationName_DD;
//	
//	@FindBy(how = How.ID, using = "ctl00_hldPage_GenericAutoFillOriginAirport_txtCode")
//	 public WebElement Via1Code_DD;
//	
//	@FindBy(how = How.ID, using = "ctl00_hldPage_GenericAutoFillOriginAirport_txtCode")
//	 public WebElement Via1Name_DD;
//	
//	@FindBy(how = How.ID, using = "ctl00_hldPage_GenericAutoFillOriginAirport_txtCode")
//	 public WebElement Via2Code_DD;
//	
//	@FindBy(how = How.ID, using = "ctl00_hldPage_GenericAutoFillOriginAirport_txtCode")
//	 public WebElement ViaName_DD;
	
	//due carrier
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_dlsDueCarrier']/tbody/tr/td/table/tbody/tr/td/input")
	 public List<WebElement> DueCarrierTextboxList;
	
	//rate as agreed
	@FindBy(how = How.ID, using = "ctl00_hldPage_Chkisaggreed")
	 public WebElement RateAsAgreed_CB;
	
	public void SelectCheckbox(String checboxName) throws Throwable
	{
		if (checboxName.equalsIgnoreCase("Rates as agreed"))
			RateAsAgreed_CB.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnMessagePopupButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Ok"))
		{ 
			CurrentBal_BtnOk.click();
		}
		wm.ImplicitlyWait(driver, 10);Thread.sleep(500);
	}
	
	public void ClickOnCargoDetailsIcon(String iconName, int rowNo) throws Throwable
	{
		wm.JavascriptExecutor_ElementScroll(driver, CargoDetailsIconList.get((rowNo-1)*2));
		Thread.sleep(500);
		if(iconName.equalsIgnoreCase("Dimensions"))
		{
			if (rowNo < 3)
			{
				CargoDetailsIconList.get((rowNo-1)*2).click();
			}
			else
			{
				CargoDetailsIconList.get(((rowNo-1)*3)-1).click();
			}
		}
		if(iconName.equalsIgnoreCase("Plus"))
		{
			if (rowNo < 3)
			{
				CargoDetailsIconList.get(((rowNo-1)*2)+1).click();
			}
			else
			{
				CargoDetailsIconList.get((((rowNo-1)*3)+1)-1).click();
			}
		}
		if(iconName.equalsIgnoreCase("Minus"))
		{
			if (rowNo > 1)
			{
				CargoDetailsIconList.get(((rowNo-1)*3)+2).click();
			}
		}
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	
	public void AddRateLineDetailsForJob(String rateClass, int rowNo) throws Throwable
	{
		wm.JavascriptExecutor_ElementScroll(driver, CargoDetailsIconList.get((rowNo-1)*2));
		Thread.sleep(500);
		CargoDetailsTextboxList.get(((rowNo-1)*8)+1).sendKeys(Keys.ENTER, Keys.TAB);
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(500);
		
		wm.selectDropDownElementByVisibleText(driver, CargoDetailsDropdownList.get(((rowNo-1)*3)+1), rateClass);
		wm.ImplicitlyWait(driver, 5);
	}
	
	public void AddRateLineDetails(String grWt, String rateClass, String rate, String natureOfGoods, int rowNo) throws Throwable
	{
		wm.JavascriptExecutor_ElementScroll(driver, CargoDetailsIconList.get((rowNo-1)*2));
		Thread.sleep(500);
		CargoDetailsTextboxList.get(((rowNo-1)*8)+1).sendKeys(grWt, Keys.TAB);
		Thread.sleep(500);
		
		wm.selectDropDownElementByVisibleText(driver, CargoDetailsDropdownList.get(((rowNo-1)*3)+1), rateClass);
		Thread.sleep(2000);
		
//		CargoDetailsTextboxList.get(((rowNo-1)*8)+4).sendKeys(rate);
//		Thread.sleep(500);
        enter_eAWBData("Rate charge", rate);
        Thread.sleep(1000);
		
		
//		CargoDetailsTextboxList.get(((rowNo-1)*8)+6).sendKeys(natureOfGoods);
//		Thread.sleep(500);df
        
		 enter_eAWBData("Nature Of Goods", natureOfGoods);
	     Thread.sleep(1000);
		
		wm.ImplicitlyWait(driver, 5);
	}
	public void AddRatelineDetails(String grWt, String rateClass, String rate, String natureOfGoods, int rowNo) throws Throwable
	{
		wm.JavascriptExecutor_ElementScroll(driver, CargoDetailsIconList.get((rowNo-1)*2));
		Thread.sleep(500);
		CargoDetailsTextboxList.get(((rowNo-1)*8)+1).sendKeys(grWt, Keys.TAB);
		Thread.sleep(500);
		wm.selectDropDownElementByVisibleText(driver, CargoDetailsDropdownList.get(((rowNo-1)*3)+1), rateClass);
		Thread.sleep(4000);
		CargoDetailsTextboxList.get(((rowNo-1)*8)+4).sendKeys(rate);
		Thread.sleep(500);
//        enter_eAWBData("Rate charge", rate);
//        Thread.sleep(1000);
		CargoDetailsTextboxList.get(((rowNo-1)*8)+6).sendKeys(natureOfGoods);
		Thread.sleep(500);
//		 enter_eAWBData("Nature Of Goods", natureOfGoods);
//	     Thread.sleep(1000);
		wm.ImplicitlyWait(driver, 5);
	}
	
	public void AddRateLineDetails(String rateClass, String rate, int rowNo) throws Throwable
	{
		wm.JavascriptExecutor_ElementScroll(driver, CargoDetailsIconList.get((rowNo-1)*2));
		Thread.sleep(500);
		
		wm.selectDropDownElementByVisibleText(driver, CargoDetailsDropdownList.get(((rowNo-1)*3)+1), rateClass);
		Thread.sleep(500);
		
//		CargoDetailsTextboxList.get(((rowNo-1)*8)+4).sendKeys(rate);
//		Thread.sleep(500);		
		
		wm.ImplicitlyWait(driver, 5);
	}
	
	public void AddRateLineDetails(String grWt, String rateClass, String natureOfGoods, int rowNo) throws Throwable
	{
		wm.JavascriptExecutor_ElementScroll(driver, CargoDetailsIconList.get((rowNo-1)*2));
		Thread.sleep(500);
		CargoDetailsTextboxList.get(((rowNo-1)*8)+1).sendKeys(grWt, Keys.TAB);
		Thread.sleep(500);
		
		wm.selectDropDownElementByVisibleText(driver, CargoDetailsDropdownList.get(((rowNo-1)*3)+1), rateClass);
		Thread.sleep(500);
		
		CargoDetailsTextboxList.get(((rowNo-1)*8)+6).sendKeys(natureOfGoods);
		Thread.sleep(500);
		
		wm.ImplicitlyWait(driver, 5);
	}
	
	public void ClickOnSaveMessagePopupButton(String buttonName) throws Throwable
	{	Thread.sleep(2000);
		wm.VisibilityOfElementExplicityWait(driver, BtnOkAWBSaveWindow, 20);
		if (buttonName.equalsIgnoreCase("Ok")) {
			Thread.sleep(1000);
			BtnOkAWBSaveWindow.click();
		}
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnRoutingInfoButton(String buttonName) throws Throwable
	{
		
		if (buttonName.equalsIgnoreCase("Ok"))
			BtnOkRoutingDetail.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnDimensionsButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Ok"))
			BtnOkDimensionWindow.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void AddDueCarrier(String dueCarrierCode, String dueCarrierAmount, int rowNo) throws Throwable
	{
		DueCarrierTextboxList.get((rowNo-1)*2).sendKeys(dueCarrierCode);
		Thread.sleep(500);
		wm.Action_SelectElement(driver);
		Thread.sleep(500);
		DueCarrierTextboxList.get((rowNo-1)*2).sendKeys(Keys.TAB);
		
		DueCarrierTextboxList.get(((rowNo-1)*2)+1).sendKeys(dueCarrierAmount, Keys.TAB);
		Thread.sleep(500);
		
		wm.ImplicitlyWait(driver, 5);
	}
	
	public void ClickOnConsolPopupButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Yes"))
			BtnYesHouseMessage.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	
	
	
//	----AddHouseManifest pop elements and methods

	@FindBy (how = How.XPATH, using = "//table[@id='tblHawbs']/tbody[1]/tr[2]/td[1]/input[1]")
	public List<WebElement> HAWB_No;
	
	@FindBy (how = How.XPATH, using = "//table[@id='tblHawbs']/tbody[1]/tr/td[2]/input[1]")
	public List<WebElement> shipper;
	
	@FindBy (how = How.XPATH, using = "//table[@id='tblHawbs']/tbody[1]/tr/td[3]/input[1]")
	public List<WebElement> cosignee;
	@FindBy (how = How.XPATH, using = "//table[@id='tblHawbs']/tbody[1]/tr/td[4]/input[1]")
	public List<WebElement> origin;
	@FindBy (how = How.XPATH, using = "//table[@id='tblHawbs']/tbody[1]/tr/td[5]/input[1]")
	public List<WebElement> dest;
	
	@FindBy (how = How.XPATH, using = "//table[@id='tblHawbs']/tbody[1]/tr/td[6]/input[1]")
	public List<WebElement> nop;
	@FindBy (how = How.XPATH, using = "//table[@id='tblHawbs']/tbody[1]/tr/td[7]/input[1]")
	public List<WebElement> grossWt;
	
	@FindBy (how = How.XPATH, using = "//table[@id='tblHawbs']/tbody[1]/tr/td[10]/input[1]")
	public List<WebElement> cargoDesciption;
	
	@FindBy (how = How.XPATH, using = "//select[@id='ctl00_hldPageHeader_rptHouse_ctl01_ddlCurrencyCode']")
	public WebElement currencyDropDown;
	
	@FindBy (how = How.XPATH, using = "//select[@id='ctl00_hldPageHeader_rptHouse_ctl01_ddlChargeCode']")
	public WebElement ChargeCodeDropDown;
	
	

	public void AddHouseManifest( String Shipper, String Consignee, String Origin, String Destination, String NOP, 
			String GrossWeight,String currency, String ChargeCode, String CargoDesc, int rowno) throws Throwable {
		
		
		System.out.println("HAWB_No.size(): "+HAWB_No.size());
		HAWB_No.get(rowno-1).sendKeys(cm.Random_hawbNo());

		try{
			shipper.get(rowno-1).sendKeys(Shipper);
			System.out.println(Shipper + " enterred");
			Thread.sleep(1500);
			Actions select = new Actions(driver);
	        select.sendKeys(Keys.chord(Keys.CONTROL,Keys.SPACE)).build().perform();
	        Thread.sleep(500);
	        select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
	        Thread.sleep(500);
	        shipper.get(rowno-1).sendKeys(Keys.TAB);
			
			} catch(UnhandledAlertException e){
			  Alert alert = driver.switchTo().alert();
			  alert.accept();
			  shipper.get(rowno-1).sendKeys(Shipper);
			  System.out.println( Shipper+ "expection handled ");
			}
				
		Thread.sleep(1000);

		try{
			cosignee.get(rowno-1).sendKeys(Consignee);
			System.out.println(Consignee +"  entered");
			Thread.sleep(1500);
			Actions select = new Actions(driver);
	        select.sendKeys(Keys.chord(Keys.CONTROL,Keys.SPACE)).build().perform();
	        Thread.sleep(500);
	        select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
	        Thread.sleep(500);
	        cosignee.get(rowno-1).sendKeys(Keys.TAB);
		
		
		} catch(UnhandledAlertException e){
			  Alert alert = driver.switchTo().alert();
			  alert.accept();
			  System.out.println(Consignee+ "expection handled ");
			 
			}
		
		Thread.sleep(1000);
		try {
			origin.get(rowno-1).sendKeys(Origin,Keys.TAB);
			System.out.println(Origin+"  entered ");
//			Thread.sleep(1500);
//			Actions select = new Actions(driver);
//	        select.sendKeys(Origin).build().perform();
//	        Thread.sleep(500);
//	        select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
//	        Thread.sleep(500);
//	        System.out.println(driver.getWindowHandle());
//	        
//	        System.out.println(wm.isAlertPresent());
//	        	Alert alert = driver.switchTo().alert();
//	        	Thread.sleep(1000);
//	        	alert.accept();
//	        	System.out.println(driver.getWindowHandle());
//	        	System.out.println(Origin+ "expection handled ");
		
			
		}catch(UnhandledAlertException e) {
			Alert alert = driver.switchTo().alert();
			Thread.sleep(1000);
			  alert.accept();
			  driver.getWindowHandle();
			  System.out.println(Consignee+ "expection handled ");
		}
		
        
		try{	
			System.out.println(wm.isAlertPresent());
			dest.get(rowno-1).sendKeys(Destination, Keys.TAB);
			System.out.println(Destination+"  entered ");
//			Thread.sleep(1500);
//			Actions select = new Actions(driver);
//	        select.sendKeys(Destination).build().perform();
//	        Thread.sleep(500);
//	        select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
//	        Thread.sleep(500);
//	        
//	        System.out.println(wm.isAlertPresent());
//	        Alert alert = driver.switchTo().alert();
//			Thread.sleep(1000);
//			  alert.accept();
//			  driver.getWindowHandle();
//			  System.out.println("11"+Destination+ " expection handled ");
			
			
			} catch(NoAlertPresentException e){
			  Alert alert = driver.switchTo().alert();
			  alert.accept();
			 
			}
		
		  Thread.sleep(2000);
				System.out.println("*******"+wm.isAlertPresent());
				  Thread.sleep(2000);
				if(wm.isAlertPresent()) {
					Alert alert = driver.switchTo().alert();
		        	Thread.sleep(1000);
				  alert.accept();
				  driver.getWindowHandle();
				  System.out.println( "doouble  expection handled ");
				}
	        	
			  
		nop.get(rowno-1).sendKeys(NOP);
		grossWt.get(rowno-1).sendKeys(GrossWeight);
		
		  Thread.sleep(2000);
		  wm.selectDropDownElementByVisibleText(driver, currencyDropDown,currency );
		  Thread.sleep(2000);
		  wm.selectDropDownElementByVisibleText(driver, ChargeCodeDropDown,ChargeCode );
		
		  	try{
		  		System.out.println(wm.isAlertPresent());
		  		cargoDesciption.get(rowno-1).sendKeys(CargoDesc);
				} catch(UnhandledAlertException e){
				  Alert alert = driver.switchTo().alert();
				  alert.accept();
				  System.out.println(CargoDesc +" exception handled ");
				  
				  System.out.println(wm.isAlertPresent());

				}
		 
		
	}
	
	
	
	@FindBy (how = How.XPATH, using = "//body[@style='background-color: #FFFFFF']/form[@id='aspnetForm']/div[13]/div[1]/a[1]/span[1]")
	public WebElement closeX;
	
	
	@FindBy (how = How.XPATH, using = "//body[@style='background-color: #FFFFFF']/form[@id='aspnetForm']/div[13]/div[11]/button[1]")
	public WebElement close;
	
	
//	WebElement of  Issuing Carrier's Agent Name and City 
	//input[@id='ctl00_hldPage_txtAgentname']
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_txtAgentname']")
	public WebElement Agentname;
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_txtAgentcity']")
	public WebElement Agentcity;
	
	
//	
	@FindBy (how = How.XPATH, using = "//input[@id='awbtemplate']")
	public WebElement saveAsTemplateBtn;
	
	//div[@id='divTemplatePanel']
	@FindBy (how = How.XPATH, using = "//div[@id='divTemplatePanel']")
	public WebElement templatePopup;
	
	@FindBy (how = How.XPATH, using = "//body[@style='background-color: #FFFFFF']/form[@id='aspnetForm']/div[13]/div[11]/button[1]")
	public WebElement templatePopUp_OKBtn;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_TxtTemplateName']")
	public WebElement templatenametextbox;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnSaveTemplate']")
	public WebElement templateBoxSaveBtn;
	
	@FindBy (how = How.XPATH, using = "//input[@id='btnCancelSaveTemplate']")
	public WebElement templateBoxCancelBtn;
	
	
	@FindBy (how = How.XPATH, using = "//span[@id='ctl00_hldPage_Label28']")
	public WebElement templateSavedSuccesPopupMsg;
	
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnClose4']")
	public WebElement templateSavedSuccesPopupMsg_OK;
	
	
	
//	Branch hover and click
	
	@FindBy(how = How.XPATH, using = "//li[@id='ctl00_liBranch']//ul[@class='sub_menu']//li//a")
	 public List <WebElement> branchLsit;
	
	
	@FindBy(how = How.XPATH, using = "//li[@id='ctl00_liBranch']//a[@href='#']")
	 public WebElement branch;
	
	public void BranchHover(String label) throws Throwable
	{
		if (label.equalsIgnoreCase("ACS Forwarder"))
			wm.Action_MoveOverElement(driver, branchLsit.get(0));
		if (label.equalsIgnoreCase("ATL FF Branch 2"))
			wm.Action_MoveOverElement(driver, branchLsit.get(1));
		if (label.equalsIgnoreCase(""))
			wm.Action_MoveOverElement(driver, branchLsit.get(2));
		if (label.equalsIgnoreCase(""))
			wm.Action_MoveOverElement(driver, branchLsit.get(3));
		if (label.equalsIgnoreCase(""))
			wm.Action_MoveOverElement(driver, branchLsit.get(4));
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(500);
	}
	
	public void ClickOnSubMenu(String label) throws Throwable
	{
		
		if (label.equalsIgnoreCase("ACS Forwarder"))
			branchLsit.get(0).click();
		if (label.equalsIgnoreCase("ATL FF Branch 2"))
			branchLsit.get(1).click();
		if (label.equalsIgnoreCase(""))
			branchLsit.get(2).click();
	}
	

// 2nd Flight Details: 
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_txtCarrier1']")
	 public WebElement carrierCode1; 
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_txtCarrier2']")
	 public WebElement carrierCode2;
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_txtCarrier3']")
	 public WebElement carrierCode3;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_txtflightdate2']")
	 public WebElement FlightDate2;
	
	
// 2nd Handling Information(Opt)
	@FindBy(how = How.XPATH, using = "	//textarea[@id='ctl00_hldPage_txtosi']")
	 public WebElement textarea2;
	
	
//	Checkbox RatesAsAgreed
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_Chkisaggreed']")
	 public WebElement Checkbox_RatesAsAgreed;
	
	
//	Prepaid chargeElement
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_txtPChargeTotal']")
	 public WebElement  TotalPrepaid ;
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='txtCgTotal_1']")
	 public WebElement  Total;
	
	
//	Due agent 
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_dlsDueAgent_ctl00_txtDueAgentchargeAmount']")
	 public WebElement  DueAgent  ;
	
	
	
	
	
	
	
	
	//house manifest popup
	@FindBy(how = How.XPATH , using = "//*[@id='houseManifest']" )
	public WebElement HouseManifestPopup;
	
	@FindBy(how = How.ID , using = "IframHAWB" )
	public WebElement HouseManifestPopupFrame;
	
	@FindBy(how = How.XPATH , using = "//*[@id='tblHawbs']/tbody/tr/td/input[@type='text']" )
	public List <WebElement> HouseManifestPopupTextboxList;
	
	@FindBy(how = How.XPATH , using = "//*[@id='tblHawbs']/tbody/tr/td/select" )
	public List <WebElement> HouseManifestPopupDropdownList;
	
	@FindBy(how = How.XPATH , using = "//*[@id='tblHawbs']/tbody/tr/td/*[@tabindex='0' or @type='image']" )
	public List <WebElement> HouseManifestPopupIconList;
	
	@FindBy(how = How.XPATH , using = "//*[@text='Add Row']" )
	public WebElement HouserManifestPopupAddRowIcon;
	
	
	@FindBy(how = How.ID , using = "ctl00_hldPageHeader_btnSave" )
	public WebElement HouseManifestPopupSaveBtn;
	
	@FindBy(how = How.XPATH , using = "//*[@value='Clear All']" )
	public WebElement HouseManifestPopupClearAllBtn;
	
	@FindBy(how = How.XPATH , using = "//*[@id='ctl00_hldPageHeader_lblSuccess']" )
	public WebElement SaveSucessMsgHAWB_iFrame;
	
	@FindBy(how = How.XPATH , using = "//*[@id='aspnetForm']/div[13]/div[11]/button" )
	public WebElement HouseManifestPopupCloseBtn;
	
	//hawb deletation  
	@FindBy(how = How.XPATH , using = "//*[text()='HAWB Deletion']" )
	 public WebElement HAWB_DeletionPopup;
	
	@FindBy(how = How.XPATH , using = "//*[@cssclass='Common-lbl']" )
	 public WebElement HAWB_DeletionPopupMsg;
	
	@FindBy(how = How.XPATH , using = "//*[text()='No']" )
	 public WebElement HAWB_DeletionPopupNoBtn;
	
	@FindBy(how = How.XPATH , using = "//*[text()='Yes']" )
	 public WebElement HAWB_DeletionPopupYesBtn;
	
	//hawb message popup
	@FindBy(how = How.XPATH , using = "//*[@id='divSuccessAlert']//h5[@id='hdrMstAlert']" )
	 public WebElement HAWB_MessagePopup;
	
	@FindBy(how = How.ID , using = "ctl00_hldPageHeader_lblMstSuccess" )
	 public WebElement HAWB_MessagePopupMsg;
	
	@FindBy(how = How.XPATH , using = "//*[@id='Button2']" )
	 public WebElement HAWB_MessagePopupOkBtn;
	
	
	
	public void AddHawbDetails(String hawbNo, String Shipper, String Consignee, 
			String Origin, String Destination, String NOP, String GrossWeight, 
			String CargoDesc, String chargeCode, int rowno) throws Throwable {
		HouseManifestPopupTextboxList.get(((rowno-1)*8)).sendKeys(hawbNo);
		
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+1).sendKeys(Shipper);
		Thread.sleep(1500);
		wm.Action_SelectElement(driver);
		Thread.sleep(500);
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+1).sendKeys(Keys.TAB);
		
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+2).sendKeys(Consignee);
		Thread.sleep(1500);
		wm.Action_SelectElement(driver);
		Thread.sleep(500);
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+2).sendKeys(Keys.TAB);
		
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+3).sendKeys(Origin, Keys.TAB);
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+4).sendKeys(Destination, Keys.TAB);
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+5).sendKeys(NOP);
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+6).sendKeys(GrossWeight);
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+7).sendKeys(CargoDesc);
		
		wm.selectDropDownElementByVisibleText(driver, HouseManifestPopupDropdownList.get(((rowno-1)*2)+1), chargeCode);
		
		wm.ImplicitlyWait(driver, 5);
	}
	
	public String AddHawbDetails(String Shipper, String Consignee, 
			String Origin, String Destination, String NOP, String GrossWeight, 
			String CargoDesc, String chargeCode, int rowno) throws Throwable {
		String hawbNo = null;
		
		hawbNo = cm.Random_hawbNo();
		HouseManifestPopupTextboxList.get(((rowno-1)*8)).sendKeys(hawbNo);
		
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+1).sendKeys(Shipper);
		Thread.sleep(1500);
		wm.Action_SelectElement(driver);
		Thread.sleep(500);
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+1).sendKeys(Keys.TAB);
		
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+2).sendKeys(Consignee);
		Thread.sleep(1500);
		wm.Action_SelectElement(driver);
		Thread.sleep(500);
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+2).sendKeys(Keys.TAB);
		
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+3).sendKeys(Origin, Keys.TAB);
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+4).sendKeys(Destination, Keys.TAB);
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+5).sendKeys(NOP);
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+6).sendKeys(GrossWeight);
		HouseManifestPopupTextboxList.get(((rowno-1)*8)+7).sendKeys(CargoDesc);
		
		wm.selectDropDownElementByVisibleText(driver, HouseManifestPopupDropdownList.get(((rowno-1)*2)+1), chargeCode);
		
		wm.ImplicitlyWait(driver, 5);
		
		return hawbNo;
	}
	
	public void ClickOnHouserManifestPopupIcon(String iconName, int rowNo) throws Throwable
	{
		if (iconName.equalsIgnoreCase("Add Shipper"))
			HouseManifestPopupIconList.get((rowNo-1)*6).click();
		if (iconName.equalsIgnoreCase("Add Consignee"))
			HouseManifestPopupIconList.get(((rowNo-1)*6)+1).click();
		if (iconName.equalsIgnoreCase("SHC"))
			HouseManifestPopupIconList.get(((rowNo-1)*6)+2).click();
		if (iconName.equalsIgnoreCase("Optional Shipment Info"))
			HouseManifestPopupIconList.get(((rowNo-1)*6)+3).click();
		if (iconName.equalsIgnoreCase("Copy"))
			HouseManifestPopupIconList.get(((rowNo-1)*6)+4).click();
		if (iconName.equalsIgnoreCase("Delete"))
			HouseManifestPopupIconList.get(((rowNo-1)*6)+5).click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnHouseManifestPopupButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Save"))
			HouseManifestPopupSaveBtn.click();
		if (buttonName.equalsIgnoreCase("Close"))
			HouseManifestPopupCloseBtn.click();
		if (buttonName.equalsIgnoreCase("Clear All"))
			HouseManifestPopupClearAllBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnHAWB_DeletionPopupButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Yes"))
			HAWB_DeletionPopupYesBtn.click();
		if (buttonName.equalsIgnoreCase("No"))
			HAWB_DeletionPopupNoBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnHAWB_MessagePopupButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Ok"))
			HAWB_MessagePopupOkBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}


	
	@FindBy (how = How.XPATH, using = "//span[@id='ctl00_hldPage_UpdatePanel3']//table//tbody//tr//td//img[@class='ui-datepicker-trigger']")
	public WebElement flightdatepicker;
	
	@FindBy (how = How.XPATH, using = "//img[@class='ui-datepicker-trigger']")
	public List<WebElement> flightdatepicker1;

	
}
