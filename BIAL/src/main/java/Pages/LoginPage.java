package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver driver;
	
	int count = 0;
	boolean verify = false;
	String elementText = null;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='login']")
	 public WebElement LoginScreen;
	
	@FindBy(how = How.XPATH, using = "//*[@id='txtUsrName']")
	 public WebElement Username_TB;
	
	@FindBy(how = How.XPATH, using = "//*[@id='txtPswd']")
	 public WebElement Password_TB;
	
	@FindBy(how = How.XPATH, using = "//*[@id='btnLogin']")
	 public WebElement Login_Btn;
	
	
	
	public void Login(String username, String password)
	{
		Username_TB.sendKeys(username);
		Password_TB.sendKeys(password);
		Login_Btn.click();
	}
	
//	Added by Rakesh Jaiswal
	@FindBy(how = How.XPATH, using = "//span[@id='lblusernmerror']")
	 public WebElement EmptyUsername_errorMsg;
	@FindBy(how = How.XPATH, using = "//span[@id='lblpasserror']")
	 public WebElement EmptyPassword_errorMsg;
}
