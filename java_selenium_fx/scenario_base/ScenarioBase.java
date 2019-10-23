package scenario_base;

import page_model_base.BrowserManager;
import org.testng.annotations.AfterMethod;

/**
 * Share common things between scenarios
 */
public class ScenarioBase{
    public page_model_base.SiteBrowser SiteBrowser = BrowserManager.getInstance();

    @AfterMethod
    public void cleanUp(){
        SiteBrowser.Browser.manage().deleteAllCookies();
        SiteBrowser.Browser.quit();
        SiteBrowser = null;
    }
}