package models.views.backend.users;

import helpers.MAHelper;
import models.views.backend.BackendPageModelBase;
import org.openqa.selenium.WebElement;

/**
 * Users --> Create new admin
 * Create new admin view
 */
public class CreateNewAdminView extends BackendPageModelBase {
    public static String link = MAHelper.BackendPath + "administrator/create";

    //<editor-fold desc="Elements">
    public WebElement getEmail(){
        return find("#admin_email");
    }

    public WebElement getName(){
        return find("#admin_name");
    }

    public WebElement getSaleTeamMemberChekbox(){
        return find("#is_seller");
    }

    public WebElement getPassword(){
        return find("#admin_password");
    }

    public WebElement getPasswordConfirmation(){
        return find("#admin_password_confirmation");
    }
    //</editor-fold>

    //<editor-fold desc="Public methods">
    /**
     * Open page
     */
    public void openPage() {
        open(link);
    }
    //</editor-fold>
}
