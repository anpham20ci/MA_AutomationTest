package models.views.backend.users;

import helpers.MAHelper;
import models.views.backend.BackendPageModelBase;
import org.openqa.selenium.WebElement;

/**
 *Users --> View users
 */
public class ViewUsersView extends BackendPageModelBase {
    public static String link = MAHelper.BackendPath + "user";

    //<editor-fold desc="Search region">
    public WebElement getEmailContains() {
        return find("//input[@name='email' and @type='text']");
    }

    public WebElement getNameContains() {
        return find("//input[@name='user_name' and @type='text']");
    }

    public WebElement getClientNameContains() {
        return find("//input[@name='client_name' and @type='text']");
    }
    //</editor-fold>

    public WebElement getNewUserBtn() {
        return find("//i[@class='fas fa-user-plus']//parent::a");
    }

    //<editor-fold desc="Table view --> Actions">
    /**
     * Get Active button at the row
     *
     * @param row Row order. Starts from 1, ignoring header row
     * @return
     */
    public WebElement getActiveBtn(int row) {
        return find(String.format("(//span[@class='status-text']//preceding-sibling::span)[%d]", row));
    }

    /**
     * Get Login button at the row
     *
     * @param row Row order. Starts from 1, ignoring header row
     * @return
     */
    public WebElement getLoginBtn(int row) {
        return find(String.format("(//i[@class='fa fa-sign-in-alt'])[%d]", row));
    }

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

    /**
     * Get Reset password button at the row
     *
     * @param row Row order. Starts from 1, ignoring header row
     * @return
     */
    public WebElement getResetPasswordBtn(int row) {
        return find(String.format("(//i[@class='fas fa-undo-alt'])[%d]", row));
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
