package models.views.backend.users;

import helpers.MAHelper;
import models.views.backend.BackendPageModelBase;
import org.openqa.selenium.WebElement;

/**
 *User --> View admins
 */
public class ViewAdminsView extends BackendPageModelBase {
    public static String link = MAHelper.BackendPath + "administrator";

    public WebElement getEmailContains(){
        return find("//input[@name='email']");
    }

    public WebElement getNewAdminButton(){
        return find("//i[@class='fas fa-user-plus']//parent::a");
    }

    //<editor-fold desc="Table view --> Actions">
    /**
     * Get Edit button at the row
     *
     * @param row Row order. Starts from 1, ignoring header row
     * @return
     */
    public WebElement getEditBtn(int row) {
        return find(String.format("(//i[@class='fas fa-pen'])[%d]", row));
    }

    /**
     * Get Delete button at the row
     *
     * @param row Row order. Starts from 1, ignoring header row
     * @return
     */
    public WebElement getDeleteBtn(int row) {
        return find(String.format("(//i[@class='far fa-trash-alt'])[%d]", row));
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
