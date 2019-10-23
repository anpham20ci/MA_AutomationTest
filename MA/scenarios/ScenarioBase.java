package scenarios;

import models.Backend;

import static helpers.MAHelper.BackendPassword;
import static helpers.MAHelper.BackendUser;

/**
 * Share common things between scenarios
 */
public class ScenarioBase extends scenario_base.ScenarioBase {
    /**
     * Backend page
     * @return
     */
    public static Backend getBackend() {
        return new Backend();
    }

    /**
     * Login into backend with email and password
     * @param email Email
     * @param password Password
     */
    public void loginBackend(String email, String password) {
        getBackend().getLoginView().login(email, password);
    }

    /**
     * Login into backend with default email and password
     */
    public void loginBackend() {
        getBackend().openPage();
        loginBackend(BackendUser, BackendPassword);
    }

    /**
     * Logout from Backend
     */
    public void logoutBackend(){
        getBackend().logout();
    }
}
