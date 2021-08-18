package Pages.eAWB;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Methods.WebdriverMethods;

public class E_AWB_ListPage {
	
	public WebDriver driver;
	public WebdriverMethods wm;
	public boolean verify = false;
	
	public E_AWB_ListPage(WebDriver driver, WebdriverMethods wm) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wm =wm;
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_hldPage_grdMAWB']/tbody/tr/td[24]/a[1]/img")
	public List <WebElement> EditBtnList;
	

}
