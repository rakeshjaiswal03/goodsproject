package Pages;

import java.text.DateFormatSymbols;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.CommonMethods;
import Methods.WebdriverMethods;
import org.openqa.selenium.JavascriptExecutor;		

public class RegistrationPage {
	
	public WebDriver driver;
	public WebdriverMethods wm;
	
	public CommonMethods cm; 
	
	int count = 0;
	boolean verify = false;
	String elementText = null;
	
	public RegistrationPage(WebDriver driver, WebdriverMethods wm, CommonMethods cm) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wm = wm;
		this.cm = cm;
	}
	
	
	@FindBy (how = How.XPATH, using = "//*[@id=\"ctl00_hldPageHeader_pnlRegistration\"]")
	public WebElement cover;
	
	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_hldPageHeader_ChkBxLstBusinessLines_0']")
	public WebElement Checkbox_shipper;

	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_hldPageHeader_ChkBxLstBusinessLines_3']")
	public WebElement checkbox_Trucking_Co;
	
	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_hldPageHeader_ChkBxLstBusinessLines_6']")
	public WebElement Checkbox_Consignee;

	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_hldPageHeader_ChkBxLstBusinessLines_9']")
	public WebElement Checkbox_Bonded_Trucker;

	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_hldPageHeader_ChkBxLstBusinessLines_1']")
	public WebElement Checkbox_Freight_Forwarder;

	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_hldPageHeader_ChkBxLstBusinessLines_4']")
	public WebElement Checkbox_Customs_Broker;

	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_hldPageHeader_ChkBxLstBusinessLines_7'] ")
	public WebElement Checkbox_Chamber_of_Commerce;

	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_hldPageHeader_ChkBxLstBusinessLines_10']")
	public WebElement Checkbox_Security;
	

	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_hldPageHeader_ChkBxLstBusinessLines_2']")
	public WebElement Checkbox_Airline;

	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_hldPageHeader_ChkBxLstBusinessLines_5']")
	public WebElement Checkbox_GHA;

	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_hldPageHeader_ChkBxLstBusinessLines_8']")
	public WebElement Checkbox_Consolidator;
	
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtCompanyName']")
	public WebElement Organization_name_textBox;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtBusinessEmail']")
	public WebElement Business_email_ID_textBox;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtPhone1']")
	public WebElement BusinessContact_textBox;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtAddressLine1']")
	public WebElement Streetaddress1_textbox;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtAddressLine2']")
	public WebElement Streetaddress2_textbox;
	
	
	
	@FindAll ({ 
		@FindBy (xpath = "//*[@id=\"wizard-p-0\"]/div[6]/div[1]/div/input"), 
		@FindBy (xpath = "//input[@id='ctl00_hldPageHeader_txtPinCode']") 
		}) public WebElement Zip_textbox;

	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_GenericAutoFillCountry_txtCode']")
	public WebElement CountryCode_textbox;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_GenericAutoFillCountry_txtName']")
	public WebElement CountryName_textbox;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_GenericAutoFillCity_txtCode']")
	public WebElement CityCode_textbox;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_GenericAutoFillCity_txtName']")
	public WebElement CityName_textBox;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_GenericAutoFillStateNew_txtCode']")
	public WebElement StateCode_textbox;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_GenericAutoFillStateNew_txtName']")
	public WebElement StateName_textbox;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtContactPersonUserName']")
	public WebElement Username_textbox;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtContactPersonFirstName']")
	public WebElement Firstname;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtContactPersonLastName']")
	public WebElement LastName;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtContactPersonEmailId']")
	public WebElement EmailID;
	
	
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtMobileNo']")
	public WebElement ContactNumber;
	
	@FindBy (how = How.XPATH, using = "//select[@id='ctl00_hldPageHeader_ddlGSTRegStatus']")
	public WebElement  GSTRegistrationStatus;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_GenericAutoFillStateGst_txtCode']")
	public WebElement GSTStateCode;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_GenericAutoFillStateGst_txtName']")
	public WebElement GSTStateName;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtGSTNID']")
	public WebElement GSTIN;
	
	@FindBy (how = How.XPATH, using = "//select[@id='ctl00_hldPageHeader_drpdocumenttype']")
	public WebElement UploadDoc_SelectDocumentType ;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_fileUpload']")
	public WebElement BrowseBtn;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_btnUpload']")
	public WebElement UploadBtn;
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_chkAgree']")
	public WebElement CheckBox_TermCondtn;
	

	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_btnNext']")
	public WebElement SubmitBtn;
	
	@FindBy (how = How.XPATH, using = "//input[@id='btnBack']")
	public WebElement BackBtn;
	
	
	
	
	
	@FindAll ({ 
		@FindBy (xpath = "//span[@id='ctl00_hldPageHeader_Label2']"), 
		@FindBy (xpath = "//*[@id='divMsgBox']/div/center[1]/h5") 
		}) public WebElement registrationSuccessMsg;

	
	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_hldPageHeader_btnCloseDialog']")
	public WebElement closeBtn;
	
	

	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtForwarderAcctDetIATAReg']")
	public WebElement  IATA_RegistrationNo;
	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_hldPageHeader_divIATARegDate']/img")
	public WebElement IATA_RegistrationDate;
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtIATACassNo']")
	public WebElement IATA_CASS;
	
	
	
	
	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_hldPageHeader_txtCHAAccDetCustLicNo']")
	public WebElement customsBrokerLicenseNo;
	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_hldPageHeader_div5']/img")
	public WebElement LicenseExpiryDate;

	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtAirAccDetCarrRegNo']")
	public WebElement CarrierRegistrationNumber;
	@FindBy (how = How.XPATH, using = "//img[@class='ui-datepicker-trigger']")
	public WebElement ForAirline_IATARegistrationExpiryDate;
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtAirAccDetAirlinePrefix']")
	public WebElement AirlinePrefix;
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtAirAccDetCarrCode']")
	public WebElement  ICAO_CarrierCode;
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtAirAccDetIATACarrCode']")
	public WebElement  IATA_CarrierCode;
	
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtCRNNumber']")
	public WebElement CRN_Number;
	@FindBy (how = How.XPATH, using = "//img[@class='ui-datepicker-trigger']")
	public List<WebElement> CRN_ExpiryDate;
	
	
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtRALicense']")
	public WebElement  RA_LicenseNumber;
	@FindBy (how = How.XPATH, using = "//img[@class='ui-datepicker-trigger']")
	public WebElement RA_LicenseExpiryDate;
	
	
//	Shipper Registration Details when Business line Shipper is selected 
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtShipperAcctDetCode']")
	public WebElement  IECode ;
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtShipperAcctDetBankCode']")
	public WebElement AuthorizedDealerCode ;
	
	

	
//	Consignee  Registration Details when Business line Shipper is selected 
	@FindBy (how = How.XPATH, using = "	//input[@id='ctl00_hldPageHeader_txtIECode']")
	public WebElement  IECode1 ;
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPageHeader_txtAuthorizedDealerCode']")
	public WebElement AuthorizedDealerCode1 ;
	
	
//	Bonded Trucker Registration Details
	
	@FindBy (how = How.XPATH, using = "	//input[@id='ctl00_hldPageHeader_txtBondedTruckingLicenseNo']")
	public WebElement  BondedTruckingLicenseNo ;
	@FindBy (how = How.XPATH, using = "//img[@class='ui-datepicker-trigger']")
	public WebElement ExpiryDate ;
	
	
//	Chamber of Commerce Registration Details 
	
	@FindBy (how = How.XPATH, using = "	//input[@id='ctl00_hldPageHeader_txtCOCRegistrationNo']")
	public WebElement   RegistrationNo  ;
	
	
//	Alert message of registraion field 
	@FindBy (how = How.XPATH, using = "//span[@id='ctl00_hldPageHeader_lblAcceptTerms']")
	public WebElement   Alertmsg_termNcondnCB  ;	
	@FindBy (how = How.XPATH, using = "	//span[@id='ctl00_hldPageHeader_rfvCompanyName']")
	public WebElement   Organization_name;  
	@FindBy (how = How.XPATH, using = "	//span[@id='ctl00_hldPageHeader_RequiredFieldValidator3']")
	public WebElement   EmailIDrequired  ;
	@FindBy (how = How.XPATH, using = "//span[@id='ctl00_hldPageHeader_rfvtxtPhone1']")
	public WebElement   ContactnumberisRequired  ;
	@FindBy (how = How.XPATH, using = "//span[@id='ctl00_hldPageHeader_reqFdlAddressLine1']")
	public WebElement   StreetaddressRequired  ;
	@FindBy (how = How.XPATH, using = "//span[@id='ctl00_hldPageHeader_rfvtxtPinCode']")
	public WebElement   ZipcodeRequired  ;
	@FindBy (how = How.XPATH, using = "	//span[@id='ctl00_hldPageHeader_rfvUserName']")
	public WebElement   UsernameRequired  ;
	
//	Term and condition 
	@FindBy (how = How.XPATH, using = "//a[@id='lnkshowTerms']")
	public WebElement   TermAndCondn  ;
	
	
	

	
	
	public void ClickonBusinessline (String label) {
		if(label.equalsIgnoreCase("shipper"))
			Checkbox_shipper.click();
		
		if(label.equalsIgnoreCase("Trucking Co"))
			checkbox_Trucking_Co.click();
		
		if(label.equalsIgnoreCase("Consignee"))
			Checkbox_Consignee.click();
		
		if(label.equalsIgnoreCase("Bonded Trucker"))
			Checkbox_Bonded_Trucker.click();
		
		if(label.equalsIgnoreCase("Freight Forwarder"))
			Checkbox_Freight_Forwarder.click();
		
		if(label.equalsIgnoreCase("Customs Broker"))
			Checkbox_Customs_Broker.click();
		
		if(label.equalsIgnoreCase("Chamber of Commerce"))
			Checkbox_Chamber_of_Commerce.click();
		
		if(label.equalsIgnoreCase("Security"))
			Checkbox_Security.click();
		
		if(label.equalsIgnoreCase("Airline"))
			Checkbox_Airline.click();
		
		if(label.equalsIgnoreCase("GHA"))
			Checkbox_GHA.click();
		
		if(label.equalsIgnoreCase("Consolidator"))
			Checkbox_Consolidator.click();
	}
	
	public boolean isChecked (String label) {
		boolean check = false; 
		if(label.equalsIgnoreCase("shipper"))
			check = Checkbox_shipper.isSelected();
		
		if(label.equalsIgnoreCase("Trucking Co"))
			check =checkbox_Trucking_Co.isSelected();
		
		if(label.equalsIgnoreCase("Consignee"))
			check =Checkbox_Consignee.isSelected();
		
		if(label.equalsIgnoreCase("Bonded Trucker"))
			check =Checkbox_Bonded_Trucker.isSelected();
		
		if(label.equalsIgnoreCase("Freight Forwarder"))
			check =Checkbox_Freight_Forwarder.isSelected();
		
		if(label.equalsIgnoreCase("Customs Broker"))
			check =Checkbox_Customs_Broker.isSelected();
		
		if(label.equalsIgnoreCase("Chamber of Commerce"))
			check =Checkbox_Chamber_of_Commerce.isSelected();
		
		if(label.equalsIgnoreCase("Security"))
			check =Checkbox_Security.isSelected();
		
		if(label.equalsIgnoreCase("Airline"))
			check =Checkbox_Airline.isSelected();
		
		if(label.equalsIgnoreCase("GHA"))
			check =Checkbox_GHA.isSelected();
		
		if(label.equalsIgnoreCase("Consolidator"))
			check =Checkbox_Consolidator.isSelected();
		
		
		System.out.println(label+"is checked :"+check);
	return check; 
	}

	
	public boolean validateIsEnable (String label) {
		boolean check = false; 
		if(label.equalsIgnoreCase("shipper"))
			check = wm.isElementAttributeValueContain(driver, Checkbox_shipper, "disabled", "disabled");
		
		if(label.equalsIgnoreCase("Trucking Co"))
			check =wm.isElementAttributeValueContain(driver, checkbox_Trucking_Co, "disabled", "disabled");
			
		if(label.equalsIgnoreCase("Consignee"))
			check =wm.isElementAttributeValueContain(driver, Checkbox_Bonded_Trucker, "disabled", "disabled");
		
		if(label.equalsIgnoreCase("Bonded Trucker"))
			check =wm.isElementAttributeValueContain(driver, Checkbox_shipper, "disabled", "disabled");
		
		if(label.equalsIgnoreCase("Freight Forwarder"))
			check =wm.isElementAttributeValueContain(driver, Checkbox_Freight_Forwarder, "disabled", "disabled");
		
		if(label.equalsIgnoreCase("Customs Broker"))
			check =wm.isElementAttributeValueContain(driver, Checkbox_Customs_Broker, "disabled", "disabled");
		
		if(label.equalsIgnoreCase("Chamber of Commerce"))
			check =wm.isElementAttributeValueContain(driver, Checkbox_Chamber_of_Commerce, "disabled", "disabled");
		
		if(label.equalsIgnoreCase("Security"))
			check =wm.isElementAttributeValueContain(driver, Checkbox_Security, "disabled", "disabled");
		
		if(label.equalsIgnoreCase("Airline"))
			check =wm.isElementAttributeValueContain(driver, Checkbox_Airline, "disabled", "disabled");
		
		if(label.equalsIgnoreCase("GHA"))
			check =wm.isElementAttributeValueContain(driver, Checkbox_GHA, "disabled", "disabled");
		
		if(label.equalsIgnoreCase("Consolidator"))
			check =wm.isElementAttributeValueContain(driver, Checkbox_Consolidator, "disabled", "disabled");
		
		System.out.println(label+"::"+check);
	return check; 
	}
	
	
	
	
	@FindAll ({ 
		@FindBy (xpath = "//*[@id='ui-datepicker-div']/div/a[2]"), 
		@FindBy (xpath = "//*[@id='ui-datepicker-div']/div/a[2]/span") 
		}) public WebElement righicon;

	
	@FindAll ({ 
		@FindBy (xpath = "//*[@id='ui-datepicker-div']/div/a[1]"), 
		@FindBy (xpath = "//*[@id='ui-datepicker-div']/div/a[1]/span") 
		}) public WebElement lefticon;
	
	
	
	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id=\"ui-datepicker-div\"]/div/div/span[2]") })
	 public WebElement CleanderYear;
	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id=\"ui-datepicker-div\"]/div/div/span[1]") })
	 public WebElement CleanderMonth;
	
	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='ui-datepicker-div']/table/tbody/tr/td/a") })
	 public List<WebElement> CleanderSelectedDateTextList;
	

	
	String[] months = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
	
	public Integer indexOf(String[] arr, String str){
		   for (int i = 0; i < arr.length; i++)
		      if(arr[i].equals(str)) return i;
		   return -1;
		}
	
	public void SelectDate(WebElement element, String date) throws Exception  {
		element.click();
		String[] splitDate = date.split(" ");
		String dd = splitDate[0];
		String mm = splitDate[1];
		String yy = splitDate[2];
		checkMonth(mm);
		checkdatte(CleanderSelectedDateTextList, dd); 
	}
	public void SelectDate2(WebElement element, String date) throws Exception  {
		element.click();
		String[] splitDate = date.split(" ");
		String dd = splitDate[0];
		String mm = splitDate[1];
		String yy = splitDate[2];
		checkMonth(mm);
		checkdatte2(CleanderSelectedDateTextList, dd);
	}
	
	public void checkyear(int entY, int capY) throws InterruptedException {
		if(entY>capY) {
			for(int i=capY; i<entY+1; i++) {
				Thread.sleep(500);
				righicon.click();
				System.out.println("Clickon on Right icon");
				capY++;
				checkyear( entY,  capY);
			}
		}
		if(entY<capY) {
			for(int i=entY; i<capY;i++ ) {
				Thread.sleep(500);
				lefticon.click();
				System.out.println("Clickon on left icon");
				entY++;
				checkyear( entY,  capY);
			}
		}		
	}
	
	public void checkMonth(String givenmonth) throws Exception {
		int gm = Integer.parseInt(givenmonth); 
		String date = cm.SpecificDate1("dd MM yyyy", 0); 
		String[] splitDate = date.split(" ");
		String presentMonth = splitDate[1];
		int pm = Integer.parseInt(presentMonth); 
		System.out.println("gm:pm=="+gm+":"+pm);
		if(gm<pm) {
			
				lefticon.click();
		}

		if(gm>pm) {
			righicon.click();
		}
	}
	
	public void checkdatte(List<WebElement> element, String date) throws InterruptedException {
		int DaysSize = element.size();  							System.out.println("DaysSize:"+DaysSize);	
		for(int i=0; i<DaysSize-1; i++) {
			Thread.sleep(2000);
			  String celltext = element.get(i).getText();			System.out.println("celltext:"+celltext);
			  int intcelltext1 =Integer.parseInt(celltext);  
			  int intdate =Integer.parseInt(date);					System.out.println("intdate:"+intdate); 
			  
			  boolean ch1 = celltext.equalsIgnoreCase(date); boolean ch2 = intcelltext1==intdate;  
			  if(ch1==true || ch2==true) {
				  element.get(i).click();
//				  element.get(i).click(); // double click is imp
				  break; 
			  }
		}
	}
	
	public void checkdatte2(List<WebElement> element, String date) throws InterruptedException {
		int DaysSize = element.size();  System.out.println("DaysSize:"+DaysSize);
		for(int i=0; i<DaysSize-1; i++) {
			  String celltext = element.get(i).getText();
			  int intcelltext =Integer.parseInt(celltext);  
			  int intdate =Integer.parseInt(date); System.out.println("intdate:"+intdate); 
			  boolean check= intcelltext== intdate; System.out.println("check:"+check);
			  if(intcelltext== intdate ) {
				  element.get(i).click();
				  break; 
			  }
		}
	}
		
	public void checkdate(List<WebElement> element, int date) throws InterruptedException {
			int s = element.size(); System.out.println(s);
			System.out.println(element.get(date).getText()+"**");
			Thread.sleep(1000);
			element.get(date).click();	  
	}

	public void enterGST(String gst) {
		GSTStateCode.click();
		GSTStateCode.clear();
		GSTStateCode.sendKeys(gst);
	}
	
	public void enterTextInto(WebElement element, String input) {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].value='"+input+"'"+";", element);
	}

}
