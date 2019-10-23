package models.views.backend.users;

import models.views.backend.BackendPageModelBase;
import org.openqa.selenium.WebElement;

/**
 * Users -> Create new user ->Notification tab view
 */
public class NotificationTabView extends BackendPageModelBase {
    public WebElement getEmailAddress1(){
        return find("#notification_email1");
    }

    public WebElement getEmailAddress2(){
        return find("#notification_email2");
    }

    public WebElement getEmailAddress3(){
        return find("#notification_email3");
    }
}
