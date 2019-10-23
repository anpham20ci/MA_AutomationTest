package page_model_base;

import helper_base.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * This class wraps WebElement of Selenium to used in PageModelBase
 */
public class ElementBase implements SearchContext {
    /**
     * Original Selenium WebElement
     */
    public WebElement element;
    public SiteBrowser SiteBrowser = BrowserManager.getInstance();

    public ElementBase(WebElement element){
        this.element = element;
    }

    /**
     *Find element
     * @param selector Xpath, css or string to find element
     * @return The first matching element, or null if nothing matches
     */
    public WebElement find(Object selector){
        return SiteBrowser.find(selector);
    }

    /**
     *Find elements
     * @param selector Xpath, css or string to find elements
     * @return List of found elements, or an empty list if nothing matches
     */
    public List<WebElement> findMany(Object selector){
        return SiteBrowser.findMany(selector);
    }

    /**
     * Find children elements
     * @param by The locating mechanism to use
     * @return List of found elements, or an empty list if nothing matches
     * Return null if self-element is null
     */
    @Override
    public List<WebElement> findElements(By by){
        if(element != null){
            return Helper.findMany(element, by);
        }
        return null;
    }

    /**
     * Find children element
     * @param by The locating mechanism to use
     * @return The first matching element, or null if nothing matches
     * Return null if self-element is null
     */
    @Override
    public WebElement findElement(By by) {
        if(element != null){
            return Helper.find(element, by);
        }
        return null;
    }
}
