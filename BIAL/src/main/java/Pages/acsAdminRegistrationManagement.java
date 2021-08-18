package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.CommonMethods;
import Methods.WebdriverMethods;

public class acsAdminRegistrationManagement {
	
	

	public WebDriver driver;
	public WebdriverMethods wm;
	public CommonMethods cm; 
	
	int count = 0;
	boolean verify = false;
	String elementText = null;
	
	public acsAdminRegistrationManagement(WebDriver driver, WebdriverMethods wm, CommonMethods cm) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wm = wm;
		this.cm = cm;
	}
	

	
	
	@FindBy (how = How.XPATH, using = "//a[@id='ctl00_siteWide_topmenucontainer_ctl01_HyperLink1']")
	public WebElement RegistrationManagement;
	
	@FindBy (how = How.XPATH, using = "//a[@id='ctl00_siteWide_topmenucontainer_ctl01_Repeater1_ctl01_HyperLink2']")
	public WebElement ReceivedRequest;
	
	@FindBy (how = How.XPATH, using = "//a[@id='ctl00_siteWide_topmenucontainer_ctl01_Repeater1_ctl02_HyperLink2'] ")
	public WebElement RejectedRequest;	
	
	@FindBy (how = How.XPATH, using = "//a[@id='ctl00_siteWide_topmenucontainer_ctl01_Repeater1_ctl03_HyperLink2']")
	public WebElement ApprovedRequest;	
	
	@FindBy (how = How.XPATH, using = "//a[@id='ctl00_siteWide_topmenucontainer_ctl01_Repeater1_ctl05_HyperLink2']")
	public WebElement RegisteredOrganization;
	
	@FindBy (how = How.XPATH, using = "//a[@id='ctl00_siteWide_topmenucontainer_ctl01_Repeater1_ctl06_HyperLink2'] ")
	public WebElement RegisteredOrganizationBranches;	
	
	@FindBy (how = How.XPATH, using = "//a[@id='ctl00_siteWide_topmenucontainer_ctl01_Repeater1_ctl07_HyperLink2'] ")
	public WebElement RegisteredUsers;
	
	
//	colFilter
	@FindBy (how = How.XPATH, using = "//tr[@class='gridHeader-yellow']//table/tbody/tr[1]/td[1]/input[1] ")
	public List <WebElement> ColFilterIconList;
	@FindBy (how = How.XPATH, using = "//table[@id='ctl00_hldPage_grdReceivedRequest']/tbody/tr/th/a ")
	public List <WebElement> ColHeaderNameList;
	@FindBy (how = How.XPATH, using = " //a[@id='filterMenustartswith']")
	public WebElement startsWithFliter_TB;
	@FindBy (how = How.XPATH, using = " //input[@id='ctl00_hldPage_grdReceivedRequest_ctl01_txtFilter0']")
	public WebElement searchbar;
	

	
//	first row
	@FindBy (how = How.XPATH, using = "//table[@id='ctl00_hldPage_grdReceivedRequest']//tbody/tr[2]/td/a")
	public WebElement firsrowcell;
	
	
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnApprove']")
	public WebElement approveBtn;
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnRejected']")
	public WebElement rejectBtn;
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnReqAddInfo']")
	public WebElement RequestforAdditionalInformationFunctionality;
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnBack']")
	public WebElement backBtn;

	
	@FindBy (how = How.XPATH, using = "//textarea[@id='ctl00_hldPage_txtReason']")
	public WebElement reasonTextBx;
	
	
	@FindBy (how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnDivReject']")
	public WebElement saveBtn;
	
	

}
