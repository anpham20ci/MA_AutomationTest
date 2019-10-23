package helper_base;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 * Common things used for the project
 */
public class Helper
{
    //<editor-fold desc="Common methods">
    /**
     * Get selector from string/By object
     * @param selector string/By selector
     * @return The locating mechanism
     */
    public static By GetSelector(Object selector)
    {
        if(selector instanceof By){
            return (By)selector;
        }

        String selectorString = selector.toString();
        if (!isNullOrEmpty((selectorString)))
        {
            try
            {
                XPathFactory xpathFactory = XPathFactory.newInstance();
                XPath xpath = xpathFactory.newXPath();
                xpath.compile(selectorString);
                return By.xpath(selectorString);
            } catch (XPathExpressionException e) {
                return By.cssSelector(selectorString);
            }
        }
        return null;
    }

    /**
     * Get driver of WebElement
     * @param element Element to get driver
     * @return Driver of element
     */
    public static WebDriver getDriver(WebElement element)
    {
        RemoteWebElement remoteElement = (RemoteWebElement)element;
        return remoteElement.getWrappedDriver();
    }

    /**
     * Set text for element
     * @param element Element to set text
     * @param text Destination text
     * @param useJavaScript Indicates whether JavaScript is used to perform this method or not.
     *                      Set True to use JavaScript; otherwise, false
     */
    public static void setText(WebElement element, String text, boolean useJavaScript)
    {
        if (useJavaScript)
        {
            WebDriver browser = getDriver(element);
            executeScript(browser, "arguments[0].setAttribute('value', '" + text + "')", element);
        }
        else
        {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    /**
     * Set text for element
     * @param element Element to set text
     * @param text Destination text
     */
    public static void setText(WebElement element, String text){
        setText(element, text, false);
    }

    /**
     * Execute JavaScript on the browser
     * @param browser Destination browser
     * @param script The JavaScript code to execute
     * @param args The arguments to the script
     * @return The value returned by the script
     */
    public static Object executeScript(WebDriver browser, String script, Object args)
    {
        JavascriptExecutor jsDriver = (JavascriptExecutor)browser;
        return jsDriver.executeScript(script, args);
    }

    /**
     * Select an element by clicking on it
     * @param element Destination element
     */
    public static void selectElement(WebElement element)
    {
        element.click();
        //todo: wait document ready
    }

    /**
     * Read all text in a file
     * @param path File path
     * @return All read text
     * @throws IOException
     */
    public static String readAllText(String path) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    /**
     * Indicates whether the specified string is null or empty string
     * @param content The string to test
     * @return True if the value parameter is null or an empty string (""); otherwise, false
     */
    public static boolean isNullOrEmpty(String content){
        if(content.isEmpty() || content == null){
            return true;
        }
        return  false;
    }

    /**
     *Read config file go get setting parameters and their value as a dictionary
     * @param profileConfigFilePath Location to the configuration file (is usually "config\default.profile.jso")
     * @return A dictionary of parameters and their values
     */
    public static Dictionary<String, String> loadProfileFromConfigFile(String profileConfigFilePath){
        String folder = System.getProperty("user.dir");
        File configFile = new File(folder, profileConfigFilePath);
        Dictionary<String, String> config = null;

        String configFileContent = null;
        try {
            configFileContent = readAllText(configFile.getPath());
            config = new Gson().fromJson(configFileContent, new TypeToken<Hashtable<String, String>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }
    //</editor-fold>

    //<editor-fold desc="Find">
    /**
     *Find element
     * @param selector Xpath, css or string to find element
     * @return The first matching element, or null if nothing matches
     */
    public static WebElement find(SearchContext element, Object selector)
    {
        By bySelector = GetSelector(selector);
        try{
            return element.findElement(bySelector);
        }catch (NoSuchElementException e){
            return null;
        }
    }

    /**
     *Find elements
     * @param selector Xpath, css or string to find elements
     * @return List of found elements, or an empty list if nothing matches
     */
    public static List<WebElement> findMany(SearchContext element, Object selector)
    {
        By bySelector = GetSelector(selector);
        return element.findElements(bySelector);
    }
    //</editor-fold>
}

