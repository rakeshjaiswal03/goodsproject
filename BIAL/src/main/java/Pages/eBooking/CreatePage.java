package Pages.eBooking;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.WebdriverMethods;

public class CreatePage {
	public WebDriver driver;
	public WebdriverMethods wm;
	boolean verify = false;
	
	public CreatePage(WebDriver driver, WebdriverMethods wm) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wm = wm;
	}
	
	//help  
	@FindBy(how = How.ID, using = "ctl00_ahelp")
	 public WebElement HelpBtn;
	
	//create screen
	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@class='lblheadingh5' and contains(text(),'Create')]"), 
		@FindBy(how = How.XPATH, using = "//*[@class='lblheadingh5' and contains(text(),'View Booking')]")})
	 public WebElement CreateScreen;
	
	//download link button   
	@FindBy(how = How.ID, using = "ctl00_hldPage_LinkButton1")
	 public WebElement DownloadSampleExcelFileBtn;
	
	//upload file
	@FindBy(how = How.ID, using = "ctl00_hldPage_fuctlLoadFilePath")
	 public WebElement ChooseFileBtn;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnFileCopyData")
	 public WebElement UploadFileBtn;
	
	
	//shipper  
	@FindBy(how = How.ID, using = "ctl00_hldPage_txtShipperName")
	 public WebElement ShipperName_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_popupShipper")
	 public WebElement AddShipperPlusIcon;
	
	//add shipper popup 
	@FindBy(how = How.XPATH, using = "//*[text()='Add Shipper']")
	 public WebElement AddShipperPopup;
	
	@FindBy(how = How.ID, using = "Ifram1")
	 public WebElement AddShipperPopupFrame;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_txtCompanyName")
	 public WebElement ShipperCompanyName_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_txtShipperAcctDetCode")
	 public WebElement ShipperIeCode_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_txtContactPersonEmailId")
	 public WebElement ShipperEmailId_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_branchAddressInformation_txtAddressLine1")
	 public WebElement ShipperAddressLine1_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_branchAddressInformation_txtAddressLine2")
	 public WebElement ShipperAddressLine2_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_branchAddressInformation_txtPinCode")
	 public WebElement ShipperZipCode_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_branchAddressInformation_GenericAutoFillCountry_txtCode")
	 public WebElement ShipperCountryCode_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_branchAddressInformation_GenericAutoFillCountry_txtName")
	 public WebElement ShipperCountryName_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_branchAddressInformation_GenericAutoFillState_txtCode")
	 public WebElement ShipperStateCode_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_branchAddressInformation_GenericAutoFillState_txtName")
	 public WebElement ShipperStateName_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_branchAddressInformation_GenericAutoFillCity_txtCode")
	 public WebElement ShipperCityCode_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_branchAddressInformation_GenericAutoFillCity_txtName")
	 public WebElement ShipperCityName_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_branchAddressInformation_txtOtherCity")
	 public WebElement ShipperOtherCity_DD;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_DivMessage']")
	 public WebElement ShipperSavedMsg;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnSave")
	 public WebElement SaveShipperBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='addshipper']/following::div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']//*[text()='Ok']")
	 public WebElement OkShipperBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='addshipper']/following::div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']//*[text()='Cancel']")
	 public WebElement CancelShipperBtn;
	
	//consignee
	@FindBy(how = How.ID, using = "ctl00_hldPage_txtConsigneeName")
	 public WebElement ConsigneeName_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_popupConsignee")
	 public WebElement AddConsigneePlusIcon;
	
	//add consignee popup 
	@FindBy(how = How.XPATH, using = "//*[text()='Add Consignee']")
	 public WebElement AddConsigneePopup;
	
	@FindBy(how = How.ID, using = "IframConsignee")
	 public WebElement AddConsigneePopupFrame;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_txtConsigneeName")
	 public WebElement ConsigneeName_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_txtConsigneeContactPersonEmail")
	 public WebElement ConsigneeEmailId_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_uclConsAddressInfo_txtAddressLine1")
	 public WebElement ConsigneeAddressLine1_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_uclConsAddressInfo_txtAddressLine2")
	 public WebElement ConsigneeAddressLine2_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_uclConsAddressInfo_txtPinCode")
	 public WebElement ConsigneeZipCode_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_uclConsAddressInfo_GenericAutoFillCountry_txtCode")
	 public WebElement ConsigneeCountryCode_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_uclConsAddressInfo_GenericAutoFillCountry_txtName")
	 public WebElement ConsigneeCountryName_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_uclConsAddressInfo_GenericAutoFillState_txtCode")
	 public WebElement ConsigneeStateCode_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_uclConsAddressInfo_GenericAutoFillState_txtName")
	 public WebElement ConsigneeStateName_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_uclConsAddressInfo_GenericAutoFillCity_txtCode")
	 public WebElement ConsigneeCityCode_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_uclConsAddressInfo_GenericAutoFillCity_txtName")
	 public WebElement ConsigneeCityName_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_uclConsAddressInfo_txtOtherCity")
	 public WebElement ConsigneeOtherCity_DD;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_lblApplicationError']")
	 public WebElement ConsigneeSavedMsg;
	
	@FindBy(how = How.XPATH, using = "//*[@id='liquid-bd']//*[@id='ctl00_hldPage_lblError']")
	 public WebElement ConsigneeErrorMsg;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dlgConsigneeContactInfo']/following::div//*[@id='ctl00_hldPage_btnCreateBooking']")
	 public WebElement SaveConsigneeBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='addConsignee']/following::div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']//*[text()='Ok']")
	 public WebElement OkConsigneeBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='addConsignee']/following::div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']//*[text()='Cancel']")
	 public WebElement CancelConsigneeBtn;
	
	//origin
	@FindBy(how = How.ID, using = "ctl00_hldPage_AirlineOriginPort_txtCode")
	 public WebElement OriginCode_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_AirlineOriginPort_txtName")
	 public WebElement OriginName_DD;
	
	//destination
	@FindBy(how = How.ID, using = "ctl00_hldPage_AirlineDestinationPort_txtCode")
	 public WebElement DestinationCode_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_AirlineDestinationPort_txtName")
	 public WebElement DestinationName_DD;
	
	//via1  
	@FindBy(how = How.ID, using = "ctl00_hldPage_GenericAutoFill1_txtCode")
	 public WebElement Via1Code_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_GenericAutoFill1_txtName")
	 public WebElement Via1Name_DD;
	
	//via2
	@FindBy(how = How.ID, using = "ctl00_hldPage_GenericAutoFill2_txtCode")
	 public WebElement Via2Code_DD;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_GenericAutoFill2_txtName")
	 public WebElement Via2Name_DD;
	
	//cargo details - rate line
	@FindBy(how = How.XPATH, using = "//*[@id='tblCargo']/tbody/tr")
	 public List<WebElement> CargoDetailsRowList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblCargo']/tbody/tr/td[@align='center']/img")
	 public List<WebElement> CargoDetailsIconList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblCargo']/tbody/tr/td[@align='center' or @align='left' or @class='table_mid' ]/input[@type='text']")
	 public List<WebElement> CargoDetailsTextboxList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblCargo']/tbody/tr/td[@align='center' or @align='left' or @class='table_mid' ]/select")
	 public List<WebElement> CargoDetailsDropdownList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblCargo']/tbody/tr/td/input[@type='checkbox']")
	 public List<WebElement> CargoDetailsCheckboxList;
	
	//Dimensions popup
	@FindBy(how = How.ID, using = "//*[text()='Dimensions']")
	 public WebElement DimesionsPopup;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblDimensions']/tbody/tr")
	 public List<WebElement> DimensionRowList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblDimensions']/tbody/tr/td[@class='table_mid']/input[@type='text']")
	 public List<WebElement> DimensionTextboxList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblDimensions']/tbody/tr/td/img")
	 public List<WebElement> DimensionIconList;
	
	@FindBy(how = How.XPATH, using = "//*[text()='Save']")
	 public WebElement SaveDimensionBtn;
	
	//buttons
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnCreateBooking")
	 public WebElement SaveJobBtn;
	 
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnSaveAsTemplate")
	 public WebElement SaveAsTemplateJobBtn;
	 
	@FindBy(how = How.ID, using = "btnSaveDraft")
	 public WebElement SaveAsDraftJobBtn;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnBackPage")
	 public WebElement BackJobBtn;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnSaveChanges")
	 public WebElement SaveChangesBtn;
	
	//Custom Broker  
	@FindBy(how = How.ID, using = "ctl00_hldPage_chkCHA")
	 public WebElement CustomBroker_CB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_drpCHAOrganization")
	 public WebElement CustomBroker_DD;
	
	//success popup
	@FindBy(how = How.ID, using = "pnlMessage6")
	 public WebElement SuccessPopup;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_Label4")
	 public WebElement SuccessPopupText;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btn6CrJob")
	 public WebElement CreateAnotherJobBtn;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btn6CpyJob")
	 public WebElement CopyThisJobBtn;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btn6No")
	 public WebElement NoBtn;
	
	//draft popup   
	@FindBy(how = How.XPATH, using = "//*[text()='Draft Name']")
	 public WebElement DraftNamePopup;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_TxtDraftName")
	 public WebElement DraftName_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnSaveAsDraft")
	 public WebElement SaveDraftNameBtn;
	
	//Template popup    //*[text()='Template']
	@FindBy(how = How.XPATH, using = "//*[text()='Template']")
	 public WebElement TemplatePopup;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_TxtTemplateName")
	 public WebElement TemplateName_TB;
	
	@FindBy(how = How.ID, using = "ctl00_hldPage_btnSaveTemplate")
	 public WebElement SaveTemplateBtn;
	
	//error/alert message
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_vldSummarySave']/ul/li")
	 public WebElement ErrorMsg;
	
	public void SelectValue(String fieldName, String selectValue) throws Throwable
	{
		if(fieldName.equalsIgnoreCase("Shipper Name"))
		{
			ShipperName_DD.sendKeys(selectValue);
			Thread.sleep(500);
			wm.Action_SelectElement(driver, ShipperName_DD);
			Thread.sleep(500);
			ShipperName_DD.sendKeys(Keys.TAB);
		}
		if(fieldName.equalsIgnoreCase("Consignee Name"))
		{
			ConsigneeName_DD.sendKeys(selectValue);
			Thread.sleep(500);
			wm.Action_SelectElement(driver, ConsigneeName_DD);
			Thread.sleep(500);
			ConsigneeName_DD.sendKeys(Keys.TAB);
		}
		if(fieldName.equalsIgnoreCase("Destination Code"))
		{
			DestinationCode_DD.sendKeys(selectValue,Keys.TAB);
			Thread.sleep(500);
		}
		
		if(fieldName.equalsIgnoreCase("Via1 Code"))
		{
			Via1Code_DD.sendKeys(selectValue,Keys.TAB);
			Thread.sleep(500);
		}
		if(fieldName.equalsIgnoreCase("Via2 Code"))
		{
			Via2Code_DD.sendKeys(selectValue,Keys.TAB);
			Thread.sleep(500);
		}
		
		wm.ImplicitlyWait(driver, 10);
	}
	
	public void SelectCustomBroker(String customBroker) throws Throwable
	{
		wm.JavascriptExecutor_ElementScroll(driver, CustomBroker_CB);
		Thread.sleep(500);
		CustomBroker_CB.click();
		Thread.sleep(500);
		
		wm.selectDropDownElementByVisibleText(driver, CustomBroker_DD, customBroker);
		wm.ImplicitlyWait(driver, 10);
	}
	
	public void ClickOnCargoDetailsIcon(String iconName, int rowNo) throws Throwable
	{
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
	
	public void AddDimensions(String noOfPcs, String length, String width, String height, int rowNo)
	{
		DimensionTextboxList.get((rowNo-1)*5).clear();
		DimensionTextboxList.get(((rowNo-1)*5)+1).clear();
		DimensionTextboxList.get(((rowNo-1)*5)+2).clear();
		DimensionTextboxList.get(((rowNo-1)*5)+3).clear();
		
		DimensionTextboxList.get((rowNo-1)*5).sendKeys(noOfPcs);
		DimensionTextboxList.get(((rowNo-1)*5)+1).sendKeys(length);
		DimensionTextboxList.get(((rowNo-1)*5)+2).sendKeys(width);
		DimensionTextboxList.get(((rowNo-1)*5)+3).sendKeys(height,Keys.TAB);
		
		wm.ImplicitlyWait(driver, 10);
	}
	
	public void ClickOnDimensionsIcon(String iconName, int rowNo)
	{
		if(iconName.equalsIgnoreCase("Plus"))
		{
			if (rowNo < 3)
			{
				DimensionIconList.get((rowNo-1)).click();
			}
			else
			{
				DimensionIconList.get(((rowNo-1)*2)-1).click();
			}
		}
		if(iconName.equalsIgnoreCase("Minus"))
		{
			if (rowNo > 1)
			{
				DimensionIconList.get(((rowNo-1)*2)+1).click();
			}
		}
		
		wm.ImplicitlyWait(driver, 10);
	}
	
	public void AddRateLine(String grWt, String cargoDescription, int rowNo)
	{
		CargoDetailsTextboxList.get(((rowNo-1)*6)+1).sendKeys(grWt, Keys.TAB);
		wm.ImplicitlyWait(driver, 10);
		
		CargoDetailsTextboxList.get(((rowNo-1)*6)+3).sendKeys(cargoDescription,Keys.TAB);
		wm.ImplicitlyWait(driver, 10);
	}
	
	public void AddRateLine(String grWt, String cargoDescription, String unNo, String Class, String packingGroup, int rowNo) throws Throwable
	{
		CargoDetailsTextboxList.get(((rowNo-1)*6)+1).sendKeys(grWt, Keys.TAB);
		wm.ImplicitlyWait(driver, 10);
		
		CargoDetailsTextboxList.get(((rowNo-1)*6)+3).sendKeys(cargoDescription,Keys.TAB);
		wm.ImplicitlyWait(driver, 10);
		
		CargoDetailsCheckboxList.get(rowNo-1).click();
		Thread.sleep(500);
		
		CargoDetailsTextboxList.get(((rowNo-1)*6)+4).sendKeys(unNo);
		CargoDetailsTextboxList.get(((rowNo-1)*6)+5).sendKeys(Class);
		wm.selectDropDownElementByVisibleText(driver, CargoDetailsDropdownList.get(((rowNo-1)*2)+1), packingGroup);
		Thread.sleep(500);
		
		wm.ImplicitlyWait(driver, 10);
//		Thread.sleep(1000);
	}
	
	public void CLickOnDimesnionsButton(String buttonName) throws Throwable
	{
		if(buttonName.equalsIgnoreCase("Save"))
		{
			SaveDimensionBtn.click();
		}
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void CLickOnButton(String buttonName) throws Throwable
	{
		if(buttonName.equalsIgnoreCase("Help"))
		{
			HelpBtn.click();
		}
		if(buttonName.equalsIgnoreCase("Download"))
		{
			DownloadSampleExcelFileBtn.click();
		}
		if(buttonName.equalsIgnoreCase("Upload"))
		{
			UploadFileBtn.click();
		}
		if(buttonName.equalsIgnoreCase("Save"))
		{
			wm.JavascriptExecutor_ElementScroll(driver, SaveJobBtn);
			Thread.sleep(500);
			SaveJobBtn.click();
		}
		if(buttonName.equalsIgnoreCase("Create Job"))
		{
			wm.JavascriptExecutor_ElementScroll(driver, SaveJobBtn);
			Thread.sleep(500);
			SaveJobBtn.click();
		}
		if(buttonName.equalsIgnoreCase("Save As Template"))
		{
			wm.JavascriptExecutor_ElementScroll(driver, SaveAsTemplateJobBtn);
			Thread.sleep(500);
			SaveAsTemplateJobBtn.click();
		}
		if(buttonName.equalsIgnoreCase("Save As Draft"))
		{	//wm.scrolldown(driver, SaveAsDraftJobBtn);
			wm.JavascriptExecutor_ElementScroll(driver, SaveAsDraftJobBtn);
			Thread.sleep(500);
			SaveAsDraftJobBtn.click();
		}
		if(buttonName.equalsIgnoreCase("Back"))
		{
			wm.JavascriptExecutor_ElementScroll(driver, BackJobBtn);
			Thread.sleep(500);
			BackJobBtn.click();
		}
		if(buttonName.equalsIgnoreCase("Save Changes"))
		{ //wm.scrolldown(driver, SaveChangesBtn);
			wm.JavascriptExecutor_ElementScroll(driver, SaveChangesBtn);
			Thread.sleep(500);
			SaveChangesBtn.click();
		}
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(2000);
	}
	
	public void ChooseFileForUpload(String dataExcelFile) throws Throwable
	{
		ChooseFileBtn.sendKeys(dataExcelFile);
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnSuccessPopupButton(String buttonName) throws Throwable
	{
		if(buttonName.equalsIgnoreCase("No"))
		{
			NoBtn.click();
		}
		if(buttonName.equalsIgnoreCase("Copy This Job"))
		{
			CopyThisJobBtn.click();
		}
		if(buttonName.equalsIgnoreCase("Create Another Job"))
		{
			CreateAnotherJobBtn.click();
		}
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnPlusIcon(String shipperOrConsignee) throws Throwable
	{
		if (shipperOrConsignee.equalsIgnoreCase("Shipper")){
			wm.VisibilityOfElementExplicityWait(driver, AddShipperPlusIcon, 10);
			AddShipperPlusIcon.click();
		}
		if (shipperOrConsignee.equalsIgnoreCase("Consignee")){
			wm.VisibilityOfElementExplicityWait(driver, AddConsigneePlusIcon, 10);
			AddConsigneePlusIcon.click();
		}
		wm.ImplicitlyWait(driver, 10); Thread.sleep(1000);
	}
	
	public void AddShipperDetails(String compnayName, String ieNo, String emailId, String addressLine1, 
			String zipCode, String countryCode, String cityCode)
	{
		ShipperCompanyName_TB.sendKeys(compnayName);
		ShipperIeCode_TB.sendKeys(ieNo);
		ShipperEmailId_TB.sendKeys(emailId);
		ShipperAddressLine1_TB.sendKeys(addressLine1);
		ShipperZipCode_TB.sendKeys(zipCode);
		ShipperCountryCode_DD.sendKeys(countryCode,Keys.TAB);
		ShipperCityCode_DD.sendKeys(cityCode,Keys.TAB);
		
		wm.ImplicitlyWait(driver, 10);
	}
	
	public void AddConsigneeDetails(String compnayName, String emailId, String addressLine1, 
			String zipCode, String countryCode, String cityCode)
	{
		ConsigneeName_TB.sendKeys(compnayName);
		ConsigneeEmailId_TB.sendKeys(emailId);
		ConsigneeAddressLine1_TB.sendKeys(addressLine1);
		ConsigneeZipCode_TB.sendKeys(zipCode);
		ConsigneeCountryCode_DD.sendKeys(countryCode,Keys.TAB);
		ConsigneeCityCode_DD.sendKeys(cityCode,Keys.TAB);
		
		wm.ImplicitlyWait(driver, 10);
	}
	
	public void ClickOnAddShipperButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Save"))
		{
			SaveShipperBtn.click();
		}
		if (buttonName.equalsIgnoreCase("Ok"))
		{
			OkShipperBtn.click();
		}
		if (buttonName.equalsIgnoreCase("Cancel"))
		{
			CancelShipperBtn.click();
		}
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnAddConsigneeButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Save"))
		{
			SaveConsigneeBtn.click();
		}
		if (buttonName.equalsIgnoreCase("Ok"))
		{
			OkConsigneeBtn.click();
		}
		if (buttonName.equalsIgnoreCase("Cancel"))
		{
			CancelConsigneeBtn.click();
		}
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void EnterDraftName(String value)
	{
		DraftName_TB.sendKeys(value);
		
		wm.ImplicitlyWait(driver, 5);
	}
	
	public void EnterTemplateName(String value)
	{
		TemplateName_TB.sendKeys(value);
		
		wm.ImplicitlyWait(driver, 5);
	}
	
	public void ClickOnDraftNameButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Save"))
		{
			SaveDraftNameBtn.click();
		}
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public void ClickOnTemplateButton(String buttonName) throws Throwable
	{
		if (buttonName.equalsIgnoreCase("Save"))
		{
			SaveTemplateBtn.click();
		}
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	
	public boolean isRateLineRowAdded()
	{
		if (CargoDetailsRowList.size() > 2)
		{
			verify = true;
		}
		else
		{
			verify = false;
		}
		
		return verify;
	}
	
	public boolean isDimesionsRowAdded()
	{
		if (DimensionRowList.size() > 2)
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
