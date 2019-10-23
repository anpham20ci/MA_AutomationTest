package models.components.backend.lists;

/**
 * User list. For example: Select item from this list to find alerts by user in Alerts page
 */
public class UserList extends ListBase {
    /**
     * Initialize a list by id of the list
     *
     */
    public UserList() {
        super("#select2-leads_user_select-container");
    }
}
