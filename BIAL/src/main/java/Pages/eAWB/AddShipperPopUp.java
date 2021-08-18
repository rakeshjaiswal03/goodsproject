package Pages.eAWB;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.CommonMethods;
import Methods.WebdriverMethods;
import junit.framework.Assert;

public class AddShipperPopUp {
	
	
	public WebDriver driver;
	public WebdriverMethods wm;
	public CommonMethods cm; 
	boolean verify = false;
	
	public AddShipperPopUp(WebDriver driver, WebdriverMethods wm,CommonMethods cm ) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wm = wm;
		this.cm = cm; 
		
	}
	
	
	@FindBy(how = How.XPATH, using = "//a[@class='right']//span//img[@id='Img2'] ")
	public WebElement shipperPlusSign;
	
	@FindBy(how = How.XPATH, using = " //span[@id='ui-dialog-title-addConsignee']")
	public WebElement popUpHeader;
	
	@FindBy(how = How.ID, using = "IframConsignee")
	public WebElement IframConsignee;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_txtCompanyName']")
	public WebElement shipperName;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_uclOrgAddressInformation_txtAddressLine1']")
	public WebElement address1;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_uclOrgAddressInformation_txtPinCode'] ")
	public WebElement zipcode;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_uclOrgAddressInformation_GenericAutoFillCountry_txtName']")
	public WebElement country;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_uclOrgAddressInformation_GenericAutoFillCity_txtName']")
	public WebElement city;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_hldPage_btnSaveShipConsignee']")
	public WebElement SaveBtn;
	
	@FindBy(how = How.XPATH, using = "//span[@id='ctl00_hldPage_lblError']")
	public WebElement dataSavedSuccessMsg;
	
	@FindBy(how = How.XPATH, using = "//body[@style='background-color: #FFFFFF']/form[@id='aspnetForm']/div[15]/div[11]/button[1]")
	public WebElement OkBtn;
	
	@FindAll ({ 
		@FindBy (xpath = "//a[@class='ui-dialog-titlebar-close ui-corner-all ui-state-hover']//span[@unselectable='on'][contains(text(),'Close X')]"), 
		@FindBy (xpath = "//body[@style='background-color: #FFFFFF']/form[@id='aspnetForm']/div[14]/div[1]/a[1]/span[1]") 
		}) public WebElement closeBtn;

	@FindBy(how = How.XPATH, using = "//form[@id='aspnetForm']/div[13]/div[1]/a[1]/span[1]")
	public WebElement closeBtn1;
	
	public String  enterShipperdetails(WebDriver driver) throws InterruptedException {
		driver.switchTo().frame(IframConsignee); 
		Thread.sleep(2000);
	
		String shippername = "KLAutoShipper_"+ cm.randomAlphabetic(4); 
		
		wm.enterTextInto(driver, shipperName, shippername);
		
		address1.sendKeys("cityPark");
		zipcode.sendKeys(cm.RandomNo(6));
		country.sendKeys("India", Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(1000);
		city.sendKeys("mumbai", Keys.TAB);
		Thread.sleep(1000);
		wm.scrolldownUsingJSE(driver, "100");
//		wm.scrolldown(driver, SaveBtn);
		SaveBtn.click();
		wm.ClickUsingJSExecutor(driver, SaveBtn);
		
		wm.scrolldownUsingJSE(driver, "-50");
		Thread.sleep(5000);
		wm.VisibilityOfElementExplicityWait(driver, dataSavedSuccessMsg, 4);
	
		System.out.println( "********"+ dataSavedSuccessMsg.getText());
		
		boolean check = dataSavedSuccessMsg.getText().equalsIgnoreCase("Data Saved Successfully."); 
		Assert.assertTrue(check);

		driver.switchTo().defaultContent();
		
		
		wm.ClickUsingJSExecutor(driver, closeBtn1);
		
		String var = shippername+"#cityPark#BOM"; 
		
		return var; 
	}
	
	
	
	

}
