package scenarios;

import org.testng.annotations.Test;

import static test_resource.TextResource.*;

public class CreateUserTests extends ScenarioBase{
    @Test(description = "MA001_Create a new valid user",
            groups = {"backend", "user", "P1"})
    public void CreateNewUserTest(){
        //Step 1: Login to backend page
        loginBackend();

        //Step 2: Open Create new user
        getBackend().getCreateNewUserView().openPage();

        //Step 3: Input info....
        getBackend().getCreateNewUserView().getUserInfoView().getUserTypeList().selectItem(UserType_SelfServe);
        getBackend().getCreateNewUserView().getUserInfoView().getDataFormatTypeList().selectItem(DataFormatType_UKMailPostcards);

        //Step 4: Press Submit button
        getBackend().getCreateNewUserView().submit();
    }

}
