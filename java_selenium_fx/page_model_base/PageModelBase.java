package page_model_base;

import org.openqa.selenium.SearchContext;

/**
 *Base class to write Page Object Model
 * All the pages can extends this class
 * For example: A HomePage can extends this class. So in HomePage, QAs can use all functions of ElementBase, SiteBrowser
 */
public class PageModelBase extends ElementBase implements SearchContext {
    /**
     * Page is not a WebElement, so initialize null object
     */
    public PageModelBase() {
        super(null);
    }

    /**
     *Go to an url
     * @param url url string. It may be relative or absolute path
     *            If url is a relative path, SiteRootUrl in config will be used
     */
    public void open(String url){
        SiteBrowser.open(url);
    }
}
