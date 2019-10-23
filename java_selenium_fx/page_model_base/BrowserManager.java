package page_model_base;

/**
 * This class manages the browser that script uses.
 * When running a scripts, there is only one static browser.
 * This browser is initialized automatically at the first time it is called.
 * So, QAs do not need to initialize a browser and do not need to parse the browser between methods/pages/classes
 */
public class BrowserManager {
    static SiteBrowser _siteBrowser;
    static final Object lock = new Object();

    /**
     * Get current SiteBrowser
     * At the first time call this method, SiteBrowser is initialized
     * @return Current SiteBrowser
     */
    public static SiteBrowser getInstance (){
        if (_siteBrowser == null) {
            synchronized (lock) {
                _siteBrowser = new SiteBrowser();
            }
        }
        return _siteBrowser;
    }

    /**
     * Set current SiteBrowser
     * @param siteBrowser SiteBrowser to set
     */
    public static void setInstance(SiteBrowser siteBrowser)
    {
        _siteBrowser = siteBrowser;
    }
}
