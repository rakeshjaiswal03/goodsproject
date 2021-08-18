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
import Pages.CO_ApprovalPage;
import Pages.LoginPage;
import Pages.homepage;
import Pages.eAWB.AddConsigneePopUp;
import Pages.eAWB.AddShipperPopUp;
import Pages.eAWB.CreateAWBPage;
import Pages.eAWB.E_AWB_ListPage;
import Pages.eAWB.HouseManifestPage;
import Pages.eAWB.MawbListPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Test_GenerateTSP_VCT {
	
	public WebDriver driver;
	public Setup launch;
	public WebdriverMethods wm;
	public CommonMethods cm;
	
	public LoginPage login;
	public BialMenu menu;
	public homepage home;
	
	public CreateAWBPage createAwb;
	public HouseManifestPage createHawb;
	public MawbListPage mawbList;
	public CO_ApprovalPage coApproval;
	
	String randomNo = null;
	public boolean verify = false;
	String ConfigKeysFile = "Config_Keys.properties";
	String geckoDriverPath = null, URL = null, AgentUsername = null, AgentPassword = null, AirlineUsername = null, AirlinePassword = null, TransactionPassword= null;
	String DownloadPath = null, DownloadFile = null, eDocketUploadFile = null, VehicleTokenNo = null;
	String CompanyName = null, ieNo = null, ShipperEmailId = null, ShipperAddressLine1 = null;
	String ConsigneeName = null, ConsigneeEmailId = null, ConsigneeAddressLine1 = null, unNo = null, Cls = null;
	String DraftName = null, TemplateName = null;
	String UrnNo = null, ShipperName = null, OriginCode = null, DestinationCode = null;
	String scheduleForDate = null, Prefix = null, awbNo = null, flightNo = null;
	String hawbNo = null, sbNo = null, sbDate = null, var = null,  mawb = null;
	
	
	@Given("^Launch Browser and Bial application link for GenerateTSP_VCT$")
	public void launch_Browser_and_Bial_application_link_for_GenerateTSP_VCT() throws Throwable {
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
		TransactionPassword = pf.getProperty("TransactionPassword");
		launch = new Setup();
		driver = launch.LaunchFirefox(geckoDriverPath, DownloadPath, URL);
		
//		driver = launch.LaunchFirefox(geckoDriverPath, URL);
		wm = new WebdriverMethods(driver);
		cm = new CommonMethods();
		
		login = new LoginPage(driver);
		menu = new BialMenu(driver, wm);
		home = new homepage(driver, wm);
		
		createAwb = new CreateAWBPage(driver, wm, cm);
		mawbList = new MawbListPage(driver, wm, cm);
		createHawb = new HouseManifestPage(driver, wm, cm);
		coApproval = new CO_ApprovalPage(driver, wm);
	}

	@When("^Login in Bial application for GenerateTSP_VCT$")
	public void login_in_Bial_application_for_GenerateTSP_VCT() throws Throwable {
		login.Login(AgentUsername, AgentPassword);
	}

    @Then("^Verify Navigated to Home screen for GenerateTSP_VCT$")
    public void verify_navigated_to_home_screen_for_GenerateTSP_VCT() throws Throwable {
    	 wm.VisibilityOfElementExplicityWait(driver, menu.MenuBar, 20);
  	    verify = wm.isElementPresent(driver, menu.MenuBar);
  	    cm.Verify(verify, true);
    }

    @When("^Navigate to Create AWB for GenerateTSP_VCT$")
    public void navigate_to_Create_AWB_for_GenerateTSP_VCT() throws Throwable {
    	    	menu.MainMenuHover("e-AWB");
    			menu.ClickOnSubMenu("Create AWB");
    			
    }
	
    
//    TS_BIAL_01  Step definition
	@Then("^Verify that balance amount message popup is displayed for GenerateTSP_VCT$")
	public void verify_that_balance_amount_message_popup_is_displayed_for_GenerateTSP_VCT() throws Throwable {
//		wm.VisibilityOfElementExplicityWait(driver, createAwb.CurrentBal_MsgContent, 5);
		verify = wm.isElementPresent(driver, createAwb.CurrentBal_MsgContent);
//		cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of message popup for GenerateTSP_VCT$")
	public void click_on_button_of_message_popup_for_GenerateTSP_VCT(String buttonName) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createAwb.CurrentBal_MsgContent, 5);
	    createAwb.ClickOnMessagePopupButton(buttonName);
	}

	@When("^Enter \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" for GenerateTSP_VCT$")
	public void enter_and_for_GenerateTSP_VCT(String prefix, String fieldName1, String fieldName2) throws Throwable {
	    Prefix = prefix; 
		createAwb.enter_eAWBData(fieldName1, Prefix);	Thread.sleep(3000);
	    awbNo = createAwb.EnterAwbNo();    				System.out.println(Prefix+awbNo);
	}
	
	@When("^Enter \"([^\"]*)\" and \"([^\"]*)\" for GenerateTSP_VCT__$")
	public void enter_and_for_GenerateTSP_VCT__( String Awb_Prefix, String Awb_No) throws Throwable {
		createAwb.enter_eAWBData(Awb_Prefix, "777");
		Thread.sleep(3000);
		awbNo =  cm.Random_awbNo();
		createAwb.enter_eAWBData(Awb_No, awbNo);
	    System.out.println(Prefix+awbNo);
	}

	@When("^Select \"([^\"]*)\" \"([^\"]*)\" for GenerateTSP_VCT$")
	public void select_for_GenerateTSP_VCT(String value, String  fieldName) throws Throwable {
		System.out.println("fieldName::value =="+fieldName+"::"+value); Thread.sleep(2000);
		createAwb.enter_eAWBData(fieldName, value);
	}
	
	@When("^Select fieldname\"([^\"]*)\"and enter value\"([^\"]*)\" for GenerateTSP_VCT__$")
	public void select_for_GenerateTSP_VCT__(String fieldName, String value) throws Throwable {
		System.out.println("fieldName::value =="+fieldName+"::"+value);
		createAwb.enter_eAWBData(fieldName, value);
	}
	

	@When("^Select field name\"([^\"]*)\" and enter value \"([^\"]*)\" for GenerateTSP_VCT$")
	public void select_field_name_and_enter_value_for_GenerateTSP_VCT(String arg1, String arg2) throws Throwable {
		Thread.sleep(1000);
		createAwb.enter_eAWBData(arg1, arg2);
	}

	@When("^Click on \"([^\"]*)\" icon to add rounting details for GenerateTSP_VCT$")
	public void click_on_icon_to_add_rounting_details_for_GenerateTSP_VCT(String iconName) throws Throwable {
	    createAwb.clickOnBtn(iconName);
	}

	@Then("^Routing details popup opened and \"([^\"]*)\" origin alreday selected for GenerateTSP_VCT$")
	public void routing_details_popup_opened_and_origin_alreday_selected_for_GenerateTSP_VCT(String arg1) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createAwb.RoutingDetailsWindow, 10);
	    verify = wm.isElementPresent(driver, createAwb.RoutingDetailsWindow);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of Routing Details popup for GenerateTSP_VCT$")
	public void click_on_button_of_Routing_Details_popup_for_GenerateTSP_VCT(String buttonName) throws Throwable {
//		createAwb.ClickOnRoutingInfoButton(buttonName);
		wm.ClickUsingJSExecutor(driver, createAwb.BtnOkRoutingDetail);
	}

	@Then("^Destinaiton filed get populated with \"([^\"]*)\" for GenerateTSP_VCT$")
	public void destinaiton_filed_get_populated_with_for_GenerateTSP_VCT(String arg1) throws Throwable {
	    //pending
	}

	@When("^Add (\\d+) flight details with \"([^\"]*)\" flight code for GenerateTSP_VCT$")
	public void add_flight_details_with_flight_code_for_GenerateTSP_VCT(int rowNo, String iconName) throws Throwable {
	    flightNo = cm.RandomNo(3); System.out.println("flightNo:"+flightNo);
	    createAwb.enter_eAWBData("Flight No", flightNo);
	}

	@When("^Click on \"([^\"]*)\" icon of (\\d+) rate line for GenerateTSP_VCT$")
	public void click_on_icon_of_rate_line_for_GenerateTSP_VCT(String iconName, int rowNo) throws Throwable {
		createAwb.ClickOnCargoDetailsIcon(iconName, rowNo);
	}

	@Then("^Dimensions popup opened for GenerateTSP_VCT$")
	public void dimensions_popup_opened_for_GenerateTSP_VCT() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createAwb.DimesionsWindow, 15);
	    verify = wm.isElementPresent(driver, createAwb.DimesionsWindow);
	    cm.Verify(verify, true);
	}

	@When("^Add (\\d+) dimesnsions with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" for GenerateTSP_VCT$")
	public void add_dimesnsions_with_and_and_and_for_GenerateTSP_VCT(int rowNo, String noOfPcs, String length, String width, String height) throws Throwable {
	    createAwb.AddDimensions(noOfPcs, length, width, height, rowNo);
	}

	@When("^Click on \"([^\"]*)\" button of Dimesnsions for GenerateTSP_VCT$")
	public void click_on_button_of_Dimesnsions_for_GenerateTSP_VCT(String buttonName) throws Throwable {
	    createAwb.ClickOnDimensionsButton(buttonName);
	}

	@Then("^No of pcs will get populated with \"([^\"]*)\" of (\\d+) rate line for GenerateTSP_VCT$")
	public void no_of_pcs_will_get_populated_with_of_rate_line_for_GenerateTSP_VCT(String arg1, int arg2) throws Throwable {
	    //pending
	}

	@When("^Add (\\d+) rate line details with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" anf \"([^\"]*)\" for GenerateTSP_VCT$")
	public void add_rate_line_details_with_and_and_anf_for_GenerateTSP_VCT(int rowNo, String grWt, String rateClass, String rate, String natureOfGoods) throws Throwable {
	    createAwb.AddRateLineDetails(grWt, rateClass, rate, natureOfGoods, rowNo);
	}

	@When("^Enter (\\d+) \"([^\"]*)\" and \"([^\"]*)\" for GenerateTSP_VCT$")
	public void enter_and_for_GenerateTSP_VCT(int rowNo, String dueCarrierCode, String dueCarrierAmount) throws Throwable {
	    createAwb.AddDueCarrier(dueCarrierCode, dueCarrierAmount, rowNo);
	}

	@When("^Click on \"([^\"]*)\" button for GenerateTSP_VCT$")
	public void click_on_button_for_GenerateTSP_VCT(String buttonName) throws Throwable {
	    createAwb.clickOnBtn(buttonName);
	}

	@Then("^Success popup displayed with message \"([^\"]*)\" for GenerateTSP_VCT$")
	public void success_popup_displayed_with_message_for_GenerateTSP_VCT(String ElementText) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createAwb.AWBSaveWindow, 20);
	    verify = wm.isElementPresent(driver, createAwb.AWBSaveWindow);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, createAwb.AWBSaveMessage, ElementText);
	    cm.Verify(verify, true);
	    Thread.sleep(1000);
	}

	@When("^Click on \"([^\"]*)\" button of Success popup for GenerateTSP_VCT$")
	public void click_on_button_of_Success_popup_for_GenerateTSP_VCT(String buttonName) throws Throwable { 
		Thread.sleep(1000);
	    createAwb.ClickOnSaveMessagePopupButton(buttonName);
	}

	@Then("^AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for GenerateTSP_VCT$")
	public void awb_successfully_created_and_navigated_to_MAWB_List_screen_able_to_see_saved_details_in_the_grid_for_GenerateTSP_VCT() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, mawbList.MawbListScreen, 20);
	    verify = wm.isElementPresent(driver, mawbList.MawbListScreen);
	    cm.Verify(verify, true);
	    verify = wm.isElementPresent(driver, awbNo);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" icon of (\\d+) mawb for GenerateTSP_VCT$")
	public void click_on_icon_of_mawb_for_GenerateTSP_VCT(String iconName, int rowNo) throws Throwable {
		Thread.sleep(8000);  
		mawbList.ClickOnGridIcon(iconName, rowNo); Thread.sleep(5000);
	}
	
	

	@When("^capture Vehicle_Token_No for GenerateTSP_VCT and click on backBtn$")
	public void capture_Vehicle_Token_No_for_GenerateTSP_VCT_and_click_on_backBtn() throws Throwable {
		Thread.sleep(1000); wm.ImplicitlyWait(driver, 2); 
		VehicleTokenNo = mawbList.captureVehicleTokenNo();
		wm.scrolldownUsingJSE(driver, "200");
		mawbList.BackBtn.click(); Thread.sleep(5000);
	}
	
	
	@Then("^MAWB ASI popup opened with \"([^\"]*)\" message for GenerateTSP_VCT$")
	public void mawb_ASI_popup_opened_with_message_for_GenerateTSP_VCT(String ElementText) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, mawbList.MawbAsiPopup, 15);
	    verify = wm.isElementPresent(driver, mawbList.MawbAsiPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.MawbAsiPopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of MAWB ASI popup for GenerateTSP_VCT$")
	public void click_on_button_of_MAWB_ASI_popup_for_GenerateTSP_VCT(String buttonName) throws Throwable {
	    mawbList.ClickOnMawbAsiPopupButton(buttonName);
	}

	@Then("^ASI successfully submited with \"([^\"]*)\" title for GenerateTSP_VCT$")
	public void asi_successfully_submited_with_title_for_GenerateTSP_VCT(String attributevalue) throws Throwable {
		wm.ElementAttributeContainsExplicityWait(driver, mawbList.ASI_IconList.get(0), "title", attributevalue, 20);
		verify = wm.isElementAttributeValueContain(driver, mawbList.ASI_IconList.get(0), "title", attributevalue);
		cm.Verify(verify, true); Thread.sleep(3000);
	}

	@Then("^Carting Order Request popup is opened with \"([^\"]*)\" message for GenerateTSP_VCT$")
	public void carting_Order_Request_popup_is_opened_with_message_for_GenerateTSP_VCT(String ElementText) throws Throwable {
		Thread.sleep(3000);  	wm.VisibilityOfElementExplicityWait(driver, mawbList.CartingOrderPopup, 15);
	    verify = wm.isElementPresent(driver, mawbList.CartingOrderPopup);   					 cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.CartingOrderPopupMsg, ElementText); 	 cm.Verify(verify, true);
	}

	@When("^Select \"([^\"]*)\" and click on \"([^\"]*)\" button of Carting Order Request popup for GenerateTSP_VCT$")
	public void select_and_click_on_button_of_Carting_Order_Request_popup_for_GenerateTSP_VCT(String airlineName, String buttonName) throws Throwable {
		mawbList.SendCO_RequestToAirline(airlineName);
	}

	@Then("^CO message popup opened with \"([^\"]*)\" message for GenerateTSP_VCT$")
	public void co_message_popup_opened_with_message_for_GenerateTSP_VCT(String ElementText) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, mawbList.CO_MessagePopup, 15);
	    verify = wm.isElementPresent(driver, mawbList.CO_MessagePopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.CO_MessagePopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button for CO message popup for GenerateTSP_VCT$")
	public void click_on_button_for_CO_message_popup_for_GenerateTSP_VCT(String buttonName) throws Throwable {
	    mawbList.ClickOnCO_MessagePopupButton(buttonName);
	}

	@Then("^Carting order request send with \"([^\"]*)\" title for GenerateTSP_VCT$")
	public void carting_order_request_send_with_title_for_GenerateTSP_VCT(String attributevalue) throws Throwable {
		wm.ElementAttributeContainsExplicityWait(driver, mawbList.CO_IconList.get(0), "title", attributevalue, 20);
		verify = wm.isElementAttributeValueContain(driver, mawbList.CO_IconList.get(0), "title", attributevalue);
		cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of user for GenerateTSP_VCT$")
	public void click_on_button_of_user_for_GenerateTSP_VCT(String arg1) throws Throwable {
		wm.ImplicitlyWait(driver, 2); Thread.sleep(500);
		 home.ClickOnLogoutButton();
	}

	@Then("^Navigated to login screen for GenerateTSP_VCT$")
	public void navigated_to_login_screen_for_GenerateTSP_VCT() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, login.LoginScreen, 15);
	    //pending
	}

	@When("^Login with airline user in Bial application for GenerateTSP_VCT$")
	public void login_with_airline_user_in_Bial_application_for_GenerateTSP_VCT() throws Throwable {
	    login.Login(AirlineUsername, AirlinePassword);
	}

	@Then("^CO Shipment screen dispalyed for GenerateTSP_VCT$")
	public void co_Shipment_screen_dispalyed_for_GenerateTSP_VCT() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, coApproval.coApprovalScreen, 15);
	    verify = wm.isElementPresent(driver, coApproval.coApprovalScreen);
	    cm.Verify(verify, true);
	}

	@When("^Enter mawb no and click on \"([^\"]*)\" button of CO approval screen for GenerateTSP_VCT$")
	public void enter_mawb_no_and_click_on_button_of_CO_approval_screen_for_GenerateTSP_VCT(String arg1) throws Throwable {
	     mawb =Prefix+awbNo; System.out.println("mawb::"+mawb); 
	     coApproval.SearchMawb(mawb);
	}
	@When("^Enter mawb no and click on \"([^\"]*)\" button of CO approval screen for GenerateTSP_VCT__$")
	public void enter_mawb_no_and_click_on_button_of_CO_approval_screen_for_GenerateTSP_VCT__(String arg1) throws Throwable {
	     mawb ="777"+awbNo; System.out.println("mawb::"+mawb); 
	     coApproval.SearchMawb(mawb);
	}
	@Then("^Mawb no shipment only displayed in the CO approval grid for GenerateTSP_VCT$")
	public void mawb_no_shipment_only_displayed_in_the_CO_approval_grid_for_GenerateTSP_VCT() throws Throwable {
	    //pending
	}

	@When("^Click on \"([^\"]*)\" icon of (\\d+) shipment for GenerateTSP_VCT$")
	public void click_on_icon_of_shipment_for_GenerateTSP_VCT(String iconName, int rowNo) throws Throwable {
	    coApproval.ClickOnGridIcon(iconName, rowNo);
	}

	@Then("^Naviaged to Carting Order Approval screen with all shipment details displayed GenerateTSP_VCT$")
	public void naviaged_to_Carting_Order_Approval_screen_with_all_shipment_details_displayed_GenerateTSP_VCT() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, coApproval.CartingOrderApprovalScreen, 15);
	    verify = wm.isElementPresent(driver, coApproval.CartingOrderApprovalScreen);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of CO Approval screen for GenerateTSP_VCT$")
	public void click_on_button_of_CO_Approval_screen_for_GenerateTSP_VCT(String buttonName) throws Throwable {
	    coApproval.ClickOnCartingOrderApprovalButton(buttonName);
	}

	@Then("^Success popup opened with \"([^\"]*)\" message for GenerateTSP_VCT$")
	public void success_popup_opened_with_message_for_GenerateTSP_VCT(String ElementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, coApproval.SuccessPopup, 15);
	    verify = wm.isElementPresent(driver, coApproval.SuccessPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, coApproval.SuccessPopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of Success popup in CO Approval screen for GenerateTSP_VCT$")
	public void click_on_button_of_Success_popup_in_CO_Approval_screen_for_GenerateTSP_VCT(String buttonName) throws Throwable {
	    coApproval.ClickOnSuccessPopupButton(buttonName);
	}

	@Then("^Navgiated to CO Shipment screen for GenerateTSP_VCT$")
	public void navgiated_to_CO_Shipment_screen_for_GenerateTSP_VCT() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, coApproval.coApprovalScreen, 15);
	    verify = wm.isElementPresent(driver, coApproval.coApprovalScreen);
	    cm.Verify(verify, true);
	}

	@When("^Navigate to MAWB List for GenerateTSP_VCT$")
	public void navigate_to_MAWB_List_for_GenerateTSP_VCT() throws Throwable {
		menu.MainMenuHover("e-AWB");
		menu.ClickOnSubMenu("MAWB List");
	}

	@When("^Add fliter to \"([^\"]*)\" column with \"([^\"]*)\" in MAWB list grid for GenerateTSP_VCT$")
	public void add_fliter_to_column_with_in_MAWB_list_grid_for_GenerateTSP_VCT(String colName, String arg2) throws Throwable {
	  System.out.println("filtered awbNo:"+awbNo); Thread.sleep(2000);
		mawbList.Filter(colName, awbNo, "Contains");
	}

	@Then("^Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT$")
	public void flitered_mawb_no_only_visible_in_MAWB_list_grid_for_GenerateTSP_VCT() throws Throwable {
	    //pending
	}

	@Then("^Shipping Bill Details screen opened and able to mawb no for GenerateTSP_VCT$")
	public void shipping_Bill_Details_screen_opened_and_able_to_mawb_no_for_GenerateTSP_VCT() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.ShippingBillDetailsScreen, 15);
	    verify = wm.isElementPresent(driver, mawbList.ShippingBillDetailsScreen);
	    cm.Verify(verify, true);
	}

	@When("^Add (\\d+) shipping bill details with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" for GenerateTSP_VCT$")
	public void add_shipping_bill_details_with_and_and_and_and_and_for_GenerateTSP_VCT(int rowNo, String sbType, 
		String nop, String length, String width, String height, String grwt) throws Throwable 
	{ 
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

	@When("^Click on \"([^\"]*)\" icon of shipping bill details screen for GenerateTSP_VCT$")
	public void click_on_icon_of_shipping_bill_details_screen_for_GenerateTSP_VCT(String iconName) throws Throwable {
	    mawbList.ClickOnSB_DetailsIcon(iconName); wm.ImplicitlyWait(driver, 2);
	}
	
	@When("^Click on \"([^\"]*)\" button in shipping bill details screen for GenerateTSP_VCT$")
	public void click_on_button_in_shipping_bill_details_screen_for_GenerateTSP_VCT(String buttonName) throws Throwable {
	    mawbList.ClickOnSB_DetailsPopupButton(buttonName);
	}

	@Then("^Shipping Bill popup opened with \"([^\"]*)\" message for GenerateTSP_VCT$")
	public void shipping_Bill_popup_opened_with_message_for_GenerateTSP_VCT(String ElementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.ShippingBillPopup, 15);
	    verify = wm.isElementPresent(driver, mawbList.ShippingBillPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.ShippingBillPopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of shipping bill popup for GenerateTSP_VCT$")
	public void click_on_button_of_shipping_bill_popup_for_GenerateTSP_VCT(String buttonName) throws Throwable {
	    mawbList.ClickOnShippingBillPopupButton(buttonName);
	}

	@Then("^Navigated to MAWB list screen for GenerateTSP_VCT$")
	public void navigated_to_MAWB_list_screen_for_GenerateTSP_VCT() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.MawbListScreen, 15);
	    verify = wm.isElementPresent(driver, mawbList.MawbListScreen);
	    cm.Verify(verify, true);
	}
	
	
	
	@Then("^SB details grid displayed for GenerateTSP_VCT$")
	public void sb_details_grid_displayed_for_GenerateTSP_VCT() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, mawbList.MawbListSB_Grid1, 5);
//	    verify = wm.isElementPresent(driver, mawbList.MawbListSB_Grid1);
//	    cm.Verify(verify, true);
	}

	@Then("^SB ASI Submission popup opened for GenerateTSP_VCT$")
	public void sb_ASI_Submission_popup_opened_for_GenerateTSP_VCT() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.SB_ASI_SubmissionPopup, 10);
	    verify = wm.isElementPresent(driver, mawbList.SB_ASI_SubmissionPopup);
	    cm.Verify(verify, true); 
	}

	@When("^Click on \"([^\"]*)\" button of SB ASI Submission popup for GenerateTSP_VCT$")
	public void click_on_button_of_SB_ASI_Submission_popup_for_GenerateTSP_VCT(String buttonName) throws Throwable {
		Thread.sleep(3000);
	    mawbList.ClickOnSB_ASI_SubmissionPopupButton(buttonName);
	}

	@Then("^SB ASI Confirmation popup opened with \"([^\"]*)\" message for GenerateTSP_VCT$")
	public void sb_ASI_Confirmation_popup_opened_with_message_for_GenerateTSP_VCT(String ElementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.SB_ASI_ConfirmationPopup, 10);
	    verify = wm.isElementPresent(driver, mawbList.SB_ASI_ConfirmationPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.SB_ASI_ConfirmationPopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of SB ASI Confirmation popup for GenerateTSP_VCT$")
	public void click_on_button_of_SB_ASI_Confirmation_popup_for_GenerateTSP_VCT(String buttonName) throws Throwable {
	    mawbList.ClickOnSB_ASI_ConfirmationPopupButton(buttonName);
	}

	@Then("^SB Advance Shipment Information popup opened with \"([^\"]*)\" message for GenerateTSP_VCT$")
	public void sb_Advance_Shipment_Information_popup_opened_with_message_for_GenerateTSP_VCT(String ElementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.SB_AdvanceShipmentInformationPopup, 20); Thread.sleep(2000);
	    verify = wm.isElementPresent(driver, mawbList.SB_AdvanceShipmentInformationPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.SB_AdvanceShipmentInformationPopupMsg, ElementText);
	    cm.Verify(verify, true); Thread.sleep(3000);
	}

	@When("^Click on \"([^\"]*)\" button of SB Advance Shipment Information popup for GenerateTSP_VCT$")
	public void click_on_button_of_SB_Advance_Shipment_Information_popup_for_GenerateTSP_VCT(String buttonName) throws Throwable {
	    mawbList.ClickOnSB_AdvanceShipmentInformationPopupButton(buttonName); Thread.sleep(3000);
	}

	@Then("^SB ASI successfully submited for GenerateTSP_VCT$")
	public void sb_ASI_successfully_submited_for_GenerateTSP_VCT() throws Throwable {
	    //pending
	}
	

	@Then("^validate TSP Payment is opened for GenerateTSP_VCT$")
	public void validate_TSP_Payment_is_opened_for_GenerateTSP_VCT() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, mawbList.TSPpaymentPopuptitle, 15);
	    verify = wm.isElementPresent(driver, mawbList.TSPpaymentPopuptitle);
	    cm.Verify(verify, true); Thread.sleep(3000);
	}
    
	@Then("^enter cargotype commodityName HSNcode transaction_passward and paynow for GenerateTSP_VCT$")
	public void enter_cargotype_commodityName_HSNcode_transaction_passward_and_paynow_for_GenerateTSP_VCT() throws Throwable {
//	    mawbList.CargoType 
		wm.VisibilityOfElementExplicityWait(driver, mawbList.CargoType, 15); Thread.sleep(3000);
	    wm.selectDropDownElementByVisibleText(driver, mawbList.CargoType, "Courier"); Thread.sleep(3000);
	    wm.selectDropDownElementByVisibleText(driver, mawbList.ComodityName, "COURIER BAG-CBV : UCB"); Thread.sleep(500);
	   String hsncode = cm.RandomNo(10); Thread.sleep(1000); 
	    mawbList.HSNCode.sendKeys(hsncode);Thread.sleep(1000);
	    System.out.println("TransactionPassword::"+TransactionPassword);
	    mawbList.TransactionPassword.sendKeys(TransactionPassword);
	    mawbList.paynow.click();
	}
	
	@When("^validate payment confirmation Message popup opens and clickon Yes for GenerateTSP_VCT$")
	public void validate_payment_confirmation_Message_popup_opens_and_clickon_for_GenerateTSP_VCT() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.TSPpaymentConfirmMessage, 15);
	    verify = wm.isElementPresent(driver, mawbList.TSPpaymentConfirmMessage);
	    cm.Verify(verify, true); Thread.sleep(3000);
	    mawbList.yes.click();
	    Thread.sleep(3000);
	}
	
	@When("^validate GenerateTokenFromTSP_Mesage popup opens and clickon \"([^\"]*)\" for GenerateTSP_VCT$")
	public void validate_GenerateTokenFromTSP_Mesage_popup_opens_and_clickon__for_GenerateTSP_VCT(String arg1) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.GenerateTokenFromTSP_Mesage, 15); Thread.sleep(3000);
	    verify =  wm.isElementTextContain(driver, mawbList.GenerateTokenFromTSP_Mesage, "TSP generated successfully. Do you want to generate token?");
	    cm.Verify(verify, true);
	    
	    if(arg1.equalsIgnoreCase("yes")== true) {
	    	   mawbList.YesbtnGenerateTokenFromTSPConfirm.click();
	    }else {
	    	mawbList.NobtnGenerateTokenFromTSPConfirm.click();
	    	
	    }
	}
	
//    TS_BIAL_02  Step definition
    
    
    
//    TS_BIAL_03 Step definition
    
	 
	@Then("^Clickon printBtn for GenerateTSP_VCT$")
	public void Clickon_printBtn_for_GenerateTSP_VCT() throws Throwable {
	   mawbList.printBnt.click();
	}
    
//    TS_BIAL_04  Step definition
	
	@Then("^clickon detach Btn for GenerateTSP_VCT$")
	public void clickon_detach_Btn_for_GenerateTSP_VCT() throws Throwable {
//	   mawbList.MawbListSB_Grid1_Action_IconList.get(0).click();
	}
    
//    TS_BIAL_05 Step definition
    
//    TS_BIAL_06 Step definition

	@Given("^enter vehicleNo as \"([^\"]*)\" driverlicence as\"([^\"]*)\" DriverName as\"([^\"]*)\" DriverMob as\"([^\"]*)\" agentMob as\"([^\"]*)\" NOP as\"([^\"]*)\" grossWt as\"([^\"]*)\" Remark as\"([^\"]*)\" in row (\\d+) and Clickon GeneratetokenBtn for GenerateTSP_VCT$")
	public void enter_vehicleNo_as_driverlicence_as_DriverName_as_DriverMob_as_agentMob_as_NOP_as_grossWt_as_Remark_as_in_row_and_Clickon_GeneratetokenBtn_for_GenerateTSP_VCT(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, int arg9) throws Throwable {
	    
	}

	@Given("^enter \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" in row (\\d+) and Clickon GeneratetokenBtn for GenerateTSP_VCT$")
	public void enter_in_row_and_Clickon_GeneratetokenBtn_for_GenerateTSP_VCT(String vehicleNo, 
			String driverlicence, String DriverName, String DriverMob, String agentMob, String NOP,  
			String grossWt, String Remark, int row) throws Throwable 
	{
		String vehicleNo1 = cm.RandomNo(12); System.out.println("vehicleNo :"+vehicleNo1);
		mawbList.VehicleNo.get(row-1).sendKeys(vehicleNo1);
		String driverlicence1 = cm.RandomNo(12); System.out.println("driverlicence :"+driverlicence1);
	    mawbList.DriverLicenseNo.get(row-1).sendKeys(driverlicence1);
	    String DriverName1 = "Driver "+cm.randomAlphabetic(5); System.out.println("DriverName :"+DriverName1);
	    mawbList.DriverName.get(row-1).sendKeys(DriverName1);
	    String DriverMob1 = "91"+cm.RandomNo(8); System.out.println("DriverMobile :"+DriverMob1);
	    mawbList.DriverMobileNo.get(row-1).sendKeys(DriverMob1);
	    String agentMob1 = "91"+cm.RandomNo(8); System.out.println("agentMob :"+agentMob);
	    mawbList.AgentMobileNo.get(row-1).sendKeys(agentMob1);
	    
	    mawbList.Nop.get(row-1).clear(); System.out.println("NOP :"+NOP);
	    mawbList.Nop.get(row-1).sendKeys(NOP);
//	    wm.ClearTextbox(driver,  mawbList.grossWt.get(row-1));
	    mawbList.grossWt.get(row-1).clear(); System.out.println("grossWt :"+grossWt);
	    mawbList.grossWt.get(row-1).sendKeys(grossWt);
	    
	    wm.ImplicitlyWait(driver, 2);Thread.sleep(500);
	}
	
	@Given("^validate \"([^\"]*)\" popup msg appears and clickon OK for GenerateTSP_VCT$")
	public void validate_popup_msg_appears_and_clickon_OK_for_GenerateTSP_VCT(String popmsg) throws Throwable {
	    wm.scrolldownUsingJSE(driver, "400"); Thread.sleep(1000);
	    mawbList.GenerateToken.click();
	    wm.VisibilityOfElementExplicityWait(driver, mawbList.vehicletokenPopupSuccessMsg, 15);
	    verify = wm.isElementPresent(driver, mawbList.vehicletokenPopupSuccessMsg);
	    verify =  wm.isElementTextContain(driver, mawbList.vehicletokenPopupSuccessMsg, popmsg);
	    cm.Verify(verify, true); Thread.sleep(5000);
	    mawbList.VehicletokenPopupOKBtn.click(); Thread.sleep(5000);
	    
	}
		
//    TS_BIAL_07 Step definition
  
//    TS_BIAL_08 Step definition
   
//    TS_BIAL_09 Step definition
	
	@Given("^add more vehile row for GenerateTSP_VCT$")
	public void add_more_vehile_row_for_GenerateTSP_VCT() throws Throwable {
		int size = mawbList.vehicleDetailrow.size(); 
		mawbList.vehicleActionAddSign.click();
		verify = wm.isElementPresent(driver, mawbList.vehicleDetailrow.get(size -1));
		cm.Verify(verify, true);
	}
	
//    TS_BIAL_10 Step definition
	@Given("^change CTO$")
	public void change_CTO() throws Throwable {
		System.out.println("CTO greyed out");
	}
	
//    TS_BIAL_11 Step definition
 
	@Given("^for_GenerateTSP_VCT Clickon searchTokenBtn$")
	public void for_generatetsp_vct_Clickon_searchTokenBtn() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.searchTokenbtn, 20); wm.ImplicitlyWait(driver, 1);
		verify = wm.isElementPresent(driver, mawbList.searchTokenbtn);
		cm.Verify(verify, true); 
		mawbList.searchTokenbtn.click(); Thread.sleep(3000);
	}

	@Given("^for GenerateTSP_VCT Enter Token No\"([^\"]*)\" and clickon search$")
	public void for_GenerateTSP_VCT_Enter_Token_No_and_clickon_search(String arg1) throws Throwable {
		arg1 = VehicleTokenNo; 
		wm.VisibilityOfElementExplicityWait(driver, mawbList.TokenTextField, 15);
	    verify = wm.isElementPresent(driver, mawbList.TokenTextField);
	    cm.Verify(verify, true); System.out.println("VehicleTokenNo:"+arg1);
	    mawbList.TokenTextField.sendKeys(arg1);
	    mawbList.searchTokenbtn.click();
	}

	@Given("^for GenerateTSP_VCT validate details are displayed$")
	public void for_GenerateTSP_VCT_validate_details_are_displayed() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.VT, 15);
	    verify = wm.isElementPresent(driver, mawbList.VT);
	    cm.Verify(verify, true);
	}
//    TS_BIAL_12 Step definition
	@Then("^for GenerateTSP_VCT Click on Edit button$")
	public void for_GenerateTSP_VCT_Click_on_Edit_button() throws Throwable {
	   wm.scrolldownUsingJSE(driver, "200");
	   Thread.sleep(2000); 
	   mawbList.EditTokenBtn.click();
	}
	
	@Then("^for GenerateTSP_VCT Make the required changes in Remarks and click on save button$")
	public void for_GenerateTSP_VCT_Make_the_required_changes_in_Remarks_and_click_on_save_button() throws Throwable {
		Thread.sleep(2000);
		wm.VisibilityOfElementExplicityWait(driver, mawbList.VehicletokenRemark, 15);
	    verify = wm.isElementPresent(driver, mawbList.VehicletokenRemark);
	    cm.Verify(verify, true);
	     var = "Add" +cm.RandomNo(2); 
	    mawbList.VehicletokenRemark.sendKeys(var);
	  
	    wm.scrolldownUsingJSE(driver, "200");
	    mawbList.SaveBtn.click();
	}
	
	@Then("^for GenerateTSP_VCT handle the vehicleupdate popup$")
	public void for_GenerateTSP_VCT_handle_the_vehicleupdate_popup() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.vehicletokenPopupSuccessMsg, 15);
	    verify = wm.isElementPresent(driver, mawbList.vehicletokenPopupSuccessMsg);
	    cm.Verify(verify, true);
	    mawbList.vehicleupdateMsgpopupOK.click();
	}
	
	@Then("^for GenerateTSP_VCT validate changesin Remarksfield is displayed$")
	public void for_GenerateTSP_VCT_validate_changesin_Remarksfield_is_displayed() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.VehicletokenRemark, 15);
	    verify =   wm.isElementAttributeValueContain(driver, mawbList.VehicletokenRemark, "value", var);
	    cm.Verify(verify, true);
	    
	}

//    TS_BIAL_13 Step definition
	@Then("^Click on the Cancel Token button$")
	public void Click_on_the_Cancel_Token_button() throws Throwable {
		Thread.sleep(500); wm.scrolldownUsingJSE(driver, "200");
		mawbList.cancelTokenBtn.click();
		wm.VisibilityOfElementExplicityWait(driver, mawbList.cancelTokenpopupMsg, 15);
		var = "Token cancelled successfully.";
		verify =  wm.isElementTextContain(driver,  mawbList.cancelTokenpopupMsg, var);
	    cm.Verify(verify, true);
	    mawbList.cancelTokenpopupMsg_okBtns.click(); Thread.sleep(2000);
	}

//    TS_BIAL_14 Step definition

	@Then("^Click on the Print button$")
	public void Click_on_the_Print_button() throws Throwable {
		wm.scrolldownUsingJSE(driver, "200");
		mawbList.printToken.click();	    
	}

	@Then("^Select the option and click on Submit button$")
	public void Select_the_option_and_click_on_Submit_button() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver,mawbList.printOption.get(0), 15);
		var = "Token cancelled successfully.";
	    verify = wm.isElementPresent(driver, mawbList.printOption.get(0));
	    cm.Verify(verify, true);
		mawbList.printOption.get(0).click();
		mawbList.submit.click();
	}
    

}
