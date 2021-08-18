package Methods;

import java.util.HashMap;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Setup {
	public static WebDriver driver;
	
	public WebDriver LaunchChrome(String chromeDriverPath, String URL)
	{
		  System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get(URL);
		  
		  return driver;
	}
	
	public WebDriver LaunchChrome(String chromeDriverPath, String downloadFilePath, String URL)
	{
		  System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		  ChromeOptions options=new ChromeOptions();
		  HashMap<String, Object> chromePref = new HashMap<String, Object>();
		  chromePref.put("profile.default_content_settings.popups", 0);
		  chromePref.put("download.default_directory", downloadFilePath);
		  options.setExperimentalOption("prefs", chromePref);
		  driver=new ChromeDriver(options);
		  driver.manage().window().maximize();
		  driver.get(URL);
		  
		  return driver;
	}
//	
	public WebDriver LaunchFirefox(String firefoxDriverPath, String URL)
	{
		  System.setProperty("webdriver.gecko.driver",firefoxDriverPath);
		  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	      capabilities.setCapability("marionette", true);
	      driver = new FirefoxDriver(capabilities);
//	      driver=new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.get(URL);
		  
		  return driver;
	}
	
	public WebDriver LaunchFirefox(String firefoxDriverPath, String downloadPath, String URL) throws Throwable
	{
		  System.setProperty("webdriver.gecko.driver",firefoxDriverPath);
//		  DesiredCapabilities capabilities = DesiredCapab
		  
		  FirefoxProfile profile = new FirefoxProfile();
//		  profile.setPreference("browser.download.dir", downloadPath);
//		  profile.setPreference("browser.download.folderList", 2);
//		  profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
//			    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"); 
//		  profile.setPreference( "browser.download.manager.showWhenStarting", false );
//		  profile.setPreference( "pdfjs.disabled", true );
//
//		  
		  profile.setPreference("browser.download.folderList", 2); 
		  profile.setPreference("browser.download.dir", downloadPath); // folder 
		  profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		  profile.setPreference("browser.download.manager.showWhenStarting", false);
		  profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/csv, text/csv, text/plain,application/octet-stream doc xls pdf txt"); // MIME type 
//		  profile.setPreference("pdfjs.disabled", true); 
		  profile.setPreference("browser.download.useDownloadDir", true);
		  profile.setPreference("browser.download.manager.closeWhenDone", true);

	      FirefoxOptions options = new FirefoxOptions();
	      options.setProfile(profile);
//	      options.addPreference("browser.download.folderList", 2);
//	      options.addPreference("browser.download.dir", downloadPath);
//	      options.addPreference("browser.download.useDownloadDir", true);
//	      options.addPreference("browser.download.viewableInternally.enabledTypes", "");
//	      options.addPreferencilities.firefox();
//	      capabilities.setCapability("marionette", true);e("browser.helperApps.neverAsk.saveToDisk", "application/pdf;text/plain;application/text;text/xml;application/xml");
//	      options.addPreference("pdfjs.disabled", true);
	      driver = new FirefoxDriver(options);
//	      driver=new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.get(URL);
		  
		  return driver;
	}
	
	public FirefoxProfile FirefoxDriverProfile(String downloadPath) throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.dir", downloadPath);
		profile.setPreference("browser.helperApps.neverAsk.openFile",
				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.closeWhenDone", false);
		return profile;
	}
	
	
}
