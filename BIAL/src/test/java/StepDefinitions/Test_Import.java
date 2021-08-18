package StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import Methods.CommonMethods;
import Methods.Setup;
import Methods.WebdriverMethods;
import Pages.BialMenu;
import Pages.LoginPage;
import Pages.RegistrationPage;
import Pages.Import.Add_MAWB_Details_screen;
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




public class Test_Import {
	
	
	public WebDriver driver;
	public Setup launch;
	public WebdriverMethods wm;
	public CommonMethods cm;
	
	public LoginPage login;
	public BialMenu menu;

	public Add_MAWB_Details_screen mawbScreen;
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
	
	@Given("^forImport Launch Browser and Bial application link$")
	public void forImport_launch_Browser_and_Bial_application_link() throws Throwable {
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
		mawbScreen = new Add_MAWB_Details_screen(driver,wm,cm);
		rp = new RegistrationPage(driver, wm, cm);
	}

	@When("^forImport Login in Bial application$")
	public void forImport_login_in_Bial_application_for_e_Booking_screen() throws Throwable {
		login.Login(AgentUsername, AgentPassword);
	}

	@Then("^forImport Verify Navigated to Home screen$")
	public void forImport_verify_Navigated_to_Home_screen() throws Throwable {
	    wm.VisibilityOfElementExplicityWait(driver, menu.MenuBar, 20);
	    verify = wm.isElementPresent(driver, menu.MenuBar);
	    cm.Verify(verify, true);
	}
	

	@When("^forImport Click on \"([^\"]*)\" mode\\.$")
	public void forimport_Click_on_mode(String arg1) throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, mawbScreen.BtnImpMode, 30);
		mawbScreen.BtnImpMode.click();
	}
	
	@Then("^forImport Click on \"([^\"]*)\"  button$")
	public void forimport_Click_on_button(String arg1) throws Throwable {	
		Thread.sleep(5000); wm.scrolldownUsingJSE(driver, "200");
		wm.VisibilityOfElementExplicityWait(driver, mawbScreen.BtnAddMAWBHAWB, 30);
		////////////////////Anita///////
		mawbScreen.BtnAddMAWBHAWB.click();
		
	}
	
	@When("^forImport Enter all the MAWB Details and click on Save button\\.$")
	public void forimport_Enter_all_the_MAWB_Details_and_click_on_Save_button() throws Throwable {
	    mawbScreen.TxtMAWBPrefix.sendKeys("777");
	    mawbScreen.TxtMAWBNO.sendKeys(awbNo); 
	    String date = cm.SpecificDate1("dd MM yyyy",0); System.out.println("date:"+date);Thread.sleep(1000);
		rp.SelectDate(mawbScreen.imgMAWBDt, date);
		//Imp_Home.TxtAirLine.sendKeys("Jet Airways");
		mawbScreen.TxtORGAirPortCode.sendKeys("DUB");
		mawbScreen.TxtMAWBNO.sendKeys(Keys.TAB);
		mawbScreen.TxtFlightNo.sendKeys("324");
		String Flight_Date = cm.SpecificDate1("dd MM yyyy",0); System.out.println("Flight_Date:"+Flight_Date);Thread.sleep(1000);
		rp.SelectDate(mawbScreen.imgFlightDate, Flight_Date);
		mawbScreen.TxtIGMNo.sendKeys("2828211");
		String IGM_Date = cm.SpecificDate1("dd MM yyyy",0); System.out.println("IGM_Date:"+IGM_Date);Thread.sleep(1000);
		rp.SelectDate(mawbScreen.imgIGMDate, IGM_Date);
		mawbScreen.Txt_No_Pkgs.sendKeys("55");
		mawbScreen.Txt_Gr_Wt.sendKeys("2000");
		mawbScreen.TxtRemark.sendKeys("Remark for Direct Shipment is done");

	} 
	
	@When("^forImport Click on \"([^\"]*)\" button of Shipment details saved successfully message dialogue\\.$")
	public void forimport_Click_on_button_of_Shipment_details_saved_successfully_message_dialogue(String arg1) throws Throwable {
		wm.scrolldownUsingJSE(driver, "200");
	    mawbScreen.BtnSave.click();
	}
//	added by Rakesh

	@Given("^forImport Navigate to Create AWB for eAWB screen$")
	public void forimport_Navigate_to_Create_AWB_for_eAWB_screen() throws Throwable {
		 menu.MainMenuHover("e-AWB"); 		Thread.sleep(5000);
        	menu.ClickOnSubMenu("Create AWB");	Thread.sleep(5000);
	}
	
	@Then("^forImport Verify that balance amount message is displayed for eAWB screen$")
	public void forimport_Verify_that_balance_amount_message_is_displayed_for_eAWB_screen() throws Throwable {
		 wm.VisibilityOfElementExplicityWait(driver, createAwb.CurrentBal_MsgBox , 100);
	        verify = wm.isElementPresent(driver, createAwb.CurrentBal_MsgBox);
	        Assert.assertTrue(verify);   Thread.sleep(3000);
	}
	
	@Then("^forImport Click in Ok button of message for eAWB screen$")
	public void forimport_Click_in_Ok_button_of_message_for_eAWB_screen() throws Throwable {
		 createAwb.clickOnBtn("CurrentBal_OK");
	}
	
	@When("^forImport Enter AWB prefix and AWB number for eAWB screen$")
	public void forimport_Enter_AWB_prefix_and_AWB_number_for_eAWB_screen() throws Throwable {
		Thread.sleep(1000); createAwb.enter_eAWBData("Awb Prefix", "777");		Thread.sleep(1000);
//		awbNo = createAwb.EnterAwbNo();    
		  awbNo =  cm.Random_awbNo(); System.out.println("entered AWB no:"+awbNo);
		  createAwb.TxtAwbNo.sendKeys(awbNo); Thread.sleep(500);
	 
	}
	
	@When("^forImport Enter \"([^\"]*)\" and \"([^\"]*)\" for eAWB screen$")
	public void forimport_Enter_and_for_eAWB_screen(String acsshipper, String acsconsigneeatl) throws Throwable {
		  createAwb.enter_eAWBData("Shipper Name", acsshipper);
	        Thread.sleep(2000);
	        createAwb.enter_eAWBData("Consignee Name", acsconsigneeatl);
	}
	
	@When("^forImport Click on Routing Info button and enter Destn \"([^\"]*)\" and Via \"([^\"]*)\" and Flight No \"([^\"]*)\" for eAWB screen Create_Direct_eAWB$")
	public void forimport_Click_on_Routing_Info_button_and_enter_Destn_and_Via_and_Flight_No_for_eAWB_screen_Create_Direct_eAWB(String DestnPort, String Via_1, String FlightNo) throws Throwable {

//      wm.JavascriptExecutor_ElementScroll(driver, createAwb.BtnRoutingInfo);
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
	
	@When("^forImport Click on Save eAWB button for eAWB screen$")
	public void forimport_Click_on_Save_eAWB_button_for_eAWB_screen() throws Throwable {
		wm.scrolldownUsingJSE(driver, "2000");
    	Thread.sleep(1000);
    	wm.ClickUsingJSExecutor(driver, createAwb.BtnSaveAwb);
	}
	
	@Then("^forImport Verify Success message is displayed for eAWB screen$")
	public void forimport_Verify_Success_message_is_displayed_for_eAWB_screen() throws Throwable {
		wm.VisibilityOfElementExplicityWait(driver, createAwb.AWBSaveWindow, 20);
        verify = wm.isElementTextContain(driver, createAwb.AWBSaveMessage, "Air Waybill saved successfully");
        Assert.assertTrue(verify);
        Thread.sleep(3000);
        createAwb.clickOnBtn("AWB Save Ok");
        Thread.sleep(5000);
	}
	

}
