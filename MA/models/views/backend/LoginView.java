package models.views.backend;

import org.openqa.selenium.WebElement;
import page_model_base.PageModelBase;

import static helper_base.Helper.*;

/**
 * Login view
 */
public class LoginView extends PageModelBase {

    //<editor-fold desc="Elements">
    public WebElement getEmail(){
        return find("#email");
    }

    public WebElement getPassword(){
        return find("#password");
    }

    public WebElement getLoginBtn(){
        return find("//button[@type='submit']");
    }
    //</editor-fold>

    //<editor-fold desc="//endregion">
    /**
     * Login
     * @param email Email
     * @param password Password
     */
    public void login(String email, String password){
        setText(getEmail(), email);
        setText(getPassword(), password);
        selectElement(getLoginBtn());
    }
    //</editor-fold>
}
