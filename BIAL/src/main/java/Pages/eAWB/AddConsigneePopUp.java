package Pages.eAWB;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.CommonMethods;
import Methods.WebdriverMethods;
import junit.framework.Assert;

public class AddConsigneePopUp {
	
	
	public WebDriver driver;
	public WebdriverMethods wm;
	public CommonMethods cm; 
	boolean verify = false;
	
	public AddConsigneePopUp(WebDriver driver, WebdriverMethods wm,CommonMethods cm ) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wm = wm;
		this.cm = cm; 
		
	}
	
	@FindBy(how = How.XPATH, using = "//img[@id='img3']")
	public WebElement consigneePlusSign;
	
	@FindBy(how = How.XPATH, using = "//span[@id='ui-dialog-title-addConsignee']")
	public WebElement popUpHeader;
	
	@FindBy(how = How.ID, using = "IframConsignee")
	public WebElement IframConsignee;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_txtConName']")
	public WebElement consigneeName;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_uclConsAddressInfo_txtAddressLine1']")
	public WebElement address1;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_uclConsAddressInfo_txtPinCode']")
	public WebElement zipcode;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_uclConsAddressInfo_GenericAutoFillCountry_txtName']")
	public WebElement country;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_uclConsAddressInfo_GenericAutoFillCity_txtName']")
	public WebElement city;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnSaveShipConsignee']")
	public WebElement SaveBtn;
	
	@FindBy(how = How.XPATH, using = "//span[@id='ctl00_hldPage_lblError']")
	public WebElement dataSavedSuccessMsg;
	
	@FindBy(how = How.XPATH, using = "//body[@style='background-color: #FFFFFF']/form[@id='aspnetForm']/div[15]/div[11]/button[1] ")
	public WebElement OkBtn;
	
	
	
	
	@FindAll ({ 
		@FindBy (xpath = "//a[@class='ui-dialog-titlebar-close ui-corner-all ui-state-hover']//span[@unselectable='on'][contains(text(),'Close X')]"), 
		@FindBy (xpath = "//body[@style='background-color: #FFFFFF']/form[@id='aspnetForm']/div[13]/div[1]/a[1]/span[1]") 
		}) public WebElement closeBtn;

	
	public String  enterConsigneedetails(WebDriver driver) throws InterruptedException {
		driver.switchTo().frame(IframConsignee); 
		String consigneename = "KLAutoConsignee_"+ cm.randomAlphabetic(4); 
		
		wm.VisibilityOfElementExplicityWait(driver, consigneeName, 20);
		consigneeName.sendKeys(consigneename);
		address1.sendKeys("cityPark");
		zipcode.sendKeys(cm.RandomNo(6));
		country.sendKeys("India", Keys.ARROW_DOWN, Keys.ENTER);
		city.sendKeys("mumbai", Keys.ARROW_DOWN, Keys.ENTER);
		SaveBtn.click();
		wm.scrolldownUsingJSE(driver, "-50");
		wm.VisibilityOfElementExplicityWait(driver, dataSavedSuccessMsg, 4);
		boolean check = dataSavedSuccessMsg.getText().equalsIgnoreCase("Data Saved Successfully."); 
		wm.VisibilityOfElementExplicityWait(driver, consigneeName, 10);
		Assert.assertTrue(check);
////		wm.scrolldownUsingJSE(driver, "200");
//		wm.JavascriptExecutor_ElementScroll(driver, closeBtn);
		driver.switchTo().defaultContent();
		wm.ClickUsingJSExecutor(driver, closeBtn);
		String var = consigneename+"#cityPark#BOM"; 
		
		return var; 
	}
	
	

}
