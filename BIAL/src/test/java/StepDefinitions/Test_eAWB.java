package StepDefinitions;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import Methods.CommonMethods;
import Methods.Setup;
import Methods.WebdriverMethods;
import Pages.BialMenu;
import Pages.CO_ApprovalPage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import Pages.homepage;
import Pages.eAWB.AddConsigneePopUp;
import Pages.eAWB.AddShipperPopUp;
import Pages.eAWB.CreateAWBPage;
import Pages.eAWB.E_AWB_ListPage;
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
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class Test_eAWB {
	
	public WebDriver driver;
	public Setup launch;
	public WebdriverMethods wm;
	public CommonMethods cm;
	public RegistrationPage rp;
	public homepage home;
	public LoginPage login;
	public BialMenu menu;
	public E_AWB_ListPage eAwbListPage;
	public CreateAWBPage createAWB;
	public HouseManifestPage houseManifestPage;
	public AddShipperPopUp addShipper; 
	public AddConsigneePopUp addConsignee;
	
	public CreateAWBPage createAwb;
	public HouseManifestPage createHawb;
	public MawbListPage mawbList;
	public CreatePage createJob;
	public SavedPage savedJob;
	public SentPage sentJob;
	public DraftsPage draft;
	public TemplatesPage template;
	public BookingShipmentPage bookingShipment;
	public CO_ApprovalPage coApproval;
	
	String randomNo = null;
	public boolean verify = false;
	String ConfigKeysFile = "Config_Keys.properties";
	String geckoDriverPath = null, URL = null, DownloadFile = null,DownloadPath = null, AgentUsername = null, AgentPassword = null, tempName=null, IssuingAgent = null;
	String CompanyName = null, ieNo = null, ShipperEmailId = null, ShipperAddressLine1 = null, scheduleForDate = null;
	String ConsigneeName = null, ConsigneeEmailId = null,flightNo = null, ConsigneeAddressLine1 = null, unNo = null, Cls = null,sbDate = null,sbNo = null;
	String DraftName = null, TemplateName = null, validate = null,Prefix = null, AirlineUsername = null, AirlinePassword = null,mawb = null; 
	
	
	@Given("^Launch Browser and Bial application link for eAWB screen$")
	public void launch_Browser_and_Bial_application_link_for_eAWB_screen() throws Throwable {
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
		
		launch = new Setup();
		driver = launch.LaunchFirefox(geckoDriverPath, URL);
		
		wm = new WebdriverMethods(driver);
		cm = new CommonMethods();
		
		login = new LoginPage(driver);
		menu = new BialMenu(driver, wm);
		home = new homepage(driver, wm);
		createAWB = new CreateAWBPage(driver, wm, cm);
		eAwbListPage = new E_AWB_ListPage(driver, wm);
		houseManifestPage =  new HouseManifestPage(driver, wm, cm);
		addShipper = new AddShipperPopUp(driver, wm, cm);
		addConsignee = new AddConsigneePopUp(driver, wm, cm);
		createAwb = new CreateAWBPage(driver, wm, cm);
		mawbList = new MawbListPage(driver, wm,cm);
		createHawb = new HouseManifestPage(driver, wm, cm);
		rp = new RegistrationPage(driver, wm, cm); 
		
		createJob = new CreatePage(driver, wm);
		savedJob = new SavedPage(driver, wm);
		sentJob = new SentPage(driver, wm);
		draft = new DraftsPage(driver, wm);
		template = new TemplatesPage(driver, wm);
		bookingShipment = new BookingShipmentPage(driver, wm, cm);
		AirlineUsername = pf.getProperty("airlineUsername");
		AirlinePassword = pf.getProperty("airlinePassword");
		coApproval = new CO_ApprovalPage(driver, wm);
	}

	@When("^Login in Bial application for eAWB screen$")
	public void login_in_Bial_application_for_eAWB_screen() throws Throwable {
		login.Login(AgentUsername, AgentPassword);
	}

    @Then("^Verify Navigated to Home screen for eAWB screen$")
    public void verify_navigated_to_home_screen_for_eawb_screen() throws Throwable {
    	 wm.VisibilityOfElementExplicityWait(driver, menu.MenuBar, 20);
 	    verify = wm.isElementPresent(driver, menu.MenuBar);
 	    cm.Verify(verify, true); Thread.sleep(5000);
        
    }

    @When("^Navigate to Create AWB for eAWB screen$")
    public void navigate_to_Create_AWB_for_eAWB_screen() throws Throwable {
    	    menu.MainMenuHover("e-AWB"); 		Thread.sleep(5000);
           	menu.ClickOnSubMenu("Create AWB");	Thread.sleep(5000);
    }

    @Then("^Verify that balance amount message is displayed for eAWB screen$")
    public void verify_that_balance_amount_message_is_displayed_for_eAWB_screen() throws Throwable {
        wm.VisibilityOfElementExplicityWait(driver, createAWB.CurrentBal_MsgBox , 100);
        verify = wm.isElementPresent(driver, createAWB.CurrentBal_MsgBox);
        Assert.assertTrue(verify);   Thread.sleep(3000);
    }
    
    @Then("^Click in Ok button of message for eAWB screen$")
    public void click_in_ok_button_of_message_for_eawb_screen() throws Throwable {
        createAWB.clickOnBtn("CurrentBal_OK");
    }

    
    String awbNo = null; 
    @When("^Enter AWB prefix and AWB number for eAWB screen$")
    public void enter_AWB_prefix_and_AWB_number_for_eAWB_screen() throws Throwable {
        Thread.sleep(1000); createAWB.enter_eAWBData("Awb Prefix", "777");
//        createAWB.TxtAwbNo.sendKeys(Keys.TAB);
    	Thread.sleep(2000); awbNo = createAWB.EnterAwbNo();
        Thread.sleep(5000);
    }
    
    @When("^Enter \"([^\"]*)\" and \"([^\"]*)\" for eAWB screen$")
    public void enter_something_and_something_for_eawb_screen(String acsshipper, String acsconsigneeatl) throws Throwable {
        createAWB.enter_eAWBData("Shipper Name", acsshipper);
        Thread.sleep(2000);
        createAWB.enter_eAWBData("Consignee Name", acsconsigneeatl);
    }
    
//    @152335  step definition 
    
	@Given("^eAWB_screen Navigated to Create screen of e-Booking$")
	public void eAWB_screen_navigated_to_Create_screen_of_e_Booking() throws Throwable {
		menu.MainMenuHover("e-Booking");
		menu.ClickOnSubMenu("Create");
		wm.VisibilityOfElementExplicityWait(driver, createJob.CreateScreen, 15);
	}

	@When("^eAWB_screen Choose file from the local directory for e-Booking$")
	public void eAWB_screen_choose_file_from_the_local_directory_for_e_Booking() throws Throwable {
		DownloadFile = DownloadPath + "Sample_File_Format.xls";
	    createJob.ChooseFileForUpload(DownloadFile);
	}


	@When("^eAWB_screen Click on \"([^\"]*)\" button to choose file for e-Booking$")
	public void eAWB_screen_click_on_button_to_choose_file_for_e_Booking(String buttonName) throws Throwable {
	    createJob.CLickOnButton(buttonName);
	}


	@Then("^eAWB_screen All mandatory field get populated with data from the excel file for e-Booking$")
	public void eAWB_screen_all_mandatory_field_get_populated_with_data_from_the_excel_file_for_e_Booking() throws Throwable {
	    Thread.sleep(3000);
	    verify = wm.isElementAttributeValueEmpty(driver, createJob.ShipperName_DD, "value");
	    cm.Verify(verify, false);
	}

	@When("^eAWB_screen Click on \"([^\"]*)\" Job button for e-Booking$")
	public void eAWB_screen_click_on_Job_button_for_e_Booking(String buttonName) throws Throwable {
		createJob.CLickOnButton(buttonName);
	}

	@Then("^eAWB_screen Success popup opened and \"([^\"]*)\" message displayed$")
	public void eAWB_screen_success_popup_opened_and_message_displayed(String ElementText) throws Throwable {
		verify = wm.isElementPresent(driver, createJob.SuccessPopup);
		cm.Verify(verify, true);
		verify = wm.isElementTextContain(driver, createJob.SuccessPopupText, ElementText);
		cm.Verify(verify, true);
		Thread.sleep(3000);
	}
	@When("^eAWB_screen Click \"([^\"]*)\" Success popup button for e-Booking$")
	public void eAWB_screen_click_Success_popup_button_for_e_Booking(String buttonName) throws Throwable {
		Thread.sleep(1000);createJob.ClickOnSuccessPopupButton(buttonName);
	}

	@Then("^eAWB_screen Navigated Saved screen of e-Booking and created job in the job list$")
	public void eAWB_screen_navigated_Saved_screen_of_e_Booking_and_created_job_in_the_job_list() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, savedJob.SavedScreen, 20);
//	    Thread.sleep(2000);
		verify = wm.isElementPresent(driver, savedJob.SavedScreen);
	    cm.Verify(verify, true);
	    Thread.sleep(1000);
	}

	@Then("^eAWB_screen Able to see gnerated \"([^\"]*)\" and \"([^\"]*)\" \"([^\"]*)\" for e-Booking$")
	public void eAWB_screen_able_to_see_gnerated_and_for_e_Booking(String fieldName1, String status, String fieldName2) throws Throwable {
		verify = wm.isElementTextContain(driver, savedJob.SavedJobStatusColList.get(0), status);
	    cm.Verify(verify, true);
	}

	@When("^eAWB_screen Select (\\d+) Job in saved job gird for e-Booking$")
	public void eAWB_screen_select_Job_in_saved_job_gird_for_e_Booking(int rowNo) throws Throwable {
	    savedJob.SelectJob(rowNo);
	}

	@When("^eAWB_screen Click on \"([^\"]*)\" in Saved page for e-Booking$")
	public void eAWB_screen_click_on_in_Saved_page_for_e_Booking(String buttonName) throws Throwable {
	    savedJob.ClickOnButton(buttonName);
	}
	@Then("^eAWB_screen Shipment type popup opened in the Boking Shipment screen for e-Booking$")
	public void eAWB_screen_shipment_type_popup_opened_in_the_Boking_Shipment_screen_for_e_Booking() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, bookingShipment.ShipmentTypePopup, 15);
	    verify = wm.isElementPresent(driver, bookingShipment.ShipmentTypePopup);
	    cm.Verify(verify, true);
	}
	@When("^eAWB_screen Click on \"([^\"]*)\" button on shipment type popup for e-Booking$")
	public void eAWB_screen_click_on_button_on_shipment_type_popup_for_e_Booking(String buttonName) throws Throwable {
	    bookingShipment.ClickOnShipmentTypePopupButton(buttonName);
	}


	@Then("^eAWB_screen Booking shipment screen dispalyed with selected job details in grid for e-Booking$")
	public void eAWB_screen_booking_shipment_screen_dispalyed_with_selected_job_details_in_grid_for_e_Booking() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, bookingShipment.BookingShipmentScreen, 10);
	    verify = wm.isElementPresent(driver, bookingShipment.BookingShipmentScreen);
	    cm.Verify(verify, true);
	    verify = bookingShipment.isJobDetailsGridDisplayed(1);
	    cm.Verify(verify, true);
	}
	@When("^eAWB_screen Select Airline Schedule for date for e-Booking$")
	public void eAWB_screen_select_Airline_Schedule_for_date_for_e_Booking() throws Throwable {
	    scheduleForDate = cm.CurrentDate("dd MMM yyyy");
		bookingShipment.EnterValue("Schedule For", scheduleForDate);
	}
	@When("^eAWB_screen Click on \"([^\"]*)\" button on booking shipment screen for e-Booking$")
	public void eAWB_screen_click_on_button_on_booking_shipment_screen_for_e_Booking(String buttonName) throws Throwable {
	    bookingShipment.ClickOnButton(buttonName);
	}
	@Then("^eAWB_screen Ailrine Schedule Tab is displayed on booking shipment screen for e-Booking$")
	public void eAWB_screen_ailrine_Schedule_Tab_is_displayed_on_booking_shipment_screen_for_e_Booking() throws Throwable {
	   wm.ImplicitlyWait(driver, 10);
	    wm.VisibilityOfElementExplicityWait(driver, bookingShipment.AirlineScheduleTab, 10);
	    verify = wm.isElementPresent(driver, bookingShipment.AirlineScheduleTab);
	    cm.Verify(verify, true);
	}

	@When("^eAWB_screen Enter \"([^\"]*)\" and flight umber to add (\\d+) airline schedule for e-Booking$")
	public void eAWB_screen_enter_and_flight_umber_to_add_airline_schedule_for_e_Booking(String prefix, int rowNo) throws Throwable {
	    flightNo = cm.RandomNo(4);
		awbNo = bookingShipment.AddAirlineScheduleDetails(prefix, flightNo, rowNo);
	}


//	@When("^Click on \"([^\"]*)\" button on booking shipment screen for e-Booking$")
//	public void click_on_button_on_booking_shipment_screen_for_e_Booking(String buttonName) throws Throwable {
//	    bookingShipment.ClickOnButton(buttonName);
//	}

	@Then("^eAWB_screen Message popup opened with \"([^\"]*)\" message on booking shipment screen for e-Booking$")
	public void eAWB_screen_message_popup_opened_with_message_on_booking_shipment_screen_for_e_Booking(String ElementText) throws Throwable {
	    Thread.sleep(1000);
	    wm.VisibilityOfElementExplicityWait(driver, bookingShipment.MessagePopup, 10);
	    verify = wm.isElementPresent(driver, bookingShipment.MessagePopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, bookingShipment.MessagePopupText, ElementText);
	    cm.Verify(verify, true);
	}
	@When("^eAWB_screen Click on \"([^\"]*)\" button on Message popup for e-Booking$")
	public void eAWB_screen_click_on_button_on_Message_popup_for_e_Booking(String buttonName) throws Throwable {
	    bookingShipment.ClickOnMessagePopupButton(buttonName);
	}

	@Then("^eAWB_screen Booking Status popup opened with \"([^\"]*)\" message for e-Booking$")
	public void eAWB_screen_booking_Status_popup_opened_with_message_for_e_Booking(String ElementText) throws Throwable {
		Thread.sleep(2000);
	    wm.VisibilityOfElementExplicityWait(driver, bookingShipment.BookingStatusPopup, 15);
	    verify = wm.isElementPresent(driver, bookingShipment.BookingStatusPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, bookingShipment.BookingStatusText, ElementText);
//	    cm.Verify(verify, true);
	}


	@When("^eAWB_screen Click on \"([^\"]*)\" button on Booking status poup for e-Booking$")
	public void eAWB_screen_click_on_button_on_Booking_status_poup_for_e_Booking(String buttonName) throws Throwable {
		bookingShipment.ClickOnBookingStatusPopupButton(buttonName);
	}


	@Then("^eAWB_screen Navigated to Sent job screen and able to Save flight details in the sent job grid for e-Booking$")
	public void eAWB_screen_navigated_to_Sent_job_screen_and_able_to_Save_flight_details_in_the_sent_job_grid_for_e_Booking() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, sentJob.SentScreen, 20);
	    verify = wm.isElementPresent(driver, sentJob.SentScreen);
	    cm.Verify(verify, true);
	}


	@When("^eAWB_screen Select \"([^\"]*)\" of (\\d+) sent job grid for e-Booking$")
	public void eAWB_screen_select_of_sent_job_grid_for_e_Booking(String actionName, int rowNo) throws Throwable {
	    sentJob.SelectAction(actionName, rowNo);
	}

	@Then("^eAWB_screen Navigated to Create MAWB screen and see message popup for e-Booking$")
	public void eAWB_screen_navigated_to_Create_MAWB_screen_and_see_message_popup_for_e_Booking() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createAwb.CurrentBal_MsgBox, 15);
	    verify = wm.isElementPresent(driver, createAwb.CurrentBal_MsgBox);
	    cm.Verify(verify, true);
	}

	@When("^eAWB_screen Click on \"([^\"]*)\" button on create MAWB messsage popup for e-Booking$")
	public void eAWB_screen_click_on_button_on_create_MAWB_messsage_popup_for_e_Booking(String buttonName) throws Throwable {
	    createAwb.ClickOnMessagePopupButton(buttonName);
	}

	@Then("^eAWB_screen Create MAWB Message popup closed and able see all fields auotmatically populated from job for e-Booking$")
	public void eAWB_screen_create_MAWB_Message_popup_closed_and_able_see_all_fields_auotmatically_populated_from_job_for_e_Booking() throws Throwable {
		verify = wm.isElementPresent(driver, createAwb.CreateAwbScreen);
	    cm.Verify(verify, true);
	    verify = wm.isElementAttributeValueEmpty(driver, createAwb.TxtShipperName, "value");
	    cm.Verify(verify, false);
	    verify = wm.isElementAttributeValueEmpty(driver, createAwb.TxtConsigneeName, "value");
	    cm.Verify(verify, false);
	}

//	@When("^Select \"([^\"]*)\" \"([^\"]*)\" on created MAWB screen for e-Booking$")
//	public void select_on_created_MAWB_screen_for_e_Booking(String selectValue, String fieldName) throws Throwable {
//		createAwb.SelectValue(fieldName, selectValue);
//	}

	@When("^eAWB_screen Select \"([^\"]*)\" \"([^\"]*)\" on created MAWB screen for e-Booking$")
	public void eAWB_screen_select_on_created_MAWB_screen_for_e_Booking(String selectValue, String fieldName) throws Throwable {
		createAwb.SelectValue(fieldName, selectValue);
	}

	@When("^eAWB_screen Select \"([^\"]*)\" and enter chargeble weight of (\\d+) rate line in create MAWB screen for e-Booking$")
	public void eAWB_screen_select_and_enter_chargeble_weight_of_rate_line_in_create_MAWB_screen_for_e_Booking(String rateClass, int rowNo) throws Throwable {
	    createAwb.AddRateLineDetailsForJob(rateClass, rowNo);
	}

	@When("^eAWB_screen CLick on \"([^\"]*)\" button on create MAWB for e-Booking$")
	public void eAWB_screen_click_on_button_on_create_MAWB_for_e_Booking(String buttonName) throws Throwable {
	    createAwb.clickOnBtn(buttonName);
	}
	
	 @When("^eAWB_screen Click on RateAsAgreed$")
		public void eAWB_screen_Click_on_RateAsAgreed() throws Throwable {
		   createAwb.Checkbox_RatesAsAgreed.click();
		}
	 
	@Then("^eAWB_screen Awb succesfully created and Success popup opened with \"([^\"]*)\" on create MAWB screen for e-Booking$")
	public void eAWB_screen_awb_succesfully_created_and_Success_popup_opened_with_on_create_MAWB_screen_for_e_Booking(String ElementText) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createAwb.AWBSaveWindow, 15);
	    verify = wm.isElementPresent(driver, createAwb.AWBSaveWindow);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, createAwb.AWBSaveMessage, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^eAWB_screen Click on \"([^\"]*)\" button in Success popup on create MAWB screen  for e-Booking$")
	public void eAWB_screen_click_on_button_in_Success_popup_on_create_MAWB_screen_for_e_Booking(String buttonName) throws Throwable {
		Thread.sleep(2000);  createAwb.ClickOnSaveMessagePopupButton(buttonName);
	}

	@Then("^eAWB_screen Navigated MAWB Created screen and Saved awb details visible in the (\\d+)st row for e-Booking$")
	public void eAWB_screen_navigated_MAWB_Created_screen_and_Saved_awb_details_visible_in_the_st_row_for_e_Booking(int arg1) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, mawbList.MawbListScreen, 20);
	    verify = wm.isElementPresent(driver, mawbList.MawbListScreen);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.MawbNoColList.get(0), awbNo);
	    cm.Verify(verify, true);
	}


    
//    @152337 @Create_Direct_e-AWB step definition 
    
    @When("^Click on Routing Info button and enter Destn \"([^\"]*)\" and Via \"([^\"]*)\" and Flight No \"([^\"]*)\" for eAWB screen Create_Direct_eAWB$")
    public void click_on_routing_info_button_and_enter_destn_and_via_and_flight_no_for_eawb_screen_Create_Direct_eAWB(String DestnPort, String Via_1, String FlightNo) throws Throwable {
    	
//        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnRoutingInfo);
        wm.scrolldownUsingJSE(driver, "400");
        Thread.sleep(1000);
    	createAWB.clickOnBtn("Routing Info");
        wm.VisibilityOfElementExplicityWait(driver, createAWB.RoutingDetailsWindow, 10);
        verify = wm.isElementPresent(driver, createAWB.RoutingDetailsWindow);
        Assert.assertTrue(verify);
        Thread.sleep(3000);

        createAWB.enter_eAWBData("Destn Port", DestnPort);
        Thread.sleep(1000);
        createAWB.enter_eAWBData("Via_1", Via_1);
        Thread.sleep(1000);
        createAWB.clickOnBtn("Routing Window Ok");
        Thread.sleep(2000);
        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdChargeCode);
        Thread.sleep(1000);
        Select selectChargeCode = new Select(createAWB.DdChargeCode);
        selectChargeCode.selectByIndex(1);
        Thread.sleep(1000);
        createAWB.enter_eAWBData("Flight No", FlightNo);
        
        createAWB.DdCustomsBroker.click();
        Thread.sleep(1000);
        createAWB.CbCustomsBroker_01.click();
        
        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnAddDimensions); 
        
        createAWB.clickOnBtn("Add Dimensions");
        wm.VisibilityOfElementExplicityWait(driver, createAWB.DimesionsWindow, 5);
        wm.isElementPresent(driver, createAWB.DimesionsWindow);
        Assert.assertTrue(verify);
        Thread.sleep(3000);
        createAWB.AddDimensions("10", "10", "10", "10", 1);
        createAWB.clickOnBtn("Dimensions Ok");
        wm.ImplicitlyWait(driver, 5);
        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdRateClass);
        createAWB.enter_eAWBData("Gross Weight", "10");
        Thread.sleep(2000);
        
         
        Select selectRateClass = new Select(createAWB.DdRateClass);
        selectRateClass.selectByIndex(1);
        Thread.sleep(1000);
     
      
        createAWB.enter_eAWBData("Nature Of Goods", "Plastic");
     
        createAWB.enter_eAWBData("Rate charge", "5");
        Thread.sleep(1000);
        
        Thread.sleep(1000);
        createAWB.enter_eAWBData("Due Carrier box1", "AWC");
        Thread.sleep(1500);
		Actions select = new Actions(driver);
        select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        Thread.sleep(1000);
        
//        createAWB.enter_eAWBData("Due Carrier box2", "251");
        createAWB.DueCarrierBox2.sendKeys("251");
        Thread.sleep(1000);
       
     
        
    }
    
    
    @When("^Click on Routing Info button and enter Destn \"([^\"]*)\" and Via \"([^\"]*)\" and Flight No \"([^\"]*)\" for eAWB screen$")
    public void click_on_routing_info_button_and_enter_destn_and_via_and_flight_no_for_eawb_screen(String DestnPort, String Via_1, String FlightNo) throws Throwable {
    	
//        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnRoutingInfo);
        wm.scrolldownUsingJSE(driver, "400");
        Thread.sleep(1000);
    	createAWB.clickOnBtn("Routing Info");
        wm.VisibilityOfElementExplicityWait(driver, createAWB.RoutingDetailsWindow, 10);
        verify = wm.isElementPresent(driver, createAWB.RoutingDetailsWindow);
        Assert.assertTrue(verify);
        Thread.sleep(3000);

        createAWB.enter_eAWBData("Destn Port", DestnPort);
        Thread.sleep(1000);
        createAWB.enter_eAWBData("Via_1", Via_1);
        Thread.sleep(1000);
        createAWB.clickOnBtn("Routing Window Ok");
        Thread.sleep(2000);
        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdChargeCode);
        Thread.sleep(1000);
        Select selectChargeCode = new Select(createAWB.DdChargeCode);
        selectChargeCode.selectByIndex(1);
        Thread.sleep(1000);
        createAWB.enter_eAWBData("Flight No", FlightNo);
        
        createAWB.DdCustomsBroker.click();
        Thread.sleep(1000);
        createAWB.CbCustomsBroker_01.click();
        
        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnAddDimensions); 
        
        createAWB.clickOnBtn("Add Dimensions");
        wm.VisibilityOfElementExplicityWait(driver, createAWB.DimesionsWindow, 5);
        wm.isElementPresent(driver, createAWB.DimesionsWindow);
        Assert.assertTrue(verify);
        Thread.sleep(3000);
        createAWB.AddDimensions("10", "10", "10", "10", 1);
        createAWB.clickOnBtn("Dimensions Ok");
        wm.ImplicitlyWait(driver, 5);
        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdRateClass);
        createAWB.enter_eAWBData("Gross Weight", "10");
        Thread.sleep(2000);
        
         
        Select selectRateClass = new Select(createAWB.DdRateClass);
        selectRateClass.selectByIndex(1);
        Thread.sleep(1000);
     
      
        createAWB.enter_eAWBData("Nature Of Goods", "Plastic");
     
//        createAWB.enter_eAWBData("Rate charge", "5");
//        Thread.sleep(1000);
//        
//        Thread.sleep(1000);
//        createAWB.enter_eAWBData("Due Carrier box1", "AWC");
//        Thread.sleep(1000);
//        createAWB.enter_eAWBData("Due Carrier box2", "251");
//        Thread.sleep(1000);
        
    }
    
    @When("^Clickon Routing Info button and enter Destn \"([^\"]*)\" and Via \"([^\"]*)\" and Flight No \"([^\"]*)\" for eAWB screen$")
    public void clickon_routing_info_button_and_enter_destn_and_via_and_flight_no_for_eawb_screen(String DestnPort, String Via_1, String FlightNo) throws Throwable {
    	
//        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnRoutingInfo);
        wm.scrolldownUsingJSE(driver, "400");
        Thread.sleep(1000);
    	createAWB.clickOnBtn("Routing Info");
        wm.VisibilityOfElementExplicityWait(driver, createAWB.RoutingDetailsWindow, 10);
        verify = wm.isElementPresent(driver, createAWB.RoutingDetailsWindow);
        Assert.assertTrue(verify);
        Thread.sleep(3000);

        createAWB.enter_eAWBData("Destn Port", DestnPort);       
        Thread.sleep(1000);
        
        createAWB.clickOnBtn("Routing Window Ok");
        Thread.sleep(2000);
        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdChargeCode);
        Thread.sleep(1000);
        Select selectChargeCode = new Select(createAWB.DdChargeCode);
        selectChargeCode.selectByIndex(1);
        Thread.sleep(1000);
        createAWB.enter_eAWBData("Flight No", FlightNo);
        
        createAWB.DdCustomsBroker.click();
        Thread.sleep(1000);
        createAWB.CbCustomsBroker_01.click();
        
        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnAddDimensions); 
        
        createAWB.clickOnBtn("Add Dimensions");
        wm.VisibilityOfElementExplicityWait(driver, createAWB.DimesionsWindow, 5);
        wm.isElementPresent(driver, createAWB.DimesionsWindow);
        Assert.assertTrue(verify);
        Thread.sleep(3000);
        createAWB.AddDimensions("10", "10", "10", "10", 1);
        createAWB.clickOnBtn("Dimensions Ok");
       
        
        wm.ImplicitlyWait(driver, 5);
        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdRateClass);
        Select selectRateClass = new Select(createAWB.DdRateClass);
        selectRateClass.selectByIndex(1);
        Thread.sleep(1000);
     

        Thread.sleep(1000);
        createAWB.DueCarrierBox1.sendKeys("AWC");
        Thread.sleep(1500);
		Actions select = new Actions(driver);
        select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        Thread.sleep(500);
        
        
        createAWB.DueCarrierBox2.sendKeys("251");
//        Thread.sleep(1000);
//        select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        Thread.sleep(500);
    }
    
    @Then("^Enter via (\\d+) flight details$")
    public void enter_via_flight_details(int arg1) throws Throwable {
    	Thread.sleep(5000);  createAWB.carrierCode2.sendKeys("AA");
    	Thread.sleep(1000); String FlightNo = cm.RandomNo(4);
        createAWB.enter_eAWBData("Flight No2", FlightNo);         
      	String date = cm.SpecificDate1("dd MM yyyy",2); System.out.println(date);Thread.sleep(1000);
		rp.SelectDate(createAWB.flightdatepicker1.get(1), date);
    }
    @Then("^Enter via (\\d+) flight detailsss$")
    public void enter_via_flight_detailsss(int arg1) throws Throwable {
    	Thread.sleep(5000); createAWB.carrierCode3.sendKeys("DA");
    	Thread.sleep(1000); String FlightNo = cm.RandomNo(4);
        createAWB.enter_eAWBData("Flight No3", FlightNo);         
      	String date = cm.SpecificDate1("dd MM yyyy",3); System.out.println(date);Thread.sleep(1000);
		rp.SelectDate(createAWB.flightdatepicker1.get(2), date);
    }
    
    //Edit eAW and Add House Manifest
    @When("^Clicked on eAwb Edit button for eAWB screen$")
    public void clicked_on_eAwb_Edit_button_for_eAWB_screen() throws Throwable {
        eAwbListPage.EditBtnList.get(0).click();
    }

    @When("^Clicked on Consol/HAWB radio button for eAWB screen$")
    public void clicked_on_Consol_HAWB_radio_button_for_eAWB_screen() throws Throwable {
        createAWB.clickOnBtn("Rb Consol");  
    }

    @Then("^Verify message popup displays and click Ok for HAWB screen$")
    public void verify_message_popup_displays_and_click_Ok_for_HAWB_screen() throws Throwable {
        wm.VisibilityOfElementExplicityWait(driver, createAWB.HouseMessagePopup, 20);
        verify = wm.isElementPresent(driver, createAWB.HouseMessage);
        Assert.assertTrue(verify);
        Thread.sleep(3000);
        verify = wm.isElementTextContain(driver, createAWB.HouseMessage, "Do you want to create House Air Waybill first?");
        Assert.assertTrue(verify);
        Thread.sleep(2000);
        createAWB.clickOnBtn("Yes House Message");
    }

    @Then("^Verify Housing Manifest iframe is displayed for HAWB screen$")
    public void verify_Housing_Manifest_iframe_is_displayed_for_HAWB_screen() throws Throwable {
        wm.VisibilityOfElementExplicityWait(driver, houseManifestPage.HouseManifestWindow, 20);
        verify = wm.isElementPresent(driver, houseManifestPage.HouseManifestWindow);
        Assert.assertTrue(verify);
        Thread.sleep(2000);
        houseManifestPage.switchTo("iFrame");
    }
    
    @When("^Enter the House Manifest data \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" (\\d+) for HAWB Screen$")
    public void enter_the_house_manifest_data_something_something_something_something_something_something_something_something_for_hawb_screen(String Shipper, String Consignee, String Origin, String Destination, String NOP, String GrossWeight, String CargoDesc, int rowno) throws Throwable {
    	houseManifestPage.enterHouseManifestData(Shipper, Consignee, Origin, Destination, NOP, GrossWeight, CargoDesc, rowno);
    }

    @When("^Enter House Manifest data \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" (\\d+) for HAWB Screen$")
    public void enter_house_manifest_data_something_something_something_something_something_something_something_something_for_hawb_screen(String Shipper, String Consignee, String Origin, String Destination, String NOP, String GrossWeight, String CargoDesc, int rowno) throws Throwable {
    	createAWB.AddHouseManifest(Shipper, Consignee, Origin, Destination, NOP, GrossWeight, "INR", "CA", CargoDesc, rowno);
    }
    
    @When("^Click Save House Manifest button for HAWB Screen$")
    public void click_Save_House_Manifest_button_for_HAWB_Screen() throws Throwable {
    	Thread.sleep(2000);
    	houseManifestPage.clickOnBtn("Hawb Save");
        
    }

    @Then("^Verify Save Success message is displayed on iFrame for HAWB Screen$")
    public void verify_Save_Success_message_is_displayed_on_iFrame_for_HAWB_Screen() throws Throwable {
        wm.isElementTextContain(driver, houseManifestPage.SaveSucessMsgHAWB_iFrame, "House Manifest Saved successfully");
    }

    @When("^Click on Close Housing Manifest iFrame for HAWB Screen$")
    public void click_on_Close_Housing_Manifest_iFrame_for_HAWB_Screen() throws Throwable {
    	
        houseManifestPage.clickOnBtn("Close iFrame");
        houseManifestPage.switchTo("default");
        houseManifestPage.clickOnBtn("Close iFrame");
        houseManifestPage.switchTo("default");
    }
    

    @When("^Click on Close Housing Manifest iFrame for HAWB window$")
    public void click_on_Close_Housing_Manifest_iFrame_for_HAWB_window() throws Throwable {
    	 wm.scrolldownUsingJSE(driver, "1000");
//        houseManifestPage.clickOnBtn("Close iFrame");
        houseManifestPage.switchTo("parent"); 
        
        wm.VisibilityOfElementExplicityWait(driver, houseManifestPage.HouseManifestWindow, 20);
        verify = wm.isElementPresent(driver, houseManifestPage.HouseManifestWindow);
        Assert.assertTrue(verify);
        
        Thread.sleep(2000);
        wm.VisibilityOfElementExplicityWait(driver,  houseManifestPage.BtnCloseHAWB_window, 15);
        houseManifestPage.BtnCloseHAWB_window.click();
//        
    }

    
    @When("^Clickon Close Housing Manifest iFrame for HAWB Screen$")
    public void clickon_Close_Housing_Manifest_iFrame_for_HAWB_Screen() throws Throwable {
    	 houseManifestPage.switchTo("default");
    	wm.scrolldownUsingJSE(driver, "400");
    	wm.scrolldownUsingJSE_tillvisibilityOfElement(driver, createAWB.close );
    	Thread.sleep(2000);
    	System.out.println(createAWB.closeX.isDisplayed());
    	createAWB.close.click();
    }

    @Then("^Verify HAWB table is displayed in eAWB screen for HAWB Screen$")
    public void verify_HAWB_table_is_displayed_in_eAWB_screen_for_HAWB_Screen() throws Throwable {
       Thread.sleep(5000); wm.VisibilityOfElementExplicityWait(driver, createAWB.HAWBTable, 30);
        verify = wm.isElementPresent(driver, createAWB.HAWBTable);
        Assert.assertTrue(verify);
        Thread.sleep(2000);
    }

    @When("^Click on Save eAWB button for eAWB screen$")
    public void click_on_Save_eAWB_button_for_eAWB_screen() throws Throwable {
    	wm.scrolldownUsingJSE(driver, "2000");
    	Thread.sleep(1000);
    	wm.ClickUsingJSExecutor(driver, createAWB.BtnSaveAwb);
    }
    
    @When("^Click on SaveeAWB button for eAWB screen$")
    public void click_on_SaveeAWB_button_for_eAWB_screen() throws Throwable {
    	wm.scrolldownUsingJSE(driver, "2000");
    	Thread.sleep(1000);
    	wm.ClickUsingJSExecutor(driver, createAWB.BtnSaveAwb);
    }


    @Then("^Verify Success message is displayed for eAWB screen$")
    public void verify_Success_message_is_displayed_for_eAWB_screen() throws Throwable {
    	 wm.VisibilityOfElementExplicityWait(driver, createAWB.AWBSaveWindow, 20);
         verify = wm.isElementTextContain(driver, createAWB.AWBSaveMessage, "Air Waybill saved successfully");
         Assert.assertTrue(verify);
         Thread.sleep(3000);
         createAWB.clickOnBtn("AWB Save Ok");
    }

    
    
//    @152339	step definition
	    @Then("^click Yes for popUpMsg Do you want to create House Air Waybill first\\?$")
	    public void click_Yes_for_popUpMsg_Do_you_want_to_create_House_Air_Waybill_first() throws Throwable {
//	    	Assert.assertTrue(createAWB.popUpMs.isDisplayed());
	    	if(createAWB.popUpMs.isDisplayed()) {
	    		createAWB.YesBtn.click();
		    	Thread.sleep(2000);
	    	}

	    }
	    
		
		@When("^Enter Shippers Name and  Address \"([^\"]*)\" in eAWB screen$")
		public void enter_Shippers_Name_and_Address_in_eAWB_screen(String arg1) throws Throwable {
			createAWB.enter_eAWBData("Shipper Name", arg1);
	        Thread.sleep(2000);
	        
		}
		
		@When("^Enter Consignee Name and Address  \"([^\"]*)\" in eAWB screen$")
		public void enter_Consignee_Name_and_Address_in_eAWB_screen(String arg1) throws Throwable {
			createAWB.enter_eAWBData("Consignee Name", arg1);
			Thread.sleep(2000);
		}
		

		
		@When("^Click on Routing Info button and enter Destn \"([^\"]*)\" and Via \"([^\"]*)\"$")
		public void click_on_Routing_Info_button_and_enter_Destn_and_Via(String arg1, String arg2) throws Throwable {
		    
		}
		
		@When("^if housemanifest popUp appears close it$")
		public void if_housemanifest_popUp_appears_close_it() throws Throwable {
			wm.VisibilityOfElementExplicityWait(driver, houseManifestPage.HouseManifestWindow, 60);
			boolean ch = houseManifestPage.HouseManifestWindow.isDisplayed();
		  if(ch==true) {
//			  houseManifestPage.popupclose.click();
			  wm.scrolldownUsingJSE_tillvisibilityOfElement(driver, createAWB.close );
		    	Thread.sleep(5000);
		    	System.out.println(createAWB.close.isDisplayed());
		    	createAWB.close.click();
		  }
		}

//  @152340	step definition
		
		@Given("^for eAWB screen- select\"([^\"]*)\"from Create AWB as/from option$")
		public void for_eAWB_screen_select_from_Create_AWB_as_from_option(String arg1) throws Throwable {
		    wm.selectDropDownElementByVisibleText(driver, createAWB.CreateAWB_asfrom, arg1);
		  
		}
		
		@Given("^for eAWB screen- from AWBList select MAWBno and click on OK\"([^\"]*)\"$")
		public void for_eAWB_screen_from_AWBList_select_MAWBno_and_click_on_OK(String arg1) throws Throwable {
		    driver.switchTo().frame(createAWB.AwbListiframe);
		    wm.VisibilityOfElementExplicityWait(driver, createAWB.MAWBNoList, 30);
		    System.out.println("size of rrow:"+ createAWB.MAWBNoList.size() +"=="+ createAWB.MAWBNoList.get(0).getText());
		    System.out.println(createAWB.selectRadio1.isDisplayed());
		    createAWB.selectRadio1.click();
//		    createAWB.selectMAWBNo(arg1);
		    driver.switchTo().defaultContent();
		    wm.ClickUsingJSExecutor(driver,createAWB.OKBtn);		    
		}

//  @152341	step definition
		
		@Then("^Save as template for eAWB screen$")
		public void save_as_template_for_eAWB_screen() throws Throwable {
			wm.scrolldownUsingJSE(driver, "200");
		   createAWB.saveAsTemplateBtn.click();    Thread.sleep(1000);
		
		   wm.VisibilityOfElementExplicityWait(driver,  createAWB.templatePopup, 30);
		   Assert.assertTrue(createAWB.templatePopup.isDisplayed());
		   wm.scrolldownUsingJSE(driver, "-400");
		   tempName = "KLautoscript"+cm.RandomNo(5); 
		   createAWB.templatenametextbox.sendKeys(tempName);
		   createAWB.templateBoxSaveBtn.click(); 
		   Thread.sleep(5000);
		   
		   wm.VisibilityOfElementExplicityWait(driver, createAWB.templateSavedSuccesPopupMsg, 30);
		   wm.isElementAttributeValueContain(driver, createAWB.templateSavedSuccesPopupMsg, "value", "Air Waybill Template saved successfully. Please save the Air Waybill now.");
		   createAWB.templateSavedSuccesPopupMsg_OK.click();
		   System.out.println("Varified: Air Waybill Template saved successfully.");
		   wm.scrolldownUsingJSE(driver, "-800");
		   Thread.sleep(5000);
		}
		

		@Given("^for eAWB screen- from AWBTemplateList select firstradio and click on OK\"([^\"]*)\"$")
		public void for_eAWB_screen_from_AWBTemplateList_select_firstradio_and_click_on_OK(String arg1) throws Throwable {
		    driver.switchTo().frame(createAWB.IframTemplate);
		    wm.VisibilityOfElementExplicityWait(driver, createAWB.selectRadioBtn, 30); 
		    Thread.sleep(5000);
		    createAWB.selectRadioBtn.click();
		    
		    driver.switchTo().defaultContent();
		    
		    wm.VisibilityOfElementExplicityWait(driver, createAwb.template_header, 15);
		    verify = wm.isElementPresent(driver, createAwb.template_header);
		    cm.Verify(verify, true);
		    
//		    createAwb.templateCloseBtn.click();
		    
		     wm.VisibilityOfElementExplicityWait(driver, createAWB.OKBtn1, 30);
		     
//		    wm.VisibilityOfElementExplicityWait(driver, createAWB.templatePopUp_OKBtn, 30);
		    System.out.println(createAWB.OKBtn1.isDisplayed());
		    Thread.sleep(5000);

		    createAWB.OKBtn1.click();
//		    wm.ClickUsingJSExecutor(driver,createAWB.templatePopUp_OKBtn);
		    System.out.println("template pop closed");
		}
	
		
		@Given("^Enter Rate Class and ChargebleWt$")
		public void Enter_Rate_Class_and_ChargebleWt() throws Throwable {
			wm.scrolldownUsingJSE(driver, "1200");
			Select selectRateClass = new Select(createAWB.DdRateClass);
			Thread.sleep(1000);
			wm.ClickUsingJSExecutor(driver, createAWB.DdRateClass);
	        selectRateClass.selectByIndex(1);
	        Thread.sleep(2000);
	        createAWB.enter_eAWBData("Chargeable Wt", "500"); Thread.sleep(3000);
	        createAWB.enter_eAWBData("Rate charge", "50");
	        Thread.sleep(5000);
		}


		@Then("^refresh the website$")
		public void refresh_the_website() throws Throwable {
		    driver.navigate().refresh();
			
		}
		
		@Given("^for eAWB validate popupMsg\"([^\"]*)\" and click OK$")
		public void for_eAWB_screen_validate_popupMsg_and_click_OK(String arg1) throws Throwable {
				wm.VisibilityOfElementExplicityWait(driver, createAWB.templatepopupMsgContent, 30);
//			    wm.VisibilityOfElementExplicityWait(driver, createAWB.templatePopUp_OKBtn, 30);
			    System.out.println(createAWB.templatepopupMsgContent.isDisplayed());
			    Thread.sleep(3000);
			    createAWB.templatepopOKBtn.click();
		}
		
		@Then("^for E_AWB Enter flight date$")
		public void for_E_AWB_Enter_flight_date() throws Throwable {
			wm.scrolldownUsingJSE(driver, "700");
			String date = cm.SpecificDate1("dd MM yyyy", 3); System.out.println(date);Thread.sleep(1000);
			rp.SelectDate2(createAWB.flightdatepicker, date);
		}
		
//		#@152342	    step definition  #Scenario: To verify By default ,Value of Issuing agent is fetched from  Issuing Carrier's Agent Name and City is displayed same as of branch which is logged in
		@Then("^To verify default issuing Carriers Agent Name and City$")
		public void to_verify_default_issuing_Carriers_Agent_Name_and_City() throws Throwable {
			
			String str[] = AgentUsername.split("_"); 
			String Agent = str[1];
			System.out.println(Agent);
			boolean validate = false; 
			validate = wm.isElementAttributeValueContain(driver,  createAWB.Agentname, "value", Agent) ;
			
		}
		
		
//		#@152343		step definition  #Scenario: To verify User is able to change the Issuing agent

		@Then("^hover branch and select branch name\"([^\"]*)\"$")
		public void hover_branch_and_select_branch_name(String arg1) throws Throwable {
			wm.Action_MoveOverElement(driver, createAWB.branch);
			Thread.sleep(2000);
			IssuingAgent = arg1;
			createAWB.ClickOnSubMenu(IssuingAgent);
//			createAWB.BranchHover(arg1);
			Thread.sleep(2000);
		}
		
		@Then("^Enter issuing agent name\"([^\"]*)\"$")
		public void Enter_issuing_agent_name(String arg1) throws Throwable {
		    wm.scrolldownUsingJSE(driver, "600");
		    IssuingAgent = arg1;
		    createAwb.enter_eAWBData("Issuing Agent", IssuingAgent);

		}
		
		@Then("^validate Issuing Carriers Agent Name and City is as selected branch$")
		public void validate_Issuing_Carriers_Agent_Name_and_City_is_as_selected_branch() throws Throwable {
		    wm.scrolldownUsingJSE(driver, "600");
		    boolean validate = false; 
			wm.isElementAttributeValueContain(driver,  createAWB.Agentname, "value", IssuingAgent) ;
		}
		
//		#@152344        step definition  #Scenario: To verify Check if Issuing agent(new) creates AWB then amount should be deducted from the new Issuing agent account
		@Then("^update Issuing Carrier's Agent Name and City$")
		public void update_Issuing_Carrier_s_Agent_Name_and_City() throws Throwable {
		   
		}
		
		@When("^Navigate to MAWB screen$")
		public void navigate_to_MAWB_screen() throws Throwable {
		 
		}
		
		@When("^filter MAWB no\\.$")
		public void filter_MAWB_no() throws Throwable {
		   
		}
		
		@Then("^clickon MAWB ASI  and OK$")
		public void clickon_MAWB_ASI_and_OK() throws Throwable {
		   
		}
		
		@Then("^Clickon CO, select from the dropdown and clickon Yes, verify confirmation msg and clickon OK$")
		public void clickon_CO_select_from_the_dropdown_and_clickon_Yes_verify_confirmation_msg_and_clickon_OK() throws Throwable {
		    // Write code here that turns
		}
		
		@Given("^Loggout from agent account$")
		public void loggout_from_agent_account() throws Throwable {
		    // Write code here that turns
		}
		
		@Then("^login using airlineUsername and airlinePassword$")
		public void login_using_airlineUsername_and_airlinePassword() throws Throwable {
		    // Write code here that turns
		}
		
		@Then("^clickon CO Approval and enter MAWB noumber and clickon searchbtn$")
		public void clickon_CO_Approval_and_enter_MAWB_noumber_and_clickon_searchbtn() throws Throwable {
		    // Write code here that turns
		}
		
		@Then("^click on Action and approve, verify success popUp and clickon OK$")
		public void click_on_Action_and_approve_verify_success_popUp_and_clickon_OK() throws Throwable {
		    // Write code here that turns
		}
		
		@When("^Clickon Admin$")
		public void clickon_Admin() throws Throwable {
		    // Write code here that turns
		}
		
		@Given("^Navigate to CargobyBLR A/C Management >> Account Ledger$")
		public void navigate_to_CargobyBLR_A_C_Management_Account_Ledger() throws Throwable {
		    // Write code here that turns
		}
		
		@Given("^filter fromdate and Todate and clickon viewBtn$")
		public void filter_fromdate_and_Todate_and_clickon_viewBtn() throws Throwable {
		    // Write code here that turns
		}
		
		@Then("^find AWBnumber and validate debit amount$")
		public void find_AWBnumber_and_validate_debit_amount() throws Throwable {
		    // Write code here that turns
		}
		

		
		
//		#@152345		step definition  #Scenario: To verify that user is able to add new shipper details or search the existing details.
		

		@Then("^Click on Plus sign near Shipper field$")
		public void click_on_Plus_sign_near_Shipper_field() throws Throwable {
			addShipper.shipperPlusSign.click();
			wm.VisibilityOfElementExplicityWait(driver,  addShipper.popUpHeader, 15);
		}
		
		@When("^validate AddShipper PopUp appears$")
		public void validate_AddShipper_PopUp_appears() throws Throwable { 
		  Assert.assertTrue(addShipper.popUpHeader.isDisplayed());
		}
		
		@Then("^Enter Shipper Name and Address details, clickon Save, Click on OK$")
		public void enter_Shipper_Name_and_Address_details_clickon_Save_Click_on_OK() throws Throwable {
		    validate =  addShipper.enterShipperdetails(driver);
		}
		
		@When("^search the same shipper Name and Address to validate$")
		public void search_the_same_shipper_Name_and_Address_to_validate() throws Throwable {
			createAWB.enter_eAWBData("Shipper Name", validate);
		}
		

		
		
//		#@152346 step definition  #Scenario: To verify that user is able to add new consignee details or search the existing details.
		
		
		@Then("^Click on Plus sign near consignee field$")
		public void click_on_Plus_sign_near_consignee_field() throws Throwable {
			addConsignee.consigneePlusSign.click();
		}
		
		@When("^validate Addconsignee PopUp appears$")
		public void validate_Addconsignee_PopUp_appears() throws Throwable {
		    Assert.assertTrue(addConsignee.popUpHeader.isDisplayed());
		}
		
		@Then("^Enter consignee Name and Address details, clickon Save, Click on OK$")
		public void enter_consignee_Name_and_Address_details_clickon_Save_Click_on_OK() throws Throwable {
		    validate =  addConsignee.enterConsigneedetails(driver); 
		}
		
		@When("^search the same consignee Name and Address to validate$")
		public void search_the_same_consignee_Name_and_Address_to_validate() throws Throwable {
			createAWB.enter_eAWBData("Consignee Name", validate);

		}
		

		
//		#@152347		step definition	#Scenario: To verify User is not able to save AWB Shipper & consignee details having same country
	    @When("^Enter same shipper and consignee details \"([^\"]*)\" and \"([^\"]*)\" for eAWB screen$")
	    public void enter_same_shipper_and_consignee_details_something_and_something_for_eawb_screen(String acsshipper, String acsconsigneeatl) throws Throwable {
	        createAWB.enter_eAWBData("Shipper Name", acsshipper);
	        createAWB.enter_eAWBData("Consignee Name", acsconsigneeatl);
	        
	    }
	    
	    @Then("^in AWSscreen verify validation popUp appears$")
	    public void in_AWSscreen_verify_validation_popUp_appears() throws Throwable {
	    	wm.VisibilityOfElementExplicityWait(driver, createAWB.popUpMsg, 20);
	    	boolean check = createAWB.sameCountryPopUpMsg.getText().equalsIgnoreCase("Shipper and consignee should be from different country"); 
	        Assert.assertTrue(check);
	        createAWB.popUpMsg.click();
	    }
		
		
//		#@152348		step definition
//		#Scenario: To verify User is able to save AWB with various 'Charge Codes' available in the system
//		#@152349 //		#Scenario: To verify User is able to save AWB with 'Routing details' having 'via 1' or 'Via 1 & Via 2' points
	    @Then("^FOR E_AWB enter Rate in Cargo(\\d+)$")
	    public void for_E_AWB_enter_Rate_in_Cargo(int arg1) throws Throwable {
	    	Thread.sleep(1000);
	    	createAWB.enter_eAWBData("Rate charge", "100");
	    }

	    @Then("^FOR E_AWB enter Due Carrier$")
	    public void for_E_AWB_enter_Due_Carrier() throws Throwable {
	        createAWB.enter_eAWBData("Due Carrier", "awc");Thread.sleep(1000);
//	        createAWB.enter_eAWBData("Due Carrier box2", "251");
	        createAWB.DueCarrierBox2.sendKeys("251" + Keys.TAB);
	    }

	    
	    
	    
//		#@152350		step definition   #Scenario: To verify User is able to save AWB with multiple 'Carrier Codes'
	    
	    @When("^Click on Routing Info button and enter Destn \"([^\"]*)\" and Via \"([^\"]*)\" and Flight No \"([^\"]*)\" for eAWB screen with multiple Carrier Codes$")
	    public void click_on_routing_info_button_and_enter_destn_and_via_and_flight_no_for_eawb_screen_with_multiple_Carrier_Codes(String DestnPort, String Via_1, String FlightNo) throws Throwable {
	    	
//	        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnRoutingInfo);
	        wm.scrolldownUsingJSE(driver, "400");
	        Thread.sleep(1000);
	    	createAWB.clickOnBtn("Routing Info");
	        wm.VisibilityOfElementExplicityWait(driver, createAWB.RoutingDetailsWindow, 10);
	        verify = wm.isElementPresent(driver, createAWB.RoutingDetailsWindow);
	        Assert.assertTrue(verify);
	        Thread.sleep(3000);

	        createAWB.enter_eAWBData("Destn Port", DestnPort);
	        Thread.sleep(1000);
	        createAWB.enter_eAWBData("Via_1", Via_1);
	        Thread.sleep(1000);
	        createAWB.clickOnBtn("Routing Window Ok");
	        Thread.sleep(2000);
	        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdChargeCode);
	        Thread.sleep(1000);
	        Select selectChargeCode = new Select(createAWB.DdChargeCode);
	        selectChargeCode.selectByIndex(1);
	        Thread.sleep(1000);
	        createAWB.enter_eAWBData("Flight No", FlightNo);
	        
	        createAWB.DdCustomsBroker.click();
	        Thread.sleep(1000);
	        createAWB.CbCustomsBroker_01.click();
	        
	        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnAddDimensions); 
	        
	        createAWB.clickOnBtn("Add Dimensions");
	        wm.VisibilityOfElementExplicityWait(driver, createAWB.DimesionsWindow, 5);
	        wm.isElementPresent(driver, createAWB.DimesionsWindow);
	        Assert.assertTrue(verify);
	        Thread.sleep(3000);
	        createAWB.AddDimensions("10", "10", "10", "10", 1);
	        createAWB.clickOnBtn("Dimensions Ok");
	        wm.ImplicitlyWait(driver, 5);
	        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdRateClass);
	        createAWB.enter_eAWBData("Gross Weight", "10");
	        Thread.sleep(2000);
	        
	         
	        Select selectRateClass = new Select(createAWB.DdRateClass);
	        selectRateClass.selectByIndex(1);
	        Thread.sleep(1000);
	     
	      
	        createAWB.enter_eAWBData("Nature Of Goods", "Plastic");
	     
//	        createAWB.enter_eAWBData("Rate charge", "5");
//	        Thread.sleep(1000);
//	        
//	        Thread.sleep(1000);
//	        createAWB.enter_eAWBData("Due Carrier box1", "AWC");
//	        Thread.sleep(1000);
//	        createAWB.enter_eAWBData("Due Carrier box2", "251");
//	        Thread.sleep(1000);  
	    }
	    
//		#@152351		step definition   #Scenario: To verify User is able to save AWB with multiple 'Flight Details'
	    
	    @When("^Click on Routing Info button and enter Destn \"([^\"]*)\" and Via \"([^\"]*)\" and Via \"([^\"]*)\" and Flight No \"([^\"]*)\" and Flight No \"([^\"]*)\" for eAWB screen Create_Direct_eAWB$")
	    public void click_on_Routing_Info_button_and_enter_Destn_and_Via_and_Via_and_Flight_No_and_Flight_No_for_eAWB_screen_Create_Direct_eAWB(
	    		String DestnPort, String Via_1, String Via_2, String FlightNo, String FlightNo2) throws Throwable 
	    {
	        wm.scrolldownUsingJSE(driver, "400");
	        Thread.sleep(1000);
	    	createAWB.clickOnBtn("Routing Info");
	        wm.VisibilityOfElementExplicityWait(driver, createAWB.RoutingDetailsWindow, 10);
	        verify = wm.isElementPresent(driver, createAWB.RoutingDetailsWindow);
	        Assert.assertTrue(verify);
	        Thread.sleep(3000);

	        createAWB.enter_eAWBData("Destn Port", DestnPort);
	        Thread.sleep(1000);
	        createAWB.enter_eAWBData("Via_1", Via_1);
	        Thread.sleep(2000);
	        
	        createAWB.enter_eAWBData("Via_2", Via_2);
	        Thread.sleep(2000);
	        createAWB.clickOnBtn("Routing Window Ok");
	        Thread.sleep(2000);
	        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdChargeCode);
	        Thread.sleep(1000);
	        Select selectChargeCode = new Select(createAWB.DdChargeCode);
	        selectChargeCode.selectByIndex(1);
	        Thread.sleep(1000);
	        createAWB.enter_eAWBData("Flight No", FlightNo);
	        
	        Thread.sleep(1000);
	        wm.JavascriptExecutor_ElementScroll(driver, createAWB.carrierCode2);
	        Thread.sleep(1000);
	        createAWB.carrierCode2.sendKeys("ZZ", Keys.TAB);
	        Thread.sleep(1000);
	        createAWB.enter_eAWBData("Flight No2", FlightNo2);
	        Thread.sleep(1000);
//	        createAWB.FlightDate2.sendKeys(cm.SpecificDate(2), Keys.TAB);
	        
	        createAWB.DdCustomsBroker.click();
	        Thread.sleep(1000);
	        createAWB.CbCustomsBroker_01.click();
	        
	        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnAddDimensions); 
	        
	        createAWB.clickOnBtn("Add Dimensions");
	        wm.VisibilityOfElementExplicityWait(driver, createAWB.DimesionsWindow, 5);
	        wm.isElementPresent(driver, createAWB.DimesionsWindow);
	        Assert.assertTrue(verify);
	        Thread.sleep(3000);
	        createAWB.AddDimensions("10", "10", "10", "10", 1);
	        createAWB.clickOnBtn("Dimensions Ok");
	        wm.ImplicitlyWait(driver, 5);
	        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdRateClass);
	        createAWB.enter_eAWBData("Gross Weight", "10");
	        Thread.sleep(2000);
	        
	         
	        Select selectRateClass = new Select(createAWB.DdRateClass);
	        selectRateClass.selectByIndex(1);
	        Thread.sleep(1000);
	     
	      
	        createAWB.enter_eAWBData("Nature Of Goods", "Plastic");
	     
	        createAWB.enter_eAWBData("Rate charge", "5");
	        Thread.sleep(1000);
	        
	        Thread.sleep(1000);
	        createAWB.enter_eAWBData("Due Carrier box1", "AWC");
	        Thread.sleep(1500);
	  		Actions select = new Actions(driver);
	        select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
	        Thread.sleep(1000);
	        
//	        createAWB.enter_eAWBData("Due Carrier box2", "251");
	        createAWB.DueCarrierBox2.sendKeys("251");
	        Thread.sleep(1000);
	    
	    }

//		#@152352		step definition  #Scenario: To verify User is able to save AWB with "Handling Information"
	    @When("^Click on Routing Info button and enter Destn \"([^\"]*)\" and Via \"([^\"]*)\" and Flight No \"([^\"]*)\" for eAWB screen Create_Direct_eAWB with handling info$")
	    public void click_on_routing_info_button_and_enter_destn_and_via_and_flight_no_for_eawb_screen_Create_Direct_eAWB_with_handling_info(
	    		String DestnPort, String Via_1, String FlightNo) throws Throwable {
	    	
//	        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnRoutingInfo);
	        wm.scrolldownUsingJSE(driver, "400");
	        Thread.sleep(1000);
	    	createAWB.clickOnBtn("Routing Info");
	        wm.VisibilityOfElementExplicityWait(driver, createAWB.RoutingDetailsWindow, 10);
	        verify = wm.isElementPresent(driver, createAWB.RoutingDetailsWindow);
	        Assert.assertTrue(verify);
	        Thread.sleep(3000);

	        createAWB.enter_eAWBData("Destn Port", DestnPort);
	        Thread.sleep(1000);
	        createAWB.enter_eAWBData("Via_1", Via_1);
	        Thread.sleep(1000);
	        createAWB.clickOnBtn("Routing Window Ok");
	        Thread.sleep(2000);
	        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdChargeCode);
	        Thread.sleep(1000);
	        Select selectChargeCode = new Select(createAWB.DdChargeCode);
	        selectChargeCode.selectByIndex(1);
	        Thread.sleep(1000);
	        createAWB.enter_eAWBData("Flight No", FlightNo);
	        
	        createAWB.textarea2.sendKeys("This AWB is part of test Automation. ");
	        
	        
	        createAWB.DdCustomsBroker.click();
	        Thread.sleep(1000);
	        createAWB.CbCustomsBroker_01.click();
	        
	        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnAddDimensions); 
	        
	        createAWB.clickOnBtn("Add Dimensions");
	        wm.VisibilityOfElementExplicityWait(driver, createAWB.DimesionsWindow, 5);
	        wm.isElementPresent(driver, createAWB.DimesionsWindow);
	        Assert.assertTrue(verify);
	        Thread.sleep(3000);
	        createAWB.AddDimensions("10", "10", "10", "10", 1);
	        createAWB.clickOnBtn("Dimensions Ok");
	        wm.ImplicitlyWait(driver, 5);
	        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdRateClass);
	        createAWB.enter_eAWBData("Gross Weight", "10");
	        Thread.sleep(2000);
	        
	         
	        Select selectRateClass = new Select(createAWB.DdRateClass);
	        selectRateClass.selectByIndex(1);
	        Thread.sleep(1000);
	     
	      
	        createAWB.enter_eAWBData("Nature Of Goods", "Plastic");
	     
	        createAWB.enter_eAWBData("Rate charge", "5");
	        Thread.sleep(1000);
	        
	        Thread.sleep(1000);
	        createAWB.enter_eAWBData("Due Carrier box1", "AWC");
	        Thread.sleep(1500);
			Actions select = new Actions(driver);
	        select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
	        Thread.sleep(1000);
	        
//	        createAWB.enter_eAWBData("Due Carrier box2", "251");
	        createAWB.DueCarrierBox2.sendKeys("251");
	        Thread.sleep(1000);
	       
	     
	        
	    }
	    
//		#@152353		step definition  #Scenario: To verify If "Rates as agreed" is checked then, Rate/Charges, Total,Prepaid section,Collect section, Due Agent & Due Carrier becomes disabled

		@When("^clickon Rates as agreed for eAWB screen$")
		public void clickon_Rates_as_agreed_for_eAWB_screen() throws Throwable {
		   
		    wm.scrolldownUsingJSE_tillvisibilityOfElement(driver, createAWB.Checkbox_RatesAsAgreed);
		    createAWB.Checkbox_RatesAsAgreed.click();
		}
		
		
		@When("^Enter FirstCarrier code$")
		public void Enter_FirstCarrier_code() throws Throwable {
		   
		    wm.scrolldownUsingJSE_tillvisibilityOfElement(driver, createAWB.carrierCode1);
		    createAWB.carrierCode1.sendKeys("ZZ");
		}
		
		@Then("^validate Rate_Charges, Total, Prepaid section, Collect section, Due Agent & Due Carrier should become disabled for eAWB screen$")
		public void validate_Rate_Charges_Total_Prepaid_section_Collect_section_Due_Agent_Due_Carrier_should_become_disabled_for_eAWB_screen() throws Throwable {
		    
			Assert.assertFalse(createAWB.Rate_Charges.isEnabled());
			Assert.assertFalse(createAWB.Total.isEnabled());
			Assert.assertFalse(createAWB.TotalPrepaid.isEnabled());
			Assert.assertFalse(createAWB.DueAgent.isEnabled());
			Assert.assertFalse(createAWB.DueCarrierBox1.isEnabled());
			Assert.assertFalse(createAWB.DueCarrierBox2.isEnabled());
			
		}
		

//		#@152354		step definition   #Scenario: To verify User is able to save AWB with Single dimension in single rateline
		
		
		
//		#@152355		step definition   #Scenario: To verify User is able to save AWB with multiple dimensions in Single rateline
		   @When("^Click on Routing Info button and enter Destn \"([^\"]*)\" and Via \"([^\"]*)\" and Flight No \"([^\"]*)\" for eAWB screen for multiple dimensions in Single rateline$")
		    public void click_on_routing_info_button_and_enter_destn_and_via_and_flight_no_for_eawb_screen_for_multiple_dimensions_in_Single_rateline(String DestnPort, String Via_1, String FlightNo) throws Throwable {
		    	
//		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnRoutingInfo);
		        wm.scrolldownUsingJSE(driver, "400");
		        Thread.sleep(1000);
		    	createAWB.clickOnBtn("Routing Info");
		        wm.VisibilityOfElementExplicityWait(driver, createAWB.RoutingDetailsWindow, 10);
		        verify = wm.isElementPresent(driver, createAWB.RoutingDetailsWindow);
		        Assert.assertTrue(verify);
		        Thread.sleep(3000);

		        createAWB.enter_eAWBData("Destn Port", DestnPort);
		        Thread.sleep(1000);
		        createAWB.enter_eAWBData("Via_1", Via_1);
		        Thread.sleep(1000);
		        createAWB.clickOnBtn("Routing Window Ok");
		        Thread.sleep(2000);
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdChargeCode);
		        Thread.sleep(1000);
		        Select selectChargeCode = new Select(createAWB.DdChargeCode);
		        selectChargeCode.selectByIndex(1);
		        Thread.sleep(1000);
		        createAWB.enter_eAWBData("Flight No", FlightNo);
		        
		        createAWB.DdCustomsBroker.click();
		        Thread.sleep(1000);
		        createAWB.CbCustomsBroker_01.click();
		        
//		        for multiple dimensions in Single rateline
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnAddDimensions); 
		        
		        createAWB.clickOnBtn("Add Dimensions");
		        wm.VisibilityOfElementExplicityWait(driver, createAWB.DimesionsWindow, 5);
		        wm.isElementPresent(driver, createAWB.DimesionsWindow);
		        Assert.assertTrue(verify);
		       
		        Thread.sleep(3000);
		        createAWB.anAddDimensions("5", "10", "10", "10", 1);
		        createAWB.dimensionPOPup_Action.click();
		        Thread.sleep(2000);
		        createAWB.anAddDimensions("5", "15", "15", "15", 2);
		        
		        createAWB.clickOnBtn("Dimensions Ok");
		        wm.ImplicitlyWait(driver, 5);
		        
//		        in Single rateline
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdRateClass);
		        createAWB.enter_eAWBData("Gross Weight", "500");
		        Thread.sleep(2000);
		        
		         
		        Select selectRateClass = new Select(createAWB.DdRateClass);
		        selectRateClass.selectByIndex(1);
		        Thread.sleep(1000);
		     
		      
		        createAWB.enter_eAWBData("Nature Of Goods", "Plastic");
		     
		        createAWB.enter_eAWBData("Rate charge", "5");
		        Thread.sleep(1000);
		        
		        Thread.sleep(1000);
		        createAWB.enter_eAWBData("Due Carrier box1", "AWC");
		        Thread.sleep(1500);
				Actions select = new Actions(driver);
		        select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
		        Thread.sleep(1000);
		        
//		        createAWB.enter_eAWBData("Due Carrier box2", "251");
		        createAWB.DueCarrierBox2.sendKeys("251");
		        Thread.sleep(1000);
		       
		     
		        
		    }
		
		
//		#@152356		step definition    #Scenario: To verify User is able to save AWB with single dimension in multiple ratelines
		   @When("^Click on Routing Info button and enter Destn \"([^\"]*)\" and Via \"([^\"]*)\" and Flight No \"([^\"]*)\" for eAWB screen for single dimension in multiple ratelines$")
		    public void click_on_routing_info_button_and_enter_destn_and_via_and_flight_no_for_eawb_screen_for_single_dimension_in_multiple_ratelines(String DestnPort, String Via_1, String FlightNo) throws Throwable {
		    	
//		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnRoutingInfo);
		        wm.scrolldownUsingJSE(driver, "400");
		        Thread.sleep(1000);
		    	createAWB.clickOnBtn("Routing Info");
		        wm.VisibilityOfElementExplicityWait(driver, createAWB.RoutingDetailsWindow, 10);
		        verify = wm.isElementPresent(driver, createAWB.RoutingDetailsWindow);
		        Assert.assertTrue(verify);
		        Thread.sleep(3000);

		        createAWB.enter_eAWBData("Destn Port", DestnPort);
		        Thread.sleep(1000);
		        createAWB.enter_eAWBData("Via_1", Via_1);
		        Thread.sleep(1000);
		        createAWB.clickOnBtn("Routing Window Ok");
		        Thread.sleep(2000);
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdChargeCode);
		        Thread.sleep(1000);
		        Select selectChargeCode = new Select(createAWB.DdChargeCode);
		        selectChargeCode.selectByIndex(1);
		        Thread.sleep(1000);
		        createAWB.enter_eAWBData("Flight No", FlightNo);
		        
		        
//-------------------------- for single dimension 
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnAddDimensions); 
		        
		        createAWB.clickOnBtn("Add Dimensions");
		        wm.VisibilityOfElementExplicityWait(driver, createAWB.DimesionsWindow, 5);
		        wm.isElementPresent(driver, createAWB.DimesionsWindow);
		        Assert.assertTrue(verify);
		       
		        Thread.sleep(3000);
		        createAWB.AddDimensions("5", "10", "10", "10", 1); 
		        createAWB.clickOnBtn("Dimensions Ok");
		        wm.ImplicitlyWait(driver, 5);
		        
//-------------------------- in first  rate lines
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdRateClass);
		        createAWB.enter_eAWBData("Gross Weight", "500");
		        Thread.sleep(2000);
		        
		         
		        Select selectRateClass = new Select(createAWB.DdRateClass);
		        selectRateClass.selectByIndex(1);
		        Thread.sleep(1000);
		     
		      
		        createAWB.enter_eAWBData("Nature Of Goods", "Plastic");
		     
		        createAWB.enter_eAWBData("Rate charge", "5");
		        Thread.sleep(1000);
//---------------------- clickon Action Rate line  ----------------------------------------------------------------------------------
		        createAWB.dimension_Action.click();
//---------------------- select single dimension again ----------------------------------------------------------------------------------
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnAddDimensions2); 
		        createAWB.clickOnBtn("Add Dimensions2");
		        wm.VisibilityOfElementExplicityWait(driver, createAWB.DimesionsWindow, 5);
		        wm.isElementPresent(driver, createAWB.DimesionsWindow);
		        Assert.assertTrue(verify);
		        Thread.sleep(3000);
		        createAWB.clickOnBtn("Dimensions Ok");
		        
//-------------------------- in second  rate lines ----------------------------------------------------------------------------------
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdRateClass2);
		        createAWB.enter_eAWBData("Gross Weight2", "100");
		        Thread.sleep(2000);
		        
		         
		        Select selectRateClass1 = new Select(createAWB.DdRateClass2);
		        selectRateClass1.selectByIndex(1);
		        Thread.sleep(1000);
		     
		      
		        createAWB.enter_eAWBData("Nature Of Goods2", "Plastic");
		     
		        createAWB.enter_eAWBData("Rate charge2", "5");
		        Thread.sleep(1000);
		        
		        

		        Thread.sleep(1000);
		        createAWB.enter_eAWBData("Due Carrier box1", "AWC");
		        Thread.sleep(1500);
				Actions select = new Actions(driver);
		        select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
		        Thread.sleep(1000);
		        
//		        createAWB.enter_eAWBData("Due Carrier box2", "251");
		        createAWB.DueCarrierBox2.sendKeys("251");
		        Thread.sleep(1000);
		       
///----------------- add custom Brokeer 
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdCustomsBroker); 
		        createAWB.CustomsBroker.click();
		        createAWB.CbCustomsBroker_01.click();
		        Thread.sleep(2000);
		  
		     
		        
		    }
		
		   
		   
//		#@152357		step definition    #Scenario: To verify User is able to save AWB with multiple dimensions in multiple ratelines
		   
		   @When("^Click on Routing Info button and enter Destn \"([^\"]*)\" and Via \"([^\"]*)\" and Flight No \"([^\"]*)\" for eAWB screen for multiple dimensions in multiple ratelines$")
		    public void click_on_routing_info_button_and_enter_destn_and_via_and_flight_no_for_eawb_screen_for_multiple_dimensions_in_multiple_ratelines(String DestnPort, String Via_1, String FlightNo) throws Throwable {
		    	
//		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnRoutingInfo);
		        wm.scrolldownUsingJSE(driver, "400");
		        Thread.sleep(1000);
		    	createAWB.clickOnBtn("Routing Info");
		        wm.VisibilityOfElementExplicityWait(driver, createAWB.RoutingDetailsWindow, 10);
		        verify = wm.isElementPresent(driver, createAWB.RoutingDetailsWindow);
		        Assert.assertTrue(verify);
		        Thread.sleep(3000);

		        createAWB.enter_eAWBData("Destn Port", DestnPort);
		        Thread.sleep(1000);
		        createAWB.enter_eAWBData("Via_1", Via_1);
		        Thread.sleep(1000);
		        createAWB.clickOnBtn("Routing Window Ok");
		        Thread.sleep(2000);
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdChargeCode);
		        Thread.sleep(1000);
		        Select selectChargeCode = new Select(createAWB.DdChargeCode);
		        selectChargeCode.selectByIndex(1);
		        Thread.sleep(1000);
		        createAWB.enter_eAWBData("Flight No", FlightNo);
		        
		       
		        
//	------------------------	adding first dimension dimensions 
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnAddDimensions); 
		        
		        createAWB.clickOnBtn("Add Dimensions");
		        wm.VisibilityOfElementExplicityWait(driver, createAWB.DimesionsWindow, 5);
		        wm.isElementPresent(driver, createAWB.DimesionsWindow);
		        Assert.assertTrue(verify);
		       
		        Thread.sleep(3000);
		        createAWB.anAddDimensions("5", "10", "10", "10", 1);
		        createAWB.clickOnBtn("Dimensions Ok");
		        wm.ImplicitlyWait(driver, 5);
		        
//	------------------------ adding first Rate line   
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdRateClass);
		        createAWB.enter_eAWBData("Gross Weight", "500");
		        Thread.sleep(2000);
		        
		         
		        Select selectRateClass = new Select(createAWB.DdRateClass);
		        selectRateClass.selectByIndex(1);
		        Thread.sleep(1000);
		     
		      
		        createAWB.enter_eAWBData("Nature Of Goods", "Plastic");
		     
		        createAWB.enter_eAWBData("Rate charge", "5");
		        Thread.sleep(1000);
//  ------------------------------------------------------------------------
		        createAWB.dimension_Action.click();
//---------------------- select single dimension again ----------------------------------------------------------------------------------
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnAddDimensions2); 
		        createAWB.clickOnBtn("Add Dimensions2");
		        wm.VisibilityOfElementExplicityWait(driver, createAWB.DimesionsWindow, 5);
		        wm.isElementPresent(driver, createAWB.DimesionsWindow);
		        Assert.assertTrue(verify);
		        Thread.sleep(3000);
		        createAWB.clickOnBtn("Dimensions Ok");
		        
//-------------------------- in second  rate lines ----------------------------------------------------------------------------------
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdRateClass2);
		        createAWB.enter_eAWBData("Gross Weight2", "100");
		        Thread.sleep(2000);
		        
		         
		        Select selectRateClass1 = new Select(createAWB.DdRateClass2);
		        selectRateClass1.selectByIndex(1);
		        Thread.sleep(1000);
		     
		      
		        createAWB.enter_eAWBData("Nature Of Goods2", "Plastic");
		     
		        createAWB.enter_eAWBData("Rate charge2", "5");
		        Thread.sleep(1000);
		        
		        
//		-----------  custom broker  ------------------------------------------------
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdCustomsBroker);
		        createAWB.DdCustomsBroker.click();
		        Thread.sleep(1000);
		        createAWB.CbCustomsBroker_01.click();
//		------------------------------------------------------------------------------------------------
		        Thread.sleep(1000);
		        createAWB.enter_eAWBData("Due Carrier box1", "AWC");
		        Thread.sleep(1500);
				Actions select = new Actions(driver);
		        select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
		        Thread.sleep(1000);
		        
//		        createAWB.enter_eAWBData("Due Carrier box2", "251");
		        createAWB.DueCarrierBox2.sendKeys("251");
		        Thread.sleep(1000);
		       
		     
		        
		    }
		   
//		#@152358		step definition 		#Scenario: To verify User is able to save AWB with different 'Rate Class'
//		#@152359		step definition  #Scenario: To verify User is able to save AWB by selecting his CHA organization name from ‘Select CHA' drop down list where forwarding and CHA activities are performed from same organization
//		#@152360		step definition   #Scenario: To verify User is able to save AWB by selecting its preferred CHA trade partner from 'Select CHA' drop down list where forwarding and CHA activities are performed from different organization 

		   @When("^Click on Routing Info button and enter Destn \"([^\"]*)\" and Via \"([^\"]*)\" and Flight No \"([^\"]*)\" for CHA activities are performed from different organization$")
		    public void click_on_routing_info_button_and_enter_destn_and_via_and_flight_no_for_CHA_activities_are_performed_from_different_organization(String DestnPort, String Via_1, String FlightNo) throws Throwable {
		    	
//		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnRoutingInfo);
		        wm.scrolldownUsingJSE(driver, "400");
		        Thread.sleep(1000);
		    	createAWB.clickOnBtn("Routing Info");
		        wm.VisibilityOfElementExplicityWait(driver, createAWB.RoutingDetailsWindow, 10);
		        verify = wm.isElementPresent(driver, createAWB.RoutingDetailsWindow);
		        Assert.assertTrue(verify);
		        Thread.sleep(3000);

		        createAWB.enter_eAWBData("Destn Port", DestnPort);
		        Thread.sleep(1000);
		        createAWB.enter_eAWBData("Via_1", Via_1);
		        Thread.sleep(1000);
		        createAWB.clickOnBtn("Routing Window Ok");
		        Thread.sleep(2000);
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdChargeCode);
		        Thread.sleep(1000);
		        Select selectChargeCode = new Select(createAWB.DdChargeCode);
		        selectChargeCode.selectByIndex(1);
		        Thread.sleep(1000);
		        createAWB.enter_eAWBData("Flight No", FlightNo);
		        
		        createAWB.DdCustomsBroker.click();
		        Thread.sleep(1000);
		        createAWB.CbCustomsBroker_00.click();
		        
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.BtnAddDimensions); 
		        
		        createAWB.clickOnBtn("Add Dimensions");
		        wm.VisibilityOfElementExplicityWait(driver, createAWB.DimesionsWindow, 5);
		        wm.isElementPresent(driver, createAWB.DimesionsWindow);
		        Assert.assertTrue(verify);
		        Thread.sleep(3000);
		        createAWB.AddDimensions("10", "10", "10", "10", 1);
		        createAWB.clickOnBtn("Dimensions Ok");
		        wm.ImplicitlyWait(driver, 5);
		        wm.JavascriptExecutor_ElementScroll(driver, createAWB.DdRateClass);
		        createAWB.enter_eAWBData("Gross Weight", "10");
		        Thread.sleep(2000);
		        
		         
		        Select selectRateClass = new Select(createAWB.DdRateClass);
		        selectRateClass.selectByIndex(1);
		        Thread.sleep(1000);
		     
		      
		        createAWB.enter_eAWBData("Nature Of Goods", "Plastic");
		     
		        createAWB.enter_eAWBData("Rate charge", "5");
		        Thread.sleep(1000);
		        
		        Thread.sleep(1000);
		        createAWB.enter_eAWBData("Due Carrier box1", "AWC");
		        Thread.sleep(1500);
				Actions select = new Actions(driver);
		        select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
		        Thread.sleep(1000);
		        
//		        createAWB.enter_eAWBData("Due Carrier box2", "251");
		        createAWB.DueCarrierBox2.sendKeys("251");
		        Thread.sleep(1000);
		       
		     
		        
		    }
		   
		   
		  
//		#@152361		step definition#Scenario: To verify User is able to save AWB by selecting option ‘Other’ from 'Select CHA' drop down list where forwarding and CHA activities are performed from different organization. This will be used where TSP is generated by an adhoc CHA
	    
//		#@152362		step definition	#Scenario: To verify After creation AWBs,Amount should be deducted from the Balance amount

	    @Then("^check balance amount message is displayed for eAWB screen$")
	    public void check_that_balance_amount_message_is_displayed_for_eAWB_screen() throws Throwable {
	        wm.VisibilityOfElementExplicityWait(driver, createAWB.CurrentBal_MsgBox , 100);
	        verify = wm.isElementPresent(driver, createAWB.CurrentBal_MsgBox);
	        cm.Verify(verify, true);
	        Thread.sleep(3000);
	    }
	    
	    double initial_balAmt = 0, final_balAmt = 0; 
	    @Then("^Capture initial balancAmt in inCargobyBLR_Account$")
	    public void Capture_initial_balancAmt_inCargobyBLR_Account() throws Throwable {
	    	initial_balAmt = createAWB.currentBal_inCargobyBLR_Account(); System.out.println("initial_balAmt:"+initial_balAmt);
	    }
	    
	    @Then("^Capture final balancAmt in inCargobyBLR_Account$")
	    public void Capture_final_balancAmt_inCargobyBLR_Account() throws Throwable {
	    	final_balAmt = createAWB.currentBal_inCargobyBLR_Account(); System.out.println("final_balAmt:"+final_balAmt);
	    }
	    
	    
	    @Then("^verify after creation AWBs,Amount should be deducted from the Balance amount$")
	    public void verify_after_creation_AWBs_Amount_should_be_deducted_from_the_Balance_amount() throws Throwable {
	    	System.out.println("initial_balAmt:" + initial_balAmt + "   final_balAmt:"+ final_balAmt); Thread.sleep(2000);
	    	Assert.assertTrue(initial_balAmt>final_balAmt);
	    	System.out.println("*****Amount gets deducted but somtime it takes a lot of time to reflect... "
	    			+ "hence the TC may Fail");
	    }
		
	    @When("^Click on \"([^\"]*)\" button of user for eAwb$")
	    public void click_on_button_of_user_for_eAwb(String arg1) throws Throwable {
	    	Thread.sleep(1000); home.ClickOnLogoutButton();
	    }  
	    @Then("^Navigated to login screen for eAwb$")
	    public void Navigated_to_login_screen_for_eAwb() throws Throwable {
	    	  wm.VisibilityOfElementExplicityWait(driver, login.LoginScreen, 15);
	    }
    
//	    E_AWB_152362
	    
	    @When("^Enter \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" for eAWB$")
	    public void enter_and_for_eAWB(String prefix, String fieldName1, String fieldName2) throws Throwable {
	    	 Prefix = prefix; System.out.println(Prefix+": "+fieldName1+": "+fieldName2+": ");
	 		createAwb.enter_eAWBData(fieldName1, Prefix);
	 		Thread.sleep(3000);
	 	    awbNo = createAwb.EnterAwbNo();
	 	    System.out.println(Prefix+awbNo);
	    }

	    @When("^Select \"([^\"]*)\" \"([^\"]*)\" for eAWB$")
	    public void select_for_eAWB(String value, String  fieldName) throws Throwable {
	    	System.out.println("fieldName::value =="+fieldName+"::"+value); Thread.sleep(2000);
			createAwb.enter_eAWBData(fieldName, value);
	    }

	    @When("^Click on \"([^\"]*)\" icon to add rounting details for eAWB$")
	    public void click_on_icon_to_add_rounting_details_for_eAWB(String iconName) throws Throwable {
	    	   createAwb.clickOnBtn(iconName);
	    }

	    @Then("^Routing details popup opened and \"([^\"]*)\" origin alreday selected for eAWB$")
	    public void routing_details_popup_opened_and_origin_alreday_selected_for_eAWB(String arg1) throws Throwable {
	    	wm.VisibilityOfElementExplicityWait(driver, createAwb.RoutingDetailsWindow, 10);
		    verify = wm.isElementPresent(driver, createAwb.RoutingDetailsWindow);
		    cm.Verify(verify, true);
	    }

	    @When("^Click on \"([^\"]*)\" button of Routing Details popup for eAWB$")
	    public void click_on_button_of_Routing_Details_popup_for_eAWB(String arg1) throws Throwable {
//			createAwb.ClickOnRoutingInfoButton(buttonName);
			wm.ClickUsingJSExecutor(driver, createAwb.BtnOkRoutingDetail);
	    }

	    @Then("^Destinaiton filed get populated with \"([^\"]*)\" for eAWB$")
	    public void destinaiton_filed_get_populated_with_for_eAWB(String arg1) throws Throwable {
	        
	    }

	    @When("^Add (\\d+) flight details with \"([^\"]*)\" flight code for eAWB$")
	    public void add_flight_details_with_flight_code_for_eAWB(int rowNo, String iconName) throws Throwable {
	    	  flightNo = cm.RandomNo(3); System.out.println("flightNo:"+flightNo);
	  	    createAwb.enter_eAWBData("Flight No", flightNo);
	    }

	    @When("^Click on \"([^\"]*)\" icon of (\\d+) rate line for eAWB$")
	    public void click_on_icon_of_rate_line_for_eAWB(String iconName, int rowNo) throws Throwable {
	    	createAwb.ClickOnCargoDetailsIcon(iconName, rowNo);
	    }

	    @Then("^Dimensions popup opened for eAWB$")
	    public void dimensions_popup_opened_for_eAWB() throws Throwable {
	    	  wm.VisibilityOfElementExplicityWait(driver, createAwb.DimesionsWindow, 15);
	  	    verify = wm.isElementPresent(driver, createAwb.DimesionsWindow);
	  	    cm.Verify(verify, true);
	    }

	    @When("^Add (\\d+) dimesnsions with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" for eAWB$")
	    public void add_dimesnsions_with_and_and_and_for_eAWB(int rowNo, String noOfPcs, String length, String width, String height) throws Throwable {
	    	 createAwb.AddDimensions(noOfPcs, length, width, height, rowNo);
	    }

	    @When("^Click on \"([^\"]*)\" button of Dimesnsions for eAWB$")
	    public void click_on_button_of_Dimesnsions_for_eAWB(String buttonName) throws Throwable {
	    	createAwb.ClickOnDimensionsButton(buttonName);
	    }

	    @Then("^No of pcs will get populated with \"([^\"]*)\" of (\\d+) rate line for eAWB$")
	    public void no_of_pcs_will_get_populated_with_of_rate_line_for_eAWB(String arg1, int arg2) throws Throwable {
	    	 //pending
	    }

	    @When("^Add (\\d+) rate line details with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" anf \"([^\"]*)\" for eAWB$")
	    public void add_rate_line_details_with_and_and_anf_for_eAWB(int rowNo, String grWt, String rateClass, String rate, String natureOfGoods) throws Throwable {
	    	 createAwb.AddRateLineDetails(grWt, rateClass, rate, natureOfGoods, rowNo);
	    }

	    @When("^Enter (\\d+) \"([^\"]*)\" and \"([^\"]*)\" for eAWB$")
	    public void enter_and_for_eAWB(int rowNo, String dueCarrierCode, String dueCarrierAmount) throws Throwable {
	    	 createAwb.AddDueCarrier(dueCarrierCode, dueCarrierAmount, rowNo);
	    }

	    @When("^Click on \"([^\"]*)\" button for eAWB$")
	    public void click_on_button_for_eAWB(String buttonName) throws Throwable {
	    	 createAwb.clickOnBtn(buttonName);
	    }

	    @Then("^Success popup displayed with message \"([^\"]*)\" for eAWB$")
	    public void success_popup_displayed_with_message_for_eAWB(String ElementText) throws Throwable {
	    	 wm.VisibilityOfElementExplicityWait(driver, createAwb.AWBSaveWindow, 20);
	 	    verify = wm.isElementPresent(driver, createAwb.AWBSaveWindow);
	 	    cm.Verify(verify, true);
	 	    verify = wm.isElementTextContain(driver, createAwb.AWBSaveMessage, ElementText);
	 	    cm.Verify(verify, true);
	 	    Thread.sleep(1000);
	    }

	    @When("^Click on \"([^\"]*)\" button of Success popup for eAWB$")
	    public void click_on_button_of_Success_popup_for_eAWB(String buttonName) throws Throwable {
	    	Thread.sleep(1000);
		    createAwb.ClickOnSaveMessagePopupButton(buttonName);
	    }

	    @Then("^AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for eAWB$")
	    public void awb_successfully_created_and_navigated_to_MAWB_List_screen_able_to_see_saved_details_in_the_grid_for_eAWB() throws Throwable {
	    	 wm.VisibilityOfElementExplicityWait(driver, mawbList.MawbListScreen, 20);
	 	    verify = wm.isElementPresent(driver, mawbList.MawbListScreen);
	 	    cm.Verify(verify, true);
	 	    verify = wm.isElementPresent(driver, awbNo);
	 	    cm.Verify(verify, true);
	    }

	    @When("^Click on \"([^\"]*)\" icon of (\\d+) mawb for eAWB$")
	    public void click_on_icon_of_mawb_for_eAWB(String iconName, int rowNo) throws Throwable {
	    	Thread.sleep(8000);  
			mawbList.ClickOnGridIcon(iconName, rowNo); Thread.sleep(5000);
	    }

	    @Then("^MAWB ASI popup opened with \"([^\"]*)\" message for eAWB$")
	    public void mawb_ASI_popup_opened_with_message_for_eAWB(String ElementText) throws Throwable {
	    	  wm.VisibilityOfElementExplicityWait(driver, mawbList.MawbAsiPopup, 15);
	  	    verify = wm.isElementPresent(driver, mawbList.MawbAsiPopup);
	  	    cm.Verify(verify, true);
	  	    verify = wm.isElementTextContain(driver, mawbList.MawbAsiPopupMsg, ElementText);
	  	    cm.Verify(verify, true);
	    }

	    @When("^Click on \"([^\"]*)\" button of MAWB ASI popup for eAWB$")
	    public void click_on_button_of_MAWB_ASI_popup_for_eAWB(String buttonName) throws Throwable {
	    	 mawbList.ClickOnMawbAsiPopupButton(buttonName);
	    }

	    @Then("^ASI successfully submited with \"([^\"]*)\" title for eAWB$")
	    public void asi_successfully_submited_with_title_for_eAWB(String attributevalue) throws Throwable {
	    	wm.ElementAttributeContainsExplicityWait(driver, mawbList.ASI_IconList.get(0), "title", attributevalue, 20);
			verify = wm.isElementAttributeValueContain(driver, mawbList.ASI_IconList.get(0), "title", attributevalue);
			cm.Verify(verify, true);
	    }

	    @Then("^Carting Order Request popup is opened with \"([^\"]*)\" message for eAWB$")
	    public void carting_Order_Request_popup_is_opened_with_message_for_eAWB(String ElementText) throws Throwable {
	    	System.out.println(	mawbList.CartingOrderPopup.getText());
			wm.VisibilityOfElementExplicityWait(driver, mawbList.CartingOrderPopup, 15);
		    verify = wm.isElementPresent(driver, mawbList.CartingOrderPopup);
		    cm.Verify(verify, true);
		    verify = wm.isElementTextContain(driver, mawbList.CartingOrderPopupMsg, ElementText);
		    cm.Verify(verify, true);
	    }

	    @When("^Select \"([^\"]*)\" and click on \"([^\"]*)\" button of Carting Order Request popup for eAWB$")
	    public void select_and_click_on_button_of_Carting_Order_Request_popup_for_eAWB(String airlineName, String buttonName) throws Throwable {
	    	mawbList.SendCO_RequestToAirline(airlineName);
	    }

	    @Then("^CO message popup opened with \"([^\"]*)\" message for eAWB$")
	    public void co_message_popup_opened_with_message_for_eAWB(String ElementText) throws Throwable {
	    	  wm.VisibilityOfElementExplicityWait(driver, mawbList.CO_MessagePopup, 15);
	  	    verify = wm.isElementPresent(driver, mawbList.CO_MessagePopup);
	  	    cm.Verify(verify, true);
	  	    verify = wm.isElementTextContain(driver, mawbList.CO_MessagePopupMsg, ElementText);
	  	    cm.Verify(verify, true);
	    }

	    @When("^Click on \"([^\"]*)\" button for CO message popup for eAWB$")
	    public void click_on_button_for_CO_message_popup_for_eAWB(String buttonName) throws Throwable {
	    	mawbList.ClickOnCO_MessagePopupButton(buttonName);
	    }

	    @Then("^Carting order request send with \"([^\"]*)\" title for eAWB$")
	    public void carting_order_request_send_with_title_for_eAWB(String attributevalue) throws Throwable {
	    	wm.ElementAttributeContainsExplicityWait(driver, mawbList.CO_IconList.get(0), "title", attributevalue, 20);
			verify = wm.isElementAttributeValueContain(driver, mawbList.CO_IconList.get(0), "title", attributevalue);
			cm.Verify(verify, true);
	    }

	    @When("^Click on \"([^\"]*)\" button of user for eAWB$")
	    public void click_on_button_of_user_for_eAWB(String arg1) throws Throwable {
	    	wm.ImplicitlyWait(driver, 2); Thread.sleep(500);
			 home.ClickOnLogoutButton();
	    }

	    @Then("^Navigated to login screen for eAWB$")
	    public void navigated_to_login_screen_for_eAWB() throws Throwable {
		    wm.VisibilityOfElementExplicityWait(driver, login.LoginScreen, 15);
	    }

	    @When("^Login with airline user in Bial application for eAWB$")
	    public void login_with_airline_user_in_Bial_application_for_eAWB() throws Throwable {
	    	  login.Login(AirlineUsername, AirlinePassword);
	    }

	    @Then("^Verify Navigated to Home screen for eAWB$")
	    public void verify_Navigated_to_Home_screen_for_eAWB() throws Throwable {
	    	 wm.VisibilityOfElementExplicityWait(driver, menu.MenuBar, 20);
	   	    verify = wm.isElementPresent(driver, menu.MenuBar);
	   	    cm.Verify(verify, true);
	    }

	    @Then("^CO Shipment screen dispalyed for eAWB$")
	    public void co_Shipment_screen_dispalyed_for_eAWB() throws Throwable {
	        wm.VisibilityOfElementExplicityWait(driver, coApproval.coApprovalScreen, 15);
		    verify = wm.isElementPresent(driver, coApproval.coApprovalScreen);
		    cm.Verify(verify, true);
	    }

	    @When("^Enter mawb no and click on \"([^\"]*)\" button of CO approval screen for eAWB$")
	    public void enter_mawb_no_and_click_on_button_of_CO_approval_screen_for_eAWB(String arg1) throws Throwable {
	    	 mawb =Prefix+awbNo; System.out.println("mawb::"+mawb); 
		     coApproval.SearchMawb(mawb);
	    }

	    @Then("^Mawb no shipment only displayed in the CO approval grid for eAWB$")
	    public void mawb_no_shipment_only_displayed_in_the_CO_approval_grid_for_eAWB() throws Throwable {
	    	//pending
	    }

	    @When("^Click on \"([^\"]*)\" icon of (\\d+) shipment for eAWB$")
	    public void click_on_icon_of_shipment_for_eAWB(String iconName, int rowNo) throws Throwable {
	    	   coApproval.ClickOnGridIcon(iconName, rowNo);
	    }

	    @Then("^Naviaged to Carting Order Approval screen with all shipment details displayed eAWB$")
	    public void naviaged_to_Carting_Order_Approval_screen_with_all_shipment_details_displayed_eAWB() throws Throwable {
	    	wm.VisibilityOfElementExplicityWait(driver, coApproval.CartingOrderApprovalScreen, 15);
		    verify = wm.isElementPresent(driver, coApproval.CartingOrderApprovalScreen);
		    cm.Verify(verify, true);
	    }

	    @When("^Click on \"([^\"]*)\" button of CO Approval screen for eAWB$")
	    public void click_on_button_of_CO_Approval_screen_for_eAWB(String buttonName) throws Throwable {
	    	 coApproval.ClickOnCartingOrderApprovalButton(buttonName);
	    }

	    @Then("^Success popup opened with \"([^\"]*)\" message for eAWB$")
	    public void success_popup_opened_with_message_for_eAWB(String ElementText) throws Throwable {
	    	wm.VisibilityOfElementExplicityWait(driver, coApproval.SuccessPopup, 15);
		    verify = wm.isElementPresent(driver, coApproval.SuccessPopup);
		    cm.Verify(verify, true);
		    verify = wm.isElementTextContain(driver, coApproval.SuccessPopupMsg, ElementText);
		    cm.Verify(verify, true);
	    }

	    @When("^Click on \"([^\"]*)\" button of Success popup in CO Approval screen for eAWB$")
	    public void click_on_button_of_Success_popup_in_CO_Approval_screen_for_eAWB(String buttonName) throws Throwable {
	    	 coApproval.ClickOnSuccessPopupButton(buttonName);
	    }

	    @When("^Login in Bial application for eAWB$")
	    public void login_in_Bial_application_for_eAWB() throws Throwable {
	    	login.Login(AgentUsername, AgentPassword);
	    }

	    @When("^Add fliter to \"([^\"]*)\" column with \"([^\"]*)\" in MAWB list grid for eAWB$")
	    public void add_fliter_to_column_with_in_MAWB_list_grid_for_eAWB(String colName, String arg2) throws Throwable {
	    	 System.out.println("filtered awbNo:"+awbNo);
	 		mawbList.Filter(colName, awbNo, "Contains");
	    }

	    @Then("^Flitered mawb no only visible in MAWB list grid for eAWB$")
	    public void flitered_mawb_no_only_visible_in_MAWB_list_grid_for_eAWB() throws Throwable {
	        // pending
	    }

	    @Then("^Shipping Bill Details screen opened and able to mawb no for eAWB$")
	    public void shipping_Bill_Details_screen_opened_and_able_to_mawb_no_for_eAWB() throws Throwable {
	    	wm.VisibilityOfElementExplicityWait(driver, mawbList.ShippingBillDetailsScreen, 15);
		    verify = wm.isElementPresent(driver, mawbList.ShippingBillDetailsScreen);
		    cm.Verify(verify, true);
	    }

	    @When("^Add (\\d+) shipping bill details with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" for eAWB$")
	    public void add_shipping_bill_details_with_and_and_and_and_and_for_eAWB(int rowNo, String sbType, 
	    		String nop, String length, String width, String height, String grwt) throws Throwable {
	    	 Thread.sleep(2000); wm.ImplicitlyWait(driver, 2);
	 	    sbDate = cm.SpecificDate("dd MMM yyyy", cm.CurrentDate("dd MMM yyyy"), -7);
	 	    if(rowNo>1) {
	 	    	sbNo = cm.RandomNo(7); System.out.println("rowNo: "+rowNo+"   sbNo:"+sbNo);
	 	    	mawbList.AddSB_Details1__(sbNo, sbDate, sbType, nop, grwt, length, width, height, rowNo);
	 		}else {
	 			String sbNo2 = cm.RandomNo(7); System.out.println("rowNo: "+rowNo+"   sbNo:"+sbNo2);
	 	    	mawbList.AddSB_Details1__(sbNo2, sbDate, sbType, nop, grwt, length, width, height, rowNo);
	 		}
	    }

	    @When("^Click on \"([^\"]*)\" button in shipping bill details screen for eAWB$")
	    public void click_on_button_in_shipping_bill_details_screen_for_eAWB(String buttonName) throws Throwable {
	    	   mawbList.ClickOnSB_DetailsPopupButton(buttonName);
	    }

	    @Then("^Shipping Bill popup opened with \"([^\"]*)\" message for eAWB$")
	    public void shipping_Bill_popup_opened_with_message_for_eAWB(String ElementText) throws Throwable {
	    	wm.VisibilityOfElementExplicityWait(driver, mawbList.ShippingBillPopup, 15);
		    verify = wm.isElementPresent(driver, mawbList.ShippingBillPopup);
		    cm.Verify(verify, true);
		    verify = wm.isElementTextContain(driver, mawbList.ShippingBillPopupMsg, ElementText);
		    cm.Verify(verify, true);
	    }

	    @When("^Click on \"([^\"]*)\" button of shipping bill popup for eAWB$")
	    public void click_on_button_of_shipping_bill_popup_for_eAWB(String buttonName) throws Throwable {
	    	 mawbList.ClickOnShippingBillPopupButton(buttonName);
	    }

	    @Then("^Navigated to MAWB list screen for eAWB$")
	    public void navigated_to_MAWB_list_screen_for_eAWB() throws Throwable {
	    	wm.VisibilityOfElementExplicityWait(driver, mawbList.MawbListScreen, 15);
		    verify = wm.isElementPresent(driver, mawbList.MawbListScreen);
		    cm.Verify(verify, true);
	    }

	    @Then("^SB details grid displayed for eAWB$")
	    public void sb_details_grid_displayed_for_eAWB() throws Throwable {
	    	  wm.VisibilityOfElementExplicityWait(driver, mawbList.MawbListSB_Grid1, 5);
//	  	    verify = wm.isElementPresent(driver, mawbList.MawbListSB_Grid1);
//	  	    cm.Verify(verify, true);
	    }

	    @Then("^SB ASI Submission popup opened for eAWB$")
	    public void sb_ASI_Submission_popup_opened_for_eAWB() throws Throwable {
	    	wm.VisibilityOfElementExplicityWait(driver, mawbList.SB_ASI_SubmissionPopup, 10);
		    verify = wm.isElementPresent(driver, mawbList.SB_ASI_SubmissionPopup);
		    cm.Verify(verify, true); 
	    }

	    @When("^Click on \"([^\"]*)\" button of SB ASI Submission popup for eAWB$")
	    public void click_on_button_of_SB_ASI_Submission_popup_for_eAWB(String buttonName) throws Throwable {
	    	Thread.sleep(3000);
		    mawbList.ClickOnSB_ASI_SubmissionPopupButton(buttonName);
	    }

	    @Then("^SB ASI Confirmation popup opened with \"([^\"]*)\" message for eAWB$")
	    public void sb_ASI_Confirmation_popup_opened_with_message_for_eAWB(String ElementText) throws Throwable {
	    	wm.VisibilityOfElementExplicityWait(driver, mawbList.SB_ASI_ConfirmationPopup, 10);
		    verify = wm.isElementPresent(driver, mawbList.SB_ASI_ConfirmationPopup);
		    cm.Verify(verify, true);
		    verify = wm.isElementTextContain(driver, mawbList.SB_ASI_ConfirmationPopupMsg, ElementText);
		    cm.Verify(verify, true);
	    }

	    @When("^Click on \"([^\"]*)\" button of SB ASI Confirmation popup for eAWB$")
	    public void click_on_button_of_SB_ASI_Confirmation_popup_for_eAWB(String buttonName) throws Throwable {
	    	mawbList.ClickOnSB_ASI_ConfirmationPopupButton(buttonName);
	    }

	    @Then("^SB Advance Shipment Information popup opened with \"([^\"]*)\" message for eAWB$")
	    public void sb_Advance_Shipment_Information_popup_opened_with_message_for_eAWB(String ElementText) throws Throwable {
	    	wm.VisibilityOfElementExplicityWait(driver, mawbList.SB_AdvanceShipmentInformationPopup, 10);
		    verify = wm.isElementPresent(driver, mawbList.SB_AdvanceShipmentInformationPopup);
		    cm.Verify(verify, true);
		    verify = wm.isElementTextContain(driver, mawbList.SB_AdvanceShipmentInformationPopupMsg, ElementText);
		    cm.Verify(verify, true);
	    }

	    @When("^Click on \"([^\"]*)\" button of SB Advance Shipment Information popup for eAWB$")
	    public void click_on_button_of_SB_Advance_Shipment_Information_popup_for_eAWB(String buttonName) throws Throwable {
	    	mawbList.ClickOnSB_AdvanceShipmentInformationPopupButton(buttonName);
	    }

	    @Then("^SB ASI successfully submited for eAWB$")
	    public void sb_ASI_successfully_submited_for_eAWB() throws Throwable {
	    	 //pending
	    }

	    
	    
    
}
