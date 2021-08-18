package StepDefinitions;

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
import Pages.eAWB.CreateAWBPage;
import Pages.eAWB.HouseManifestPage;
import Pages.eAWB.MawbListPage;
import Pages.eBooking.BookingShipmentPage;
import Pages.eBooking.CreatePage;
import Pages.eBooking.DraftsPage;
import Pages.eBooking.SavedPage;
import Pages.eBooking.SentPage;
import Pages.eBooking.TemplatesPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_eBooking {
	public WebDriver driver;
	public Setup launch;
	public WebdriverMethods wm;
	public CommonMethods cm;
	
	public LoginPage login;
	public BialMenu menu;

	
	public CreatePage createJob;
	public SavedPage savedJob;
	public SentPage sentJob;
	public DraftsPage draft;
	public TemplatesPage template;
	public BookingShipmentPage bookingShipment;
	public CreateAWBPage createAwb;
	public HouseManifestPage createHawb;
	public MawbListPage mawbList;
	
	String randomNo = null;
	public boolean verify = false;
	String ConfigKeysFile = "Config_Keys.properties";
	String geckoDriverPath = null, URL = null, AgentUsername = null, AgentPassword = null;
	String DownloadPath = null, DownloadFile = null, eDocketUploadFile = null;
	String CompanyName = null, ieNo = null, ShipperEmailId = null, ShipperAddressLine1 = null;
	String ConsigneeName = null, ConsigneeEmailId = null, ConsigneeAddressLine1 = null, unNo = null, Cls = null;
	String DraftName = null, TemplateName = null;
	String UrnNo = null, ShipperName = null, OriginCode = null, DestinationCode = null;
	String scheduleForDate = null, awbNo = null, flightNo = null;
	String hawbNo = null;
	
	@Given("^Launch Browser and Bial application link for e-Booking screen$")
	public void launch_Browser_and_Bial_application_link_for_e_Booking_screen() throws Throwable {
		File file = new File(ConfigKeysFile);
		InputStream fis = new FileInputStream(file);
		Properties pf = new Properties();
		pf.load(fis);
		
		geckoDriverPath = pf.getProperty("GeckodriverPath");
//		URL = pf.getProperty("URL");
		URL = pf.getProperty("STGLink");
		AgentUsername = pf.getProperty("agentUsername");
		AgentPassword = pf.getProperty("agentPassword");
		DownloadPath = pf.getProperty("DownloadPath");
		eDocketUploadFile = pf.getProperty("eDocketFilePath");
		
		launch = new Setup();
		driver = launch.LaunchFirefox(geckoDriverPath, DownloadPath, URL);
		
		wm = new WebdriverMethods(driver);
		cm = new CommonMethods();
		
		login = new LoginPage(driver);
		menu = new BialMenu(driver, wm);
		
		createJob = new CreatePage(driver, wm);
		savedJob = new SavedPage(driver, wm);
		sentJob = new SentPage(driver, wm);
		draft = new DraftsPage(driver, wm);
		template = new TemplatesPage(driver, wm);
		bookingShipment = new BookingShipmentPage(driver, wm, cm);
		createAwb = new CreateAWBPage(driver, wm, cm);
		mawbList = new MawbListPage(driver, wm,cm);
		createHawb = new HouseManifestPage(driver, wm, cm);
	}

	@When("^Login in Bial application for e-Booking screen$")
	public void login_in_Bial_application_for_e_Booking_screen() throws Throwable {
		login.Login(AgentUsername, AgentPassword);
	}

	@Then("^Verify Navigated to Home screen for e-Booking screen$")
	public void verify_Navigated_to_Home_screen_for_e_Booking_screen() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, menu.MenuBar, 20);
	    verify = wm.isElementPresent(driver, menu.MenuBar);
	    cm.Verify(verify, true);
	}

	@Given("^Navigated to Create screen of e-Booking$")
	public void navigated_to_Create_screen_of_e_Booking() throws Throwable {
		wm.ImplicitlyWait(driver, 5); Thread.sleep(5000);
		menu.MainMenuHover("e-Booking");Thread.sleep(5000);
		menu.ClickOnSubMenu("Create");
		wm.VisibilityOfElementExplicityWait(driver, createJob.CreateScreen, 15);
	}

	@When("^Select \"([^\"]*)\" \"([^\"]*)\" for e-Booking$")
	public void select_for_e_Booking(String selectValue, String fieldName) throws Throwable {
		createJob.SelectValue(fieldName, selectValue);
	}

	@Then("^Verify \"([^\"]*)\" already entered in \"([^\"]*)\" field for e-Booking$")
	public void verify_already_entered_in_field_for_e_Booking(String value, String fieldName) throws Throwable {
	    verify = wm.isElementAttributeValueContain(driver, createJob.OriginCode_DD, "value", value);
	    cm.Verify(verify, true);
	}

	@When("^Enter \"([^\"]*)\" \"([^\"]*)\" for e-Booking$")
	public void enter_for_e_Booking(String selectValue, String fieldName) throws Throwable {
		createJob.SelectValue(fieldName, selectValue);
	}

	@Then("^\"([^\"]*)\" is get populated with correct value for e-Booking$")
	public void is_get_populated_with_correct_value_for_e_Booking(String arg1) throws Throwable {
	    
	}

	@When("^Click on \"([^\"]*)\" icon of (\\d+) rate line for e-Booking$")
	public void click_on_icon_of_rate_line_for_e_Booking(String iconName, int rowNo) throws Throwable {
	    createJob.ClickOnCargoDetailsIcon(iconName, rowNo);
	}

	@Then("^Dimensions popup is opened for e-Booking$")
	public void dimensions_popup_is_opened_for_e_Booking() throws Throwable {
	    verify = wm.isElementPresent(driver, createJob.DimesionsPopup);
//	    cm.Verify(verify, true);
	}

	@When("^Enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" of (\\d+) dimension row for e-Booking$")
	public void enter_and_and_and_of_dimension_row_for_e_Booking(String noOfPcs, String length, String width, String height, int rowNo) throws Throwable {
	   Thread.sleep(1000); createJob.AddDimensions(noOfPcs, length, width, height, rowNo);
	 
	}
	
	@When("^Enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" of (\\d+) dimensionss row for e-Booking$")
	public void enter_and_and_and_of_dimensionss_row_for_e_Booking(String noOfPcs, String length, String width, String height, int rowNo) throws Throwable {
		createAwb.anAddDimensions(noOfPcs, length, width, height, rowNo);
		createAwb.clickOnBtn("Dimensions Ok");
	}

	
      
	@Then("^Volume field get popluated on the base of entered dimension of (\\d+) dimension row for e-Booking$")
	public void volume_field_get_popluated_on_the_base_of_entered_dimension_of_dimension_row_for_e_Booking(int arg1) throws Throwable {
	    
	}

	@When("^Click on \"([^\"]*)\" Dimension button for e-Booking$")
	public void click_on_Dimension_button_for_e_Booking(String buttonName) throws Throwable {
		createJob.CLickOnDimesnionsButton(buttonName);
	}

	@Then("^Dimension get save and No of Pcs field get populated of (\\d+) rate line for e-Booking$")
	public void dimension_get_save_and_No_of_Pcs_field_get_populated_of_rate_line_for_e_Booking(int rowNo) throws Throwable {
	    
	}

	@When("^Enter \"([^\"]*)\" and \"([^\"]*)\" of (\\d+) rate line for e-Booking$")
	public void enter_and_of_rate_line_for_e_Booking(String grWt, String cargoDescription, int rowNo) throws Throwable {
		createJob.AddRateLine(grWt, cargoDescription, rowNo);
	}

	@Then("^Chargeable Weight is get populated of (\\d+) rate line for e-Booking$")
	public void chargeable_Weight_is_get_populated_of_rate_line_for_e_Booking(int arg1) throws Throwable {
		
	}

	@When("^Click on \"([^\"]*)\" Job button for e-Booking$")
	public void click_on_Job_button_for_e_Booking(String buttonName) throws Throwable {
//		wm.scrolldownUsingJSE(driver, "50");
		createJob.CLickOnButton(buttonName);
	}

	@Then("^Success popup opened and \"([^\"]*)\" message displayed$")
	public void success_popup_opened_and_message_displayed(String ElementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createJob.SuccessPopup, 20);
		verify = wm.isElementPresent(driver, createJob.SuccessPopup); System.out.println("createJob.SuccessPopup:"+createJob.SuccessPopup.getText());
		cm.Verify(verify, true);  System.out.println("createJob.SuccessPopupText:"+createJob.SuccessPopupText.getText());
		verify = wm.isElementTextContain(driver, createJob.SuccessPopupText, ElementText);
		cm.Verify(verify, true);
	}

	@When("^Click \"([^\"]*)\" Success popup button for e-Booking$")
	public void click_Success_popup_button_for_e_Booking(String buttonName) throws Throwable {
		createJob.ClickOnSuccessPopupButton(buttonName);
	}

	@Then("^Navigated Saved screen of e-Booking and created job in the job list$")
	public void navigated_Saved_screen_of_e_Booking_and_created_job_in_the_job_list() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, savedJob.SavedScreen, 20);
//	    Thread.sleep(2000);
		verify = wm.isElementPresent(driver, savedJob.SavedScreen);
	    cm.Verify(verify, true);
	    Thread.sleep(1000);
	}

	@Then("^Able to see gnerated \"([^\"]*)\" and \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" \"([^\"]*)\" for e-Booking$")
	public void able_to_see_gnerated_and_and_and_and_for_e_Booking(String fieldName1, String shipperName, String fieldName2, String destCode, String fieldName3, String grWt, String fieldName4, String status, String fieldName5) throws Throwable {
	    verify = wm.isElementTextContain(driver, savedJob.SavedJobShipperColList.get(0), shipperName);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, savedJob.SavedJobDestinationColList.get(0), destCode);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, savedJob.SavedJobGrossWtColList.get(0), grWt);
//	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, savedJob.SavedJobStatusColList.get(0), status);
	    cm.Verify(verify, true);
	}
	
	
	
	
	@When("^Click on \"([^\"]*)\" sample excel data button for e-Booking$")
	public void click_on_sample_excel_data_button_for_e_Booking(String buttonName) throws Throwable {
	    createJob.CLickOnButton(buttonName);
	}

	@Then("^Sample excel data file get downloaded in the local directory for e-Booking$")
	public void sample_excel_data_file_get_downloaded_in_the_local_directory_for_e_Booking() throws Throwable {
	    DownloadFile = DownloadPath + "Sample_File_Format.xls";
	    verify = cm.isFileDownloaded(DownloadFile);
	    cm.Verify(verify, true);
	}

	@When("^Choose file from the local directory for e-Booking$")
	public void choose_file_from_the_local_directory_for_e_Booking() throws Throwable {
		DownloadFile = DownloadPath + "Sample_File_Format.xls";
	    createJob.ChooseFileForUpload(DownloadFile);
	}

	@When("^Click on \"([^\"]*)\" button to choose file for e-Booking$")
	public void click_on_button_to_choose_file_for_e_Booking(String buttonName) throws Throwable {
	    createJob.CLickOnButton(buttonName);
	}

	@Then("^All mandatory field get populated with data from the excel file for e-Booking$")
	public void all_mandatory_field_get_populated_with_data_from_the_excel_file_for_e_Booking() throws Throwable {
	   wm.VisibilityOfElementExplicityWait(driver, createJob.ShipperName_DD, 10); wm.ImplicitlyWait(driver, 5);
	    verify = wm.isElementAttributeValueEmpty(driver, createJob.ShipperName_DD, "value");
	    cm.Verify(verify, false);
	}

	@Then("^Able to see gnerated \"([^\"]*)\" and \"([^\"]*)\" \"([^\"]*)\" for e-Booking$")
	public void able_to_see_gnerated_and_for_e_Booking(String fieldName1, String status, String fieldName2) throws Throwable {
//		verify = wm.isElementTextContain(driver, savedJob.SavedJobStatusColList.get(0), status);
//	    cm.Verify(verify, true);
	}
	
	@When("^Click on \"([^\"]*)\" icon of (\\d+) add dimension for e-Bookng$")
	public void click_on_icon_of_add_dimension_for_e_Bookng(String iconName, int rowNo) throws Throwable {
		createJob.ClickOnDimensionsIcon(iconName, rowNo);
	}

	@Then("^Dimension Row get added for e-Booking$")
	public void dimension_Row_get_added_for_e_Booking() throws Throwable {
		verify = createJob.isDimesionsRowAdded();
		cm.Verify(verify, true);
	}
	@Then("^Rate line row get added in e-Booking$")
	public void rate_line_row_get_added_in_e_Booking() throws Throwable {
		verify = createJob.isRateLineRowAdded();
		cm.Verify(verify, true);
	}
	@Then("^Unable to create a job and \"([^\"]*)\" error message displayed$")
	public void unable_to_create_a_job_and_error_message_displayed(String ElementText) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createJob.ErrorMsg, 20);
	    verify = wm.isElementTextContain(driver, createJob.ErrorMsg, ElementText);
	}
	@When("^Click on plus icon of add \"([^\"]*)\" for e-Booking$")
	public void click_on_plus_icon_of_add_for_e_Booking(String shipperOrConsignee) throws Throwable {
	    Thread.sleep(2000); 
		createJob.ClickOnPlusIcon(shipperOrConsignee);
	}
	@Then("^Add Shipper popup opened for e-Booking$")
	public void add_Shipper_popup_opened_for_e_Booking() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createJob.AddShipperPopup, 15);
	    verify = wm.isElementPresent(driver, createJob.AddShipperPopup);
	    cm.Verify(verify, true);
	    driver.switchTo().frame(createJob.AddShipperPopupFrame);  Thread.sleep(1000);
	  
	}

	@When("^Enter \"([^\"]*)\" and IE no and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" on Add Shipper for e-Booking$")
	public void enter_and_IE_no_and_and_and_and_and_on_Add_Shipper_for_e_Booking(String companyName, String emailId, String addressLine1, String zipCode, String country, String city) throws Throwable {
	    randomNo = cm.RandomNo(3);
	    CompanyName = companyName+" "+randomNo;
	    ieNo = cm.RandomNo(10);
	    ShipperEmailId = emailId + randomNo + "@gmail.com";
	    ShipperAddressLine1 = addressLine1 + " " + randomNo;
	    
	    createJob.AddShipperDetails(CompanyName, ieNo, ShipperEmailId, ShipperAddressLine1, zipCode, country, city);
	}

	@When("^CLick on \"([^\"]*)\" button for save shipper details of Add Shipper for e-Booking$")
	public void click_on_button_for_save_shipper_details_of_Add_Shipper_for_e_Booking(String buttonName) throws Throwable {
	    createJob.ClickOnAddShipperButton(buttonName);
	}

	@Then("^Shipper details get saved and \"([^\"]*)\" message dispalyed$")
	public void shipper_details_get_saved_and_message_dispalyed(String ElementText) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createJob.ShipperSavedMsg, 10);
	    verify = wm.isElementTextContain(driver, createJob.ShipperSavedMsg, ElementText);
	    cm.Verify(verify, true);
	    
	    driver.switchTo().defaultContent();
	    Thread.sleep(1000);
	}

	@When("^Click on \"([^\"]*)\" button of Add Shipper for e-Booking$")
	public void click_on_button_of_Add_Shipper_for_e_Booking(String buttonName) throws Throwable {
	    createJob.ClickOnAddShipperButton(buttonName);
	}

	@Then("^Add Shipper popup will closed and shipper name and address field get populated$")
	public void add_Shipper_popup_will_closed_and_shipper_name_and_address_field_get_populated() throws Throwable {
		
	}

	@Then("^Add Consignee popup opened for e-Booking$")
	public void add_Consignee_popup_opened_for_e_Booking() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createJob.AddConsigneePopup, 20); Thread.sleep(1000);
	    verify = wm.isElementPresent(driver, createJob.AddConsigneePopup);
	    cm.Verify(verify, true);
	    
	    driver.switchTo().frame(createJob.AddConsigneePopupFrame);
	    Thread.sleep(1000);
	}

	@When("^Enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" on Add Consignee for e-Booking$")
	public void enter_and_and_and_and_and_on_Add_Consignee_for_e_Booking(String consigneeName, String emailId, String addressLine1, String zipCode, String country, String city) throws Throwable {
		randomNo = cm.RandomNo(3);
	    ConsigneeName = consigneeName+" "+randomNo;
	    ConsigneeEmailId = emailId + randomNo + "@gmail.com";
	    ConsigneeAddressLine1 = addressLine1 + " " + randomNo;
	    
	    createJob.AddConsigneeDetails(ConsigneeName, ConsigneeEmailId, ConsigneeAddressLine1, zipCode, country, city);
	}

	@When("^CLick on \"([^\"]*)\" button for save Consignee details of Add Consignee for e-Booking$")
	public void click_on_button_for_save_Consignee_details_of_Add_Consignee_for_e_Booking(String buttonName) throws Throwable {
	    createJob.ClickOnAddConsigneeButton(buttonName);
	}

	@Then("^Consignee details get saved and \"([^\"]*)\" message dispalyed$")
	public void consignee_details_get_saved_and_message_dispalyed(String ElementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createJob.ConsigneeSavedMsg, 10);
	    verify = wm.isElementTextContain(driver, createJob.ConsigneeSavedMsg, ElementText);
	    cm.Verify(verify, true);
	    
	    driver.switchTo().defaultContent();
	    Thread.sleep(1000);
	}

	@When("^Click on \"([^\"]*)\" button of Add Consignee for e-Booking$")
	public void click_on_button_of_Add_Consignee_for_e_Booking(String buttonName) throws Throwable {
		createJob.ClickOnAddConsigneeButton(buttonName);
	}

	@Then("^Add Consignee popup will closed and Consignee name and address field get populated$")
	public void add_Consignee_popup_will_closed_and_Consignee_name_and_address_field_get_populated() throws Throwable {
	    
	}
	
	
	@Then("^Consignee details not saved and \"([^\"]*)\" error message dispalyed$")
	public void consignee_details_not_saved_and_error_message_dispalyed(String ElementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createJob.ConsigneeErrorMsg, 10);
	    verify = wm.isElementTextContain(driver, createJob.ConsigneeErrorMsg, ElementText);
	    cm.Verify(verify, true);
	    
	    driver.switchTo().defaultContent();
	    Thread.sleep(1000);
	}
	
	
	
	@When("^Enter \"([^\"]*)\" and \"([^\"]*)\" and select Hazardous and enter UN no and \"([^\"]*)\" and select \"([^\"]*)\" (\\d+) rate line for e-Booking$")
	public void enter_and_and_select_Hazardous_and_enter_UN_no_and_and_select_rate_line_for_e_Booking(String grWt, String cargoDesciption, String Class, String packingGroup, int rwoNo) throws Throwable {
	    unNo = cm.RandomNo(4);
	    Cls = Class +" "+ cm.RandomNo(2);
		createJob.AddRateLine(grWt, cargoDesciption, unNo, Cls, packingGroup, rwoNo);
	}
	
	
	@When("^Check custom broker and select \"([^\"]*)\" for e-Booking$")
	public void check_custom_broker_and_select_for_e_Booking(String customBroker) throws Throwable {
	    createJob.SelectCustomBroker(customBroker);
	}
	
	
	
	
	@Then("^Draft Name popup opened for e-Booking$")
	public void draft_Name_popup_opened_for_e_Booking() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createJob.DraftNamePopup, 10);
	    verify = wm.isElementPresent(driver, createJob.DraftNamePopup);
	    cm.Verify(verify, true);
	}

	@When("^Enter \"([^\"]*)\" on Draft Name popup for e-Booking$")
	public void enter_on_Draft_Name_popup_for_e_Booking(String draftName) throws Throwable {
		DraftName = draftName+cm.RandomNo(3);
	    createJob.EnterDraftName(DraftName);
	}

	@When("^Click on \"([^\"]*)\" draft name button for e-Booking$")
	public void click_on_draft_name_button_for_e_Booking(String buttonName) throws Throwable {
	    createJob.ClickOnDraftNameButton(buttonName);
	}
	
	@Then("^Navigated Draft screen of e-Booking and Booking Status popup displayed$")
	public void navigated_Draft_screen_of_e_Booking_and_Booking_Status_popup_displayed() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, draft.BookingStatusPopup, 20);
	    verify = wm.isElementPresent(driver, draft.BookingStatusPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, draft.BookingStatusPopupMsg, "Draft has been saved successfully.");
	    cm.Verify(verify, true);
	    Thread.sleep(500);
	    
	    draft.ClickOnBookingStatusPopupButton("Ok");
	    Thread.sleep(3000);
	    
		verify = wm.isElementPresent(driver, draft.DraftScreen);
	    cm.Verify(verify, true);
	    Thread.sleep(500);
	}

	@Then("^Template popup opened for e-Booking$")
	public void template_popup_opened_for_e_Booking() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createJob.TemplatePopup, 20);
	    verify = wm.isElementPresent(driver, createJob.TemplatePopup);
	    cm.Verify(verify, true);
	    Thread.sleep(500);
	}

	@When("^Enter \"([^\"]*)\" on Template popup for e-Booking$")
	public void enter_on_Template_popup_for_e_Booking(String templateName) throws Throwable {
	    TemplateName = templateName+cm.RandomNo(3);
	    createJob.EnterTemplateName(TemplateName);
	}

	@When("^Click on \"([^\"]*)\" Template button for e-Booking$")
	public void click_on_Template_button_for_e_Booking(String buttonName) throws Throwable {
	    createJob.ClickOnTemplateButton(buttonName);
	}

	@Then("^Navigated Template screen of e-Booking and Booking Status popup displayed$")
	public void navigated_Template_screen_of_e_Booking_and_Booking_Status_popup_displayed() throws Throwable {
		Thread.sleep(2000);
	    wm.VisibilityOfElementExplicityWait(driver, template.BookingStatusPopup, 15);
	    verify = wm.isElementPresent(driver, template.BookingStatusPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, template.BookingStatusMsg, "Booking Template '"+TemplateName+"' has been saved successfully.");
	    cm.Verify(verify, true);
	    Thread.sleep(500);
	    
	    template.ClickOnBookingStatusPopupButton("Ok");
	    Thread.sleep(3000);
	}

	@When("^Click on \"([^\"]*)\" button for e-Booking$")
	public void click_on_button_for_e_Booking(String buttonName) throws Throwable {
	    createJob.CLickOnButton(buttonName);
	}

	@Then("^Verify user should be able to view 'Create Job' guide\\.$")
	public void verify_user_should_be_able_to_view_Create_Job_guide() throws Throwable {
	    
	}
	
	
	
	
	@Given("^Navigated to Saved screen of e-Booking$")
	public void navigated_to_Saved_screen_of_e_Booking() throws Throwable {
		menu.MainMenuHover("e-Booking");
		menu.ClickOnSubMenu("Saved");
		wm.VisibilityOfElementExplicityWait(driver, savedJob.SavedScreen, 20);
	}

	@When("^Click on (\\d+) \"([^\"]*)\" in job grid for e-Booking$")
	public void click_on_in_job_grid_for_e_Booking(int rowNo, String iconName) throws Throwable {
	    UrnNo = savedJob.SavedJobUrnColList.get(rowNo-1).getText();
	    ShipperName = savedJob.SavedJobShipperColList.get(rowNo-1).getText();
	    OriginCode = savedJob.SavedJobOriginColList.get(rowNo-1).getText();
	    DestinationCode = savedJob.SavedJobDestinationColList.get(rowNo-1).getText();
		savedJob.ClickOnIcon(iconName, rowNo);
	}

	@Then("^Navigated Create Job screen to see all the details of job in the field which are disabled and also all button also disabled$")
	public void navigated_Create_Job_screen_to_see_all_the_details_of_job_in_the_field_which_are_disabled_and_also_all_button_also_disabled() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createJob.CreateScreen, 20);
	    verify = wm.isElementPresent(driver, createJob.CreateScreen);
	    cm.Verify(verify, true);
	    verify = wm.isElementAttributeValueContain(driver, createJob.ShipperName_DD, "value", ShipperName);
		cm.Verify(verify, true);
		verify = wm.isElementAttributeValueContain(driver, createJob.OriginCode_DD, "value", OriginCode);
		cm.Verify(verify, true);
		verify = wm.isElementAttributeValueContain(driver, createJob.DestinationCode_DD, "value", DestinationCode);
		cm.Verify(verify, true);
	}

	@Then("^Navigated to Create Job screen poulated all field with of that job for e-Booking$")
	public void navigated_to_Create_Job_screen_poulated_all_field_with_of_that_job_for_e_Booking() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createJob.CreateScreen, 20);
	    verify = wm.isElementPresent(driver, createJob.CreateScreen);
	    cm.Verify(verify, true);
//	    verify = wm.isElementAttributeValueContain(driver, createJob.ShipperName_DD, "value", ShipperName);
//		cm.Verify(verify, true);
//		verify = wm.isElementAttributeValueContain(driver, createJob.OriginCode_DD, "value", OriginCode);
//		cm.Verify(verify, true);
//		verify = wm.isElementAttributeValueContain(driver, createJob.DestinationCode_DD, "value", DestinationCode);
//		cm.Verify(verify, true);
	}

	@Then("^Able to see gnerated URN and \"([^\"]*)\" Status for e-Booking$")
	public void able_to_see_gnerated_URN_and_Status_for_e_Booking(String status) throws Throwable {
//		verify = wm.isElementTextContain(driver, savedJob.SavedJobShipperColList.get(0), ShipperName);
//	    cm.Verify(verify, true);
//	    verify = wm.isElementTextContain(driver, savedJob.SavedJobDestinationColList.get(0), DestinationCode);
//	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, savedJob.SavedJobStatusColList.get(0), status);
	    cm.Verify(verify, true);
	}

	@Then("^e-Docket popup opened for e-Booking$")
	public void e_Docket_popup_opened_for_e_Booking() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, savedJob.eDocketPopup, 10);
	    verify = wm.isElementPresent(driver, savedJob.eDocketPopup);
	    cm.Verify(verify, true);
	    driver.switchTo().frame(savedJob.eDocketPopupFrame);
		Thread.sleep(500);
	}

	@When("^Select \"([^\"]*)\" and choose file from local directory of (\\d+) row for e-Booking$")
	public void select_and_choose_file_from_local_directory_of_row_for_e_Booking(String documentType, int rowNo) throws Throwable {
	    savedJob.eDocketDocumentUpload(documentType, eDocketUploadFile, rowNo);
	}

	@Then("^Document get uploaded and document details displayed in document grid for e-Booking$")
	public void document_get_uploaded_and_document_details_displayed_in_document_grid_for_e_Booking() throws Throwable {
	    Thread.sleep(1000);
	    verify = wm.isElementPresent(driver, savedJob.DocumentUploadedGrid);
	    cm.Verify(verify, true);
	    driver.switchTo().defaultContent();
	    Thread.sleep(500);
	}
	
	@When("^CLick on \"([^\"]*)\" eDocket button for e-Booking$")
	public void click_on_eDocket_button_for_e_Booking(String buttonName) throws Throwable {
		savedJob.ClickOn_eDocketButtons(buttonName);
	}
//	@When("^Click on \"([^\"]*)\" eDocket button for e-Booking$")
//	public void click_on_eDocket_button_for_e_Booking(String buttonName) throws Throwable {
//	    savedJob.ClickOn_eDocketButtons(buttonName);
//	}

	@Then("^e-Docket popup is closed and job gird visible for e-Booking$")
	public void e_Docket_popup_is_closed_and_job_gird_visible_for_e_Booking() throws Throwable {
	    
	}
	
	
	
	@When("^Select (\\d+) Job in saved job gird for e-Booking$")
	public void select_Job_in_saved_job_gird_for_e_Booking(int rowNo) throws Throwable {
	    savedJob.SelectJob(rowNo);
	}

	@When("^Click on \"([^\"]*)\" in Saved page for e-Booking$")
	public void click_on_in_Saved_page_for_e_Booking(String buttonName) throws Throwable {
	    savedJob.ClickOnButton(buttonName);
	}

	@Then("^Navigated to Booking Shipment screen and Shipment type popup opened for e-Booking$")
	public void navigated_to_Booking_Shipment_screen_and_Shipment_type_popup_opened_for_e_Booking() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, bookingShipment.ShipmentTypePopup, 15);
	    verify = wm.isElementPresent(driver, bookingShipment.ShipmentTypePopup);
	    cm.Verify(verify, true);
	}
	
	@When("^Search \"([^\"]*)\" \"([^\"]*)\" of on saved screen for e-Booking$")
	public void search_of_on_saved_screen_for_e_Booking(String filterValue, String fieldName) throws Throwable {
	    savedJob.Filter(fieldName, filterValue, "Equals");
	    Thread.sleep(2000);
	}
	
	@Then("^Navigated HAWB View screen and able to see the hawb job details for e-Booking$")
	public void navigated_HAWB_View_screen_and_able_to_see_the_hawb_job_details_for_e_Booking() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, savedJob.HawbViewGrid, 15);
	    verify = wm.isElementPresent(driver, savedJob.HawbViewGrid);
	    cm.Verify(verify, true);
//	    verify = wm.isElementTextContain(driver, savedJob.HawbViewMawbNoLinkColList.get(0), awbNo);
//	    cm.Verify(verify, true);
//	    verify = wm.isElementTextContain(driver, savedJob.HawbViewHawbNoLinkColList.get(0), hawbNo);
//	    cm.Verify(verify, true);
	}
	
	@Then("^Navigated to MAWB view screen and able to see mawb job details for e-Booking$")
	public void navigated_to_MAWB_view_screen_and_able_to_see_mawb_job_details_for_e_Booking() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, savedJob.HawbViewGrid, 15);
	    verify = wm.isElementPresent(driver, savedJob.HawbViewGrid);
	    cm.Verify(verify, true);
//	    verify = wm.isElementTextContain(driver, savedJob.HawbViewMawbNoLinkColList.get(0), awbNo);
//	    cm.Verify(verify, true);
	}
	
	@Then("^Shipment type popup opened in the Boking Shipment screen for e-Booking$")
	public void shipment_type_popup_opened_in_the_Boking_Shipment_screen_for_e_Booking() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, bookingShipment.ShipmentTypePopup, 15);
	    verify = wm.isElementPresent(driver, bookingShipment.ShipmentTypePopup);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button on shipment type popup for e-Booking$")
	public void click_on_button_on_shipment_type_popup_for_e_Booking(String buttonName) throws Throwable {
	    bookingShipment.ClickOnShipmentTypePopupButton(buttonName);
	}

	@Then("^Booking shipment screen dispalyed with selected job details in grid for e-Booking$")
	public void booking_shipment_screen_dispalyed_with_selected_job_details_in_grid_for_e_Booking() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, bookingShipment.BookingShipmentScreen, 10);
	    verify = wm.isElementPresent(driver, bookingShipment.BookingShipmentScreen);
	    cm.Verify(verify, true);
	    verify = bookingShipment.isJobDetailsGridDisplayed(1);
	    cm.Verify(verify, true);
	}

	@Then("^Booking shipment screen dispalyed with selected jobs details in grid for e-Booking$")
	public void booking_shipment_screen_dispalyed_with_selected_jobs_details_in_grid_for_e_Booking() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, bookingShipment.BookingShipmentScreen, 10);
	    verify = wm.isElementPresent(driver, bookingShipment.BookingShipmentScreen);
	    cm.Verify(verify, true);
	    verify = bookingShipment.isJobDetailsGridDisplayed(2);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button on booking shipment screen for e-Booking$")
	public void click_on_button_on_booking_shipment_screen_for_e_Booking(String buttonName) throws Throwable {
	    bookingShipment.ClickOnButton(buttonName);
	}

	@Then("^Navigated to Saved Job screen for e-Booking$")
	public void navigated_to_Saved_Job_screen_for_e_Booking() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, savedJob.SavedScreen, 15);
	    verify = wm.isElementPresent(driver, savedJob.SavedScreen);
	    cm.Verify(verify, true);
	}

	@Then("^Navigated to Sent Job screen for e-Booking$")
	public void navigated_to_Sent_Job_screen_for_e_Booking() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, sentJob.SentScreen, 15);
	    verify = wm.isElementPresent(driver, sentJob.SentScreen);
	    cm.Verify(verify, true);
	}
	
	
	
	
	
	@When("^Select Airline Schedule for date for e-Booking$")
	public void select_Airline_Schedule_for_date_for_e_Booking() throws Throwable {
	    scheduleForDate = cm.CurrentDate("dd MMM yyyy");
		bookingShipment.EnterValue("Schedule For", scheduleForDate);
	}

	@Then("^Ailrine Schedule Tab is displayed on booking shipment screen for e-Booking$")
	public void ailrine_Schedule_Tab_is_displayed_on_booking_shipment_screen_for_e_Booking() throws Throwable {
	    Thread.sleep(1000);
	    wm.VisibilityOfElementExplicityWait(driver, bookingShipment.AirlineScheduleTab, 10);
	    verify = wm.isElementPresent(driver, bookingShipment.AirlineScheduleTab);
	    cm.Verify(verify, true);
	}
	
	@When("^Enter \"([^\"]*)\" and flight umber to add (\\d+) airline schedule for e-Booking$")
	public void enter_and_flight_umber_to_add_airline_schedule_for_e_Booking(String prefix, int rowNo) throws Throwable {
	    flightNo = cm.RandomNo(4);  Thread.sleep(3000);
		awbNo = bookingShipment.AddAirlineScheduleDetails(prefix, flightNo, rowNo);
	}

	@Then("^Message popup opened with \"([^\"]*)\" message on booking shipment screen for e-Booking$")
	public void message_popup_opened_with_message_on_booking_shipment_screen_for_e_Booking(String ElementText) throws Throwable {
	    Thread.sleep(2000); wm.VisibilityOfElementExplicityWait(driver, bookingShipment.MessagePopup, 10);
	    verify = wm.isElementPresent(driver, bookingShipment.MessagePopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, bookingShipment.MessagePopupText, ElementText);
	    cm.Verify(verify, true);
	    Thread.sleep(2000); wm.ImplicitlyWait(driver, 5);
	}

	@When("^Click on \"([^\"]*)\" button on Message popup for e-Booking$")
	public void click_on_button_on_Message_popup_for_e_Booking(String buttonName) throws Throwable {
		Thread.sleep(3000);	    bookingShipment.ClickOnMessagePopupButton(buttonName);
	}

	@Then("^Booking Status popup opened with \"([^\"]*)\" message for e-Booking$")
	public void booking_Status_popup_opened_with_message_for_e_Booking(String ElementText) throws Throwable {
		Thread.sleep(2000); wm.VisibilityOfElementExplicityWait(driver, bookingShipment.BookingStatusPopup, 15);
	    verify = wm.isElementPresent(driver, bookingShipment.BookingStatusPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, bookingShipment.BookingStatusText, ElementText);
//	    cm.Verify(verify, true);
	}
	
	@Then("^Hawb Booking Status popup opened with \"([^\"]*)\" message for e-Booking$")
	public void hawb_Booking_Status_popup_opened_with_message_for_e_Booking(String ElementText) throws Throwable {
		Thread.sleep(2000); wm.VisibilityOfElementExplicityWait(driver, bookingShipment.BookingStatusPopup2, 15);
	    verify = wm.isElementPresent(driver, bookingShipment.BookingStatusPopup2);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, bookingShipment.BookingStatus2Text, ElementText);
//	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button on Booking status poup for e-Booking$")
	public void click_on_button_on_Booking_status_poup_for_e_Booking(String buttonName) throws Throwable {
		bookingShipment.ClickOnBookingStatusPopupButton(buttonName);
	}
	
	@When("^Click on \"([^\"]*)\" button on hawb Booking status poup for e-Booking$")
	public void click_on_button_on_hawb_Booking_status_poup_for_e_Booking(String buttonName) throws Throwable {
		bookingShipment.ClickOnBookingStatusPopup2Button(buttonName);
	}

	@Then("^Navigated to Sent job screen and able to Save flight details in the sent job grid for e-Booking$")
	public void navigated_to_Sent_job_screen_and_able_to_Save_flight_details_in_the_sent_job_grid_for_e_Booking() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, sentJob.SentScreen, 20);
	    verify = wm.isElementPresent(driver, sentJob.SentScreen);
	    cm.Verify(verify, true);
	}
	
	@When("^Enter \"([^\"]*)\" and \"([^\"]*)\" and flight number to add (\\d+) airline schedule for e-Booking$")
	public void enter_and_and_flight_number_to_add_airline_schedule_for_e_Booking(String prefix, String awbNo, int rowNo) throws Throwable {
		flightNo = cm.RandomNo(4);
		bookingShipment.AddAirlineScheduleDetails(prefix, awbNo, flightNo, rowNo);
	}

	@Then("^Message popup opened with \"([^\"]*)\" message for e-Booking$")
	public void message_popup_opened_with_message_for_e_Booking(String ElementText) throws Throwable {
	    Thread.sleep(1000);
	    verify = wm.isElementTextContain(driver, bookingShipment.MessagePopupMsgText, ElementText);
	    cm.Verify(verify, true);
	}

	@Then("^Message popup is closed and flight details not saved for e-Booking$")
	public void message_popup_is_closed_and_flight_details_not_saved_for_e_Booking() throws Throwable {
	    
	}
	
	@Then("^Job get saved and same details populated in the create job screen for e-Booking$")
	public void job_get_saved_and_same_details_populated_in_the_create_job_screen_for_e_Booking() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createJob.CreateScreen, 20);
	    verify = wm.isElementPresent(driver, createJob.CreateScreen);
	    cm.Verify(verify, true);
	    verify = wm.isElementAttributeValueEmpty(driver, createJob.ShipperName_DD, "value");
	    cm.Verify(verify, false);
	    verify = wm.isElementAttributeValueEmpty(driver, createJob.ConsigneeName_DD, "value");
	    cm.Verify(verify, false);
	    verify = wm.isElementAttributeValueEmpty(driver, createJob.DestinationCode_DD, "value");
	    cm.Verify(verify, false);
	}

	@Then("^Navigated to Create MAWB screen and able to see added hawb details for e-Booking$")
	public void navigated_to_Create_MAWB_screen_and_able_to_see_added_hawb_details_for_e_Booking() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createAwb.CreateAwbScreen, 15);
	    verify = wm.isElementPresent(driver, createAwb.CreateAwbScreen);
	    cm.Verify(verify, true);
	    verify = wm.isElementAttributeValueEmpty(driver, createAwb.TxtShipperName, "value");
	    cm.Verify(verify, false);
	    verify = wm.isElementAttributeValueEmpty(driver, createAwb.TxtConsigneeName, "value");
	    cm.Verify(verify, false);
	}
	
	@Then("^Navigated to Create MAWB screen and see message popup for e-Booking$")
	public void navigated_to_Create_MAWB_screen_and_see_message_popup_for_e_Booking() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createAwb.CurrentBal_MsgBox, 15);
	    verify = wm.isElementPresent(driver, createAwb.CurrentBal_MsgBox);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button on create MAWB messsage popup for e-Booking$")
	public void click_on_button_on_create_MAWB_messsage_popup_for_e_Booking(String buttonName) throws Throwable {
	    createAwb.ClickOnMessagePopupButton(buttonName);
	}

	@Then("^Create MAWB Message popup closed and able see all fields auotmatically populated from job for e-Booking$")
	public void create_MAWB_Message_popup_closed_and_able_see_all_fields_auotmatically_populated_from_job_for_e_Booking() throws Throwable {
		verify = wm.isElementPresent(driver, createAwb.CreateAwbScreen);
	    cm.Verify(verify, true);
	    verify = wm.isElementAttributeValueEmpty(driver, createAwb.TxtShipperName, "value");
	    cm.Verify(verify, false);
	    verify = wm.isElementAttributeValueEmpty(driver, createAwb.TxtConsigneeName, "value");
	    cm.Verify(verify, false);
	}

	@When("^Select \"([^\"]*)\" of (\\d+) sent job grid for e-Booking$")
	public void select_of_sent_job_grid_for_e_Booking(String actionName, int rowNo) throws Throwable {
	    sentJob.SelectAction(actionName, rowNo);
	}

	@When("^Select \"([^\"]*)\" radio button on shipment type popup for e-Booking$")
	public void select_radio_button_on_shipment_type_popup_for_e_Booking(String consolYesOrNo) throws Throwable {
	    bookingShipment.SelectShipmentType(consolYesOrNo);
	}

	@Then("^Navigated to Create HAWB screen and see message popup for e-Booking$")
	public void navigated_to_Create_HAWB_screen_and_see_message_popup_for_e_Booking() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createHawb.HouseManifestScreen, 15);
	    verify = wm.isElementPresent(driver, createHawb.HouseManifestScreen);
	    cm.Verify(verify, true);
	}

	
	@Given("^Navigated to Sent screen of e-Booking$")
	public void navigated_to_Sent_screen_of_e_Booking() throws Throwable {
		menu.MainMenuHover("e-Booking");
		menu.ClickOnSubMenu("Sent");
		wm.VisibilityOfElementExplicityWait(driver, sentJob.SentScreen, 15);
	}
	
	@When("^Enter hawb number and select \"([^\"]*)\"  and \"([^\"]*)\" and enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" amd select \"([^\"]*)\" of (\\d+) row in create HAWB for e-Booking$")
	public void enter_hawb_number_and_select_and_and_enter_and_and_and_and_amd_select_of_row_in_create_HAWB_for_e_Booking(String Shipper, 
			String Consignee, String Origin, String Destination, String NOP, String GrossWeight, String CargoDesc, String chargeCode, int rowno) throws Throwable {
		hawbNo = cm.Random_hawbNo();
//	    createHawb.AddHawbDetails(hawbNo, Shipper, Consignee, Origin, Destination, NOP, GrossWeight, CargoDesc, chargeCode, rowno);
	    createHawb.AddHawbDetails1(hawbNo, Shipper, Consignee, Origin, Destination, NOP, GrossWeight, CargoDesc, chargeCode, rowno);
	    
	    
//	    createAwb.AddHawbDetails(NOP, Shipper, Consignee, Origin, Destination, NOP, GrossWeight, CargoDesc, chargeCode, rowno);
//	    createAwb.AddHouseManifest(Shipper, Consignee, Origin, Destination, NOP, GrossWeight, currency, ChargeCode, CargoDesc, rowno);
	}

	@When("^Click on \"([^\"]*)\" button in Create HAWB screen for e-Booking$")
	public void click_on_button_in_Create_HAWB_screen_for_e_Booking(String buttonName) throws Throwable {
	    createHawb.clickOnBtn(buttonName);
	}

	@Then("^Status popup displayed on Create HAWB screen with \"([^\"]*)\" message for e-Booking$")
	public void status_popup_displayed_on_Create_HAWB_screen_with_message_for_e_Booking(String ElementText) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createHawb.StatusPopup, 15);
	    verify = wm.isElementPresent(driver, createHawb.StatusPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, createHawb.StatusPopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^CLick on \"([^\"]*)\" button of status popup on create HAWB screen for e-Booking$")
	public void click_on_button_of_status_popup_on_create_HAWB_screen_for_e_Booking(String buttonName) throws Throwable {
	    createHawb.ClickOnStatuPopupButton(buttonName);
	}

//	@When("^Select \"([^\"]*)\" on created MAWB screen for e-Booking$")
//	public void select_on_created_MAWB_screen_for_e_Booking(String selectValue) throws Throwable {
////	    createAwb.SelectValue(fieldName, selectValue);
//	}
	@When("^Select \"([^\"]*)\" \"([^\"]*)\" on created MAWB screen for e-Booking$")
	public void select_on_created_MAWB_screen_for_e_Booking(String selectValue, String fieldName) throws Throwable {
		Thread.sleep(1000);createAwb.SelectValue(fieldName, selectValue);
	}

	@When("^Select \"([^\"]*)\" and enter chargeble weight of (\\d+) rate line in create MAWB screen for e-Booking$")
	public void select_and_enter_chargeble_weight_of_rate_line_in_create_MAWB_screen_for_e_Booking(String rateClass, int rowNo) throws Throwable {
		Thread.sleep(1000);createAwb.AddRateLineDetailsForJob(rateClass, rowNo);
	}
	
	 
	@When("^FOR eBookking select RateAsAgreed checbox$")
	public void FOR_eBookking_select_RateAsAgreed_checbox() throws Throwable {
		createAwb.Checkbox_RatesAsAgreed.click();
	}

	@When("^CLick on \"([^\"]*)\" button on create MAWB for e-Booking$")
	public void click_on_button_on_create_MAWB_for_e_Booking(String buttonName) throws Throwable {
	    createAwb.clickOnBtn(buttonName);
	}

	@When("^Enter Naure of Good as\"([^\"]*)\"$")
	public void Enter_Naure_of_Good_as(String natureOfGoods) throws Throwable {
			Thread.sleep(1000);
			createAwb.CargoDetailsTextboxList.get(((1-1)*8)+6).sendKeys(natureOfGoods);
			Thread.sleep(500);
	}
	
	@Then("^Clickon Rate as agreed$")
	public void Clickon_Rate_as_agreed() throws Throwable {
		Thread.sleep(500);createAwb.RateAsAgreed_CB.click();
	}

	@Then("^Awb succesfully created and Success popup opened with \"([^\"]*)\" on create MAWB screen for e-Booking$")
	public void awb_succesfully_created_and_Success_popup_opened_with_on_create_MAWB_screen_for_e_Booking(String ElementText) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createAwb.AWBSaveWindow, 15);
	    verify = wm.isElementPresent(driver, createAwb.AWBSaveWindow);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, createAwb.AWBSaveMessage, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button in Success popup on create MAWB screen  for e-Booking$")
	public void click_on_button_in_Success_popup_on_create_MAWB_screen_for_e_Booking(String buttonName) throws Throwable {
	    createAwb.ClickOnSaveMessagePopupButton(buttonName);
	}

	@Then("^Navigated MAWB Created screen and Saved awb details visible in the (\\d+)st row for e-Booking$")
	public void navigated_MAWB_Created_screen_and_Saved_awb_details_visible_in_the_st_row_for_e_Booking(int arg1) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, mawbList.MawbListScreen, 20);
	    verify = wm.isElementPresent(driver, mawbList.MawbListScreen);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.MawbNoColList.get(0), awbNo);
	    cm.Verify(verify, true);
	}

	@Given("^Navigated to Draft screen of e-Booking$")
	public void navigated_to_Draft_screen_of_e_Booking() throws Throwable {
		menu.MainMenuHover("e-Booking");
		menu.ClickOnSubMenu("Drafts");
		wm.VisibilityOfElementExplicityWait(driver, draft.DraftScreen, 15);
	}

	@When("^Click on \"([^\"]*)\" icon of (\\d+) draft in draft screen for e-Booking$")
	public void click_on_icon_of_draft_in_draft_screen_for_e_Booking(String iconName, int rowNo) throws Throwable {
	    draft.ClickOnGridIcon(iconName, rowNo);
	}

	@Then("^Navigated to Create Job screen and all field are populated with data from the draft for e-Booking$")
	public void navigated_to_Create_Job_screen_and_all_field_are_populated_with_data_from_the_draft_for_e_Booking() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createJob.CreateScreen, 20);
	    verify = wm.isElementPresent(driver, createJob.CreateScreen);
	    cm.Verify(verify, true);
	    verify = wm.isElementAttributeValueEmpty(driver, createJob.ShipperName_DD, "value");
	    cm.Verify(verify, false);
	    verify = wm.isElementAttributeValueEmpty(driver, createJob.ConsigneeName_DD, "value");
	    cm.Verify(verify, false);
	    verify = wm.isElementAttributeValueEmpty(driver, createJob.DestinationCode_DD, "value");
	    cm.Verify(verify, false);
	}

	@When("^Edit \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" \"([^\"]*)\" on create job screen for e-Booking$")
	public void edit_and_on_create_job_screen_for_e_Booking(String shipperName, String fieldName1, 
			String destCode, String fieldName2) throws Throwable {
	    createJob.ShipperName_DD.clear();
	    Thread.sleep(500);
	    createJob.SelectValue(fieldName1, shipperName);
	    
	    createJob.DestinationCode_DD.clear();
	    Thread.sleep(500);
	    createJob.SelectValue(fieldName2, destCode);
	}

	@Then("^Booking status popup opened on draft job screen with \"([^\"]*)\" message$")
	public void booking_status_popup_opened_on_draft_job_screen_with_message(String ElementText) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, draft.BookingStatusPopup, 15);
	    verify = wm.isElementPresent(driver, draft.BookingStatusPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, draft.BookingStatusPopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Click \"([^\"]*)\" btton of Booking Status popup on draft job screeb for e-Booking$")
	public void click_btton_of_Booking_Status_popup_on_draft_job_screeb_for_e_Booking(String buttonName) throws Throwable {
	    draft.ClickOnBookingStatusPopupButton(buttonName);
	}

	@Then("^Booking status popup closed and draft job grid visibile for e-Booking$")
	public void booking_status_popup_closed_and_draft_job_grid_visibile_for_e_Booking() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, draft.DraftScreen, 15);
	    verify = wm.isElementPresent(driver, draft.DraftScreen);
	    cm.Verify(verify, true);
	}

	@Then("^Confirm popup opened on Draft job screen with \"([^\"]*)\" message for e-Booking$")
	public void confirm_popup_opened_on_Draft_job_screen_with_message_for_e_Booking(String ElementText) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, draft.ConfirmPopup, 15);
	    verify = wm.isElementPresent(driver, draft.ConfirmPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, draft.ConfirmPopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of confirm popup on draft job screen for e-Booking$")
	public void click_on_button_of_confirm_popup_on_draft_job_screen_for_e_Booking(String buttonName) throws Throwable {
	    draft.ClickOnConfirmPopupButton(buttonName);
	}

	@Then("^Message popup opened on Draft job screen with \"([^\"]*)\" message for e-Booking$")
	public void message_popup_opened_on_Draft_job_screen_with_message_for_e_Booking(String ElementText) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, draft.MessagePopup, 10);
	    verify = wm.isElementPresent(driver, draft.MessagePopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, draft.MessagePopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of message popup on draft job screen for e-Booking$")
	public void click_on_button_of_message_popup_on_draft_job_screen_for_e_Booking(String buttonName) throws Throwable {
	    draft.ClickOnMessagePopupButton(buttonName);
	}

	@Then("^Draft job is get deleted and remove from the draft job grid for e-Booking$")
	public void draft_job_is_get_deleted_and_remove_from_the_draft_job_grid_for_e_Booking() throws Throwable {
	    verify = wm.isElementPresent(driver, DraftName);
	    cm.Verify(verify, false);
	}

	@Given("^Navigated to Template screen of e-Booking$")
	public void navigated_to_Template_screen_of_e_Booking() throws Throwable {
		menu.MainMenuHover("e-Booking");
		menu.ClickOnSubMenu("e-booking Templates");
		wm.VisibilityOfElementExplicityWait(driver, template.TemplateSceen, 20);
	}

	@When("^Click on \"([^\"]*)\" icon of (\\d+) template in Template screen for e-Booking$")
	public void click_on_icon_of_template_in_Template_screen_for_e_Booking(String iconName, int rowNo) throws Throwable {
	    template.ClickOnGridIcon(iconName, rowNo);
	}

//	@When("^Click on \"([^\"]*)\" icon of (\\d+) template in template screen for e-Booking$")
//	public void click_on_icon_of_template_in_template_screen_for_e_Booking(String arg1, int arg2) throws Throwable {
//	    
//	}

	@Then("^Confirm popup opened on template job screen with \"([^\"]*)\" message for e-Booking$")
	public void confirm_popup_opened_on_template_job_screen_with_message_for_e_Booking(String ElementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, template.ConfirmPopup, 15);
	    verify = wm.isElementPresent(driver, template.ConfirmPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, template.ConfirmPopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of confirm popup on template job screen for e-Booking$")
	public void click_on_button_of_confirm_popup_on_template_job_screen_for_e_Booking(String buttonName) throws Throwable {
	    template.ClickOnConfirmPopupButton(buttonName);
	}

	@Then("^Message popup opened on template job screen with \"([^\"]*)\" message for e-Booking$")
	public void message_popup_opened_on_template_job_screen_with_message_for_e_Booking(String ElementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, template.MessagePopup, 10);
	    verify = wm.isElementPresent(driver, template.MessagePopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, template.MessagePopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of message popup on template job screen for e-Booking$")
	public void click_on_button_of_message_popup_on_template_job_screen_for_e_Booking(String buttonName) throws Throwable {
	    template.ClickOnMessagePopupButton(buttonName);
	}

	@Then("^template job is get deleted and remove from the template job grid for e-Booking$")
	public void template_job_is_get_deleted_and_remove_from_the_template_job_grid_for_e_Booking() throws Throwable {
	    verify = wm.isElementPresent(driver, TemplateName);
	    cm.Verify(verify, false);
	}
	
	
	
	
	
	@Then("^Navigated to Create Job screen and all field are populated with data from the template for e-Booking$")
	public void navigated_to_Create_Job_screen_and_all_field_are_populated_with_data_from_the_template_for_e_Booking() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createJob.CreateScreen, 20);
	    verify = wm.isElementPresent(driver, createJob.CreateScreen);
	    cm.Verify(verify, true);
	    verify = wm.isElementAttributeValueEmpty(driver, createJob.ShipperName_DD, "value");
	    cm.Verify(verify, false);
	    verify = wm.isElementAttributeValueEmpty(driver, createJob.ConsigneeName_DD, "value");
	    cm.Verify(verify, false);
	    verify = wm.isElementAttributeValueEmpty(driver, createJob.DestinationCode_DD, "value");
	    cm.Verify(verify, false);
	}

	@Then("^Booking status popup opened on template job screen with \"([^\"]*)\" message$")
	public void booking_status_popup_opened_on_template_job_screen_with_message(String elementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, template.BookingStatusPopup, 15);
	    verify = wm.isElementPresent(driver, template.BookingStatusPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, template.BookingStatusMsg, elementText);
	    cm.Verify(verify, true);
	}

	@When("^Click \"([^\"]*)\" btton of Booking Status popup on template job screen for e-Booking$")
	public void click_btton_of_Booking_Status_popup_on_template_job_screen_for_e_Booking(String buttonName) throws Throwable {
	    template.ClickOnBookingStatusPopupButton(buttonName);
	}

	@Then("^Booking status popup closed and template job grid visibile for e-Booking$")
	public void booking_status_popup_closed_and_template_job_grid_visibile_for_e_Booking() throws Throwable {
	    
	}
	
	
	
	
}
