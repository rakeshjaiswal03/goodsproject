package StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Methods.Setup;
import Methods.WebdriverMethods;
import Pages.BialMenu;
import Pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_BialTest {
	public WebDriver driver;
	public Setup launch;
	public WebdriverMethods wm;
	
	LoginPage login;
	BialMenu menu;
	
	public boolean verify = false;
	String ConfigKeysFile = "Config_Keys.properties";
	String geckoDriverPath = null, URL = null, AgentUsername = null, AgentPassword = null, DownloadPath = null;
	
	
	@Given("^Launch Browser and Bial application link$")
	public void launch_Browser_and_Bial_application_link() throws Throwable {
		File file = new File(ConfigKeysFile);
		InputStream fis = new FileInputStream(file);
		Properties pf = new Properties();
		pf.load(fis);
		
		geckoDriverPath = pf.getProperty("GeckodriverPath");
		URL = pf.getProperty("URL");
		AgentUsername = pf.getProperty("agentUsername");
		AgentPassword = pf.getProperty("agentPassword");
		DownloadPath = pf.getProperty("DownloadPath");
		
		launch = new Setup();
		driver = launch.LaunchFirefox(geckoDriverPath, DownloadPath, URL);
		
		wm = new WebdriverMethods(driver);
		
		login = new LoginPage(driver);
		menu = new BialMenu(driver, wm);
		
		
	}

	@When("^Login in Bial application$")
	public void login_in_Bial_application() throws Throwable {
		login.Login(AgentUsername, AgentPassword);
	}

	@Then("^Verify Navigated to Home screen$")
	public void verify_Navigated_to_Home_screen() throws Throwable {
	}

	@Given("^Navigated to Create AWB screen$")
	public void navigated_to_Create_AWB_screen() throws Throwable {
		menu.MainMenuHover("e-AWB");
		menu.ClickOnSubMenu("Create AWB");
	}
	
}
