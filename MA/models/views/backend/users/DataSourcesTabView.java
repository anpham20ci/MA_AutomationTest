package models.views.backend.users;

import models.views.backend.BackendPageModelBase;
import org.openqa.selenium.WebElement;

/**
 * Users -> Create new user -> Datasources tab view
 */
public class DataSourcesTabView extends BackendPageModelBase {
    /**
     * Get data source check box by name
     * @param name Data source name
     * @return
     */
    public WebElement getDataSourceCheckbox(String name){
        return find(String.format("//label[text()='%s']", name));
    }
}
