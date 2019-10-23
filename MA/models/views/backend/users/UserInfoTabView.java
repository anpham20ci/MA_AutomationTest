package models.views.backend.users;

import models.components.backend.lists.DataFormatTypeList;
import models.components.backend.lists.MemberTypeList;
import models.components.backend.lists.UserRoleList;
import models.components.backend.lists.UserTypeList;
import models.views.backend.BackendPageModelBase;
import org.openqa.selenium.WebElement;

/**
 * Users -> Create new user -> User info tab view
 */
public class UserInfoTabView extends BackendPageModelBase {
    //<editor-fold desc="Elements">
    public WebElement getFirstName() {
        return find("#profile_first_name");
    }

    public WebElement getLastName() {
        return find("#profile_last_name");
    }

    public WebElement getCompany() {
        return find("#profile_company");
    }

    public WebElement getEmail() {
        return find("#user_email");
    }

    public UserTypeList getUserTypeList() {
        return new UserTypeList();
    }

    public MemberTypeList getMemberTypeList() {
        return new MemberTypeList();
    }

    public DataFormatTypeList getDataFormatTypeList() {
        return new DataFormatTypeList();
    }

    public WebElement getDefaultSalutation() {
        return find("#user_default_salutation");
    }

    public WebElement getTemplateFront() {
        return find("#user_template_front");
    }

    public UserRoleList getUserRole() {
        return new UserRoleList();
    }

    public WebElement getFeedbackConfigure() {
        return find("#profile_feedback_expire");
    }

    public WebElement getPassword() {
        return find("#user_password");
    }

    public WebElement getPasswordConfirmation() {
        return find("#user_password_confirmation");
    }

    public WebElement getActiveCheckbox() {
        return find("//input[@id='profile_active']//following-sibling::label");
    }

    public WebElement getAllowNamesDownloadCheckbox() {
        return find("//input[@id='user_allow_names_download']//following-sibling::label");
    }

    public WebElement getDataDeliverySFTPYes() {
        return find("//input[@id='sftp_delivery_yes']//following-sibling::label");
    }

    public WebElement getDataDeliverySFTPNo() {
        return find("//input[@id='sftp_delivery_no']//following-sibling::label");
    }

    public WebElement getSFTPHost() {
        return find("user_sftp_host");
    }

    public WebElement getSFTPUserName() {
        return find("user_sftp_username");
    }

    public WebElement getSFTPPassword() {
        return find("user_sftp_pwd");
    }

    public WebElement getChooseFileButton() {
        return find("#user_avatar");
    }
    //</editor-fold>
}
