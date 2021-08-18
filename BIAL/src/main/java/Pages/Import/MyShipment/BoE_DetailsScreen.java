package Pages.Import.MyShipment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindAll;
import Methods.CommonMethods;
import Methods.WebdriverMethods;

public class BoE_DetailsScreen {
	public WebDriver driver;
	public WebdriverMethods wm;
	public CommonMethods cm; 
	
	public BoE_DetailsScreen(WebDriver driver, WebdriverMethods wm, CommonMethods cm) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wm = wm;
		this.cm = cm;
	}
	
	@FindBy(how= How.XPATH,using= "//h5[@id='ModalHeader']") 
	public WebElement BoE_header;
	@FindBy(how= How.XPATH,using= "//input[@id='txtSBNumber']") 
	public WebElement BoE_TB;
	
	@FindAll ({ 
		@FindBy (xpath = "//*[@class='ui-datepicker-trigger']"), 
		@FindBy (xpath = "//table[@id='tblAWB']/tbody/tr/td[2]/img") 
		}) public WebElement BoE_dateImg;

	@FindBy(how= How.XPATH,using= "//select[@id='drpSBType']") 
	public WebElement BoE_Type_DD;
	@FindBy(how= How.XPATH,using= "//input[@id='txtCAV']") 
	public WebElement txtCAV;
	@FindBy(how= How.XPATH,using= "//input[@id='txtNOP']") 
	public WebElement txtNOP;
	@FindBy(how= How.XPATH,using= "//img[@title='Upload BoE']") 
	public WebElement Upload_BoE;
	@FindBy(how= How.XPATH,using= "//input[@id='ctl00_hldPage_fuctlUploadDocs']") 
	public WebElement Upload_BoE_BrowserBtn;
	@FindBy(how= How.XPATH,using= "//input[@id='ctl00_hldPage_btnUploadSave']") 
	public WebElement Upload_Btn;
	@FindBy(how= How.XPATH,using= "//div[@id='documentGrid']") 
	public WebElement DcoumentGrid;
	@FindBy(how= How.XPATH,using= "//body/form[@id='aspnetForm']/div[10]/div[11]/button[1]") 
	public WebElement close_Btn;
	@FindBy(how= How.XPATH,using= "//button[@id='btnSaveAWB']") 
	public WebElement btnSaveAWB;
	
	/////// Message popup
	@FindBy(how= How.XPATH, using="//span[@id='ctl00_hldPage_lblMstSuccess']")
	public WebElement MessagePopup_txt;
	@FindBy(how= How.XPATH, using="//div[@class='modal-footer']//input[@type='button']")
	public WebElement MessagePopup_OKbtn;
	
	
}
