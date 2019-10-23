package page_model_base;

import com.sun.org.apache.xerces.internal.util.URI;
import helper_base.Helper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static helper_base.Helper.*;

/**
 * This class wraps WebDriver of Selenium
 * All usual methods are wrapped to make it easy to write test scripts
 */
public class SiteBrowser
{
    /**
     * Original Selenium WebDriver
     */
    public WebDriver Browser;
    Dictionary<String, String> config = new Hashtable<String, String>();
    String configFilePath = "";
    public Dictionary<String, String> SiteBrowserConfig;
    public String SiteRootUrl = config.get("SiteRootUrl");
    public String BackendPath = config.get("BackendPath");

    /**
     * Initialize a SiteBrowser
     */
    public SiteBrowser(){
        this("config\\default.profile.json");
    }

    /**
     * Initialize a SiteBrowser
     * @param configFilePath Configuration/Setting filepath
     */
    public SiteBrowser(String configFilePath){
        this.configFilePath = configFilePath;
        Start(loadProfileFromConfigFile(configFilePath));
    }

    /**
     * Initialize a SiteBrowser
     * @param config A dictionary of setting parameters and their values
     */
    public SiteBrowser(Dictionary<String, String> config)
    {
        Start(config);
    }

    /**
     * Initialize a SiteBrowser
     * @param config A dictionary of setting parameters and their values
     */
    public void Start(Dictionary<String, String> config)
    {
        this.config = config;

        switch ((config.get("Browser")))
        {
            case "ChromeDriver":
                Browser = new ChromeDriver();
                break;
            case "InternetExplorerDriver":
                Browser = new InternetExplorerDriver();
                break;
            default:
                Browser = new FirefoxDriver();
                break;
        }
        Browser.manage().window().maximize();
        Browser.manage().timeouts().implicitlyWait(Long.parseLong(config.get("ElementTimeout")), TimeUnit.SECONDS);
        Browser.manage().timeouts().pageLoadTimeout(Long.parseLong(config.get("PageTimeout")), TimeUnit.SECONDS);
        Browser.manage().timeouts().setScriptTimeout(Long.parseLong(config.get("ScriptTimeout")), TimeUnit.SECONDS);
    }

    /**
     *Go to an url
     * @param url url string. It may be relative or absolute path
     *            If url is a relative path, SiteRootUrl in config will be used
     */
    public void open(String url){
        if(url.contains("{SiteRootUrl}")){
            url = url.replace("{SiteRootUrl}", SiteRootUrl);
        }else{
            if(url.contains("{BackendPath}")) {
                url = url.replace("{BackendPath}", BackendPath);
            }
        }
        System.out.println("url:");
        System.out.println(url);
        try {
            if (new URI(url).isAbsoluteURI())
            {
                Browser.navigate().to(url);
            }else{
                URI absoluteURI = new URI(config.get("SiteRootUrl"));
                absoluteURI.appendPath(url);
                Browser.navigate().to(absoluteURI.toString());
            }
        } catch (URI.MalformedURIException e) {
            e.printStackTrace();
        }

    }

    /**
     *Find element
     * @param selector Xpath, css or string to find element
     * @return The first matching element, or null if nothing matches
     */
    public WebElement find(Object selector)
    {
        return Helper.find(Browser, selector);
    }

    /**
     *Find elements
     * @param selector Xpath, css or string to find elements
     * @return List of found elements, or an empty list if nothing matches
     */
    public List<WebElement> findMany(Object selector)
    {
        return Helper.findMany(Browser, selector);
    }

    /**
     *Run javascript on the current browser
     * @param script Script to be execute
     * @param args List of parameters that parse into script
     * @return
     */
    public Object executeScript(String script, Object[] args)
    {
        JavascriptExecutor jsDriver = (JavascriptExecutor)Browser;
        return jsDriver.executeScript(script, args);
    }
}