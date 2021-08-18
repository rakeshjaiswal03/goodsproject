package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.CommonMethods;
import Methods.WebdriverMethods;

public class TermAndCondition {
	
	
	
	public WebDriver driver;
	public WebdriverMethods wm;
	
	public CommonMethods cm; 
	
	int count = 0;
	boolean verify = false;
	String elementText = null;
	
	public TermAndCondition(WebDriver driver, WebdriverMethods wm, CommonMethods cm) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wm = wm;
		this.cm = cm;
	}
	
//	Content List 
	@FindBy (how = How.XPATH, using = "//a[contains(text(),'Preface')]")
	public WebElement Preface;
	
	@FindBy (how = How.XPATH, using = "//a[contains(text(),'Introduction')]")
	public WebElement Introduction;
	@FindBy (how = How.XPATH, using = "//a[contains(text(),'Revision of Terms & Conditions')]")
	public WebElement Revision_of_Terms_Conditions;
	@FindBy (how = How.XPATH, using = "//a[contains(text(),'Registration')]")
	public WebElement Registration;
	@FindBy (how = How.XPATH, using = "//a[contains(text(),'Fees & Payments')]")
	public WebElement FeesPayments;
	@FindBy (how = How.XPATH, using = "//a[contains(text(),'Scope of Services')]")
	public WebElement ScopeofServices;
	@FindBy (how = How.XPATH, using = "//a[contains(text(),'Usage of System')]")
	public WebElement UsageofSystem;
	
	
}
