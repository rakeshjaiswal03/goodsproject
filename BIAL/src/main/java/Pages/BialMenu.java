package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.WebdriverMethods;

public class BialMenu {
	public WebDriver driver;
	public WebdriverMethods wm;
	
	int count = 0;
	boolean verify = false;
	String elementText = null;
	
	public BialMenu(WebDriver driver, WebdriverMethods wm) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wm = wm;
	}
	
	@FindAll ({ 
		@FindBy (xpath = "//*[@id='ctl00_liMode']"), 
		@FindBy (xpath = "//*[@id='liMode']") 
		}) public WebElement MenuBar;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_liMode']/nav/ul/li/a")
	 public List <WebElement> MainMenu;
	
	@FindBy(how = How.XPATH, using = "//*[@id='e-AWB']/ul/li/a")
	 public List <WebElement> eAwbSubMenu;
	
	@FindBy(how = How.XPATH, using = "//*[@id='e-Booking']/ul/li/a")
	 public List <WebElement> eBookingSubMenu;
	
	
	public void MainMenuHover(String label) throws Throwable
	{
		if (label.equalsIgnoreCase("Track and Trace"))
			wm.Action_MoveOverElement(driver, MainMenu.get(0));
		if (label.equalsIgnoreCase("e-Booking"))
			wm.Action_MoveOverElement(driver, MainMenu.get(1));
		if (label.equalsIgnoreCase("e-AWB"))
			wm.Action_MoveOverElement(driver, MainMenu.get(2));
		if (label.equalsIgnoreCase("AWB Stock"))
			wm.Action_MoveOverElement(driver, MainMenu.get(3));
		if (label.equalsIgnoreCase("GST Info"))
			wm.Action_MoveOverElement(driver, MainMenu.get(4));
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(500);
	}
	
	public void ClickOnSubMenu(String label) throws Throwable
	{Thread.sleep(2000);
		//e-Awb
		if (label.equalsIgnoreCase("MAWB List"))
			eAwbSubMenu.get(0).click();
		if (label.equalsIgnoreCase("Create AWB"))
			eAwbSubMenu.get(1).click();
		if (label.equalsIgnoreCase("HAWB List"))
			eAwbSubMenu.get(2).click();
		if (label.equalsIgnoreCase("House Manifest"))
			eAwbSubMenu.get(3).click();
		if (label.equalsIgnoreCase("Attach MAWB to HAWB"))
			eAwbSubMenu.get(4).click();
		if (label.equalsIgnoreCase("Hawb Details Upload"))
			eAwbSubMenu.get(5).click();
		if (label.equalsIgnoreCase("Templates"))
			eAwbSubMenu.get(6).click();
		
		//e-booking
		if (label.equalsIgnoreCase("Create"))
			eBookingSubMenu.get(0).click();
		if (label.equalsIgnoreCase("Saved"))
			eBookingSubMenu.get(1).click();
		if (label.equalsIgnoreCase("Sent"))
			eBookingSubMenu.get(2).click();
		if (label.equalsIgnoreCase("Drafts"))
			eBookingSubMenu.get(3).click();
		if (label.equalsIgnoreCase("e-booking Templates"))
			eBookingSubMenu.get(4).click();
		if (label.equalsIgnoreCase("e-Docket"))
			eBookingSubMenu.get(5).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
	}
	
}
