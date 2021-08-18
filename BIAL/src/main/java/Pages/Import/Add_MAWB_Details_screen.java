package Pages.Import;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.CommonMethods;
import Methods.WebdriverMethods;


public class Add_MAWB_Details_screen {
	public WebDriver driver;
	public WebdriverMethods wm;
	public CommonMethods cm; 
	
	int count = 0;
	boolean verify = false;
	String elementText = null;
	
	public Add_MAWB_Details_screen(WebDriver driver, WebdriverMethods wm, CommonMethods cm) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wm = wm;
		this.cm = cm;
	}
	
	@FindAll ({ 
		@FindBy (xpath = "//a[@id='ctl00_btnimp']"), 
		@FindBy (xpath = "//div[@id='ctl00_hd']//a[@id='ctl00_btnimp']") 
		}) public WebElement BtnImpMode;
	
	@FindBy(how= How.XPATH,using= "//input[@id='ctl00_hldPage_BtnLoadFromFile1']") 
	public WebElement BtnAddMAWBHAWB;
	
	@FindBy(how= How.XPATH,using= "//*[@id=\"ctl00_hldPage_txtAirlinePrefix\"]") 
	public WebElement TxtMAWBPrefix;
	
	@FindBy(how= How.XPATH,using= "//*[@id=\"ctl00_hldPage_txtMAWBNumber\"]") 
	public WebElement TxtMAWBNO;
	
	@FindBy(how= How.XPATH,using= "//table[@id='tblMAWBDetails']/tbody/tr[2]/td[4]/img[1]") 
	public WebElement imgMAWBDt;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_txtAirline\"]")
	public WebElement TxtAirLine;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_GenericAutoFillCityDeparture_txtCode\"]")
	public WebElement TxtORGAirPortCode;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_GenericAutoFillCityDeparture_txtName\"]")
	public WebElement TxtORGAirPortName;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_GenericAutoFillArrival_txtCode\"]")
	public WebElement TxtDSTNAirPortCode;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_GenericAutoFillArrival_txtName\"]")
	public WebElement TxtDSTNAirPortName;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_txtCarriarCode\"]")
	public WebElement TxtCarrierCode;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_txtFlightNo\"]")
	public WebElement TxtFlightNo;
	
	@FindBy(how= How.XPATH, using="//table[@id='tblMAWBDetails']/tbody/tr[4]/td[4]/img[1]")
	public WebElement imgFlightDate;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_txtIGMNo\"]")
	public WebElement TxtIGMNo;
	
	@FindBy(how= How.XPATH, using="//table[@id='tblMAWBDetails']/tbody/tr[5]/td[4]/img[1]")
	public WebElement imgIGMDate;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_txtNumberOfPackages\"]")
	public WebElement Txt_No_Pkgs;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_txtGrossWeight\"]")
	public WebElement Txt_Gr_Wt;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_txtChargeableWeight\"]")
	public WebElement Txt_Chargable_Wt;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_drpWeight\"]")
	public WebElement Drp_Wt;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_txtDescription\"]")
	public WebElement Txt_Descriptionn;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_txtRemarks\"]")
	public WebElement TxtRemark;
	
	//Save/Back button***********
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_btnSaveMAWB\"]")
	public WebElement BtnSave;
	

	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_btnBackMAWB\"]")
	public WebElement Btn_Back;
	
	//HAWB details***********
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_rptHAWB_ctl02_txtHAWBNumber\"]")
	public WebElement TxtHAWBNo;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_rptHAWB_ctl02_txtHAWBDate\"]")
	public WebElement Txt_HAWB_Date;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_rptHAWB_ctl02_txtOrigin\"]")
	public WebElement Txt_HAWB_Origin;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_rptHAWB_ctl02_txtHAWBDestination\"]")
	public WebElement Txt_HAWB_Destination;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_rptHAWB_ctl02_txtHAWBNumberOfPackages\"]")
	public WebElement Txt_HAWB_No_Pkg;
	
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_rptHAWB_ctl02_txtHAWBGrossWeight\"]")
	public WebElement Txt_HAWB_Gr_Wt;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_rptHAWB_ctl02_txtHAWBChargeableWeight\"]")
	public WebElement Txt_HAWB_Chargable_Wt;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_rptHAWB_ctl02_txtRcvdHAWBNumberOfPackages\"]")
	public WebElement Txt_RCVD_HAWB_Pkg;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_rptHAWB_ctl02_txtRcvdHAWBGrossWeight\"]")
	public WebElement Txt_RCVD_HAWB_Gr_Wt;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_rptHAWB_ctl02_txtRcvdHAWBChargeableWeight\"]")
	public WebElement Txt_RCVD_HAWB_Chargable_Wt;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_rptHAWB_ctl02_txtHAWBDescription\"]")
	public WebElement Txt_HAWB_Description;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"ctl00_hldPage_rptHAWB_ctl00_btnAddRows\"]")
	public WebElement Btn_Add_Rpw;
	
	@FindBy(how= How.XPATH, using="/html/body/form/div[4]/div[4]/div/div[2]/div[6]/div[1]/div[1]/table/tbody/tr[1]/td/fieldset/div[2]/span/table/tbody/tr[4]/td[14]/a/img")
	public WebElement Img_Del_Row;
	
	// Message popup
	@FindBy(how= How.XPATH, using="//span[@id='ctl00_hldPage_lblMstSuccess']")
	public WebElement MessagePopup_txt;
	@FindBy(how= How.XPATH, using="//input[@type='button']")
	public WebElement MessagePopup_OKbtn;
	

	
	
	
	
	

}
