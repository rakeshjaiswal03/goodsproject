
package StepDefinitions;

import Methods.Setup;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import screenshotMethod.ScreenShotMethod;

public class Hooks {
	
	 public ScreenShotMethod ss;
	 String screenshotName = null, screenshotFilePath = null;
	    
	@Before
	public void beforeScenario() throws Throwable {
		
		
		
		System.out.println(" <----------------------- Run before the Scenario ------------------------->");
	}

	@After
	public void afterScenario(Scenario scenario) throws Throwable {
		
	
		Thread.sleep(5000);
        ss = new ScreenShotMethod();
        ss.ReportScreenshot(Setup.driver, scenario);
        Setup.driver.quit();
		
		System.out.println(" <----------------------- Run After the Scenario ------------------------->");
	}
	


}

