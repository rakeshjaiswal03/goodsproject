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
import Pages.LoginPage;
import Pages.RegistrationPage;
import Pages.homepage;
import Pages.AirlineApproval.Import.ShipmentDetails;
import Pages.Import.Add_MAWB_Details_screen;
import Pages.Import.MyShipment.BoE_DetailsScreen;
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
import junit.framework.Assert;

public class Test_Import2 {
	

	public WebDriver driver;
	public Setup launch;
	public WebdriverMethods wm;
	public CommonMethods cm;
	
	public LoginPage login;
	public BialMenu menu;

	public Add_MAWB_Details_screen addMAWB_detailscreen;
	public CreatePage createJob;
	public SavedPage savedJob;
	public SentPage sentJob;
	public DraftsPage draft;
	public TemplatesPage template;
	public BookingShipmentPage bookingShipment;
	public CreateAWBPage createAwb;
	public HouseManifestPage createHawb;
	public MawbListPage mawbList;
	public RegistrationPage rp;
	public homepage home;
	public ShipmentDetails shipmentDetails; 
	public BoE_DetailsScreen BoE_screen; 
	String randomNo = null;
	public boolean verify = false;
	String ConfigKeysFile = "Config_Keys.properties";
	String geckoDriverPath = null, URL = null,AirlineUsername = null, AirlinePassword = null,  AgentUsername = null, AgentPassword = null;
	String DownloadPath = null, DownloadFile = null, eDocketUploadFile = null;
	String CompanyName = null, ieNo = null, ShipperEmailId = null, ShipperAddressLine1 = null;
	String ConsigneeName = null, ConsigneeEmailId = null, ConsigneeAddressLine1 = null, unNo = null, Cls = null;
	String DraftName = null, TemplateName = null;
	String UrnNo = null, ShipperName = null, OriginCode = null, DestinationCode = null;
	String scheduleForDate = null, awbNo = null, flightNo = null;
	String hawbNo = null, IGM_No= null, NoP =null, BoE_doc = null;
	
	@Given("^forImport2 Launch Browser and Bial application link$")
	public void forImport2_launch_Browser_and_Bial_application_link() throws Throwable {
		File file = new File(ConfigKeysFile);
		InputStream fis = new FileInputStream(file);
		Properties pf = new Properties();
		pf.load(fis);
		
		geckoDriverPath = pf.getProperty("GeckodriverPath");
//		URL = pf.getProperty("URL");
		URL = pf.getProperty("STGLink");
		AgentUsername = pf.getProperty("agentUsername");
		AgentPassword = pf.getProperty("agentPassword");
		AirlineUsername = pf.getProperty("airlineUsername");
		AirlinePassword = pf.getProperty("airlinePassword");
		DownloadPath = pf.getProperty("DownloadPath");
		eDocketUploadFile = pf.getProperty("eDocketFilePath");
		BoE_doc = pf.getProperty("BoE_docPath"); 
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
		addMAWB_detailscreen = new Add_MAWB_Details_screen(driver,wm,cm);
		rp = new RegistrationPage(driver, wm, cm);
		home = new homepage(driver, wm);
		shipmentDetails = new ShipmentDetails(driver, wm, cm);
		BoE_screen = new BoE_DetailsScreen(driver, wm, cm);
	}

	@When("^forImport2 Login in Bial application$")
	public void forImport2_login_in_Bial_application_for_e_Booking_screen() throws Throwable {
		login.Login(AgentUsername, AgentPassword);
	}

	@Then("^forImport2 Verify Navigated to Home screen$")
	public void forImport2_verify_Navigated_to_Home_screen() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, menu.MenuBar, 80);
	    verify = wm.isElementPresent(driver, menu.MenuBar);
	    cm.Verify(verify, true); Thread.sleep(2000);
	}
	
	@Given("^forImport2 Navigate to Create AWB for eAWB screen$")
	public void forImport2_Navigate_to_Create_AWB_for_eAWB_screen() throws Throwable {
		 menu.MainMenuHover("e-AWB"); 		Thread.sleep(5000);
        	menu.ClickOnSubMenu("Create AWB");	Thread.sleep(5000);
	}
	
	@Then("^forImport2 Verify that balance amount message is displayed for eAWB screen$")
	public void forImport2_Verify_that_balance_amount_message_is_displayed_for_eAWB_screen() throws Throwable {
		 wm.VisibilityOfElementExplicityWait(driver, createAwb.CurrentBal_MsgBox , 100);
	        verify = wm.isElementPresent(driver, createAwb.CurrentBal_MsgBox);
	        Assert.assertTrue(verify);   Thread.sleep(3000);
	}
	
	@Then("^forImport2 Click in Ok button of message for eAWB screen$")
	public void forImport2_Click_in_Ok_button_of_message_for_eAWB_screen() throws Throwable {
		 createAwb.clickOnBtn("CurrentBal_OK"); 				Thread.sleep(500);
	}
	
	@When("^forImport2 Enter AWB prefix and AWB number for eAWB screen$")
	public void forImport2_Enter_AWB_prefix_and_AWB_number_for_eAWB_screen() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createAwb.TxtAwbNo, 40);		 Thread.sleep(1000); 
		createAwb.enter_eAWBData("Awb Prefix", "777");		
		  awbNo =  cm.Random_awbNo(); 				System.out.println("entered AWB no:"+awbNo);			Thread.sleep(1000);  
		  createAwb.TxtAwbNo.clear();
		  createAwb.TxtAwbNo.sendKeys(awbNo); 
	 
	}
	
	@When("^forImport2 Enter \"([^\"]*)\" and \"([^\"]*)\" for eAWB screen$")
	public void forImport2_Enter_and_for_eAWB_screen(String acsshipper, String acsconsigneeatl) throws Throwable {
		  createAwb.enter_eAWBData("Shipper Name", acsshipper);
	        Thread.sleep(2000);
	        createAwb.enter_eAWBData("Consignee Name", acsconsigneeatl);
	}
	
	@When("^forImport2 Click on Routing Info button and enter Destn \"([^\"]*)\" and Via \"([^\"]*)\" and Flight No \"([^\"]*)\" for eAWB screen Create_Direct_eAWB$")
	public void forImport2_Click_on_Routing_Info_button_and_enter_Destn_and_Via_and_Flight_No_for_eAWB_screen_Create_Direct_eAWB(String DestnPort, String Via_1, String FlightNo) throws Throwable {
      wm.scrolldownUsingJSE(driver, "400");
      Thread.sleep(1000);
  	createAwb.clickOnBtn("Routing Info");
      wm.VisibilityOfElementExplicityWait(driver, createAwb.RoutingDetailsWindow, 10);
      verify = wm.isElementPresent(driver, createAwb.RoutingDetailsWindow);
      Assert.assertTrue(verify);
      Thread.sleep(3000);

      createAwb.enter_eAWBData("Destn Port", DestnPort);
      Thread.sleep(1000);
      createAwb.enter_eAWBData("Via_1", Via_1);
      Thread.sleep(1000);
      createAwb.clickOnBtn("Routing Window Ok");
      Thread.sleep(2000);
      wm.JavascriptExecutor_ElementScroll(driver, createAwb.DdChargeCode);
      Thread.sleep(1000);
      Select selectChargeCode = new Select(createAwb.DdChargeCode);
      selectChargeCode.selectByIndex(1);
      Thread.sleep(1000);
      createAwb.enter_eAWBData("Flight No", FlightNo);
      
      createAwb.DdCustomsBroker.click();
      Thread.sleep(1000);
      createAwb.CbCustomsBroker_01.click();
      
      wm.JavascriptExecutor_ElementScroll(driver, createAwb.BtnAddDimensions); 
      
      createAwb.clickOnBtn("Add Dimensions");
      wm.VisibilityOfElementExplicityWait(driver, createAwb.DimesionsWindow, 5);
      wm.isElementPresent(driver, createAwb.DimesionsWindow);
      Assert.assertTrue(verify);
      Thread.sleep(3000);
      createAwb.AddDimensions("10", "10", "10", "10", 1);
      createAwb.clickOnBtn("Dimensions Ok");
      wm.ImplicitlyWait(driver, 5);
      wm.JavascriptExecutor_ElementScroll(driver, createAwb.DdRateClass);
      createAwb.enter_eAWBData("Gross Weight", "10");
      Thread.sleep(2000);
      
       
      Select selectRateClass = new Select(createAwb.DdRateClass);
      selectRateClass.selectByIndex(1);
      Thread.sleep(1000);
   
    
      createAwb.enter_eAWBData("Nature Of Goods", "Plastic");
   
      createAwb.enter_eAWBData("Rate charge", "5");
      Thread.sleep(1000);
      
      Thread.sleep(1000);
      createAwb.enter_eAWBData("Due Carrier box1", "AWC");
      Thread.sleep(1500);
		Actions select = new Actions(driver);
      select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
      Thread.sleep(1000);
      
//      createAwb.enter_eAWBData("Due Carrier box2", "251");
      createAwb.DueCarrierBox2.sendKeys("251");
      Thread.sleep(1000);
     
	}
	
	@When("^forImport2 Click on Save eAWB button for eAWB screen$")
	public void forImport2_Click_on_Save_eAWB_button_for_eAWB_screen() throws Throwable {
		wm.scrolldownUsingJSE(driver, "2000");
    	Thread.sleep(1000);
    	wm.ClickUsingJSExecutor(driver, createAwb.BtnSaveAwb);
	}
	
	@Then("^forImport2 Verify Success message is displayed for eAWB screen$")
	public void forImport2_Verify_Success_message_is_displayed_for_eAWB_screen() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createAwb.AWBSaveWindow, 20);
        verify = wm.isElementTextContain(driver, createAwb.AWBSaveMessage, "Air Waybill saved successfully");
        Assert.assertTrue(verify);
        Thread.sleep(3000);
        createAwb.clickOnBtn("AWB Save Ok");
        Thread.sleep(5000);
	}
	
	@When("^forImport2 Click on \"([^\"]*)\" mode\\.$")
	public void forimport2_Click_on_mode(String arg1) throws Throwable {
		Thread.sleep(2000);				wm.VisibilityOfElementExplicityWait(driver, addMAWB_detailscreen.BtnImpMode, 30); 			
		addMAWB_detailscreen.BtnImpMode.click(); Thread.sleep(2000);
	}
	
	@Then("^forImport2 Click on \"([^\"]*)\"  button$")
	public void forimport2_Click_on_button(String arg1) throws Throwable {	
		Thread.sleep(5000); wm.scrolldownUsingJSE(driver, "200");
		wm.VisibilityOfElementExplicityWait(driver, addMAWB_detailscreen.BtnAddMAWBHAWB, 30);
		addMAWB_detailscreen.BtnAddMAWBHAWB.click();
		
	}

	@When("^forImport2 Enter all the MAWB Details and click on Save button\\.$")
	public void forimport2_Enter_all_the_MAWB_Details_and_click_on_Save_button() throws Throwable {
	    addMAWB_detailscreen.TxtMAWBPrefix.sendKeys("777");
	    addMAWB_detailscreen.TxtMAWBNO.sendKeys(awbNo); 
	    
	    String MAWBDt = cm.SpecificDate1("dd MM yyyy",0); 		System.out.println("MAWBDt:"+MAWBDt);			Thread.sleep(1000);
		rp.SelectDate(addMAWB_detailscreen.imgMAWBDt, MAWBDt);

		addMAWB_detailscreen.TxtORGAirPortCode.sendKeys("DUB");
		addMAWB_detailscreen.TxtFlightNo.sendKeys("324");
		String Flight_Date = cm.SpecificDate1("dd MM yyyy",0); 	System.out.println("Flight_Date:"+Flight_Date);	Thread.sleep(1000);
		rp.SelectDate(addMAWB_detailscreen.imgFlightDate, Flight_Date);
		
		IGM_No = cm.RandomNo(7);
		addMAWB_detailscreen.TxtIGMNo.sendKeys(IGM_No);
		String IGM_Date = cm.SpecificDate1("dd MM yyyy",0); 	System.out.println("IGM_Date:"+IGM_Date);		Thread.sleep(1000);
		rp.SelectDate(addMAWB_detailscreen.imgIGMDate, IGM_Date);
		NoP ="55"; 
		addMAWB_detailscreen.Txt_No_Pkgs.sendKeys(NoP);
		addMAWB_detailscreen.Txt_Gr_Wt.sendKeys("200");
		addMAWB_detailscreen.TxtRemark.sendKeys("Direct Shipment for automate testing purpose");
		addMAWB_detailscreen.Txt_Chargable_Wt.sendKeys("200");  ////// not required for now 
		addMAWB_detailscreen.Txt_Descriptionn.sendKeys("Toys"); ////// not required for now  
		wm.scrolldownUsingJSE(driver, "200");
	    addMAWB_detailscreen.BtnSave.click();

	} 

	
	/////// import14 stepdefination

	@Then("^forImport(\\d+)	validate Message \"([^\"]*)\" is displayed and clickon OK$")
	public void forimport_validate_Message_is_displayed_and_clickon_OK(int arg1, String arg2) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, addMAWB_detailscreen.MessagePopup_txt, 20);
		verify = wm.isElementTextContain(driver, addMAWB_detailscreen.MessagePopup_txt, arg2);
		cm.Verify(verify, true); Thread.sleep(2000);
		addMAWB_detailscreen.MessagePopup_OKbtn.click();
		Thread.sleep(5000);
	}
	
	@Then("^forImport(\\d+)	logout from FF username$")
	public void forimport_logout_from_FF_username(int arg1) throws Throwable {
		wm.ImplicitlyWait(driver, 2); Thread.sleep(500);
		 home.ClickOnLogoutButton();
	}
	
	@Then("^forImport(\\d+)  login using airline credential$")
	public void forimport_login_using_airline_credential(int arg1) throws Throwable {
		 login.Login(AirlineUsername, AirlinePassword);
	}
	
	@Then("^forImport(\\d+)	Enter IGM number and clickon Search btn$")
	public void forimport_Enter_IGM_number_and_clickon_Search_btn(int arg1) throws Throwable {
		shipmentDetails.IGM_No_TB.sendKeys(IGM_No); 
		shipmentDetails.SearchBtn.click();
	}
	
	@Then("^forImport(\\d+)	clickon Action Pending ADO$")
	public void forimport_clickon_Action_Pending_ADO(int arg1) throws Throwable {
	   shipmentDetails.ActionBtn_pendingADO.click();
	}
	
	@Then("^forImport(\\d+)	validate Approve DO popup is displayed$")
	public void forimport_validate_Approve_DO_popup_is_displayed(int arg1) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, shipmentDetails.ApproveDO_popupTitle, 20);
	    verify = wm.isElementPresent(driver, shipmentDetails.ApproveDO_popupTitle); 
	    cm.Verify(verify, true);
	    
	}
	
	@Then("^forImport(\\d+)	enter DO No and DO date and click on submit$")
	public void forimport_enter_DO_No_and_DO_date_and_click_on_submit(int arg1) throws Throwable {
//	   ////note DO No. and DO date are optional 
		Thread.sleep(1000);shipmentDetails.ApproveDO_popup_SubmitBtn.click();Thread.sleep(3000);
	}
	
	@Then("^forImport(\\d+)	logout from airline credential$")
	public void forimport_logout_from_airline_credential(int arg1) throws Throwable {
		wm.ImplicitlyWait(driver, 2); Thread.sleep(500);
		 home.ClickOnLogoutButton(); Thread.sleep(2000);
	}

	@Then("^forImport(\\d+)	validate Message \"([^\"]*)\" is displayed and clickon OK in ShipmentDetails Screen$")
	public void forimport_validate_Message_is_displayed_and_clickon_OK_in_ShipmentDetails_Screen(int arg1, String message) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, shipmentDetails.MessagePopup_txt, 20);
		verify = wm.isElementTextContain(driver,shipmentDetails.MessagePopup_txt, message);
		cm.Verify(verify, true); Thread.sleep(2000);
		shipmentDetails.MessagePopup_OKbtn.click();
		Thread.sleep(5000);
	}
	@Then("^forImport(\\d+)	filter using IGM$")
	public void forimport_filter_using_IGM(int arg1) throws Throwable {
	     shipmentDetails.Filter("IGM No", IGM_No, "Contains");				 Thread.sleep(2000);
	}
	@Then("^forImport2 click on GridExpandBtn$")
	public void forImport2_click_on_GridExpandBtn(int arg1) throws Throwable {
		 Thread.sleep(2000); 		shipmentDetails.gridExpandBtn.click();
	}
	@Then("^forImport(\\d+)	click on BOE$")
	public void forimport_click_on_BOE(int arg1) throws Throwable {
	   shipmentDetails.BOE_btn.click();
	}
	
	@Then("^forImport(\\d+)	Enter Bill of Entry Details like BOE number, BOE Date, BOE type, NOP, upload BOE$")
	public void forimport_Enter_Bill_of_Entry_Details_like_BOE_number_BOE_Date_BOE_type_NOP_upload_BOE(int arg1) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, BoE_screen.BoE_header, 30);
	   verify =  wm.isElementPresent(driver, BoE_screen.BoE_header); 
	   cm.Verify(verify, true);
	     
	   BoE_screen.BoE_TB.sendKeys(cm.RandomNo(7)); 			Thread.sleep(1000);
	 
	   String BoE_date = cm.SpecificDate1("dd MM yyyy",0); 		System.out.println("BoE_date:"+BoE_date);			Thread.sleep(1000);
	   rp.SelectDate( BoE_screen.BoE_dateImg, BoE_date);
	   wm.selectDropDownElementByVisibleText(driver, BoE_screen.BoE_Type_DD, "Manual");
	   BoE_screen.txtCAV.sendKeys("555");
	   BoE_screen.txtNOP.sendKeys(NoP);
	   BoE_screen.Upload_BoE.click();
	   
	   wm.VisibilityOfElementExplicityWait(driver, BoE_screen.Upload_BoE_BrowserBtn, 30);
	   verify =  wm.isElementPresent(driver, BoE_screen.Upload_BoE_BrowserBtn); 
	   cm.Verify(verify, true);
	   BoE_screen.Upload_BoE_BrowserBtn.click();
	   BoE_screen.Upload_BoE_BrowserBtn.sendKeys(BoE_doc); 			Thread.sleep(3000);
	   BoE_screen.Upload_Btn.click(); 								Thread.sleep(3000);
	   
	   wm.VisibilityOfElementExplicityWait(driver, BoE_screen.DcoumentGrid, 30);
	   verify =  wm.isElementPresent(driver, BoE_screen.DcoumentGrid); 
	   cm.Verify(verify, true);
	   
	   BoE_screen.close_Btn.click(); Thread.sleep(3000);
	}
	
	@Then("^forImport(\\d+)  clickon save$")
	public void forimport_clickon_save(int arg1) throws Throwable {
		  wm.VisibilityOfElementExplicityWait(driver, BoE_screen.btnSaveAWB, 30);
		   verify =  wm.isElementPresent(driver, BoE_screen.btnSaveAWB); 
		   cm.Verify(verify, true);
		   BoE_screen.btnSaveAWB.click();
	}
	
	@Then("^forImport(\\d+)	validate message \"([^\"]*)\" is displayed and clickon OK for BoE Screen$")
	public void forimport_validate_message_is_displayed_and_clickon_OK_for_BoE_Screen(int arg1, String message) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, BoE_screen.MessagePopup_txt, 20);
		verify = wm.isElementTextContain(driver,BoE_screen.MessagePopup_txt, message);
		cm.Verify(verify, true); Thread.sleep(2000);
		BoE_screen.MessagePopup_OKbtn.click();
		Thread.sleep(5000);
	}


	
//	@Then("^forImport(\\d+)	scroll horizontally right / click on expand option$")
//	public void forimport_scroll_horizontally_right_click_on_expand_option(int arg1) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//	
//	@Then("^forImport(\\d+)	click on OoC$")
//	public void forimport_click_on_OoC(int arg1) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//	
//	@Then("^forImport(\\d+)	validate OoC screen is displayed$")
//	public void forimport_validate_OoC_screen_is_displayed(int arg1) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//	
//	@Then("^forImport(\\d+)	Enter Details in OoC screen like   OoC Number, Date, OoC Type==Manual,\\(BOEnumber, BOE date, NOP, CustomerBroker code is autofilled\\) and upload Ooc$")
//	public void forimport_Enter_Details_in_OoC_screen_like_OoC_Number_Date_OoC_Type_Manual_BOEnumber_BOE_date_NOP_CustomerBroker_code_is_autofilled_and_upload_Ooc(int arg1) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//	
//	@Then("^forImport(\\d+)  Refresh the site after some time and click on Reject icon$")
//	public void forimport_Refresh_the_site_after_some_time_and_click_on_Reject_icon(int arg1) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//	

	
	
}
