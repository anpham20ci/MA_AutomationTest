package models.views.backend.users;

import helpers.MAHelper;
import models.views.backend.BackendPageModelBase;
import org.openqa.selenium.WebElement;

import static helper_base.Helper.selectElement;

/**
 * Users -> Create new user
 * Create new user view
 */
public class CreateNewUserView extends BackendPageModelBase {
    public static String link = MAHelper.BackendPath + "user/create";
    public static UserInfoTabView getUserInfoView(){
        return new UserInfoTabView();
    }

    public static PaymentDetailsTabView getPaymentDetailsView(){
        return new PaymentDetailsTabView();
    }

    public static DataSourcesTabView getDatSourceView(){
        return new DataSourcesTabView();
    }

    public static NotificationTabView getNotificationView(){
        return new NotificationTabView();
    }

    //<editor-fold desc="Elements">
    public WebElement getUserInfoTab(){
        return find("#user-info-tab");
    }

    public WebElement getPaymentDetailsTab(){
        return find("#client-profile-tab");
    }

    public WebElement getDataSourcesTab(){
        return find("#user-datasources-tab");
    }

    public WebElement getNotificationTab(){
        return find("#client-notification-preference-tab");
    }
    //</editor-fold>

    //<editor-fold desc="Public methods">
    /**
     * Open page
     */
    public void openPage() {
        open(link);
    }

    /**
     * Open User info tab
     */
    public void openUserInfoTab(){
        selectElement(getUserInfoTab());
    }

    /**
     * Open Payment details tab
     */
    public void openPaymentDetailsTab(){
        selectElement(getPaymentDetailsTab());
    }

    /**
     * Open Data source tab
     */
    public void openDatasourcesTab(){
        selectElement(getDataSourcesTab());
    }

    /**
     * Open Notification tab
     */
    public void openNotificationTab(){
        selectElement(getNotificationTab());
    }
    //</editor-fold>

}
