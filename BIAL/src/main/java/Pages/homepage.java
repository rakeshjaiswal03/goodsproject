package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.WebdriverMethods;

public class homepage {
	
	public WebDriver driver;
	public WebdriverMethods wm;
	
	int count = 0;
	boolean verify = false;
	String elementText = null;
	
	public homepage(WebDriver driver, WebdriverMethods wm) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wm = wm;
	}
	

	@FindBy (how = How.XPATH, using = "//*[@id='login']")
	public WebElement loginDiv;

	@FindBy (how = How.XPATH, using = "	//*[@id='spnRegText']")
	public WebElement NewRegistrationtext;
	
	@FindBy (how = How.XPATH, using = "	//*[@id=\"hprISTEmailRegistration\"]")
	public WebElement NewRegistrationhyperLink;
	
	@FindBy (how = How.XPATH, using = "	//*[@id='ctl00_hldPageHeader_UpdatePanel2']/div[1]/div[1]/p")
	public WebElement RegistrationFormHeader;
	
	//logout
	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_hd']/div[3]/div[2]/div")
	 public WebElement UserMenu;
	
	@FindBy (how = How.XPATH, using = "//*[@id='ctl00_LinkButton6']")
	 public WebElement LogOutBtn;
	
	public void ClickOnLogoutButton() throws Throwable
	{ 
		UserMenu.click();
	    Thread.sleep(2000);
		LogOutBtn.click();
		
		wm.ImplicitlyWait(driver, 10);
		Thread.sleep(1000);
	}
	

}
