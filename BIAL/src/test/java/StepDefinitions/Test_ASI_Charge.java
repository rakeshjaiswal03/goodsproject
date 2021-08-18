
package StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import Methods.CommonMethods;
import Methods.Setup;
import Methods.WebdriverMethods;
import Pages.BialMenu;
import Pages.CO_ApprovalPage;
import Pages.LoginPage;
import Pages.homepage;
import Pages.eAWB.CreateAWBPage;
import Pages.eAWB.HouseManifestPage;
import Pages.eAWB.MawbListPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Test_ASI_Charge {
	
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
	String geckoDriverPath = null, URL = null, AgentUsername = null, AgentPassword = null, AirlineUsername = null, AirlinePassword = null;
	String DownloadPath = null, DownloadFile = null, eDocketUploadFile = null, TransactionPassword =null;
	String CompanyName = null, ieNo = null, ShipperEmailId = null, ShipperAddressLine1 = null;
	String ConsigneeName = null, ConsigneeEmailId = null, ConsigneeAddressLine1 = null, unNo = null, Cls = null;
	String DraftName = null, TemplateName = null;
	String UrnNo = null, ShipperName = null, OriginCode = null, DestinationCode = null;
	String scheduleForDate = null, Prefix = null, awbNo = null, flightNo = null;
	String hawbNo1 = null, hawbNo2 = null, sbNo = null, sbDate = null, customBroker=null;
	
	
	@Given("^Launch Browser and Bial application link for ASI and Charge$")
	public void launch_Browser_and_Bial_application_link_for_ASI_and_Charge() throws Throwable {
		File file = new File(ConfigKeysFile);
		InputStream fis = new FileInputStream(file);
		Properties pf = new Properties();
		pf.load(fis);
		
		geckoDriverPath = pf.getProperty("GeckodriverPath");
		URL = pf.getProperty("STGLink");
		AgentUsername = pf.getProperty("agentUsername");
		AgentPassword = pf.getProperty("agentPassword");
		AirlineUsername = pf.getProperty("airlineUsername");
		AirlinePassword = pf.getProperty("airlinePassword");
		DownloadPath = pf.getProperty("DownloadPath");
		eDocketUploadFile = pf.getProperty("eDocketFilePath");
		customBroker = pf.getProperty("customBroker");
		launch = new Setup();
		TransactionPassword = pf.getProperty("TransactionPassword");
		
		driver = launch.LaunchFirefox(geckoDriverPath, DownloadPath, URL);
		
		wm = new WebdriverMethods(driver);
		cm = new CommonMethods();
		
		login = new LoginPage(driver);
		menu = new BialMenu(driver, wm);
		home = new homepage(driver, wm);
		
		createAwb = new CreateAWBPage(driver, wm, cm);
		mawbList = new MawbListPage(driver, wm,cm);
		createHawb = new HouseManifestPage(driver, wm, cm);
		coApproval = new CO_ApprovalPage(driver, wm);
	}

	@When("^Login in Bial application for ASI and Charge$")
	public void login_in_Bial_application_for_ASI_and_Charge() throws Throwable {
		login.Login(AgentUsername, AgentPassword);
	}

	@Then("^Verify Navigated to Home screen for ASI and Charge$")
	public void verify_Navigated_to_Home_screen_for_ASI_and_Charge() throws Throwable {
		 Thread.sleep(3000); wm.VisibilityOfElementExplicityWait(driver, menu.MenuBar, 20);
	    verify = wm.isElementPresent(driver, menu.MenuBar); System.out.println("Verify Navigated to Home screen:"+verify);
	    cm.Verify(verify, true); 
	}

	@Given("^Navigate to Create AWB for ASI and Charge$")
	public void navigate_to_Create_AWB_for_ASI_and_Charge() throws Throwable {
		menu.MainMenuHover("e-AWB"); Thread.sleep(500);
		menu.ClickOnSubMenu("Create AWB");
		
	}

	@Then("^Verify that balance amount message popup is displayed for ASI and Charge$")
	public void verify_that_balance_amount_message_popup_is_displayed_for_ASI_and_Charge() throws Throwable {
		Thread.sleep(5000);wm.VisibilityOfElementExplicityWait(driver, createAwb.CurrentBal_MsgContent, 40);
		verify = wm.isElementPresent(driver, createAwb.CurrentBal_MsgContent);
		cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of message popup for ASI and Charge$")
	public void click_on_button_of_message_popup_for_ASI_and_Charge(String buttonName) throws Throwable {
	    Thread.sleep(3000); createAwb.ClickOnMessagePopupButton(buttonName); Thread.sleep(3000);
	}

	@When("^Enter \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" for ASI and Charge$")
	public void enter_and_for_ASI_and_Charge(String prefix, String fieldName1, String fieldName2) throws Throwable {
	    Prefix = prefix; wm.ImplicitlyWait(driver, 10);Thread.sleep(5000);
		createAwb.enter_eAWBData(fieldName1, Prefix);
		Thread.sleep(5000);
	    awbNo = createAwb.EnterAwbno();
	}

	@When("^Select \"([^\"]*)\" \"([^\"]*)\" for ASI and Charge$")
	public void select_for_ASI_and_Charge(String value, String fieldName) throws Throwable {
		Thread.sleep(5000);createAwb.enter_eAWBData(fieldName, value);
	}

	@When("^Click on \"([^\"]*)\" icon to add rounting details for ASI and Charge$")
	public void click_on_icon_to_add_rounting_details_for_ASI_and_Charge(String iconName) throws Throwable {
	    createAwb.clickOnBtn(iconName);
	}

	@Then("^Routing details popup opened and \"([^\"]*)\" origin alreday selected for ASI and Charge$")
	public void routing_details_popup_opened_and_origin_alreday_selected_for_ASI_and_Charge(String arg1) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createAwb.RoutingDetailsWindow, 10);
	    verify = wm.isElementPresent(driver, createAwb.RoutingDetailsWindow);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of Routing Details popup for ASI and Charge$")
	public void click_on_button_of_Routing_Details_popup_for_ASI_and_Charge(String buttonName) throws Throwable {
		createAwb.ClickOnRoutingInfoButton(buttonName);
	}

	@Then("^Destinaiton filed get populated with \"([^\"]*)\" for ASI and Charge$")
	public void destinaiton_filed_get_populated_with_for_ASI_and_Charge(String arg1) throws Throwable {
	    //pending
	}

	@When("^Add (\\d+) flight details with \"([^\"]*)\" flight code for ASI and Charge$")
	public void add_flight_details_with_flight_code_for_ASI_and_Charge(int rowNo, String iconName) throws Throwable {
		
	    flightNo = cm.RandomNo(3);
	   
	    createAwb.enter_eAWBData("carrierCode1", "ZZ");
	    createAwb.enter_eAWBData("Flight No", flightNo);
	}

	@When("^Click on \"([^\"]*)\" icon of (\\d+) rate line for ASI and Charge$")
	public void click_on_icon_of_rate_line_for_ASI_and_Charge(String iconName, int rowNo) throws Throwable {
		createAwb.ClickOnCargoDetailsIcon(iconName, rowNo);
	}

	@Then("^Dimensions popup opened for ASI and Charge$")
	public void dimensions_popup_opened_for_ASI_and_Charge() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createAwb.DimesionsWindow, 15);
	    verify = wm.isElementPresent(driver, createAwb.DimesionsWindow);
	    cm.Verify(verify, true);
	}

	@When("^Add (\\d+) dimesnsions with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" for ASI and Charge$")
	public void add_dimesnsions_with_and_and_and_for_ASI_and_Charge(int rowNo, String noOfPcs, String length, String width, String height) throws Throwable {
	    createAwb.AddDimensions(noOfPcs, length, width, height, rowNo);
	}

	@When("^Click on \"([^\"]*)\" button of Dimesnsions for ASI and Charge$")
	public void click_on_button_of_Dimesnsions_for_ASI_and_Charge(String buttonName) throws Throwable {
	    createAwb.ClickOnDimensionsButton(buttonName);
	}

	@Then("^No of pcs will get populated with \"([^\"]*)\" of (\\d+) rate line$")
	public void no_of_pcs_will_get_populated_with_of_rate_line(String arg1, int arg2) throws Throwable {
	    //pending
	}

	@When("^Add (\\d+) rate line details with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" anf \"([^\"]*)\" for ASI and Charge$")
	public void add_rate_line_details_with_and_and_anf_for_ASI_and_Charge(int rowNo, String grWt, String rateClass, String rate, String natureOfGoods) throws Throwable {
//	    createAwb.AddRateLineDetails(grWt, rateClass, rate, natureOfGoods, rowNo);
	    createAwb.AddRatelineDetails(grWt, rateClass, rate, natureOfGoods, rowNo);
	}

	@When("^Enter (\\d+) \"([^\"]*)\" and \"([^\"]*)\" for ASI and Charge$")
	public void enter_and_for_ASI_and_Charge(int rowNo, String dueCarrierCode, String dueCarrierAmount) throws Throwable {
	    createAwb.AddDueCarrier(dueCarrierCode, dueCarrierAmount, rowNo);
	}

	@When("^Click on \"([^\"]*)\" button for ASI and Charge$")
	public void click_on_button_for_ASI_and_Charge(String buttonName) throws Throwable {
		Thread.sleep(2000);
	    createAwb.clickOnBtn(buttonName);
	}

	@Then("^Success popup displayed with message \"([^\"]*)\" for ASI and Charge$")
	public void success_popup_displayed_with_message_for_ASI_and_Charge(String ElementText) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createAwb.AWBSaveWindow, 25); 
	    verify = wm.isElementPresent(driver, createAwb.AWBSaveWindow);
	    cm.Verify(verify, true); System.out.println(ElementText);
	    verify = wm.isElementTextContain(driver, createAwb.AWBSaveMessage, ElementText);
	    cm.Verify(verify, true);
	    Thread.sleep(1000);
	}

	@When("^Click on \"([^\"]*)\" button of Success popup for ASI and Charge$")
	public void click_on_button_of_Success_popup_for_ASI_and_Charge(String buttonName) throws Throwable {
	    createAwb.ClickOnSaveMessagePopupButton(buttonName);
	}

	@Then("^AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge$")
	public void awb_successfully_created_and_navigated_to_MAWB_List_screen_able_to_see_saved_details_in_the_grid_for_ASI_and_Charge() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, mawbList.MawbListScreen, 20);
	    verify = wm.isElementPresent(driver, mawbList.MawbListScreen);
	    cm.Verify(verify, true);
	    verify = wm.isElementPresent(driver, awbNo);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" icon of (\\d+) mawb for ASI and Charge$")
	public void click_on_icon_of_mawb_for_ASI_and_Charge(String iconName, int rowNo) throws Throwable {
	   Thread.sleep(2000); mawbList.ClickOnGridIcon(iconName, rowNo); Thread.sleep(5000);
	}

	@Then("^MAWB ASI popup opened with \"([^\"]*)\" message for ASI and Charge$")
	public void mawb_ASI_popup_opened_with_message_for_ASI_and_Charge(String ElementText) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, mawbList.MawbAsiPopup, 15);
	    verify = wm.isElementPresent(driver, mawbList.MawbAsiPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.MawbAsiPopupMsg, ElementText);
	    cm.Verify(verify, true);
	    
	}

	@When("^Click on \"([^\"]*)\" button of MAWB ASI popup for ASI and Charge$")
	public void click_on_button_of_MAWB_ASI_popup_for_ASI_and_Charge(String buttonName) throws Throwable {
	    mawbList.ClickOnMawbAsiPopupButton(buttonName);
	}

	@Then("^ASI successfully submited with \"([^\"]*)\" title for ASI and Charge$")
	public void asi_successfully_submited_with_title_for_ASI_and_Charge(String attributevalue) throws Throwable {
		System.out.println(attributevalue);
		wm.ElementAttributeContainsExplicityWait(driver, mawbList.ASI_IconList.get(0), "title", attributevalue, 20);
		verify = wm.isElementAttributeValueContain(driver, mawbList.ASI_IconList.get(0), "title", attributevalue);
		cm.Verify(verify, true);
	}

	@Then("^Carting Order Request popup is opened with \"([^\"]*)\" message for ASI and Charge$")
	public void carting_Order_Request_popup_is_opened_with_message_for_ASI_and_Charge(String ElementText) throws Throwable {
		System.out.println(ElementText);
		wm.VisibilityOfElementExplicityWait(driver, mawbList.CartingOrderPopup, 15);
	    verify = wm.isElementPresent(driver, mawbList.CartingOrderPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.CartingOrderPopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Select \"([^\"]*)\" and click on \"([^\"]*)\" button of Carting Order Request popup for ASI and Charge$")
	public void select_and_click_on_button_of_Carting_Order_Request_popup_for_ASI_and_Charge(String airlineName, String buttonName) throws Throwable {
		mawbList.SendCO_RequestToAirline(airlineName);
	}

	@Then("^CO message popup opened with \"([^\"]*)\" message for ASI and Charge$")
	public void co_message_popup_opened_with_message_for_ASI_and_Charge(String ElementText) throws Throwable {
		System.out.println(ElementText);  Thread.sleep(2000);
	    wm.VisibilityOfElementExplicityWait(driver, mawbList.CO_MessagePopup, 15); 
	    verify = wm.isElementPresent(driver, mawbList.CO_MessagePopup);
	    cm.Verify(verify, true);  Thread.sleep(2000);
	    verify = wm.isElementTextContain(driver, mawbList.CO_MessagePopupMsg, ElementText); 
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button for CO message popup for ASI and Charge$")
	public void click_on_button_for_CO_message_popup_for_ASI_and_Charge(String buttonName) throws Throwable {
	    mawbList.ClickOnCO_MessagePopupButton(buttonName);
	}

	@Then("^Carting order request send with \"([^\"]*)\" title for ASI and Charge$")
	public void carting_order_request_send_with_title_for_ASI_and_Charge(String attributevalue) throws Throwable {
		System.out.println(attributevalue);
		wm.ElementAttributeContainsExplicityWait(driver, mawbList.CO_IconList.get(0), "title", attributevalue, 20);
		verify = wm.isElementAttributeValueContain(driver, mawbList.CO_IconList.get(0), "title", attributevalue);
		cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of user for ASI and Charge$")
	public void click_on_button_of_user_for_ASI_and_Charge(String arg1) throws Throwable {
		Thread.sleep(1000); home.ClickOnLogoutButton();
	}

	@Then("^Navigated to login screen for ASI and Charge$")
	public void navigated_to_login_screen_for_ASI_and_Charge() throws Throwable {
	    //pending
	    wm.VisibilityOfElementExplicityWait(driver, login.LoginScreen, 15);
	    
	}

	@When("^Login with username \"([^\"]*)\"and password\"([^\"]*)\" in Bial application for ASI and Charge$")
	public void login_with_username_and_password_in_Bial_application_for_ASI_and_Charge(String username, String password) throws Throwable {
	    login.Login(username, password);
	}
	
	@When("^Login with airline user in Bial application for ASI and Charge$")
	public void login_with_airline_user_in_Bial_application_for_ASI_and_Charge() throws Throwable {
	    login.Login(AirlineUsername, AirlinePassword);
	}

	@Then("^CO Shipment screen dispalyed for ASI and Charge$")
	public void co_Shipment_screen_dispalyed_for_ASI_and_Charge() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, coApproval.coApprovalScreen, 15);
	    verify = wm.isElementPresent(driver, coApproval.coApprovalScreen);
	    cm.Verify(verify, true);
	}

	@When("^Enter mawb no and click on \"([^\"]*)\" button of CO approval screen for ASI and Charge$")
	public void enter_mawb_no_and_click_on_button_of_CO_approval_screen_for_ASI_and_Charge(String arg1) throws Throwable {
	    coApproval.SearchMawb(Prefix+awbNo);
	}

	@Then("^Mawb no shipment only displayed in the CO approval grid for ASI and Charge$")
	public void mawb_no_shipment_only_displayed_in_the_CO_approval_grid_for_ASI_and_Charge() throws Throwable {
	    //pending
	}

	@When("^Click on \"([^\"]*)\" icon of (\\d+) shipment for ASI and Charge$")
	public void click_on_icon_of_shipment_for_ASI_and_Charge(String iconName, int rowNo) throws Throwable {
	    coApproval.ClickOnGridIcon(iconName, rowNo);
	}

	@Then("^Naviaged to Carting Order Approval screen with all shipment details displayed$")
	public void naviaged_to_Carting_Order_Approval_screen_with_all_shipment_details_displayed() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, coApproval.CartingOrderApprovalScreen, 15);
	    verify = wm.isElementPresent(driver, coApproval.CartingOrderApprovalScreen);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of CO Approval screen for ASI and Charge$")
	public void click_on_button_of_CO_Approval_screen_for_ASI_and_Charge(String buttonName) throws Throwable {
	    coApproval.ClickOnCartingOrderApprovalButton(buttonName);
	}

	@Then("^Success popup opened with \"([^\"]*)\" message for ASI and Charge$")
	public void success_popup_opened_with_message_for_ASI_and_Charge(String ElementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, coApproval.SuccessPopup, 15);
	    verify = wm.isElementPresent(driver, coApproval.SuccessPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, coApproval.SuccessPopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of Success popup in CO Approval screen for ASI and Charge$")
	public void click_on_button_of_Success_popup_in_CO_Approval_screen_for_ASI_and_Charge(String buttonName) throws Throwable {
	    coApproval.ClickOnSuccessPopupButton(buttonName);
	}

	@Then("^Navgiated to CO Shipment screen for ASI and Charge$")
	public void navgiated_to_CO_Shipment_screen_for_ASI_and_Charge() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, coApproval.coApprovalScreen, 15);
	    verify = wm.isElementPresent(driver, coApproval.coApprovalScreen);
	    cm.Verify(verify, true);
	}

	@When("^Navigate to MAWB List for ASI and Charge$")
	public void navigate_to_MAWB_List_for_ASI_and_Charge() throws Throwable {
		menu.MainMenuHover("e-AWB");
		menu.ClickOnSubMenu("MAWB List");
	}

	@When("^Add fliter to \"([^\"]*)\" column with \"([^\"]*)\" in MAWB list grid for ASI and Charge$")
	public void add_fliter_to_column_with_in_MAWB_list_grid_for_ASI_and_Charge(String colName, String arg2) throws Throwable {
	    Thread.sleep(2000);mawbList.Filter(colName, awbNo, "Contains"); Thread.sleep(2000);
	}

	@Then("^Flitered mawb no only visible in MAWB list grid for ASI and Charge$")
	public void flitered_mawb_no_only_visible_in_MAWB_list_grid_for_ASI_and_Charge() throws Throwable {
	    //pending
	}

	@Then("^Shipping Bill Details screen opened and able to mawb no for ASI and Charge$")
	public void shipping_Bill_Details_screen_opened_and_able_to_mawb_no_for_ASI_and_Charge() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.ShippingBillDetailsScreen, 15);
	    verify = wm.isElementPresent(driver, mawbList.ShippingBillDetailsScreen);
	    cm.Verify(verify, true);
	}

	@When("^Add (\\d+) shipping bill details with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" for ASI and Charge$")
	public void add_shipping_bill_details_with_and_and_and_and_and_for_ASI_and_Charge(int rowNo, String sbType, 
			String nop, String length, String width, String height, String grwt) throws Throwable {
		sbDate = cm.SpecificDate("dd MMM yyyy", cm.CurrentDate("dd MMM yyyy"), -7);
	    sbNo = cm.RandomNo(7);
	    mawbList.AddSB_Details1__(sbNo, sbDate, sbType, nop, grwt, length, width, height, rowNo); //updated from mawbList.AddSB_Details__()
	}

	@When("^Click on \"([^\"]*)\" button in shipping bill details screen for ASI and Charge$")
	public void click_on_button_in_shipping_bill_details_screen_for_ASI_and_Charge(String buttonName) throws Throwable {
		Thread.sleep(1000);
	    mawbList.ClickOnSB_DetailsPopupButton(buttonName);
	}

	@Then("^Shipping Bill popup opened with \"([^\"]*)\" message for ASI and Charge$")
	public void shipping_Bill_popup_opened_with_message_for_ASI_and_Charge(String ElementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.ShippingBillPopup, 15);
	    verify = wm.isElementPresent(driver, mawbList.ShippingBillPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.ShippingBillPopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of shipping bill popup for ASI and Charge$")
	public void click_on_button_of_shipping_bill_popup_for_ASI_and_Charge(String buttonName) throws Throwable {
	  Thread.sleep(2000);  mawbList.ClickOnShippingBillPopupButton(buttonName);
	}

	@Then("^Navigated to MAWB list screen for ASI and Charge$")
	public void navigated_to_MAWB_list_screen_for_ASI_and_Charge() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.MawbListScreen, 15);
	    verify = wm.isElementPresent(driver, mawbList.MawbListScreen);
	    cm.Verify(verify, true);
	}
	
	
	
	@Then("^SB details grid displayed for ASI and Charge$")
	public void sb_details_grid_displayed_for_ASI_and_Charge() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, mawbList.MawbListSB_Grid1, 5);
//	    verify = wm.isElementPresent(driver, mawbList.MawbListSB_Grid1);
//	    cm.Verify(verify, true);
	}

	@Then("^SB ASI Submission popup opened for ASI and Charge$")
	public void sb_ASI_Submission_popup_opened_for_ASI_and_Charge() throws Throwable {
		Thread.sleep(5000);wm.VisibilityOfElementExplicityWait(driver, mawbList.SB_ASI_SubmissionPopup, 50);
	    verify = wm.isElementPresent(driver, mawbList.SB_ASI_SubmissionPopup);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of SB ASI Submission popup for ASI and Charge$")
	public void click_on_button_of_SB_ASI_Submission_popup_for_ASI_and_Charge(String buttonName) throws Throwable {
	    mawbList.ClickOnSB_ASI_SubmissionPopupButton(buttonName);
	}

	@Then("^SB ASI Confirmation popup opened with \"([^\"]*)\" message for ASI and Charge$")
	public void sb_ASI_Confirmation_popup_opened_with_message_for_ASI_and_Charge(String ElementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.SB_ASI_ConfirmationPopup, 15);
	    verify = wm.isElementPresent(driver, mawbList.SB_ASI_ConfirmationPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.SB_ASI_ConfirmationPopupMsg, ElementText);
	    cm.Verify(verify, true);
	}
	
	@Then("^SB ASI confirmation popup opened with \"([^\"]*)\" message for ASI and Charge$")
	public void sb_ASI_confirmation_popup_opened_with_message_for_ASI_and_Charge(String ElementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.SB_ASI_PDPopupMsg, 10);
	    verify = wm.isElementPresent(driver, mawbList.SB_ASI_PDPopupMsg);
	    verify = wm.isElementTextContain(driver, mawbList.SB_ASI_PDPopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of SB ASI Confirmation popup for ASI and Charge$")
	public void click_on_button_of_SB_ASI_Confirmation_popup_for_ASI_and_Charge(String buttonName) throws Throwable {
		mawbList.ClickOnSB_ASI_ConfirmationPopupButton(buttonName);
	}

	@Then("^SB Advance Shipment Information popup opened with \"([^\"]*)\" message for ASI and Charge$")
	public void sb_Advance_Shipment_Information_popup_opened_with_message_for_ASI_and_Charge(String ElementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.SB_AdvanceShipmentInformationPopup, 10);
	    verify = wm.isElementPresent(driver, mawbList.SB_AdvanceShipmentInformationPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.SB_AdvanceShipmentInformationPopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of SB Advance Shipment Information popup for ASI and Charge$")
	public void click_on_button_of_SB_Advance_Shipment_Information_popup_for_ASI_and_Charge(String buttonName) throws Throwable {
		mawbList.ClickOnSB_AdvanceShipmentInformationPopupButton(buttonName);
	}

	@Then("^SB ASI successfully submited for ASI and Charge$")
	public void sb_ASI_successfully_submited_for_ASI_and_Charge() throws Throwable {
	    //pending
		
	}

	@Then("^Naviaged to Create AWB screen for ASI and Charge$")
	public void naviaged_to_Create_AWB_screen_for_ASI_and_Charge() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createAwb.CreateAwbScreen, 15);
	}

	@When("^Edit \"([^\"]*)\" \"([^\"]*)\" for ASI and Charge$")
	public void edit_for_ASI_and_Charge(String value, String fieldName) throws Throwable {
//	    createAwb.TxtRoutingDetailsDestnPort.clear();    //comment as xpath doesnot exist now- Rakesh
	    Thread.sleep(500);
	    createAwb.enter_eAWBData(fieldName, value);
	}

	@When("^Edit SB date of (\\d+) SB details row for ASI and Charge$")
	public void edit_SB_date_of_SB_details_row_for_ASI_and_Charge(int rowNo) throws Throwable {
//		wm.ImplicitlyWait(driver, 5);Thread.sleep(2000);
////		mawbList.SB_DetailsTextboxList.get(((rowNo-1)*9)+1).clear();
//		Thread.sleep(1000);
//		sbDate = cm.SpecificDate("dd MMM yyyy", cm.CurrentDate("dd MMM yyyy"), -5);
//	    mawbList.SB_DetailsTextboxList.get(((rowNo-1)*9)+1).sendKeys(sbDate);	Thread.sleep(1000);
	}

	@When("^Edit SB date of (\\d+) SB details row for ASI and Charge_$")
	public void edit_SB_date_of_SB_details_row_for_ASI_and_Charge_(int rowNo) throws Throwable {

	}

	@Then("^The attached SB should be removed and the MAWB should be deleted$")
	public void the_attached_SB_should_be_removed_and_the_MAWB_should_be_deleted() throws Throwable {
	    
	}

	@Then("^Unable SB ASI submit without MAWB ASI submit and (\\d+) SB ASI icon is disabled for ASI and Charge$")
	public void unable_SB_ASI_submit_without_MAWB_ASI_submit_and_SB_ASI_icon_is_disabled_for_ASI_and_Charge(int rowNo) throws Throwable {
	    verify = wm.isElementPresent(driver, mawbList.SB_ASI_SubmissionPopup);
	    cm.Verify(verify, false);
	}

	@Then("^Unable send carting order request without MAWB ASI submit and (\\d+) CO icon is disabled for ASI and Charge$")
	public void unable_send_carting_order_request_without_MAWB_ASI_submit_and_CO_icon_is_disabled_for_ASI_and_Charge(int rowNo) throws Throwable {
		verify = wm.isElementPresent(driver, mawbList.CO_MessagePopup);
	    cm.Verify(verify, false);
	}

	
	@When("^Click on \"([^\"]*)\" icon of shipping bill details screen for ASI and Charge$")
	public void click_on_icon_of_shipping_bill_details_screen_for_ASI_and_Charge(String iconName) throws Throwable {
	    mawbList.ClickOnSB_DetailsIcon(iconName); wm.ImplicitlyWait(driver, 2);
	}
	
	
	
	@When("^Select \"([^\"]*)\" checkbox of SB ASI Submission grid for ASI and Charge$")
	public void select_checkbox_of_SB_ASI_Submission_grid_for_ASI_and_Charge(String buttonName) throws Throwable {
	    mawbList.ClickOnSB_ASI_SubmissionPopupButton(buttonName);
	}

	@When("^Select \"([^\"]*)\" radio button for ASI and Charge$")
	public void select_radio_button_for_ASI_and_Charge(String buttonName) throws Throwable {
		createAwb.clickOnBtn(buttonName);
	}

	@Then("^Consol Message popup opened with \"([^\"]*)\" message for ASI and Charge$")
	public void consol_Message_popup_opened_with_message_for_ASI_and_Charge(String elementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createAwb.HouseMessagePopup, 20);
        verify = wm.isElementPresent(driver, createAwb.HouseMessagePopup);
        cm.Verify(verify, true);
        verify = wm.isElementTextContain(driver, createAwb.HouseMessage, elementText);
        cm.Verify(verify, true);
        Thread.sleep(2000);
	}

	@When("^Click on \"([^\"]*)\" button of Consol Message popup for ASI and Charge$")
	public void click_on_button_of_Consol_Message_popup_for_ASI_and_Charge(String buttonName) throws Throwable {
		Thread.sleep(2000); createAwb.ClickOnConsolPopupButton(buttonName); Thread.sleep(2000);
	}

	@Then("^House Manifest popup opened for ASI and Charge$")
	public void house_Manifest_popup_opened_for_ASI_and_Charge() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createAwb.HouseManifestPopup, 20);
        verify = wm.isElementPresent(driver, createAwb.HouseManifestPopup);
        cm.Verify(verify, true);
        Thread.sleep(500);
        driver.switchTo().frame(createAwb.HouseManifestPopupFrame);
        Thread.sleep(2000);
	}

	
	@When("^HouserManifestPopupAddRowIcon$")
	public void HouserManifestPopupAddRowIcon() throws Throwable {
		createAwb.HouserManifestPopupAddRowIcon.click();Thread.sleep(1000);
	}
	
	@When("^Add (\\d+) house details with hawb no and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" for ASI and Charge$")
	public void add_house_details_with_hawb_no_and_and_and_and_and_and_and_and_for_ASI_and_Charge(int rowno, String Shipper, String Consignee, 
			String Origin, String Destination, String NOP, String GrossWeight, String chargeCode, String CargoDesc) throws Throwable {
	    if (rowno == 1)
	    {
	    	hawbNo1 = cm.Random_hawbNo();
	    	createAwb.AddHawbDetails(hawbNo1, Shipper, Consignee, 
	    			Origin, Destination, NOP, GrossWeight, CargoDesc, chargeCode, rowno);
	    }
	    else
	    {
	    	hawbNo2 = cm.Random_hawbNo();
	    	createAwb.AddHawbDetails(hawbNo2, Shipper, Consignee, 
	    			Origin, Destination, NOP, GrossWeight, CargoDesc, chargeCode, rowno);
	    }
	}

	@When("^Click on \"([^\"]*)\" button of House Manifest popup for ASI and Charge$")
	public void click_on_button_of_House_Manifest_popup_for_ASI_and_Charge(String buttonName) throws Throwable {
		createAwb.ClickOnHouseManifestPopupButton(buttonName);
	}

	@Then("^Hawb detils get saved and able to see \"([^\"]*)\" message for ASI and Charge$")
	public void hawb_detils_get_saved_and_able_to_see_message_for_ASI_and_Charge(String elementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createAwb.SaveSucessMsgHAWB_iFrame, 15);
		verify = wm.isElementTextContain(driver, createAwb.SaveSucessMsgHAWB_iFrame, elementText);
		cm.Verify(verify, true);
		Thread.sleep(500);
		
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}

	@Then("^Houser manifest popup closed and HAWB grid displayed on Create AWB screen for ASI and Charge$")
	public void houser_manifest_popup_closed_and_HAWB_grid_displayed_on_Create_AWB_screen_for_ASI_and_Charge() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createAwb.HAWBTable, 10);
        verify = wm.isElementPresent(driver, createAwb.HAWBTable);
        cm.Verify(verify, true);
        Thread.sleep(2000);
	}

	@When("^Add (\\d+) rate line details with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" for ASI and Charge$")
	public void add_rate_line_details_with_and_and_for_ASI_and_Charge(int rowNo, String grWt, String rateClass, String rate) throws Throwable {
	    createAwb.AddRateLineDetails(rateClass, rate, rowNo);
	}
	@When("^Add chargeble weight as\"([^\"]*)\"$")
	public void Add_chargeble_weight_as(String chwt) throws Throwable {
	   createAwb.chargebleWt.sendKeys(chwt);
	}

	@When("^Add (\\d+) shipping bill details with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" for ASI and Charge$")
	public void add_shipping_bill_details_with_and_and_and_and_for_ASI_and_Charge(int rowNo, String sbType, 
			String nop, String length, String width, String height) throws Throwable {
		
		String NoP = "2"; 
		sbNo = cm.RandomNo(7); String grwt = "10";
		sbDate = cm.SpecificDate("dd MMM yyyy", cm.CurrentDate("dd MMM yyyy"), -7);
		if (rowNo == 1)
	    {
			mawbList.AddConsolSB_Details__(sbNo, sbDate, sbType, 
					hawbNo1, NoP, length, width, height, rowNo,grwt);
	    }
	    else
	    {
	    	mawbList.AddConsolSB_Details__(sbNo, sbDate, sbType, 
					hawbNo2, NoP, length, width, height, rowNo, grwt);
	    }
	}
	
	
	@When("^Add (\\d+) shipping bill details with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" for ASI and Charge__$")
	public void add_shipping_bill_details_with_and_and_and_and_for_ASI_and_Charge__(int rowNo, String sbType, 
			String nop, String length, String width, String height) throws Throwable {
		String NoP =nop; 
		sbNo = cm.RandomNo(7); String grwt = "10";
		sbDate = cm.SpecificDate("dd MMM yyyy", cm.CurrentDate("dd MMM yyyy"), -7);
		if (rowNo == 1)
	    {
			mawbList.AddConsolSB_Details__(sbNo, sbDate, sbType, 
					hawbNo1, NoP, length, width, height, rowNo,grwt);
	    }
	    else
	    {
	    	mawbList.AddConsolSB_Details__(sbNo, sbDate, sbType, 
					hawbNo2, NoP, length, width, height, rowNo, grwt);
	    }
	}
	
	
	
	
	@Then("^Navigated to House Manifest screen for ASI and Charge$")
	public void navigated_to_House_Manifest_screen_for_ASI_and_Charge() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createHawb.HouseManifestScreen, 15);
	    verify = wm.isElementPresent(driver, createHawb.HouseManifestScreen);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" icon of (\\d+) hawb row for ASI and Charge$")
	public void click_on_icon_of_hawb_row_for_ASI_and_Charge(String iconName, int rowNo) throws Throwable {
	    createAwb.ClickOnHouserManifestPopupIcon(iconName, rowNo);
	}

	@Then("^HAWB Deletion popup is opened with \"([^\"]*)\" message for ASI and Charge$")
	public void hawb_Deletion_popup_is_opened_with_message_for_ASI_and_Charge(String ElementText) throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, createAwb.HAWB_DeletionPopup, 10);
	    verify = wm.isElementPresent(driver, createAwb.HAWB_DeletionPopup);
	    cm.Verify(verify, true);
//	    verify = wm.isElementTextContain(driver, createAwb.HAWB_DeletionPopupMsg, ElementText);
//	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of HAWB Deletion popup for ASI and Charge$")
	public void click_on_button_of_HAWB_Deletion_popup_for_ASI_and_Charge(String buttonName) throws Throwable {
	    createAwb.ClickOnHAWB_DeletionPopupButton(buttonName);
	}

	@Then("^HAWB Message popup is opened with \"([^\"]*)\" message for ASI and Charge$")
	public void hawb_Message_popup_is_opened_with_message_for_ASI_and_Charge(String ElementText) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createAwb.HAWB_MessagePopup, 10);
	    verify = wm.isElementPresent(driver, createAwb.HAWB_MessagePopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, createAwb.HAWB_MessagePopupMsg, ElementText);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of HAWB Message popup for ASI and Charge$")
	public void click_on_button_of_HAWB_Message_popup_for_ASI_and_Charge(String buttonName) throws Throwable {
	    createAwb.ClickOnHAWB_MessagePopupButton(buttonName);
	}

	@Then("^HAWB details get deleted successfully for ASI and Charge$")
	public void hawb_details_get_deleted_successfully_for_ASI_and_Charge() throws Throwable {
	    //pending
	}

	@When("^Click on \"([^\"]*)\" button of House Manifest screen for ASI and Charge$")
	public void click_on_button_of_House_Manifest_screen_for_ASI_and_Charge(String buttonName) throws Throwable {
	    createHawb.clickOnBtn(buttonName);
	}

	@Then("^House Manifest Status popup opened for ASI and Charge$")
	public void house_Manifest_Status_popup_opened_for_ASI_and_Charge() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createHawb.StatusPopup, 10);
	    verify = wm.isElementPresent(driver, createHawb.StatusPopup);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of House Manifest Status popup for ASI and Charge$")
	public void click_on_button_of_House_Manifest_Status_popup_for_ASI_and_Charge(String buttonName) throws Throwable {
	    createHawb.ClickOnStatuPopupButton(buttonName);
	}

	@Then("^SB details get deleted of a hawb for ASI and Charge$")
	public void sb_details_get_deleted_of_a_hawb_for_ASI_and_Charge() throws Throwable {
	    if (mawbList.SB_DetailsRowList.size() == 1)
	    	verify = true;
	    else
	    	verify = false;
	    
	    cm.Verify(verify, true);
	}
	
	
	
	
	@When("^Select \"([^\"]*)\" checkbox for ASI and Charge$")
	public void select_checkbox_for_ASI_and_Charge(String checboxName) throws Throwable {
	    createAwb.SelectCheckbox(checboxName);
	}
	
	
	@Then("^SB ASI already submited and Resubmit icon instead of submit icon with \"([^\"]*)\" title for ASI and Charge$")
	public void sb_ASI_already_submited_and_Resubmit_icon_instead_of_submit_icon_with_title_for_ASI_and_Charge(String attributeValue) throws Throwable {
	    Thread.sleep(2000);
	    verify = wm.isElementAttributeValueContain(driver, mawbList.MawbListSB_Grid1_SB_ASI_IconList.get(0), "title", attributeValue);
	    cm.Verify(verify, true);
	    
	}

	@Then("^Edit (\\d+) shipping bill details with \"([^\"]*)\" chargebel weight for ASI and Charge$")
	public void edit_shipping_bill_details_with_chargebel_weight_for_ASI_and_Charge(int rowNo, String chWt) throws Throwable {
//		Commented as element was greyed out.. rakesh jaiswal 7june 2021
//		mawbList.SB_DetailsTextboxList.get(((rowNo-1)*9)+5).clear();
//		Thread.sleep(500);
//		mawbList.SB_DetailsTextboxList.get(((rowNo-1)*9)+5).sendKeys(chWt, Keys.TAB);
//		Thread.sleep(1000);
	}

	@Then("^Shipping Bill popup opened with \"([^\"]*)\" and \"([^\"]*)\" message for ASI and Charge$")
	public void shipping_Bill_popup_opened_with_and_message_for_ASI_and_Charge(String ElementText1, String ElementText2) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.ShippingBillPopup, 15);
	    verify = wm.isElementPresent(driver, mawbList.ShippingBillPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.ShippingBillPopupMsg, ElementText1);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.ShippingBillPopupMsg2, ElementText2);
	    cm.Verify(verify, true);
	}

	@Then("^MAWB Deletion popup opened with \"([^\"]*)\" message for ASI and Charge$")
	public void mawb_Deletion_popup_opened_with_message_for_ASI_and_Charge(String ElementText1) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.MAWB_DeletionPopup, 15);
	    verify = wm.isElementPresent(driver, mawbList.MAWB_DeletionPopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.MAWB_DeletionPopupMsg, ElementText1);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of MAWB Deletion popup for ASI and Charge$")
	public void click_on_button_of_MAWB_Deletion_popup_for_ASI_and_Charge(String buttonName) throws Throwable {
	    mawbList.ClickOnMAWB_DeletionPopupButton(buttonName);
	}

	@Then("^MAWB Deletion Message opened with \"([^\"]*)\" message for ASI and Charge$")
	public void mawb_Deletion_Message_opened_with_message_for_ASI_and_Charge(String ElementText1) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.MAWB_DeletionMessagePopup, 15);
	    verify = wm.isElementPresent(driver, mawbList.MAWB_DeletionMessagePopup);
	    cm.Verify(verify, true);
	    verify = wm.isElementTextContain(driver, mawbList.MAWB_DeletionMessagePopupMsg, ElementText1);
	    cm.Verify(verify, true);
	}

	@When("^Click on \"([^\"]*)\" button of MAWB Deletion Message popup for ASI and Charge$")
	public void click_on_button_of_MAWB_Deletion_Message_popup_for_ASI_and_Charge(String buttonName) throws Throwable {
	    mawbList.ClickOnMAWB_DeletionMessagePopupButton(buttonName);
	}

	@Then("^MAWB get successfully deleted for ASI and Charge$")
	public void mawb_get_successfully_deleted_for_ASI_and_Charge() throws Throwable {
	   Thread.sleep(2000);
	   //pending
	}

	@Then("^Flight no link displayed in the mawb grid against the flitered mawb for ASI and Charge$")
	public void flight_no_link_displayed_in_the_mawb_grid_against_the_flitered_mawb_for_ASI_and_Charge() throws Throwable {
		Thread.sleep(2000);
		verify = wm.isElementTextContain(driver, mawbList.CO_IconList.get(0), flightNo);
	    cm.Verify(verify, true);
	}
	
	
	@Then("^validate TSP Payment is opened for ASI and Charge$")
	public void validate_TSP_Payment_is_opened_for_ASI_and_Charge() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, mawbList.TSPpaymentPopuptitle, 15);
	    verify = wm.isElementPresent(driver, mawbList.TSPpaymentPopuptitle);
	    cm.Verify(verify, true);
	}

	@Then("^enter cargotype commodityName HSNcode transaction_passward and paynow for ASI and Charge$")
	public void enter_cargotype_commodityName_HSNcode_transaction_passward_and_paynow_for_ASI_and_Charge() throws Throwable {
//	    mawbList.CargoType
		Thread.sleep(3000);wm.selectDropDownElementByVisibleText(driver, mawbList.CargoType, "Courier");
		Thread.sleep(3000);wm.selectDropDownElementByVisibleText(driver, mawbList.ComodityName, "COURIER BAG-CBV : UCB");
	   String hsncode = cm.RandomNo(10); 
	   Thread.sleep(3000);
	    mawbList.HSNCode.sendKeys(hsncode);
	    Thread.sleep(1000); System.out.println("TransactionPassword:"+TransactionPassword);
	    mawbList.TransactionPassword.sendKeys(TransactionPassword);
	    mawbList.paynow.click();
	}
	

	@When("^validate payment confirmation Message popup opens and clickon Yes for ASI and Charge$")
	public void validate_payment_confirmation_Message_popup_opens_and_clickon_Yes_for_ASI_and_Charge() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.TSPpaymentConfirmMessage, 15);
	    verify = wm.isElementPresent(driver, mawbList.TSPpaymentConfirmMessage);
	    cm.Verify(verify, true);
	    mawbList.yes.click();
	}
	

	@When("^validate GenerateTokenFromTSP_Mesage popup opens and clickon No for ASI and Charge$")
	public void validate_GenerateTokenFromTSP_Mesage_popup_opens_and_clickon_No_for_ASI_and_Charge() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbList.GenerateTokenFromTSP_Mesage, 15);
	    verify = wm.isElementPresent(driver, mawbList.GenerateTokenFromTSP_Mesage);
	    cm.Verify(verify, true);
	    mawbList.NobtnGenerateTokenFromTSPConfirm.click();
	}
	
	
}
