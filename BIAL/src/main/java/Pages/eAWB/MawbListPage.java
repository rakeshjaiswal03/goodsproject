package Pages.eAWB;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindAll;

import Methods.CommonMethods;
import Methods.WebdriverMethods;

public class MawbListPage {
	public WebDriver driver;
	public WebdriverMethods wm;
	boolean verify = false;
	public CommonMethods cm;
	


	public MawbListPage(WebDriver driver, WebdriverMethods wm, CommonMethods cm) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wm = wm;
		this.cm = cm;
	}








	//opertor dropdown list  
	@FindBy(how = How.XPATH, using = "//*[@id='filterMenuDiv']/a")
	 public List<WebElement> FilterOperatorMenuList;
	
	//mawb list screen
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'MAWB List')]")
	 public WebElement MawbListScreen;
	
	//mawb list grid   
	//expand icon
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[1]/img")
	 public List<WebElement> MawbExpandIconList;
	
	//mawb no
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[2]/a[@class='item-right text-underline']")
	 public List<WebElement> MawbNoColList;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_grdMAWB_ctl01_txtFilter2")
	 public WebElement MawbNoFilter_TB;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB_ctl01_ddlFiltertable2']//*[@id='ctl00_hldPage_grdMAWB_ctl01_txtFilter2']")
	 public WebElement MawbNoFilter_TB1;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_grdMAWB_ctl01_imgFilterOperator2")
	 public WebElement MawbNoOperatorIconDD;
	
	//mawb date
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[3]/span")
	 public List<WebElement> MawbDateColList;
	
	//origin
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[4]/span")
	 public List<WebElement> OriginColList;
	
	//destination
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[5]/span")
	 public List<WebElement> DestColList;
	
	//carrier
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[6]/span")
	 public List<WebElement> CarrierColList;
	
	//CTO
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[7]/span")
	 public List<WebElement> CTO_ColList;
	
	//NOP
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[8]/span")
	 public List<WebElement> NOP_ColList;
	
	//gross wt
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[9]/span")
	 public List<WebElement> GrossWtColList;
	
	//Unit
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[10]/span")
	 public List<WebElement> UnitColList;
	
	//add hawb icon
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[11]/a/img")
	 public List<WebElement> AddHAWB_IconList;
	
	//ASI icon
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[12]/div/input[@type='image']")
	 public List<WebElement> ASI_IconList;
	
	//CO icon
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[13]/div/*[@type='image' or contains(@title,'Carting Order')]")
	 public List<WebElement> CO_IconList;
	
	//add SB
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[14]/a/img")
	 public List<WebElement> AddSB_IconList;
	
	//TSP
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[15]/input[@type='image']")
	 public List<WebElement> TSP_IconList;
	
	//View HAWB
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[16]/input[@type='image']")
	 public List<WebElement> ViewHAWB_IconList;
	
	//FWB
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[17]/div/input[@type='image']")
	 public List<WebElement> FWB_IconList;
	
	//FHL
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[18]/div/input[@type='image']")
	 public List<WebElement> FHL_IconList;
	
	//eDocket
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[19]/input[@type='image']")
	 public List<WebElement> eDocketIconList;
	
	//send manifest
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[20]/a/img")
	 public List<WebElement> SendManifestIconList;
	
	//update status
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[21]/a")
	 public List<WebElement> UpdateStatusLinkList;
	
	//ACS Receipt
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[22]/div/input[@type='image']")
	 public List<WebElement> ACS_ReceiptIconList;
	
	//SIR
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[23]/div/input[@type='image']")
	 public List<WebElement> SIR_IconList;
	
	//attach job
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[24]/input")
	 public List<WebElement> AttachJobIconList;
	
	//edit mawb
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[23]/a/img[@title='Edit Master Air Waybill']")
	 public List<WebElement> EditMawbIconList;
	
	//copy mawb
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[25]/a/img[@title='Copy Master Air Waybill']")
	 public List<WebElement> CopyMawbIconList;
	
	//Delete mawb
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[23]/input")
	 public List<WebElement> DeleteMawbIconList;
	
	// MAWB ASI poup  
	@FindBy(how = How.XPATH, using = "//*[text()='MAWB ASI' and @id='ctl00_hldPage_hdrMAWBASIResult']")
	 public WebElement MawbAsiPopup;
	
	
	
	
//	generate Token WebElements

	@FindAll ({ 
		@FindBy (xpath = "//input[@id='ctl00_hldPage_btnGenerateToken']"), 
		@FindBy (xpath = "//input[@id='ctl00_hldPage_btnSaveAwb']") 
		}) public WebElement GenerateToken;
	

	@FindBy (how = How.XPATH, using = "//*[contains(text(),'Vehicle Token Details')]")
	public WebElement VehicleTokenDetails_header ;
	
	@FindBy (how = How.XPATH, using = "//table[@id='tblVehicleTokenDetails']//tbody//tr//td[2]//input")
	public List<WebElement> VehicleNo ;
	
	@FindBy (how = How.XPATH, using = "//table[@id='tblVehicleTokenDetails']//tbody//tr//td[3]//input")
	public List <WebElement> DriverLicenseNo;
	
	@FindBy (how = How.XPATH, using = "//table[@id='tblVehicleTokenDetails']//tbody//tr//td[4]//input")
	public List <WebElement>  DriverName;

	@FindBy (how = How.XPATH, using = "//table[@id='tblVehicleTokenDetails']//tbody//tr//td[5]//input")
	public List<WebElement> DriverMobileNo;

	@FindBy (how = How.XPATH, using = "//table[@id='tblVehicleTokenDetails']//tbody//tr//td[6]//input")
	public List <WebElement> AgentMobileNo;

	@FindBy (how = How.XPATH, using = "//table[@id='tblVehicleTokenDetails']//tbody//tr//td[7]//input")
	public List<WebElement> Nop;
	
	@FindBy (how = How.XPATH, using = "//table[@id='tblVehicleTokenDetails']//tbody//tr//td[8]//input")
	public List <WebElement> grossWt;
	
	@FindBy (how = How.XPATH, using = "//select[@id='drpVehicleCargoType']")
	public WebElement  vehicleCargoType ;
	
	@FindBy (how = How.XPATH, using = "//img[@id='imgDesignated']")
	public WebElement  vehicleParkingArea ;
	
	@FindBy (how = How.XPATH, using = "//img[@id='imgDockIn']")
	public WebElement  vehicleDockIn ;
	
	@FindBy (how = How.XPATH, using = "//img[@id='imgDockOut']  ")
	public WebElement  vehicleDockOut ;

	@FindBy (how = How.XPATH, using = "//input[@id='txtRemarks']")
	public WebElement  VehicletokenRemark ;
	
	@FindBy (how = How.XPATH, using = "//table[@id='tblVehicleTokenDetails']//tfoot//tr//td[@class='text-center clsCreateAWB clsEdit']//img[@id='AddRow']")
	public WebElement  vehicleActionAddSign ;
	
	@FindBy (how = How.XPATH, using = "//table[@id='tblVehicleTokenDetails']//tbody//tr")
	public List<WebElement>  vehicleDetailrow ;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnSave']")
	public WebElement  SaveBtn ;
	
	@FindBy (how = How.XPATH, using = "//span[@id='ctl00_hldPage_lblMstSuccess']")
	public WebElement  vehicletokenPopupSuccessMsg ;
	
	@FindBy (how = How.XPATH, using = "//input[@type='button']")
	public WebElement  VehicletokenPopupOKBtn ;
	
//	--Search Token WebeElements----------------------------------------
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnSearchToken']")
	public WebElement searchTokenbtn ;

	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_txtSearchToken']")
	public WebElement TokenTextField ;
	
	@FindBy (how = How.XPATH, using = "//span[@id='txtVehTokenNo']")
	public WebElement VT ;

	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnEdit']//parent::span")
	public WebElement EditTokenBtn ;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnCancelToken']")
	public WebElement cancelTokenBtn ;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnBack']")
	public WebElement BackBtn ;
	
	@FindBy (how = How.XPATH, using = "//span[@id='ctl00_hldPage_lblMstSuccess']")
	public WebElement cancelTokenpopupMsg ;
		
	@FindBy (how = How.XPATH, using = "//input[@type='button']")
	public WebElement cancelTokenpopupMsg_okBtns ;
		

	@FindAll ({ 
		@FindBy (xpath = "//input[@id='ctl00_hldPage_btnPrintAll']"), 
		@FindBy (xpath = "//input[@id='btnPrintAllToken']") 
		}) public WebElement printToken;

	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_Button1']")
	public WebElement submit;
	
	@FindBy (how = How.XPATH, using = "//table[@id='ctl00_hldPage_chkTokenOption']//tbody//tr/td/input")
	public List<WebElement> printOption;
	
	@FindBy (how = How.XPATH, using = "	//span[@id='ctl00_hldPage_lblMstSuccess']")
	public WebElement vehicleupdateMsgpopup;
	
	@FindBy (how = How.XPATH, using = "//input[@type='button']")
	public WebElement vehicleupdateMsgpopupOK ;
	
//	------------------------------------------
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblMAWBASIMsg")
	 public WebElement MawbAsiPopupMsg;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_Button4")
	 public WebElement MawbAsiPopupOkBtn;
	
	//Carting Order (CO) Request popup
	@FindBy(how = How.ID, using = "hdrCMstAlert")
	 public WebElement CartingOrderPopup;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblCOMessage")
	 public WebElement CartingOrderPopupMsg;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_drpAirlineList")
	 public WebElement CartingOrderPopupAirline_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnGo")
	 public WebElement CartingOrderPopupNoBtn;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnRequestCartingOrder")
	 public WebElement CartingOrderPopupYesBtn;
	
	//co message popup
	@FindBy(how = How.ID, using = "CORreq")
	 public WebElement CO_MessagePopup;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblCORreqMessage")
	 public WebElement CO_MessagePopupMsg;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnCORreq")
	 public WebElement CO_MessagePopupOkBtn;
	
	//Shipping Bil Details screen  
	@FindBy(how = How.ID, using = "ModalHeader")
	 public WebElement ShippingBillDetailsScreen;
	
	@FindBy(how = How.XPATH, using = "//input[@id='txtSBNumber']")
	 public WebElement sbNo;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblMAWBNo")
	 public WebElement SB_MawbNo;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblAWB']/tbody/tr")
	 public List<WebElement> SB_DetailsRowList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblAWB']/tbody/tr/td/input[@type='text']")
	 public List<WebElement> SB_DetailsTextboxList;
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblAWB']/tbody/tr/td/select")
	 public List<WebElement> SB_DetailsDropdownList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblAWB']/tbody/tr/td/img")
	 public List<WebElement> SB_DetailsIconList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='AddRow']")
	 public WebElement SB_AddRowIcon;
	
	//dimesnsions popup
	@FindBy(how = How.XPATH, using = "ui-dialog-title-dialogdimensions")
	 public WebElement SB_DimensionsPopup; 
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblDimensions']/tbody/tr/td/input[@type='text']")
	 public List<WebElement> SB_DimensionsTextboxList; 
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblDimensions']/tbody/tr/td/img")
	 public List<WebElement> SB_DimensionsIconList; 
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblDimensions']/tbody/tr/td/select")
	 public List<WebElement> SB_DimensionsDropdownList;  
	
	@FindBy(how = How.XPATH, using = "//*[@id='dialogdimensions']/following::*[text()='Ok']")
	 public WebElement SB_DimensionsPopupOkBtn; 
	
	@FindBy(how = How.XPATH, using = "//*[@id='dialogdimensions']/following::*[text()='Cancel']")
	 public WebElement SB_DimensionsPopupCancelBtn; 
	
	@FindBy(how = How.ID, using = "btnSaveAWB")
	 public WebElement SB_SaveBtn;
	 
	@FindBy(how = How.ID, using = "btnCancelSaveAWB")
	 public WebElement SB_BackBtn;
	 
	//shipping bill popup
	@FindBy(how = How.XPATH, using = "//*[@id='hdrMstAlert' and text()='Shipping Bill']")
	 public WebElement ShippingBillPopup;
	 
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblMstSuccess")
	 public WebElement ShippingBillPopupMsg;
	 
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_lblMstSuccess']/span")
	 public WebElement ShippingBillPopupMsg2;
	
	@FindBy(how = How.XPATH, using = "//*[@id='divSuccessAlert']/div/div/div[3]/input")
	 public WebElement ShippingBillPopupOkBtn;
	
	//mawb list SB grid
	@FindBy(how = How.ID, using = "ctl00_hldPage_grdMAWB_ctl02_grdSBDetails")
	 public WebElement MawbListSB_Grid1;
	
	//sb no link
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr[3]/td/div/div/table/tbody/tr/td[1]/a")
	 public List<WebElement> MawbListSB_Grid1_SbNoLinkList;  
	
	//sb asi icon
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr[3]/td/div/div/table/tbody/tr/td[12]/input[@type='image']")
	 public List<WebElement> MawbListSB_Grid1_SB_ASI_IconList;  
	
	//TSP payment icon -- added by Rakesh Jaiswal
	
	 @FindAll ({ 
		 @FindBy (xpath = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr[3]/td/div/div/table/tbody/tr/td[13]/input[@type='image']"), 
		 @FindBy (xpath = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr[3]/td/div/div/table/tbody/tr/td[13]/a[1]") 
		 })	 public List<WebElement> MawbListSB_Grid1_TSPpayment_IconList;  
	
	
	//vehicleToken icon -- added by Rakesh Jaiswal
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr[3]/td/div/div/table/tbody/tr/td[14]/input[@type='image']")
	 public List<WebElement> MawbListSB_Grid1_vehicleToken_IconList;  
			
	//Hold Remark icon -- added by Rakesh Jaiswal
		@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr[3]/td/div/div/table/tbody/tr/td[15]/input[@type='image']")
		 public List<WebElement> MawbListSB_Grid1_holdremark_IconList;  
	
	//DockIn icon -- added by Rakesh Jaiswal
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr[3]/td/div/div/table/tbody/tr/td[16]/input[@type='image']")
	public List<WebElement> MawbListSB_Grid1_DockIn_IconList;  
	
	//DockOut icon -- added by Rakesh Jaiswal
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr[3]/td/div/div/table/tbody/tr/td[17]/input[@type='image']")
	public List<WebElement> MawbListSB_Grid1_DockOut_IconList;  
	
	//ACSReceipt icon -- added by Rakesh Jaiswal
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr[3]/td/div/div/table/tbody/tr/td[18]/input[@type='image']")
	public List<WebElement> MawbListSB_Grid1_ACSReceipt_IconList;  

	//Action icon -- added by Rakesh Jaiswal
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr[3]/td/div/div/table/tbody/tr/td[19]/input[@type='image']")
	public List<WebElement> MawbListSB_Grid1_Action_IconList;  
	
	//sbi asi submission popup  
	@FindBy(how = How.ID, using = "hdrASISbn")
	 public WebElement SB_ASI_SubmissionPopup;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_txtASIMawbNum")
	 public WebElement SB_ASI_SubmissionMawbNo_TB;
	 
	@FindBy(how = How.ID, using = "ctl00_hldPage_gridASIMawb_ctl01_chkAllSB")
	 public WebElement SB_ASI_SubmissionPopupSelectAll_CB;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_gridASIMawb']/tbody/tr/td[1]/input[@type='checkbox']")
	 public List<WebElement> SB_ASI_SubmissionGridCheckboxList;  
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_gridASIMawb_ctl02_lblASISBNumber")
	 public WebElement SB_ASI_SubmissionSbNo;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnASICancel")
	 public WebElement SB_ASI_SubmissionCancelBtn;
	
	@FindBy(how = How.ID, using = "btnASIProceed")
	 public WebElement SB_ASI_SubmissionProceedBtn;
	
	//sb asi confiramtion  

	
	@FindAll ({ 
		@FindBy (xpath = "//*[@id='hdrMstAlert' and text()='SB ASI Confirmation']"), 
		@FindBy (xpath = "//span[@id='ctl00_lblMstAlert']") 
		}) public WebElement SB_ASI_ConfirmationPopup;


	
	@FindBy(how = How.XPATH, using = "//div[@id='divMstAlert']//div[@class='modal-dialog popup-center']//div[@class='modal-content']//div[@class='modal-body']//span")
	 public WebElement SB_ASI_PDPopupMsg;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_Label1']")
	 public WebElement SB_ASI_ConfirmationPopupMsg;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnASINo")
	 public WebElement SB_ASI_ConfirmationNoBtn;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnASIYes")
	 public WebElement SB_ASI_ConfirmationYesBtn;
	
	//sb advance shipment information popup  
	@FindBy(how = How.XPATH, using = "//*[text()='SB Advance Shipment Information' and @id='hdrASIResult']")
	 public WebElement SB_AdvanceShipmentInformationPopup;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblASIFWB")
	 public WebElement SB_AdvanceShipmentInformationPopupMsg;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnASIOK") 
	 public WebElement SB_AdvanceShipmentInformationPopupOkBtn;
	
	//mawb deletion popup  
	@FindBy(how = How.XPATH, using = "//*[text()='MAWB Deletion']")
	 public WebElement MAWB_DeletionPopup;
	
	@FindBy(how = How.XPATH, using = "//*[@cssclass='Common-lbl']")
	 public WebElement MAWB_DeletionPopupMsg;
	
	@FindBy(how = How.XPATH, using = "//*[text()='Yes']")
	 public WebElement MAWB_DeletionPopupYesBtn;
	
	@FindBy(how = How.XPATH, using = "//*[text()='No']")
	 public WebElement MAWB_DeletionPopupNoBtn;
	
	//mawb deletion Message popup  
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_UpdatePanel2']/div")
	 public WebElement MAWB_DeletionMessagePopup;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_lblCOSuccessMsg")
	 public WebElement MAWB_DeletionMessagePopupMsg;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_Button1")
	 public WebElement MAWB_DeletionPopupMessageOkBtn;
	
	public void ClickOnGridIcon(String iconName, int rowNo) throws Exception
	{ Thread.sleep(5000);
		if (iconName.equalsIgnoreCase("Expand"))
			MawbExpandIconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("Add HAWB"))
			AddHAWB_IconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("ASI"))
			ASI_IconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("CO"))
			CO_IconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("Add SB"))
			AddSB_IconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("TSP"))
			TSP_IconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("View HAWB"))
			ViewHAWB_IconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("FWB"))
			FWB_IconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("FHL"))
			FHL_IconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("e-Docket"))
			eDocketIconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("Send Manifest"))
			SendManifestIconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("Update Status"))
			UpdateStatusLinkList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("ACS Receipt"))
			ACS_ReceiptIconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("SIR"))
			SIR_IconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("Attach Job"))
			AttachJobIconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("Edit"))
			EditMawbIconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("Copy"))
			CopyMawbIconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("Delete"))
			DeleteMawbIconList.get(rowNo-1).click();

		if (iconName.equalsIgnoreCase("SB No"))
			MawbListSB_Grid1_SbNoLinkList.get(rowNo-1).click();
		//------ elements under expand 
		if (iconName.equalsIgnoreCase("SB ASI"))
			MawbListSB_Grid1_SB_ASI_IconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("TSP payment"))
			MawbListSB_Grid1_TSPpayment_IconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("hold remark"))
			MawbListSB_Grid1_holdremark_IconList.get(rowNo-1).click();
		if (iconName.equalsIgnoreCase("vehicle token"))
			MawbListSB_Grid1_vehicleToken_IconList.get(rowNo-1).click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnMawbAsiPopupButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Ok"))
			MawbAsiPopupOkBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void SendCO_RequestToAirline(String airlineName) throws Throwable
	{
		wm.selectDropDownElementByVisibleText(driver, CartingOrderPopupAirline_DD, airlineName); 	Thread.sleep(300);
		CartingOrderPopupYesBtn.click();
		wm.ImplicitlyWait(driver, 10); Thread.sleep(500);
	}
	
	public void ClickOnCO_MessagePopupButton(String buttonName) throws Throwable
	{
		try{
			if (buttonName.equalsIgnoreCase("Ok"))
				CO_MessagePopupOkBtn.click();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		
		wm.ImplicitlyWait(driver, 10); Thread.sleep(1000);
	}
	
	public void Filter(String colName, String filterValue, String opeator) throws Throwable
	{ 	wm.VisibilityOfElementExplicityWait(driver, MawbNoFilter_TB1, 10);
		if(colName.equalsIgnoreCase("MAWB No"))
		{	Thread.sleep(1000);
			MawbNoFilter_TB1.clear();
			MawbNoFilter_TB1.sendKeys(filterValue);
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
	
	public void AddSB_Details(String sbNo, String sbDate, String sbType, 
			String nop, String grwt, String length, String width, String height, int rowNo) throws Throwable
	{
		Thread.sleep(2000);System.out.println("rowNo: "+rowNo+"   sbNo:"+sbNo);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+0).clear();
		SB_DetailsTextboxList.get(((rowNo-1)*9)+0).sendKeys(sbNo, Keys.TAB);
		
//		this.sbNo.clear(); this.sbNo.sendKeys(sbNo, Keys.TAB);
		
		SB_DetailsTextboxList.get(((rowNo-1)*9)+1).sendKeys(sbDate, Keys.TAB);
		wm.selectDropDownElementByVisibleText(driver, SB_DetailsDropdownList.get((rowNo-1)*2), sbType);
		Thread.sleep(1000);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+2).sendKeys(nop, Keys.TAB);
		Thread.sleep(500);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+3).sendKeys(grwt, Keys.TAB);
		
		
		if (rowNo < 3)
		{
			SB_DetailsIconList.get(((rowNo-1)*3)+1).click();
		}
		else
		{
			SB_DetailsIconList.get(((rowNo-1)*4)).click();
		}
//		SB_DetailsIconList.get(((rowNo-1)*3)+1).click();
		Thread.sleep(3000);
//		wm.VisibilityOfElementExplicityWait(driver, SB_DimensionsPopup, 8);
		SB_DimensionsTextboxList.get(0).sendKeys(nop);
		SB_DimensionsTextboxList.get(1).sendKeys(length);
		SB_DimensionsTextboxList.get(2).sendKeys(width);
		SB_DimensionsTextboxList.get(3).sendKeys(height,Keys.TAB);
		Thread.sleep(500);
		SB_DimensionsPopupOkBtn.click();
		Thread.sleep(2000);
		
		SB_DetailsTextboxList.get(((rowNo-1)*9)+5).clear();
		Thread.sleep(500);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+5).sendKeys(grwt, Keys.TAB);
		
		SB_DetailsTextboxList.get(((rowNo-1)*9)+6).sendKeys(cm.RandomNo(10), Keys.TAB);
	
	}
	
	public void AddSB_Details__(String sbNo, String sbDate, String sbType, 
			String nop, String grwt, String length, String width, String height, int rowNo) throws Throwable
	{
		Thread.sleep(2000);System.out.println("sbNo::"+sbNo);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+0).clear();
		SB_DetailsTextboxList.get(((rowNo-1)*9)+0).sendKeys(sbNo, Keys.TAB);
//		this.sbNo.clear(); this.sbNo.sendKeys(sbNo, Keys.TAB);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+1).sendKeys(sbDate, Keys.TAB);
		wm.selectDropDownElementByVisibleText(driver, SB_DetailsDropdownList.get((rowNo-1)*2), sbType);
		Thread.sleep(1000);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+2).sendKeys(nop, Keys.TAB);
		Thread.sleep(500);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+3).sendKeys(grwt, Keys.TAB);
		
		if (rowNo < 3)
		{
			SB_DetailsIconList.get(((rowNo-1)*3)+1).click();
		}
		else
		{
			SB_DetailsIconList.get(((rowNo-1)*4)).click();
		}
//		SB_DetailsIconList.get(((rowNo-1)*3)+1).click();
		Thread.sleep(3000);
//		wm.VisibilityOfElementExplicityWait(driver, SB_DimensionsPopup, 8);
		SB_DimensionsTextboxList.get(0).sendKeys(nop);
		SB_DimensionsTextboxList.get(1).sendKeys(length);
		SB_DimensionsTextboxList.get(2).sendKeys(width);
		SB_DimensionsTextboxList.get(3).sendKeys(height,Keys.TAB);
		Thread.sleep(500);
		SB_DimensionsPopupOkBtn.click();
		Thread.sleep(2000);
		
//		SB_DetailsTextboxList.get(((rowNo-1)*9)+5).clear();
		Thread.sleep(500);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+5).sendKeys(grwt, Keys.TAB);
		
		SB_DetailsTextboxList.get(((rowNo-1)*9)+6).sendKeys(cm.RandomNo(10), Keys.TAB);
	
	}
	
	public void AddSB_Details1__(String sbNo, String sbDate, String sbType, 
			String nop, String grwt, String length, String width, String height, int rowNo) throws Throwable
	{
		Thread.sleep(2000);System.out.println("sbNo::"+sbNo);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+0).clear();
		SB_DetailsTextboxList.get(((rowNo-1)*9)+0).sendKeys(sbNo, Keys.TAB);
//		this.sbNo.clear(); this.sbNo.sendKeys(sbNo, Keys.TAB);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+1).sendKeys(sbDate, Keys.TAB);
		wm.selectDropDownElementByVisibleText(driver, SB_DetailsDropdownList.get((rowNo-1)*2), sbType);
		Thread.sleep(1000);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+2).sendKeys(nop, Keys.TAB);
		Thread.sleep(500);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+3).sendKeys(grwt, Keys.TAB);
		
		if (rowNo < 3)
		{
			SB_DetailsIconList.get(((rowNo-1)*3)+1).click();
		}
		else
		{
			SB_DetailsIconList.get(((rowNo-1)*4)).click();
		}
//		SB_DetailsIconList.get(((rowNo-1)*3)+1).click();
		Thread.sleep(3000);
//		wm.VisibilityOfElementExplicityWait(driver, SB_DimensionsPopup, 8);
		SB_DimensionsTextboxList.get(0).sendKeys(nop);
		SB_DimensionsTextboxList.get(1).sendKeys(length);
		SB_DimensionsTextboxList.get(2).sendKeys(width);
		SB_DimensionsTextboxList.get(3).sendKeys(height,Keys.TAB);
		Thread.sleep(500);
		SB_DimensionsPopupOkBtn.click();
		Thread.sleep(2000);
		
//		SB_DetailsTextboxList.get(((rowNo-1)*9)+5).clear();
		Thread.sleep(500);
//		SB_DetailsTextboxList.get(((rowNo-1)*9)+5).sendKeys(grwt, Keys.TAB);
		
		SB_DetailsTextboxList.get(((rowNo-1)*9)+6).sendKeys(cm.RandomNo(10), Keys.TAB);
	
	}
	
	public void AddConsolSB_Details(String sbNo, String sbDate, String sbType, String hawbNo, 
			String nop, String length, String width, String height, int rowNo) throws Throwable
	{
		SB_DetailsTextboxList.get((rowNo-1)*9).sendKeys(sbNo);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+1).sendKeys(sbDate, Keys.TAB);
		wm.selectDropDownElementByVisibleText(driver, SB_DetailsDropdownList.get((rowNo-1)*2), sbType);
		Thread.sleep(500);
		wm.selectDropDownElementByVisibleText(driver, SB_DetailsDropdownList.get(((rowNo-1)*2)+1), hawbNo);
//		SB_DetailsTextboxList.get(((rowNo-1)*9)+2).sendKeys(nop, Keys.TAB);
//		SB_DetailsTextboxList.get(((rowNo-1)*9)+3).sendKeys(grwt, Keys.TAB);
		Thread.sleep(2000);
		
		if (rowNo < 3)
		{Thread.sleep(500);
			SB_DetailsIconList.get(((rowNo-1)*3)+1).click();
		}
		else
		{
			SB_DetailsIconList.get(((rowNo-1)*4)).click();
		}
//		SB_DetailsIconList.get(((rowNo-1)*3)+1).click();
		Thread.sleep(3000);
//		wm.VisibilityOfElementExplicityWait(driver, SB_DimensionsPopup, 8);
		SB_DimensionsTextboxList.get(0).sendKeys(nop);
		SB_DimensionsTextboxList.get(1).sendKeys(length);
		SB_DimensionsTextboxList.get(2).sendKeys(width);
		SB_DimensionsTextboxList.get(3).sendKeys(height,Keys.TAB);
		Thread.sleep(500);
		SB_DimensionsPopupOkBtn.click();
		Thread.sleep(2000);
		
//		SB_DetailsTextboxList.get(((rowNo-1)*9)+5).clear();
//		Thread.sleep(500);
//		SB_DetailsTextboxList.get(((rowNo-1)*9)+5).sendKeys(grwt, Keys.TAB);
	}
	
	public void AddConsolSB_Details__(String sbNo, String sbDate, String sbType, String hawbNo, 
			String nop, String length, String width, String height, int rowNo, String grwt) throws Throwable
	{
		SB_DetailsTextboxList.get((rowNo-1)*9).sendKeys(sbNo);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+1).sendKeys(sbDate, Keys.TAB);
		wm.selectDropDownElementByVisibleText(driver, SB_DetailsDropdownList.get((rowNo-1)*2), sbType);
		Thread.sleep(2000);
		wm.selectDropDownElementByVisibleText(driver, SB_DetailsDropdownList.get(((rowNo-1)*2)+1), hawbNo);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+2).clear();
		SB_DetailsTextboxList.get(((rowNo-1)*9)+2).sendKeys(nop, Keys.TAB); System.out.println("nop::"+nop);
		SB_DetailsTextboxList.get(((rowNo-1)*9)+3).sendKeys(grwt, Keys.TAB);
		Thread.sleep(4000);
		
		if (rowNo < 3)
		{Thread.sleep(500);
			SB_DetailsIconList.get(((rowNo-1)*3)+1).click();
		}
		else
		{Thread.sleep(500);
			SB_DetailsIconList.get(((rowNo-1)*4)).click();
		}
//		SB_DetailsIconList.get(((rowNo-1)*3)+1).click();
		Thread.sleep(3000);
//		wm.VisibilityOfElementExplicityWait(driver, SB_DimensionsPopup, 8);
		SB_DimensionsTextboxList.get(0).clear();
		SB_DimensionsTextboxList.get(0).sendKeys(nop);
		SB_DimensionsTextboxList.get(1).sendKeys(length);
		SB_DimensionsTextboxList.get(2).sendKeys(width);
		SB_DimensionsTextboxList.get(3).sendKeys(height,Keys.TAB);
		Thread.sleep(500);
		SB_DimensionsPopupOkBtn.click();
		Thread.sleep(2000);
		
//		below  field commented as Field has been greyed out.. rakesh jaiswal
//		SB_DetailsTextboxList.get(((rowNo-1)*9)+5).clear();
//		Thread.sleep(500);
//		SB_DetailsTextboxList.get(((rowNo-1)*9)+5).sendKeys(grwt, Keys.TAB);
	}
	public void ClickOnSB_DetailsIcon(String iconName) throws Throwable
	{
		if (iconName.equalsIgnoreCase("Add Row"))
			SB_AddRowIcon.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnSB_DetailsPopupButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Save"))
			SB_SaveBtn.click();
		if (buttonName.equalsIgnoreCase("Back"))
			SB_BackBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnShippingBillPopupButton(String buttonName) throws Throwable
	{    Thread.sleep(2000);
		if (buttonName.equalsIgnoreCase("Ok"))
			ShippingBillPopupOkBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void SelectSB_ASI_SubmissinGridCheckbox(int rowNo) throws Throwable
	{
		SB_ASI_SubmissionGridCheckboxList.get(rowNo-1).click();
		Thread.sleep(300);
	}
	
	public void ClickOnSB_ASI_SubmissionPopupButton(String buttonName) throws Throwable
	{
		Thread.sleep(3000);
		if (buttonName.equalsIgnoreCase("Proceed"))
			SB_ASI_SubmissionProceedBtn.click();
		if (buttonName.equalsIgnoreCase("Cancel"))
			SB_ASI_SubmissionCancelBtn.click();
		if (buttonName.equalsIgnoreCase("Select All"))
			SB_ASI_SubmissionPopupSelectAll_CB.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnSB_ASI_ConfirmationPopupButton(String buttonName) throws Throwable
	{		Thread.sleep(2000);
		if (buttonName.equalsIgnoreCase("Yes"))
			SB_ASI_ConfirmationYesBtn.click();
		if (buttonName.equalsIgnoreCase("No"))
			SB_ASI_ConfirmationNoBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnSB_AdvanceShipmentInformationPopupButton(String buttonName) throws Throwable
	{ 		Thread.sleep(2000); wm.VisibilityOfElementExplicityWait(driver, SB_AdvanceShipmentInformationPopupOkBtn, 10);
		if (buttonName.equalsIgnoreCase("Ok"))
			SB_AdvanceShipmentInformationPopupOkBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	
	public void ClickOnMAWB_DeletionPopupButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Yes"))
			MAWB_DeletionPopupYesBtn.click();
		if (buttonName.equalsIgnoreCase("No"))
			MAWB_DeletionPopupNoBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnMAWB_DeletionMessagePopupButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Ok"))
			MAWB_DeletionPopupMessageOkBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
//	added by Rakesh jaiswal 
	
//	TSP Payment popup element 
	
	@FindBy (how = How.XPATH, using = "//h5[@id='hdrTSPPop']")
	public WebElement TSPpaymentPopuptitle;

	@FindBy (how = How.XPATH, using = "//select[@id='ctl00_hldPage_ddlTypeTxt']")
	public WebElement  CargoType ;

	@FindBy (how = How.XPATH, using = "//select[@id='ctl00_hldPage_ddlComodityTypeName']")
	public WebElement ComodityName;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_txtHSNCode']")
	public WebElement  HSNCode ;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_txtTransPassword']")
	public WebElement  TransactionPassword ;

	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnPayNow']")
	public WebElement  paynow ;
	
	@FindBy (how = How.XPATH, using = "//span[@id='ctl00_hldPage_lblTSPConfirmMessage']")
	public WebElement  TSPpaymentConfirmMessage ;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnTSPConfirm']")
	public WebElement  yes ;

//	token validation popup element 
	//input[@id='ctl00_hldPage_btnTSPConfirm']
	@FindBy (how = How.XPATH, using = "//span[@id='ctl00_hldPage_lblTSPRsltMsg']")
	public WebElement GenerateTokenFromTSP_Mesage;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnGenerateTokenFromTSPConfirm']")
	public WebElement YesbtnGenerateTokenFromTSPConfirm;

	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_Button2']")
	public WebElement NobtnGenerateTokenFromTSPConfirm;

//	print TSP Element 
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_ibtnPrint']")
	public WebElement printBnt;

	
	
	@FindBy (how = How.XPATH, using = "//span[@id='txtVehTokenNo']")
	public WebElement VehicleTokenNo_Field;
	public String captureVehicleTokenNo() {
		String v= VehicleTokenNo_Field.getText(); System.out.println("VehicleTokenNo_:"+v);
		return v;
	}

	

	
	
	
}
