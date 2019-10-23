package models;

import models.views.backend.BackendPageModelBase;
import models.views.backend.LoginView;
import models.views.backend.users.*;

import static helpers.MAHelper.BackendPath;

/**
 * Backend page
 * All the backend views are called from here
 */
public class Backend extends BackendPageModelBase {

    //<editor-fold desc="Views in backend">
    public static LoginView getLoginView() {
        return new LoginView();
    }

    public static CreateNewUserView getCreateNewUserView() {
        return new CreateNewUserView();
    }

    public static CreateNewAdminView getCreateNewAdminView(){
        return new CreateNewAdminView();
    }

    public static ViewAdminsView getViewAdminsView(){
        return new ViewAdminsView();
    }

    public static ViewUsersView getViewUsersView(){
        return new ViewUsersView();
    }
    //</editor-fold>

    //<editor-fold desc="Public methods">
    /**
     * Open backend page
     */
    public void openPage() {
        open(BackendPath);
    }
    //</editor-fold>
}
