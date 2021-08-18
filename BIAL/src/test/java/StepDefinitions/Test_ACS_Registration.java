package StepDefinitions;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Methods.CommonMethods;
import Methods.Setup;
import Methods.WebdriverMethods;
import Pages.BialMenu;
import Pages.LoginPage;
import Pages.RegistrationPage;
import Pages.TermAndCondition;
import Pages.acsAdminRegistrationManagement;
import Pages.commonOperation;
import Pages.homepage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Test_ACS_Registration {
	
	public WebDriver driver;
	public Setup launch;
	public WebdriverMethods wm;
	public commonOperation co; 
	public acsAdminRegistrationManagement registMangmt; 
	
	LoginPage login;
	BialMenu menu;
	RegistrationPage rp;
	CommonMethods cm;  
	TermAndCondition tc; 
	public boolean verify = false;
	String ConfigKeysFile = "Config_Keys.properties";
	String geckoDriverPath = null, URL = null, AgentUsername = null, AgentPassword = null, KaleACSUsername, KaleACSPassword, UploadFilePath1, UploadFilePath2, UploadFilePath3, UploadFilePath4 ;
	
	homepage hp; 
		
	@Given("^Launch Browser and Bial application link for registration$")
	public void launch_Browser_and_Bial_application_link_for_registration() throws Throwable {
		File file = new File(ConfigKeysFile);
		InputStream fis = new FileInputStream(file);
		Properties pf = new Properties();
		pf.load(fis);
		geckoDriverPath = pf.getProperty("GeckodriverPath");
//		URL = pf.getProperty("URL");
		URL = pf.getProperty("STGLink");
		AgentUsername = pf.getProperty("agentUsername");
		AgentPassword = pf.getProperty("agentPassword");

		KaleACSUsername = pf.getProperty("KaleAdminUsername");
		KaleACSPassword = pf.getProperty("KaleAdminPassword");
		 
		UploadFilePath1 = pf.getProperty("UploadFilePath1"); 
		UploadFilePath2 = pf.getProperty("UploadFilePath2"); 
		UploadFilePath3 = pf.getProperty("UploadFilePath3"); 
		UploadFilePath4 = pf.getProperty("UploadFilePath4"); 
		launch = new Setup();
		driver = launch.LaunchFirefox(geckoDriverPath, URL);
		wm = new WebdriverMethods(driver);
		cm = new CommonMethods(); 
		login = new LoginPage(driver);
		menu = new BialMenu(driver, wm);
		hp = new homepage(driver, wm);
		rp = new RegistrationPage(driver, wm, cm);
		co = new commonOperation(driver, wm, cm);
		tc = new TermAndCondition(driver, wm, cm);
		registMangmt = new acsAdminRegistrationManagement(driver, wm, cm);
	}
	
//     @135875 @BIAL_TC_01 step definition 56456454
	
	@When("^Refresh website$")
	public void refresh_website() throws Throwable {
		driver.navigate().refresh();
	}
	
	@Then("^validate login div is present in homepage$")
	public void validate_login_div_is_present_in_homepage() throws Throwable {
		boolean validate = hp.loginDiv.isDisplayed(); 
		Assert.assertTrue(validate);
	}

//	@135875 @BIAL_TC_02 step definition
	@Then("^Validate Registration hyperlink is present in homepage$")
	public void validate_Registration_hyperlink_is_present_in_homepage() throws Throwable {
		boolean validate = hp.NewRegistrationhyperLink.isDisplayed(); 
		Assert.assertTrue(validate);
	}

	@Then("^validate Registration Text is present in homepage$")
	public void validate_Registration_Text_is_present_in_homepage() throws Throwable {
		boolean validate = hp.NewRegistrationtext.isDisplayed(); 
		Assert.assertTrue(validate);
	}

	@Then("^Clickon Registration hyperLink$")
	public void Clickon_Registration_hyperLink() throws Throwable {
		hp.NewRegistrationhyperLink.click();
	}
	
	@Then("^validate new Registration page is displayed$")
	public void validate_new_Registration_page_is_displayed() throws Throwable {
		boolean validate = hp.RegistrationFormHeader.isDisplayed(); 
		Assert.assertTrue(validate);
	}

//	@135875	@BIAL_TC_03 step definition 
	
	@When("^Check the check box of Freight Forwarder business line$")
	public void check_the_check_box_of_Freight_Forwarder_business_line() throws Throwable {
	  rp.ClickonBusinessline("Freight Forwarder");
	  Thread.sleep(3000);
	}
	
	
	@When("^validate Customs Broker and Consolidator business line is enabled$") //updated on 29may2021
	public void validate_Customs_Broker_and_Consolidator_business_line_is_enabled() throws Throwable {
		Thread.sleep(1000);
		 Assert.assertFalse(rp.validateIsEnable("Customs Broker")); 
		 Assert.assertFalse(rp.validateIsEnable("Consolidator"));
	  wm.ImplicitlyWait(driver, 2);	  
	}
	
	@When("^validate remaining business line should be disabled$")
	public void validate_remaining_business_line_should_be_disabled() throws Throwable {
		 Assert.assertFalse(rp.validateIsEnable("Shipper"));
		 Assert.assertFalse(rp.validateIsEnable("Trucking Co"));
		 Assert.assertFalse(rp.validateIsEnable("Consignee"));
		 Assert.assertFalse(rp.validateIsEnable("Bonded Trucker"));
		 Assert.assertFalse(rp.validateIsEnable("Chamber of Commerce"));
		 Assert.assertFalse(rp.validateIsEnable("Security"));
		 Assert.assertFalse(rp.validateIsEnable("Airline"));
		 Assert.assertFalse(rp.validateIsEnable("GHA"));
		  wm.ImplicitlyWait(driver, 2);
	}
	

	@Then("^Select more than one business line Validate for FF, CB, consolidator\\.$")
	public void select_more_than_one_business_line_Validate_for_FF_CB_consolidator() throws Throwable {
		 rp.ClickonBusinessline("Freight Forwarder");Thread.sleep(500);
		 rp.ClickonBusinessline("Customs Broker");Thread.sleep(500);
		 rp.ClickonBusinessline("Consolidator");Thread.sleep(500);
		 System.out.println("completed ********select_more_than_one_business_line_Validate_for_FF_CB_consolidator");
	}

	
	@Then("^validate remaining business line should be disabled if FF, CB, consolidator\\. is selected$")
	public void validate_remaining_business_line_should_be_disabled_if_FF_CB_consolidator_is_selected() throws Throwable {
		Thread.sleep(2000);
		System.out.println(rp.validateIsEnable("Shipper"));
		 Assert.assertFalse(rp.validateIsEnable("Shipper"));
		System.out.println(rp.validateIsEnable("Trucking Co"));
		 Assert.assertFalse(rp.validateIsEnable("Trucking Co"));
		 Assert.assertFalse(rp.validateIsEnable("Consignee"));
		 Assert.assertFalse(rp.validateIsEnable("Bonded Trucker"));
		 Assert.assertFalse(rp.validateIsEnable("Chamber of Commerce"));
		 Assert.assertFalse(rp.validateIsEnable("Security"));
		 Assert.assertFalse(rp.validateIsEnable("Airline"));
		 Assert.assertFalse(rp.validateIsEnable("GHA"));
		  wm.ImplicitlyWait(driver, 2);  
		 System.out.println("completed ********validate_remaining_business_line_should_be_disabled_if_FF_CB_consolidator_is_selected");
	}
	
	@Then("^uncheck  FF, CB, consolidator\\.$")
	public void uncheck_FF_CB_consolidator() throws Throwable {
		Thread.sleep(3000);
		 rp.ClickonBusinessline("Freight Forwarder");
		 rp.ClickonBusinessline("Customs Broker");
		 rp.ClickonBusinessline("Consolidator");
		 System.out.println("completed ********uncheck_FF_CB_consolidator");
	}
	
	@Then("^Select more than one business line Validate for FF, CB$")
	public void select_more_than_one_business_line_Validate_for_FF_CB() throws Throwable {
		Thread.sleep(8000);
		rp.ClickonBusinessline("Freight Forwarder");
		 rp.ClickonBusinessline("Customs Broker");
		 System.out.println("completed ********select_more_than_one_business_line_Validate_for_FF_CB");
	}
	
	
	@Then("^validate remaining business line should be disabled if FF, CB is selected$")
	public void validate_remaining_business_line_should_be_disabled_if_FF_CB_is_selected() throws Throwable {
			Thread.sleep(2000);
			System.out.println(rp.validateIsEnable("Shipper"));
		 Assert.assertFalse(rp.validateIsEnable("Shipper"));
		 System.out.println(rp.validateIsEnable("Trucking Co"));
		 Assert.assertFalse(rp.validateIsEnable("Trucking Co"));
		 Assert.assertFalse(rp.validateIsEnable("Consignee"));
		 Assert.assertFalse(rp.validateIsEnable("Bonded Trucker"));
		 Assert.assertFalse(rp.validateIsEnable("Chamber of Commerce"));
		 Assert.assertFalse(rp.validateIsEnable("Security"));
		 Assert.assertFalse(rp.validateIsEnable("Airline"));
		 Assert.assertFalse(rp.validateIsEnable("GHA"));
		 wm.ImplicitlyWait(driver, 2);
		 System.out.println("completed ********validate_remaining_business_line_should_be_disabled_if_FF_CB_is_selected");
	}
	
	@Then("^uncheck FF, CB$")
	public void uncheck_FF_CB() throws Throwable {
		Thread.sleep(3000);
		 rp.ClickonBusinessline("Freight Forwarder");
			Thread.sleep(3000);
		 rp.ClickonBusinessline("Customs Broker");
		 System.out.println("completed ********uncheck_FF_CB");
	}


	@Then("^Select more than one business line Validate for Shipper, consignee$")
	public void select_more_than_one_business_line_Validate_for_Shipper_consignee() throws Throwable {
		Thread.sleep(5000);
		rp.ClickonBusinessline("shipper"); Thread.sleep(5000);
	    rp.ClickonBusinessline("Consignee"); 
    	 System.out.println("completed ********select_more_than_one_business_line_Validate_for_Shipper_consignee");
	}

	
	@Then("^validate remaining business line should be disabled if Shipper, consignee is selected$")
	public void validate_remaining_business_line_should_be_disabled_if_Shipper_consignee_is_selected() throws Throwable {
		Thread.sleep(2000);
		System.out.println(rp.validateIsEnable("Trucking Co"));
		 Assert.assertFalse(rp.validateIsEnable("Trucking Co"));
		 Assert.assertFalse(rp.validateIsEnable("Bonded Trucker"));
		 Assert.assertFalse(rp.validateIsEnable("Freight Forwarder"));
		 Assert.assertFalse(rp.validateIsEnable("Customs Broker"));
		 Assert.assertFalse(rp.validateIsEnable("Chamber of Commerce"));
		 Assert.assertFalse(rp.validateIsEnable("Security"));
		 Assert.assertFalse(rp.validateIsEnable("Airline"));
		 Assert.assertFalse(rp.validateIsEnable("Consolidator"));
		  wm.ImplicitlyWait(driver, 2);System.out.println("completed ********validate_remaining_business_line_should_be_disabled_if_Shipper_consignee_is_selected");
	}
	
	@Then("^uncheck  Shipper, consignee$")
	public void uncheck__Shipper_consignee() throws Throwable {
		 rp.ClickonBusinessline("shipper");
		 rp.ClickonBusinessline("Consignee"); System.out.println("completed ********uncheck__Shipper_consignee");
	}
	
//	@135875	@BIAL_TC_04 step definition
	@Then("^Enter valid Organizationname\"([^\"]*)\"$")
	public void enter_valid_Organizationname(String arg1) throws Throwable {
	  Thread.sleep(1000);
	  String username = arg1+ "_"+cm.randomAlphabetic(2); 
	  wm.enterTextInto(driver, rp.Organization_name_textBox, username);
	}
	
	@Then("^Enter valid BusinessEmailID\"([^\"]*)\"$")
	public void enter_valid_BusinessEmailID(String arg1) throws Throwable {
	  Thread.sleep(2000);
	  wm.enterTextInto(driver, rp.Business_email_ID_textBox, arg1);
	}
	
	@Then("^Enter valid BusinessContactnumber\"([^\"]*)\"$")
	public void enter_valid_BusinessContactnumber(String arg1) throws Throwable {
	    wm.enterTextInto(driver, rp.BusinessContact_textBox, arg1);
	}
	
	@Then("^Enter valid Streetaddress(\\d+)\"([^\"]*)\"$")
	public void enter_valid_Streetaddress(int arg1, String arg2) throws Throwable {
	 wm.enterTextInto(driver, rp.Streetaddress1_textbox, arg2);
	  wm.ImplicitlyWait(driver, 2);
	}
	
	@Then("^Enter valid Citycode\"([^\"]*)\"$")
	public void enter_valid_Citycode(String arg1) throws Throwable {
		Thread.sleep(1000);
		wm.enterTextInto(driver,  rp.CityCode_textbox, arg1);
	}
	
	@Then("^Enter valid Statecode\"([^\"]*)\"$")
	public void enter_valid_Statecode(String arg1) throws Throwable {
		Thread.sleep(1000);
	    wm.enterTextInto(driver,   rp.StateCode_textbox, arg1);
	   
	}
	
	@Then("^Enter valid Countrycode\"([^\"]*)\"$")
	public void enter_valid_Countrycode(String arg1) throws Throwable {
	    rp.CountryCode_textbox.sendKeys(arg1);
	    wm.ImplicitlyWait(driver, 2);
	}
	
	@Then("^Enter valid Zip\"([^\"]*)\"$")
	public void enter_valid_Zip(String arg1) throws Throwable {
		Thread.sleep(2000);
		rp.Zip_textbox.click();
	   rp.Zip_textbox.sendKeys(arg1);
	   wm.ImplicitlyWait(driver, 2);
	}
	
	@Then("^Enter valid Username\"([^\"]*)\"$")
	public void enter_valid_Username(String arg1) throws Throwable {
		Thread.sleep(1000);
		String username = arg1+ "_"+cm.randomAlphabetic(4);
	    wm.enterTextInto(driver,  rp.Username_textbox, username);
	    wm.ImplicitlyWait(driver, 2);
	}
	
	@Then("^Enter valid Firstname\"([^\"]*)\"$")
	public void enter_valid_Firstname(String arg1) throws Throwable {
	
		wm.enterTextInto(driver, rp.Firstname, arg1);
		  wm.ImplicitlyWait(driver, 2);
	}
	
	@Then("^Enter valid Lastname\"([^\"]*)\"$")
	public void enter_valid_Lastname(String arg1) throws Throwable {
	    wm.enterTextInto(driver,  rp.LastName, arg1);
	    wm.ImplicitlyWait(driver, 2);
		wm.scrolldownUsingJSE(driver, "400");
		Thread.sleep(1000);  
	}
	
	
	@Then("^Enter EmailID and mobile number \"([^\"]*)\"\"([^\"]*)\"$")
	public void enter_EmailID_and_mobile_number(String arg1, String arg2) throws Throwable {
	  wm.enterTextInto(driver, rp.EmailID, arg1);
	  wm.enterTextInto(driver, rp.ContactNumber, arg2);
	}
	@Then("^Select\"([^\"]*)\"option from the drop down option for Freight Forwarder business line$")
	public void select_option_from_the_drop_down_option_for_Freight_Forwarder_business_line(String arg1) throws Throwable {	    
		wm.selectDropDownElementByVisibleText(driver, rp.GSTRegistrationStatus, arg1);
	    wm.ImplicitlyWait(driver, 2);
	}
	@Then("^Enter valid\"([^\"]*)\"of GST details section$")
	public void enter_valid_of_GST_details_section(String arg1) throws Throwable {
		wm.enterTextInto(driver, rp.GSTStateCode, arg1); 
		Thread.sleep(2000);
	}
	@Then("^Enter valid\"([^\"]*)\"value$")
	public void enter_valid_value(String arg1) throws Throwable {
		Thread.sleep(2000); 
//		wm.enterTextInto(driver, rp.GSTIN, arg1);
		wm.enterTextInto(driver, rp.GSTIN, 	cm.GSTIN() );
	   Thread.sleep(1000);
	}
	
	@Then("^Validate Registration is complete$")
	public void validate_Registration_is_complete() throws Throwable {
	    System.out.println("*********validation is pending ");
	    wm.VisibilityOfElementExplicityWait(driver,  rp.registrationSuccessMsg, 50);
	    boolean ch=  rp.registrationSuccessMsg.isDisplayed();
	    cm.Verify(ch, true);
	    
	    for(int i=0; i<3;i++) {
	    	  if(ch==false) {
	    		  wm.ClickUsingJSExecutor(driver,  rp.SubmitBtn);
	    		  System.out.println("click on submit btn:"+i);
	    		  wm.VisibilityOfElementExplicityWait(driver,  rp.registrationSuccessMsg, 50);
		    	  ch= rp.registrationSuccessMsg.isDisplayed();
		    }else {
		    	break;
		    }
	    }
//	    Assert.assertTrue(ch);
//	    rp.closeBtn.click();
	}
	

	@Given("^for_FreightForwarder_businessline Click on Select Document Type drop down as\"([^\"]*)\"$")
	public void for_FreightForwarder_businessline_click_on_Select_Document_Type_drop_down_as(String arg1) throws Throwable {
		wm.scrolldownUsingJSE(driver, "400");
	   wm.selectDropDownElementByVisibleText(driver,rp.UploadDoc_SelectDocumentType, "IATA Registration Certificate");
//	   rp.BrowseBtn.sendKeys("E:\\documents for BIAL\\sample1.PNG"); 
	   rp.BrowseBtn.sendKeys(UploadFilePath1); 
	   wm.ImplicitlyWait(driver, 2);
	   rp.UploadBtn.click();
	   Thread.sleep(5000);
	   wm.ImplicitlyWait(driver, 2);
	   wm.selectDropDownElementByVisibleText(driver, rp.UploadDoc_SelectDocumentType, "Organization registration certificate");
	   rp.BrowseBtn.sendKeys(UploadFilePath2);
	   wm.ImplicitlyWait(driver, 2);
	   rp.UploadBtn.click();
	   Thread.sleep(5000);
	   wm.ImplicitlyWait(driver, 2);
	}
	
	@Then("^Check the check box of Terms and Conditions$")
	public void check_the_check_box_of_Terms_and_Conditions() throws Throwable {
		wm.scrolldownUsingJSE(driver, "600");
	    rp.CheckBox_TermCondtn.click();
	    wm.ImplicitlyWait(driver, 2); Thread.sleep(2000);
	}
	
	@Then("^Click on Submit$")
	public void click_on_Submit() throws Throwable {
		rp.SubmitBtn.click();
		wm.VisibilityOfElementExplicityWait(driver,  rp.registrationSuccessMsg, 50);
	}
	
	
	@When("^Enter valid IATA registration number$")
	public void Enter_valid_IATA_registration_number() throws Throwable {
		  Thread.sleep(1000);
		  wm.enterTextInto(driver, rp.IATA_RegistrationNo, "1234567"); 
		  Thread.sleep(2000);
	}
	
	@When("^Select IATA Registration Date from the calendar icon$")
	public void Select_IATA_Registration_Date_from_the_calendar_icon() throws Throwable {
//		Thread.sleep(1000);  wm.scrolldown(driver,rp.cover ); 
		String date1 = cm.SpecificDate1("dd MM yyyy", -5);  System.out.println(date1+"******");
		rp.SelectDate(rp.IATA_RegistrationDate, date1);
	}	
	@Then("^Enter valid CASS no$")
	public void Enter_valid_CASS_no() throws Throwable {
//		its optional
//		rp.IATA_CASS.sendKeys(keysToSend);
	}


//	@135875	@BIAL_TC_05 step definition
	@When("^Check the Trucking Co\\. check box of Business line$")
	public void check_the_Trucking_Co_check_box_of_Business_line() throws Throwable {
	    rp.ClickonBusinessline("Trucking Co");
	    Thread.sleep(4000);
	}


	@Then("^Select\"([^\"]*)\"option from the drop down option for Trucking Co$")
	public void select_option_from_the_drop_down_option_for_Trucking_Co(String arg1) throws Throwable {
		wm.selectDropDownElementByVisibleText(driver, rp.GSTRegistrationStatus, arg1);
	    wm.ImplicitlyWait(driver, 2);
	}
	
	@Given("^for_Trucking_Co_businessline Click on Select Document Type drop down as\"([^\"]*)\" for Trucking Co$")
	public void for_Trucking_Co_businessline_Click_on_Select_Document_Type_drop_down_as_for_Trucking_Co(String arg1) throws Throwable {
		 wm.selectDropDownElementByVisibleText(driver,rp.UploadDoc_SelectDocumentType, "Organization registration certificate");
		   rp.BrowseBtn.sendKeys(UploadFilePath1);
		   wm.ImplicitlyWait(driver, 2);
		   rp.UploadBtn.click();
		   Thread.sleep(5000);
		   wm.ImplicitlyWait(driver, 2);
	}
	
	
//	@135875	@BIAL_TC_06 step definition

	
	@When("^Check the Customer Broker check box of Business line$")
	public void check_the_Customer_Broker_check_box_of_Business_line() throws Throwable {
		 rp.ClickonBusinessline("Customs Broker");
		    Thread.sleep(4000);
	}
	
	@Then("^Select\"([^\"]*)\"option from the drop down option for Customer Broker$")
	public void select_option_from_the_drop_down_option_for_Customer_Broker(String arg1) throws Throwable {
		wm.selectDropDownElementByVisibleText(driver, rp.GSTRegistrationStatus, arg1);
	    wm.ImplicitlyWait(driver, 2);
	}
	
	@Then("^Enter valid Customs Broker License Number whichis PAN Based$")
	public void enter_valid_Customs_Broker_License_Number_whichis_PAN_Based() throws Throwable {
		String var = cm.randomAlphanumeric(10) ;
	    wm.enterTextInto(driver, rp.customsBrokerLicenseNo, var);
	}
	
	@Then("^Select License Expiry Date from the calendar icon$")
	public void select_License_Expiry_Date_from_the_calendar_icon() throws Throwable {
		Thread.sleep(1000); //		wm.scrolldown(driver,rp.LicenseExpiryDate ); //wm.scrolldown(driver,rp.cover ); 
		String date1 = cm.SpecificDate1("dd MM yyyy", 65); System.out.println(date1+"******");
		rp.SelectDate(rp.LicenseExpiryDate, date1);
		Thread.sleep(4000);
	}
	
	@Then("^Select LicenseExpiry Date from the calendar icon$")
	public void select_LicenseExpiry_Date_from_the_calendar_icon() throws Throwable {
		Thread.sleep(1000);
		wm.scrolldown(driver,rp.cover ); 
		rp.LicenseExpiryDate.click();
		rp.checkdate(rp.CleanderSelectedDateTextList, 11);
		Thread.sleep(4000);		
	}

		@Given("^for_Customer_Broker_businessline Click on Select Document Type drop down as\"([^\"]*)\"$")
		public void for_Customer_Broker_businessline_Click_on_Select_Document_Type_drop_down_as(String arg1) throws Throwable {
			wm.scrolldownUsingJSE(driver, "400");
			 wm.selectDropDownElementByVisibleText(driver,rp.UploadDoc_SelectDocumentType, "Customs Broker License");
			   rp.BrowseBtn.sendKeys(UploadFilePath3);
			   wm.ImplicitlyWait(driver, 2);
			   Thread.sleep(1000);
			   rp.UploadBtn.click();
			   Thread.sleep(5000);
			   wm.ImplicitlyWait(driver, 2);
			   
			   wm.selectDropDownElementByVisibleText(driver,rp.UploadDoc_SelectDocumentType, "Organization registration certificate");
			   rp.BrowseBtn.sendKeys(UploadFilePath2);
			   wm.ImplicitlyWait(driver, 2);
			   Thread.sleep(1000);
			   rp.UploadBtn.click();
			   Thread.sleep(5000);
			   wm.ImplicitlyWait(driver, 2);
		}
	
	
//		@135875	@BIAL_TC_07 step definition
		
		@When("^Check\"([^\"]*)\"check box of Business line$")
		public void check_check_box_of_Business_line(String arg1) throws Throwable {
			 
			rp.ClickonBusinessline(arg1);
			    Thread.sleep(4000);
		}
		@Then("^Enter AirlineDetails$")
		public void enter_AirlineDetails() throws Throwable {
		   wm.enterTextInto(driver, rp.CarrierRegistrationNumber, cm.randomAlphanumeric(10));
		   Thread.sleep(1000);
		   
			String date1 = cm.SpecificDate1("dd MM yyyy", 1);
			rp.SelectDate(rp.ForAirline_IATARegistrationExpiryDate, date1);
			Thread.sleep(4000);
			System.out.println(date1+"****** ForAirline_IATARegistrationExpiryDate");
		
		   wm.enterTextInto(driver, rp.AirlinePrefix, "777");
		   Thread.sleep(1000);
		   wm.enterTextInto(driver, rp.ICAO_CarrierCode, cm.randomAlphanumeric(3));
		   Thread.sleep(1000);
		   wm.enterTextInto(driver, rp.IATA_CarrierCode, cm.randomAlphanumeric(2));
		   Thread.sleep(1000);
			
		}
		
		@Given("^for_Airline_businessline Click on Select Document Type drop down as\"([^\"]*)\" for Trucking Co$")
		public void for_airline_businessline_Click_on_Select_Document_Type_drop_down_as_for_Trucking_Co(String arg1) throws Throwable {
		       wm.selectDropDownElementByVisibleText(driver,rp.UploadDoc_SelectDocumentType, "Airline Registration Certificate");
			   rp.BrowseBtn.sendKeys(UploadFilePath1);
			   wm.ImplicitlyWait(driver, 2);
			   Thread.sleep(1000);
			   rp.UploadBtn.click();
			   Thread.sleep(5000);
			   wm.ImplicitlyWait(driver, 2);
		}

//		@135875	@BIAL_TC_08 step definition
		@Then("^Consolidator Registration Details__$")
		public void consolidator_Registration_Details__() throws Throwable {
		    wm.enterTextInto(driver, rp.CRN_Number, cm.randomAlphanumeric(10));
		    wm.scrolldownUsingJSE(driver, "400");
			String date1 = cm.SpecificDate1("dd MM yyyy",-15);
			rp.SelectDate(rp.CRN_ExpiryDate.get(0), date1);
			Thread.sleep(4000); System.out.println(date1+"****** consolidator_Registration_Details");
		}
		
		@Then("^Consolidator Registration Details$")
		public void consolidator_Registration_Details() throws Throwable {
		    wm.enterTextInto(driver, rp.CRN_Number, cm.randomAlphanumeric(10));
		    wm.scrolldownUsingJSE(driver, "400");
			String date1 =  cm.SpecificDate1("dd MM yyyy", 45); //"25 March 2021";
			rp.SelectDate(rp.CRN_ExpiryDate.get(2), date1);
			Thread.sleep(4000); System.out.println(date1+"****** consolidator_Registration_Details");
		}
		
		@Then("^for BIAL_TC_27 Consolidator Registration Details$")
		public void for_BIAL_TC_27_consolidator_Registration_Details_() throws Throwable {
		    wm.enterTextInto(driver, rp.CRN_Number, cm.randomAlphanumeric(10));
		    wm.scrolldownUsingJSE(driver, "400");
			String date1 = cm.SpecificDate1("dd MM yyyy",-15);
			rp.SelectDate(rp.CRN_ExpiryDate.get(1), date1);
			Thread.sleep(4000); System.out.println(date1+"****** consolidator_Registration_Details");
		}
		
		@Given("^for_Consolidator_businessline Click on Select Document Type drop down as\"([^\"]*)\"$")
		public void for_consolidator_businessline_Click_on_Select_Document_Type_drop_down_as(String arg1) throws Throwable {
			wm.scrolldownUsingJSE(driver, "400");
			 wm.selectDropDownElementByVisibleText(driver,rp.UploadDoc_SelectDocumentType, "Organization registration certificate");
			   rp.BrowseBtn.sendKeys(UploadFilePath2);
			   wm.ImplicitlyWait(driver, 2);
			   Thread.sleep(1000);
			   rp.UploadBtn.click();
			   Thread.sleep(5000);
			   wm.ImplicitlyWait(driver, 2);
			   
			   wm.selectDropDownElementByVisibleText(driver,rp.UploadDoc_SelectDocumentType, "Consol Registration Certificate");
			   rp.BrowseBtn.sendKeys(UploadFilePath4);
			   wm.ImplicitlyWait(driver, 2);
			   Thread.sleep(1000);
			   rp.UploadBtn.click();
			   Thread.sleep(5000);
			   wm.ImplicitlyWait(driver, 2);
			   
		}
		
//		@135875	@BIAL_TC_09 step definition
		@Then("^Security Registration Details$")
		public void security_Registration_Details() throws Throwable {
		   wm.enterTextInto(driver, rp.RA_LicenseNumber, cm.randomAlphanumeric(10));
		   String date1 = cm.SpecificDate1("dd MM yyyy",1);
			rp.SelectDate(rp.RA_LicenseExpiryDate, date1);
			Thread.sleep(4000);
			System.out.println(date1+"****** security_Registration_Details");
		}
		
		@Given("^for_Security_businessline Click on Select Document Type drop down as\"([^\"]*)\" for Trucking Co$")
		public void for_security_businessline_Click_on_Select_Document_Type_drop_down_as_for_Trucking_Co(String arg1) throws Throwable {
			wm.scrolldownUsingJSE(driver, "600");
			wm.selectDropDownElementByVisibleText(driver,rp.UploadDoc_SelectDocumentType, "RA License");
			   rp.BrowseBtn.sendKeys(UploadFilePath1);
			   wm.ImplicitlyWait(driver, 2);
			   Thread.sleep(1000);
			   rp.UploadBtn.click();
			   Thread.sleep(8000);
			  
			   wm.selectDropDownElementByVisibleText(driver,rp.UploadDoc_SelectDocumentType, "Organization registration certificate");
			   rp.BrowseBtn.sendKeys(UploadFilePath2);
			   wm.ImplicitlyWait(driver, 2);
			   Thread.sleep(1000);
			   rp.UploadBtn.click();
			   Thread.sleep(5000);
			   wm.ImplicitlyWait(driver, 2);
		}

//			#@135875	@BIAL_TC_10 step definition
		
		
		@Then("^Shipper Registration Details$")
		public void shipper_Registration_Details() throws Throwable {
		  wm.enterTextInto(driver, rp.IECode, cm.randomAlphanumeric(10));
		  wm.enterTextInto(driver, rp.AuthorizedDealerCode, cm.randomAlphanumeric(10));
		}

		@Given("^for_Shipper_businessline Click on Select Document Type drop down as\"([^\"]*)\"$")
		public void for_shipper_businessline_Click_on_Select_Document_Type_drop_down_as(String arg1) throws Throwable {
			wm.scrolldownUsingJSE(driver, "1200");
			wm.selectDropDownElementByVisibleText(driver, rp.UploadDoc_SelectDocumentType, "Organization registration certificate");
			   rp.BrowseBtn.sendKeys(UploadFilePath1);
			   wm.ImplicitlyWait(driver, 2);
			   Thread.sleep(1000);
			   rp.UploadBtn.click();
			   Thread.sleep(8000);  
		}

		
//		@135875	@BIAL_TC_11	step definition
		
		@Then("^Consignee Registration Details$")
		public void Consignees_Registration_Details() throws Throwable {
		  wm.enterTextInto(driver, rp.IECode1, cm.randomAlphanumeric(10));
		  wm.enterTextInto(driver, rp.AuthorizedDealerCode1, cm.randomAlphanumeric(10));
		}

		@Given("^for_Consignee_businessline Click on Select Document Type drop down as\"([^\"]*)\"$")
		public void for_Consignee_businessline_Click_on_Select_Document_Type_drop_down_as(String arg1) throws Throwable {
			wm.scrolldownUsingJSE(driver, "1200");
			wm.selectDropDownElementByVisibleText(driver, rp.UploadDoc_SelectDocumentType, "Organization registration certificate");
			   rp.BrowseBtn.sendKeys(UploadFilePath2);
			   wm.ImplicitlyWait(driver, 2);
			   Thread.sleep(1000);
			   rp.UploadBtn.click();
			   Thread.sleep(8000);
		}
		
		
//		@135875	@BIAL_TC_12	step definition
		@Given("^for_GHA_businessline Click on Select Document Type drop down as\"([^\"]*)\" for Trucking Co$")
		public void for_GHA_businessline_Click_on_Select_Document_Type_drop_down_as_for_Trucking_Co(String arg1) throws Throwable {
			wm.scrolldownUsingJSE(driver, "1200");
			wm.selectDropDownElementByVisibleText(driver, rp.UploadDoc_SelectDocumentType, "Organization registration certificate");
			   rp.BrowseBtn.sendKeys(UploadFilePath1);
			   wm.ImplicitlyWait(driver, 2);
			   Thread.sleep(1000);
			   rp.UploadBtn.click();
			   Thread.sleep(8000); 
		}
		
		
//		@135875	@BIAL_TC_13	step definition
		@Given("^Enter Bonded Trucker Registration Details$")
		public void Enter_Bonded_Trucker_Registration_Details() throws Throwable {
		  wm.enterTextInto(driver, rp.BondedTruckingLicenseNo, cm.randomAlphanumeric(10));
		  String date1 = cm.SpecificDate1("dd MM yyyy", 1);
			rp.SelectDate(rp.ExpiryDate, date1);
			Thread.sleep(4000);
			System.out.println(date1+"****** security_Registration_Details");
		}
		
		@Given("^for_BondedTrucker_businessline Click on Select Document Type drop down as\"([^\"]*)\" for Trucking Co$")
		public void for_BondedTrucker_businessline_Click_on_Select_Document_Type_drop_down_as_for_Trucking_Co(String arg1) throws Throwable {
			wm.scrolldownUsingJSE(driver, "1200");
			wm.selectDropDownElementByVisibleText(driver, rp.UploadDoc_SelectDocumentType, "Organization registration certificate");
			   rp.BrowseBtn.sendKeys(UploadFilePath1);
			   wm.ImplicitlyWait(driver, 2);
			   Thread.sleep(1000);
			   rp.UploadBtn.click();
			   Thread.sleep(8000);
			   wm.selectDropDownElementByVisibleText(driver, rp.UploadDoc_SelectDocumentType, "Customs Certificate");
			   rp.BrowseBtn.sendKeys(UploadFilePath2);
			   wm.ImplicitlyWait(driver, 2);
			   Thread.sleep(1000);
			   rp.UploadBtn.click();
			   Thread.sleep(8000);
		}
		
		

//@135875	@BIAL_TC_14	 step definition
		
		@Given("^Enter Chamber of Commerce Registration Details$")
		public void Enter_Chamber_of_Commerce_Registration_Details() throws Throwable {
		  wm.enterTextInto(driver, rp.RegistrationNo, cm.randomAlphanumeric(10));
		}
		
		@Given("^for_ChamberOfCommerce_businessline Click on Select Document Type drop down as\"([^\"]*)\" for Trucking Co$")
		public void for_ChamberOfCommerce_businessline_Click_on_Select_Document_Type_drop_down_as_for_Trucking_Co(String arg1) throws Throwable {
			wm.scrolldownUsingJSE(driver, "1200");
			wm.selectDropDownElementByVisibleText(driver, rp.UploadDoc_SelectDocumentType, "Organization registration certificate");
			   rp.BrowseBtn.sendKeys(UploadFilePath1);
			   wm.ImplicitlyWait(driver, 2);
			   Thread.sleep(1000);
			   rp.UploadBtn.click();
			   Thread.sleep(8000);
			
			   
			   wm.selectDropDownElementByVisibleText(driver, rp.UploadDoc_SelectDocumentType, "Authority Letter");
			   rp.BrowseBtn.sendKeys(UploadFilePath2);
			   wm.ImplicitlyWait(driver, 2);
			   Thread.sleep(1000);
			   rp.UploadBtn.click();
			   Thread.sleep(8000);
			   
			   
			   wm.selectDropDownElementByVisibleText(driver, rp.UploadDoc_SelectDocumentType, "Indemnity Document Format");
			   rp.BrowseBtn.sendKeys(UploadFilePath3);
			   wm.ImplicitlyWait(driver, 2);
			   Thread.sleep(1000);
			   rp.UploadBtn.click();
			   Thread.sleep(8000);
		}
		
		
		

//@126709	@BIAL_TC_15	step definition
		@Then("^Validate whether the system allows the user to register by keeping mandatory fields blank$")
		public void Validate_whether_the_system_allows_the_user_to_register_by_keeping_mandatory_fields_blank() throws Throwable {
			 Assert.assertTrue(rp.Organization_name.isDisplayed());
			 Assert.assertTrue(rp.EmailIDrequired.isDisplayed());
			 Assert.assertTrue(rp.ContactnumberisRequired.isDisplayed());
			 Assert.assertTrue(rp.StreetaddressRequired.isDisplayed());
			 Assert.assertTrue(rp.ZipcodeRequired.isDisplayed());
			 Assert.assertTrue(rp.UsernameRequired.isDisplayed());
		}

		//@135875	@BIAL_TC_16	step definition
		@Then("^Click on backBtn$")
		public void click_on_backBtn() throws Throwable {
			wm.scrolldownUsingJSE(driver, "2000");
		   rp.BackBtn.click();
		   Thread.sleep(8000);
		}
		
		@Then("^Validate whether the system gets navigated back to login screen after clicking on Back button$")
		public void validate_whether_the_system_gets_navigated_back_to_login_screen_after_clicking_on_Back_button() throws Throwable {
			boolean validate = hp.NewRegistrationtext.isDisplayed(); 
			Assert.assertTrue(validate);
			boolean validate1 = hp.NewRegistrationhyperLink.isDisplayed(); 
			Assert.assertTrue(validate1);
		}
		
//		@135875	@BIAL_TC_17	step definition

		@Then("^Click on Terms and Conditions hyperlink$")
		public void click_on_Terms_and_Conditions_hyperlink() throws Throwable {
			wm.scrolldownUsingJSE(driver, "2000");
			rp.TermAndCondn.click();
		}
		
		@When("^Switch to next tab$")
		public void switch_to_next_tab() throws Throwable {
		    wm.switchToChildBrowserTab(driver);
		    Thread.sleep(5000);
		}
		
		@Then("^Click on every single menu to view the information about the Terms and Conditions$")
		public void click_on_every_single_menu_to_view_the_information_about_the_Terms_and_Conditions() throws Throwable {
			wm.isElementPresent(driver, tc.Preface);
			wm.isElementPresent(driver, tc.Introduction);
			wm.isElementPresent(driver, tc.Revision_of_Terms_Conditions);
			wm.isElementPresent(driver, tc.Registration);
			wm.isElementPresent(driver, tc.FeesPayments);
			wm.isElementPresent(driver, tc.ScopeofServices);
			wm.isElementPresent(driver, tc.UsageofSystem);
		}
		
//		@135875	@BIAL_TC_18	
		@When("^Click on LoginBtn$")
		public void click_on_LoginBtn() throws Throwable {
			login.Login_Btn.click();
		}
		@Then("^Validate login error message is displayed$")
		public void validate_login_error_message_is_displayed() throws Throwable {
			Assert.assertTrue(login.EmptyUsername_errorMsg.isDisplayed());
			Assert.assertTrue(login.EmptyPassword_errorMsg.isDisplayed());
		}
//		@135875	@BIAL_TC_19 step definition 
		
		@Then("^Validate alert message is displayed for unchecked term and condition cb$")
		public void validate_alert_message_is_displayed_for_unchecked_term_and_condition_cb() throws Throwable {
			Thread.sleep(2000);
			Assert.assertTrue(rp.Alertmsg_termNcondnCB.isDisplayed());
		}
		
//		#@135875	@BIAL_TC_20	step definition
		@When("^Login in Bial application for ACS_Registration TC$")
		public void login_in_Bial_application_for_ACS_Registration_TC() throws Throwable {
			login.Login(KaleACSUsername, KaleACSPassword);
		}
		
		@Then("^Clickon Registration >> Received Request$")
		public void clickon_Registration_Received_Request() throws Throwable {
			Thread.sleep(5000);
			wm.mouseHover(driver, registMangmt.RegistrationManagement, registMangmt.ReceivedRequest);
		}
		
		@Then("^Filter Organization Startswith KaleAutomation$")
		public void filter_Organization_Startswith_KaleAutomation() throws Throwable {
		    co.ColheaderFilter(driver, co.ColFilterIconList, co.ColHeaderNameList, co.searchbar, "Organization", "kaleautomation");
		}
		
		@Then("^Click on requested organization name$")
		public void click_on_requested_organization_name() throws Throwable {
			Thread.sleep(10000);
			registMangmt.firsrowcell.click();
		}
		
		@Then("^Click on Approve Btn$")
		public void click_on_Approve_Btn() throws Throwable {
			Thread.sleep(3000);
		  wm.scrolldownUsingJSE(driver, "2000");
		  wm.ClickUsingJSExecutor(driver, registMangmt.approveBtn);
		}
//@135875	@BIAL_TC_21	step definition
		@Then("^Click on Reject Btn$")
		public void click_on_Reject_Btn() throws Throwable {
			Thread.sleep(3000);
			  wm.scrolldownUsingJSE(driver, "2000");
			  wm.ClickUsingJSExecutor(driver, registMangmt.rejectBtn);
		}
		
		@Then("^Enter reason for rejection$")
		public void enter_reason_for_rejection() throws Throwable {
		    wm.enterTextInto(driver, registMangmt.reasonTextBx, "reject as per automation testcase");
		}
		
		@Then("^Clickon saveBtn$")
		public void clickon_saveBtn() throws Throwable {
		    wm.ClickUsingJSExecutor(driver, registMangmt.saveBtn);
		}

//#@135875	@BIAL_TC_26	step definition

		@Then("^validate FF CB consolidator are checked$")
		public void validate_FF_CB_consolidator_are_checked() throws Throwable {
			 Assert.assertTrue(rp.isChecked("Freight Forwarder"));
			 Assert.assertTrue(rp.isChecked("Customs Broker"));
			 Assert.assertTrue(rp.isChecked("Consolidator"));
		}

//#@135875	@BIAL_TC_27	step definition
		@Then("^validate Customs Broker and Consolidator are selected$")
		public void validate_Customs_Broker_and_Consolidator_are_selected() throws Throwable {
			 Assert.assertTrue(rp.isChecked("Customs Broker"));
			 Assert.assertTrue(rp.isChecked("Consolidator"));
		}
//#@135875	@BIAL_TC_28	step definition

		@Then("^validate shipper and consignee are checked$")
		public void validate_shipper_and_consignee_are_checked() throws Throwable {
			 Assert.assertTrue(rp.isChecked("shipper"));
			 Assert.assertTrue(rp.isChecked("Consignee"));
			 
		}
		
		
		@Then("^unable to automate as we donot automate mail$")
		public void unable_to_automate_as_we_donot_automate_mail() throws Throwable {
			
		}
}
